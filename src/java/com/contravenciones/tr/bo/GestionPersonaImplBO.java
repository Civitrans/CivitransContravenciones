/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.PersonaException;
import com.contravenciones.jdbc.dao.ITDirecciones;
import com.contravenciones.jdbc.dao.ITDivipo;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jsf.bean.BeanGestionPersona;
import com.contravenciones.tr.persistence.CivDirecciones;
import com.contravenciones.tr.persistence.CivDivipos;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivUsuarios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roymer Camacho
 */
public class GestionPersonaImplBO implements GestionPersonaBO {

    private ITPersonas personasDAO;
    private ITParametros parametrosDAO;
    private ITDivipo divipoDAO;
    private ITDirecciones direccionesDAO;

    @Override
    public void listPersona(BeanGestionPersona bean) throws Exception {
        bean.setListPersonas(new ArrayList<>());

        for (CivPersonas per : getPersonasDAO().listarPersonas(bean.getBuscarPersona().toUpperCase())) {
            bean.getListPersonas().add(per);
        }
        if (bean.getListPersonas().isEmpty()) {
            throw new PersonaException("No se encontraron coincidencias.", 2);
        }
        bean.setMostrarConsulta(true);
    }

    @Override
    public void cargarDatos(BeanGestionPersona bean) throws Exception {
        //Combo de Tipo de documento que se encuentra en la tabla parametros
        bean.setListTipoDocumento(new HashMap<>());
        bean.setEstadoPersona(new HashMap<>());
        for (CivParametros objParametros : getParametrosDAO().listParametros(5)) {
            bean.getListTipoDocumento().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        for (CivParametros objParametros : getParametrosDAO().listParametros(391)) {
            bean.getEstadoPersona().put(objParametros.getParCodigo().intValue(), objParametros.getParNombre());
        }
        
    }
    
    @Override
    public void verificarPersona(BeanGestionPersona bean) throws Exception {
       CivPersonas persona = getPersonasDAO().consultarPersonasByDocumento(bean.getTipoDoc(), bean.getDocumento());
       if(persona!=null){
           bean.setBtnRegistrar(true);
            throw new PersonaException("La persona ya existe", 1);
       }else{
           bean.setBtnRegistrar(false);
       }
        
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void guardarPersona(BeanGestionPersona beanPersona) throws Exception {

        if (beanPersona.getDocumento() == null || beanPersona.getDocumento().isEmpty()) {
            throw new PersonaException("No se ha insertado un Documento.", 1);
        }
        if (beanPersona.getTipoDoc() == 0) {
            throw new PersonaException("Seleccione un tipo de Documento.", 1);
        }
        if (beanPersona.getNombre1() == null || beanPersona.getNombre1().isEmpty()) {
            throw new PersonaException("No se ha insertado el Primer Nombre.", 1);
        }
        if (beanPersona.getApellido1() == null || beanPersona.getApellido1().isEmpty()) {
            throw new PersonaException("No se ha insertado el Primer Apellido.", 1);
        }
        if (beanPersona.getFechaExp() == null) {
            throw new PersonaException("No se ha insertado la fecha de Expedición del documento.", 1);
        }
        if (beanPersona.getFechaNac()== null) {
            throw new PersonaException("No se ha insertado la fecha de nacimiento de la persona.", 1);
        }
        if (beanPersona.getDir() == null || beanPersona.getDir().isEmpty()) {
            throw new PersonaException("No se ha insertado la dirección de la persona.", 1);
        }

        CivPersonas persona = getPersonasDAO().consultarPersonasByDocumento(
                beanPersona.getTipoDoc(), beanPersona.getDocumento());
        if (persona != null) {
            beanPersona.setIdpersona(persona.getPerId().intValue());
        } else {
            beanPersona.setIdpersona(0);
        }
        if (beanPersona.getIdpersona() == 0) {
            persona = new CivPersonas();
            persona.setPerFechainicial(new Date());
            persona.setPerFechaproceso(new Date());
            persona.setUsuId(BigDecimal.valueOf((Integer.parseInt(beanPersona.getLoginBean().getID_Usuario()))));
            persona.setPerEstado(BigDecimal.ONE);
        } else {
            persona = getPersonasDAO().consultarPersonasById((int) beanPersona.getIdpersona());
        }

        CivDivipos divipo_nacimiento = getDivipoDAO().getDivipoByDepartamentoByMunicipio(beanPersona.getDepNac(), beanPersona.getMunNac());

        if (divipo_nacimiento == null) {
            throw new Exception("Lugar de nacimiento inválido");
        }
        CivDivipos divipo_exp = getDivipoDAO().getDivipoByDepartamentoByMunicipio(beanPersona.getDepExp(), beanPersona.getMunExp());

        if (divipo_exp == null) {
            throw new Exception("Lugar de expedición inválido");
        }

//        CivMunicipios municipio = getMunicipiosDAO().getMunicipio(beanPersona.getPer().getCodemunicipio());
//        CivDepartamentos departamento = getDepartamentosDAO().getDepartamento(beanPersona.getPer().getCodeDepartamento());
//        if (departamento != null && municipio != null) {
//            //CivDivipos divipoLugarNacimiento = getDiviposDAO().getDivipoByDepartamentoByMunicipio(departamento.getId().getDepId().longValue(), municipio.getMunId().longValue());
//            // esto se debe utilzar cuando se coloque la relacion en la base de datos 
//            throw new Exception("Por implementar");
//        }
        persona.setPerTipodocumento(BigDecimal.valueOf(beanPersona.getTipoDoc()));
        persona.setPerDocumento(beanPersona.getDocumento());
        persona.setPerFechanac(beanPersona.getFechaNac());//buscar campo fecha_nacimiento
        if (beanPersona.getGrupoSang() != null && beanPersona.getGrupoSang().length() > 0) {
            if (beanPersona.getGrupoSang().length() == 2) {
                persona.setPerGruposanguineo(beanPersona.getGrupoSang().charAt(0) + "");
                persona.setPerRh(beanPersona.getGrupoSang().charAt(1) + "");
            } else if (beanPersona.getGrupoSang().length() == 3) {
                persona.setPerGruposanguineo((beanPersona.getGrupoSang().charAt(0) + "") + beanPersona.getGrupoSang().charAt(1) + "");
                persona.setPerRh(beanPersona.getGrupoSang().charAt(2) + "");
            }
        }

        beanPersona.getGrupoSang(); //Validación Especial
        persona.setPerSexo(beanPersona.getSexo());
        persona.setPerNombre1(beanPersona.getNombre1().toUpperCase());
        persona.setPerNombre2(beanPersona.getNombre2().toUpperCase());
        persona.setPerApellido1(beanPersona.getApellido1().toUpperCase());
        persona.setPerApellido2(beanPersona.getApellido2().toUpperCase());
        persona.setPerEmail(beanPersona.getEmail().toLowerCase());
        persona.setPerCelular(beanPersona.getCelular());
//        persona.setPerLugarnacimiento(beanPersona.getPer().getCodDivipo() > 0 ? BigDecimal.valueOf(beanPersona.getPer().getCodDivipo()) : null);
        persona.setPerLugarnacimiento(divipo_nacimiento.getDivId());
        persona.setPerLugarexpedicion(divipo_exp.getDivId());
        persona.setPerFechaexp(beanPersona.getFechaExp());
        persona.setPerDocumento(beanPersona.getDocumento());

        if (beanPersona.getIdpersona() != 0) {
            persona.setPerId(BigDecimal.valueOf(beanPersona.getIdpersona()));
            if (!getPersonasDAO().update(persona)) {
                throw new PersonaException("Persona no pudo ser actualizada.", 1);
            }
        } else {
            if (getPersonasDAO().insert(persona) == 0) {
                throw new PersonaException("Persona no pudo ser ingresada.", 1);
            }
        }

        CivDirecciones direccion = new CivDirecciones();

        CivDivipos divipo_direccion = getDivipoDAO().getDivipoByDepartamentoByMunicipio(
                beanPersona.getDepDir(),
                beanPersona.getMunDir());

        if (divipo_direccion == null || divipo_direccion.getDivCodigo() == null || divipo_direccion.getDivCodigo().intValue() == 0) {
            throw new PersonaException("Los datos de dirección de la persona son Incorrectos.", 1);
        }

        direccion.setDirDescripcion(beanPersona.getDir());
        direccion.setDirTelefono(beanPersona.getTelefono());
        direccion.setDirEstado(BigDecimal.ONE);
        direccion.setDirFechainicial(new Date());
        direccion.setDirFechaproceso(new Date());
        direccion.setCivPersonas(persona);

        direccion.setCivDivipos(divipo_direccion);
        if (getDireccionesDAO().insert(direccion) == 0) {
            throw new PersonaException("Direccion no pudo ser ingresada.", 1);
        }

    }

    /**
     * @return the personasDAO
     */
    public ITPersonas getPersonasDAO() {
        return personasDAO;
    }

    /**
     * @param personasDAO the personasDAO to set
     */
    public void setPersonasDAO(ITPersonas personasDAO) {
        this.personasDAO = personasDAO;
    }

    /**
     * @return the parametrosDAO
     */
    public ITParametros getParametrosDAO() {
        return parametrosDAO;
    }

    /**
     * @param parametrosDAO the parametrosDAO to set
     */
    public void setParametrosDAO(ITParametros parametrosDAO) {
        this.parametrosDAO = parametrosDAO;
    }

    /**
     * @return the divipoDAO
     */
    public ITDivipo getDivipoDAO() {
        return divipoDAO;
    }

    /**
     * @param divipoDAO the divipoDAO to set
     */
    public void setDivipoDAO(ITDivipo divipoDAO) {
        this.divipoDAO = divipoDAO;
    }

    /**
     * @return the direccionesDAO
     */
    public ITDirecciones getDireccionesDAO() {
        return direccionesDAO;
    }

    /**
     * @param direccionesDAO the direccionesDAO to set
     */
    public void setDireccionesDAO(ITDirecciones direccionesDAO) {
        this.direccionesDAO = direccionesDAO;
    }

}
