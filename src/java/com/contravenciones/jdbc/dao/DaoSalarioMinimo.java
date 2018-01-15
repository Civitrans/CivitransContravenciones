/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivSalariosminimos;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoSalarioMinimo extends HibernateDaoSupport implements ITSalarioMinimo {

    /**
     *
     * @param salarioMinimo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivSalariosminimos salarioMinimo) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(salarioMinimo).toString());
    }

    /**
     *
     * @param salarioMinimo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivSalariosminimos salarioMinimo) throws Exception {
        getHibernateTemplate().merge(salarioMinimo);
        return true;
    }

    /**
     *
     * @param vigencia
     * @return
     * @throws Exception
     */
    @Override
    public CivSalariosminimos salarioPorVigencia(long vigencia) throws Exception {
        String hql = "from CivSalariosminimos where sal_id=:vigencia";
        List list = getHibernateTemplate().findByNamedParam(hql, "vigencia", vigencia);
        CivSalariosminimos of = new CivSalariosminimos();
        if (list.size() > 0) {
            of = (CivSalariosminimos) list.get(0);
            return of;
        }else{
            return null;
        }
        
    }
    
    /**
     *
     * @param vigencia
     * @return
     * @throws Exception
     */
    @Override
    public CivSalariosminimos salarioByVigencia(long vigencia) throws Exception {
        String hql = "from CivSalariosminimos where sal_vigencia=:vigencia";
        List list = getHibernateTemplate().findByNamedParam(hql, "vigencia", vigencia);
        CivSalariosminimos of = new CivSalariosminimos();
        if (list.size() > 0) {
            of = (CivSalariosminimos) list.get(0);
            return of;
        }else{
            return null;
        }
        
    }
    
    @Override

    public List<CivSalariosminimos> listVigencia() throws Exception {
        String hql = "from CivSalariosminimos order by sal_vigencia desc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }


}
