/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jdbc.dao.ITAgentes;
import com.contravenciones.jdbc.dao.ITCargueComparendos;
import com.contravenciones.jdbc.dao.ITCarteras;
import com.contravenciones.jdbc.dao.ITComparendos;
import com.contravenciones.jdbc.dao.ITDetalleCarteras;
import com.contravenciones.jdbc.dao.ITDirecciones;
import com.contravenciones.jdbc.dao.ITDivipo;
import com.contravenciones.jdbc.dao.ITEstructuraSimit;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jdbc.dao.ITSalarioMinimo;
import com.contravenciones.jdbc.dao.ITTipoDocumento;
import com.contravenciones.jsf.bean.BeanGestionPersona;
import com.contravenciones.jsf.bean.BeanPlanos;
import com.contravenciones.tr.persistence.CivAgentes;
import com.contravenciones.tr.persistence.CivCarguecomparendo;
import com.contravenciones.tr.persistence.CivCarteras;
import com.contravenciones.tr.persistence.CivComparendos;
import com.contravenciones.tr.persistence.CivConceptos;
import com.contravenciones.tr.persistence.CivDetallecartera;
import com.contravenciones.tr.persistence.CivDirecciones;
import com.contravenciones.tr.persistence.CivDivipos;
import com.contravenciones.tr.persistence.CivEstructuraSimit;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivSalariosminimos;
import com.contravenciones.tr.persistence.CivTipocarteras;
import com.contravenciones.tr.persistence.CivTipodocumentos;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Soporte 2
 */
public class PlanosImplBO implements PlanosBO {

    // FECHA DEL SISTEMA QUE SE UTILIZA PARA COMPLEMENTAR EN NOMBRE DE LA CARPETA EN CONDE SE GUARDARA EL ARCHIVO CARGADO
    private SimpleDateFormat dirDate = new SimpleDateFormat("ddMMYYYY");
    private SimpleDateFormat vigenciaActual = new SimpleDateFormat("YYYY");
    // FECHA DEL SISTEMA QUE SE UTILIZA PARA COMPLEMENTAR EN NOMBRE DE LA CARPETA EN CONDE SE GUARDARA EL ARCHIVO CARGADO
    private SimpleDateFormat sudDirDate = new SimpleDateFormat("dd-MM-YYYY hh mm ss");

    private java.sql.Date fecha_Actual = new java.sql.Date(new java.util.Date().getTime());
    private java.sql.Timestamp fechaSystem = new java.sql.Timestamp(new java.util.Date().getTime());

    // INTERFACE QUE SE UTILIZA PARA OBTENER LA ESTRUCTURA DEL PLANO SEGUN SU TIPO
    private ITEstructuraSimit estructuraSimitDAO;
    // INTERFACE QUE SE UTILIZA PARA GUARDAR EL COMPARENDO
    private ITCargueComparendos cargueComparendosDAO;
    // OBJETO QUE SE UTILIZA PARA GUARDAR Y RETORNAR
    private CivCarguecomparendo civCargueComparendo;
    private ITComparendos comparendosDAO;
    private CivComparendos civcomparendo;
    private ITDivipo divipoDAO;
    private ITPersonas personasDAO;
    private ITDirecciones direccionesDAO;
    private ITParametros parametrosDAO;
    private ITTipoDocumento tiposDocumentosDAO;
    private ITAgentes agentesDAO;
    private ITCarteras carterasDAO;
    private ITSalarioMinimo salarioMinimoDAO;
    private ITDetalleCarteras detalleCarterasDAO;
// VARIABLE QUE SE UTILIZA PARA SABER SI CADA LINEA ES CORRECTA PARA SU ALMACENAMIENTO 
    private boolean correcto;
    // VARIABLE QUE SE UTILIZARA PARA SABER QUE LINEA SE ESTA VALIDANDO
    private String registroLinea;
    // LISTA QUE CONTIENE LAS LINEAS DEL ARCHIVO LEIDO
    private List lineasPlano;

    private String msg = "";
    private String valor = "";
    private String campo = "";

    @Override
    public boolean guardarComparendoPlano(BeanPlanos bean) throws Exception {
        String linea = "";
        int cantidadRegistro = 0;
        if (bean.getFile() == null) {
            return false;
        }

        if (bean.getFile().getName().isEmpty()) {
            return false;
        }

        if (!bean.getFile().getContentType().equals("text/plain")) {
            return false;
        }
        java.io.DataInputStream dis = new DataInputStream(bean.getFile().getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(dis));
        while ((linea = reader.readLine()) != null) {
            cantidadRegistro++;
            java.util.List listaCampos = obtenerCampos(linea);
            if (listaCampos.size() <= 4) {
                continue;
            }
            if (validarlineaComparendo(listaCampos, 1)) {
                CivCarguecomparendo migracionComp = getCargueComparendosDAO().getCargueComparendo(Long.parseLong(listaCampos.get(1).toString()), listaCampos.get(14).toString(), Long.parseLong(listaCampos.get(15).toString()));
                if (migracionComp == null) {
                    if (guardarCargueComparendo(listaCampos)) {
                        if (guardarComparendo(getCivCargueComparendo())) {

                        }
                        setMsg(getRegistroLinea() + " - Guardado Exitosamente");
                        setCorrecto(true);
                    } else {
                        setMsg(getRegistroLinea() + " - Guardado Exitosamente");
                        bean.setNoCargados((bean.getNoCargados() + 1));
                        setCorrecto(false);
                    }

                } else {
                    setMsg(getRegistroLinea() + " - Ya se encuentra Registrado");
                    bean.setNoCargados((bean.getNoCargados() + 1));
                    setCorrecto(false);
                }
            }

            bean.setHashLine(new HashMap<>());
            bean.setListLinea(new LinkedList<>());
            bean.getHashLine().put("linea", cantidadRegistro + "");
            bean.getHashLine().put("msg", getMsg());
            bean.getHashLine().put("value", "");
            bean.getListLinea().add(bean.getHashLine());
        }

        return true;
    }

