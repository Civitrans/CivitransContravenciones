/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.crypto.DigestHandler;
import com.contravenciones.exception.UsuariosException;
import com.contravenciones.jdbc.dao.ITParametros;
import com.contravenciones.jdbc.dao.ITPerfilRecursos;
import com.contravenciones.jdbc.dao.ITPerfiles;
import com.contravenciones.jdbc.dao.ITPersonas;
import com.contravenciones.jdbc.dao.ITRecursos;
import com.contravenciones.jdbc.dao.ITUsuarios;
import com.contravenciones.tr.persistence.CivAttempts;
import com.contravenciones.tr.persistence.CivPerfiles;
import com.contravenciones.tr.persistence.CivPersonas;
import com.contravenciones.tr.persistence.CivRecursos;
import com.contravenciones.tr.persistence.CivUspHistoria;
import com.contravenciones.tr.persistence.CivUsuarios;
import com.contravenciones.utility.ValidacionPassword;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.transaction.annotation.Transactional;
import com.contravenciones.jdbc.dao.ITAttempts;
import com.contravenciones.jdbc.dao.ITCajas;
import com.contravenciones.jdbc.dao.ITDetalleRecUsu;
import com.contravenciones.jdbc.dao.ITDetalleRecursos;
import com.contravenciones.jdbc.dao.ITHistorialPerfilRecurso;
import com.contravenciones.jdbc.dao.ITHistorialUsuarioCaja;
import com.contravenciones.jdbc.dao.ITModulos;
import com.contravenciones.jdbc.dao.ITUsuarioCajas;
import com.contravenciones.jdbc.dao.ITUsuarioTipoPago;
import com.contravenciones.jsf.bean.BeanGestionUsuario;
import com.contravenciones.tr.persistence.CivCajas;
import com.contravenciones.tr.persistence.CivDetalleRecUsu;
import com.contravenciones.tr.persistence.CivDetalleRecursos;
import com.contravenciones.tr.persistence.CivHistorialPerfilRecurso;
import com.contravenciones.tr.persistence.CivHistorialUsuarioCaja;
import com.contravenciones.tr.persistence.CivModulos;
import com.contravenciones.tr.persistence.CivParametros;
import com.contravenciones.tr.persistence.CivPerfilrecurso;
import com.contravenciones.tr.persistence.CivPerfilrecursoId;
import com.contravenciones.tr.persistence.CivTipopagos;
import com.contravenciones.tr.persistence.CivUsuarioCajas;
import com.contravenciones.tr.persistence.CivUsuarioCajasId;
import com.contravenciones.tr.persistence.CivUsuariosTipopagos;
import com.contravenciones.utility.Log_Handler;
import com.contravenciones.utility.ValidacionDatos;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roymer Camacho
 */
public class GestionUsuarioImplBO implements GestionUsuarioBO {

    private ITUsuarios usuariosDAO;
    private ITPersonas personasDAO;
    private ITAttempts attemptsDAO;
    private ITPerfiles perfilesDAO;
    private ITRecursos recursosDAO;
    private ITParametros parametrosDAO;
    private ITCajas cajaDAO;
    private ITPerfilRecursos perfilRecursosDAO;
    private ITUsuarioCajas usuarioCajasDAO;
    private ITModulos modulosDAO;
    private ITHistorialPerfilRecurso HistorialPerfilRecursoDAO;
    private ITHistorialUsuarioCaja historialUsuarioCajaDAO;
    private ITDetalleRecursos detalleRecursosDAO;
    private ITDetalleRecUsu detalleRecUsuDAO;
    private ITUsuarioTipoPago usuarioTipoPagosDAO;

    @Override
    public void listRecursosPerfiles(BeanGestionUsuario bean) throws Exception {

        bean.setListaRecursosPerfilUsuario(new ArrayList<>());
        for (CivRecursos perfilR : getRecursosDAO().getRecursosAll()) {
            BeanGestionUsuario datos = new BeanGestionUsuario();
            datos.setNombreRecurso(new ValidacionDatos().letraMayuscula(perfilR.getRecNombre()));
            datos.setCodeRecurso(perfilR.getRecId().intValue());
            datos.setCodeModulo(perfilR.getCivModulos().getModId().intValue());
            datos.setCheckValue(false);
            bean.getListaRecursosPerfilUsuario().add(datos);
        }

    }

    @Override
    public void listDetalleRecursosID(int cod_rec, BeanGestionUsuario bean) throws Exception {
        bean.setListDetalleRecursosbyRec(new ArrayList<>());
        for (CivDetalleRecursos detR : getDetalleRecursosDAO().getDetalleRecursosbyRec(cod_rec)) {
            BeanGestionUsuario datos = new BeanGestionUsuario();
            datos.setNombreDetalleRecurso(detR.getDetRecDescripcion());
            datos.setCheckDetalleRecurso(true);
            datos.setTipoDetalleRecurso(detR.getDetRecTipo());
            datos.setCodeDetalleRecurso(detR.getDetRecId().intValue());
            datos.setCodeRecursoDetalle(detR.getCivRecursos().getRecId().intValue());
            bean.getListDetalleRecursosbyRec().add(datos);

        }

    }

    @Override
    public void listModulos(BeanGestionUsuario bean) throws Exception {
        bean.setListaModulos(new ArrayList<>());
        for (CivModulos mod : getModulosDAO().getAll()) {
            BeanGestionUsuario datosModulos = new BeanGestionUsuario();
            datosModulos.setNombreModulo(mod.getModNombre());
            datosModulos.setCodeModuloCiv(mod.getModId().intValue());
            bean.getListaModulos().add(datosModulos);
        }

    }

