package com.contravenciones.tr.persistence;
// Generated 22/01/2018 08:46:48 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivAgentes generated by hbm2java
 */
public class CivAgentes  implements java.io.Serializable {


     private BigDecimal ageId;
     private CivPersonas civPersonas;
     private BigDecimal ageTipo;
     private String agePlaca;
     private Date ageFechaInicio;
     private Date ageFechaFin;
     private Blob ageFirma;
     private Set civDetalleRangoComparendoses = new HashSet(0);

    public CivAgentes() {
    }

	
    public CivAgentes(BigDecimal ageId, CivPersonas civPersonas, BigDecimal ageTipo, String agePlaca, Date ageFechaInicio) {
        this.ageId = ageId;
        this.civPersonas = civPersonas;
        this.ageTipo = ageTipo;
        this.agePlaca = agePlaca;
        this.ageFechaInicio = ageFechaInicio;
    }
    public CivAgentes(BigDecimal ageId, CivPersonas civPersonas, BigDecimal ageTipo, String agePlaca, Date ageFechaInicio, Date ageFechaFin, Blob ageFirma, Set civDetalleRangoComparendoses) {
       this.ageId = ageId;
       this.civPersonas = civPersonas;
       this.ageTipo = ageTipo;
       this.agePlaca = agePlaca;
       this.ageFechaInicio = ageFechaInicio;
       this.ageFechaFin = ageFechaFin;
       this.ageFirma = ageFirma;
       this.civDetalleRangoComparendoses = civDetalleRangoComparendoses;
    }
   
    public BigDecimal getAgeId() {
        return this.ageId;
    }
    
    public void setAgeId(BigDecimal ageId) {
        this.ageId = ageId;
    }
    public CivPersonas getCivPersonas() {
        return this.civPersonas;
    }
    
    public void setCivPersonas(CivPersonas civPersonas) {
        this.civPersonas = civPersonas;
    }
    public BigDecimal getAgeTipo() {
        return this.ageTipo;
    }
    
    public void setAgeTipo(BigDecimal ageTipo) {
        this.ageTipo = ageTipo;
    }
    public String getAgePlaca() {
        return this.agePlaca;
    }
    
    public void setAgePlaca(String agePlaca) {
        this.agePlaca = agePlaca;
    }
    public Date getAgeFechaInicio() {
        return this.ageFechaInicio;
    }
    
    public void setAgeFechaInicio(Date ageFechaInicio) {
        this.ageFechaInicio = ageFechaInicio;
    }
    public Date getAgeFechaFin() {
        return this.ageFechaFin;
    }
    
    public void setAgeFechaFin(Date ageFechaFin) {
        this.ageFechaFin = ageFechaFin;
    }
    public Blob getAgeFirma() {
        return this.ageFirma;
    }
    
    public void setAgeFirma(Blob ageFirma) {
        this.ageFirma = ageFirma;
    }
    public Set getCivDetalleRangoComparendoses() {
        return this.civDetalleRangoComparendoses;
    }
    
    public void setCivDetalleRangoComparendoses(Set civDetalleRangoComparendoses) {
        this.civDetalleRangoComparendoses = civDetalleRangoComparendoses;
    }




}