    @Override
    public boolean validarlineaComparendo(List listaCampos, int tipo) throws Exception {
        int numeroCampo = 0;
        String nombreCampo = "";
        setRegistroLinea(" Registro " + (listaCampos.get(0).toString() != null ? listaCampos.get(0).toString() : "") + "-" + (listaCampos.get(1).toString() != null ? listaCampos.get(1).toString() : " Sin Comparendo"));
        int cantidadCampos = listaCampos.size();
        try {
            if (listaCampos.size() < 57) {
                setMsg(getRegistroLinea() + " linea no cumple con los campos minimos. valor Minimo(57) valor Obtenido (" + listaCampos.size() + ")");
                return false;
            }

            if (listaCampos.size() > 60) {
                setMsg(getRegistroLinea() + " linea no cumple con los campos maximo. valor Maximo(60) valor Obtenido (" + listaCampos.size() + ")");
                return false;
            }

            if (listaCampos.get(55).equals("F")) {
                cantidadCampos = 57;
                if (listaCampos.size() < 58) {
                    setMsg(getRegistroLinea() + " linea no cumple con los campos minimos. Campo grado de alcohol no reportado.");
                    return false;
                }
            }

            if (!listaCampos.get(55).equals("F") && listaCampos.size() > 57) {
                if (listaCampos.size() == 59) {
                    cantidadCampos = 59;
                    if (!listaCampos.get(57).equals("S") && !listaCampos.get(57).equals("N")) {
                        setMsg(getRegistroLinea() + " linea no cumple con los campos minimos. Campo Foto Multa no reportado correctamente.");
                        return false;
                    }
                } else {
                    if (listaCampos.size() == 60) {
                        cantidadCampos = 60;
                        if (!listaCampos.get(58).equals("S") && !listaCampos.get(58).equals("N")) {
                            setMsg(getRegistroLinea() + " linea no cumple con los campos minimos. Campo Foto Multa no reportado correctamente.");
                            return false;
                        }
                    }
                }
            }

            for (int i = 0; i < cantidadCampos; i++) {
                numeroCampo = i + 1;
                CivEstructuraSimit estructura = getEstructuraSimitDAO().getEstructuraSimit((i + 1), tipo);
                nombreCampo = estructura.getEstrNombreCampo();
                setValor(listaCampos.get(i).toString());
                if (getValor().trim().equals("") || getValor().isEmpty()) {
                    if (estructura.getEstrObligatorio().equals("S")) {
                        setMsg(getRegistroLinea() + " - error en (" + estructura.getEstrNombreCampo() + ") el campo es obligatorio - en el campo: (" + (i + 1) + ")");
                        return false;
                    } else {
                        if (nombreCampo.equals("COMNOMBREPROP")) {
                            if ((!listaCampos.get(30).equals("")) && (!listaCampos.get(31).equals(""))) {
                                setMsg(getRegistroLinea() + " - error en(" + estructura.getEstrNombreCampo() + ")  COMNOMBREPROP no puede ser vacio si existe documento de identidad" + "- en el campo: (" + (i + 1) + ")");
                                return false;
                            }
                        }
                        setValor("");
                    }
                } else {
                    if (getValor().length() < estructura.getEstrLongitudMin().intValue()) {
                        setMsg(getRegistroLinea() + " - longitud no permitida en (" + estructura.getEstrNombreCampo() + ") min( :" + estructura.getEstrLongitudMin().intValue() + ") real(" + getValor().length() + ") valor:" + getValor() + "- en el campo: (" + (i + 1) + ")");
                        return false;
                    }
                    if (getValor().length() > estructura.getEstrLongitudMax().intValue()) {

                        setMsg(getRegistroLinea() + " - longitud no permitida en (" + estructura.getEstrNombreCampo() + ")  max( :" + estructura.getEstrLongitudMax().intValue() + ") real(" + getValor().length() + ") valor:" + getValor() + "- en el campo: (" + (i + 1) + ")");
                        return false;
                    }
                    if (estructura.getEstrTipoDato().equals("numerico")) {
                        try {
                            long valorEntero = Long.parseLong(getValor());
                        } catch (NumberFormatException e) {
                            setMsg(getRegistroLinea() + " - error en (" + estructura.getEstrNombreCampo() + ") al convertir valor a entero :(" + getValor() + ") causa :" + e.getMessage() + "- en el campo: (" + (i + 1) + ")");
                            return false;
                        }

                    }
                    if (estructura.getEstrTipoDato().equals("fecha")) {
                        try {
                            Date valorFecha = new Date(new java.text.SimpleDateFormat("dd/mm/yyyy").parse(getValor()).getTime());
                        } catch (ParseException ex) {
                            setMsg(getRegistroLinea() + " - error en(" + estructura.getEstrNombreCampo() + ")  al convertir valor a fecha:(" + getValor() + ") requerido 'dd/mm/yyyy' causa :" + ex.getMessage() + "- en el campo: (" + (i + 1) + ")");
                            return false;
                        }
                    }

                }
            }
            return true;
        } catch (Exception e) {
            setMsg(getRegistroLinea() + " - Error Fatal : " + e + "En el campo (" + nombreCampo + ")(" + numeroCampo + ") valor (" + getValor() + ")");
            return false;
        }
    }

