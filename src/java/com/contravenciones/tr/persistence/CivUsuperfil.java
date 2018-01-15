package com.contravenciones.tr.persistence;
// Generated 15/01/2018 11:03:58 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivUsuperfil generated by hbm2java
 */
public class CivUsuperfil  implements java.io.Serializable {


     private BigDecimal usuperId;
     private CivPerfiles civPerfiles;
     private CivUsuarios civUsuarios;
     private Date usuperFechaini;
     private Date usuperFechafin;

    public CivUsuperfil() {
    }

	
    public CivUsuperfil(BigDecimal usuperId, CivPerfiles civPerfiles, CivUsuarios civUsuarios) {
        this.usuperId = usuperId;
        this.civPerfiles = civPerfiles;
        this.civUsuarios = civUsuarios;
    }
    public CivUsuperfil(BigDecimal usuperId, CivPerfiles civPerfiles, CivUsuarios civUsuarios, Date usuperFechaini, Date usuperFechafin) {
       this.usuperId = usuperId;
       this.civPerfiles = civPerfiles;
       this.civUsuarios = civUsuarios;
       this.usuperFechaini = usuperFechaini;
       this.usuperFechafin = usuperFechafin;
    }
   
    public BigDecimal getUsuperId() {
        return this.usuperId;
    }
    
    public void setUsuperId(BigDecimal usuperId) {
        this.usuperId = usuperId;
    }
    public CivPerfiles getCivPerfiles() {
        return this.civPerfiles;
    }
    
    public void setCivPerfiles(CivPerfiles civPerfiles) {
        this.civPerfiles = civPerfiles;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public Date getUsuperFechaini() {
        return this.usuperFechaini;
    }
    
    public void setUsuperFechaini(Date usuperFechaini) {
        this.usuperFechaini = usuperFechaini;
    }
    public Date getUsuperFechafin() {
        return this.usuperFechafin;
    }
    
    public void setUsuperFechafin(Date usuperFechafin) {
        this.usuperFechafin = usuperFechafin;
    }




}


