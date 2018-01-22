/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.tr.bo.GestionPersonaBO;
import com.contravenciones.tr.persistence.CivPersonas;
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
public class BeanGestionPersona implements Serializable {

    private BeanLogin loginBean;
    private GestionPersonaBO gestionPersonaBO;

    private List<CivPersonas> listPersonas;
    private Map<Integer, String> listTipoDocumento; // tipos de documento
    private Map<Integer, String> estadoPersona;
    private String buscarPersona;
    private boolean mostrarConsulta = false;

    private int idpersona;
    private int tipoDoc;
    private String documento;
    private Date fechaNac;
    private int paisNac;
    private int depNac;
    private int munNac;
    private int paisExp;
    private int depExp;
    private int munExp;
    private Date fechaExp;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String sexo;
    private String grupoSang;
    private String celular;
    private String telefono;
    private String email;
    private int depDir;
    private int munDir;
    private String dir;
    private boolean btnRegistrar;
    private String origen;

    public void cargarDatos() {
        try {
            getGestionPersonaBO().cargarDatos(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Método para consultar todos las personas registradas en la base de datos.*/
    public void listarPersona() {
        cargarDatos();
        getListTipoDocumento();
        impListarPersona();
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impListarPersona() {
        try {
            getGestionPersonaBO().listPersona(this);
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (PersonaException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        }

    }

    public void guardarDatosPersona() {
        guardarPersona();
//        mostrarAlerta();
    }

    /**
     *
     */
    protected void guardarPersona() {
        try {
            getGestionPersonaBO().guardarPersona(this);
            limpiarModal();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Persona registrada correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("messageGeneral");
            RequestContext.getCurrentInstance().execute("$('#dg_persona').modal('toggle'); $('#" + getOrigen() + "').modal('toggle')");
            
        } catch (PersonaException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getNivelFacesMessage(), "Error", ex.getMessage()));
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error guardando persona: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
        }
    }

    public void verificarPersona() {
        try {
            getGestionPersonaBO().verificarPersona(this);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mnsje");
        } catch (PersonaException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getNivelFacesMessage(), "Error", ex.getMessage()));
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al verificar persona: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
        }
    }

    public void cancelarModal() {
        RequestContext.getCurrentInstance().execute("$('#dg_persona').modal('toggle'); $('#" + getOrigen() + "').modal('toggle')");
    }
    
    public void limpiarModal(){
        setTipoDoc(0);
        setNombre1("");
        setNombre2("");
        setApellido1("");
        setApellido2("");
        setPaisExp(0);
        setDepExp(0);
        setMunExp(0);
        setFechaExp(null);
        setDepNac(0);
        setMunNac(0);
        setSexo("");
        setGrupoSang("");
        setCelular("");
        setEmail("");
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
     * @return the gestionPersonaBO
     */
    public GestionPersonaBO getGestionPersonaBO() {
        return gestionPersonaBO;
    }

    /**
     * @param gestionPersonaBO the gestionPersonaBO to set
     */
    public void setGestionPersonaBO(GestionPersonaBO gestionPersonaBO) {
        this.gestionPersonaBO = gestionPersonaBO;
    }

    /**
     * @return the buscarPersona
     */
    public String getBuscarPersona() {
        return buscarPersona;
    }

    /**
     * @param buscarPersona the buscarPersona to set
     */
    public void setBuscarPersona(String buscarPersona) {
        this.buscarPersona = buscarPersona;
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
     * @return the listTipoDocumento
     */
    public Map<Integer, String> getListTipoDocumento() {
        return listTipoDocumento;
    }

    /**
     * @param listTipoDocumento the listTipoDocumento to set
     */
    public void setListTipoDocumento(Map<Integer, String> listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
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
     * @return the tipoDoc
     */
    public int getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(int tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the paisNac
     */
    public int getPaisNac() {
        return paisNac;
    }

    /**
     * @param paisNac the paisNac to set
     */
    public void setPaisNac(int paisNac) {
        this.paisNac = paisNac;
    }

    /**
     * @return the depNac
     */
    public int getDepNac() {
        return depNac;
    }

    /**
     * @param depNac the depNac to set
     */
    public void setDepNac(int depNac) {
        this.depNac = depNac;
    }

    /**
     * @return the munNac
     */
    public int getMunNac() {
        return munNac;
    }

    /**
     * @param munNac the munNac to set
     */
    public void setMunNac(int munNac) {
        this.munNac = munNac;
    }

    /**
     * @return the paisExp
     */
    public int getPaisExp() {
        return paisExp;
    }

    /**
     * @param paisExp the paisExp to set
     */
    public void setPaisExp(int paisExp) {
        this.paisExp = paisExp;
    }

    /**
     * @return the depExp
     */
    public int getDepExp() {
        return depExp;
    }

    /**
     * @param depExp the depExp to set
     */
    public void setDepExp(int depExp) {
        this.depExp = depExp;
    }

    /**
     * @return the munExp
     */
    public int getMunExp() {
        return munExp;
    }

    /**
     * @param munExp the munExp to set
     */
    public void setMunExp(int munExp) {
        this.munExp = munExp;
    }

    /**
     * @return the fechaExp
     */
    public Date getFechaExp() {
        return fechaExp;
    }

    /**
     * @param fechaExp the fechaExp to set
     */
    public void setFechaExp(Date fechaExp) {
        this.fechaExp = fechaExp;
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the grupoSang
     */
    public String getGrupoSang() {
        return grupoSang;
    }

    /**
     * @param grupoSang the grupoSang to set
     */
    public void setGrupoSang(String grupoSang) {
        this.grupoSang = grupoSang;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the depDir
     */
    public int getDepDir() {
        return depDir;
    }

    /**
     * @param depDir the depDir to set
     */
    public void setDepDir(int depDir) {
        this.depDir = depDir;
    }

    /**
     * @return the munDir
     */
    public int getMunDir() {
        return munDir;
    }

    /**
     * @param munDir the munDir to set
     */
    public void setMunDir(int munDir) {
        this.munDir = munDir;
    }

    /**
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return the idpersona
     */
    public int getIdpersona() {
        return idpersona;
    }

    /**
     * @param idpersona the idpersona to set
     */
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
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
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
