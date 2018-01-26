package com.contravenciones.tr.persistence;
// Generated 26/01/2018 03:08:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivCarteras generated by hbm2java
 */
public class CivCarteras  implements java.io.Serializable {


     private BigDecimal carId;
     private CivUsuarios civUsuarios;
     private CivPersonas civPersonas;
     private CivConceptos civConceptos;
     private BigDecimal pagId;
     private BigDecimal carTipo;
     private String carReferencia;
     private BigDecimal carPeriodo;
     private BigDecimal carValor;
     private BigDecimal carSaldo;
     private Date carFechasaldo;
     private BigDecimal carEstado;
     private Date carFechainicial;
     private Date carFechafinal;
     private Set civDetallecarteras = new HashSet(0);

    public CivCarteras() {
    }

	
    public CivCarteras(BigDecimal carId, CivUsuarios civUsuarios, CivPersonas civPersonas, CivConceptos civConceptos, BigDecimal carValor, BigDecimal carSaldo, BigDecimal carEstado, Date carFechainicial) {
        this.carId = carId;
        this.civUsuarios = civUsuarios;
        this.civPersonas = civPersonas;
        this.civConceptos = civConceptos;
        this.carValor = carValor;
        this.carSaldo = carSaldo;
        this.carEstado = carEstado;
        this.carFechainicial = carFechainicial;
    }
    public CivCarteras(BigDecimal carId, CivUsuarios civUsuarios, CivPersonas civPersonas, CivConceptos civConceptos, BigDecimal pagId, BigDecimal carTipo, String carReferencia, BigDecimal carPeriodo, BigDecimal carValor, BigDecimal carSaldo, Date carFechasaldo, BigDecimal carEstado, Date carFechainicial, Date carFechafinal, Set civDetallecarteras) {
       this.carId = carId;
       this.civUsuarios = civUsuarios;
       this.civPersonas = civPersonas;
       this.civConceptos = civConceptos;
       this.pagId = pagId;
       this.carTipo = carTipo;
       this.carReferencia = carReferencia;
       this.carPeriodo = carPeriodo;
       this.carValor = carValor;
       this.carSaldo = carSaldo;
       this.carFechasaldo = carFechasaldo;
       this.carEstado = carEstado;
       this.carFechainicial = carFechainicial;
       this.carFechafinal = carFechafinal;
       this.civDetallecarteras = civDetallecarteras;
    }
   
    public BigDecimal getCarId() {
        return this.carId;
    }
    
    public void setCarId(BigDecimal carId) {
        this.carId = carId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivPersonas getCivPersonas() {
        return this.civPersonas;
    }
    
    public void setCivPersonas(CivPersonas civPersonas) {
        this.civPersonas = civPersonas;
    }
    public CivConceptos getCivConceptos() {
        return this.civConceptos;
    }
    
    public void setCivConceptos(CivConceptos civConceptos) {
        this.civConceptos = civConceptos;
    }
    public BigDecimal getPagId() {
        return this.pagId;
    }
    
    public void setPagId(BigDecimal pagId) {
        this.pagId = pagId;
    }
    public BigDecimal getCarTipo() {
        return this.carTipo;
    }
    
    public void setCarTipo(BigDecimal carTipo) {
        this.carTipo = carTipo;
    }
    public String getCarReferencia() {
        return this.carReferencia;
    }
    
    public void setCarReferencia(String carReferencia) {
        this.carReferencia = carReferencia;
    }
    public BigDecimal getCarPeriodo() {
        return this.carPeriodo;
    }
    
    public void setCarPeriodo(BigDecimal carPeriodo) {
        this.carPeriodo = carPeriodo;
    }
    public BigDecimal getCarValor() {
        return this.carValor;
    }
    
    public void setCarValor(BigDecimal carValor) {
        this.carValor = carValor;
    }
    public BigDecimal getCarSaldo() {
        return this.carSaldo;
    }
    
    public void setCarSaldo(BigDecimal carSaldo) {
        this.carSaldo = carSaldo;
    }
    public Date getCarFechasaldo() {
        return this.carFechasaldo;
    }
    
    public void setCarFechasaldo(Date carFechasaldo) {
        this.carFechasaldo = carFechasaldo;
    }
    public BigDecimal getCarEstado() {
        return this.carEstado;
    }
    
    public void setCarEstado(BigDecimal carEstado) {
        this.carEstado = carEstado;
    }
    public Date getCarFechainicial() {
        return this.carFechainicial;
    }
    
    public void setCarFechainicial(Date carFechainicial) {
        this.carFechainicial = carFechainicial;
    }
    public Date getCarFechafinal() {
        return this.carFechafinal;
    }
    
    public void setCarFechafinal(Date carFechafinal) {
        this.carFechafinal = carFechafinal;
    }
    public Set getCivDetallecarteras() {
        return this.civDetallecarteras;
    }
    
    public void setCivDetallecarteras(Set civDetallecarteras) {
        this.civDetallecarteras = civDetallecarteras;
    }




}


