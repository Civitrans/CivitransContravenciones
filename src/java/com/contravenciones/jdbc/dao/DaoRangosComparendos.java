/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivRangosComparendos;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoRangosComparendos extends HibernateDaoSupport implements ITRangos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivRangosComparendos rangos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(rangos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivRangosComparendos rangos) throws Exception {
        getHibernateTemplate().update(rangos);
        return true;
    }
    
    @Override

    public List<CivRangosComparendos> getRangosAll() throws Exception {
        String hql = "from CivRangosComparendos where ran_estado = 1 order by ran_id asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }
    
     @Override
    public CivRangosComparendos rangoId(int id) throws Exception {
        String hql = "from CivRangosComparendos where ran_id =:id";
        List list = getHibernateTemplate().findByNamedParam(hql, "id", id);
        if (list.size() > 0) {
            return (CivRangosComparendos)list.get(0);
        }
        return null;
    }
    
}