    @Override
    public void listDetalleRecursobyUsu(int cod, BeanGestionUsuario bean) throws Exception {
        int valor = 0;
        bean.setDetalleRbyRecurso(new ArrayList<>());
        bean.setDetalleRbyRecurso1(new LinkedHashMap<>());
        List<CivDetalleRecUsu> d = getDetalleRecUsuDAO().getDetalleRecursosbyUsu(cod);
        if (d != null) {
            bean.setEstadoDR(true);
            for (CivDetalleRecUsu dr : d) {
                if (dr.getPropiedadVisible()) {
                    bean.getDetalleRbyRecurso().add(dr); //Llena la lista completa con los detalles recursos asignados al usuario
                    if (valor != dr.getCivRecursos().getRecId().intValue()) { //Llena solo los recursos que contienen detalles recursos por usuario
                        CivRecursos r = getRecursosDAO().getRecursosbyId(dr.getCivRecursos().getRecId().intValue());
                        bean.getDetalleRbyRecurso1().put(dr.getCivRecursos().getRecId().intValue(), r.getRecNombre());
                        valor = dr.getCivRecursos().getRecId().intValue();
                    }
                }

            }
        }

    }

    @Override
    public void listarPerfiles(BeanGestionUsuario bean) throws Exception {
        bean.setListPerfil(new ArrayList<>());
        for (CivPerfiles per : getPerfilesDAO().getAllPerfiles()) {
            BeanGestionUsuario datosPerfiles = new BeanGestionUsuario();
            datosPerfiles.setNombrePerfil(per.getPerfNombre().toUpperCase());
            datosPerfiles.setCodePerfil(per.getPerfId().intValue());
            bean.getListPerfil().add(datosPerfiles);
        }

    }

    @Override
    public void listarMPagoCaja(BeanGestionUsuario bean) throws Exception {
        bean.setListMetodoPago(new ArrayList<>());
        bean.setListCajas(new ArrayList<>());
        /*Llenar lista de métodos de pago*/
        for (CivParametros p : getParametrosDAO().listParametros(301)) {
            BeanGestionUsuario parametros = new BeanGestionUsuario();
            parametros.setNombreTipoPago(p.getParNombre());
            parametros.setCodeTipoPago(p.getParCodigo().intValue());
            parametros.setCheckValueTipoPago(false);
            bean.getListMetodoPago().add(parametros);
        }
        /*Llenar lista de cajas*/
        for (CivCajas civCajas : getCajaDAO().listCajasByEstado(1)) {
            BeanGestionUsuario bc = new BeanGestionUsuario();
            bc.setNombreCaja(civCajas.getCajNombre());
            bc.setCodeCaja(civCajas.getCajId().intValue());
            bc.setCheckValueCaja(false);
            bean.getListCajas().add(bc);
        }

    }

    @Override
    public void listUsuario(BeanGestionUsuario bean) throws Exception {
        bean.setListUsuario(new ArrayList<>());
        for (CivUsuarios object : getUsuariosDAO().listarUsuarios(bean.getNombreUsuario().toUpperCase())) {
            BeanGestionUsuario bnUsuario = new BeanGestionUsuario();
            bnUsuario.setNombreUsuario(object.getUsuNombre());
            //nombreUsuario=object.getUsuNombre();
            bnUsuario.setCodeUsuario(object.getUsuId().intValue());
            bnUsuario.setFechainicio(object.getUsuFechainicial());
            bnUsuario.setCodeEstado(object.getUsuEstado().intValue());
            bnUsuario.setEstado(getParametrosDAO().getParametroByCodeGrupo(13, object.getUsuEstado().intValue()).getParNombre());
            bnUsuario.setFechaFin(object.getUsuFechafinal());
            bnUsuario.setLista(new ArrayList<>());
            bean.getListUsuario().add(bnUsuario);

        }
        if (bean.getListUsuario().isEmpty()) {
            throw new UsuariosException("No se encontraron coincidencias.", 2);
        }
    }

    @Override
    public void detalleUsuario(int codigoUsuario, BeanGestionUsuario bean) throws Exception {
        bean.setPerfilAsignados(new ArrayList<>());
        List<CivPerfilrecurso> recursos = getPerfilRecursosDAO().listPerfilRecursoByIDUsuario(codigoUsuario);

        if (recursos.isEmpty()) {
            CivUsuarios usu = getUsuariosDAO().consultarUsuarioBy(codigoUsuario);
            int id = 0;
            for (CivPerfilrecurso pe : recursos) {
                if (id != pe.getCivRecursos().getCivPerfiles().getPerfId().intValue()) {
                    bean.getPerfilAsignados().add(pe);
                    id = pe.getCivRecursos().getCivPerfiles().getPerfId().intValue();
                }

            }
            bean.setEstado(usu.getUsuEstado().toString());
            RequestContext.getCurrentInstance().execute("$('#perfilesEditar').modal('toggle')");
        } else {
            throw new UsuariosException("El usuario seleccionado ya ha sido perfilado", 2);

        }

    }

    @Override
    public void detalleRecurso(BeanGestionUsuario bean) throws Exception {
        bean.setListDetalleRecursos(new ArrayList<>());
        for (CivDetalleRecursos rec : getDetalleRecursosDAO().getAllDetalleRecursos()) {
            bean.getListDetalleRecursos().add(rec);
        }

    }

