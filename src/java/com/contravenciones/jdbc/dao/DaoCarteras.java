/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarteras;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
public class DaoCarteras extends HibernateDaoSupport implements ITCarteras{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivCarteras carteras) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(carteras).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivCarteras carteras) throws Exception {
        getHibernateTemplate().update(carteras);
        return true;
    }
    
}
