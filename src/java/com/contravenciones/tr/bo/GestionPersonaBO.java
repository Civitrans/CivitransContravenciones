/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanGestionPersona;
import com.contravenciones.tr.persistence.CivPersonas;


/**
 *
 * @author Roymer Camacho
 */
public interface GestionPersonaBO {

    /**
     *
     * @param bean
     * @throws Exception
     */
    void listPersona(BeanGestionPersona bean) throws Exception;
    
     /**
     *
     * @param bean
     * @throws Exception
     */
    void cargarDatos(BeanGestionPersona bean) throws Exception;
    
     /**
     *
     * @param bean
     * @throws Exception
     */
    void guardarPersona(BeanGestionPersona bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void verificarPersona(BeanGestionPersona bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void cancelarEditar(BeanGestionPersona bean) throws Exception;
    
    /**
     *
     * @param per
     * @param bean
     * @throws Exception
     */
    void detallePersona(CivPersonas per, BeanGestionPersona bean) throws Exception;
    
}
