package com.contravenciones.tr.persistence;
// Generated 26/01/2018 03:08:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * CivPerfiles generated by hbm2java
 */
public class CivPerfiles  implements java.io.Serializable {


     private BigDecimal perfId;
     private String perfNombre;
     private Set civUsuperfils = new HashSet(0);
     private Set civPerfilrecursos = new HashSet(0);

    public CivPerfiles() {
    }

	
    public CivPerfiles(BigDecimal perfId) {
        this.perfId = perfId;
    }
    public CivPerfiles(BigDecimal perfId, String perfNombre, Set civUsuperfils, Set civPerfilrecursos) {
       this.perfId = perfId;
       this.perfNombre = perfNombre;
       this.civUsuperfils = civUsuperfils;
       this.civPerfilrecursos = civPerfilrecursos;
    }
   
    public BigDecimal getPerfId() {
        return this.perfId;
    }
    
    public void setPerfId(BigDecimal perfId) {
        this.perfId = perfId;
    }
    public String getPerfNombre() {
        return this.perfNombre;
    }
    
    public void setPerfNombre(String perfNombre) {
        this.perfNombre = perfNombre;
    }
    public Set getCivUsuperfils() {
        return this.civUsuperfils;
    }
    
    public void setCivUsuperfils(Set civUsuperfils) {
        this.civUsuperfils = civUsuperfils;
    }
    public Set getCivPerfilrecursos() {
        return this.civPerfilrecursos;
    }
    
    public void setCivPerfilrecursos(Set civPerfilrecursos) {
        this.civPerfilrecursos = civPerfilrecursos;
    }




}


