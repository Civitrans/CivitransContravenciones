/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivOrganismos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoOrganismos extends HibernateDaoSupport implements ITOrganismos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivOrganismos par) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(par).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivOrganismos par) throws Exception {
        getHibernateTemplate().update(par);
        return true;
    }
    
    @Override
    public CivOrganismos consultaCodigoOrganismo(int id) throws Exception {
        String hql = "from CivOrganismos where orgId =:id";
       List list = getHibernateTemplate().findByNamedParam(hql, "id", BigDecimal.valueOf(id));
        if (list.size() > 0) {
            return (CivOrganismos) list.get(0);
        }
        return null;
    }
    
    
}
