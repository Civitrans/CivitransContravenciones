/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDatosParametricos;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITDatosParametricos {
    
    /**
    
     *
     * @param agentes El Objeto a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivDatosParametricos agentes) throws Exception;

    /**
     
     *
     * @param agentes El Objeto a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivDatosParametricos agentes) throws Exception;
    
    
    /**
     
     *
     * @param id id del dato parametrico
     * @return La Persona resultante de la consulta. Retorna NULL en caso de no
     * encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivDatosParametricos consultarDatosPID(int id) throws Exception;
   
}
