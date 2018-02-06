/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.tr.bo.GestionPersonaBO;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivTipodocumentos;
import com.contravenciones.utility.Log_Handler;
import com.contravenciones.utility.ValidacionDatos;
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
public class BeanGestionPersona implements Serializable {

    private BeanLogin loginBean;
    private GestionPersonaBO gestionPersonaBO;

    private List<CivPersonas> listPersonas;
    private Map<Integer, String> listTipoDocumento; // tipos de documento
    private List<CivTipodocumentos> listaTipoDocumento;
    private Map<Integer, String> estadoPersona;
    private String buscarPersona;
    private int buscarTipoDoc;
    private Date buscarFecha;
    private boolean mostrarConsulta = false;
    private boolean mostrarDetalle = false;
    private boolean mostrarBuscar = true;
    private boolean campos = true;
    private boolean nombreCompleto = true;
    private boolean nombreSeparado = false;
    private boolean botones = false;
    private boolean btnEditar = true;

    private int idpersona;
    private int idDireccion;
    private int tipoDoc;
    private String documento;
    private Date fechaNac;
    private int paisNac;
    private int depNac;
    private int munNac;
    private int paisExp;
    private int depExp;
    private int munExp;
    private int depDir;
    private int munDir;
    private int estado;
    private Date fechaRegistro;
    private Date fechaExp;
    private Date fechaInicialDir;
    private String usuario;
    private String nombre; // nombre completo de la persona
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String sexo;
    private String grupoSang;
    private String celular;
    private String telefono;
    private String email;
    private String formulario="gestionPersona:"; //Nombre del formulario para mostrar los respectivos mensajes

    private String dir;
    private boolean btnRegistrar;
    private String origen;

    /*direccion*/
    private String nomenclatura;
    private Map<String, String> listNomenclatura; // tipos de documento
    private String simbolo;
    private String numero1;
    private String letra;
    private boolean generarDireccion = false;
    private List<String> nuevaDireccion = new ArrayList<>();
    private boolean detalleDireccion = true;
    private boolean cancelarDireccion = false;
    private boolean disDireccion = true;

    @PostConstruct
    public void cargarDatos() {
        try {
            getGestionPersonaBO().cargarDatos(this);
            setListNomenclatura(new ValidacionDatos().ordenarMap(getListNomenclatura()));
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        }
    }

    public void detalle(CivPersonas civPersonas) {
        setMostrarDetalle(true);
        setMostrarBuscar(false);
        setMostrarConsulta(false);
        impDetallePersona(civPersonas);
    }

