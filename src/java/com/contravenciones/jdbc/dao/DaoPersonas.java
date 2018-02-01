/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivPersonas;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
@Service
public class DaoPersonas implements ITPersonas {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public CivPersonas consultarPersonasById(int per_id) throws Exception {

        Criteria cri = getSessionFactory().getCurrentSession().createCriteria(CivPersonas.class);

        CivPersonas per = (CivPersonas) cri.add(Restrictions.idEq(BigDecimal.valueOf(per_id))).uniqueResult();
        if (per == null) {
            return null;
        }

        return per;
    }

    @Override
    @Transactional
    public CivPersonas consultarPersonasByDocumento(int tipo, String nro_documento) throws Exception {

        Criteria cri = getSessionFactory().getCurrentSession().createCriteria(CivPersonas.class);

        CivPersonas per = (CivPersonas) cri.add(Restrictions.eq("perDocumento", nro_documento)).add(Restrictions.and(Restrictions.eq("civTipodocumentos.tipdocId", BigDecimal.valueOf(tipo)))).uniqueResult();

        if (per == null) {
            return null;
        }
        return per;
    }

    @Override
    @Transactional
    public List<CivPersonas> listarPersonas(String persona) throws Exception {
        Criteria cri = getSessionFactory().getCurrentSession().createCriteria(CivPersonas.class);

        List<CivPersonas> per = cri
                .add(Restrictions.or(
                        Restrictions.like("perNombre1", "%" + persona + "%"),
                        Restrictions.like("perNombre2", "%" + persona + "%"),
                        Restrictions.like("perApellido1", "%" + persona + "%"),
                        Restrictions.like("perApellido2", "%" + persona + "%")))
                .list();

        if (per == null) {
            return null;
        }

        return per;

    }

    @Override
    @Transactional
    public List<CivPersonas> listarPersonasFecha(String fecha) throws Exception {

//        String hql = "from CivPersonas where per_fechainicial = :fecha order by 1 asc";
//        List list = getHibernateTemplate().findByNamedParam(hql, "fecha", fecha);
//        return list;
        return null;
    }

    @Override
    public CivPersonas consultarPersonasDocumento(String nro_documento) throws Exception {
//        String hql = "from CivPersonas where per_documento=:nro_documento";
//        List list = getHibernateTemplate().findByNamedParam(hql, "nro_documento", nro_documento);
//        if (list.size() > 0) {
//            return (CivPersonas) list.get(0);
//        }
        return null;
    }

    /**
     *
     * @param per
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivPersonas per) throws Exception {
        return Long.parseLong(getSessionFactory().getCurrentSession().save(per).toString());
    }

    /**
     *
     * @param per
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivPersonas per) throws Exception {
        getSessionFactory().getCurrentSession().update(per);
        return true;
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
