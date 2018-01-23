/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivPlantillas;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Soporte 2
 */
public class DaoPlantillas extends HibernateDaoSupport implements ITPlantillas {

    @Override
    public CivPlantillas getPlantilla(int tipo) throws Exception {
        String hql = "FROM CivPlantillas WHERE planTipo = :tipo";
        List list = getHibernateTemplate().findByNamedParam(hql, "tipo", BigDecimal.valueOf(tipo));
        if (list.size() > 0) {
            return (CivPlantillas) list.get(0);
        }
        return null;
    }

}
