/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.RangosException;
import com.contravenciones.model.Agente;
import com.contravenciones.model.Rangos;
import com.contravenciones.tr.bo.RangosBO;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivDetalleRangoComparendos;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivRangosComparendos;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
import java.util.ArrayList;
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
public class BeanRangos implements Serializable {

    private BeanLogin loginBean;
    private RangosBO rangosBO;

    private boolean mostrarBuscar = true;
    private boolean mostrarConsultaAgente = false;

    private Map<Integer, String> tipoComparendos;

    private List<Rangos> listRangos;

    private boolean detalleConsulta = false;
    private boolean crearPersona = false;
    private boolean btnRegistrar = false;
    private boolean mostrarDetalle = false;
    private boolean mostrarConsulta = true;

    private String rangoInicial;
    private String rangoFinal;
    private String referenciaInicial;
    private String referenciaFinal;
    private Date fechaResolucion;
    private String numeroRango;
    private String rangoDefecto;
    private int longitud;
    private int maxLength;
    private int tipoComparendo;
    /*Detalle rango*/
    private Map<Integer, String> listEstadoRango;
    private String codigo;
    private Date fechaInicial;
    private Date fechaFinal;
    private int estado;
    private String usuarioCreacion;
    private int codigoUsuario;
    private boolean campos = true;
    private boolean btnEditar = true;
    private boolean botones = false;
    private List<CivDetalleRangoComparendos> listDetalleRango;
    private Map<Integer, String> listEstadoDetalleRango;

