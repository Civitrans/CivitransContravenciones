package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivValorinfraccion generated by hbm2java
 */
public class CivValorinfraccion  implements java.io.Serializable {


     private BigDecimal valinfId;
     private CivUsuarios civUsuarios;
     private CivInfracciones civInfracciones;
     private String valinfLey;
     private BigDecimal valinfSalarios;
     private String valinfResolucion;
     private Date valinfFechares;
     private Date valinfFechainicial;
     private Date valinfFechafinal;
     private BigDecimal valinfEstado;

    public CivValorinfraccion() {
    }

	
    public CivValorinfraccion(BigDecimal valinfId, CivUsuarios civUsuarios, CivInfracciones civInfracciones, BigDecimal valinfSalarios, Date valinfFechainicial, BigDecimal valinfEstado) {
        this.valinfId = valinfId;
        this.civUsuarios = civUsuarios;
        this.civInfracciones = civInfracciones;
        this.valinfSalarios = valinfSalarios;
        this.valinfFechainicial = valinfFechainicial;
        this.valinfEstado = valinfEstado;
    }
    public CivValorinfraccion(BigDecimal valinfId, CivUsuarios civUsuarios, CivInfracciones civInfracciones, String valinfLey, BigDecimal valinfSalarios, String valinfResolucion, Date valinfFechares, Date valinfFechainicial, Date valinfFechafinal, BigDecimal valinfEstado) {
       this.valinfId = valinfId;
       this.civUsuarios = civUsuarios;
       this.civInfracciones = civInfracciones;
       this.valinfLey = valinfLey;
       this.valinfSalarios = valinfSalarios;
       this.valinfResolucion = valinfResolucion;
       this.valinfFechares = valinfFechares;
       this.valinfFechainicial = valinfFechainicial;
       this.valinfFechafinal = valinfFechafinal;
       this.valinfEstado = valinfEstado;
    }
   
    public BigDecimal getValinfId() {
        return this.valinfId;
    }
    
    public void setValinfId(BigDecimal valinfId) {
        this.valinfId = valinfId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivInfracciones getCivInfracciones() {
        return this.civInfracciones;
    }
    
    public void setCivInfracciones(CivInfracciones civInfracciones) {
        this.civInfracciones = civInfracciones;
    }
    public String getValinfLey() {
        return this.valinfLey;
    }
    
    public void setValinfLey(String valinfLey) {
        this.valinfLey = valinfLey;
    }
    public BigDecimal getValinfSalarios() {
        return this.valinfSalarios;
    }
    
    public void setValinfSalarios(BigDecimal valinfSalarios) {
        this.valinfSalarios = valinfSalarios;
    }
    public String getValinfResolucion() {
        return this.valinfResolucion;
    }
    
    public void setValinfResolucion(String valinfResolucion) {
        this.valinfResolucion = valinfResolucion;
    }
    public Date getValinfFechares() {
        return this.valinfFechares;
    }
    
    public void setValinfFechares(Date valinfFechares) {
        this.valinfFechares = valinfFechares;
    }
    public Date getValinfFechainicial() {
        return this.valinfFechainicial;
    }
    
    public void setValinfFechainicial(Date valinfFechainicial) {
        this.valinfFechainicial = valinfFechainicial;
    }
    public Date getValinfFechafinal() {
        return this.valinfFechafinal;
    }
    
    public void setValinfFechafinal(Date valinfFechafinal) {
        this.valinfFechafinal = valinfFechafinal;
    }
    public BigDecimal getValinfEstado() {
        return this.valinfEstado;
    }
    
    public void setValinfEstado(BigDecimal valinfEstado) {
        this.valinfEstado = valinfEstado;
    }




}


