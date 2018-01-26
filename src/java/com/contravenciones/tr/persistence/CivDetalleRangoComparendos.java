package com.contravenciones.tr.persistence;
// Generated 26/01/2018 03:08:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivDetalleRangoComparendos generated by hbm2java
 */
public class CivDetalleRangoComparendos  implements java.io.Serializable {


     private BigDecimal dtranId;
     private CivRangosComparendos civRangosComparendos;
     private CivAgentes civAgentes;
     private String dtranNumero;
     private BigDecimal dtranEstado;
     private Date dtranFechaInicial;
     private BigDecimal usuId;
     private Date dtranFechaUso;
     private String dtranObservaciones;

    public CivDetalleRangoComparendos() {
    }

	
    public CivDetalleRangoComparendos(BigDecimal dtranId, CivRangosComparendos civRangosComparendos, String dtranNumero, BigDecimal dtranEstado, BigDecimal usuId) {
        this.dtranId = dtranId;
        this.civRangosComparendos = civRangosComparendos;
        this.dtranNumero = dtranNumero;
        this.dtranEstado = dtranEstado;
        this.usuId = usuId;
    }
    public CivDetalleRangoComparendos(BigDecimal dtranId, CivRangosComparendos civRangosComparendos, CivAgentes civAgentes, String dtranNumero, BigDecimal dtranEstado, Date dtranFechaInicial, BigDecimal usuId, Date dtranFechaUso, String dtranObservaciones) {
       this.dtranId = dtranId;
       this.civRangosComparendos = civRangosComparendos;
       this.civAgentes = civAgentes;
       this.dtranNumero = dtranNumero;
       this.dtranEstado = dtranEstado;
       this.dtranFechaInicial = dtranFechaInicial;
       this.usuId = usuId;
       this.dtranFechaUso = dtranFechaUso;
       this.dtranObservaciones = dtranObservaciones;
    }
   
    public BigDecimal getDtranId() {
        return this.dtranId;
    }
    
    public void setDtranId(BigDecimal dtranId) {
        this.dtranId = dtranId;
    }
    public CivRangosComparendos getCivRangosComparendos() {
        return this.civRangosComparendos;
    }
    
    public void setCivRangosComparendos(CivRangosComparendos civRangosComparendos) {
        this.civRangosComparendos = civRangosComparendos;
    }
    public CivAgentes getCivAgentes() {
        return this.civAgentes;
    }
    
    public void setCivAgentes(CivAgentes civAgentes) {
        this.civAgentes = civAgentes;
    }
    public String getDtranNumero() {
        return this.dtranNumero;
    }
    
    public void setDtranNumero(String dtranNumero) {
        this.dtranNumero = dtranNumero;
    }
    public BigDecimal getDtranEstado() {
        return this.dtranEstado;
    }
    
    public void setDtranEstado(BigDecimal dtranEstado) {
        this.dtranEstado = dtranEstado;
    }
    public Date getDtranFechaInicial() {
        return this.dtranFechaInicial;
    }
    
    public void setDtranFechaInicial(Date dtranFechaInicial) {
        this.dtranFechaInicial = dtranFechaInicial;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }
    public Date getDtranFechaUso() {
        return this.dtranFechaUso;
    }
    
    public void setDtranFechaUso(Date dtranFechaUso) {
        this.dtranFechaUso = dtranFechaUso;
    }
    public String getDtranObservaciones() {
        return this.dtranObservaciones;
    }
    
    public void setDtranObservaciones(String dtranObservaciones) {
        this.dtranObservaciones = dtranObservaciones;
    }




}


