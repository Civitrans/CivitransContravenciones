/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDirecciones;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITDirecciones {

    /**
     * Método para insertar una direccion a la base de datos.
     *
     * @param direccion El Objeto Dirección a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivDirecciones direccion) throws Exception;

    /**
     * Método para actualizar una direccion a la base de datos.
     *
     * @param direccion El Objeto Dirección a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivDirecciones direccion) throws Exception;

    /**
     * Retorna el listado de las Direcciones correspondientes a una Persona de
     * la base de datos.
     *
     * @param persona ID único de la Persona en el sistema.
     * @return Lista con las Direcciones resultantes de la consulta. Retorna
     * NULL en caso de no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivDirecciones> listDireccionesByPersona(long persona) throws Exception;
    
    /**
     * Retorna el listado de la dirección actual de la persona
     *
     * @param persona ID único de la Persona en el sistema.
     * @return Lista con las Direcciones resultantes de la consulta. Retorna
     * NULL en caso de no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivDirecciones consultarDireccionActualByPersona(long persona) throws Exception;
}
