package com.contravenciones.tr.persistence;
// Generated 23/01/2018 03:51:28 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivDatosParametricos generated by hbm2java
 */
public class CivDatosParametricos  implements java.io.Serializable {


     private BigDecimal dtparaId;
     private CivUsuarios civUsuarios;
     private CivConceptos civConceptos;
     private BigDecimal dtparaTipo;
     private BigDecimal dtparaPorcentaje;
     private BigDecimal dtparaDiaMin;
     private BigDecimal dtparaDiaMax;
     private Date dtparaFechaIni;
     private Date dtparaFechaFin;
     private BigDecimal dtparaEstado;
     private String dtparaDescripcion;
     private BigDecimal dtparaValorFijo;
     private BigDecimal dtparaLongitud;

    public CivDatosParametricos() {
    }

	
    public CivDatosParametricos(BigDecimal dtparaId, CivUsuarios civUsuarios, BigDecimal dtparaTipo, Date dtparaFechaIni, BigDecimal dtparaEstado, String dtparaDescripcion) {
        this.dtparaId = dtparaId;
        this.civUsuarios = civUsuarios;
        this.dtparaTipo = dtparaTipo;
        this.dtparaFechaIni = dtparaFechaIni;
        this.dtparaEstado = dtparaEstado;
        this.dtparaDescripcion = dtparaDescripcion;
    }
    public CivDatosParametricos(BigDecimal dtparaId, CivUsuarios civUsuarios, CivConceptos civConceptos, BigDecimal dtparaTipo, BigDecimal dtparaPorcentaje, BigDecimal dtparaDiaMin, BigDecimal dtparaDiaMax, Date dtparaFechaIni, Date dtparaFechaFin, BigDecimal dtparaEstado, String dtparaDescripcion, BigDecimal dtparaValorFijo, BigDecimal dtparaLongitud) {
       this.dtparaId = dtparaId;
       this.civUsuarios = civUsuarios;
       this.civConceptos = civConceptos;
       this.dtparaTipo = dtparaTipo;
       this.dtparaPorcentaje = dtparaPorcentaje;
       this.dtparaDiaMin = dtparaDiaMin;
       this.dtparaDiaMax = dtparaDiaMax;
       this.dtparaFechaIni = dtparaFechaIni;
       this.dtparaFechaFin = dtparaFechaFin;
       this.dtparaEstado = dtparaEstado;
       this.dtparaDescripcion = dtparaDescripcion;
       this.dtparaValorFijo = dtparaValorFijo;
       this.dtparaLongitud = dtparaLongitud;
    }
   
    public BigDecimal getDtparaId() {
        return this.dtparaId;
    }
    
    public void setDtparaId(BigDecimal dtparaId) {
        this.dtparaId = dtparaId;
    }
    public CivUsuarios getCivUsuarios() {
        return this.civUsuarios;
    }
    
    public void setCivUsuarios(CivUsuarios civUsuarios) {
        this.civUsuarios = civUsuarios;
    }
    public CivConceptos getCivConceptos() {
        return this.civConceptos;
    }
    
    public void setCivConceptos(CivConceptos civConceptos) {
        this.civConceptos = civConceptos;
    }
    public BigDecimal getDtparaTipo() {
        return this.dtparaTipo;
    }
    
    public void setDtparaTipo(BigDecimal dtparaTipo) {
        this.dtparaTipo = dtparaTipo;
    }
    public BigDecimal getDtparaPorcentaje() {
        return this.dtparaPorcentaje;
    }
    
    public void setDtparaPorcentaje(BigDecimal dtparaPorcentaje) {
        this.dtparaPorcentaje = dtparaPorcentaje;
    }
    public BigDecimal getDtparaDiaMin() {
        return this.dtparaDiaMin;
    }
    
    public void setDtparaDiaMin(BigDecimal dtparaDiaMin) {
        this.dtparaDiaMin = dtparaDiaMin;
    }
    public BigDecimal getDtparaDiaMax() {
        return this.dtparaDiaMax;
    }
    
    public void setDtparaDiaMax(BigDecimal dtparaDiaMax) {
        this.dtparaDiaMax = dtparaDiaMax;
    }
    public Date getDtparaFechaIni() {
        return this.dtparaFechaIni;
    }
    
    public void setDtparaFechaIni(Date dtparaFechaIni) {
        this.dtparaFechaIni = dtparaFechaIni;
    }
    public Date getDtparaFechaFin() {
        return this.dtparaFechaFin;
    }
    
    public void setDtparaFechaFin(Date dtparaFechaFin) {
        this.dtparaFechaFin = dtparaFechaFin;
    }
    public BigDecimal getDtparaEstado() {
        return this.dtparaEstado;
    }
    
    public void setDtparaEstado(BigDecimal dtparaEstado) {
        this.dtparaEstado = dtparaEstado;
    }
    public String getDtparaDescripcion() {
        return this.dtparaDescripcion;
    }
    
    public void setDtparaDescripcion(String dtparaDescripcion) {
        this.dtparaDescripcion = dtparaDescripcion;
    }
    public BigDecimal getDtparaValorFijo() {
        return this.dtparaValorFijo;
    }
    
    public void setDtparaValorFijo(BigDecimal dtparaValorFijo) {
        this.dtparaValorFijo = dtparaValorFijo;
    }
    public BigDecimal getDtparaLongitud() {
        return this.dtparaLongitud;
    }
    
    public void setDtparaLongitud(BigDecimal dtparaLongitud) {
        this.dtparaLongitud = dtparaLongitud;
    }




}


