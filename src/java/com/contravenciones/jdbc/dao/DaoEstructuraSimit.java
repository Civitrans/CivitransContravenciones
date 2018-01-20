/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivEstructuraSimit;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Soporte 2
 */
public class DaoEstructuraSimit extends HibernateDaoSupport implements ITEstructuraSimit {

    @Override
    public CivEstructuraSimit getEstructuraSimit(long index, long tipo) throws Exception {
        String hql = "From CivEstructuraSimit where estrIndice =:index And estrTipo =:tipo";
        List list = getHibernateTemplate().findByNamedParam(hql, new String[]{"index", "tipo"}, new Object[]{BigDecimal.valueOf(index), BigDecimal.valueOf(tipo)});
        if (!list.isEmpty()) {
            return (CivEstructuraSimit) list.get(0);
        }
        return null;
    }

}