    @Override
    public void detalleUsuarioActualizacion(int codigoUsuario, BeanGestionUsuario bean) throws Exception {
        int con = 0, co = 0;
        bean.setPerfilAsignados(new ArrayList<>());
        bean.setListRecursosSeleccionado(new ArrayList<>());
        CivUsuarios usu = getUsuariosDAO().consultarUsuarioBy(codigoUsuario);
        List<CivPerfilrecurso> recursos = getPerfilRecursosDAO().listPerfilRecursoByIDUsuarioFechaFin(codigoUsuario);

        if (usu != null) {
            CivPersonas per = getPersonasDAO().consultarPersonasById(usu.getCivPersonas().getPerId().intValue());
            bean.setNombrePersona(per.getPerNombre1() + " " + (per.getPerNombre2() != null ? per.getPerNombre2() + " " : "") + per.getPerApellido1() + " " + (per.getPerApellido2() != null ? per.getPerApellido2() : ""));

            if (usu.getUsuEstado().intValue() == 3) {
                bean.setDisableEstado(true);
                bean.setTitleEstado("Debe iniciar sesión");
            } else {
                bean.setDisableEstado(false);
                bean.setTitleEstado("Estado del usuario");
            }
        }

        if (!recursos.isEmpty()) {
            int id = 0;
            for (CivPerfilrecurso p : recursos) {
                if (id != p.getCivRecursos().getCivPerfiles().getPerfId().intValue()) {
                    bean.getPerfilAsignados().add(p);
                    id = p.getCivRecursos().getCivPerfiles().getPerfId().intValue();
                }

            }
            bean.setEstadoMensajePerfil(false);
            for (CivPerfilrecurso recurso : recursos) {

                if (recurso.getCivRecursos().getRecId().intValue() == 8) {
                    con++;
                    List<CivUsuarioCajas> cajasUsuario = getUsuarioCajasDAO().listUsuarioCajasByUsuarioFechaFin(codigoUsuario);
                    List<CivUsuariosTipopagos> tipoPago = getUsuarioTipoPagosDAO().listTipoPagosByUsuarioFechaFin(codigoUsuario);
                    if (cajasUsuario != null) {
                        for (CivUsuarioCajas cajaUsu : cajasUsuario) {
                            for (BeanGestionUsuario listCaja : bean.getListCajas()) {
                                if (cajaUsu.getCivCajas().getCajId().intValue() == listCaja.getCodeCaja()) {
                                    listCaja.setCheckValueCaja(true);
                                }
                            }
                        }
                        bean.setEstadoRenderActualizarCheckCaja(true);
                    }
                    if (tipoPago != null) {
                        for (CivUsuariosTipopagos tipoPagoUsuario : tipoPago) {
                            for (BeanGestionUsuario listPago : bean.getListMetodoPago()) {
                                if (tipoPagoUsuario.getCivTipopagos().getTippagId().intValue() == listPago.getCodeTipoPago()) {
                                    listPago.setCheckValueTipoPago(true);
                                }
                            }
                        }
                        bean.setEstadoRenderActualizarCheck(true);
                    }
                }

                if (recurso.getCivRecursos().getRecId().intValue() == 3) {
                    List<CivUsuarioCajas> cajasUsuario = getUsuarioCajasDAO().listUsuarioCajasByUsuarioFechaFin(codigoUsuario);
                    for (CivUsuarioCajas cajaUsu : cajasUsuario) {
                        for (BeanGestionUsuario listCaja : bean.getListCajas()) {
                            if (cajaUsu.getCivCajas().getCajId().intValue() == listCaja.getCodeCaja()) {
                                listCaja.setCheckValueCaja(true);
                            }
                        }
                    }
                    bean.setEstadoRenderActualizarCheckCaja(true);
                }

                for (BeanGestionUsuario listaRecursosPerfilUsuario1 : bean.getListaRecursosPerfilUsuario()) {

                    if (listaRecursosPerfilUsuario1.getCodeRecurso() == recurso.getId().getRecId().intValue()) {
                        listaRecursosPerfilUsuario1.setCheckValue(true);
                        bean.getListRecursosSeleccionado().add(listaRecursosPerfilUsuario1);
                        if (listaRecursosPerfilUsuario1.getCodeRecurso() == 8 || listaRecursosPerfilUsuario1.getCodeRecurso() == 6) {
                            co++;

                        }
                    }
                }

            }
            if (co == 2) {
                bean.setSw(1);
            }
            bean.getListaRecursosPerfilUsuario();
            RequestContext.getCurrentInstance().execute("$('#perfilesActualizarUsuario').modal('toggle')");

        } else {
            throw new UsuariosException("El usuario seleccionado no ha sido perfilado", 2);

        }

    }

    @Override
    public void listRecursosbyModulo(int modulo, BeanGestionUsuario bean) throws Exception {
        bean.setListRecursosbyModulo(new ArrayList<>());
        List<CivRecursos> rec = getRecursosDAO().getRecursosByModulo(modulo);
        if (rec != null) {
            for (CivRecursos rec1 : rec) {
                bean.getListRecursosbyModulo().add(rec1.getRecId().intValue());
            }
        }

    }

    @Override
    public void generarContrasenaAleatoria(BeanGestionUsuario bean) throws Exception {
        int numero;
        numero = (int) (Math.random() * 900) + 100;
        String contrasenia = "Civitrans" + numero;
        bean.setPasswordAleatorio(contrasenia);
    }

