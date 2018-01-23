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
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jdbc.dao.ITRangos;
import com.contravenciones.jdbc.dao.ITSedes;
import com.contravenciones.jsf.bean.BeanRangos;
import com.contravenciones.model.Agente;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivDatosParametricos;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivSedes;
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
    private ITSedes sedesDAO;

    @Override
    public void cargarDatos(BeanRangos bean) throws Exception {
        String numeros = "";
        CivDatosParametricos dp = getDatosParametricosDAO().consultarDatosPID(1);
        CivSedes s = getSedesDAO().getSedeById(bean.getLoginBean().getSede());
        if (dp != null) {
            for (int i = 0; i < dp.getDtparaLongitud().intValue(); i++) {
                numeros += "0";
            }
            String rangoLong=(numeros.substring(0, dp.getDtparaLongitud().intValue() - (s.getSedCodigo() + "").length()));
            String rango = s.getSedCodigo() + rangoLong;
            bean.setMaxLength(rangoLong.length());
            bean.setRangoInicial(rango);
            bean.setRangoFinal(rango);
        }
    }
    
    @Override
    public void registrarRangos(BeanRangos bean) throws Exception {
      
    }

    @Override
    public void generarRangos(BeanRangos bean, String ref) throws Exception {
        int longi = bean.getRangoInicial().length();

        String valor, ran;
        if (ref.equals("fechaInicial")) {
            ran=bean.getRangoInicial();
            valor=bean.getReferenciaInicial();
        }else{
            ran=bean.getRangoFinal();
            valor=bean.getReferenciaFinal();
        }

        String rango = (ran.substring(0, longi - (valor + "").length())) + valor;
        if (ref.equals("fechaInicial")) {
            bean.setRangoInicial(rango);
        }else{
            if(Long.parseLong(bean.getReferenciaInicial())>=Long.parseLong(bean.getReferenciaFinal())){
                throw new RangosException("El rango final debe ser mayor al rango inicial.", 1);
            }
            bean.setRangoFinal(rango);
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
     * @return the sedesDAO
     */
    public ITSedes getSedesDAO() {
        return sedesDAO;
    }

    /**
     * @param sedesDAO the sedesDAO to set
     */
    public void setSedesDAO(ITSedes sedesDAO) {
        this.sedesDAO = sedesDAO;
    }

}
