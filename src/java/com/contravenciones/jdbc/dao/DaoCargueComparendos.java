/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivCarguecomparendo;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Soporte 2
 */
public class DaoCargueComparendos extends HibernateDaoSupport implements ITCargueComparendos {

    @Override
    public CivCarguecomparendo getCargueComparendo(String comparendo, String documento, long tipoDocumento) throws Exception {
        String hql = "From CivCarguecomparendo Cc Where Cc.comnumero = :comparendo and Cc.cominfractor =:documento and Cc.comtipodoc =:tipo ";
        List list = getHibernateTemplate().findByNamedParam(hql, new String[]{"comparendo", "documento", "tipo"}, new Object[]{comparendo, documento, BigDecimal.valueOf(tipoDocumento).toString()});
        if (!list.isEmpty()) {
            return (CivCarguecomparendo) list.get(0);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivCarguecomparendo civCarguecomparendo) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civCarguecomparendo).toString());
    }
    

}
