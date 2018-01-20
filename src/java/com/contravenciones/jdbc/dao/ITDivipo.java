/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDivipos;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITDivipo {

    /**
     * Retorna el listado de todos los Divipos de la base de datos.
     *
     * @return Lista con los Divipos resultantes de la consulta. Retorna NULL en
     * caso de no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivDivipos> listAllDivipos() throws Exception;

    /**
     * Retorna el Divipo de la base de datos por medio del ID único.
     *
     * @param id_divipo ID único del Divipo a consultar.
     * @return El Divipo resultante de la consulta. Retorna NULL en caso de no
     * encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public CivDivipos getDivipo(long id_divipo) throws Exception;

    /**
     * Método para insertar un Divipo en la base de datos.
     *
     * @param divipo El Objeto Divipo a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivDivipos divipo) throws Exception;

    /**
     * Método para actualizar un Divipo en la base de datos.
     *
     * @param divipo El Objeto Divipo a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivDivipos divipo) throws Exception;

    /**
     * Retorna el listado de los Divipos correspondientes a un departamento de
     * la base de datos.
     *
     * @param id_departamento ID único del Departamento en el sistema.
     * @return Lista con los resultantes de la consulta. Retorna NULL en caso de
     * no encontrarse resultados.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivDivipos> listDiviposByDepartamento(long id_departamento) throws Exception;

    /**
     *
     * @param municipio
     * @return Objeto CivDivipo
     * @throws Exception
     */
    public CivDivipos getDivipoByMunicipio(long municipio) throws Exception;

    /**
     *
     * @param departamento
     * @param municipio
     * @return
     * @throws Exception
     */
    public CivDivipos getDivipoByDepartamentoByMunicipio(long departamento, long municipio) throws Exception;

    /**
     * Funcion para consultar divipo por codigo
     *
     * @param code
     * @return
     * @throws Exception
     */
    public CivDivipos getDivipoByCode(long code) throws Exception;
}
