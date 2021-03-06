package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivEstructuraSimit generated by hbm2java
 */
public class CivEstructuraSimit  implements java.io.Serializable {


     private BigDecimal estrId;
     private String estrNombreCampo;
     private BigDecimal estrIndice;
     private String estrDescripcion;
     private BigDecimal estrLongitudMin;
     private BigDecimal estrLongitudMax;
     private String estrTipoDato;
     private String estrObligatorio;
     private String estrObservaciones;
     private BigDecimal estrTipo;

    public CivEstructuraSimit() {
    }

	
    public CivEstructuraSimit(BigDecimal estrId) {
        this.estrId = estrId;
    }
    public CivEstructuraSimit(BigDecimal estrId, String estrNombreCampo, BigDecimal estrIndice, String estrDescripcion, BigDecimal estrLongitudMin, BigDecimal estrLongitudMax, String estrTipoDato, String estrObligatorio, String estrObservaciones, BigDecimal estrTipo) {
       this.estrId = estrId;
       this.estrNombreCampo = estrNombreCampo;
       this.estrIndice = estrIndice;
       this.estrDescripcion = estrDescripcion;
       this.estrLongitudMin = estrLongitudMin;
       this.estrLongitudMax = estrLongitudMax;
       this.estrTipoDato = estrTipoDato;
       this.estrObligatorio = estrObligatorio;
       this.estrObservaciones = estrObservaciones;
       this.estrTipo = estrTipo;
    }
   
    public BigDecimal getEstrId() {
        return this.estrId;
    }
    
    public void setEstrId(BigDecimal estrId) {
        this.estrId = estrId;
    }
    public String getEstrNombreCampo() {
        return this.estrNombreCampo;
    }
    
    public void setEstrNombreCampo(String estrNombreCampo) {
        this.estrNombreCampo = estrNombreCampo;
    }
    public BigDecimal getEstrIndice() {
        return this.estrIndice;
    }
    
    public void setEstrIndice(BigDecimal estrIndice) {
        this.estrIndice = estrIndice;
    }
    public String getEstrDescripcion() {
        return this.estrDescripcion;
    }
    
    public void setEstrDescripcion(String estrDescripcion) {
        this.estrDescripcion = estrDescripcion;
    }
    public BigDecimal getEstrLongitudMin() {
        return this.estrLongitudMin;
    }
    
    public void setEstrLongitudMin(BigDecimal estrLongitudMin) {
        this.estrLongitudMin = estrLongitudMin;
    }
    public BigDecimal getEstrLongitudMax() {
        return this.estrLongitudMax;
    }
    
    public void setEstrLongitudMax(BigDecimal estrLongitudMax) {
        this.estrLongitudMax = estrLongitudMax;
    }
    public String getEstrTipoDato() {
        return this.estrTipoDato;
    }
    
    public void setEstrTipoDato(String estrTipoDato) {
        this.estrTipoDato = estrTipoDato;
    }
    public String getEstrObligatorio() {
        return this.estrObligatorio;
    }
    
    public void setEstrObligatorio(String estrObligatorio) {
        this.estrObligatorio = estrObligatorio;
    }
    public String getEstrObservaciones() {
        return this.estrObservaciones;
    }
    
    public void setEstrObservaciones(String estrObservaciones) {
        this.estrObservaciones = estrObservaciones;
    }
    public BigDecimal getEstrTipo() {
        return this.estrTipo;
    }
    
    public void setEstrTipo(BigDecimal estrTipo) {
        this.estrTipo = estrTipo;
    }




}


