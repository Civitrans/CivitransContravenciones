package com.contravenciones.tr.persistence;
// Generated 5/02/2018 01:39:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * CivDepartamentos generated by hbm2java
 */
public class CivDepartamentos  implements java.io.Serializable {


     private BigDecimal depId;
     private CivPais civPais;
     private String depNombre;
     private String depCodigoarea;
     private BigDecimal depCoddepartamento;
     private Set civDiviposes = new HashSet(0);

    public CivDepartamentos() {
    }

	
    public CivDepartamentos(BigDecimal depId) {
        this.depId = depId;
    }
    public CivDepartamentos(BigDecimal depId, CivPais civPais, String depNombre, String depCodigoarea, BigDecimal depCoddepartamento, Set civDiviposes) {
       this.depId = depId;
       this.civPais = civPais;
       this.depNombre = depNombre;
       this.depCodigoarea = depCodigoarea;
       this.depCoddepartamento = depCoddepartamento;
       this.civDiviposes = civDiviposes;
    }
   
    public BigDecimal getDepId() {
        return this.depId;
    }
    
    public void setDepId(BigDecimal depId) {
        this.depId = depId;
    }
    public CivPais getCivPais() {
        return this.civPais;
    }
    
    public void setCivPais(CivPais civPais) {
        this.civPais = civPais;
    }
    public String getDepNombre() {
        return this.depNombre;
    }
    
    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }
    public String getDepCodigoarea() {
        return this.depCodigoarea;
    }
    
    public void setDepCodigoarea(String depCodigoarea) {
        this.depCodigoarea = depCodigoarea;
    }
    public BigDecimal getDepCoddepartamento() {
        return this.depCoddepartamento;
    }
    
    public void setDepCoddepartamento(BigDecimal depCoddepartamento) {
        this.depCoddepartamento = depCoddepartamento;
    }
    public Set getCivDiviposes() {
        return this.civDiviposes;
    }
    
    public void setCivDiviposes(Set civDiviposes) {
        this.civDiviposes = civDiviposes;
    }




}


