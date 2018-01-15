package com.contravenciones.tr.persistence;
// Generated 15/01/2018 11:03:58 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CivComparendos generated by hbm2java
 */
public class CivComparendos  implements java.io.Serializable {


     private BigDecimal comId;
     private CivPersonas civPersonasByPerId;
     private CivPersonas civPersonasByPerTestigo;
     private CivPersonas civPersonasByPerPropietario;
     private CivInfracciones civInfracciones;
     private BigDecimal sedId;
     private String comNumero;
     private Date comFecha;
     private String comHora;
     private BigDecimal comVia;
     private BigDecimal comTipovia;
     private String comDireccion;
     private BigDecimal munId;
     private String locId;
     private BigDecimal divId;
     private String comPlaca;
     private BigDecimal comClase;
     private BigDecimal comServicio;
     private BigDecimal comRadioAccion;
     private BigDecimal comModalidad;
     private BigDecimal comPasajeros;
     private BigDecimal divMatri;
     private String comLicenciacon;
     private String comCategoria;
     private BigDecimal divLicencia;
     private Date comFechavence;
     private BigDecimal comTipoinfractor;
     private String comLicenciatran;
     private BigDecimal divLicenciatra;
     private String comNitempresa;
     private String comNombreempresa;
     private String comTarjetaoperacion;
     private BigDecimal ageId;
     private BigDecimal comFuga;
     private BigDecimal comAccidente;
     private BigDecimal comInmovilizacion;
     private BigDecimal comPolca;
     private BigDecimal comFirmado;
     private BigDecimal comElectronico;
     private BigDecimal comFotomulta;
     private BigDecimal comTipo;
     private String comOrganismo;
     private BigDecimal comEstado;
     private String comGradoalco;
     private Date comFechanoti;
     private BigDecimal usuId;
     private Date comFechaproceso;
     private BigDecimal patId;
     private BigDecimal gruId;
     private String comObservaciones;
     private BigDecimal comTipoingreso;
     private String comDireccioninfra;
     private BigDecimal divDireccioninfra;

