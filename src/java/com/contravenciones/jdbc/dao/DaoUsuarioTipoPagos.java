/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivUsuariosTipopagos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ing_jefreypadilla
 */
public class DaoUsuarioTipoPagos extends HibernateDaoSupport implements ITUsuarioTipoPago {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivUsuariosTipopagos usuariosCajasTipopagos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(usuariosCajasTipopagos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivUsuariosTipopagos usuariosCajasTipopagos) throws Exception {
        getHibernateTemplate().update(usuariosCajasTipopagos);
        return true;
    }


    @Override
    public List<CivUsuariosTipopagos> listTipoPagosByUsuario(long usuario) throws Exception {
        String hql = "from CivUsuariosTipopagos where civUsuarios.usuId=:usuario";
        List list = getHibernateTemplate().findByNamedParam(hql, "usuario", BigDecimal.valueOf(usuario));
        return list;

    }
    
    @Override
    public List<CivUsuariosTipopagos> listTipoPagosByUsuarioFechaFin(long usuario) throws Exception {
        String hql = "from CivUsuariosTipopagos where civUsuarios.usuId=:usuario and fechafin is null";
        List list = getHibernateTemplate().findByNamedParam(hql, "usuario", BigDecimal.valueOf(usuario));
        if (list.isEmpty()) {
            return null;
        }
        return list;

    }
    

}