    protected void impDetallePersona(CivPersonas civPersonas) {
        try {
            getGestionPersonaBO().detallePersona(civPersonas, this);
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (PersonaException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al mostrar detalle persona : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        }

    }

    /*Método para consultar todos las personas registradas en la base de datos.*/
    public void listarPersona(String accion) {
        //cargarDatos();
        getListTipoDocumento();
        impListarPersona(accion);
        //RequestContext.getCurrentInstance().execute("reload()"); // Función para mantener la paginación de la tabla donde se listan los usuarios registrados en la base de datos.
    }

    protected void impListarPersona(String accion) {
        try {
            getGestionPersonaBO().listPersona(this, accion);
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionPersona:messageGeneral");
        } catch (PersonaException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al listar personas : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        }

    }

    public void guardarDatosPersona(String proceso) {
        guardarPersona(proceso);

    }

    /**
     *
     * @param proceso
     */
    protected void guardarPersona(String proceso) {
        try {
            getGestionPersonaBO().guardarPersona(this);

            if (proceso.equals("insertar")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Persona registrada correctamente"));
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
                limpiarModal();
                RequestContext.getCurrentInstance().execute("$('#dg_persona').modal('toggle'); $('#" + getOrigen() + "').modal('toggle')");
            } else {

                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
                deshabilitarCampos();
            }

        } catch (PersonaException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDetallePersona");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error guardando persona: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
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

    public void limpiarModal() {
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

    public void habilitarCampos() {
        setCampos(false);
        setBtnEditar(false);
        setBotones(true);
        setNombreCompleto(false);
        setNombreSeparado(true);
    }

    public void deshabilitarCampos() {
        setCampos(true);
        setBtnEditar(true);
        setBotones(false);
        setNombreCompleto(true);
        setNombreSeparado(false);
        setGenerarDireccion(false);
        setCancelarDireccion(false);
        setDetalleDireccion(true);
        setDisDireccion(true);
        setNuevaDireccion(new ArrayList<>());
    }

    public void btnDireccion() {
        setCancelarDireccion(true);
        setDetalleDireccion(false);
        setGenerarDireccion(true);
        setDir("");
    }

    public void cancelarEdicion() {
        impCancelarEdicion();
    }

    protected void impCancelarEdicion() {
        try {
            getGestionPersonaBO().cancelarEditar(this);
            deshabilitarCampos();
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        } catch (PersonaException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"messageGeneral");
        }

    }

    public void generaDireccion(String combo) {

        String valor = "";
        if (combo.equals("nom")) {
            getNuevaDireccion().add(getNomenclatura());
            setNomenclatura("");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
        }
        if (combo.equals("sim")) {
            if (getSimbolo().equals("1")) {
                getNuevaDireccion().add("No.");
            }
            if (getSimbolo().equals("2")) {
                getNuevaDireccion().add("-");
            }
            setSimbolo("");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
        }
        if (combo.equals("num")) {

            if (!getNumero1().equals("")) {
                if (new ValidacionDatos().validarSolonumeros(getNumero1())) {
                    getNuevaDireccion().add(getNumero1());
                    setNumero1("");
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Campo solo número"));
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Campo número vacío"));
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
            }

        }
        if (combo.equals("letra")) {

            if (!getLetra().equals("")) {
                if (new ValidacionDatos().validarSololetras(getLetra().toUpperCase())) {
                    getNuevaDireccion().add(getLetra().toUpperCase());
                    setLetra("");
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Campo solo letras"));
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Campo letra vacío"));
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(getFormulario()+"mensajeDireccion");
            }
        }
        for (String dire : getNuevaDireccion()) {
            valor += dire + " ";
        }
        
        setDir(valor);
        setDisDireccion(false);

    }

    public void reversarDireccion() {
        String valor = "";
        if (!getNuevaDireccion().isEmpty()) {
            getNuevaDireccion().remove(getNuevaDireccion().size() - 1);
            if (getNuevaDireccion().isEmpty()) {
                setDisDireccion(true);
            }
            for (String dire : getNuevaDireccion()) {
                valor += dire + " ";
            }
            setDir(valor);
        }
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
     * @return the nombreCompleto
     */
    public boolean isNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(boolean nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the nombreSeparado
     */
    public boolean isNombreSeparado() {
        return nombreSeparado;
    }

    /**
     * @param nombreSeparado the nombreSeparado to set
     */
    public void setNombreSeparado(boolean nombreSeparado) {
        this.nombreSeparado = nombreSeparado;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idDireccion
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the fechaInicialDir
     */
    public Date getFechaInicialDir() {
        return fechaInicialDir;
    }

    /**
     * @param fechaInicialDir the fechaInicialDir to set
     */
    public void setFechaInicialDir(Date fechaInicialDir) {
        this.fechaInicialDir = fechaInicialDir;
    }

    /**
     * @return the via
     */
    public String getNomenclatura() {
        return nomenclatura;
    }

    /**
     * @param via the via to set
     */
    public void setNomenclatura(String via) {
        this.nomenclatura = via;
    }

    /**
     * @return the numero1
     */
    public String getNumero1() {
        return numero1;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    /**
     * @return the listNomenclatura
     */
    public Map<String, String> getListNomenclatura() {
        return listNomenclatura;
    }

    /**
     * @param listNomenclatura the listNomenclatura to set
     */
    public void setListNomenclatura(Map<String, String> listNomenclatura) {
        this.listNomenclatura = listNomenclatura;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the generarDireccion
     */
    public boolean isGenerarDireccion() {
        return generarDireccion;
    }

    /**
     * @param generarDireccion the generarDireccion to set
     */
    public void setGenerarDireccion(boolean generarDireccion) {
        this.generarDireccion = generarDireccion;
    }

    /**
     * @return the nuevaDireccion
     */
    public List<String> getNuevaDireccion() {
        return nuevaDireccion;
    }

    /**
     * @param nuevaDireccion the nuevaDireccion to set
     */
    public void setNuevaDireccion(List<String> nuevaDireccion) {
        this.nuevaDireccion = nuevaDireccion;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }

    /**
     * @return the detalleDireccion
     */
    public boolean isDetalleDireccion() {
        return detalleDireccion;
    }

    /**
     * @param detalleDireccion the detalleDireccion to set
     */
    public void setDetalleDireccion(boolean detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    /**
     * @return the cancelarDireccion
     */
    public boolean isCancelarDireccion() {
        return cancelarDireccion;
    }

    /**
     * @param cancelarDireccion the cancelarDireccion to set
     */
    public void setCancelarDireccion(boolean cancelarDireccion) {
        this.cancelarDireccion = cancelarDireccion;
    }

    /**
     * @return the disDireccion
     */
    public boolean isDisDireccion() {
        return disDireccion;
    }

    /**
     * @param disDireccion the disDireccion to set
     */
    public void setDisDireccion(boolean disDireccion) {
        this.disDireccion = disDireccion;
    }

    /**
     * @return the buscarTipoDoc
     */
    public int getBuscarTipoDoc() {
        return buscarTipoDoc;
    }

    /**
     * @param buscarTipoDoc the buscarTipoDoc to set
     */
    public void setBuscarTipoDoc(int buscarTipoDoc) {
        this.buscarTipoDoc = buscarTipoDoc;
    }

    /**
     * @return the buscarFecha
     */
    public Date getBuscarFecha() {
        return buscarFecha;
    }

    /**
     * @param buscarFecha the buscarFecha to set
     */
    public void setBuscarFecha(Date buscarFecha) {
        this.buscarFecha = buscarFecha;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the listaTipoDocumento
     */
    public List<CivTipodocumentos> getListaTipoDocumento() {
        return listaTipoDocumento;
    }

    /**
     * @param listaTipoDocumento the listaTipoDocumento to set
     */
    public void setListaTipoDocumento(List<CivTipodocumentos> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    /**
     * @return the formulario
     */
    public String getFormulario() {
        return formulario;
    }

    /**
     * @param formulario the formulario to set
     */
    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

}
