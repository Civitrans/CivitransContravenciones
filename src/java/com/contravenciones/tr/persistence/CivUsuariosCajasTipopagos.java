package com.contravenciones.tr.persistence;
// Generated 30/12/2017 12:47:12 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivUsuariosCajasTipopagos generated by hbm2java
 */
public class CivUsuariosCajasTipopagos  implements java.io.Serializable {


     private BigDecimal usuCajTpId;
     private long usuId;
     private long cajId;
     private BigDecimal ustipTipoPago;
     private BigDecimal ustipEstado;
     private Date fechainicial;
     private Date fechafin;

    public CivUsuariosCajasTipopagos() {
    }

	
    public CivUsuariosCajasTipopagos(BigDecimal usuCajTpId, long usuId, long cajId, BigDecimal ustipTipoPago, BigDecimal ustipEstado, Date fechainicial) {
        this.usuCajTpId = usuCajTpId;
        this.usuId = usuId;
        this.cajId = cajId;
        this.ustipTipoPago = ustipTipoPago;
        this.ustipEstado = ustipEstado;
        this.fechainicial = fechainicial;
    }
    public CivUsuariosCajasTipopagos(BigDecimal usuCajTpId, long usuId, long cajId, BigDecimal ustipTipoPago, BigDecimal ustipEstado, Date fechainicial, Date fechafin) {
       this.usuCajTpId = usuCajTpId;
       this.usuId = usuId;
       this.cajId = cajId;
       this.ustipTipoPago = ustipTipoPago;
       this.ustipEstado = ustipEstado;
       this.fechainicial = fechainicial;
       this.fechafin = fechafin;
    }
   
    public BigDecimal getUsuCajTpId() {
        return this.usuCajTpId;
    }
    
    public void setUsuCajTpId(BigDecimal usuCajTpId) {
        this.usuCajTpId = usuCajTpId;
    }
    public long getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }
    public long getCajId() {
        return this.cajId;
    }
    
    public void setCajId(long cajId) {
        this.cajId = cajId;
    }
    public BigDecimal getUstipTipoPago() {
        return this.ustipTipoPago;
    }
    
    public void setUstipTipoPago(BigDecimal ustipTipoPago) {
        this.ustipTipoPago = ustipTipoPago;
    }
    public BigDecimal getUstipEstado() {
        return this.ustipEstado;
    }
    
    public void setUstipEstado(BigDecimal ustipEstado) {
        this.ustipEstado = ustipEstado;
    }
    public Date getFechainicial() {
        return this.fechainicial;
    }
    
    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }
    public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }




}


