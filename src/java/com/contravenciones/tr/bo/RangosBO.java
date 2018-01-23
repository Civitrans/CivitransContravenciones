/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanRangos;



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
  
}