    public CivComparendos() {
    }

	
    public CivComparendos(BigDecimal comId, CivPersonas civPersonasByPerId, CivInfracciones civInfracciones, BigDecimal sedId, String comNumero, Date comFecha, String comHora, String comDireccion, BigDecimal munId, BigDecimal comTipoinfractor, BigDecimal ageId, BigDecimal comFuga, BigDecimal comAccidente, BigDecimal comInmovilizacion, BigDecimal comPolca, BigDecimal comFirmado, BigDecimal comElectronico, BigDecimal comFotomulta, BigDecimal comTipo, String comOrganismo, BigDecimal comEstado, BigDecimal usuId, Date comFechaproceso) {
        this.comId = comId;
        this.civPersonasByPerId = civPersonasByPerId;
        this.civInfracciones = civInfracciones;
        this.sedId = sedId;
        this.comNumero = comNumero;
        this.comFecha = comFecha;
        this.comHora = comHora;
        this.comDireccion = comDireccion;
        this.munId = munId;
        this.comTipoinfractor = comTipoinfractor;
        this.ageId = ageId;
        this.comFuga = comFuga;
        this.comAccidente = comAccidente;
        this.comInmovilizacion = comInmovilizacion;
        this.comPolca = comPolca;
        this.comFirmado = comFirmado;
        this.comElectronico = comElectronico;
        this.comFotomulta = comFotomulta;
        this.comTipo = comTipo;
        this.comOrganismo = comOrganismo;
        this.comEstado = comEstado;
        this.usuId = usuId;
        this.comFechaproceso = comFechaproceso;
    }
    public CivComparendos(BigDecimal comId, CivPersonas civPersonasByPerId, CivPersonas civPersonasByPerTestigo, CivPersonas civPersonasByPerPropietario, CivInfracciones civInfracciones, BigDecimal sedId, String comNumero, Date comFecha, String comHora, BigDecimal comVia, BigDecimal comTipovia, String comDireccion, BigDecimal munId, String locId, BigDecimal divId, String comPlaca, BigDecimal comClase, BigDecimal comServicio, BigDecimal comRadioAccion, BigDecimal comModalidad, BigDecimal comPasajeros, BigDecimal divMatri, String comLicenciacon, String comCategoria, BigDecimal divLicencia, Date comFechavence, BigDecimal comTipoinfractor, String comLicenciatran, BigDecimal divLicenciatra, String comNitempresa, String comNombreempresa, String comTarjetaoperacion, BigDecimal ageId, BigDecimal comFuga, BigDecimal comAccidente, BigDecimal comInmovilizacion, BigDecimal comPolca, BigDecimal comFirmado, BigDecimal comElectronico, BigDecimal comFotomulta, BigDecimal comTipo, String comOrganismo, BigDecimal comEstado, String comGradoalco, Date comFechanoti, BigDecimal usuId, Date comFechaproceso, BigDecimal patId, BigDecimal gruId, String comObservaciones, BigDecimal comTipoingreso, String comDireccioninfra, BigDecimal divDireccioninfra) {
       this.comId = comId;
       this.civPersonasByPerId = civPersonasByPerId;
       this.civPersonasByPerTestigo = civPersonasByPerTestigo;
       this.civPersonasByPerPropietario = civPersonasByPerPropietario;
       this.civInfracciones = civInfracciones;
       this.sedId = sedId;
       this.comNumero = comNumero;
       this.comFecha = comFecha;
       this.comHora = comHora;
       this.comVia = comVia;
       this.comTipovia = comTipovia;
       this.comDireccion = comDireccion;
       this.munId = munId;
       this.locId = locId;
       this.divId = divId;
       this.comPlaca = comPlaca;
       this.comClase = comClase;
       this.comServicio = comServicio;
       this.comRadioAccion = comRadioAccion;
       this.comModalidad = comModalidad;
       this.comPasajeros = comPasajeros;
       this.divMatri = divMatri;
       this.comLicenciacon = comLicenciacon;
       this.comCategoria = comCategoria;
       this.divLicencia = divLicencia;
       this.comFechavence = comFechavence;
       this.comTipoinfractor = comTipoinfractor;
       this.comLicenciatran = comLicenciatran;
       this.divLicenciatra = divLicenciatra;
       this.comNitempresa = comNitempresa;
       this.comNombreempresa = comNombreempresa;
       this.comTarjetaoperacion = comTarjetaoperacion;
       this.ageId = ageId;
       this.comFuga = comFuga;
       this.comAccidente = comAccidente;
       this.comInmovilizacion = comInmovilizacion;
       this.comPolca = comPolca;
       this.comFirmado = comFirmado;
       this.comElectronico = comElectronico;
       this.comFotomulta = comFotomulta;
       this.comTipo = comTipo;
       this.comOrganismo = comOrganismo;
       this.comEstado = comEstado;
       this.comGradoalco = comGradoalco;
       this.comFechanoti = comFechanoti;
       this.usuId = usuId;
       this.comFechaproceso = comFechaproceso;
       this.patId = patId;
       this.gruId = gruId;
       this.comObservaciones = comObservaciones;
       this.comTipoingreso = comTipoingreso;
       this.comDireccioninfra = comDireccioninfra;
       this.divDireccioninfra = divDireccioninfra;
    }
   
    public BigDecimal getComId() {
        return this.comId;
    }
    
    public void setComId(BigDecimal comId) {
        this.comId = comId;
    }
    public CivPersonas getCivPersonasByPerId() {
        return this.civPersonasByPerId;
    }
    
    public void setCivPersonasByPerId(CivPersonas civPersonasByPerId) {
        this.civPersonasByPerId = civPersonasByPerId;
    }
    public CivPersonas getCivPersonasByPerTestigo() {
        return this.civPersonasByPerTestigo;
    }
    
    public void setCivPersonasByPerTestigo(CivPersonas civPersonasByPerTestigo) {
        this.civPersonasByPerTestigo = civPersonasByPerTestigo;
    }
    public CivPersonas getCivPersonasByPerPropietario() {
        return this.civPersonasByPerPropietario;
    }
    
    public void setCivPersonasByPerPropietario(CivPersonas civPersonasByPerPropietario) {
        this.civPersonasByPerPropietario = civPersonasByPerPropietario;
    }
    public CivInfracciones getCivInfracciones() {
        return this.civInfracciones;
    }
    
    public void setCivInfracciones(CivInfracciones civInfracciones) {
        this.civInfracciones = civInfracciones;
    }
    public BigDecimal getSedId() {
        return this.sedId;
    }
    
