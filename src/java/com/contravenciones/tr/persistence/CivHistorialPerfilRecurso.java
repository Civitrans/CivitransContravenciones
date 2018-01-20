package com.contravenciones.tr.persistence;
// Generated 20/01/2018 11:02:54 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivHistorialPerfilRecurso generated by hbm2java
 */
public class CivHistorialPerfilRecurso  implements java.io.Serializable {


     private BigDecimal hisPerfRecId;
     private BigDecimal perfId;
     private BigDecimal recId;
     private BigDecimal usuId;
     private Date hisFechaIni;
     private Date hisFechaFin;

    public CivHistorialPerfilRecurso() {
    }

	
    public CivHistorialPerfilRecurso(BigDecimal hisPerfRecId) {
        this.hisPerfRecId = hisPerfRecId;
    }
    public CivHistorialPerfilRecurso(BigDecimal hisPerfRecId, BigDecimal perfId, BigDecimal recId, BigDecimal usuId, Date hisFechaIni, Date hisFechaFin) {
       this.hisPerfRecId = hisPerfRecId;
       this.perfId = perfId;
       this.recId = recId;
       this.usuId = usuId;
       this.hisFechaIni = hisFechaIni;
       this.hisFechaFin = hisFechaFin;
    }
   
    public BigDecimal getHisPerfRecId() {
        return this.hisPerfRecId;
    }
    
    public void setHisPerfRecId(BigDecimal hisPerfRecId) {
        this.hisPerfRecId = hisPerfRecId;
    }
    public BigDecimal getPerfId() {
        return this.perfId;
    }
    
    public void setPerfId(BigDecimal perfId) {
        this.perfId = perfId;
    }
    public BigDecimal getRecId() {
        return this.recId;
    }
    
    public void setRecId(BigDecimal recId) {
        this.recId = recId;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }
    public Date getHisFechaIni() {
        return this.hisFechaIni;
    }
    
    public void setHisFechaIni(Date hisFechaIni) {
        this.hisFechaIni = hisFechaIni;
    }
    public Date getHisFechaFin() {
        return this.hisFechaFin;
    }
    
    public void setHisFechaFin(Date hisFechaFin) {
        this.hisFechaFin = hisFechaFin;
    }




}


