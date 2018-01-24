/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDetalleRangoComparendos;
import java.util.List;
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
    
     @Override
    public List<CivDetalleRangoComparendos> detalleRangobyId(int id) throws Exception {
        String hql = "from CivDetalleRangoComparendos where ran_id =:id";
        List list = getHibernateTemplate().findByNamedParam(hql, "id", id);
        if (list.size() > 0) {
            return list;
        }
        return null;
    }
    
     @Override

    public CivDetalleRangoComparendos detalleRangobyNumero(String numero) throws Exception {

        String hql = "from CivDetalleRangoComparendos where DTRAN_NUMERO =:numero";
        List list = getHibernateTemplate().findByNamedParam(hql, "numero", numero);
        if (list.size() > 0) {
            return (CivDetalleRangoComparendos) list.get(0);
        }
        return null;
    }
    
}