    public void setSedId(BigDecimal sedId) {
        this.sedId = sedId;
    }
    public String getComNumero() {
        return this.comNumero;
    }
    
    public void setComNumero(String comNumero) {
        this.comNumero = comNumero;
    }
    public Date getComFecha() {
        return this.comFecha;
    }
    
    public void setComFecha(Date comFecha) {
        this.comFecha = comFecha;
    }
    public String getComHora() {
        return this.comHora;
    }
    
    public void setComHora(String comHora) {
        this.comHora = comHora;
    }
    public BigDecimal getComVia() {
        return this.comVia;
    }
    
    public void setComVia(BigDecimal comVia) {
        this.comVia = comVia;
    }
    public BigDecimal getComTipovia() {
        return this.comTipovia;
    }
    
    public void setComTipovia(BigDecimal comTipovia) {
        this.comTipovia = comTipovia;
    }
    public String getComDireccion() {
        return this.comDireccion;
    }
    
    public void setComDireccion(String comDireccion) {
        this.comDireccion = comDireccion;
    }
    public BigDecimal getMunId() {
        return this.munId;
    }
    
    public void setMunId(BigDecimal munId) {
        this.munId = munId;
    }
    public String getLocId() {
        return this.locId;
    }
    
    public void setLocId(String locId) {
        this.locId = locId;
    }
    public BigDecimal getDivId() {
        return this.divId;
    }
    
    public void setDivId(BigDecimal divId) {
        this.divId = divId;
    }
    public String getComPlaca() {
        return this.comPlaca;
    }
    
    public void setComPlaca(String comPlaca) {
        this.comPlaca = comPlaca;
    }
    public BigDecimal getComClase() {
        return this.comClase;
    }
    
    public void setComClase(BigDecimal comClase) {
        this.comClase = comClase;
    }
    public BigDecimal getComServicio() {
        return this.comServicio;
    }
    
    public void setComServicio(BigDecimal comServicio) {
        this.comServicio = comServicio;
    }
    public BigDecimal getComRadioAccion() {
        return this.comRadioAccion;
    }
    
    public void setComRadioAccion(BigDecimal comRadioAccion) {
        this.comRadioAccion = comRadioAccion;
    }
    public BigDecimal getComModalidad() {
        return this.comModalidad;
    }
    
    public void setComModalidad(BigDecimal comModalidad) {
        this.comModalidad = comModalidad;
    }
    public BigDecimal getComPasajeros() {
        return this.comPasajeros;
    }
    
    public void setComPasajeros(BigDecimal comPasajeros) {
        this.comPasajeros = comPasajeros;
    }
    public BigDecimal getDivMatri() {
        return this.divMatri;
    }
    
    public void setDivMatri(BigDecimal divMatri) {
        this.divMatri = divMatri;
    }
    public String getComLicenciacon() {
        return this.comLicenciacon;
    }
    
    public void setComLicenciacon(String comLicenciacon) {
        this.comLicenciacon = comLicenciacon;
    }
    public String getComCategoria() {
        return this.comCategoria;
    }
    
    public void setComCategoria(String comCategoria) {
        this.comCategoria = comCategoria;
    }
    public BigDecimal getDivLicencia() {
        return this.divLicencia;
    }
    
    public void setDivLicencia(BigDecimal divLicencia) {
        this.divLicencia = divLicencia;
    }
    public Date getComFechavence() {
        return this.comFechavence;
    }
    
    public void setComFechavence(Date comFechavence) {
        this.comFechavence = comFechavence;
    }
    public BigDecimal getComTipoinfractor() {
        return this.comTipoinfractor;
    }
    
    public void setComTipoinfractor(BigDecimal comTipoinfractor) {
        this.comTipoinfractor = comTipoinfractor;
    }
    public String getComLicenciatran() {
        return this.comLicenciatran;
    }
    
    public void setComLicenciatran(String comLicenciatran) {
        this.comLicenciatran = comLicenciatran;
    }
    public BigDecimal getDivLicenciatra() {
        return this.divLicenciatra;
    }
    
    public void setDivLicenciatra(BigDecimal divLicenciatra) {
        this.divLicenciatra = divLicenciatra;
    }
    public String getComNitempresa() {
        return this.comNitempresa;
    }
    
