/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.RangosException;
import com.contravenciones.jdbc.dao.ITAgentes;
import com.contravenciones.jdbc.dao.ITDatosParametricos;
import com.contravenciones.jdbc.dao.ITDetalleRangoComparendos;
import com.contravenciones.jdbc.dao.ITOrganismos;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jdbc.dao.ITRangos;
import com.contravenciones.jdbc.dao.ITUsuarios;
import com.contravenciones.jsf.bean.BeanRangos;
import com.contravenciones.model.Agente;
import com.contravenciones.model.Rangos;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivDatosParametricos;
import com.contravenciones.tr.persistence.CivDetalleRangoComparendos;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivRangosComparendos;
import com.contravenciones.tr.persistence.CivUsuarios;
import com.contravenciones.utility.ValidacionDatos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author Roymer Camacho
 */
public class RangosImplBO implements RangosBO {

    private ITAgentes agentesDAO;
    private ITPersonas personasDAO;
    private ITRangos rangosDAO;
    private ITDetalleRangoComparendos detalleRangoComparendosDAO;
    private ITParametros parametrosDAO;
    private ITDatosParametricos datosParametricosDAO;
    private ITUsuarios usuariosDAO;
    private ITOrganismos organismosDAO;

    @Override
    public void cargarDatos(BeanRangos bean) throws Exception {
        String numeros = "";
        CivDatosParametricos dp = getDatosParametricosDAO().consultarDatosPID(1);
        long codigoOrganismo = Integer.parseInt(getOrganismosDAO().consultaCodigoOrganismo(1).getOrgCodigo());
        if (dp != null) {
            for (int i = 0; i < dp.getDtparaLongitud().intValue(); i++) {
                numeros += "0";
            }
            String rangoLong = (numeros.substring(0, dp.getDtparaLongitud().intValue() - (codigoOrganismo + "").length()));
            String rango = codigoOrganismo + rangoLong;
            bean.setMaxLength(rangoLong.length());
            bean.setRangoInicial(rango);
            bean.setRangoFinal(rango);
            bean.setRangoDefecto(rango);
            bean.setLongitud(dp.getDtparaLongitud().intValue());
        }
        bean.setTipoComparendos(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(393)) {
            bean.getTipoComparendos().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        bean.setListEstadoRango(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(394)) {
            bean.getListEstadoRango().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        bean.setListEstadoDetalleRango(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(395)) {
            bean.getListEstadoDetalleRango().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
    }

    @Override
    public void registrarRangos(BeanRangos bean) throws Exception {

        if (bean.getTipoComparendo() == 0 || bean.getReferenciaInicial().equals("") || bean.getReferenciaFinal().equals("") || bean.getNumeroRango().equals("") || bean.getFechaResolucion() == null) {
            throw new RangosException("Campos vacíos", 1);
        }
        for (int i = Integer.parseInt(bean.getReferenciaInicial()); i <= Integer.parseInt(bean.getReferenciaFinal()); i++) {

            String valor = genRangos(bean.getLongitud(), String.valueOf(i), bean.getRangoDefecto());
            CivDetalleRangoComparendos com = getDetalleRangoComparendosDAO().detalleRangobyNumero(valor);

            if (com != null) {
                throw new RangosException("Detalle rango ya se encuentra asociado a un rango", 1);
            }
        }

        CivRangosComparendos ran = new CivRangosComparendos();
        ran.setRanNumInicial(bean.getRangoInicial());
        ran.setRanNumFinal(bean.getRangoFinal());
        ran.setRanFechaInicial(new Date());
        ran.setRanEstado(BigDecimal.ONE);
        ran.setRanNumResolucion(bean.getNumeroRango().toUpperCase());
        ran.setRanFechaResolucion(bean.getFechaResolucion());
        ran.setRanTipoComparendo(BigDecimal.valueOf(bean.getTipoComparendo()));
        long idRango = getRangosDAO().insert(ran);

        for (int i = Integer.parseInt(bean.getReferenciaInicial()); i <= Integer.parseInt(bean.getReferenciaFinal()); i++) {

            String valor = genRangos(bean.getLongitud(), String.valueOf(i), bean.getRangoDefecto());

            CivDetalleRangoComparendos dr = new CivDetalleRangoComparendos();
            CivRangosComparendos r = new CivRangosComparendos();
            r.setRanId(BigDecimal.valueOf(idRango));
            dr.setCivRangosComparendos(r);
            dr.setDtranNumero(valor);
            dr.setDtranEstado(BigDecimal.ONE);
            dr.setDtranFechaInicial(new Date());
            getDetalleRangoComparendosDAO().insert(dr);
        }
    }

    @Override
    public void editarRangos(BeanRangos bean) throws Exception {

        if (bean.getRangoInicial().equals("") || bean.getRangoFinal().equals("") || bean.getFechaInicial() == null || bean.getNumeroRango() == null || bean.getFechaResolucion() == null) {
            throw new RangosException("Campos vacíos", 1);
        }

        CivRangosComparendos ran = new CivRangosComparendos();
        ran.setRanId(BigDecimal.valueOf(Integer.parseInt(bean.getCodigo())));
        ran.setRanNumInicial(bean.getRangoInicial());
        ran.setRanNumFinal(bean.getRangoFinal());
        ran.setRanFechaInicial(bean.getFechaInicial());
        if (bean.getEstado() == 2) {
            ran.setRanFechaFinal(new Date());
            bean.setFechaFinal(ran.getRanFechaFinal());
        } else {
            ran.setRanFechaFinal(null);
            bean.setFechaFinal(ran.getRanFechaFinal());
        }
        ran.setRanEstado(BigDecimal.valueOf(bean.getEstado()));
        ran.setRanNumResolucion(bean.getNumeroRango().toUpperCase());
        ran.setRanFechaResolucion(bean.getFechaResolucion());
        ran.setRanTipoComparendo(BigDecimal.valueOf(bean.getTipoComparendo()));
        getRangosDAO().update(ran);
    }

    @Override
    public void listRangos(BeanRangos bean) throws Exception {
        bean.setListRangos(new ArrayList<>());
        for (CivRangosComparendos ran : getRangosDAO().getRangosAll()) {
            int utilizados = 0, activos = 0, cantidad = 0;
            Rangos r = new Rangos();
            r.setRanId(ran.getRanId().intValue());
            r.setRanNumInicial(ran.getRanNumInicial());
            r.setRanNumFinal(ran.getRanNumFinal());
            r.setRanFechaInicial(ran.getRanFechaInicial());
            r.setRanFechaFinal(ran.getRanFechaFinal());
            r.setRanEstado(ran.getRanEstado().intValue());
            r.setRanNumResolucion(ran.getRanNumResolucion());
            r.setRanFechaResolucion(ran.getRanFechaResolucion());
            r.setRanTipoComparendo(ran.getRanTipoComparendo().intValue());
            for (CivDetalleRangoComparendos dr : getDetalleRangoComparendosDAO().detalleRangobyId(ran.getRanId().intValue())) {
                cantidad++;
                if (dr.getDtranEstado().intValue() == 1) {
                    activos++;
                } else {
                    utilizados++;
                }
            }
            int porcentaje = utilizados * 100 / cantidad;
            if (porcentaje <= 50) {
                r.setBar(porcentaje > 0 ? "progress-bar-success" : "progress-bar-aqua");
                r.setUti(porcentaje > 0 ? "bg-green" : "bg-aqua");
            } else if (porcentaje <= 75) {
                r.setBar("progress-bar-warning");
                r.setUti("bg-yellow");
            } else {
                r.setBar("progress-bar progress-bar-danger");
                r.setUti("bg-red");
            }
            r.setPorcentaje(porcentaje + "%");
            r.setActivos(String.valueOf(activos));
            r.setUtilizados(String.valueOf(utilizados));
            r.setTotal(cantidad + "");
            bean.getListRangos().add(r);
        }

    }

    @Override
    public void listDetalleRangos(BeanRangos bean, Rangos list) throws Exception {
        bean.setMostrarDetalle(true);
        bean.setMostrarBuscar(false);
        bean.setMostrarConsulta(false);
        /*Detalle rango*/
        bean.setCodigo(list.getRanId() + "");
        bean.setRangoInicial(list.getRanNumInicial());
        bean.setRangoFinal(list.getRanNumFinal());
        bean.setFechaInicial(list.getRanFechaInicial());
        bean.setFechaFinal(list.getRanFechaFinal());
        bean.setEstado(list.getRanEstado());
        bean.setNumeroRango(list.getRanNumResolucion());
        bean.setFechaResolucion(list.getRanFechaResolucion());
        bean.setTipoComparendo(list.getRanTipoComparendo());
        bean.setCodigoUsuario(list.getUsuId());
        CivUsuarios usu = getUsuariosDAO().consultarUsuarioBy(list.getUsuId());
        if (usu != null) {
            bean.setUsuarioCreacion(usu.getUsuNombre());
        }

        bean.setListDetalleRango(new ArrayList<>());
        for (CivDetalleRangoComparendos dr : getDetalleRangoComparendosDAO().detalleRangobyId(Integer.parseInt(bean.getCodigo()))) {
            bean.getListDetalleRango().add(dr);
        }
    }

    @Override
    public void generarRangos(BeanRangos bean, String ref) throws Exception {

        if (!new ValidacionDatos().validarSolonumeros(bean.getReferenciaInicial()) || !new ValidacionDatos().validarSolonumeros(bean.getReferenciaFinal())) {
            throw new RangosException("Datos incorrectos", 1);
        }

        int longi = bean.getRangoInicial().length();

        String valor, ran;
        if (ref.equals("fechaInicial")) {
            ran = bean.getRangoDefecto();
            valor = bean.getReferenciaInicial();
        } else {
            ran = bean.getRangoDefecto();
            valor = bean.getReferenciaFinal();
        }

        String rango = genRangos(longi, valor, ran);
        if (ref.equals("fechaInicial")) {
            bean.setRangoInicial(rango);
        } else {
            if (Long.parseLong(bean.getReferenciaInicial()) >= Long.parseLong(bean.getReferenciaFinal())) {
                bean.setBtnRegistrar(true);
                bean.setRangoFinal(ran);
                throw new RangosException("El rango final debe ser mayor al rango inicial.", 1);
            }
            bean.setBtnRegistrar(false);
            bean.setRangoFinal(rango);
        }

    }

    @Override
    public void cancelarEditar(BeanRangos bean) throws Exception {

        CivRangosComparendos ran = getRangosDAO().rangoId(Integer.parseInt(bean.getCodigo()));
        bean.setCodigo(ran.getRanId() + "");
        bean.setRangoInicial(ran.getRanNumInicial());
        bean.setRangoFinal(ran.getRanNumFinal());
        bean.setFechaInicial(ran.getRanFechaInicial());
        bean.setEstado(ran.getRanEstado().intValue());
        bean.setNumeroRango(ran.getRanNumResolucion());
        bean.setFechaResolucion(ran.getRanFechaResolucion());
        bean.setTipoComparendo(ran.getRanTipoComparendo().intValue());
        bean.setFechaFinal(ran.getRanFechaFinal());

    }

    public String genRangos(int longi, String valor, String ran) {
        String rango = (ran.substring(0, longi - (valor + "").length())) + valor;
        return rango;
    }

    @Override
    public String consultarAgente(int id) throws Exception {
        CivAgentes ag = getAgentesDAO().listarAgentesId(id);
        if (ag != null) {
            CivPersonas per = getPersonasDAO().consultarPersonasById(ag.getCivPersonas().getPerId().intValue());
            if (per != null) {
                return per.getPerNombre1() + " " + per.getPerApellido1();
            }
        }
        return "";
    }

    /**
     * @return the agentesDAO
     */
    public ITAgentes getAgentesDAO() {
        return agentesDAO;
    }

    /**
     * @param agentesDAO the agentesDAO to set
     */
    public void setAgentesDAO(ITAgentes agentesDAO) {
        this.agentesDAO = agentesDAO;
    }

    /**
     * @return the personasDAO
     */
    public ITPersonas getPersonasDAO() {
        return personasDAO;
    }

    /**
     * @param personasDAO the personasDAO to set
     */
    public void setPersonasDAO(ITPersonas personasDAO) {
        this.personasDAO = personasDAO;
    }

    /**
     * @return the rangosDAO
     */
    public ITRangos getRangosDAO() {
        return rangosDAO;
    }

    /**
     * @param rangosDAO the rangosDAO to set
     */
    public void setRangosDAO(ITRangos rangosDAO) {
        this.rangosDAO = rangosDAO;
    }

    /**
     * @return the detalleRangoComparendosDAO
     */
    public ITDetalleRangoComparendos getDetalleRangoComparendosDAO() {
        return detalleRangoComparendosDAO;
    }

    /**
     * @param detalleRangoComparendosDAO the detalleRangoComparendosDAO to set
     */
    public void setDetalleRangoComparendosDAO(ITDetalleRangoComparendos detalleRangoComparendosDAO) {
        this.detalleRangoComparendosDAO = detalleRangoComparendosDAO;
    }

    /**
     * @return the parametrosDAO
     */
    public ITParametros getParametrosDAO() {
        return parametrosDAO;
    }

    /**
     * @param parametrosDAO the parametrosDAO to set
     */
    public void setParametrosDAO(ITParametros parametrosDAO) {
        this.parametrosDAO = parametrosDAO;
    }

    /**
     * @return the datosParametricosDAO
     */
    public ITDatosParametricos getDatosParametricosDAO() {
        return datosParametricosDAO;
    }

    /**
     * @param datosParametricosDAO the datosParametricosDAO to set
     */
    public void setDatosParametricosDAO(ITDatosParametricos datosParametricosDAO) {
        this.datosParametricosDAO = datosParametricosDAO;
    }

    /**
     * @return the usuariosDAO
     */
    public ITUsuarios getUsuariosDAO() {
        return usuariosDAO;
    }

    /**
     * @param usuariosDAO the usuariosDAO to set
     */
    public void setUsuariosDAO(ITUsuarios usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    /**
     * @return the organismosDAO
     */
    public ITOrganismos getOrganismosDAO() {
        return organismosDAO;
    }

    /**
     * @param organismosDAO the organismosDAO to set
     */
    public void setOrganismosDAO(ITOrganismos organismosDAO) {
        this.organismosDAO = organismosDAO;
    }

}
