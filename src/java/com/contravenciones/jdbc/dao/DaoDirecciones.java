/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivDirecciones;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ing_jefreypadilla
 */
public class DaoDirecciones extends HibernateDaoSupport implements ITDirecciones {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDirecciones direccion) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(direccion).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDirecciones direccion) throws Exception {
        getHibernateTemplate().merge(direccion);
        return true;
    }

    @Override
    public List<CivDirecciones> listDireccionesByPersona(long id_persona) throws Exception {

        String hql = "from CivDirecciones where per_id=:id_persona order by 1 desc";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_persona", id_persona);
        return list;
    }
    
    @Override
    public CivDirecciones consultarDireccionActualByPersona(long persona) throws Exception {
        String hql = "from CivDirecciones where per_id =:persona and dir_fechafinal is null";
        List list = getHibernateTemplate().findByNamedParam(hql, "persona", persona);
        if (list.size() > 0) {
            return (CivDirecciones) list.get(0);
        }
        return null;
    }

}
