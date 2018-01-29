/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.RangosException;
import com.contravenciones.jdbc.dao.ITAgentes;
import com.contravenciones.jdbc.dao.ITDetalleRangoComparendos;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jdbc.dao.ITRangos;
import com.contravenciones.jsf.bean.BeanAgentes;
import com.contravenciones.model.Agente;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author Roymer Camacho
 */
public class AgentesImplBO implements AgentesBO {

    private ITAgentes agentesDAO;
    private ITPersonas personasDAO;
    private ITRangos rangosDAO;
    private ITDetalleRangoComparendos detalleRangoComparendosDAO;
    private ITParametros parametrosDAO;

    @Override
    public void cargarDatos(BeanAgentes bean) throws Exception {
        //Combo de Tipo de documento que se encuentra en la tabla parametros
        bean.setListTipoDocumento(new HashMap<>());
        bean.setEstadoPersona(new HashMap<>());
        bean.setTipoAgentes(new HashMap<>());
        bean.setEstadoAgentes(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(5)) {
            bean.getListTipoDocumento().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivParametros objParametros : getParametrosDAO().listParametros(391)) {
            bean.getEstadoPersona().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivParametros objParametros : getParametrosDAO().listParametros(397)) {
            bean.getTipoAgentes().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivParametros objParametros : getParametrosDAO().listParametros(398)) {
            bean.getEstadoAgentes().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }

    }

    @Override
    public void listAgentes(BeanAgentes bean, String BuscarReferencia) throws Exception {
        bean.setListDatos(new ArrayList<>());
        
        CivAgentes civ = getAgentesDAO().agentes(1);
        
        if (BuscarReferencia.equals("nombre")) {
            for (CivPersonas per : getPersonasDAO().listarPersonas(bean.getReferencia().toUpperCase())) {
                if (per != null) {
                    for (CivAgentes ag : getAgentesDAO().listarAgentes(per.getPerId().intValue())) {
                        if (ag != null) {
                            Agente dat = new Agente();
                            dat.setAgeId(ag.getAgeId().intValue());
                            dat.setAgeTipo(ag.getAgeTipo().intValue());
                            dat.setAgePlaca(ag.getAgePlaca());
                            dat.setAgeFechaInicio(ag.getAgeFechaInicio());
                            dat.setAgeFechaFin(ag.getAgeFechaFin());
                            dat.setPerId(per.getPerId().intValue());
                            dat.setPerDocumento(per.getPerDocumento());
                            dat.setPerTipodocumento(per.getPerTipodocumento().intValue());
                            dat.setPerFechanac(per.getPerFechanac());
                            dat.setPerGruposanguineo(per.getPerGruposanguineo());
                            dat.setPerRh(per.getPerRh());
                            dat.setPerSexo(per.getPerSexo());
                            dat.setPerNombre1(per.getPerNombre1());
                            dat.setPerNombre2(per.getPerNombre2());
                            dat.setPerApellido1(per.getPerApellido1());
                            dat.setPerApellido2(per.getPerApellido2());
                            dat.setPerEmail(per.getPerEmail());
                            dat.setPerCelular(per.getPerCelular());
                            dat.setPerLugarnacimiento(per.getPerLugarnacimiento().intValue());
                            dat.setPerFechaexp(per.getPerFechaexp());
                            dat.setPerEstado(per.getPerEstado().intValue());
                            dat.setPerFechainicial(per.getPerFechainicial());
                            dat.setPerFechafinal(per.getPerFechafinal());
                            dat.setEstadoAgente(ag.getAgeEstado().intValue());
                            bean.getListDatos().add(dat);
                        }
                    }

                }
            }

        }
        if (BuscarReferencia.equals("placa")) {
            if (bean.getReferencia().equals("")) {
                throw new RangosException("Digite referencia", 1);
            }
            for (CivAgentes ag : getAgentesDAO().listarAgentesPlaca(bean.getReferencia())) {
                if (ag != null) {
                    CivPersonas per = getPersonasDAO().consultarPersonasById(ag.getCivPersonas().getPerId().intValue());
                    if (per != null) {
                        Agente dat = new Agente();
                        dat.setAgeId(ag.getAgeId().intValue());
                        dat.setAgeTipo(ag.getAgeTipo().intValue());
                        dat.setAgePlaca(ag.getAgePlaca());
                        dat.setAgeFechaInicio(ag.getAgeFechaInicio());
                        dat.setAgeFechaFin(ag.getAgeFechaFin());
                        dat.setPerId(per.getPerId().intValue());
                        dat.setPerDocumento(per.getPerDocumento());
                        dat.setPerTipodocumento(per.getPerTipodocumento().intValue());
                        dat.setPerFechanac(per.getPerFechanac());
                        dat.setPerGruposanguineo(per.getPerGruposanguineo());
                        dat.setPerRh(per.getPerRh());
                        dat.setPerSexo(per.getPerSexo());
                        dat.setPerNombre1(per.getPerNombre1());
                        dat.setPerNombre2(per.getPerNombre2());
                        dat.setPerApellido1(per.getPerApellido1());
                        dat.setPerApellido2(per.getPerApellido2());
                        dat.setPerEmail(per.getPerEmail());
                        dat.setPerCelular(per.getPerCelular());
                        dat.setPerLugarnacimiento(per.getPerLugarnacimiento().intValue());
                        dat.setPerFechaexp(per.getPerFechaexp());
                        dat.setPerEstado(per.getPerEstado().intValue());
                        dat.setPerFechainicial(per.getPerFechainicial());
                        dat.setPerFechafinal(per.getPerFechafinal());
                        dat.setEstadoAgente(ag.getAgeEstado().intValue());
                        bean.getListDatos().add(dat);
                    }
                }
            }
        }
        if (BuscarReferencia.equals("identificacion")) {
            if (bean.getReferencia().equals("")) {
                throw new RangosException("Digite referencia", 1);
            }
            CivPersonas per = getPersonasDAO().consultarPersonasDocumento(bean.getReferencia());
            if (per != null) {
                for (CivAgentes ag : getAgentesDAO().listarAgentes(per.getPerId().intValue())) {
                    if (ag != null) {
                        Agente dat = new Agente();
                        dat.setAgeId(ag.getAgeId().intValue());
                        dat.setAgeTipo(ag.getAgeTipo().intValue());
                        dat.setAgePlaca(ag.getAgePlaca());
                        dat.setAgeFechaInicio(ag.getAgeFechaInicio());
                        dat.setAgeFechaFin(ag.getAgeFechaFin());
                        dat.setPerId(per.getPerId().intValue());
                        dat.setPerDocumento(per.getPerDocumento());
                        dat.setPerTipodocumento(per.getPerTipodocumento().intValue());
                        dat.setPerFechanac(per.getPerFechanac());
                        dat.setPerGruposanguineo(per.getPerGruposanguineo());
                        dat.setPerRh(per.getPerRh());
                        dat.setPerSexo(per.getPerSexo());
                        dat.setPerNombre1(per.getPerNombre1());
                        dat.setPerNombre2(per.getPerNombre2());
                        dat.setPerApellido1(per.getPerApellido1());
                        dat.setPerApellido2(per.getPerApellido2());
                        dat.setPerEmail(per.getPerEmail());
                        dat.setPerCelular(per.getPerCelular());
                        dat.setPerLugarnacimiento(per.getPerLugarnacimiento().intValue());
                        dat.setPerFechaexp(per.getPerFechaexp());
                        dat.setPerEstado(per.getPerEstado().intValue());
                        dat.setPerFechainicial(per.getPerFechainicial());
                        dat.setPerFechafinal(per.getPerFechafinal());
                        dat.setEstadoAgente(ag.getAgeEstado().intValue());
                        bean.getListDatos().add(dat);
                    }
                }

            }
        }

        if (bean.getListDatos().isEmpty()) {
            throw new RangosException("No se encontraron coincidencias.", 1);
        }
        bean.setMostrarConsultaAgente(true);
    }

