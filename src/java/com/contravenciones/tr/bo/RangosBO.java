/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanRangos;
import com.contravenciones.model.Rangos;



/**
 *
 * @author Roymer Camacho
 */
public interface RangosBO {

    /**
     *
     * @param bean
     * @param ref
     
     * @throws Exception
     */
    void generarRangos(BeanRangos bean, String ref) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void cargarDatos(BeanRangos bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void registrarRangos(BeanRangos bean) throws Exception;
    
     /**
     *
     * @param bean
     * @throws Exception
     */
    void editarRangos(BeanRangos bean) throws Exception;
    
    /**
     *
     * @param id
     * @throws Exception
     */
    String consultarAgente(int id) throws Exception;
    
     /**
     *
     * @param bean
     
     * @throws Exception
     */
    void listRangos(BeanRangos bean) throws Exception;
    
     /**
     *
     * @param bean
     * @param list
     * @throws Exception
     */
    void listDetalleRangos(BeanRangos bean, Rangos list) throws Exception;
    
    /**
     *
     * @param bean
     
     * @throws Exception
     */
    void cancelarEditar(BeanRangos bean) throws Exception;
  
}
