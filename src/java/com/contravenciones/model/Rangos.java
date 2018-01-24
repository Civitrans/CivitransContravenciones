/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que define un recurso del sistema. Por ejemplo una vista que se llama
 * desde el menú principal.
 *
 * @author Roymer Camacho
 */
public class Rangos implements Serializable {

    private int ranId;
    private String ranNumInicial;
    private String ranNumFinal;
    private Date ranFechaInicial;
    private Date ranFechaFinal;
    private int ranEstado;
    private String ranNumResolucion;
    private Date ranFechaResolucion;
    private int usuId;
    private int ranTipoComparendo;
    private String bar;
    private String uti; // class del span
    private String porc; //class bar progress
    private String porcentaje;
    private String activos;
    private String utilizados;
    private String total;

    /**
     * @return the ranId
     */
    public int getRanId() {
        return ranId;
    }

    /**
     * @param ranId the ranId to set
     */
    public void setRanId(int ranId) {
        this.ranId = ranId;
    }

    /**
     * @return the ranNumInicial
     */
    public String getRanNumInicial() {
        return ranNumInicial;
    }

    /**
     * @param ranNumInicial the ranNumInicial to set
     */
    public void setRanNumInicial(String ranNumInicial) {
        this.ranNumInicial = ranNumInicial;
    }

    /**
     * @return the ranNumFinal
     */
    public String getRanNumFinal() {
        return ranNumFinal;
    }

    /**
     * @param ranNumFinal the ranNumFinal to set
     */
    public void setRanNumFinal(String ranNumFinal) {
        this.ranNumFinal = ranNumFinal;
    }

    /**
     * @return the ranFechaInicial
     */
    public Date getRanFechaInicial() {
        return ranFechaInicial;
    }

    /**
     * @param ranFechaInicial the ranFechaInicial to set
     */
    public void setRanFechaInicial(Date ranFechaInicial) {
        this.ranFechaInicial = ranFechaInicial;
    }

    /**
     * @return the ranFechaFinal
     */
    public Date getRanFechaFinal() {
        return ranFechaFinal;
    }

    /**
     * @param ranFechaFinal the ranFechaFinal to set
     */
    public void setRanFechaFinal(Date ranFechaFinal) {
        this.ranFechaFinal = ranFechaFinal;
    }

    /**
     * @return the ranEstado
     */
    public int getRanEstado() {
        return ranEstado;
    }

    /**
     * @param ranEstado the ranEstado to set
     */
    public void setRanEstado(int ranEstado) {
        this.ranEstado = ranEstado;
    }

    /**
     * @return the ranNumResolucion
     */
    public String getRanNumResolucion() {
        return ranNumResolucion;
    }

    /**
     * @param ranNumResolucion the ranNumResolucion to set
     */
    public void setRanNumResolucion(String ranNumResolucion) {
        this.ranNumResolucion = ranNumResolucion;
    }

    /**
     * @return the ranFechaResolucion
     */
    public Date getRanFechaResolucion() {
        return ranFechaResolucion;
    }

    /**
     * @param ranFechaResolucion the ranFechaResolucion to set
     */
    public void setRanFechaResolucion(Date ranFechaResolucion) {
        this.ranFechaResolucion = ranFechaResolucion;
    }

    /**
     * @return the usuId
     */
    public int getUsuId() {
        return usuId;
    }

    /**
     * @param usuId the usuId to set
     */
    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    /**
     * @return the ranTipoComparendo
     */
    public int getRanTipoComparendo() {
        return ranTipoComparendo;
    }

    /**
     * @param ranTipoComparendo the ranTipoComparendo to set
     */
    public void setRanTipoComparendo(int ranTipoComparendo) {
        this.ranTipoComparendo = ranTipoComparendo;
    }

    /**
     * @return the bar
     */
    public String getBar() {
        return bar;
    }

    /**
     * @param bar the bar to set
     */
    public void setBar(String bar) {
        this.bar = bar;
    }

    /**
     * @return the porc
     */
    public String getPorc() {
        return porc;
    }

    /**
     * @param porc the porc to set
     */
    public void setPorc(String porc) {
        this.porc = porc;
    }

    /**
     * @return the activos
     */
    public String getActivos() {
        return activos;
    }

    /**
     * @param activos the activos to set
     */
    public void setActivos(String activos) {
        this.activos = activos;
    }

    /**
     * @return the utilizados
     */
    public String getUtilizados() {
        return utilizados;
    }

    /**
     * @param utilizados the utilizados to set
     */
    public void setUtilizados(String utilizados) {
        this.utilizados = utilizados;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the uti
     */
    public String getUti() {
        return uti;
    }

    /**
     * @param uti the uti to set
     */
    public void setUti(String uti) {
        this.uti = uti;
    }

    /**
     * @return the porcentaje
     */
    public String getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    private static long serialVersionUID = 7526423451548L;

}
