package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivSalariosminimos generated by hbm2java
 */
public class CivSalariosminimos  implements java.io.Serializable {


     private BigDecimal salId;
     private BigDecimal salVigencia;
     private BigDecimal salValor;
     private BigDecimal salEstado;
     private Date salFechainicial;
     private Date salFechafinal;

    public CivSalariosminimos() {
    }

	
    public CivSalariosminimos(BigDecimal salId, BigDecimal salVigencia, BigDecimal salValor, BigDecimal salEstado, Date salFechainicial) {
        this.salId = salId;
        this.salVigencia = salVigencia;
        this.salValor = salValor;
        this.salEstado = salEstado;
        this.salFechainicial = salFechainicial;
    }
    public CivSalariosminimos(BigDecimal salId, BigDecimal salVigencia, BigDecimal salValor, BigDecimal salEstado, Date salFechainicial, Date salFechafinal) {
       this.salId = salId;
       this.salVigencia = salVigencia;
       this.salValor = salValor;
       this.salEstado = salEstado;
       this.salFechainicial = salFechainicial;
       this.salFechafinal = salFechafinal;
    }
   
    public BigDecimal getSalId() {
        return this.salId;
    }
    
    public void setSalId(BigDecimal salId) {
        this.salId = salId;
    }
    public BigDecimal getSalVigencia() {
        return this.salVigencia;
    }
    
    public void setSalVigencia(BigDecimal salVigencia) {
        this.salVigencia = salVigencia;
    }
    public BigDecimal getSalValor() {
        return this.salValor;
    }
    
    public void setSalValor(BigDecimal salValor) {
        this.salValor = salValor;
    }
    public BigDecimal getSalEstado() {
        return this.salEstado;
    }
    
    public void setSalEstado(BigDecimal salEstado) {
        this.salEstado = salEstado;
    }
    public Date getSalFechainicial() {
        return this.salFechainicial;
    }
    
    public void setSalFechainicial(Date salFechainicial) {
        this.salFechainicial = salFechainicial;
    }
    public Date getSalFechafinal() {
        return this.salFechafinal;
    }
    
    public void setSalFechafinal(Date salFechafinal) {
        this.salFechafinal = salFechafinal;
    }




}