    public void setComNitempresa(String comNitempresa) {
        this.comNitempresa = comNitempresa;
    }
    public String getComNombreempresa() {
        return this.comNombreempresa;
    }
    
    public void setComNombreempresa(String comNombreempresa) {
        this.comNombreempresa = comNombreempresa;
    }
    public String getComTarjetaoperacion() {
        return this.comTarjetaoperacion;
    }
    
    public void setComTarjetaoperacion(String comTarjetaoperacion) {
        this.comTarjetaoperacion = comTarjetaoperacion;
    }
    public BigDecimal getAgeId() {
        return this.ageId;
    }
    
    public void setAgeId(BigDecimal ageId) {
        this.ageId = ageId;
    }
    public BigDecimal getComFuga() {
        return this.comFuga;
    }
    
    public void setComFuga(BigDecimal comFuga) {
        this.comFuga = comFuga;
    }
    public BigDecimal getComAccidente() {
        return this.comAccidente;
    }
    
    public void setComAccidente(BigDecimal comAccidente) {
        this.comAccidente = comAccidente;
    }
    public BigDecimal getComInmovilizacion() {
        return this.comInmovilizacion;
    }
    
    public void setComInmovilizacion(BigDecimal comInmovilizacion) {
        this.comInmovilizacion = comInmovilizacion;
    }
    public BigDecimal getComPolca() {
        return this.comPolca;
    }
    
    public void setComPolca(BigDecimal comPolca) {
        this.comPolca = comPolca;
    }
    public BigDecimal getComFirmado() {
        return this.comFirmado;
    }
    
    public void setComFirmado(BigDecimal comFirmado) {
        this.comFirmado = comFirmado;
    }
    public BigDecimal getComElectronico() {
        return this.comElectronico;
    }
    
    public void setComElectronico(BigDecimal comElectronico) {
        this.comElectronico = comElectronico;
    }
    public BigDecimal getComFotomulta() {
        return this.comFotomulta;
    }
    
    public void setComFotomulta(BigDecimal comFotomulta) {
        this.comFotomulta = comFotomulta;
    }
    public BigDecimal getComTipo() {
        return this.comTipo;
    }
    
    public void setComTipo(BigDecimal comTipo) {
        this.comTipo = comTipo;
    }
    public String getComOrganismo() {
        return this.comOrganismo;
    }
    
    public void setComOrganismo(String comOrganismo) {
        this.comOrganismo = comOrganismo;
    }
    public BigDecimal getComEstado() {
        return this.comEstado;
    }
    
    public void setComEstado(BigDecimal comEstado) {
        this.comEstado = comEstado;
    }
    public String getComGradoalco() {
        return this.comGradoalco;
    }
    
    public void setComGradoalco(String comGradoalco) {
        this.comGradoalco = comGradoalco;
    }
    public Date getComFechanoti() {
        return this.comFechanoti;
    }
    
    public void setComFechanoti(Date comFechanoti) {
        this.comFechanoti = comFechanoti;
    }
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }
    public Date getComFechaproceso() {
        return this.comFechaproceso;
    }
    
    public void setComFechaproceso(Date comFechaproceso) {
        this.comFechaproceso = comFechaproceso;
    }
    public BigDecimal getPatId() {
        return this.patId;
    }
    
    public void setPatId(BigDecimal patId) {
        this.patId = patId;
    }
    public BigDecimal getGruId() {
        return this.gruId;
    }
    
    public void setGruId(BigDecimal gruId) {
        this.gruId = gruId;
    }
    public String getComObservaciones() {
        return this.comObservaciones;
    }
    
    public void setComObservaciones(String comObservaciones) {
        this.comObservaciones = comObservaciones;
    }
    public BigDecimal getComTipoingreso() {
        return this.comTipoingreso;
    }
    
    public void setComTipoingreso(BigDecimal comTipoingreso) {
        this.comTipoingreso = comTipoingreso;
    }
    public String getComDireccioninfra() {
        return this.comDireccioninfra;
    }
    
    public void setComDireccioninfra(String comDireccioninfra) {
        this.comDireccioninfra = comDireccioninfra;
    }
    public BigDecimal getDivDireccioninfra() {
        return this.divDireccioninfra;
    }
    
    public void setDivDireccioninfra(BigDecimal divDireccioninfra) {
        this.divDireccioninfra = divDireccioninfra;
    }




}

