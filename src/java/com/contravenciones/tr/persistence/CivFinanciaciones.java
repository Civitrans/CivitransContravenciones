package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivFinanciaciones generated by hbm2java
 */
public class CivFinanciaciones  implements java.io.Serializable {


     private BigDecimal finId;
     private CivResoluciones civResoluciones;

    public CivFinanciaciones() {
    }

    public CivFinanciaciones(BigDecimal finId, CivResoluciones civResoluciones) {
       this.finId = finId;
       this.civResoluciones = civResoluciones;
    }
   
    public BigDecimal getFinId() {
        return this.finId;
    }
    
    public void setFinId(BigDecimal finId) {
        this.finId = finId;
    }
    public CivResoluciones getCivResoluciones() {
        return this.civResoluciones;
    }
    
    public void setCivResoluciones(CivResoluciones civResoluciones) {
        this.civResoluciones = civResoluciones;
    }




}


