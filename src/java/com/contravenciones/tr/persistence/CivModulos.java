package com.contravenciones.tr.persistence;
// Generated 15/01/2018 11:03:58 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivModulos generated by hbm2java
 */
public class CivModulos  implements java.io.Serializable {


     private BigDecimal modId;
     private String modNombre;
     private Date modFechaini;
     private Date modFechafin;
     private BigDecimal modEstado;
     private String icon;
     private Set civRecursoses = new HashSet(0);

    public CivModulos() {
    }

	
    public CivModulos(BigDecimal modId) {
        this.modId = modId;
    }
    public CivModulos(BigDecimal modId, String modNombre, Date modFechaini, Date modFechafin, BigDecimal modEstado, String icon, Set civRecursoses) {
       this.modId = modId;
       this.modNombre = modNombre;
       this.modFechaini = modFechaini;
       this.modFechafin = modFechafin;
       this.modEstado = modEstado;
       this.icon = icon;
       this.civRecursoses = civRecursoses;
    }
   
    public BigDecimal getModId() {
        return this.modId;
    }
    
    public void setModId(BigDecimal modId) {
        this.modId = modId;
    }
    public String getModNombre() {
        return this.modNombre;
    }
    
    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }
    public Date getModFechaini() {
        return this.modFechaini;
    }
    
    public void setModFechaini(Date modFechaini) {
        this.modFechaini = modFechaini;
    }
    public Date getModFechafin() {
        return this.modFechafin;
    }
    
    public void setModFechafin(Date modFechafin) {
        this.modFechafin = modFechafin;
    }
    public BigDecimal getModEstado() {
        return this.modEstado;
    }
    
    public void setModEstado(BigDecimal modEstado) {
        this.modEstado = modEstado;
    }
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Set getCivRecursoses() {
        return this.civRecursoses;
    }
    
    public void setCivRecursoses(Set civRecursoses) {
        this.civRecursoses = civRecursoses;
    }




}


