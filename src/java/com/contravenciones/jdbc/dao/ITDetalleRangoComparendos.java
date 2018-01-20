/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDetalleRangoComparendos;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITDetalleRangoComparendos {
    
    /**
    
     *
     * @param detalle El Objeto a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivDetalleRangoComparendos detalle) throws Exception;

    /**
     
     *
     * @param detalle El Objeto a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivDetalleRangoComparendos detalle) throws Exception;

   
}
