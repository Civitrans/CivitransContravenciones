package com.contravenciones.tr.persistence;
// Generated 30/12/2017 12:47:12 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivPoblados generated by hbm2java
 */
public class CivPoblados  implements java.io.Serializable {


     private BigDecimal pobId;
     private String pobNombre;
     private BigDecimal pobCodpoblado;
     private BigDecimal munId;

    public CivPoblados() {
    }

	
    public CivPoblados(BigDecimal pobId) {
        this.pobId = pobId;
    }
    public CivPoblados(BigDecimal pobId, String pobNombre, BigDecimal pobCodpoblado, BigDecimal munId) {
       this.pobId = pobId;
       this.pobNombre = pobNombre;
       this.pobCodpoblado = pobCodpoblado;
       this.munId = munId;
    }
   
    public BigDecimal getPobId() {
        return this.pobId;
    }
    
    public void setPobId(BigDecimal pobId) {
        this.pobId = pobId;
    }
    public String getPobNombre() {
        return this.pobNombre;
    }
    
    public void setPobNombre(String pobNombre) {
        this.pobNombre = pobNombre;
    }
    public BigDecimal getPobCodpoblado() {
        return this.pobCodpoblado;
    }
    
    public void setPobCodpoblado(BigDecimal pobCodpoblado) {
        this.pobCodpoblado = pobCodpoblado;
    }
    public BigDecimal getMunId() {
        return this.munId;
    }
    
    public void setMunId(BigDecimal munId) {
        this.munId = munId;
    }




}


