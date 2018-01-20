/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDivipos;
import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoDivipos extends HibernateDaoSupport implements ITDivipo, Serializable {

    private static final long serialVersionUID = 7526472295622776524L;  // unique id

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDivipos divipo) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(divipo).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDivipos divipo) throws Exception {
        getHibernateTemplate().merge(divipo);
        return true;
    }
    
    @Override
    public List<CivDivipos> listAllDivipos() throws Exception {

        String hql = "FROM CivDivipos";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivDivipos getDivipo(long id_divipo) throws Exception {

        String hql = "FROM CivDivipos WHERE DIV_ID = :id_divipo";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_divipo", id_divipo);
        if (list.size() > 0) {
            return (CivDivipos) list.get(0);
        }
        return null;
    }

    @Override
    public List<CivDivipos> listDiviposByDepartamento(long id_departamento) throws Exception {

        String hql = "FROM CivDivipos WHERE DEP_ID = :id_departamento";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_departamento", id_departamento);
        return list;
    }

    @Override
    public CivDivipos getDivipoByMunicipio(long id_municipio) throws Exception {
        String hql = "FROM CivDivipos WHERE mun_id = :id_municipio order by div_codigo asc";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_municipio", id_municipio);
        if (list.size() > 0) {
            return (CivDivipos) list.get(0);
        }
        return new CivDivipos();
    }

    /**
     *
     * @param departamento
     * @param municipio
     * @return
     * @throws Exception
     */
    @Override
    public CivDivipos getDivipoByDepartamentoByMunicipio(long departamento, long municipio) throws Exception {
        String hql = "FROM CivDivipos WHERE dep_id = :departamento and mun_id = :municipio order by div_codigo asc";
        List list = getHibernateTemplate().findByNamedParam(hql, new String[]{"departamento", "municipio"}, new Object[]{departamento, municipio});
        if (list.size() > 0) {
            return (CivDivipos) list.get(0);
        }
        return new CivDivipos();
    }

    @Override
    public CivDivipos getDivipoByCode(long code) throws Exception {
        String hql = "FROM CivDivipos WHERE div_codigo = :code";
        List list = getHibernateTemplate().findByNamedParam(hql, "code", code);
        if (list.size() > 0) {
            return (CivDivipos) list.get(0);
        }
        return null;
    }
}
