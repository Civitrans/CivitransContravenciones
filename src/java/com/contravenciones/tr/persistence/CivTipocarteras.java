package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivTipocarteras generated by hbm2java
 */
public class CivTipocarteras  implements java.io.Serializable {


     private BigDecimal tipcarId;
     private BigDecimal tipcarCodigo;
     private String tipcarNombre;
     private String tipcarNombrecorto;
     private BigDecimal tipcarEstado;
     private Date tipcarFechainicial;
     private Date tipcarFechafinal;
     private Set civCarterases = new HashSet(0);

    public CivTipocarteras() {
    }

	
    public CivTipocarteras(BigDecimal tipcarId, BigDecimal tipcarCodigo, String tipcarNombre, BigDecimal tipcarEstado, Date tipcarFechainicial) {
        this.tipcarId = tipcarId;
        this.tipcarCodigo = tipcarCodigo;
        this.tipcarNombre = tipcarNombre;
        this.tipcarEstado = tipcarEstado;
        this.tipcarFechainicial = tipcarFechainicial;
    }
    public CivTipocarteras(BigDecimal tipcarId, BigDecimal tipcarCodigo, String tipcarNombre, String tipcarNombrecorto, BigDecimal tipcarEstado, Date tipcarFechainicial, Date tipcarFechafinal, Set civCarterases) {
       this.tipcarId = tipcarId;
       this.tipcarCodigo = tipcarCodigo;
       this.tipcarNombre = tipcarNombre;
       this.tipcarNombrecorto = tipcarNombrecorto;
       this.tipcarEstado = tipcarEstado;
       this.tipcarFechainicial = tipcarFechainicial;
       this.tipcarFechafinal = tipcarFechafinal;
       this.civCarterases = civCarterases;
    }
   
    public BigDecimal getTipcarId() {
        return this.tipcarId;
    }
    
    public void setTipcarId(BigDecimal tipcarId) {
        this.tipcarId = tipcarId;
    }
    public BigDecimal getTipcarCodigo() {
        return this.tipcarCodigo;
    }
    
    public void setTipcarCodigo(BigDecimal tipcarCodigo) {
        this.tipcarCodigo = tipcarCodigo;
    }
    public String getTipcarNombre() {
        return this.tipcarNombre;
    }
    
    public void setTipcarNombre(String tipcarNombre) {
        this.tipcarNombre = tipcarNombre;
    }
    public String getTipcarNombrecorto() {
        return this.tipcarNombrecorto;
    }
    
    public void setTipcarNombrecorto(String tipcarNombrecorto) {
        this.tipcarNombrecorto = tipcarNombrecorto;
    }
    public BigDecimal getTipcarEstado() {
        return this.tipcarEstado;
    }
    
    public void setTipcarEstado(BigDecimal tipcarEstado) {
        this.tipcarEstado = tipcarEstado;
    }
    public Date getTipcarFechainicial() {
        return this.tipcarFechainicial;
    }
    
    public void setTipcarFechainicial(Date tipcarFechainicial) {
        this.tipcarFechainicial = tipcarFechainicial;
    }
    public Date getTipcarFechafinal() {
        return this.tipcarFechafinal;
    }
    
    public void setTipcarFechafinal(Date tipcarFechafinal) {
        this.tipcarFechafinal = tipcarFechafinal;
    }
    public Set getCivCarterases() {
        return this.civCarterases;
    }
    
    public void setCivCarterases(Set civCarterases) {
        this.civCarterases = civCarterases;
    }




}


