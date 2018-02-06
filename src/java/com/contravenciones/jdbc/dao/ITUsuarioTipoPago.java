/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivUsuariosTipopagos;
import java.util.List;

/**
 *
 * @author ing_jefreypadilla
 */
public interface ITUsuarioTipoPago {

    /**
     * Insertar usuario caja tipo pagos
     *
     * @param usuariosCajasTipopagos
     * @return id de insercion
     * @throws Exception
     */
    public long insert(CivUsuariosTipopagos usuariosCajasTipopagos) throws Exception;

    /**
     * Actualiza usuario caja tipo pago
     *
     * @param usuariosCajasTipopagos
     * @return true en el caso de ser exitosa la actualización
     * @throws Exception
     */
    public boolean update(CivUsuariosTipopagos usuariosCajasTipopagos) throws Exception;

    
    /**
     * Listado de los tipos de pago asociados a una caja, usuario y estado
     *
     
     * @param usuario
    
     * @return Listado
     * @throws Exception
     */
    public List<CivUsuariosTipopagos> listTipoPagosByUsuario(long usuario) throws Exception;
    
    public List<CivUsuariosTipopagos> listTipoPagosByUsuarioFechaFin(long usuario) throws Exception;
    
    
}
