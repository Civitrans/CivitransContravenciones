/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivPersonas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITPersonas {

    /**
     *
     * @param per
     * @return
     * @throws Exception
     */
    public long insert(CivPersonas per) throws Exception;

    /**
     *
     * @param per
     * @return
     * @throws Exception
     */
    public boolean update(CivPersonas per) throws Exception;

    /**
     * Retorna La Persona de la base de datos por medio del ID único.
     *
     * @param per_id ID único de la Persona a consultar.
     * @return La Persona resultante de la consulta. Retorna NULL en caso de no
     * encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivPersonas consultarPersonasById(int per_id) throws Exception;

    /**
     * Retorna La Persona de la base de datos por medio del documento de
     * identificación.
     *
     * @param tipo Tipo de documento
     * @param Documento Documento de la Persona
     * @return La Persona resultante de la consulta. Retorna NULL en caso de no
     * encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivPersonas consultarPersonasByDocumento(int tipo, String Documento) throws Exception;
    
    /**
     * Retorna el listado de los Datos de Vehículos correspondientes a un
     * vehiculo de la base de datos.
     *
     * @param persona Nombre de usuario. 'ALL' o vacío trae todos los usuarios.
     * @return Lista con los Usuarios resultantes de la consulta. Retorna NULL
     * en caso de no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivPersonas> listarPersonas(String persona) throws Exception;
    
    /**
     * Retorna el listado de los Datos de Vehículos correspondientes a un
     * vehiculo de la base de datos.
     *
     * @param fecha Nombre de usuario. 'ALL' o vacío trae todos los usuarios.
     * @return Lista con los Usuarios resultantes de la consulta. Retorna NULL
     * en caso de no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivPersonas> listarPersonasFecha(String fecha) throws Exception;
    
    /**
     * Retorna La Persona de la base de datos por medio del documento de
     * identificación.
     *
     * @param Documento Documento de la Persona
     * @return La Persona resultante de la consulta. Retorna NULL en caso de no
     * encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivPersonas consultarPersonasDocumento(String Documento) throws Exception;
    
}
