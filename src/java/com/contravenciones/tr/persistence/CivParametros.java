package com.contravenciones.tr.persistence;
// Generated 20/01/2018 11:02:54 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivParametros generated by hbm2java
 */
public class CivParametros  implements java.io.Serializable {


     private BigDecimal parId;
     private CivGrupos civGrupos;
     private String parNombre;
     private String parNombrecorto;
     private BigDecimal parCodigo;
     private BigDecimal parSubcodigo;
     private BigDecimal parPrioridad;
     private BigDecimal parEstado;
     private Date parFechainicial;
     private Date parFechafinal;
     private Date parFechaproceso;
     private BigDecimal usuId;

    public CivParametros() {
    }

	
    public CivParametros(BigDecimal parId) {
        this.parId = parId;
    }
    public CivParametros(BigDecimal parId, CivGrupos civGrupos, String parNombre, String parNombrecorto, BigDecimal parCodigo, BigDecimal parSubcodigo, BigDecimal parPrioridad, BigDecimal parEstado, Date parFechainicial, Date parFechafinal, Date parFechaproceso, BigDecimal usuId) {
       this.parId = parId;
       this.civGrupos = civGrupos;
       this.parNombre = parNombre;
       this.parNombrecorto = parNombrecorto;
       this.parCodigo = parCodigo;
       this.parSubcodigo = parSubcodigo;
       this.parPrioridad = parPrioridad;
       this.parEstado = parEstado;
       this.parFechainicial = parFechainicial;
       this.parFechafinal = parFechafinal;
       this.parFechaproceso = parFechaproceso;
       this.usuId = usuId;
    }
   
    public BigDecimal getParId() {
        return this.parId;
    }
    
    public void setParId(BigDecimal parId) {
        this.parId = parId;
    }
    public CivGrupos getCivGrupos() {
        return this.civGrupos;
    }
    
    public void setCivGrupos(CivGrupos civGrupos) {
        this.civGrupos = civGrupos;
    }
    public String getParNombre() {
        return this.parNombre;
    }
    
    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }
    public String getParNombrecorto() {
        return this.parNombrecorto;
    }
    
    public void setParNombrecorto(String parNombrecorto) {
        this.parNombrecorto = parNombrecorto;
    }
    public BigDecimal getParCodigo() {
        return this.parCodigo;
    }
    
    public void setParCodigo(BigDecimal parCodigo) {
        this.parCodigo = parCodigo;
    }
    public BigDecimal getParSubcodigo() {
        return this.parSubcodigo;
    }
    
    public void setParSubcodigo(BigDecimal parSubcodigo) {
        this.parSubcodigo = parSubcodigo;
    }
    public BigDecimal getParPrioridad() {
        return this.parPrioridad;
    }
    
    public void setParPrioridad(BigDecimal parPrioridad) {
        this.parPrioridad = parPrioridad;
    }
    public BigDecimal getParEstado() {
        return this.parEstado;
    }
    
    public void setParEstado(BigDecimal parEstado) {
        this.parEstado = parEstado;
    }
    public Date getParFechainicial() {
        return this.parFechainicial;
    }
    
    public void setParFechainicial(Date parFechainicial) {
        this.parFechainicial = parFechainicial;
    }
    public Date getParFechafinal() {
        return this.parFechafinal;
    }
    
    public void setParFechafinal(Date parFechafinal) {
        this.parFechafinal = parFechafinal;
    }
    public Date getParFechaproceso() {
        return this.parFechaproceso;
    }
    
    public void setParFechaproceso(Date parFechaproceso) {
        this.parFechaproceso = parFechaproceso;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }




}


