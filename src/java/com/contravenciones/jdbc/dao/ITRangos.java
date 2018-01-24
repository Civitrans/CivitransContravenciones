/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivRangosComparendos;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITRangos {

    /**
     *
     *
     * @param rangos El Objeto a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivRangosComparendos rangos) throws Exception;

    /**
     *
     *
     * @param rangos El Objeto a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivRangosComparendos rangos) throws Exception;

    /**
     *
     *
     * @return @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivRangosComparendos> getRangosAll() throws Exception;

    /**
     *
     *
     * @return @throws Exception La Excepción lanzada en caso de error.
     */
    public CivRangosComparendos rangoId(int id) throws Exception;

}
