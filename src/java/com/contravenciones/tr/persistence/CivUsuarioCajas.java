package com.contravenciones.tr.persistence;
// Generated 29/01/2018 01:31:54 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CivUsuarioCajas generated by hbm2java
 */
public class CivUsuarioCajas  implements java.io.Serializable {


     private CivUsuarioCajasId id;
     private CivUsuarios civUsuarios;
     private CivSedes civSedes;
     private CivCajas civCajas;
     private Date usucajFechaInicio;
     private Date usucajFechaFin;

    public CivUsuarioCajas() {
    }

	
    public CivUsuarioCajas(CivUsuarioCajasId id, CivUsuarios civUsuarios, CivSedes civSedes, CivCajas civCajas, Date usucajFechaInicio) {
        this.id = id;
        this.civUsuarios = civUsuarios;
        this.civSedes = civSedes;
        this.civCajas = civCajas;
        this.usucajFechaInicio = usucajFechaInicio;
    }
    public CivUsuarioCajas(CivUsuarioCajasId id, CivUsuarios civUsuarios, CivSedes civSedes, CivCajas civCajas, Date usucajFechaInicio, Date usucajFechaFin) {
       this.id = id;
       this.civUsuarios = civUsuarios;
       this.civSedes = civSedes;
       this.civCajas = civCajas;
       this.usucajFechaInicio = usucajFechaInicio;
       this.usucajFechaFin = usucajFechaFin;
    }
   
    public CivUsuarioCajasId getId() {
        return this.id;
    }
    
    public void setId(CivUsuarioCajasId id) {
        this.id = id;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivSedes getCivSedes() {
        return this.civSedes;
    }
    
    public void setCivSedes(CivSedes civSedes) {
        this.civSedes = civSedes;
    }
    public CivCajas getCivCajas() {
        return this.civCajas;
    }
    
    public void setCivCajas(CivCajas civCajas) {
        this.civCajas = civCajas;
    }
    public Date getUsucajFechaInicio() {
        return this.usucajFechaInicio;
    }
    
    public void setUsucajFechaInicio(Date usucajFechaInicio) {
        this.usucajFechaInicio = usucajFechaInicio;
    }
    public Date getUsucajFechaFin() {
        return this.usucajFechaFin;
    }
    
    public void setUsucajFechaFin(Date usucajFechaFin) {
        this.usucajFechaFin = usucajFechaFin;
    }




}