    @Override
    public void consultarPersona(BeanAgentes bean) throws Exception {

        if (bean.getIdentificacion().equals("")) {
            throw new RangosException("Digite número de identificación", 1);
        }
        CivPersonas per = getPersonasDAO().consultarPersonasDocumento(bean.getIdentificacion());
        if (per != null) {
            List<CivAgentes> agente = getAgentesDAO().listarAgentes(per.getPerId().intValue());
            if (!agente.isEmpty()) {
                bean.setBtnRegistrar(true);
                throw new RangosException("La persona consultada ya tiene asignada una placa.", 1);
            }
            bean.setDetalleConsulta(true);
            bean.setCrearPersona(false);
            bean.setBtnRegistrar(false);
            bean.setIdPersona(per.getPerId().intValue());
            bean.setNombrePersona(per.getPerNombre1() + " " + (per.getPerNombre2() != null ? per.getPerNombre2() + " " : "") + per.getPerApellido1() + " " + (per.getPerApellido2() != null ? per.getPerApellido2() : ""));
        } else {
            bean.setCrearPersona(true);
            bean.setDetalleConsulta(false);
            bean.setBtnRegistrar(true);
        }
    }

    @Override
    public void registrarAgente(BeanAgentes bean, String accion) throws Exception {
        if (bean.getPlaca().equals("")) {
            throw new RangosException("Digite Placa", 1);
        }
        CivAgentes agente = new CivAgentes();
        CivPersonas persona = new CivPersonas();
        persona.setPerId(BigDecimal.valueOf(bean.getIdPersona()));
        agente.setCivPersonas(persona);
        agente.setAgeTipo(BigDecimal.valueOf(bean.getTipoAgente()));
        agente.setAgePlaca(bean.getPlaca());
        agente.setAgeFechaInicio(new Date());
        agente.setAgeEstado(BigDecimal.ONE);
        if (accion.equals("insertar")) {
            getAgentesDAO().insert(agente);
        }

        if (accion.equals("actualizar")) {
            agente.setAgeId(BigDecimal.valueOf(bean.getIdAgente()));
            agente.setAgeFechaInicio(bean.getFechaRegistro());
            agente.setAgeEstado(BigDecimal.valueOf(bean.getEstadoAgente()));
            if (bean.getEstadoAgente() == 2) {
                agente.setAgeFechaFin(new Date());
            }
            if (bean.getEstadoAgente() == 1) {
                agente.setAgeFechaFin(null);
            }
            getAgentesDAO().update(agente);
        }

    }

    @Override
    public void detalleAgente(BeanAgentes bean, int id) throws Exception {
        CivAgentes agente = getAgentesDAO().listarAgentesId(id);
        if (agente != null) {
            bean.setIdAgente(agente.getAgeId().intValue());
            bean.setTipoAgente(agente.getAgeTipo().intValue());
            bean.setPlaca(agente.getAgePlaca());
            bean.setFechaRegistro(agente.getAgeFechaInicio());
            bean.setEstadoAgente(agente.getAgeEstado().intValue());
            bean.setIdPersona(agente.getCivPersonas().getPerId().intValue());
        }
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

}
