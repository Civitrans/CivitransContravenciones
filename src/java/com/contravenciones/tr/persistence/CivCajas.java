package com.contravenciones.tr.persistence;
// Generated 15/01/2018 03:21:52 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivCajas generated by hbm2java
 */
public class CivCajas  implements java.io.Serializable {


     private BigDecimal cajId;
     private String cajNombre;
     private BigDecimal sedId;
     private Date cajFechaInicio;
     private Date cajFechaFin;
     private BigDecimal cajEstado;
     private Set civUsuarioCajases = new HashSet(0);

    public CivCajas() {
    }

	
    public CivCajas(BigDecimal cajId) {
        this.cajId = cajId;
    }
    public CivCajas(BigDecimal cajId, String cajNombre, BigDecimal sedId, Date cajFechaInicio, Date cajFechaFin, BigDecimal cajEstado, Set civUsuarioCajases) {
       this.cajId = cajId;
       this.cajNombre = cajNombre;
       this.sedId = sedId;
       this.cajFechaInicio = cajFechaInicio;
       this.cajFechaFin = cajFechaFin;
       this.cajEstado = cajEstado;
       this.civUsuarioCajases = civUsuarioCajases;
    }
   
    public BigDecimal getCajId() {
        return this.cajId;
    }
    
    public void setCajId(BigDecimal cajId) {
        this.cajId = cajId;
    }
    public String getCajNombre() {
        return this.cajNombre;
    }
    
    public void setCajNombre(String cajNombre) {
        this.cajNombre = cajNombre;
    }
    public BigDecimal getSedId() {
        return this.sedId;
    }
    
    public void setSedId(BigDecimal sedId) {
        this.sedId = sedId;
    }
    public Date getCajFechaInicio() {
        return this.cajFechaInicio;
    }
    
    public void setCajFechaInicio(Date cajFechaInicio) {
        this.cajFechaInicio = cajFechaInicio;
    }
    public Date getCajFechaFin() {
        return this.cajFechaFin;
    }
    
    public void setCajFechaFin(Date cajFechaFin) {
        this.cajFechaFin = cajFechaFin;
    }
    public BigDecimal getCajEstado() {
        return this.cajEstado;
    }
    
    public void setCajEstado(BigDecimal cajEstado) {
        this.cajEstado = cajEstado;
    }
    public Set getCivUsuarioCajases() {
        return this.civUsuarioCajases;
    }
    
    public void setCivUsuarioCajases(Set civUsuarioCajases) {
        this.civUsuarioCajases = civUsuarioCajases;
    }




}


