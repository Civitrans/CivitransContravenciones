package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CivPerfilrecurso generated by hbm2java
 */
public class CivPerfilrecurso  implements java.io.Serializable {


     private CivPerfilrecursoId id;
     private CivUsuarios civUsuarios;
     private CivRecursos civRecursos;
     private Date perrecFechaini;
     private Date perrecFechafin;

    public CivPerfilrecurso() {
    }

	
    public CivPerfilrecurso(CivPerfilrecursoId id, CivUsuarios civUsuarios, CivRecursos civRecursos) {
        this.id = id;
        this.civUsuarios = civUsuarios;
        this.civRecursos = civRecursos;
    }
    public CivPerfilrecurso(CivPerfilrecursoId id, CivUsuarios civUsuarios, CivRecursos civRecursos, Date perrecFechaini, Date perrecFechafin) {
       this.id = id;
       this.civUsuarios = civUsuarios;
       this.civRecursos = civRecursos;
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


