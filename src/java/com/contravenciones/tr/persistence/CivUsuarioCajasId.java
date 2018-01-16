package com.contravenciones.tr.persistence;
// Generated 15/01/2018 03:21:52 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivUsuarioCajasId generated by hbm2java
 */
public class CivUsuarioCajasId  implements java.io.Serializable {


     private long usuId;
     private BigDecimal cajId;

    public CivUsuarioCajasId() {
    }

    public CivUsuarioCajasId(long usuId, BigDecimal cajId) {
       this.usuId = usuId;
       this.cajId = cajId;
    }
   
    public long getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }
    public BigDecimal getCajId() {
        return this.cajId;
    }
    
    public void setCajId(BigDecimal cajId) {
        this.cajId = cajId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CivUsuarioCajasId) ) return false;
		 CivUsuarioCajasId castOther = ( CivUsuarioCajasId ) other; 
         
		 return (this.getUsuId()==castOther.getUsuId())
 && ( (this.getCajId()==castOther.getCajId()) || ( this.getCajId()!=null && castOther.getCajId()!=null && this.getCajId().equals(castOther.getCajId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getUsuId();
         result = 37 * result + ( getCajId() == null ? 0 : this.getCajId().hashCode() );
         return result;
   }   


}


