package com.contravenciones.tr.persistence;
// Generated 20/01/2018 11:02:54 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CivPersonas generated by hbm2java
 */
public class CivPersonas  implements java.io.Serializable {


     private BigDecimal perId;
     private BigDecimal perTipodocumento;
     private String perDocumento;
     private Date perFechanac;
     private String perGruposanguineo;
     private String perRh;
     private String perSexo;
     private String perNombre1;
     private String perNombre2;
     private String perApellido1;
     private String perApellido2;
     private String perEmail;
     private String perCelular;
     private BigDecimal perLugarnacimiento;
     private Date perFechaexp;
     private BigDecimal perEstado;
     private Date perFechainicial;
     private Date perFechafinal;
     private Date perFechaproceso;
     private BigDecimal usuId;
     private BigDecimal perLugarexpedicion;
     private Set civDireccioneses = new HashSet(0);
     private Set civComparendosesForPerId = new HashSet(0);
     private Set civComparendosesForPerTestigo = new HashSet(0);
     private Set civUsuarioses = new HashSet(0);
     private Set civAgenteses = new HashSet(0);
     private Set civCarterases = new HashSet(0);
     private Set civComparendosesForPerPropietario = new HashSet(0);

    public CivPersonas() {
    }

	
    public CivPersonas(BigDecimal perId, BigDecimal perTipodocumento, String perDocumento, String perNombre1, String perApellido1, BigDecimal perEstado) {
        this.perId = perId;
        this.perTipodocumento = perTipodocumento;
        this.perDocumento = perDocumento;
        this.perNombre1 = perNombre1;
        this.perApellido1 = perApellido1;
        this.perEstado = perEstado;
    }
    public CivPersonas(BigDecimal perId, BigDecimal perTipodocumento, String perDocumento, Date perFechanac, String perGruposanguineo, String perRh, String perSexo, String perNombre1, String perNombre2, String perApellido1, String perApellido2, String perEmail, String perCelular, BigDecimal perLugarnacimiento, Date perFechaexp, BigDecimal perEstado, Date perFechainicial, Date perFechafinal, Date perFechaproceso, BigDecimal usuId, BigDecimal perLugarexpedicion, Set civDireccioneses, Set civComparendosesForPerId, Set civComparendosesForPerTestigo, Set civUsuarioses, Set civAgenteses, Set civCarterases, Set civComparendosesForPerPropietario) {
       this.perId = perId;
       this.perTipodocumento = perTipodocumento;
       this.perDocumento = perDocumento;
       this.perFechanac = perFechanac;
       this.perGruposanguineo = perGruposanguineo;
       this.perRh = perRh;
       this.perSexo = perSexo;
       this.perNombre1 = perNombre1;
       this.perNombre2 = perNombre2;
       this.perApellido1 = perApellido1;
       this.perApellido2 = perApellido2;
       this.perEmail = perEmail;
       this.perCelular = perCelular;
       this.perLugarnacimiento = perLugarnacimiento;
       this.perFechaexp = perFechaexp;
       this.perEstado = perEstado;
       this.perFechainicial = perFechainicial;
       this.perFechafinal = perFechafinal;
       this.perFechaproceso = perFechaproceso;
       this.usuId = usuId;
       this.perLugarexpedicion = perLugarexpedicion;
       this.civDireccioneses = civDireccioneses;
       this.civComparendosesForPerId = civComparendosesForPerId;
       this.civComparendosesForPerTestigo = civComparendosesForPerTestigo;
       this.civUsuarioses = civUsuarioses;
       this.civAgenteses = civAgenteses;
       this.civCarterases = civCarterases;
       this.civComparendosesForPerPropietario = civComparendosesForPerPropietario;
    }
   
