/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.exception.RecursoException;
import com.contravenciones.jdbc.dao.ITModulos;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITRecursos;
import com.contravenciones.jsf.bean.BeanGestionRecurso;
import com.contravenciones.tr.persistence.CivModulos;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivRecursos;
import com.contravenciones.utility.ValidacionDatos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Roymer Camacho
 */
public class GestionRecursoImplBO implements GestionRecursoBO {

    private ITRecursos recursosDAO;
    private ITParametros parametrosDAO;
    private ITModulos modulosDAO;

    @Override
    public void cargarDatos(BeanGestionRecurso bean) throws Exception {
        bean.setListEstadoRecurso(new HashMap<>());
        bean.setListModulos(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(392)) {
            objParametros.setParNombre(new ValidacionDatos().letraMayuscula(objParametros.getParNombre()));
            bean.getListEstadoRecurso().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivModulos mod : getModulosDAO().getAll()) {
            bean.getListModulos().put(mod.getModId().intValue(), mod.getModNombre());
        }

    }

    @Override
    public void listRecursos(BeanGestionRecurso bean) throws Exception {
        bean.setListRecursos(new ArrayList<>());

        for (CivRecursos rec : getRecursosDAO().listarRecursos(bean.getBuscarRecursos().toUpperCase())) {
            rec.setRecNombre(new ValidacionDatos().letraMayuscula(rec.getRecNombre()));
            bean.getListRecursos().add(rec);
        }
        if (bean.getListRecursos().isEmpty()) {
            throw new RecursoException("No se encontraron coincidencias.", 2);
        }
        bean.setMostrarConsulta(true);
    }

    @Override
    public void detalleRecursos(CivRecursos rec, BeanGestionRecurso bean) throws Exception {

        bean.setNombreRecurso(rec.getRecNombre());
        bean.setIdrecurso(rec.getRecId().intValue());
        bean.setDescripcion(rec.getRecDescripcion());
        bean.setFechaInicial(rec.getRecFechainicial());
        bean.setFechaFinal(rec.getRecFechafin());
        bean.setEstado(rec.getRecEstado().intValue());
        bean.setCarpeta(rec.getRecCarpeta());
        bean.setModulo(rec.getCivModulos().getModId().intValue());
        bean.setTipo(rec.getRecTipo().intValue());

    }

    @Override
    public void editarRecursos(BeanGestionRecurso bean) throws Exception {
        
        validarCampos(bean.getNombreRecurso());
        validarCampos(bean.getCarpeta());
        validarCampos(bean.getDescripcion());

        CivRecursos rec = new CivRecursos();
        rec.setRecId(BigDecimal.valueOf(bean.getIdrecurso()));
        rec.setRecNombre(bean.getNombreRecurso().toUpperCase());
        rec.setRecDescripcion(bean.getDescripcion());
        rec.setRecFechainicial(bean.getFechaInicial());
        if (bean.getEstado() == 2) {
            rec.setRecFechafin(new Date());
            bean.setFechaFinal(rec.getRecFechafin());
        } else {
            rec.setRecFechafin(null);
            bean.setFechaFinal(rec.getRecFechafin());
        }
        rec.setRecEstado(BigDecimal.valueOf(bean.getEstado()));
        rec.setRecCarpeta(bean.getCarpeta());
        CivModulos mod = new CivModulos();
        mod.setModId(BigDecimal.valueOf(bean.getModulo()));
        rec.setCivModulos(mod);
        rec.setRecTipo(BigDecimal.valueOf(bean.getTipo()));
        getRecursosDAO().update(rec);
    }
    
    @Override
    public void crearRecursos(BeanGestionRecurso bean) throws Exception {
        
        validarCampos(bean.getNombreRecurso());
        validarCampos(bean.getCarpeta());
        validarCampos(bean.getDescripcion());
        
        CivRecursos rec = new CivRecursos();
        rec.setRecNombre(bean.getNombreRecurso().toUpperCase());
        rec.setRecDescripcion(bean.getDescripcion());
        rec.setRecFechainicial(new Date());
        rec.setRecEstado(BigDecimal.ONE);
        rec.setRecCarpeta(bean.getCarpeta());
        CivModulos mod = new CivModulos();
        mod.setModId(BigDecimal.valueOf(bean.getModulo()));
        rec.setCivModulos(mod);
        rec.setRecTipo(BigDecimal.valueOf(bean.getTipo()));
        getRecursosDAO().insert(rec);
    }

    @Override
    public void cancelarEditar(BeanGestionRecurso bean) throws Exception {

        CivRecursos rec = getRecursosDAO().getRecursosbyId(bean.getIdrecurso());
        bean.setNombreRecurso(new ValidacionDatos().letraMayuscula(rec.getRecNombre()));
        bean.setIdrecurso(rec.getRecId().intValue());
        bean.setDescripcion(rec.getRecDescripcion());
        bean.setFechaInicial(rec.getRecFechainicial());
        bean.setFechaFinal(rec.getRecFechafin());
        bean.setEstado(rec.getRecEstado().intValue());
        bean.setCarpeta(rec.getRecCarpeta());
        bean.setModulo(rec.getCivModulos().getModId().intValue());
        bean.setTipo(rec.getRecTipo().intValue());

    }
    
    public boolean validarCampos(String campo) throws Exception{
        if(campo.equals("")){
            throw new RecursoException("Campos vacíos",1);
        }
        return true;
    }

    /**
     * @return the recursosDAO
     */
    public ITRecursos getRecursosDAO() {
        return recursosDAO;
    }

    /**
     * @param recursosDAO the recursosDAO to set
     */
    public void setRecursosDAO(ITRecursos recursosDAO) {
        this.recursosDAO = recursosDAO;
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

    /**
     * @return the modulosDAO
     */
    public ITModulos getModulosDAO() {
        return modulosDAO;
    }

    /**
     * @param modulosDAO the modulosDAO to set
     */
    public void setModulosDAO(ITModulos modulosDAO) {
        this.modulosDAO = modulosDAO;
    }

}
