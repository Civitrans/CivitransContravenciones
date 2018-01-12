/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jsf.bean.BeanGestionPersona;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Miguel Borja
 */
public class GestionPersonaImplBO implements GestionPersonaBO {

    private ITPersonas personasDAO;
    private ITParametros parametrosDAO;

    @Override
    public void listPersona(BeanGestionPersona bean) throws Exception {
        bean.setListPersonas(new ArrayList<>());

        for (CivPersonas per : getPersonasDAO().listarPersonas(bean.getBuscarPersona().toUpperCase())) {
            bean.getListPersonas().add(per);
        }
        if (bean.getListPersonas().isEmpty()) {
            throw new PersonaException("No se encontraron coincidencias.", 2);
        }
        bean.setMostrarConsulta(true);
    }

    @Override
    public void cargarDatos(BeanGestionPersona bean) throws Exception {
        //Combo de Tipo de documento que se encuentra en la tabla parametros
        bean.setListTipoDocumento(new HashMap<>());
        bean.setEstadoPersona(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(5)) {
            bean.getListTipoDocumento().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivParametros objParametros : getParametrosDAO().listParametros(391)) {
            bean.getEstadoPersona().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        
    }

    /**
     * @return the personasDAO
     */
    public ITPersonas getPersonasDAO() {
        return personasDAO;
    }

    /**
     * @param personasDAO the personasDAO to set
     */
    public void setPersonasDAO(ITPersonas personasDAO) {
        this.personasDAO = personasDAO;
    }

    /**
     * @return the parametrosDAO
     */
    public ITParametros getParametrosDAO() {
        return parametrosDAO;
    }

    /**
     * @param parametrosDAO the parametrosDAO to set
     */
    public void setParametrosDAO(ITParametros parametrosDAO) {
        this.parametrosDAO = parametrosDAO;
    }

}