    @Override
    public void consultarPersona(BeanGestionUsuario bean) throws Exception {
        if (bean.getTipoDocumento() == 0) {
            return;
        }

        CivPersonas persona = getPersonasDAO().consultarPersonasByDocumento(bean.getTipoDocumento(), bean.getDocumento());
        if (persona == null) {
            bean.setNombreUsuarioPerfilar("");
            bean.setNombrePersona("");
            bean.modalPersona();
            throw new UsuariosException("La persona no existe", 2);

        } else {
            bean.setNombrePersona(persona.getPerNombre1() + " " + (persona.getPerNombre2() != null ? persona.getPerNombre2() + " " : "") + persona.getPerApellido1() + " " + (persona.getPerApellido2() != null ? persona.getPerApellido2() : ""));
            bean.setNombreUsuarioPerfilar(generarNombreUsuario(persona.getPerNombre1(), persona.getPerApellido1()));

        }
    }

    public String generarNombreUsuario(String nombre, String apellido) throws Exception {
        String username = "";
        String ap = "";
        Random rnd = new Random();
        int x = rnd.nextInt(99);
        String apellido1 = apellido.toUpperCase();
        for (int i = 0; i < apellido1.length(); i++) {
            if (apellido1.charAt(i) != ' ') {
                ap += apellido1.charAt(i);
            }
        }
        String nombre1 = nombre.toUpperCase();
        username = nombre1.charAt(0) + ap + x;
        //nombreUsuario=username;
        return username;
    }

    @Override

    public void registrarUsuario(BeanGestionUsuario bean) throws Exception {
        CivPersonas persona = getPersonasDAO().consultarPersonasByDocumento(bean.getTipoDocumento(), bean.getDocumento());
        CivUsuarios user = getUsuariosDAO().consultarUsuarioByNombre(bean.getNombreUsuarioPerfilar().toUpperCase());
        if (persona == null) {
            throw new UsuariosException("Digite el documento de la persona", 2);
        }
        if (user != null) {
            throw new UsuariosException("Ya existe este nombre de usuario. Por favor genere otro diferente a este", 2);
        }
        CivUsuarios usuarios = new CivUsuarios();
        int idpersona = Integer.parseInt(persona.getPerId().toString());
        CivUsuarios sw = getUsuariosDAO().consultarIdPer(idpersona);

        if (sw != null) {
            throw new UsuariosException("Ya existe un usuario registrado a esta persona", 2);
        }
        //bean.setNombreUsuarioPerfilar(nombreUsuario);
        usuarios.setUsuEstado(BigDecimal.valueOf(3));
        usuarios.setUsuFechainicial(new Date());
        usuarios.setUsuNombre(bean.getNombreUsuarioPerfilar().toUpperCase()); //Generar nombre Usuario
        usuarios.setUsuPassword(DigestHandler.encryptSHA2(bean.getDocumento()));
        usuarios.setUsuFechaproceso(new Date());
        usuarios.setCivPersonas(persona);
        long idUSuario = getUsuariosDAO().insert(usuarios);
        usuarios.setUsuId(BigDecimal.valueOf(idUSuario));
        getUsuariosDAO().insertHisPass(new CivUspHistoria(null, usuarios, DigestHandler.encryptSHA2(bean.getDocumento()), new Date(), BigDecimal.ONE));
    }

    @Override

    public void registrarPerfil(BeanGestionUsuario bean) throws Exception {

        CivUsuarios usuario = getUsuariosDAO().consultarUsuarioByNombre(bean.getNombreUsuarioPerfilar());
        CivPerfiles perfil = getPerfilesDAO().consultarPerfilByName(bean.getNombrePerfilUsuario());

        for (BeanGestionUsuario ob : bean.getListaRecursosPerfilUsuario()) {

            if (ob.isCheckValue()) {
                CivPerfilrecurso recurso = new CivPerfilrecurso();

                CivRecursos idrecurso = new CivRecursos();
                idrecurso.setRecId(BigDecimal.valueOf(ob.getCodeRecurso()));
                CivPerfilrecursoId recursoId = new CivPerfilrecursoId(idrecurso.getRecId(), usuario.getUsuId());

                recurso.setPerrecFechaini(new Date());
                recurso.setId(recursoId);
                recurso.setCivRecursos(idrecurso);
                getPerfilRecursosDAO().insert(recurso);
            }

        }
        /*Inserta tipos de pago*/
        if (bean.getListMetodoPago() != null) {

            for (BeanGestionUsuario obj : bean.getListMetodoPago()) {

                if (obj.isCheckValueTipoPago()) {
                    CivUsuariosTipopagos tipoPago = new CivUsuariosTipopagos();
                    CivTipopagos tp = new CivTipopagos();
                    tp.setTippagId(BigDecimal.valueOf(obj.getCodeTipoPago()));

                    tipoPago.setCivUsuarios(usuario);
                    tipoPago.setUstipEstado(BigDecimal.ONE);
                    tipoPago.setFechainicial(new Date());
                    tipoPago.setCivTipopagos(tp);
                    getUsuarioTipoPagosDAO().insert(tipoPago);
                }

            }
        }
        /*Inserta Caja*/
        if (bean.getListCajas() != null) {

            for (BeanGestionUsuario obj : bean.getListCajas()) {

                if (obj.isCheckValueCaja()) {
                    CivUsuarioCajas caja = new CivUsuarioCajas();

                    CivCajas idcaja = new CivCajas();
                    idcaja.setCajId(BigDecimal.valueOf(obj.getCodeCaja()));
                    CivUsuarioCajasId usuariocajaID = new CivUsuarioCajasId(usuario.getUsuId().longValue(), idcaja.getCajId());

                    caja.setId(usuariocajaID);
                    caja.setUsucajFechaInicio(new Date());
                    getUsuarioCajasDAO().insert(caja);
                }

            }

        }

        /*Inserta los detalles recursos*/
        if (bean.getListDetalleRecursosSeleccionado() != null) {
            for (BeanGestionUsuario obj : bean.getListDetalleRecursosSeleccionado()) {
                if (obj.isCheckDetalleRecurso()) {
                    CivDetalleRecUsu recusu = new CivDetalleRecUsu();
                    CivDetalleRecursos dtRec = new CivDetalleRecursos();

                    CivRecursos rec = new CivRecursos();
                    rec.setRecId(BigDecimal.valueOf(obj.getCodeRecursoDetalle()));

                    dtRec.setDetRecId(BigDecimal.valueOf(obj.getCodeDetalleRecurso()));

                    recusu.setCivRecursos(rec);
                    recusu.setCivUsuarios(usuario);
                    recusu.setCivDetalleRecursos(dtRec);
                    recusu.setPropiedadVisible(true);
                    recusu.setFechaInicial(new Date());
                    getDetalleRecUsuDAO().insert(recusu);
                }

            }
        }

    }

