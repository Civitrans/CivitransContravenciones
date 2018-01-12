package com.contravenciones.tr.persistence;
// Generated 30/12/2017 12:47:12 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivRecursos generated by hbm2java
 */
public class CivRecursos  implements java.io.Serializable {


     private BigDecimal recId;
     private CivModulos civModulos;
     private String recNombre;
     private String recDescripcion;
     private Date recFechainicial;
     private Date recFechafin;
     private BigDecimal recEstado;
     private String recCarpeta;
     private BigDecimal recTipo;
     private Set civDetalleRecUsus = new HashSet(0);
     private Set civPerfilrecursos = new HashSet(0);
     private Set civDetalleRecursoses = new HashSet(0);

    public CivRecursos() {
    }

	
    public CivRecursos(BigDecimal recId) {
        this.recId = recId;
    }
    public CivRecursos(BigDecimal recId, CivModulos civModulos, String recNombre, String recDescripcion, Date recFechainicial, Date recFechafin, BigDecimal recEstado, String recCarpeta, BigDecimal recTipo, Set civDetalleRecUsus, Set civPerfilrecursos, Set civDetalleRecursoses) {
       this.recId = recId;
       this.civModulos = civModulos;
       this.recNombre = recNombre;
       this.recDescripcion = recDescripcion;
       this.recFechainicial = recFechainicial;
       this.recFechafin = recFechafin;
       this.recEstado = recEstado;
       this.recCarpeta = recCarpeta;
       this.recTipo = recTipo;
       this.civDetalleRecUsus = civDetalleRecUsus;
       this.civPerfilrecursos = civPerfilrecursos;
       this.civDetalleRecursoses = civDetalleRecursoses;
    }
   
    public BigDecimal getRecId() {
        return this.recId;
    }
    
    public void setRecId(BigDecimal recId) {
        this.recId = recId;
    }
    public CivModulos getCivModulos() {
        return this.civModulos;
    }
    
    public void setCivModulos(CivModulos civModulos) {
        this.civModulos = civModulos;
    }
    public String getRecNombre() {
        return this.recNombre;
    }
    
    public void setRecNombre(String recNombre) {
        this.recNombre = recNombre;
    }
    public String getRecDescripcion() {
        return this.recDescripcion;
    }
    
    public void setRecDescripcion(String recDescripcion) {
        this.recDescripcion = recDescripcion;
    }
    public Date getRecFechainicial() {
        return this.recFechainicial;
    }
    
    public void setRecFechainicial(Date recFechainicial) {
        this.recFechainicial = recFechainicial;
    }
    public Date getRecFechafin() {
        return this.recFechafin;
    }
    
    public void setRecFechafin(Date recFechafin) {
        this.recFechafin = recFechafin;
    }
    public BigDecimal getRecEstado() {
        return this.recEstado;
    }
    
    public void setRecEstado(BigDecimal recEstado) {
        this.recEstado = recEstado;
    }
    public String getRecCarpeta() {
        return this.recCarpeta;
    }
    
    public void setRecCarpeta(String recCarpeta) {
        this.recCarpeta = recCarpeta;
    }
    public BigDecimal getRecTipo() {
        return this.recTipo;
    }
    
    public void setRecTipo(BigDecimal recTipo) {
        this.recTipo = recTipo;
    }
    public Set getCivDetalleRecUsus() {
        return this.civDetalleRecUsus;
    }
    
    public void setCivDetalleRecUsus(Set civDetalleRecUsus) {
        this.civDetalleRecUsus = civDetalleRecUsus;
    }
    public Set getCivPerfilrecursos() {
        return this.civPerfilrecursos;
    }
    
    public void setCivPerfilrecursos(Set civPerfilrecursos) {
        this.civPerfilrecursos = civPerfilrecursos;
    }
    public Set getCivDetalleRecursoses() {
        return this.civDetalleRecursoses;
    }
    
    public void setCivDetalleRecursoses(Set civDetalleRecursoses) {
        this.civDetalleRecursoses = civDetalleRecursoses;
    }




}

