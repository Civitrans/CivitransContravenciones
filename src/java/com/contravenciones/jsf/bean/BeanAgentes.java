/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.RangosException;
import com.contravenciones.model.Agente;
import com.contravenciones.tr.bo.AgentesBO;
import com.contravenciones.tr.bo.RangosBO;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivTipodocumentos;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class BeanAgentes implements Serializable {

    private BeanLogin loginBean;
    private AgentesBO agentesBO;

    private boolean mostrarBuscar = true;
    private boolean mostrarConsultaAgente = false;
    private boolean campos = true;
    private boolean botones = false;
    private boolean btnEditar = true;
    private BeanGestionPersona beanPersona;

    private List<CivAgentes> listAgente;
    private List<CivPersonas> listPersonas;
    private Map<Integer, String> estadoPersona;
    private Map<Integer, String> tipoAgentes;
    private Map<Integer, String> estadoAgentes;
    private List<CivAgentes> listDatos;
    private List<CivTipodocumentos> listTipoDocumento; // tipos de documento

    private String referencia;
    private String nombrePersona;
    private String placa;
    private String identificacion;
    private int tipoAgente;
    private int idPersona;
    private int estadoAgente;
    private int idAgente;

    private Date fechaRegistro;

    private boolean detalleConsulta = false;
    private boolean crearPersona = false;
    private boolean btnRegistrar = true;
    
    @PostConstruct
    public void cargarDatos() {
        try {
            getAgentesBO().cargarDatos(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        }
    }

    public void listarAgente(String BuscarReferencia) {
        impListarAgente(BuscarReferencia);
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impListarAgente(String BuscarReferencia) {
        try {
            getAgentesBO().listAgentes(this, BuscarReferencia);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar agentes: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        }

    }

    public void consultarPersona() {
        impConsultarPersona();
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impConsultarPersona() {
        try {
            getAgentesBO().consultarPersona(this);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:mensajeModal");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:mensajeModal");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al consultar persona: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:mensajeModal");
        }

    }

    public void registrarAgente(String accion) {
        impRegistrarAgente(accion);
    }

    protected void impRegistrarAgente(String accion) {
        try {
            getAgentesBO().registrarAgente(this, accion);
            setCampos(true);
            setBtnEditar(true);
            setBotones(false);
            if (accion.equals("insertar")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Agente registrado correctamente"));
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
                RequestContext.getCurrentInstance().execute("$('#registrarAgente').modal('hide');");
            }

        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:mensajeModal");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar agentes: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:mensajeModal");
        }

    }

    public void cancelarAgente() {
        setIdentificacion("");
        setPlaca("");
        setNombrePersona("");
        setBtnRegistrar(false);
        setCrearPersona(false);
        setDetalleConsulta(false);
    }

    public void detalleAgente(CivAgentes ag) {
        setMostrarBuscar(false);
        setMostrarConsultaAgente(false);
        CivPersonas per = new CivPersonas();
        per.setPerId(ag.getCivPersonas().getPerId());
        getBeanPersona().cargarDatos();
        getBeanPersona().setFormulario("agentes:");
        getBeanPersona().detalle(per);
        impDetalleAgente(ag.getAgeId().intValue());
    }

    protected void impDetalleAgente(int id) {
        try {
            getAgentesBO().detalleAgente(this, id);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        } catch (RangosException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar detalle agente: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("agentes:messageGeneral");
        }

    }

    public void cancelarEdicion() {
        impDetalleAgente(getIdAgente());
        setCampos(true);
        setBtnEditar(true);
        setBotones(false);
    }

    public void habilitarCampos() {
        setCampos(false);
        setBtnEditar(false);
        setBotones(true);
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
     * @return the listAgente
     */
    public List<CivAgentes> getListAgente() {
        return listAgente;
    }

    /**
     * @param listAgente the listAgente to set
     */
    public void setListAgente(List<CivAgentes> listAgente) {
        this.listAgente = listAgente;
    }

    /**
     * @return the listPersonas
     */
    public List<CivPersonas> getListPersonas() {
        return listPersonas;
    }

    /**
     * @param listPersonas the listPersonas to set
     */
    public void setListPersonas(List<CivPersonas> listPersonas) {
        this.listPersonas = listPersonas;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    

    /**
     * @return the estadoPersona
     */
    public Map<Integer, String> getEstadoPersona() {
        return estadoPersona;
    }

    /**
     * @param estadoPersona the estadoPersona to set
     */
    public void setEstadoPersona(Map<Integer, String> estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    /**
     * @return the listDatos
     */
    public List<CivAgentes> getListDatos() {
        return listDatos;
    }

    /**
     * @param listDatos the listDatos to set
     */
    public void setListDatos(List<CivAgentes> listDatos) {
        this.listDatos = listDatos;
    }

    /**
     * @return the nombrePersona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * @param nombrePersona the nombrePersona to set
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the tipoAgente
     */
    public int getTipoAgente() {
        return tipoAgente;
    }

    /**
     * @param tipoAgente the tipoAgente to set
     */
    public void setTipoAgente(int tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
     * @return the agentesBO
     */
    public AgentesBO getAgentesBO() {
        return agentesBO;
    }

    /**
     * @param agentesBO the agentesBO to set
     */
    public void setAgentesBO(AgentesBO agentesBO) {
        this.agentesBO = agentesBO;
    }

    /**
     * @return the beanPersona
     */
    public BeanGestionPersona getBeanPersona() {
        return beanPersona;
    }

    /**
     * @param beanPersona the beanPersona to set
     */
    public void setBeanPersona(BeanGestionPersona beanPersona) {
        this.beanPersona = beanPersona;
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
     * @return the tipoAgentes
     */
    public Map<Integer, String> getTipoAgentes() {
        return tipoAgentes;
    }

    /**
     * @param tipoAgentes the tipoAgentes to set
     */
    public void setTipoAgentes(Map<Integer, String> tipoAgentes) {
        this.tipoAgentes = tipoAgentes;
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
     * @return the estadoAgentes
     */
    public Map<Integer, String> getEstadoAgentes() {
        return estadoAgentes;
    }

    /**
     * @param estadoAgentes the estadoAgentes to set
     */
    public void setEstadoAgentes(Map<Integer, String> estadoAgentes) {
        this.estadoAgentes = estadoAgentes;
    }

    /**
     * @return the estadoAgente
     */
    public int getEstadoAgente() {
        return estadoAgente;
    }

    /**
     * @param estadoAgente the estadoAgente to set
     */
    public void setEstadoAgente(int estadoAgente) {
        this.estadoAgente = estadoAgente;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the idAgente
     */
    public int getIdAgente() {
        return idAgente;
    }

    /**
     * @param idAgente the idAgente to set
     */
    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    /**
     * @return the listTipoDocumento
     */
    public List<CivTipodocumentos> getListTipoDocumento() {
        return listTipoDocumento;
    }

    /**
     * @param listTipoDocumento the listTipoDocumento to set
     */
    public void setListTipoDocumento(List<CivTipodocumentos> listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
    }


}
