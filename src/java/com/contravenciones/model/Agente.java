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
public class Agente implements Serializable {

    private static long serialVersionUID = 7526423451548L;

    private int perId;
    private int perTipodocumento;
    private String perDocumento;
    private Date perFechanac;
    private String perGruposanguineo;
    private String perRh;
    private String perSexo;
    private String perNombre1;
    private String perNombre2;
    private String perApellido1;
    private String perApellido2;
    private String perEmail;
    private String perCelular;
    private int perLugarnacimiento;
    private Date perFechaexp;
    private int perEstado;
    private Date perFechainicial;
    private Date perFechafinal;
    private Date perFechaproceso;
    private int usuId;
    private int perLugarexpedicion;
    private int ageId;
    private int ageTipo;
    private String agePlaca;
    private Date ageFechaInicio;
    private Date ageFechaFin;
    private int estadoAgente;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the perId
     */
    public int getPerId() {
        return perId;
    }

    /**
     * @param perId the perId to set
     */
    public void setPerId(int perId) {
        this.perId = perId;
    }

    /**
     * @return the perTipodocumento
     */
    public int getPerTipodocumento() {
        return perTipodocumento;
    }

    /**
     * @param perTipodocumento the perTipodocumento to set
     */
    public void setPerTipodocumento(int perTipodocumento) {
        this.perTipodocumento = perTipodocumento;
    }

    /**
     * @return the perDocumento
     */
    public String getPerDocumento() {
        return perDocumento;
    }

    /**
     * @param perDocumento the perDocumento to set
     */
    public void setPerDocumento(String perDocumento) {
        this.perDocumento = perDocumento;
    }

    /**
     * @return the perFechanac
     */
    public Date getPerFechanac() {
        return perFechanac;
    }

    /**
     * @param perFechanac the perFechanac to set
     */
    public void setPerFechanac(Date perFechanac) {
        this.perFechanac = perFechanac;
    }

    /**
     * @return the perGruposanguineo
     */
    public String getPerGruposanguineo() {
        return perGruposanguineo;
    }

    /**
     * @param perGruposanguineo the perGruposanguineo to set
     */
    public void setPerGruposanguineo(String perGruposanguineo) {
        this.perGruposanguineo = perGruposanguineo;
    }

    /**
     * @return the perRh
     */
    public String getPerRh() {
        return perRh;
    }

    /**
     * @param perRh the perRh to set
     */
    public void setPerRh(String perRh) {
        this.perRh = perRh;
    }

    /**
     * @return the perSexo
     */
    public String getPerSexo() {
        return perSexo;
    }

    /**
     * @param perSexo the perSexo to set
     */
    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    /**
     * @return the perNombre1
     */
    public String getPerNombre1() {
        return perNombre1;
    }

    /**
     * @param perNombre1 the perNombre1 to set
     */
    public void setPerNombre1(String perNombre1) {
        this.perNombre1 = perNombre1;
    }

    /**
     * @return the perNombre2
     */
    public String getPerNombre2() {
        return perNombre2;
    }

    /**
     * @param perNombre2 the perNombre2 to set
     */
    public void setPerNombre2(String perNombre2) {
        this.perNombre2 = perNombre2;
    }

    /**
     * @return the perApellido1
     */
    public String getPerApellido1() {
        return perApellido1;
    }

    /**
     * @param perApellido1 the perApellido1 to set
     */
    public void setPerApellido1(String perApellido1) {
        this.perApellido1 = perApellido1;
    }

    /**
     * @return the perApellido2
     */
    public String getPerApellido2() {
        return perApellido2;
    }

    /**
     * @param perApellido2 the perApellido2 to set
     */
    public void setPerApellido2(String perApellido2) {
        this.perApellido2 = perApellido2;
    }

    /**
     * @return the perEmail
     */
    public String getPerEmail() {
        return perEmail;
    }

    /**
     * @param perEmail the perEmail to set
     */
    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    /**
     * @return the perCelular
     */
    public String getPerCelular() {
        return perCelular;
    }

    /**
     * @param perCelular the perCelular to set
     */
    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    /**
     * @return the perLugarnacimiento
     */
    public int getPerLugarnacimiento() {
        return perLugarnacimiento;
    }

    /**
     * @param perLugarnacimiento the perLugarnacimiento to set
     */
    public void setPerLugarnacimiento(int perLugarnacimiento) {
        this.perLugarnacimiento = perLugarnacimiento;
    }

    /**
     * @return the perFechaexp
     */
    public Date getPerFechaexp() {
        return perFechaexp;
    }

    /**
     * @param perFechaexp the perFechaexp to set
     */
    public void setPerFechaexp(Date perFechaexp) {
        this.perFechaexp = perFechaexp;
    }

    /**
     * @return the perEstado
     */
    public int getPerEstado() {
        return perEstado;
    }

    /**
     * @param perEstado the perEstado to set
     */
    public void setPerEstado(int perEstado) {
        this.perEstado = perEstado;
    }

    /**
     * @return the perFechainicial
     */
    public Date getPerFechainicial() {
        return perFechainicial;
    }

    /**
     * @param perFechainicial the perFechainicial to set
     */
    public void setPerFechainicial(Date perFechainicial) {
        this.perFechainicial = perFechainicial;
    }

    /**
     * @return the perFechafinal
     */
    public Date getPerFechafinal() {
        return perFechafinal;
    }

    /**
     * @param perFechafinal the perFechafinal to set
     */
    public void setPerFechafinal(Date perFechafinal) {
        this.perFechafinal = perFechafinal;
    }

    /**
     * @return the perFechaproceso
     */
    public Date getPerFechaproceso() {
        return perFechaproceso;
    }

    /**
     * @param perFechaproceso the perFechaproceso to set
     */
    public void setPerFechaproceso(Date perFechaproceso) {
        this.perFechaproceso = perFechaproceso;
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
     * @return the perLugarexpedicion
     */
    public int getPerLugarexpedicion() {
        return perLugarexpedicion;
    }

    /**
     * @param perLugarexpedicion the perLugarexpedicion to set
     */
    public void setPerLugarexpedicion(int perLugarexpedicion) {
        this.perLugarexpedicion = perLugarexpedicion;
    }

    /**
     * @return the ageId
     */
    public int getAgeId() {
        return ageId;
    }

    /**
     * @param ageId the ageId to set
     */
    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    /**
     * @return the ageTipo
     */
    public int getAgeTipo() {
        return ageTipo;
    }

    /**
     * @param ageTipo the ageTipo to set
     */
    public void setAgeTipo(int ageTipo) {
        this.ageTipo = ageTipo;
    }

    /**
     * @return the agePlaca
     */
    public String getAgePlaca() {
        return agePlaca;
    }

    /**
     * @param agePlaca the agePlaca to set
     */
    public void setAgePlaca(String agePlaca) {
        this.agePlaca = agePlaca;
    }

    /**
     * @return the ageFechaInicio
     */
    public Date getAgeFechaInicio() {
        return ageFechaInicio;
    }

    /**
     * @param ageFechaInicio the ageFechaInicio to set
     */
    public void setAgeFechaInicio(Date ageFechaInicio) {
        this.ageFechaInicio = ageFechaInicio;
    }

    /**
     * @return the ageFechaFin
     */
    public Date getAgeFechaFin() {
        return ageFechaFin;
    }

    /**
     * @param ageFechaFin the ageFechaFin to set
     */
    public void setAgeFechaFin(Date ageFechaFin) {
        this.ageFechaFin = ageFechaFin;
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
}