    public BigDecimal getPerId() {
        return this.perId;
    }
    
    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }
    public BigDecimal getPerTipodocumento() {
        return this.perTipodocumento;
    }
    
    public void setPerTipodocumento(BigDecimal perTipodocumento) {
        this.perTipodocumento = perTipodocumento;
    }
    public String getPerDocumento() {
        return this.perDocumento;
    }
    
    public void setPerDocumento(String perDocumento) {
        this.perDocumento = perDocumento;
    }
    public Date getPerFechanac() {
        return this.perFechanac;
    }
    
    public void setPerFechanac(Date perFechanac) {
        this.perFechanac = perFechanac;
    }
    public String getPerGruposanguineo() {
        return this.perGruposanguineo;
    }
    
    public void setPerGruposanguineo(String perGruposanguineo) {
        this.perGruposanguineo = perGruposanguineo;
    }
    public String getPerRh() {
        return this.perRh;
    }
    
    public void setPerRh(String perRh) {
        this.perRh = perRh;
    }
    public String getPerSexo() {
        return this.perSexo;
    }
    
    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }
    public String getPerNombre1() {
        return this.perNombre1;
    }
    
    public void setPerNombre1(String perNombre1) {
        this.perNombre1 = perNombre1;
    }
    public String getPerNombre2() {
        return this.perNombre2;
    }
    
    public void setPerNombre2(String perNombre2) {
        this.perNombre2 = perNombre2;
    }
    public String getPerApellido1() {
        return this.perApellido1;
    }
    
    public void setPerApellido1(String perApellido1) {
        this.perApellido1 = perApellido1;
    }
    public String getPerApellido2() {
        return this.perApellido2;
    }
    
    public void setPerApellido2(String perApellido2) {
        this.perApellido2 = perApellido2;
    }
    public String getPerEmail() {
        return this.perEmail;
    }
    
    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }
    public String getPerCelular() {
        return this.perCelular;
    }
    
    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }
    public BigDecimal getPerLugarnacimiento() {
        return this.perLugarnacimiento;
    }
    
    public void setPerLugarnacimiento(BigDecimal perLugarnacimiento) {
        this.perLugarnacimiento = perLugarnacimiento;
    }
    public Date getPerFechaexp() {
        return this.perFechaexp;
    }
    
    public void setPerFechaexp(Date perFechaexp) {
        this.perFechaexp = perFechaexp;
    }
    public BigDecimal getPerEstado() {
        return this.perEstado;
    }
    
    public void setPerEstado(BigDecimal perEstado) {
        this.perEstado = perEstado;
    }
    public Date getPerFechainicial() {
        return this.perFechainicial;
    }
    
    public void setPerFechainicial(Date perFechainicial) {
        this.perFechainicial = perFechainicial;
    }
    public Date getPerFechafinal() {
        return this.perFechafinal;
    }
    
    public void setPerFechafinal(Date perFechafinal) {
        this.perFechafinal = perFechafinal;
    }
    public Date getPerFechaproceso() {
        return this.perFechaproceso;
    }
    
    public void setPerFechaproceso(Date perFechaproceso) {
        this.perFechaproceso = perFechaproceso;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }
    public BigDecimal getPerLugarexpedicion() {
        return this.perLugarexpedicion;
    }
    
    public void setPerLugarexpedicion(BigDecimal perLugarexpedicion) {
        this.perLugarexpedicion = perLugarexpedicion;
    }
    public Set getCivDireccioneses() {
        return this.civDireccioneses;
    }
    
    public void setCivDireccioneses(Set civDireccioneses) {
        this.civDireccioneses = civDireccioneses;
    }
    public Set getCivComparendosesForPerId() {
        return this.civComparendosesForPerId;
    }
    
    public void setCivComparendosesForPerId(Set civComparendosesForPerId) {
        this.civComparendosesForPerId = civComparendosesForPerId;
    }
    public Set getCivComparendosesForPerTestigo() {
        return this.civComparendosesForPerTestigo;
    }
    
    public void setCivComparendosesForPerTestigo(Set civComparendosesForPerTestigo) {
        this.civComparendosesForPerTestigo = civComparendosesForPerTestigo;
    }
    public Set getCivUsuarioses() {
        return this.civUsuarioses;
    }
    
    public void setCivUsuarioses(Set civUsuarioses) {
        this.civUsuarioses = civUsuarioses;
    }
    public Set getCivAgenteses() {
        return this.civAgenteses;
    }
    
    public void setCivAgenteses(Set civAgenteses) {
        this.civAgenteses = civAgenteses;
    }
    public Set getCivCarterases() {
        return this.civCarterases;
    }
    
    public void setCivCarterases(Set civCarterases) {
        this.civCarterases = civCarterases;
    }
    public Set getCivComparendosesForPerPropietario() {
        return this.civComparendosesForPerPropietario;
    }
    
    public void setCivComparendosesForPerPropietario(Set civComparendosesForPerPropietario) {
        this.civComparendosesForPerPropietario = civComparendosesForPerPropietario;
    }




}