    @Override
    public boolean guardarCargueComparendo(List listaCampoValidados) throws Exception {
        setCivCargueComparendo(new CivCarguecomparendo());
        getCivCargueComparendo().setComconsecutivo(listaCampoValidados.get(0).toString().toString());
        getCivCargueComparendo().setComnumero(listaCampoValidados.get(1).toString());
        getCivCargueComparendo().setComfecha(listaCampoValidados.get(2).toString());
        getCivCargueComparendo().setComhora(listaCampoValidados.get(3).toString());
        getCivCargueComparendo().setComdir(listaCampoValidados.get(4).toString());
        getCivCargueComparendo().setComdivipomuni(listaCampoValidados.get(5).toString());
        getCivCargueComparendo().setComlocalidadcomuna(listaCampoValidados.get(6).toString());
        getCivCargueComparendo().setComplaca(listaCampoValidados.get(7).toString());
        getCivCargueComparendo().setComdivipomatri(listaCampoValidados.get(8).toString());
        getCivCargueComparendo().setComtipovehi(listaCampoValidados.get(9).toString());
        getCivCargueComparendo().setComtiposer(listaCampoValidados.get(10).toString());
        getCivCargueComparendo().setComcodigoradio(listaCampoValidados.get(11).toString());
        getCivCargueComparendo().setComcodigomodalidad(listaCampoValidados.get(12).toString());
        getCivCargueComparendo().setComcodigopasajeros(listaCampoValidados.get(13).toString());
        getCivCargueComparendo().setCominfractor(listaCampoValidados.get(14).toString());
        getCivCargueComparendo().setComtipodoc(listaCampoValidados.get(15).toString());
        getCivCargueComparendo().setComnombe(listaCampoValidados.get(16).toString());
        getCivCargueComparendo().setComapellido(listaCampoValidados.get(17).toString());
        getCivCargueComparendo().setComedadinfractor(listaCampoValidados.get(18).toString());
        getCivCargueComparendo().setComdirinfractor(listaCampoValidados.get(19).toString());
        getCivCargueComparendo().setComemail(listaCampoValidados.get(20).toString());
        getCivCargueComparendo().setComteleinfractor(listaCampoValidados.get(21).toString());
        getCivCargueComparendo().setComidciudad(listaCampoValidados.get(22).toString());
        getCivCargueComparendo().setComlicencia(listaCampoValidados.get(23).toString());
        getCivCargueComparendo().setComcategoria(listaCampoValidados.get(24).toString());
        getCivCargueComparendo().setComsecreexpide(listaCampoValidados.get(25).toString());
        getCivCargueComparendo().setComfechavence(listaCampoValidados.get(26).toString());
        getCivCargueComparendo().setComtipoinfrac(listaCampoValidados.get(27).toString());
        getCivCargueComparendo().setComplictransito(listaCampoValidados.get(28).toString());
        getCivCargueComparendo().setComdivipolicen(listaCampoValidados.get(29).toString());
        getCivCargueComparendo().setComidentificacion(listaCampoValidados.get(30).toString());
        getCivCargueComparendo().setComidtipodocprop(listaCampoValidados.get(31).toString());
        getCivCargueComparendo().setComnombreprop(listaCampoValidados.get(32).toString());
        getCivCargueComparendo().setComnombreempresa(listaCampoValidados.get(33).toString());
        getCivCargueComparendo().setComnitempresa(listaCampoValidados.get(34).toString());
        getCivCargueComparendo().setComtarjetaoperacion(listaCampoValidados.get(35).toString());
        getCivCargueComparendo().setCompplacaagente(listaCampoValidados.get(36).toString());
        getCivCargueComparendo().setComobserva(listaCampoValidados.get(37).toString());
        getCivCargueComparendo().setComfuga(listaCampoValidados.get(38).toString());
        getCivCargueComparendo().setComacci(listaCampoValidados.get(39).toString());
        getCivCargueComparendo().setCominmov(listaCampoValidados.get(40).toString());
        getCivCargueComparendo().setCompatioinmoviliza(listaCampoValidados.get(41).toString());
        getCivCargueComparendo().setComdirpatioinmovi(listaCampoValidados.get(42).toString());
        getCivCargueComparendo().setComgruanumero(listaCampoValidados.get(43).toString());
        getCivCargueComparendo().setComplacagrua(listaCampoValidados.get(44).toString());
        getCivCargueComparendo().setComconsecutiinmovi(listaCampoValidados.get(45).toString());
        getCivCargueComparendo().setComidentificaciontest(listaCampoValidados.get(46).toString());
        getCivCargueComparendo().setComnombretesti(listaCampoValidados.get(47).toString());
        getCivCargueComparendo().setComdirecrestesti(listaCampoValidados.get(48).toString());
        getCivCargueComparendo().setComteletestigo(listaCampoValidados.get(49).toString());
        getCivCargueComparendo().setComvalor(listaCampoValidados.get(50).toString());
        getCivCargueComparendo().setComvalad(listaCampoValidados.get(51).toString());
        getCivCargueComparendo().setComorganismo(listaCampoValidados.get(52).toString());
        getCivCargueComparendo().setComestadocom(listaCampoValidados.get(53).toString());
        getCivCargueComparendo().setCompolca(listaCampoValidados.get(54).toString());
        getCivCargueComparendo().setCominfraccion(listaCampoValidados.get(55).toString());
        getCivCargueComparendo().setComvalinfra(listaCampoValidados.get(56).toString());
        //validacion para cuando sea foto multa
        if (listaCampoValidados.size() > 57) {
            getCivCargueComparendo().setGradoalcohol(listaCampoValidados.get(57).equals("") ? "" : listaCampoValidados.get(57).toString());
            getCivCargueComparendo().setFotomulta(listaCampoValidados.get(58).equals("") ? "" : listaCampoValidados.get(58).toString());
            getCivCargueComparendo().setFechaDeNotificacion(listaCampoValidados.get(59).equals("") ? "" : listaCampoValidados.get(59).toString());
        } else {
            getCivCargueComparendo().setGradoalcohol("");
            getCivCargueComparendo().setFotomulta("");
            getCivCargueComparendo().setFechaDeNotificacion(getCampo());
        }
        getCivCargueComparendo().setEstado(new BigDecimal(1));
        getCargueComparendosDAO().insert(getCivCargueComparendo());
        boolean respuesta = true;
        return respuesta;
    }

