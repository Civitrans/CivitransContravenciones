/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.exception.RecursoException;
import com.contravenciones.tr.bo.GestionPersonaBO;
import com.contravenciones.tr.bo.GestionRecursoBO;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivRecursos;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roymer Camacho
 */
public class BeanGestionRecurso implements Serializable {

    private BeanLogin loginBean;
    private GestionRecursoBO gestionRecursoBO;

    private String buscarRecursos;
    private List<CivRecursos> listRecursos;
    private boolean mostrarConsulta = false;
    private boolean mostrarDetalle = false;
    private boolean mostrarBuscar = true;

    /*Detalle Recurso*/
    private Map<Integer, String> listEstadoRecurso;
    private Map<Integer, String> listModulos;
    private String nombreRecurso;
    private int idrecurso;
    private String descripcion;
    private Date fechaInicial;
    private Date fechaFinal;
    private int estado;
    private String carpeta;
    private int modulo;
    private int tipo;
    private boolean botones = false;
    private boolean btnEditar = true;
    private boolean campos = true;

    /*Método para consultar todos los recursos registrados en la base de datos.*/
    public void listarRecurso() {
        cargarDatos();
        impListarRecurso();
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void cargarDatos() {
        try {
            getGestionRecursoBO().cargarDatos(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        }
    }

    protected void impListarRecurso() {
        try {
            getGestionRecursoBO().listRecursos(this);
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (RecursoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        }

    }

    public void detalle(CivRecursos bean) {
        setMostrarDetalle(true);
        setMostrarBuscar(false);
        setMostrarConsulta(false);
        impDetalleRecurso(bean);
    }

    protected void impDetalleRecurso(CivRecursos bean) {
        try {
            getGestionRecursoBO().detalleRecursos(bean, this);
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (RecursoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        }

    }

    public void habilitarCampos() {
        setCampos(false);
        setBtnEditar(false);
        setBotones(true);
    }

    public void editarRecurso() {
        impEditarRecurso();
    }

    protected void impEditarRecurso() {
        try {
            getGestionRecursoBO().editarRecursos(this);
            setCampos(true);
            setBtnEditar(true);
            setBotones(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Recurso actualizado correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (RecursoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        }

    }
    
    public void cancelarEdicion() {
        impCancelarEdicion();
    }

    protected void impCancelarEdicion() {
        try {
            getGestionRecursoBO().cancelarEditar(this);
            setCampos(true);
            setBtnEditar(true);
            setBotones(false);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (RecursoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionRecursos:messageGeneral");
        }

    }

    /**
     * @return the loginBean
     */
    public BeanLogin getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(BeanLogin loginBean) {
        this.loginBean = loginBean;
    }

    /**
     * @return the gestionRecursoBO
     */
    public GestionRecursoBO getGestionRecursoBO() {
        return gestionRecursoBO;
    }

    /**
     * @param gestionRecursoBO the gestionRecursoBO to set
     */
    public void setGestionRecursoBO(GestionRecursoBO gestionRecursoBO) {
        this.gestionRecursoBO = gestionRecursoBO;
    }

    /**
     * @return the buscarRecursos
     */
    public String getBuscarRecursos() {
        return buscarRecursos;
    }

    /**
     * @param buscarRecursos the buscarRecursos to set
     */
    public void setBuscarRecursos(String buscarRecursos) {
        this.buscarRecursos = buscarRecursos;
    }

    /**
     * @return the listRecursos
     */
    public List<CivRecursos> getListRecursos() {
        return listRecursos;
    }

    /**
     * @param listRecursos the listRecursos to set
     */
    public void setListRecursos(List<CivRecursos> listRecursos) {
        this.listRecursos = listRecursos;
    }

    /**
     * @return the mostrarConsulta
     */
    public boolean isMostrarConsulta() {
        return mostrarConsulta;
    }

    /**
     * @param mostrarConsulta the mostrarConsulta to set
     */
    public void setMostrarConsulta(boolean mostrarConsulta) {
        this.mostrarConsulta = mostrarConsulta;
    }

    /**
     * @return the mostrarDetalle
     */
    public boolean isMostrarDetalle() {
        return mostrarDetalle;
    }

    /**
     * @param mostrarDetalle the mostrarDetalle to set
     */
    public void setMostrarDetalle(boolean mostrarDetalle) {
        this.mostrarDetalle = mostrarDetalle;
    }

    /**
     * @return the mostrarBuscar
     */
    public boolean isMostrarBuscar() {
        return mostrarBuscar;
    }

    /**
     * @param mostrarBuscar the mostrarBuscar to set
     */
    public void setMostrarBuscar(boolean mostrarBuscar) {
        this.mostrarBuscar = mostrarBuscar;
    }

    /**
     * @return the nombreRecurso
     */
    public String getNombreRecurso() {
        return nombreRecurso;
    }

    /**
     * @param nombreRecurso the nombreRecurso to set
     */
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    /**
     * @return the idrecurso
     */
    public int getIdrecurso() {
        return idrecurso;
    }

    /**
     * @param idrecurso the idrecurso to set
     */
    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the carpeta
     */
    public String getCarpeta() {
        return carpeta;
    }

    /**
     * @param carpeta the carpeta to set
     */
    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    /**
     * @return the modulo
     */
    public int getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the botones
     */
    public boolean isBotones() {
        return botones;
    }

    /**
     * @param botones the botones to set
     */
    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    /**
     * @return the btnEditar
     */
    public boolean isBtnEditar() {
        return btnEditar;
    }

    /**
     * @param btnEditar the btnEditar to set
     */
    public void setBtnEditar(boolean btnEditar) {
        this.btnEditar = btnEditar;
    }

    /**
     * @return the campos
     */
    public boolean isCampos() {
        return campos;
    }

    /**
     * @param campos the campos to set
     */
    public void setCampos(boolean campos) {
        this.campos = campos;
    }

    /**
     * @return the listEstadoRecurso
     */
    public Map<Integer, String> getListEstadoRecurso() {
        return listEstadoRecurso;
    }

    /**
     * @param listEstadoRecurso the listEstadoRecurso to set
     */
    public void setListEstadoRecurso(Map<Integer, String> listEstadoRecurso) {
        this.listEstadoRecurso = listEstadoRecurso;
    }

    /**
     * @return the listModulos
     */
    public Map<Integer, String> getListModulos() {
        return listModulos;
    }

    /**
     * @param listModulos the listModulos to set
     */
    public void setListModulos(Map<Integer, String> listModulos) {
        this.listModulos = listModulos;
    }

}
