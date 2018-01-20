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
     * @param BuscarReferencia
     * @throws Exception
     */
    void listAgentes(BeanRangos bean, String BuscarReferencia) throws Exception;
    
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
    void consultarPersona(BeanRangos bean) throws Exception;
    
     /**
     *
     * @param bean
     * @throws Exception
     */
    void registrarAgente(BeanRangos bean) throws Exception;
}
