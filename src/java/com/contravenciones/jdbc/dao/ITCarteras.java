/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarteras;

/**
 *
 * @author Admin
 */
public interface ITCarteras {

    public long insert(CivCarteras carteras) throws Exception;

    public boolean update(CivCarteras carteras) throws Exception;
}
