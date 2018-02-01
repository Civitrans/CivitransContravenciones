package com.contravenciones.tr.persistence;
// Generated 29/01/2018 01:31:54 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivDetalleRecursos generated by hbm2java
 */
public class CivDetalleRecursos  implements java.io.Serializable {


     private BigDecimal detRecId;
     private CivRecursos civRecursos;
     private String detRecDescripcion;
     private String detRecObjeto;
     private String detRecTipo;

    public CivDetalleRecursos() {
    }

	
    public CivDetalleRecursos(BigDecimal detRecId) {
        this.detRecId = detRecId;
    }
    public CivDetalleRecursos(BigDecimal detRecId, CivRecursos civRecursos, String detRecDescripcion, String detRecObjeto, String detRecTipo) {
       this.detRecId = detRecId;
       this.civRecursos = civRecursos;
       this.detRecDescripcion = detRecDescripcion;
       this.detRecObjeto = detRecObjeto;
       this.detRecTipo = detRecTipo;
    }
   
    public BigDecimal getDetRecId() {
        return this.detRecId;
    }
    
    public void setDetRecId(BigDecimal detRecId) {
        this.detRecId = detRecId;
    }
    public CivRecursos getCivRecursos() {
        return this.civRecursos;
    }
    
    public void setCivRecursos(CivRecursos civRecursos) {
        this.civRecursos = civRecursos;
    }
    public String getDetRecDescripcion() {
        return this.detRecDescripcion;
    }
    
    public void setDetRecDescripcion(String detRecDescripcion) {
        this.detRecDescripcion = detRecDescripcion;
    }
    public String getDetRecObjeto() {
        return this.detRecObjeto;
    }
    
    public void setDetRecObjeto(String detRecObjeto) {
        this.detRecObjeto = detRecObjeto;
    }
    public String getDetRecTipo() {
        return this.detRecTipo;
    }
    
    public void setDetRecTipo(String detRecTipo) {
        this.detRecTipo = detRecTipo;
    }




}


