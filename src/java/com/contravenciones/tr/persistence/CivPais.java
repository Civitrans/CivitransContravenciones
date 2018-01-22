package com.contravenciones.tr.persistence;
// Generated 22/01/2018 08:46:48 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivPais generated by hbm2java
 */
public class CivPais  implements java.io.Serializable {


     private BigDecimal paiId;
     private String paiNombre;
     private BigDecimal paiCodpais;

    public CivPais() {
    }

	
    public CivPais(BigDecimal paiId) {
        this.paiId = paiId;
    }
    public CivPais(BigDecimal paiId, String paiNombre, BigDecimal paiCodpais) {
       this.paiId = paiId;
       this.paiNombre = paiNombre;
       this.paiCodpais = paiCodpais;
    }
   
    public BigDecimal getPaiId() {
        return this.paiId;
    }
    
    public void setPaiId(BigDecimal paiId) {
        this.paiId = paiId;
    }
    public String getPaiNombre() {
        return this.paiNombre;
    }
    
    public void setPaiNombre(String paiNombre) {
        this.paiNombre = paiNombre;
    }
    public BigDecimal getPaiCodpais() {
        return this.paiCodpais;
    }
    
    public void setPaiCodpais(BigDecimal paiCodpais) {
        this.paiCodpais = paiCodpais;
    }




}


