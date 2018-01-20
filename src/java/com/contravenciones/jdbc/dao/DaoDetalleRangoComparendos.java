/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDetalleRangoComparendos;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoDetalleRangoComparendos extends HibernateDaoSupport implements ITDetalleRangoComparendos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDetalleRangoComparendos detalle) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(detalle).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDetalleRangoComparendos detalle) throws Exception {
        getHibernateTemplate().update(detalle);
        return true;
    }
    
}
