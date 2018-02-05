/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDetallecartera;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
public class DaoDetalleCarteras extends HibernateDaoSupport implements ITDetalleCarteras{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDetallecartera detalleCarteras) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(detalleCarteras).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDetallecartera detalleCarteras) throws Exception {
        getHibernateTemplate().update(detalleCarteras);
        return true;
    }
    
}
