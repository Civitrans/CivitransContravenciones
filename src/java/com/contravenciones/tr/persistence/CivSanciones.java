package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivSanciones generated by hbm2java
 */
public class CivSanciones  implements java.io.Serializable {


     private BigDecimal sanId;
     private CivResoluciones civResoluciones;

    public CivSanciones() {
    }

    public CivSanciones(BigDecimal sanId, CivResoluciones civResoluciones) {
       this.sanId = sanId;
       this.civResoluciones = civResoluciones;
    }
   
    public BigDecimal getSanId() {
        return this.sanId;
    }
    
    public void setSanId(BigDecimal sanId) {
        this.sanId = sanId;
    }
    public CivResoluciones getCivResoluciones() {
        return this.civResoluciones;
    }
    
    public void setCivResoluciones(CivResoluciones civResoluciones) {
        this.civResoluciones = civResoluciones;
    }




}

