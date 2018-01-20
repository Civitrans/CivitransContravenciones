/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivRangosComparendos;
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
    
}
