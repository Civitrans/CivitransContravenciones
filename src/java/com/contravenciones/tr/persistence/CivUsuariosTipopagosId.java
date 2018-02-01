package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivUsuariosTipopagosId generated by hbm2java
 */
public class CivUsuariosTipopagosId  implements java.io.Serializable {


     private long usuId;
     private BigDecimal tippagId;
     private BigDecimal ustipEstado;
     private Date fechafin;
     private Date fechainicial;

    public CivUsuariosTipopagosId() {
    }

	
    public CivUsuariosTipopagosId(long usuId, BigDecimal tippagId, BigDecimal ustipEstado, Date fechainicial) {
        this.usuId = usuId;
        this.tippagId = tippagId;
        this.ustipEstado = ustipEstado;
        this.fechainicial = fechainicial;
    }
    public CivUsuariosTipopagosId(long usuId, BigDecimal tippagId, BigDecimal ustipEstado, Date fechafin, Date fechainicial) {
       this.usuId = usuId;
       this.tippagId = tippagId;
       this.ustipEstado = ustipEstado;
       this.fechafin = fechafin;
       this.fechainicial = fechainicial;
    }
   
    public long getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }
    public BigDecimal getTippagId() {
        return this.tippagId;
    }
    
    public void setTippagId(BigDecimal tippagId) {
        this.tippagId = tippagId;
    }
    public BigDecimal getUstipEstado() {
        return this.ustipEstado;
    }
    
    public void setUstipEstado(BigDecimal ustipEstado) {
        this.ustipEstado = ustipEstado;
    }
    public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    public Date getFechainicial() {
        return this.fechainicial;
    }
    
    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CivUsuariosTipopagosId) ) return false;
		 CivUsuariosTipopagosId castOther = ( CivUsuariosTipopagosId ) other; 
         
		 return (this.getUsuId()==castOther.getUsuId())
 && ( (this.getTippagId()==castOther.getTippagId()) || ( this.getTippagId()!=null && castOther.getTippagId()!=null && this.getTippagId().equals(castOther.getTippagId()) ) )
 && ( (this.getUstipEstado()==castOther.getUstipEstado()) || ( this.getUstipEstado()!=null && castOther.getUstipEstado()!=null && this.getUstipEstado().equals(castOther.getUstipEstado()) ) )
 && ( (this.getFechafin()==castOther.getFechafin()) || ( this.getFechafin()!=null && castOther.getFechafin()!=null && this.getFechafin().equals(castOther.getFechafin()) ) )
 && ( (this.getFechainicial()==castOther.getFechainicial()) || ( this.getFechainicial()!=null && castOther.getFechainicial()!=null && this.getFechainicial().equals(castOther.getFechainicial()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getUsuId();
         result = 37 * result + ( getTippagId() == null ? 0 : this.getTippagId().hashCode() );
         result = 37 * result + ( getUstipEstado() == null ? 0 : this.getUstipEstado().hashCode() );
         result = 37 * result + ( getFechafin() == null ? 0 : this.getFechafin().hashCode() );
         result = 37 * result + ( getFechainicial() == null ? 0 : this.getFechainicial().hashCode() );
         return result;
   }   


}


