package com.contravenciones.tr.persistence;
// Generated 23/01/2018 03:51:28 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivConceptos generated by hbm2java
 */
public class CivConceptos  implements java.io.Serializable {


     private BigDecimal conId;
     private CivUsuarios civUsuarios;
     private String conNombre;
     private String conDescripcion;
     private BigDecimal conTipo;
     private BigDecimal conClase;
     private BigDecimal conPrioridad;
     private Date conFechainicial;
     private Date conFechafinal;
     private BigDecimal conEstado;
     private Set civDetallecarteras = new HashSet(0);
     private Set civDatosParametricoses = new HashSet(0);
     private Set civCarterases = new HashSet(0);

    public CivConceptos() {
    }

	
    public CivConceptos(BigDecimal conId, CivUsuarios civUsuarios, String conNombre, BigDecimal conTipo, Date conFechainicial, BigDecimal conEstado) {
        this.conId = conId;
        this.civUsuarios = civUsuarios;
        this.conNombre = conNombre;
        this.conTipo = conTipo;
        this.conFechainicial = conFechainicial;
        this.conEstado = conEstado;
    }
    public CivConceptos(BigDecimal conId, CivUsuarios civUsuarios, String conNombre, String conDescripcion, BigDecimal conTipo, BigDecimal conClase, BigDecimal conPrioridad, Date conFechainicial, Date conFechafinal, BigDecimal conEstado, Set civDetallecarteras, Set civDatosParametricoses, Set civCarterases) {
       this.conId = conId;
       this.civUsuarios = civUsuarios;
       this.conNombre = conNombre;
       this.conDescripcion = conDescripcion;
       this.conTipo = conTipo;
       this.conClase = conClase;
       this.conPrioridad = conPrioridad;
       this.conFechainicial = conFechainicial;
       this.conFechafinal = conFechafinal;
       this.conEstado = conEstado;
       this.civDetallecarteras = civDetallecarteras;
       this.civDatosParametricoses = civDatosParametricoses;
       this.civCarterases = civCarterases;
    }
   
    public BigDecimal getConId() {
        return this.conId;
    }
    
    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public String getConNombre() {
        return this.conNombre;
    }
    
    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }
    public String getConDescripcion() {
        return this.conDescripcion;
    }
    
    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }
    public BigDecimal getConTipo() {
        return this.conTipo;
    }
    
    public void setConTipo(BigDecimal conTipo) {
        this.conTipo = conTipo;
    }
    public BigDecimal getConClase() {
        return this.conClase;
    }
    
    public void setConClase(BigDecimal conClase) {
        this.conClase = conClase;
    }
    public BigDecimal getConPrioridad() {
        return this.conPrioridad;
    }
    
    public void setConPrioridad(BigDecimal conPrioridad) {
        this.conPrioridad = conPrioridad;
    }
    public Date getConFechainicial() {
        return this.conFechainicial;
    }
    
    public void setConFechainicial(Date conFechainicial) {
        this.conFechainicial = conFechainicial;
    }
    public Date getConFechafinal() {
        return this.conFechafinal;
    }
    
    public void setConFechafinal(Date conFechafinal) {
        this.conFechafinal = conFechafinal;
    }
    public BigDecimal getConEstado() {
        return this.conEstado;
    }
    
    public void setConEstado(BigDecimal conEstado) {
        this.conEstado = conEstado;
    }
    public Set getCivDetallecarteras() {
        return this.civDetallecarteras;
    }
    
    public void setCivDetallecarteras(Set civDetallecarteras) {
        this.civDetallecarteras = civDetallecarteras;
    }
    public Set getCivDatosParametricoses() {
        return this.civDatosParametricoses;
    }
    
    public void setCivDatosParametricoses(Set civDatosParametricoses) {
        this.civDatosParametricoses = civDatosParametricoses;
    }
    public Set getCivCarterases() {
        return this.civCarterases;
    }
    
    public void setCivCarterases(Set civCarterases) {
        this.civCarterases = civCarterases;
    }




}


