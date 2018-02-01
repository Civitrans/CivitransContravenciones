/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivPerfilrecurso;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class DaoPerfilRecurso extends HibernateDaoSupport implements ITPerfilRecursos {

    @Override

    @Transactional(rollbackFor = Exception.class)
    public void insert(CivPerfilrecurso perfilrecurso) throws Exception {
        getHibernateTemplate().save(perfilrecurso).toString();
    }

    @Override

    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivPerfilrecurso perfilrecurso) throws Exception {
        getHibernateTemplate().update(perfilrecurso);
        return true;
    }

    @Override

    public List<CivPerfilrecurso> listPerfilRecursoByPerfil(long perfil) throws Exception {

        String hql = "from CivPerfilrecurso where perf_id=:perfil";
        List list = getHibernateTemplate().findByNamedParam(hql, "perfil", perfil);
        return list;
    }

    @Override

    public List<CivPerfilrecurso> listPerfilRecursoByIDUsuario(long idusuario) throws Exception {

        String hql = "from CivPerfilrecurso where usu_id=:idusuario";
        List list = getHibernateTemplate().findByNamedParam(hql, "idusuario", idusuario);
        return list;
    }

    @Override

    public List<CivPerfilrecurso> listPerfilRecursoByIDUsuarioFechaFin(long idusuario) throws Exception {

        Criteria cri = getHibernateTemplate().getSessionFactory().openSession().createCriteria(CivPerfilrecurso.class);

        List<CivPerfilrecurso> perfilRecurso = cri
                .add(Restrictions.eq("civUsuarios.usuId", BigDecimal.valueOf(idusuario)))
                .add(Restrictions.and(Restrictions.isNull("perrecFechafin")))
                .list();

        Collections.sort(perfilRecurso, (CivPerfilrecurso o1, CivPerfilrecurso o2) -> o2.getCivRecursos().getCivModulos().getModId().intValue() - o1.getCivRecursos().getCivModulos().getModId().intValue());

        if (perfilRecurso == null) {
            return null;
        }
        return perfilRecurso;
    }

    @Override

    public List<CivPerfilrecurso> listPerfilRecurso() throws Exception {

        String hql = "from CivPerfilrecurso order by perf_id asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
