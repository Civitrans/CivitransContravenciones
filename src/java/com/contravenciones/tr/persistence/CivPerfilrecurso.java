package com.contravenciones.tr.persistence;
// Generated 29/01/2018 01:31:54 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CivPerfilrecurso generated by hbm2java
 */
public class CivPerfilrecurso  implements java.io.Serializable {


     private CivPerfilrecursoId id;
     private CivUsuarios civUsuarios;
     private CivRecursos civRecursos;
     private CivPerfiles civPerfiles;
     private Date perrecFechaini;
     private Date perrecFechafin;

    public CivPerfilrecurso() {
    }

	
    public CivPerfilrecurso(CivPerfilrecursoId id, CivUsuarios civUsuarios, CivRecursos civRecursos) {
        this.id = id;
        this.civUsuarios = civUsuarios;
        this.civRecursos = civRecursos;
    }
    public CivPerfilrecurso(CivPerfilrecursoId id, CivUsuarios civUsuarios, CivRecursos civRecursos, CivPerfiles civPerfiles, Date perrecFechaini, Date perrecFechafin) {
       this.id = id;
       this.civUsuarios = civUsuarios;
       this.civRecursos = civRecursos;
       this.civPerfiles = civPerfiles;
       this.perrecFechaini = perrecFechaini;
       this.perrecFechafin = perrecFechafin;
    }
   
    public CivPerfilrecursoId getId() {
        return this.id;
    }
    
    public void setId(CivPerfilrecursoId id) {
        this.id = id;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivRecursos getCivRecursos() {
        return this.civRecursos;
    }
    
    public void setCivRecursos(CivRecursos civRecursos) {
        this.civRecursos = civRecursos;
    }
    public CivPerfiles getCivPerfiles() {
        return this.civPerfiles;
    }
    
    public void setCivPerfiles(CivPerfiles civPerfiles) {
        this.civPerfiles = civPerfiles;
    }
    public Date getPerrecFechaini() {
        return this.perrecFechaini;
    }
    
    public void setPerrecFechaini(Date perrecFechaini) {
        this.perrecFechaini = perrecFechaini;
    }
    public Date getPerrecFechafin() {
        return this.perrecFechafin;
    }
    
    public void setPerrecFechafin(Date perrecFechafin) {
        this.perrecFechafin = perrecFechafin;
    }




}


