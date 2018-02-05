/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarguecomparendo;
import com.contravenciones.tr.persistence.CivComparendos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
public class DaoComparendos extends HibernateDaoSupport implements ITComparendos {

    @Override
    public CivComparendos getComparendo(String numeroComparendo) throws Exception {
        String hql = "From CivComparendos Cc Where Cc.comNumero = :comparendo ";
        List list = getHibernateTemplate().findByNamedParam(hql, "comparendo", numeroComparendo);
        if (!list.isEmpty()) {
            return (CivComparendos) list.get(0);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivComparendos civComparendo) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civComparendo).toString());
    }

}