    @Override

    public void actualizaUsuario(BeanGestionUsuario bean) throws Exception {

        CivUsuarios usuario = getUsuariosDAO().consultarUsuarioByNombre(bean.getNombreUsuarioPerfilar());

        CivUsuarios civUsuarios = new CivUsuarios();

        civUsuarios.setUsuId(usuario.getUsuId());
        civUsuarios.setUsuNombre(usuario.getUsuNombre());
        if (usuario.getUsuEstado().intValue() == 3) {
            civUsuarios.setUsuEstado(BigDecimal.valueOf(3));
        } else {
            civUsuarios.setUsuEstado(BigDecimal.valueOf(bean.getCodeEstado()));
            if (bean.getCodeEstado() == 2) {
                civUsuarios.setUsuFechafinal(new Date());
            }
        }

        if (bean.getPasswordAleatorio() != null && bean.getPasswordAleatorio().length() > 0) {//Aquí se almacena la contraseña en caso de que se haya generado
            civUsuarios.setUsuPassword(DigestHandler.encryptSHA2(bean.getPasswordAleatorio()));
            civUsuarios.setUsuEstado(new BigDecimal(3));// estado 3 contraseña establecida
            CivAttempts att = getAttemptsDAO().consultarIntentos(civUsuarios.getUsuId().intValue());
            if (att != null) {
                att.setTtpIntentos(0L);
                getAttemptsDAO().update(att);
            }

            Log_Handler.registrarEvento("El usuario ID: " + civUsuarios.getUsuId().intValue() + " se le ha restablecido la contraseña correctamente.", null, Log_Handler.INFO, getClass(), Integer.parseInt(bean.getLoginBean().getID_Usuario()));
        } else {
            civUsuarios.setUsuPassword(usuario.getUsuPassword());
        }

        civUsuarios.setUsuFechainicial(usuario.getUsuFechainicial());
        civUsuarios.setUsuFechaproceso(usuario.getUsuFechaproceso());
        civUsuarios.setCivPersonas(usuario.getCivPersonas());

        getUsuariosDAO().update(civUsuarios);

        /*actualiza todos los tipos de pago y caja con fecha fin*/
        if (!bean.isEstadoRenderActualizarCheck() || !bean.isEstadoRenderActualizarCheckCaja()) {
            List<CivUsuariosTipopagos> usuTPago = getUsuarioTipoPagosDAO().listTipoPagosByUsuario(usuario.getUsuId().intValue());
            List<CivUsuarioCajas> usCaja = getUsuarioCajasDAO().listUsuarioCajasByUsuario(usuario.getUsuId().intValue());

            if (usuTPago != null) {
                if (!usuTPago.isEmpty()) {
                    for (CivUsuariosTipopagos utp : usuTPago) {
                        CivUsuariosTipopagos utpa = new CivUsuariosTipopagos();
                        utpa.setCivUsuarios(utp.getCivUsuarios());
                        utpa.setCivTipopagos(utp.getCivTipopagos());
                        utpa.setUstipEstado(utp.getUstipEstado());
                        utpa.setFechainicial(utp.getFechainicial());
                        utpa.setFechafin(new Date());
                        getUsuarioTipoPagosDAO().update(utpa);
                    }
                }
            }

            if (usCaja != null) {
                if (!usCaja.isEmpty()) {
                    for (CivUsuarioCajas usca : usCaja) {
                        CivUsuarioCajas usucaja = new CivUsuarioCajas();
                        usucaja.setId(usca.getId());
                        usucaja.setUsucajFechaInicio(usca.getUsucajFechaInicio());
                        usucaja.setUsucajFechaFin(new Date());
                        getUsuarioCajasDAO().update(usucaja);
                    }
                }
            }

        }

        List<CivPerfilrecurso> perfilesUsuarios = getPerfilRecursosDAO().listPerfilRecursoByIDUsuario(usuario.getUsuId().longValue());
        CivPerfiles perfil = getPerfilesDAO().consultarPerfilById(bean.getCodePerfilSeleccionado());


        /*Inserta los nuevos valores de los recursos del usuario*/
        for (BeanGestionUsuario ob : bean.getListaRecursosPerfilUsuario()) {
            int insert = 0;
            if (ob.isCheckValue()) {

                if (ob.getCodeRecurso() == 3) {
                    bean.setEstadoRenderActualizarCheckCaja(true);
                }

                if (ob.getCodeRecurso() == 8) {
                    bean.setEstadoRenderActualizarCheckCaja(true);
                    bean.setEstadoRenderActualizarCheck(true);
                }

                for (CivPerfilrecurso actPer : perfilesUsuarios) {
                    if (ob.getCodeRecurso() == actPer.getId().getRecId().intValue()) {
                        if (actPer.getPerrecFechafin() != null) {
                            /*actualiza en la tabla perfil recurso la fecha de inicio*/
                            CivPerfilrecurso recurso = new CivPerfilrecurso();

                            recurso.setPerrecFechaini(new Date());
                            recurso.setId(actPer.getId());
                            getPerfilRecursosDAO().update(recurso);

                        }
                        insert++;
                    }
                }
                if (insert == 0) {
                    CivPerfilrecurso recurso = new CivPerfilrecurso();

                    CivRecursos idrecurso = new CivRecursos();
                    idrecurso.setRecId(BigDecimal.valueOf(ob.getCodeRecurso()));
                    CivPerfilrecursoId recursoId = new CivPerfilrecursoId(idrecurso.getRecId(), usuario.getUsuId());

                    recurso.setPerrecFechaini(new Date());
                    recurso.setId(recursoId);
                    recurso.setCivRecursos(idrecurso);
                    getPerfilRecursosDAO().insert(recurso);
                }

            } else {
                /*Se hace el proceso de desasignación de recurso*/
                for (CivPerfilrecurso actPer : perfilesUsuarios) {
                    if (ob.getCodeRecurso() == actPer.getId().getRecId().intValue()) {

                        /*inserta el registro anterior a la tabla historial perfil recurso*/
                        if (actPer.getPerrecFechafin() == null) {
                            CivHistorialPerfilRecurso recursos = new CivHistorialPerfilRecurso();
                            recursos.setRecId(actPer.getId().getRecId());
                            recursos.setUsuId(actPer.getId().getUsuId());
                            recursos.setHisFechaIni(actPer.getPerrecFechaini());
                            recursos.setHisFechaFin(new Date());
                            getHistorialPerfilRecursoDAO().insert(recursos);
                        }

                        /*actualizar fecha fin en perfil recurso*/
                        CivPerfilrecurso recurso = new CivPerfilrecurso();

                        recurso.setPerrecFechaini(actPer.getPerrecFechaini());
                        recurso.setPerrecFechafin(new Date());
                        recurso.setId(actPer.getId());
                        getPerfilRecursosDAO().update(recurso);
                    }
                }

            }

        }

        if (bean.isEstadoRenderActualizarCheck() || bean.isEstadoRenderActualizarCheckCaja()) {
            /*Actualiza Cajas*/
            List<CivUsuarioCajas> usuCaja = getUsuarioCajasDAO().listUsuarioCajasByUsuario(usuario.getUsuId().intValue());
            if (usuCaja != null) {
                if (bean.getListCajas() != null || !bean.getListCajas().isEmpty()) {
                    for (BeanGestionUsuario listCaja : bean.getListCajas()) {
                        if (listCaja.isCheckValueCaja()) {
                            int inserta = 0;
                            for (CivUsuarioCajas caj : usuCaja) {

                                if (listCaja.getCodeCaja() == caj.getId().getCajId().intValue()) {
                                    if (caj.getUsucajFechaFin() != null) {
                                        /*actualiza en la tabla usuario caja la fecha de inicio*/
                                        CivUsuarioCajas cajausu = new CivUsuarioCajas();

                                        cajausu.setId(caj.getId());
                                        cajausu.setUsucajFechaInicio(new Date());
                                        getUsuarioCajasDAO().update(cajausu);

                                    }
                                    inserta++;
                                }
                            }

                            if (inserta == 0) {
                                CivUsuarioCajas cajausu = new CivUsuarioCajas();
                                CivUsuarioCajasId cajaID = new CivUsuarioCajasId(usuario.getUsuId().longValue(), BigDecimal.valueOf(listCaja.getCodeCaja()));
                                cajausu.setId(cajaID);
                                cajausu.setUsucajFechaInicio(new Date());
                                getUsuarioCajasDAO().insert(cajausu);

                            }
                        } else {
                            /*Se hace el proceso de desasignación de caja*/
                            for (CivUsuarioCajas caj : usuCaja) {
                                if (listCaja.getCodeCaja() == caj.getId().getCajId().intValue()) {

                                    /*inserta el registro anterior a la tabla historial usuario caja*/
                                    if (caj.getUsucajFechaFin() == null) {
                                        CivHistorialUsuarioCaja hc = new CivHistorialUsuarioCaja();
                                        hc.setUsuId(BigDecimal.valueOf(caj.getId().getUsuId()));
                                        hc.setCajId(caj.getId().getCajId());
                                        hc.setHisFechaInicio(caj.getUsucajFechaInicio());
                                        hc.setHisFechaFin(new Date());
                                        getHistorialUsuarioCajaDAO().insert(hc);

                                    }

                                    /*actualizar fecha fin en perfil recurso*/
                                    CivUsuarioCajas usc = new CivUsuarioCajas();

                                    usc.setUsucajFechaFin(new Date());
                                    usc.setUsucajFechaInicio(caj.getUsucajFechaInicio());
                                    usc.setId(caj.getId());
                                    getUsuarioCajasDAO().update(usc);

                                }
                            }

                        }
                    }
                }
            }

        }
        if (bean.isEstadoRenderActualizarCheck()) {
            /*Actualiza los tipos de pagos*/
            List<CivUsuariosTipopagos> usuPago = getUsuarioTipoPagosDAO().listTipoPagosByUsuario(usuario.getUsuId().intValue());
            if (usuPago != null) {
                if (bean.getListMetodoPago() != null || !bean.getListMetodoPago().isEmpty()) {
                    for (BeanGestionUsuario listMetodoPago : bean.getListMetodoPago()) {

                        if (listMetodoPago.isCheckValueTipoPago()) {
                            int cont = 0;
                            for (CivUsuariosTipopagos pag : usuPago) {
                                if (pag.getCivTipopagos().getTippagId().intValue() == listMetodoPago.getCodeTipoPago() && pag.getFechafin() == null) {
                                    cont++;
                                }
                            }

                            if (cont == 0) {
                                CivUsuariosTipopagos tp = new CivUsuariosTipopagos();
                                CivTipopagos tipPago = new CivTipopagos();
                                tipPago.setTippagId(BigDecimal.valueOf(listMetodoPago.getCodeTipoPago()));

                                tp.setCivUsuarios(usuario);
                                tp.setCivTipopagos(tipPago);
                                tp.setUstipEstado(BigDecimal.ONE);
                                tp.setFechainicial(new Date());
                                getUsuarioTipoPagosDAO().insert(tp);
                            }
                        } else {
                            for (CivUsuariosTipopagos pag : usuPago) {
                                if (pag.getCivTipopagos().getTippagId().intValue() == listMetodoPago.getCodeTipoPago()) {
                                    CivUsuariosTipopagos tp = new CivUsuariosTipopagos();
                                    CivTipopagos tipPago = new CivTipopagos();
                                    tipPago.setTippagId(BigDecimal.valueOf(listMetodoPago.getCodeTipoPago()));

                                    tp.setCivUsuarios(usuario);
                                    tp.setCivTipopagos(tipPago);
                                    tp.setUstipEstado(BigDecimal.valueOf(2));
                                    tp.setFechainicial(pag.getFechainicial());
                                    tp.setFechafin(new Date());
                                    getUsuarioTipoPagosDAO().update(tp);
                                }
                            }
                        }
                    }

                }
            }
        }

        /*Inserta los detalles recursos*/
        if (bean.getListDetalleRecursosSeleccionado() != null) {
            for (BeanGestionUsuario obj : bean.getListDetalleRecursosSeleccionado()) {
                if (obj.isCheckDetalleRecurso()) {
                    CivDetalleRecUsu recusu = new CivDetalleRecUsu();

                    CivRecursos rec = new CivRecursos();
                    rec.setRecId(BigDecimal.valueOf(obj.getCodeRecursoDetalle()));
                    CivDetalleRecursos dtRec = new CivDetalleRecursos();
                    dtRec.setDetRecId(BigDecimal.valueOf(obj.getCodeDetalleRecurso()));

                    recusu.setCivRecursos(rec);
                    recusu.setCivUsuarios(usuario);
                    recusu.setCivDetalleRecursos(dtRec);
                    recusu.setPropiedadVisible(true);
                    recusu.setFechaInicial(new Date());
                    getDetalleRecUsuDAO().insert(recusu);
                }

            }
        }

        /*Actualiza los detalles recursos*/
        if (!bean.getListDetalleRecursos().isEmpty()) {
            for (CivDetalleRecursos bg : bean.getListDetalleRecursos()) {
                if (bg.getDetRecObjeto() != null) {
                    if (bg.getDetRecObjeto().equals("1")) {
                        int cont = 0;
                        for (CivDetalleRecUsu dt : bean.getDetalleRbyRecurso()) {
                            if (dt.getCivDetalleRecursos().getDetRecId().intValue() == bg.getDetRecId().intValue() && dt.getPropiedadVisible()) {
                                cont++;
                            }
                        }
                        if (cont == 0) {
                            CivDetalleRecUsu d = new CivDetalleRecUsu();
                            CivDetalleRecursos dtRec = new CivDetalleRecursos();
                            dtRec.setDetRecId(BigDecimal.valueOf(bg.getDetRecId().intValue()));

                            d.setCivRecursos(bg.getCivRecursos());
                            d.setCivUsuarios(civUsuarios);
                            d.setPropiedadVisible(true);
                            d.setFechaInicial(new Date());
                            d.setCivDetalleRecursos(dtRec);
                            getDetalleRecUsuDAO().insert(d);
                        }
                    } else {
                        if (bg.getDetRecObjeto().equals("2")) {
                            for (CivDetalleRecUsu dt : bean.getDetalleRbyRecurso()) {
                                if (dt.getCivDetalleRecursos().getDetRecId().intValue() == bg.getDetRecId().intValue()) {
                                    CivDetalleRecUsu d = new CivDetalleRecUsu();
                                    CivDetalleRecursos dtRec = new CivDetalleRecursos();
                                    dtRec.setDetRecId(BigDecimal.valueOf(bg.getDetRecId().intValue()));

                                    d.setCivRecursos(bg.getCivRecursos());
                                    d.setCivUsuarios(civUsuarios);
                                    d.setPropiedadVisible(false);
                                    d.setFechaInicial(dt.getFechaInicial());
                                    d.setFechaFin(new Date());
                                    d.setCivDetalleRecursos(dtRec);
                                    getDetalleRecUsuDAO().update(d);
                                }
                            }
                        }

                    }
                }

            }
        }

        Log_Handler.registrarEvento("El usuario ID: " + civUsuarios.getUsuId().intValue() + " se ha actualizado correctamente.", null, Log_Handler.INFO, getClass(), Integer.parseInt(bean.getLoginBean().getID_Usuario()));
    }

