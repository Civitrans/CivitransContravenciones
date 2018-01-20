/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivEstructuraSimit;

/**
 *
 * @author Soporte 2
 */
public interface ITEstructuraSimit {
    
    public CivEstructuraSimit getEstructuraSimit(long index,long tipo) throws Exception;
    
}
