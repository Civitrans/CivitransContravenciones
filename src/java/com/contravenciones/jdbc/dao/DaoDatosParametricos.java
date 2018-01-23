/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDatosParametricos;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoDatosParametricos extends HibernateDaoSupport implements ITDatosParametricos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDatosParametricos par) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(par).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDatosParametricos par) throws Exception {
        getHibernateTemplate().update(par);
        return true;
    }
    
    @Override
    public CivDatosParametricos consultarDatosPID(int id) throws Exception {
        String hql = "from CivDatosParametricos where DTPARA_ID =:id";
       List list = getHibernateTemplate().findByNamedParam(hql, "id", id);
        if (list.size() > 0) {
            return (CivDatosParametricos) list.get(0);
        }
        return null;
    }
    
    
}