    public ITUsuarios getUsuariosDAO() {
        return usuariosDAO;
    }

    /**
     * @param usuariosDAO the usuariosDAO to set
     */
    public void setUsuariosDAO(ITUsuarios usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
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
     * @return the attemptsDAO
     */
    public ITAttempts getAttemptsDAO() {
        return attemptsDAO;
    }

    /**
     * @param attemptsDAO the attemptsDAO to set
     */
    public void setAttemptsDAO(ITAttempts attemptsDAO) {
        this.attemptsDAO = attemptsDAO;
    }

    /**
     * @return the perfilesDAO
     */
    public ITPerfiles getPerfilesDAO() {
        return perfilesDAO;
    }

    /**
     * @param perfilesDAO the perfilesDAO to set
     */
    public void setPerfilesDAO(ITPerfiles perfilesDAO) {
        this.perfilesDAO = perfilesDAO;
    }

    /**
     * @return the recursosDAO
     */
    public ITRecursos getRecursosDAO() {
        return recursosDAO;
    }

    /**
     * @param recursosDAO the recursosDAO to set
     */
    public void setRecursosDAO(ITRecursos recursosDAO) {
        this.recursosDAO = recursosDAO;
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
     * @return the cajaDAO
     */
    public ITCajas getCajaDAO() {
        return cajaDAO;
    }

    /**
     * @param cajaDAO the cajaDAO to set
     */
    public void setCajaDAO(ITCajas cajaDAO) {
        this.cajaDAO = cajaDAO;
    }

    /**
     * @return the perfilRecursosDAO
     */
    public ITPerfilRecursos getPerfilRecursosDAO() {
        return perfilRecursosDAO;
    }

    /**
     * @param perfilRecursosDAO the perfilRecursosDAO to set
     */
    public void setPerfilRecursosDAO(ITPerfilRecursos perfilRecursosDAO) {
        this.perfilRecursosDAO = perfilRecursosDAO;
    }

    /**
     * @return the usuarioCajasDAO
     */
    public ITUsuarioCajas getUsuarioCajasDAO() {
        return usuarioCajasDAO;
    }

    /**
     * @param usuarioCajasDAO the usuarioCajasDAO to set
     */
    public void setUsuarioCajasDAO(ITUsuarioCajas usuarioCajasDAO) {
        this.usuarioCajasDAO = usuarioCajasDAO;
    }

    /**
     * @return the modulosDAO
     */
    public ITModulos getModulosDAO() {
        return modulosDAO;
    }

    /**
     * @param modulosDAO the modulosDAO to set
     */
    public void setModulosDAO(ITModulos modulosDAO) {
        this.modulosDAO = modulosDAO;
    }

    /**
     * @return the HistorialPerfilRecursoDAO
     */
    public ITHistorialPerfilRecurso getHistorialPerfilRecursoDAO() {
        return HistorialPerfilRecursoDAO;
    }

    /**
     * @param HistorialPerfilRecursoDAO the HistorialPerfilRecursoDAO to set
     */
    public void setHistorialPerfilRecursoDAO(ITHistorialPerfilRecurso HistorialPerfilRecursoDAO) {
        this.HistorialPerfilRecursoDAO = HistorialPerfilRecursoDAO;
    }

    /**
     * @return the historialUsuarioCajaDAO
     */
    public ITHistorialUsuarioCaja getHistorialUsuarioCajaDAO() {
        return historialUsuarioCajaDAO;
    }

    /**
     * @param historialUsuarioCajaDAO the historialUsuarioCajaDAO to set
     */
    public void setHistorialUsuarioCajaDAO(ITHistorialUsuarioCaja historialUsuarioCajaDAO) {
        this.historialUsuarioCajaDAO = historialUsuarioCajaDAO;
    }

    /**
     * @return the detalleRecursosDAO
     */
    public ITDetalleRecursos getDetalleRecursosDAO() {
        return detalleRecursosDAO;
    }

    /**
     * @param detalleRecursosDAO the detalleRecursosDAO to set
     */
    public void setDetalleRecursosDAO(ITDetalleRecursos detalleRecursosDAO) {
        this.detalleRecursosDAO = detalleRecursosDAO;
    }

    /**
     * @return the detalleRecUsuDAO
     */
    public ITDetalleRecUsu getDetalleRecUsuDAO() {
        return detalleRecUsuDAO;
    }

    /**
     * @param detalleRecUsuDAO the detalleRecUsuDAO to set
     */
    public void setDetalleRecUsuDAO(ITDetalleRecUsu detalleRecUsuDAO) {
        this.detalleRecUsuDAO = detalleRecUsuDAO;
    }

    /**
     * @return the usuarioTipoPagosDAO
     */
    public ITUsuarioTipoPago getUsuarioTipoPagosDAO() {
        return usuarioTipoPagosDAO;
    }

    /**
     * @param usuarioTipoPagosDAO the usuarioTipoPagosDAO to set
     */
    public void setUsuarioTipoPagosDAO(ITUsuarioTipoPago usuarioTipoPagosDAO) {
        this.usuarioTipoPagosDAO = usuarioTipoPagosDAO;
    }

}
