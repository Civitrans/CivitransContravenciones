/*
 * To change this template, choose Tools | Templates
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanLogin;
import com.contravenciones.model.Modulo;
import com.contravenciones.tr.persistence.CivPerfilrecurso;
import java.util.List;

/**
 *
 * @author Jefrey Padilla
 */
public interface LoginBO {

    /**
     *
     * @param obj
     * @throws java.lang.Exception
     */
    void iniciarSesion(BeanLogin obj) throws Exception;

    /**
     *
     * @param obj
     * @return
     * @throws java.lang.Exception
     */
    List<Modulo> listarModulos(BeanLogin obj) throws Exception;
    
    /**
     *
     * @param obj
     * @return
     * @throws java.lang.Exception
     */
    void listarPerfilRecursos(BeanLogin obj) throws Exception;
    
    /**
     *
     * @param obj
     * @param tipo
     * @return
     * @throws java.lang.Exception
     */
    void filtrarRecursosPlantillas(BeanLogin obj, int tipo) throws Exception;

    /**
     *
     * @return @throws Exception
     */
    public String generarContrasena() throws Exception;

    /**
     *
     * @param obj
     * @return
     * @throws Exception
     */
    List<String> listarRecursos(BeanLogin obj) throws Exception;

    public List<Modulo> listarModulos(BeanLogin obj, int tipo) throws Exception;

    void consultarDatosUsuario(BeanLogin obj) throws Exception;

    public String getPlantilla(BeanLogin obj) throws Exception;
}
