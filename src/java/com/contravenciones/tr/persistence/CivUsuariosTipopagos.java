package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1



/**
 * CivUsuariosTipopagos generated by hbm2java
 */
public class CivUsuariosTipopagos  implements java.io.Serializable {


     private CivUsuariosTipopagosId id;
     private CivUsuarios civUsuarios;
     private CivTipopagos civTipopagos;

    public CivUsuariosTipopagos() {
    }

    public CivUsuariosTipopagos(CivUsuariosTipopagosId id, CivUsuarios civUsuarios, CivTipopagos civTipopagos) {
       this.id = id;
       this.civUsuarios = civUsuarios;
       this.civTipopagos = civTipopagos;
    }
   
    public CivUsuariosTipopagosId getId() {
        return this.id;
    }
    
    public void setId(CivUsuariosTipopagosId id) {
        this.id = id;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivTipopagos getCivTipopagos() {
        return this.civTipopagos;
    }
    
    public void setCivTipopagos(CivTipopagos civTipopagos) {
        this.civTipopagos = civTipopagos;
    }




}


