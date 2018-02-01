package com.contravenciones.tr.persistence;
// Generated 1/02/2018 01:51:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LogEventos generated by hbm2java
 */
public class LogEventos  implements java.io.Serializable {


     private BigDecimal evId;
     private CivUsuarios civUsuarios;
     private String evIp;
     private BigDecimal evNivel;
     private Date evFecha;
     private String evExcpetion;
     private String evMensaje;
     private String evCausa;
     private String evClaseOrigen;
     private String evStacktrace;

    public LogEventos() {
    }

	
    public LogEventos(BigDecimal evId) {
        this.evId = evId;
    }
    public LogEventos(BigDecimal evId, CivUsuarios civUsuarios, String evIp, BigDecimal evNivel, Date evFecha, String evExcpetion, String evMensaje, String evCausa, String evClaseOrigen, String evStacktrace) {
       this.evId = evId;
       this.civUsuarios = civUsuarios;
       this.evIp = evIp;
       this.evNivel = evNivel;
       this.evFecha = evFecha;
       this.evExcpetion = evExcpetion;
       this.evMensaje = evMensaje;
       this.evCausa = evCausa;
       this.evClaseOrigen = evClaseOrigen;
       this.evStacktrace = evStacktrace;
    }
   
    public BigDecimal getEvId() {
        return this.evId;
    }
    
    public void setEvId(BigDecimal evId) {
        this.evId = evId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public String getEvIp() {
        return this.evIp;
    }
    
    public void setEvIp(String evIp) {
        this.evIp = evIp;
    }
    public BigDecimal getEvNivel() {
        return this.evNivel;
    }
    
    public void setEvNivel(BigDecimal evNivel) {
        this.evNivel = evNivel;
    }
    public Date getEvFecha() {
        return this.evFecha;
    }
    
    public void setEvFecha(Date evFecha) {
        this.evFecha = evFecha;
    }
    public String getEvExcpetion() {
        return this.evExcpetion;
    }
    
    public void setEvExcpetion(String evExcpetion) {
        this.evExcpetion = evExcpetion;
    }
    public String getEvMensaje() {
        return this.evMensaje;
    }
    
    public void setEvMensaje(String evMensaje) {
        this.evMensaje = evMensaje;
    }
    public String getEvCausa() {
        return this.evCausa;
    }
    
    public void setEvCausa(String evCausa) {
        this.evCausa = evCausa;
    }
    public String getEvClaseOrigen() {
        return this.evClaseOrigen;
    }
    
    public void setEvClaseOrigen(String evClaseOrigen) {
        this.evClaseOrigen = evClaseOrigen;
    }
    public String getEvStacktrace() {
        return this.evStacktrace;
    }
    
    public void setEvStacktrace(String evStacktrace) {
        this.evStacktrace = evStacktrace;
    }




}


