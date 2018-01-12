/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.tr.bo.GestionPersonaBO;
import com.contravenciones.tr.bo.GestionRecursoBO;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
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
    
     /*Método para consultar todos las personas registradas en la base de datos.*/
    /*public void listarRecurso() {
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

    }*/

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
    

}
