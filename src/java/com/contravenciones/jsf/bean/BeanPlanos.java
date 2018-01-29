/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.jsf.bean;

import com.contravenciones.tr.bo.PlanosBO;
import com.contravenciones.tr.persistence.CivCarguecomparendo;
import com.contravenciones.utility.Log_Handler;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Soporte 2
 */
public class BeanPlanos implements Serializable {

    private BeanLogin loginBean;
    private PlanosBO planosBO;

    private Part file;
    private List listaLinea;

    private List<CivCarguecomparendo> listComparendos; // Plano Arriba 
    private HashMap<String, String> hashLine; // Lienas del Error
    private List<HashMap> listLinea; //Listya de lineas de Error 
    private int cargados;
    private int noCargados;

    

    public void getPlanoComparendo() {
        if (getFile() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Infomarcion", Log_Handler.solucionError(new Exception("Debe cargar una archivo"))));
            return;
        }
        cargarPlanoComparendo();
    }

    protected void cargarPlanoComparendo() {
        try {
            getPlanosBO().guardarComparendoPlano(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error Subien archivo plano: ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBean().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
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
     * @return the planosBO
     */
    public PlanosBO getPlanosBO() {
        return planosBO;
    }

    /**
     * @param planosBO the planosBO to set
     */
    public void setPlanosBO(PlanosBO planosBO) {
        this.planosBO = planosBO;
    }

    /**
     * @return the file
     */
    public Part getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Part file) {
        this.file = file;
    }

    /**
     * @return the listComparendos
     */
    public List<CivCarguecomparendo> getListComparendos() {
        return listComparendos;
    }

    /**
     * @param listComparendos the listComparendos to set
     */
    public void setListComparendos(List<CivCarguecomparendo> listComparendos) {
        this.listComparendos = listComparendos;
    }

    /**
     * @return the hashLine
     */
    public HashMap<String, String> getHashLine() {
        return hashLine;
    }

    /**
     * @param hashLine the hashLine to set
     */
    public void setHashLine(HashMap<String, String> hashLine) {
        this.hashLine = hashLine;
    }

    /**
     * @return the listLinea
     */
    public List<HashMap> getListLinea() {
        return listLinea;
    }

    /**
     * @param listLinea the listLinea to set
     */
    public void setListLinea(List<HashMap> listLinea) {
        this.listLinea = listLinea;
    }

    /**
     * @return the cargados
     */
    public int getCargados() {
        return cargados;
    }

    /**
     * @param cargados the cargados to set
     */
    public void setCargados(int cargados) {
        this.cargados = cargados;
    }

    /**
     * @return the noCargados
     */
    public int getNoCargados() {
        return noCargados;
    }

    /**
     * @param noCargados the noCargados to set
     */
    public void setNoCargados(int noCargados) {
        this.noCargados = noCargados;
    }

    /**
     * @return the listaLinea
     */
    public List getListaLinea() {
        return listaLinea;
    }

    /**
     * @param listaLinea the listaLinea to set
     */
    public void setListaLinea(List listaLinea) {
        this.listaLinea = listaLinea;
    }

}
