/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivComparendos;

/**
 *
 * @author Admin
 */
public interface ITComparendos {
    
     public CivComparendos getComparendo(String numeroComparendo) throws Exception;
    
    public long insert(CivComparendos civComparendo) throws Exception;
    
}
