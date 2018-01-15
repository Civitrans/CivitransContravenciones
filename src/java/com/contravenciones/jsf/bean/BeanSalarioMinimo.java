/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.exception.SalarioMinimoException;
import com.contravenciones.tr.bo.SalarioMinimoBO;
import com.contravenciones.tr.persistence.CivSalariosminimos;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roymer Camacho
 */
public class BeanSalarioMinimo implements Serializable {

    private BeanLogin loginBean;
    private SalarioMinimoBO salarioMinimoBO;

    private int codeVigencia;

    private boolean btnActualizar = false;

    private double salario;

    private String vigencia;

    private List<CivSalariosminimos> listVigencia;

    /*Método para listar todas las vigencias.*/
    @PostConstruct
    public void listVigencias() {
        limpiarDatos();
        implistVigencias();
    }

    protected void implistVigencias() {
        try {
            getSalarioMinimoBO().listVig(this);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar vigencias: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        }
    }

    /*Método para registrar salario mínimo.*/
    public void registrarSalario() {
        try {
            getSalarioMinimoBO().registrarSalario(this);
            limpiarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, "Vigencia registrada correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        } catch (SalarioMinimoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al registrar salario: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        }
    }

    public void modal() {
        try {
            if (getCodeVigencia() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "¡Atención!", "Seleccione una vigencia"));
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
            } else {
                getSalarioMinimoBO().salarioVigencia(this);
                RequestContext.getCurrentInstance().execute("$('#actualizarSalario').modal('toggle')");
            }
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar salario: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        }
    }

    /*Método para listar salario por vigencia*/
    public void salarioVigencia() {
        try {
            if (getCodeVigencia() == 0) {
                setSalario(0);
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
            } else {
                if (getCodeVigencia() == 1000) {
                    setSalario(0);
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:pnGroup2");
                    RequestContext.getCurrentInstance().execute("$('#todosSalarios').modal('toggle')");
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
                } else {
                    getSalarioMinimoBO().salarioVigencia(this);
                    FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
                }

            }
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar salario: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        }
    }

    /*Método para actualizar vigencias*/
    public void actualizarVigencia() {
        try {
            getSalarioMinimoBO().actualizarVigencia(this);
            limpiarDatos();
            RequestContext.getCurrentInstance().execute("$('#actualizarSalario').modal('hide')");
            listVigencias();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, "Vigencia actualizada correctamente"));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        } catch (SalarioMinimoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getNivelFacesMessage(), null, e.getMessage()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al registrar salario: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(loginBean.getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("salarioMinimo:messageGeneral");
        }
    }

    public void limpiarDatos() {
        setVigencia("");
        setCodeVigencia(0);
        setSalario(0);
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
     * @return the salarioMinimoBO
     */
    public SalarioMinimoBO getSalarioMinimoBO() {
        return salarioMinimoBO;
    }

    /**
     * @param salarioMinimoBO the salarioMinimoBO to set
     */
    public void setSalarioMinimoBO(SalarioMinimoBO salarioMinimoBO) {
        this.salarioMinimoBO = salarioMinimoBO;
    }

    /**
     * @return the codeVigencia
     */
    public int getCodeVigencia() {
        return codeVigencia;
    }

    /**
     * @param codeVigencia the codeVigencia to set
     */
    public void setCodeVigencia(int codeVigencia) {
        this.codeVigencia = codeVigencia;
    }

    /**
     * @return the listVigencia
     */
    public List<CivSalariosminimos> getListVigencia() {
        return listVigencia;
    }

    /**
     * @param listVigencia the listVigencia to set
     */
    public void setListVigencia(List<CivSalariosminimos> listVigencia) {
        this.listVigencia = listVigencia;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * @return the btnActualizar
     */
    public boolean isBtnActualizar() {
        return btnActualizar;
    }

    /**
     * @param btnActualizar the btnActualizar to set
     */
    public void setBtnActualizar(boolean btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

}
