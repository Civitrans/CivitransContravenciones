/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarguecomparendo;

/**
 *
 * @author Soporte 2
 */
public interface ITCargueComparendos {
    
    public CivCarguecomparendo getCargueComparendo(long comparendo,String documento, long tipoDocumento) throws Exception;
    
}