    @PostConstruct
    public void listaRangos() {
        try {
            cargarDatos();
            getRangosBO().listRangos(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar rangos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        }
    }

    public void detalle(Rangos bean) {

        try {
            getRangosBO().listDetalleRangos(this, bean);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar detalles : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        }
    }

    public void habilitarCampos() {
        setCampos(false);
        setBtnEditar(false);
        setBotones(true);
    }

    public void cancelarEdicion() {
        impCancelarEdicion();
    }

    protected void impCancelarEdicion() {
        try {
            getRangosBO().cancelarEditar(this);
            setCampos(true);
            setBtnEditar(true);
            setBotones(false);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos::messageGeneral");
        }

    }

    public void cargarDatos() {
        try {
            getRangosBO().cargarDatos(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        }
    }

    public void generarRangos(String ref) {
        impGenerarRangos(ref);
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impGenerarRangos(String ref) {
        try {
            getRangosBO().generarRangos(this, ref);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:mensajeModal");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar agentes: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:mensajeModal");
        }

    }

    public void registrarRango() {
        impRegistrarRango();
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impRegistrarRango() {
        try {
            getRangosBO().registrarRangos(this);
            cancelarModalRango();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Rango registrado correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
            RequestContext.getCurrentInstance().execute("$('#adicionarRango').modal('hide');");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:mensajeModal");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar agentes: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:mensajeModal");
        }

    }
    
    public void editarRango() {
        impEditarRango();
    }

    protected void impEditarRango() {
        try {
            getRangosBO().editarRangos(this);
            setCampos(true);
            setBtnEditar(true);
            setBotones(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Rango actualizado correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        }

    }

    public String agente(int id) {
        try {
            return getRangosBO().consultarAgente(id);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar detalle rangos agente : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("rangos:messageGeneral");
        }
        return "";
    }

    public void cancelarModalRango() {
        setRangoInicial("");
        setRangoFinal("");
        setReferenciaInicial("");
        setReferenciaFinal("");
        setNumeroRango("");
        setFechaResolucion(null);
        setBtnRegistrar(false);
        setLongitud(0);
        setRangoDefecto("");
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
     * @return the rangosBO
     */
    public RangosBO getRangosBO() {
        return rangosBO;
    }

    /**
     * @param rangosBO the rangosBO to set
     */
    public void setRangosBO(RangosBO rangosBO) {
        this.rangosBO = rangosBO;
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
     * @return the mostrarConsulta
     */
    public boolean isMostrarConsultaAgente() {
        return mostrarConsultaAgente;
    }

    /**
     * @param mostrarConsulta the mostrarConsulta to set
     */
    public void setMostrarConsultaAgente(boolean mostrarConsulta) {
        this.mostrarConsultaAgente = mostrarConsulta;
    }

    /**
     * @return the detalleConsulta
     */
    public boolean isDetalleConsulta() {
        return detalleConsulta;
    }

    /**
     * @param detalleConsulta the detalleConsulta to set
     */
    public void setDetalleConsulta(boolean detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    /**
     * @return the crearPersona
     */
    public boolean isCrearPersona() {
        return crearPersona;
    }

    /**
     * @param crearPersona the crearPersona to set
     */
    public void setCrearPersona(boolean crearPersona) {
        this.crearPersona = crearPersona;
    }

    /**
     * @return the btnRegistrar
     */
    public boolean isBtnRegistrar() {
        return btnRegistrar;
    }

    /**
     * @param btnRegistrar the btnRegistrar to set
     */
    public void setBtnRegistrar(boolean btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * @return the rangoInicial
     */
    public String getRangoInicial() {
        return rangoInicial;
    }

    /**
     * @param rangoInicial the rangoInicial to set
     */
    public void setRangoInicial(String rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    /**
     * @return the rangoFinal
     */
    public String getRangoFinal() {
        return rangoFinal;
    }

    /**
     * @param rangoFinal the rangoFinal to set
     */
    public void setRangoFinal(String rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    /**
     * @return the referenciaInicial
     */
    public String getReferenciaInicial() {
        return referenciaInicial;
    }

    /**
     * @param referenciaInicial the referenciaInicial to set
     */
    public void setReferenciaInicial(String referenciaInicial) {
        this.referenciaInicial = referenciaInicial;
    }

    /**
     * @return the referenciaFinal
     */
    public String getReferenciaFinal() {
        return referenciaFinal;
    }

    /**
     * @param referenciaFinal the referenciaFinal to set
     */
    public void setReferenciaFinal(String referenciaFinal) {
        this.referenciaFinal = referenciaFinal;
    }

    /**
     * @return the fechaResolucion
     */
    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    /**
     * @param fechaResolucion the fechaResolucion to set
     */
    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    /**
     * @return the numeroRango
     */
    public String getNumeroRango() {
        return numeroRango;
    }

    /**
     * @param numeroRango the numeroRango to set
     */
    public void setNumeroRango(String numeroRango) {
        this.numeroRango = numeroRango;
    }

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * @return the tipoComparendo
     */
    public int getTipoComparendo() {
        return tipoComparendo;
    }

    /**
     * @param tipoComparendo the tipoComparendo to set
     */
    public void setTipoComparendo(int tipoComparendo) {
        this.tipoComparendo = tipoComparendo;
    }

    /**
     * @return the tipoComparendos
     */
    public Map<Integer, String> getTipoComparendos() {
        return tipoComparendos;
    }

    /**
     * @param tipoComparendos the tipoComparendos to set
     */
    public void setTipoComparendos(Map<Integer, String> tipoComparendos) {
        this.tipoComparendos = tipoComparendos;
    }

    /**
     * @return the rangoDefecto
     */
    public String getRangoDefecto() {
        return rangoDefecto;
    }

    /**
     * @param rangoDefecto the rangoDefecto to set
     */
    public void setRangoDefecto(String rangoDefecto) {
        this.rangoDefecto = rangoDefecto;
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the listRangos
     */
    public List<Rangos> getListRangos() {
        return listRangos;
    }

    /**
     * @param listRangos the listRangos to set
     */
    public void setListRangos(List<Rangos> listRangos) {
        this.listRangos = listRangos;
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the usuarioCreacion
     */
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    /**
     * @param usuarioCreacion the usuarioCreacion to set
     */
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
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
     * @return the listDetalleRango
     */
    public List<CivDetalleRangoComparendos> getListDetalleRango() {
        return listDetalleRango;
    }

    /**
     * @param listDetalleRango the listDetalleRango to set
     */
    public void setListDetalleRango(List<CivDetalleRangoComparendos> listDetalleRango) {
        this.listDetalleRango = listDetalleRango;
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
     * @return the listEstadoRango
     */
    public Map<Integer, String> getListEstadoRango() {
        return listEstadoRango;
    }

    /**
     * @param listEstadoRango the listEstadoRango to set
     */
    public void setListEstadoRango(Map<Integer, String> listEstadoRango) {
        this.listEstadoRango = listEstadoRango;
    }

    /**
     * @return the listEstadoDetalleRango
     */
    public Map<Integer, String> getListEstadoDetalleRango() {
        return listEstadoDetalleRango;
    }

    /**
     * @param listEstadoDetalleRango the listEstadoDetalleRango to set
     */
    public void setListEstadoDetalleRango(Map<Integer, String> listEstadoDetalleRango) {
        this.listEstadoDetalleRango = listEstadoDetalleRango;
    }

    /**
     * @return the codigoUsuario
     */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

}
