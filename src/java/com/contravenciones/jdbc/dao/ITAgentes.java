/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivAgentes;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITAgentes {
    
    /**
    
     *
     * @param agentes El Objeto a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivAgentes agentes) throws Exception;

    /**
     
     *
     * @param agentes El Objeto a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivAgentes agentes) throws Exception;
    
    /**
     
     *
     * @param idper
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivAgentes> listarAgentes(int idper) throws Exception;
    
     /**
     
     *
     * @param placa
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivAgentes> listarAgentesPlaca(String placa) throws Exception;
    
      /**
     
     *
     * @param id
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivAgentes listarAgentesId(int id) throws Exception;

   
}
