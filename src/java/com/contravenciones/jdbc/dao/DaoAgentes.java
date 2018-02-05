/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivAgentes;
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
public class DaoAgentes extends HibernateDaoSupport implements ITAgentes {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivAgentes agente) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(agente).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivAgentes agente) throws Exception {
        getHibernateTemplate().update(agente);
        return true;
    }

    @Override

    public List<CivAgentes> listarAgentes(int idper) throws Exception {

        String hql = "from CivAgentes where per_id =:idper";
        List list = getHibernateTemplate().findByNamedParam(hql, "idper", idper);
        
        return list;

    }

    @Override

    public List<CivAgentes> listarAgentesPlaca(String placa) throws Exception {

        String hql = "from CivAgentes where age_placa =:placa";
        List list = getHibernateTemplate().findByNamedParam(hql, "placa", placa);
        return list;

    }

    @Override

    public CivAgentes listarAgentesId(int id) throws Exception {

        String hql = "from CivAgentes where ageId =:id";
        List list = getHibernateTemplate().findByNamedParam(hql, "id", BigDecimal.valueOf(id));
        if (list.size() > 0) {
            return (CivAgentes) list.get(0);
        }
        return null;
    }

    @Override

    public CivAgentes agentes(int id) throws Exception {
        
        Criteria cri = getHibernateTemplate().getSessionFactory().openSession().createCriteria(CivAgentes.class);
        
       CivAgentes holi=(CivAgentes) cri.add(Restrictions.idEq(BigDecimal.ONE)).uniqueResult();
       return holi;
    }

    @Override
    public CivAgentes getAgente(String placa) throws Exception {
        String hql = "from CivAgentes where agePlaca =:placa";
        List list = getHibernateTemplate().findByNamedParam(hql, "placa", placa);
        if (list.size() > 0) {
            return (CivAgentes) list.get(0);
        }
        return null;
    }

}
