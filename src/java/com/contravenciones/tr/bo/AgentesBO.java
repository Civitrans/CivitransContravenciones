/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanAgentes;



/**
 *
 * @author Roymer Camacho
 */
public interface AgentesBO {

    /**
     *
     * @param bean
     * @param BuscarReferencia
     * @throws Exception
     */
    void listAgentes(BeanAgentes bean, String BuscarReferencia) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void cargarDatos(BeanAgentes bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void consultarPersona(BeanAgentes bean) throws Exception;
    
     /**
     *
     * @param bean
     * @param accion
     * @throws Exception
     */
    void registrarAgente(BeanAgentes bean, String accion) throws Exception;
    
      /**
     *
     * @param bean
     * @param id
     * @throws Exception
     */
    void detalleAgente(BeanAgentes bean, int id) throws Exception;
    
}
