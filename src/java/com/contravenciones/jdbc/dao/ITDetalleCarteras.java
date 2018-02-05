/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDetallecartera;

/**
 *
 * @author Admin
 */
public interface ITDetalleCarteras {
    public long insert(CivDetallecartera detalleCarteras) throws Exception;

    public boolean update(CivDetallecartera detalleCarteras) throws Exception;
}
