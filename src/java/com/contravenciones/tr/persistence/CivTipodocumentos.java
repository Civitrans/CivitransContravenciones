package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivTipodocumentos generated by hbm2java
 */
public class CivTipodocumentos  implements java.io.Serializable {


     private BigDecimal tipdocId;
     private BigDecimal tipdocCodigo;
     private String tipdocNombre;
     private BigDecimal tipdocEstado;
     private Date tipdocFechainicial;
     private Date tipdocFechafinal;
     private String tipdocNombrecorto;
     private Set civPersonases = new HashSet(0);

    public CivTipodocumentos() {
    }

	
    public CivTipodocumentos(BigDecimal tipdocId, BigDecimal tipdocCodigo, String tipdocNombre, BigDecimal tipdocEstado, Date tipdocFechainicial) {
        this.tipdocId = tipdocId;
        this.tipdocCodigo = tipdocCodigo;
        this.tipdocNombre = tipdocNombre;
        this.tipdocEstado = tipdocEstado;
        this.tipdocFechainicial = tipdocFechainicial;
    }
    public CivTipodocumentos(BigDecimal tipdocId, BigDecimal tipdocCodigo, String tipdocNombre, BigDecimal tipdocEstado, Date tipdocFechainicial, Date tipdocFechafinal, String tipdocNombrecorto, Set civPersonases) {
       this.tipdocId = tipdocId;
       this.tipdocCodigo = tipdocCodigo;
       this.tipdocNombre = tipdocNombre;
       this.tipdocEstado = tipdocEstado;
       this.tipdocFechainicial = tipdocFechainicial;
       this.tipdocFechafinal = tipdocFechafinal;
       this.tipdocNombrecorto = tipdocNombrecorto;
       this.civPersonases = civPersonases;
    }
   
    public BigDecimal getTipdocId() {
        return this.tipdocId;
    }
    
    public void setTipdocId(BigDecimal tipdocId) {
        this.tipdocId = tipdocId;
    }
    public BigDecimal getTipdocCodigo() {
        return this.tipdocCodigo;
    }
    
    public void setTipdocCodigo(BigDecimal tipdocCodigo) {
        this.tipdocCodigo = tipdocCodigo;
    }
    public String getTipdocNombre() {
        return this.tipdocNombre;
    }
    
    public void setTipdocNombre(String tipdocNombre) {
        this.tipdocNombre = tipdocNombre;
    }
    public BigDecimal getTipdocEstado() {
        return this.tipdocEstado;
    }
    
    public void setTipdocEstado(BigDecimal tipdocEstado) {
        this.tipdocEstado = tipdocEstado;
    }
    public Date getTipdocFechainicial() {
        return this.tipdocFechainicial;
    }
    
    public void setTipdocFechainicial(Date tipdocFechainicial) {
        this.tipdocFechainicial = tipdocFechainicial;
    }
    public Date getTipdocFechafinal() {
        return this.tipdocFechafinal;
    }
    
    public void setTipdocFechafinal(Date tipdocFechafinal) {
        this.tipdocFechafinal = tipdocFechafinal;
    }
    public String getTipdocNombrecorto() {
        return this.tipdocNombrecorto;
    }
    
    public void setTipdocNombrecorto(String tipdocNombrecorto) {
        this.tipdocNombrecorto = tipdocNombrecorto;
    }
    public Set getCivPersonases() {
        return this.civPersonases;
    }
    
    public void setCivPersonases(Set civPersonases) {
        this.civPersonases = civPersonases;
    }




}


