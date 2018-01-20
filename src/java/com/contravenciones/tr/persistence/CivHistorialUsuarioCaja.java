package com.contravenciones.tr.persistence;
// Generated 19/01/2018 08:59:41 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivHistorialUsuarioCaja generated by hbm2java
 */
public class CivHistorialUsuarioCaja  implements java.io.Serializable {


     private BigDecimal hisUsuCajId;
     private BigDecimal usuId;
     private BigDecimal sedId;
     private BigDecimal cajId;
     private Date hisFechaInicio;
     private Date hisFechaFin;

    public CivHistorialUsuarioCaja() {
    }

	
    public CivHistorialUsuarioCaja(BigDecimal hisUsuCajId) {
        this.hisUsuCajId = hisUsuCajId;
    }
    public CivHistorialUsuarioCaja(BigDecimal hisUsuCajId, BigDecimal usuId, BigDecimal sedId, BigDecimal cajId, Date hisFechaInicio, Date hisFechaFin) {
       this.hisUsuCajId = hisUsuCajId;
       this.usuId = usuId;
       this.sedId = sedId;
       this.cajId = cajId;
       this.hisFechaInicio = hisFechaInicio;
       this.hisFechaFin = hisFechaFin;
    }
   
    public BigDecimal getHisUsuCajId() {
        return this.hisUsuCajId;
    }
    
    public void setHisUsuCajId(BigDecimal hisUsuCajId) {
        this.hisUsuCajId = hisUsuCajId;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }
    public BigDecimal getSedId() {
        return this.sedId;
    }
    
    public void setSedId(BigDecimal sedId) {
        this.sedId = sedId;
    }
    public BigDecimal getCajId() {
        return this.cajId;
    }
    
    public void setCajId(BigDecimal cajId) {
        this.cajId = cajId;
    }
    public Date getHisFechaInicio() {
        return this.hisFechaInicio;
    }
    
    public void setHisFechaInicio(Date hisFechaInicio) {
        this.hisFechaInicio = hisFechaInicio;
    }
    public Date getHisFechaFin() {
        return this.hisFechaFin;
    }
    
    public void setHisFechaFin(Date hisFechaFin) {
        this.hisFechaFin = hisFechaFin;
    }




}