    @Override
    public boolean guardarComparendo(CivCarguecomparendo cargueComparendo) throws SQLException, ParseException, Exception {

        //-------------------------------------------------------------------//
        //--------------------- DECLARACION DE VARIABLES --------------------//
        //-------------------------------------------------------------------//
        java.sql.Date fechaNotificiacion = null;
        // ESTADO DEL COMPARENDO SE INICIALIZA EN 1(ACTIVO)
        long estadoComparendo = 1;
        int idconcepto = 0;
        //-------------------------------------------------------------------//
        //---------------------- VALIDACION PRINCIPAL -----------------------//
        //-------------------------------------------------------------------//
        // SE CONSULTA EL COMPARENDO POR EL NUMERO EN LA TABLA CIV_COMPARENDOS PARA SABER SI EL COMPARENDO YA EXISTE
        CivComparendos comparendo = getComparendosDAO().getComparendo(cargueComparendo.getComnumero());
        // SI EL COMPARENDO EXISTE NO PUEDE SER INGRESADO NUEVAMENTE
        if (comparendo != null) {
            setMsg(getRegistroLinea() + "Comparendo Ya se encuentra Registrado");
            return false;
        }
        //*-------------------------------------------------------------------------------------------------------------------------------------*/
        // /*------------------------------------------------------- REGISTRO DE LA PERSONA INFRACTORA ------------------------------------------*/
        // /*-----------------------------------------------------------------------------------------------------------------------------------*/

        CivPersonas infractor = new CivPersonas();
        // SE VALIDA QUE LA PERSONA INFRACTORA TENGA UN NOMBRE
        if (cargueComparendo.getCominfractor().equals("")) {
            // SI EL INFRACTOR NO POSEE NOMBRE SE CONSULTA LA PERSONA INDETERMINADA
            infractor = getPersonasDAO().consultarPersonasById(0);//PERSONA INDETERMINADA
            // SE COLOCA EL COMPARENDO EN ESTADO INDETERMINADO
            estadoComparendo = 14;

        } else {
            // SE CONSULTA LA PERSONA PARA SABER SI EXISTE EN EL SISTEMA
            infractor = getPersonasDAO().consultarPersonasByDocumento(Integer.parseInt(cargueComparendo.getComtipodoc()), cargueComparendo.getCominfractor());
        }
        // SI LA PERSONA NO EXISTE EN EL SISTEMA SE PROCESE A INGRESARLA
        if (infractor == null) {
            // SE INICIALIZA EL OBJETO PERSONA
            infractor = new CivPersonas();
            //--------------- DATOS TIPO DOCUMENTO -------------/
            CivTipodocumentos tipoDocumentoInfractor = new CivTipodocumentos();
            tipoDocumentoInfractor.setTipdocCodigo(new BigDecimal(cargueComparendo.getComtipodoc()));
            //---------------------------------------------------------//
            infractor.setCivTipodocumentos(tipoDocumentoInfractor);
            infractor.setPerDocumento(cargueComparendo.getCominfractor());
            infractor.setPerNombre1(cargueComparendo.getComnombe());
            infractor.setPerApellido1(cargueComparendo.getComapellido());
            infractor.setPerEmail(cargueComparendo.getComemail());
            // SE INGRESA LA PERSONA Y SE OBTIENE SU ID PARA LLENAR COMPLETAMENTE EL OBJETO
            infractor.setPerId(new BigDecimal(getPersonasDAO().insert(infractor)));
            // SI LA PERSONA POSEE DIRECCION SE PROCESE A INGRESARLA AL SISTEMA
            if (!cargueComparendo.getComdirinfractor().equals("")) {
                CivDirecciones direccionPersonaInfractora = new CivDirecciones();
                direccionPersonaInfractora.setDirDescripcion(cargueComparendo.getComdirinfractor());
                direccionPersonaInfractora.setDirFechainicial(getFecha_Actual());
                direccionPersonaInfractora.setDirEstado(BigDecimal.ONE);
                direccionPersonaInfractora.setDirTelefono(cargueComparendo.getComteleinfractor());
                direccionPersonaInfractora.setCivPersonas(infractor);
                // SI EL CODIGO DE LA CIUDAD DE LA DIRECCION DE LA PERSONA CONTIENE UN VALOR SE POSEE A INGRESARLA EN EL SISTEMA
                if (Long.parseLong(cargueComparendo.getComidciudad()) != 0) {
                    // SE CONSULTA EL DIVIPO DE LA CIUDAD
                    CivDivipos divipoDireccionInfractor = getDivipoDAO().getDivipoByCode(Long.parseLong(cargueComparendo.getComidciudad()));
                    // SI SE ENCUENTRA EL DIVIPO EN EL SISTEMA SE INGRESA EN LA DIRECCION DE LA PERSONA
                    if (divipoDireccionInfractor == null) {
                        setMsg(getRegistroLinea() + "No se pudo ingresar la persona ya que no posee divipo la direccion");
                        return false;
                    }
                    direccionPersonaInfractora.setCivDivipos(divipoDireccionInfractor);
                    getDireccionesDAO().insert(direccionPersonaInfractora);
                }
            }
        }
        //----------------------------------------------------------------------------------------------------//
        //---------------------------------- FIN REGISTRO PERSONA INFRACTORA ---------------------------------//
        //----------------------------------------------------------------------------------------------------//

        //----------------------------------------------------------------------------------------------------//
        //----------------------------------REGISTRO DE LA PERSONA PROPIETARIO --------------------------------//
        //----------------------------------------------------------------------------------------------------//
        CivPersonas personaPropietario = new CivPersonas();
        if (!(cargueComparendo.getComidtipodocprop().isEmpty() && cargueComparendo.getComidentificacion().isEmpty())) {
            if ((!cargueComparendo.getComidtipodocprop().equals("")) && (!cargueComparendo.getComidentificacion().equals(""))) {
                personaPropietario = getPersonasDAO().consultarPersonasByDocumento(Integer.parseInt(cargueComparendo.getComidtipodocprop()), cargueComparendo.getComidentificacion());
                // se crea la persona en la base de datos si no existe
                if (personaPropietario == null) {
                    personaPropietario = new CivPersonas();
                    //--------------- DATOS TIPO DOCUMENTO -------------/
                    CivTipodocumentos tipoDocumentoPropietario = new CivTipodocumentos();
                    tipoDocumentoPropietario.setTipdocCodigo(new BigDecimal(cargueComparendo.getComtipodoc()));
                    //---------------------------------------------------------//
                    personaPropietario.setCivTipodocumentos(tipoDocumentoPropietario);
                    personaPropietario.setPerDocumento(cargueComparendo.getComidentificacion());
                    personaPropietario.setPerNombre1(cargueComparendo.getComnombreprop()); //Revisar
                    personaPropietario.setPerApellido1(" "); //Revisar Vacía
                    personaPropietario.setPerEmail(cargueComparendo.getComemail());
                    personaPropietario.setPerId(new BigDecimal(getPersonasDAO().insert(personaPropietario)));
                }
            }
        }
        //----------------------------------------------------------------------------------------------------//
        //---------------------------------- FIN REGISTRO PERSONA PROPIETARIO --------------------------------//
        //----------------------------------------------------------------------------------------------------//

        //---------------------------------------------------------------------------------------------------//
        //---------------------------------- REGISTRO PERSONA TESTIGO ----------------------------------//
        //---------------------------------------------------------------------------------------------------//
        CivPersonas testigo = getPersonasDAO().consultarPersonasByDocumento(1, cargueComparendo.getComidentificaciontest());
        if (testigo == null && !cargueComparendo.getComidentificaciontest().isEmpty() && !cargueComparendo.getComnombretesti().equals("")) {
            testigo = new CivPersonas();
            //--------------- DATOS TIPO DOCUMENTO -------------/
            CivTipodocumentos tipoDocumentoTestigo = new CivTipodocumentos();
            tipoDocumentoTestigo.setTipdocCodigo(new BigDecimal(cargueComparendo.getComtipodoc()));
            //---------------------------------------------------------//
            testigo.setCivTipodocumentos(tipoDocumentoTestigo);
            testigo.setPerDocumento(cargueComparendo.getComidentificaciontest());
            testigo.setPerNombre1(cargueComparendo.getComnombretesti());
            testigo.setPerApellido1(" ");
            testigo.setPerCelular(cargueComparendo.getComteletestigo());
            testigo.setPerId(new BigDecimal(getPersonasDAO().insert(testigo)));

            if (!cargueComparendo.getComdirecrestesti().equals("")) {
                CivDirecciones direccionTestigo = new CivDirecciones();
                direccionTestigo.setDirDescripcion(cargueComparendo.getComdirecrestesti());
                direccionTestigo.setDirFechainicial(getFecha_Actual());
                direccionTestigo.setDirFechaproceso(getFecha_Actual());
                direccionTestigo.setDirEstado(new BigDecimal(1));
                direccionTestigo.setCivPersonas(testigo);
                if (Integer.parseInt(cargueComparendo.getComidciudad()) != 0) {
                    CivDivipos divipoTestigo = getDivipoDAO().getDivipoByCode(Long.parseLong((cargueComparendo.getComidciudad())));
                    if (divipoTestigo != null) {
                        direccionTestigo.setCivDivipos(divipoTestigo);
                        getDivipoDAO().insert(divipoTestigo);
                    }
                }
            }
        }
        //----------------------------------------------------------------------------------------------------//
        //---------------------------------- FIN REGISTRO PERSONA TESTIGO ------------------------------------//
        //----------------------------------------------------------------------------------------------------//

        //----------------------------------------------------------------------------------------------------//
        //-------------------------------------INICIO REGISTRO DE LA CARTERA ---------------------------------//
        //----------------------------------------------------------------------------------------------------//
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //PARAMETRIZAR ESTO PARA QUE FUNCIONE DEPENDIENDO EL TRANSITO
        long vigenciaComparendo = Long.parseLong(dateFormat.format(cargueComparendo.getComfecha()));
        if (vigenciaComparendo == Long.parseLong(dateFormat.format(getFecha_Actual()))) {
            idconcepto = 12;
        } else {
            idconcepto = 100;
        }

        CivCarteras cartera = new CivCarteras();
        CivTipocarteras tipoCartera = new CivTipocarteras();
        tipoCartera.setTipcarCodigo(new BigDecimal(1));
        cartera.setCivTipocarteras(tipoCartera);
        cartera.setCarReferencia1(cargueComparendo.getComnumero());
        cartera.setCarReferencia2("");
        cartera.setCarValor(new BigDecimal(cargueComparendo.getComvalinfra()));
        cartera.setCarSaldo(new BigDecimal(cargueComparendo.getComvalinfra()));
        CivConceptos concepto = new CivConceptos();
        concepto.setConId(new BigDecimal(12));
        cartera.setCivConceptos(concepto);
        cartera.setCarPeriodo(new BigDecimal(getVigenciaActual() + ""));
        cartera.setCarFechafinal(getFecha_Actual());
        cartera.setCarEstado(new BigDecimal(1));
        cartera.setCarId(new BigDecimal(getCarterasDAO().insert(cartera)));
        //----------------------------------------------------------------------------------------------------//
        //---------------------------------- FIN REGISTRO CARTERA COMPARENDO ---------------------------------//
        //----------------------------------------------------------------------------------------------------//

        //----------------------------------------------------------------------------------------------------//
        //------------------------------- INGRESO DE LA DETALLE CARTERA --------------------------------------//
        //----------------------------------------------------------------------------------------------------//
        CivSalariosminimos salariosMinimos = getSalarioMinimoDAO().salarioByVigencia(vigenciaComparendo);

        CivDetallecartera detalleCartera = new CivDetallecartera();
        detalleCartera.setCivCarteras(cartera);
        detalleCartera.setDetcarReferencia(cartera.getCarReferencia1());
        detalleCartera.setDetcarFecha(getFecha_Actual());
        //detalleCartera.setDetcarEstado(new BigDecimal(1));
        double valor = 0;

        if (Integer.parseInt(cargueComparendo.getCompolca()) == 1) {
            CivConceptos conceptoPolca = new CivConceptos();
            conceptoPolca.setConId(new BigDecimal(73));

            detalleCartera.setCivConceptos(conceptoPolca);
            valor = cartera.getCarValor().intValue() * 0.55;
            detalleCartera.setDetcarValor(new BigDecimal(valor));
            getDetalleCarterasDAO().insert(detalleCartera);

            detalleCartera.setCivConceptos(concepto);
            valor = cartera.getCarValor().intValue() * 0.45;
            detalleCartera.setDetcarValor(new BigDecimal(valor));
            getDetalleCarterasDAO().insert(detalleCartera);
        } else {
            CivConceptos conceptoSimit = new CivConceptos();
            conceptoSimit.setConId(new BigDecimal(88));

            detalleCartera.setCivConceptos(conceptoSimit);
            valor = cartera.getCarValor().intValue() * 0.1;

            double VrSMLDV = 0;
            VrSMLDV = (double) salariosMinimos.getSalValor().intValue() / 30;
            if (valor < (VrSMLDV * 0.5)) {
                detalleCartera.setDetcarValor(new BigDecimal(VrSMLDV));
                getDetalleCarterasDAO().insert(detalleCartera);

                detalleCartera.setCivConceptos(concepto);
                valor = cartera.getCarValor().intValue() - VrSMLDV;
                detalleCartera.setDetcarValor(new BigDecimal(valor));
                getDetalleCarterasDAO().insert(detalleCartera);
            } else {
                detalleCartera.setDetcarValor(new BigDecimal(valor));
                getDetalleCarterasDAO().insert(detalleCartera);

                detalleCartera.setCivConceptos(concepto);
                valor = cartera.getCarValor().intValue() * 0.9;
                detalleCartera.setDetcarValor(new BigDecimal(valor));
                getDetalleCarterasDAO().insert(detalleCartera);
            }
        }
        //----------------------------------------------------------------------------------------------------//
        //---------------------------------------------- REGISTRO AGENTE -------------------------------------//
        //----------------------------------------------------------------------------------------------------//
//        CivAgentes agente = getAgentesDAO().getAgente(cargueComparendo.getCompplacaagente());
//        if (agente == null) {
//            agente = new CivAgentes();
//            agente.setAgeFechaInicio(getFecha_Actual());
//            agente.setNombre("AGENTE PLANO SIMIT"); //Revisar
//            agente.setPlaca(cargueComparendo.getCOMPPLACAAGENTE());
//            agente.setTipo(cargueComparendo.getCOMPOLCA().equals("S") ? 2 : 1);
//            idAgente = model.adicionarAgente(agente);
//        }
        long idDivipoMatri = 0, idDivipoLicCond = 0, idDivipoLicTran = 0;
        if (cargueComparendo.getFotomulta().equals("") && (!cargueComparendo.getFotomulta().isEmpty())) {
            getCivcomparendo().setComFotomulta((cargueComparendo.getFotomulta().equals("S") ? new BigDecimal(1) : new BigDecimal(0)));
        } else {
            getCivcomparendo().setComFotomulta(new BigDecimal(0));
        }
        if (!cargueComparendo.getFechaDeNotificacion().isEmpty()) {
            fechaNotificiacion = new java.sql.Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(cargueComparendo.getFechaDeNotificacion()).getTime());
            getCivcomparendo().setComFechanoti(fechaNotificiacion);
        } else {
            getCivcomparendo().setComFechanoti(null);
        }
        //este codigo es para agregar infomacion de alcoholemia
        if (cargueComparendo.getCominfraccion().equals("F")) {
            getCivcomparendo().setComGradoalco(cargueComparendo.getGradoalcohol());
        }

