package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivCarteras generated by hbm2java
 */
public class CivCarteras  implements java.io.Serializable {


     private BigDecimal carId;
     private CivTipocarteras civTipocarteras;
     private CivConceptos civConceptos;
     private String carReferencia1;
     private String carReferencia2;
     private BigDecimal carValor;
     private BigDecimal carSaldo;
     private BigDecimal carPeriodo;
     private Date carFechainicial;
     private Date carFechafinal;
     private BigDecimal carEstado;
     private Set civResolucioneses = new HashSet(0);
     private Set civComparendoses = new HashSet(0);
     private Set civDetallecarteras = new HashSet(0);

    public CivCarteras() {
    }

	
    public CivCarteras(BigDecimal carId, CivConceptos civConceptos, BigDecimal carValor, BigDecimal carSaldo, Date carFechainicial, BigDecimal carEstado) {
        this.carId = carId;
        this.civConceptos = civConceptos;
        this.carValor = carValor;
        this.carSaldo = carSaldo;
        this.carFechainicial = carFechainicial;
        this.carEstado = carEstado;
    }
    public CivCarteras(BigDecimal carId, CivTipocarteras civTipocarteras, CivConceptos civConceptos, String carReferencia1, String carReferencia2, BigDecimal carValor, BigDecimal carSaldo, BigDecimal carPeriodo, Date carFechainicial, Date carFechafinal, BigDecimal carEstado, Set civResolucioneses, Set civComparendoses, Set civDetallecarteras) {
       this.carId = carId;
       this.civTipocarteras = civTipocarteras;
       this.civConceptos = civConceptos;
       this.carReferencia1 = carReferencia1;
       this.carReferencia2 = carReferencia2;
       this.carValor = carValor;
       this.carSaldo = carSaldo;
       this.carPeriodo = carPeriodo;
       this.carFechainicial = carFechainicial;
       this.carFechafinal = carFechafinal;
       this.carEstado = carEstado;
       this.civResolucioneses = civResolucioneses;
       this.civComparendoses = civComparendoses;
       this.civDetallecarteras = civDetallecarteras;
    }
   
    public BigDecimal getCarId() {
        return this.carId;
    }
    
    public void setCarId(BigDecimal carId) {
        this.carId = carId;
    }
    public CivTipocarteras getCivTipocarteras() {
        return this.civTipocarteras;
    }
    
    public void setCivTipocarteras(CivTipocarteras civTipocarteras) {
        this.civTipocarteras = civTipocarteras;
    }
    public CivConceptos getCivConceptos() {
        return this.civConceptos;
    }
    
    public void setCivConceptos(CivConceptos civConceptos) {
        this.civConceptos = civConceptos;
    }
    public String getCarReferencia1() {
        return this.carReferencia1;
    }
    
    public void setCarReferencia1(String carReferencia1) {
        this.carReferencia1 = carReferencia1;
    }
    public String getCarReferencia2() {
        return this.carReferencia2;
    }
    
    public void setCarReferencia2(String carReferencia2) {
        this.carReferencia2 = carReferencia2;
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
    public BigDecimal getCarPeriodo() {
        return this.carPeriodo;
    }
    
    public void setCarPeriodo(BigDecimal carPeriodo) {
        this.carPeriodo = carPeriodo;
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
    public BigDecimal getCarEstado() {
        return this.carEstado;
    }
    
    public void setCarEstado(BigDecimal carEstado) {
        this.carEstado = carEstado;
    }
    public Set getCivResolucioneses() {
        return this.civResolucioneses;
    }
    
    public void setCivResolucioneses(Set civResolucioneses) {
        this.civResolucioneses = civResolucioneses;
    }
    public Set getCivComparendoses() {
        return this.civComparendoses;
    }
    
    public void setCivComparendoses(Set civComparendoses) {
        this.civComparendoses = civComparendoses;
    }
    public Set getCivDetallecarteras() {
        return this.civDetallecarteras;
    }
    
    public void setCivDetallecarteras(Set civDetallecarteras) {
        this.civDetallecarteras = civDetallecarteras;
    }




}


