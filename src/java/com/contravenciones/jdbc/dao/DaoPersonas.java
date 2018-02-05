/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivPersonas;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JefreySistemas
 */
public class DaoPersonas extends HibernateDaoSupport implements ITPersonas {

    @Override
    public CivPersonas consultarPersonasById(int per_id) throws Exception {
        String hql = "from CivPersonas where perId =:per_id";
        List list = getHibernateTemplate().findByNamedParam(hql, "per_id", BigDecimal.valueOf(per_id));
        if (list.size() > 0) {
            return (CivPersonas) list.get(0);
        }
        return null;
    }

    @Override
    public CivPersonas consultarPersonasByDocumento(int tipo, String nro_documento) throws Exception {
        String hql = "from CivPersonas where civTipodocumentos.tipdocCodigo =:tipo and perDocumento=:nro_documento";
        List list = getHibernateTemplate().findByNamedParam(hql, new String[]{"tipo", "nro_documento"}, new Object[]{new BigDecimal(tipo), nro_documento});
        if (list.size() > 0) {
            return (CivPersonas) list.get(0);
        }
        return null;
    }
    
    @Override

    public List<CivPersonas> listarPersonas(String persona) throws Exception {

        String hql = "from CivPersonas where Per_Nombre1 like :persona or Per_Nombre2 like :persona or Per_Apellido1 like :persona or Per_Apellido2 like :persona ORDER BY 1 asc";
        List list = getHibernateTemplate().findByNamedParam(hql, "persona", "%" + persona + "%");
       return list;
        
    }
    
    @Override

    public List<CivPersonas> listarPersonasFecha(String fecha) throws Exception {

        String hql = "from CivPersonas where per_fechainicial = :fecha order by 1 asc";
        List list = getHibernateTemplate().findByNamedParam(hql, "fecha", fecha);
       return list;
        
    }
    
    @Override
    public CivPersonas consultarPersonasDocumento(String nro_documento) throws Exception {
        String hql = "from CivPersonas where per_documento=:nro_documento";
        List list = getHibernateTemplate().findByNamedParam(hql, "nro_documento", nro_documento);
        if (list.size() > 0) {
            return (CivPersonas) list.get(0);
        }
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
        return Long.parseLong(getHibernateTemplate().save(per).toString());
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
        getHibernateTemplate().merge(per);
        return true;
    }

}
