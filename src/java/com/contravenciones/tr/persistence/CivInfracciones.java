package com.contravenciones.tr.persistence;
// Generated 15/01/2018 03:21:52 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivInfracciones generated by hbm2java
 */
public class CivInfracciones  implements java.io.Serializable {


     private BigDecimal infId;
     private CivUsuarios civUsuarios;
     private String infCodigoTransito;
     private String infNumero;
     private String infDescripcion;
     private BigDecimal infEstado;
     private Date infFechainicial;
     private Date infFechafinal;
     private Set civComparendoses = new HashSet(0);

    public CivInfracciones() {
    }

	
    public CivInfracciones(BigDecimal infId, CivUsuarios civUsuarios, String infNumero, String infDescripcion, BigDecimal infEstado, Date infFechainicial) {
        this.infId = infId;
        this.civUsuarios = civUsuarios;
        this.infNumero = infNumero;
        this.infDescripcion = infDescripcion;
        this.infEstado = infEstado;
        this.infFechainicial = infFechainicial;
    }
    public CivInfracciones(BigDecimal infId, CivUsuarios civUsuarios, String infCodigoTransito, String infNumero, String infDescripcion, BigDecimal infEstado, Date infFechainicial, Date infFechafinal, Set civComparendoses) {
       this.infId = infId;
       this.civUsuarios = civUsuarios;
       this.infCodigoTransito = infCodigoTransito;
       this.infNumero = infNumero;
       this.infDescripcion = infDescripcion;
       this.infEstado = infEstado;
       this.infFechainicial = infFechainicial;
       this.infFechafinal = infFechafinal;
       this.civComparendoses = civComparendoses;
    }
   
    public BigDecimal getInfId() {
        return this.infId;
    }
    
    public void setInfId(BigDecimal infId) {
        this.infId = infId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public String getInfCodigoTransito() {
        return this.infCodigoTransito;
    }
    
    public void setInfCodigoTransito(String infCodigoTransito) {
        this.infCodigoTransito = infCodigoTransito;
    }
    public String getInfNumero() {
        return this.infNumero;
    }
    
    public void setInfNumero(String infNumero) {
        this.infNumero = infNumero;
    }
    public String getInfDescripcion() {
        return this.infDescripcion;
    }
    
    public void setInfDescripcion(String infDescripcion) {
        this.infDescripcion = infDescripcion;
    }
    public BigDecimal getInfEstado() {
        return this.infEstado;
    }
    
    public void setInfEstado(BigDecimal infEstado) {
        this.infEstado = infEstado;
    }
    public Date getInfFechainicial() {
        return this.infFechainicial;
    }
    
    public void setInfFechainicial(Date infFechainicial) {
        this.infFechainicial = infFechainicial;
    }
    public Date getInfFechafinal() {
        return this.infFechafinal;
    }
    
    public void setInfFechafinal(Date infFechafinal) {
        this.infFechafinal = infFechafinal;
    }
    public Set getCivComparendoses() {
        return this.civComparendoses;
    }
    
    public void setCivComparendoses(Set civComparendoses) {
        this.civComparendoses = civComparendoses;
    }




}


