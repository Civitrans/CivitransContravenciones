package com.contravenciones.tr.persistence;
// Generated 26/01/2018 03:08:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CivPerfilrecursoId generated by hbm2java
 */
public class CivPerfilrecursoId  implements java.io.Serializable {


     private BigDecimal recId;
     private BigDecimal usuId;

    public CivPerfilrecursoId() {
    }

    public CivPerfilrecursoId(BigDecimal recId, BigDecimal usuId) {
       this.recId = recId;
       this.usuId = usuId;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CivPerfilrecursoId) ) return false;
		 CivPerfilrecursoId castOther = ( CivPerfilrecursoId ) other; 
         
		 return ( (this.getRecId()==castOther.getRecId()) || ( this.getRecId()!=null && castOther.getRecId()!=null && this.getRecId().equals(castOther.getRecId()) ) )
 && ( (this.getUsuId()==castOther.getUsuId()) || ( this.getUsuId()!=null && castOther.getUsuId()!=null && this.getUsuId().equals(castOther.getUsuId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRecId() == null ? 0 : this.getRecId().hashCode() );
         result = 37 * result + ( getUsuId() == null ? 0 : this.getUsuId().hashCode() );
         return result;
   }   


}


