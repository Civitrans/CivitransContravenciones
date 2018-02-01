/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivTipodocumentos;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoTipoDocumento extends HibernateDaoSupport implements ITTipoDocumento {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTipodocumentos civTipodocumentos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civTipodocumentos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTipodocumentos civTipodocumentos) throws Exception {
        getHibernateTemplate().update(civTipodocumentos);
        return true;
    }

    @Override

    public List<CivTipodocumentos> listAll() throws Exception {
        String hql = "from CivTipodocumentos where tipdocFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }
}