        /*conversion de campos*/
        java.sql.Date fechaComparendo = new java.sql.Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(cargueComparendo.getComfecha()).getTime());
        CivDivipos divipoDireccion = getDivipoDAO().getDivipoByCode(idDivipoMatri);
        CivDivipos divipoMatricula = getDivipoDAO().getDivipoByCode(idDivipoMatri);
        if (divipoMatricula != null) {
            idDivipoMatri = divipoMatricula.getDivId().longValue();
        }
        CivDivipos divipoLicenciaTran = getDivipoDAO().getDivipoByCode(idDivipoMatri); //Revisar
        if (divipoLicenciaTran != null) {
            idDivipoLicTran = divipoLicenciaTran.getDivId().longValue();
        }
        CivDivipos divipoLicenciaCond = getDivipoDAO().getDivipoByCode(idDivipoMatri); //Revisar
        if (divipoLicenciaCond != null) {
            idDivipoLicCond = divipoLicenciaCond.getDivId().longValue();
        }
        //Infraccion infraccionComparendo = model.consultarInfraccionByNumero(cargueComparendo.getCominfraccion());
        long claseVeh = 0;
        if (!cargueComparendo.getComtipovehi().isEmpty()) {
            CivParametros claseVehiculo = getParametrosDAO().getParametroByCodeGrupo(Integer.parseInt(cargueComparendo.getComtipovehi()), 1);
            claseVeh = claseVehiculo.getParCodigo().longValue();
        }

        java.sql.Date fechaVence = null;
        if (!cargueComparendo.getComfechavence().isEmpty()) {
            fechaVence = new java.sql.Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(cargueComparendo.getComfechavence()).getTime());
        }

        //
        //
        //            /*-----------------------------------------------------------------------------------------------------------------------------------*/
        // /*--------------------------------------------------------INGRESO DEL PATIO ---------------------------------------------------------*/
        // /*-----------------------------------------------------------------------------------------------------------------------------------*/
        //            Patios patio_comp = model.ConsultarPatiosByNombre(cargueComparendo.getCOMPATIOINMOVILIZA());
        //            Patios patio_comp_fk = new Patios();
        //            if (patio_comp == null && cargueComparendo.getCOMINMOV().equals("S") && cargueComparendo.getCOMPATIOINMOVILIZA().length() > 0
        //                    && cargueComparendo.getCOMDIRPATIOINMOVI().length() > 0) {
        //                Patios patio = new Patios();
        //                patio.setFk_sede(sede.getId_sede());
        //                patio.setNombre(cargueComparendo.getCOMPATIOINMOVILIZA());
        //                patio.setDireccion(cargueComparendo.getCOMDIRPATIOINMOVI());
        //                patio.setTipo(1); //Revisar
        //                patio.setTelefono("");
        //                model.adicionarpatios(patio);
        //                patio_comp_fk = model.ConsultarPatiosByNombre(cargueComparendo.getCOMPATIOINMOVILIZA());
        //            } else {
        //                if (patio_comp != null) {
        //                    patio_comp_fk = patio_comp;
        //                }
        //            }
        //
        //            /*-----------------------------------------------------------------------------------------------------------------------------------*/
        // /*--------------------------------------------------------INGRESO DE LA GRUA --------------------------------------------------------*/
        // /*-----------------------------------------------------------------------------------------------------------------------------------*/
        //            Grua grua_comp = model.consultarGruaByPlaca(cargueComparendo.getCOMPLACAGRUA());
        //            Grua fk_grua = new Grua();
        //            if (grua_comp == null && cargueComparendo.getCOMINMOV().equals("S") && !cargueComparendo.getCOMPLACAGRUA().equals("") && !cargueComparendo.getCOMGRUANUMERO().equals("")) {
        //                Grua grua = new Grua();
        //                grua.setPlaca_grua(cargueComparendo.getCOMPLACAGRUA());
        //                grua.setNumero(cargueComparendo.getCOMGRUANUMERO());
        //                grua.setFecha_proceso(fecha_Actual);
        //                grua.setFecha_ini(fecha_Actual);
        //                if (patio_comp_fk != null) {
        //                    grua.setFk_patio(patio_comp_fk.getId_patio());
        //                } else if (patio_comp != null) {
        //                    grua.setFk_patio(patio_comp.getId_patio());
        //                }
        //                if (patio_comp_fk != null || patio_comp != null) {
        //                    model.adicionarGrua(grua);
        //                    fk_grua = model.consultarGruaByPlaca(cargueComparendo.getCOMPLACAGRUA());
        //                }
        //            } else {
        //                if (grua_comp != null) {
        //                    fk_grua = grua_comp;
        //                }
        //            }
        //
        //            /*-----------------------------------------------------------------------------------------------------------------------------------*/
        // /*--------------------------------INICIO DE RECOLECCION DE DATOS(aqui ya deben de estar llenos los Objetos)-------------------------*/
        // /*-----------------------------------------------------------------------------------------------------------------------------------*/
        //            // recoleccion de datos principales obligatorios
        //            setFk_sede(sede.getId_sede());
        //            setNumero(cargueComparendo.getCOMNUMERO());
        //            setFecha_comparendo(fechaComparendo);
        //            setHora(cargueComparendo.getCOMHORA());
        //            setDireccion(cargueComparendo.getCOMDIR());
        //            setMunicipio(divipoDireccion.getFk_municipio());
        //            setFk_infraccion(infraccionComparendo.getId_infraccion());
        //            setFk_divipo(divipoDireccion.getId_divipo());
        //            setFk_persona(idPersona);
        //            setTipo_infractor(Integer.parseInt(cargueComparendo.getCOMTIPOINFRAC()));
        //            setFk_agente(idAgente);
        //            setFuga(cargueComparendo.getCOMFUGA().equals("S") ? 1 : 0);
        //            setAccidente(cargueComparendo.getCOMACCI().equals("S") ? 1 : 0);
        //            setInmovilizacion(cargueComparendo.getCOMINMOV().equals("S") ? 1 : 0);
        //            setPolca(cargueComparendo.getCOMPOLCA().equals("S") ? 1 : 0);
        //            setFirmado(0);
        //            setElectronico(cargueComparendo.getFOTOMULTA().equals("S") ? 1 : 0);// solo si es comparendera electronica
        //            setFoto_multa(cargueComparendo.getFOTOMULTA().equals("S") ? 1 : 0);// solo si es foto multa
        //            setTipo_comparendo(cargueComparendo.getFOTOMULTA().equals("S") ? 2 : 1);
        //            setOrganismo(cargueComparendo.getCOMORGANISMO());
        //            setEstado_comparendo(estado_comparendo);
        //            setFk_cartera(Fk_cartera);
        //            setFk_usuario(usuario.getId_usuario());
        //            // recoleccion de datos opcionales
        //            setVia(0);
        //            setTipo_via(0);
        //            setLocalidad(cargueComparendo.getCOMLOCALIDADCOMUNA().isEmpty() ? "" : cargueComparendo.getCOMLOCALIDADCOMUNA());
        //            setPlaca(cargueComparendo.getCOMPLACA().isEmpty() ? "" : cargueComparendo.getCOMPLACA());
        //            setClase(claseVeh);
        //            long tiposervicio = Long.parseLong(cargueComparendo.getCOMTIPOSER());
        //            tiposervicio = tiposervicio == 3 ? 1 : tiposervicio == 5 ? 3 : tiposervicio == 1 ? 4 : tiposervicio == 4 ? 5 : tiposervicio;
        //            setServicio(tiposervicio);
        //            setRadio_accion(cargueComparendo.getCOMCODIGORADIO().isEmpty() ? 0 : Integer.parseInt(cargueComparendo.getCOMCODIGORADIO()));
        //            setModalidad(cargueComparendo.getCOMCODIGOMODALIDAD().isEmpty() ? 0 : Integer.parseInt(cargueComparendo.getCOMCODIGOMODALIDAD()));
        //            setPasajeros(cargueComparendo.getCOMCODIGOPASAJEROS().isEmpty() ? 0 : Integer.parseInt(cargueComparendo.getCOMCODIGOPASAJEROS()));
        //            setFk_divipo_matri(idDivipoMatri);//buscar dato
        //            setLicencia_conduccion(cargueComparendo.getCOMLICENCIA().isEmpty() ? "" : cargueComparendo.getCOMLICENCIA());
        //            setCategoria(cargueComparendo.getCOMCATEGORIA().isEmpty() ? "" : cargueComparendo.getCOMCATEGORIA());
        //            setFk_divipo_licencia(idDivipoLicCond);//buscar dato
        //            setFecha_vence(fechaVence);
        //            setLicencia_transito(cargueComparendo.getCOMPLICTRANSITO().isEmpty() ? "" : cargueComparendo.getCOMPLICTRANSITO());
        //            setFk_divipo_lt(idDivipoLicTran);
        //            setFk_persona_prop(idPersonaPropietario);
        //            setNit_empresa(cargueComparendo.getCOMNITEMPRESA().isEmpty() ? "" : cargueComparendo.getCOMNITEMPRESA());
        //            setNombre_empresa(cargueComparendo.getCOMNOMBREEMPRESA().isEmpty() ? "" : cargueComparendo.getCOMNOMBREEMPRESA());
        //            setTarjeta_operacion(cargueComparendo.getCOMTARJETAOPERACION().isEmpty() ? "" : cargueComparendo.getCOMTARJETAOPERACION());
        //            setFk_persona_testigo(idPersonaTestigo);
        //            setFk_patio(patio_comp_fk.getId_patio());
        //            setFk_grua(fk_grua.getId_grua());
        //            setObservaciones("Ingresado por archivo polca");
        //            setTipo_ingreso(1);
        //            setDireccion_infractor(cargueComparendo.getCOMDIRINFRACTOR());
        //            setFk_divipo_direinfra(idDivipoDireccionInfractor);
        //            id = model.adicionarComparendo(this);
        //        } else {
        //            cargueComparendo.setDescripcion_error("El Comparendo " + cargueComparendo.getCOMNUMERO() + " Ya Se encuentra Registrado en los comparendos locales");
        //        }
        return true;
    }

    @Override
    public List obtenerCampos(String text) throws Exception {
        java.util.List lista = new java.util.LinkedList();
        int start = 0;
        int end = 0;
        while (true) {
            end = text.indexOf(",", start);
            if (end != -1) {
                lista.add(text.substring(start, end));
                start = end + 1;
            } else {
                lista.add(text.substring(start, text.length()));
                break;
            }

        }
        return lista;
    }

    /**
     * @return the estructuraSimitDAO
     */
    public ITEstructuraSimit getEstructuraSimitDAO() {
        return estructuraSimitDAO;
    }

    /**
     * @param estructuraSimitDAO the estructuraSimitDAO to set
     */
    public void setEstructuraSimitDAO(ITEstructuraSimit estructuraSimitDAO) {
        this.estructuraSimitDAO = estructuraSimitDAO;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the campo
     */
    public String getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * @return the dirDate
     */
    public SimpleDateFormat getDirDate() {
        return dirDate;
    }

    /**
     * @param dirDate the dirDate to set
     */
    public void setDirDate(SimpleDateFormat dirDate) {
        this.dirDate = dirDate;
    }

    /**
     * @return the sudDirDate
     */
    public SimpleDateFormat getSudDirDate() {
        return sudDirDate;
    }

    /**
     * @param sudDirDate the sudDirDate to set
     */
    public void setSudDirDate(SimpleDateFormat sudDirDate) {
        this.sudDirDate = sudDirDate;
    }

    /**
     * @return the lineasPlano
     */
    public List getLineasPlano() {
        return lineasPlano;
    }

    /**
     * @param lineasPlano the lineasPlano to set
     */
    public void setLineasPlano(List lineasPlano) {
        this.lineasPlano = lineasPlano;
    }

    /**
     * @return the correcto
     */
    public boolean isCorrecto() {
        return correcto;
    }

    /**
     * @param correcto the correcto to set
     */
    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    /**
     * @return the registroLinea
     */
    public String getRegistroLinea() {
        return registroLinea;
    }

    /**
     * @param registroLinea the registroLinea to set
     */
    public void setRegistroLinea(String registroLinea) {
        this.registroLinea = registroLinea;
    }

    /**
     * @return the civCargueComparendo
     */
    public CivCarguecomparendo getCivCargueComparendo() {
        return civCargueComparendo;
    }

    /**
     * @param civCargueComparendo the civCargueComparendo to set
     */
    public void setCivCargueComparendo(CivCarguecomparendo civCargueComparendo) {
        this.civCargueComparendo = civCargueComparendo;
    }

    /**
     * @return the cargueComparendosDAO
     */
    public ITCargueComparendos getCargueComparendosDAO() {
        return cargueComparendosDAO;
    }

    /**
     * @param cargueComparendosDAO the cargueComparendosDAO to set
     */
    public void setCargueComparendosDAO(ITCargueComparendos cargueComparendosDAO) {
        this.cargueComparendosDAO = cargueComparendosDAO;
    }

    /**
     * @return the comparendosDAO
     */
    public ITComparendos getComparendosDAO() {
        return comparendosDAO;
    }

    /**
     * @param comparendosDAO the comparendosDAO to set
     */
    public void setComparendosDAO(ITComparendos comparendosDAO) {
        this.comparendosDAO = comparendosDAO;
    }

    /**
     * @return the civcomparendo
     */
    public CivComparendos getCivcomparendo() {
        return civcomparendo;
    }

    /**
     * @param civcomparendo the civcomparendo to set
     */
    public void setCivcomparendo(CivComparendos civcomparendo) {
        this.civcomparendo = civcomparendo;
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
     * @return the fecha_Actual
     */
    public java.sql.Date getFecha_Actual() {
        return fecha_Actual;
    }

    /**
     * @param fecha_Actual the fecha_Actual to set
     */
    public void setFecha_Actual(java.sql.Date fecha_Actual) {
        this.fecha_Actual = fecha_Actual;
    }

    /**
     * @return the fechaSystem
     */
    public java.sql.Timestamp getFechaSystem() {
        return fechaSystem;
    }

    /**
     * @param fechaSystem the fechaSystem to set
     */
    public void setFechaSystem(java.sql.Timestamp fechaSystem) {
        this.fechaSystem = fechaSystem;
    }

    /**
     * @return the tiposDocumentosDAO
     */
    public ITTipoDocumento getTiposDocumentosDAO() {
        return tiposDocumentosDAO;
    }

    /**
     * @param tiposDocumentosDAO the tiposDocumentosDAO to set
     */
    public void setTiposDocumentosDAO(ITTipoDocumento tiposDocumentosDAO) {
        this.tiposDocumentosDAO = tiposDocumentosDAO;
    }

    /**
     * @return the agentesDAO
     */
    public ITAgentes getAgentesDAO() {
        return agentesDAO;
    }

    /**
     * @param agentesDAO the agentesDAO to set
     */
    public void setAgentesDAO(ITAgentes agentesDAO) {
        this.agentesDAO = agentesDAO;
    }

    /**
     * @return the vigenciaActual
     */
    public SimpleDateFormat getVigenciaActual() {
        return vigenciaActual;
    }

    /**
     * @param vigenciaActual the vigenciaActual to set
     */
    public void setVigenciaActual(SimpleDateFormat vigenciaActual) {
        this.vigenciaActual = vigenciaActual;
    }

    /**
     * @return the carterasDAO
     */
    public ITCarteras getCarterasDAO() {
        return carterasDAO;
    }

    /**
     * @param carterasDAO the carterasDAO to set
     */
    public void setCarterasDAO(ITCarteras carterasDAO) {
        this.carterasDAO = carterasDAO;
    }

    /**
     * @return the salarioMinimoDAO
     */
    public ITSalarioMinimo getSalarioMinimoDAO() {
        return salarioMinimoDAO;
    }

    /**
     * @param salarioMinimoDAO the salarioMinimoDAO to set
     */
    public void setSalarioMinimoDAO(ITSalarioMinimo salarioMinimoDAO) {
        this.salarioMinimoDAO = salarioMinimoDAO;
    }

    /**
     * @return the detalleCarterasDAO
     */
    public ITDetalleCarteras getDetalleCarterasDAO() {
        return detalleCarterasDAO;
    }

    /**
     * @param detalleCarterasDAO the detalleCarterasDAO to set
     */
    public void setDetalleCarterasDAO(ITDetalleCarteras detalleCarterasDAO) {
        this.detalleCarterasDAO = detalleCarterasDAO;
    }

}
