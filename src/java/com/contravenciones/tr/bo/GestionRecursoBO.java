/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanGestionRecurso;
import com.contravenciones.tr.persistence.CivRecursos;


/**
 *
 * @author Roymer Camacho
 */
public interface GestionRecursoBO {

    /**
     *
     * @param bean
     * @throws Exception
     */
    void cargarDatos(BeanGestionRecurso bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void listRecursos(BeanGestionRecurso bean) throws Exception;
    
    /**
     *
     * @param bean
     * @param rec
     * @throws Exception
     */
    void detalleRecursos(CivRecursos rec, BeanGestionRecurso bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void editarRecursos(BeanGestionRecurso bean) throws Exception;
    
     /**
     *
     * @param bean
     * @throws Exception
     */
    void cancelarEditar(BeanGestionRecurso bean) throws Exception;
    
}
