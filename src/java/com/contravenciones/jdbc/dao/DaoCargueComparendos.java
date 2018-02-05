/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarguecomparendo;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Soporte 2
 */
public class DaoCargueComparendos extends HibernateDaoSupport implements ITCargueComparendos {

    @Override
    public CivCarguecomparendo getCargueComparendo(long comparendo, String documento, long tipoDocumento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
