/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jdbc.dao.ITCargueComparendos;
import com.contravenciones.jdbc.dao.ITEstructuraSimit;
import com.contravenciones.jsf.bean.BeanPlanos;
import com.contravenciones.tr.persistence.CivCarguecomparendo;
import com.contravenciones.tr.persistence.CivEstructuraSimit;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Soporte 2
 */
public class PlanosImplBO implements PlanosBO {

    private final SimpleDateFormat dirDate = new SimpleDateFormat("ddMMYYYY");
    private final SimpleDateFormat sudDirDate = new SimpleDateFormat("dd-MM-YYYY hh mm ss");
    private ITEstructuraSimit estructuraSimitDAO;
    private ITCargueComparendos cargueComparendosDAO;
    private String msg = "";
    private String valor = "";
    private String campo = "";
    private boolean error;
    private CivCarguecomparendo CvCarguecomparendo;

    @Override
    public void getListEstructura(BeanPlanos bean) throws Exception {
        bean.setListLinea(new ArrayList<>());
        bean.setCargados(0);
        bean.setNoCargados(0);
        if (bean.getFile() == null) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
        }

        if (bean.getFile().getName().isEmpty()) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
        }

        if (!bean.getFile().getContentType().equals("text/plain")) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
        }

        java.io.DataInputStream dis = new DataInputStream(bean.getFile().getInputStream());

        String archivo = "comparendo" + " " + dirDate.format(new Date()) + ".txt";
        String fileName = "C:/Documentos/" + bean.getLoginBean().getUser() + "/" + sudDirDate.format(new Date()) + "/";
        File saveTo = new File(fileName);

        if (!saveTo.exists()) {
            saveTo.mkdirs();
        }

        /*Copia del archivo cargado*/
        InputStream input = bean.getFile().getInputStream();
        Files.copy(input, new File(fileName, archivo).toPath());
        /*end Copy*/

        String linea;
        BufferedReader reader = new BufferedReader(new InputStreamReader(dis));
        int line = 0;
        while ((linea = reader.readLine()) != null) {
            bean.setHashLine(new HashMap<>());
            StringTokenizer st = new StringTokenizer(linea, ",");
            String valid;

            List<String> param = new ArrayList<>();

            while (st.hasMoreTokens()) {
                param.add(st.nextToken());
            }

            if (param.isEmpty()) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            line++;

            List<PlanosImplBO> plano = validarLiena(param, 1);

            if (plano == null) {
                bean.setNoCargados((bean.getNoCargados() + 1));
                bean.getHashLine().put("linea", line + "");
                bean.getHashLine().put("msg", getCvCarguecomparendo().getDescripcionError());
                bean.getHashLine().put("value", "");
                bean.getListLinea().add(bean.getHashLine());
            } else {
                for (PlanosImplBO planosImplBO : plano) {
                    if (!planosImplBO.isError()) {
                        bean.setNoCargados((bean.getNoCargados() + 1));
                        bean.getHashLine().put("linea", line + "");
                        bean.getHashLine().put("msg", getCvCarguecomparendo().getDescripcionError());
                        bean.getHashLine().put("value", "");
                        bean.getListLinea().add(bean.getHashLine());
                        continue;
                    }
                    bean.setCargados((bean.getCargados() + 1));
                }//next
            }//If 
        }//while
    }//main

    @Override
    public List<PlanosImplBO> validarLiena(List listaCampos, int tipo) throws Exception {
        int numeroCampo = 0;
        String nombreCampo = "";
        String registro = " Registro " + (listaCampos.get(0).toString() != null ? listaCampos.get(0).toString() : "") + "-" + (listaCampos.get(1).toString() != null ? listaCampos.get(1).toString() : " Sin Comparendo");
        int cantidadCampos = listaCampos.size();
        try {
            List<PlanosImplBO> listaValidados = new ArrayList();
            setCvCarguecomparendo(new CivCarguecomparendo());
            if (listaCampos.size() < 57) {
                getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. valor Minimo(57) valor Obtenido (" + listaCampos.size() + ")");
                setError(false);
                return null;
            }

            if (listaCampos.size() > 60) {
                getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. valor Maximo(60) valor Obtenido (" + listaCampos.size() + ")");
                setError(false);
                return null;
            }

            if (listaCampos.get(55).equals("F")) {
                cantidadCampos = 57;
                if (listaCampos.size() < 58) {
                    getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. Campo grado de alcohol no reportado.");
                    setError(false);
                    return null;
                }
            }

            if (!listaCampos.get(55).equals("F") && listaCampos.size() > 57) {
                if (listaCampos.size() == 59) {
                    cantidadCampos = 59;
                    if (!listaCampos.get(57).equals("S") && !listaCampos.get(57).equals("N")) {
                        getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. Campo Foto Multa no reportado correctamente.");
                        setError(false);
                        return null;
                    }
                } else {
                    if (listaCampos.size() == 60) {
                        cantidadCampos = 60;
                        if (!listaCampos.get(58).equals("S") && !listaCampos.get(58).equals("N")) {
                            getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. Campo Foto Multa no reportado correctamente.");
                            setError(false);
                            return null;
                        }
                    }
                }
            }

//            if (listaCampos.size() < estructuraEstandar.size()) {
//                getCvCarguecomparendo().setDescripcionError(registro + " linea no cumple con los campos minimos. valor Minimo("+estructuraEstandar.size()+") valor Obtenido ("+listaCampos.size()+")");
//                setError(false);
//                return null;
//            }
            //for (int i = 0; i < estructuraEstandar.size(); i++) {
            for (int i = 0; i < cantidadCampos; i++) {
                numeroCampo = i + 1;
                PlanosImplBO datosCarguePlano = new PlanosImplBO();
                setError(true);
                CivEstructuraSimit estructura = getEstructuraSimitDAO().getEstructuraSimit((i + 1), tipo);
                nombreCampo = estructura.getEstrNombreCampo();
                datosCarguePlano.setCampo(estructura.getEstrNombreCampo());
                valor = listaCampos.get(i).toString();

                if (valor.trim().equals("") || valor.isEmpty()) {
                    if (estructura.getEstrObligatorio().equals("S")) {
                        getCvCarguecomparendo().setDescripcionError(registro + " - error en (" + estructura.getEstrNombreCampo() + ") el campo es obligatorio - en el campo: (" + (i + 1) + ")");
                        setError(false);
                        break;
                    } else {
                        if (nombreCampo.equals("COMNOMBREPROP")) {
                            if ((!listaCampos.get(30).equals("")) && (!listaCampos.get(31).equals(""))) {
                                getCvCarguecomparendo().setDescripcionError(registro + " - error en(" + estructura.getEstrNombreCampo() + ")  COMNOMBREPROP no puede ser vacio si existe documento de identidad" + "- en el campo: (" + (i + 1) + ")");
                                setError(false);
                                break;
                            }
                        }
                        valor = "";
                    }

                } else {
                    if (valor.length() < estructura.getEstrLongitudMin().intValue()) {
                        getCvCarguecomparendo().setDescripcionError(registro + " - longitud no permitida en (" + estructura.getEstrNombreCampo() + ") min( :" + estructura.getEstrLongitudMin().intValue() + ") real(" + valor.length() + ") valor:" + valor + "- en el campo: (" + (i + 1) + ")");
                        setError(false);
                        break;
                    }
                    if (valor.length() > estructura.getEstrLongitudMax().intValue()) {

                        getCvCarguecomparendo().setDescripcionError(registro + " - longitud no permitida en (" + estructura.getEstrNombreCampo() + ")  max( :" + estructura.getEstrLongitudMax().intValue() + ") real(" + valor.length() + ") valor:" + valor + "- en el campo: (" + (i + 1) + ")");
                        setError(false);
                        break;
                    }
                    if (estructura.getEstrTipoDato().equals("numerico")) {
                        try {
                            long valorEntero = Long.parseLong(valor);
                        } catch (NumberFormatException e) {
                            getCvCarguecomparendo().setDescripcionError(registro + " - error en (" + estructura.getEstrNombreCampo() + ") al convertir valor a entero :(" + valor + ") causa :" + e.getMessage() + "- en el campo: (" + (i + 1) + ")");
                            setError(false);
                            break;
                        }

                    }
                    if (estructura.getEstrTipoDato().equals("fecha")) {
                        try {
                            Date valorFecha = new Date(new java.text.SimpleDateFormat("dd/mm/yyyy").parse(valor).getTime());
                        } catch (ParseException ex) {
                            getCvCarguecomparendo().setDescripcionError(registro + " - error en(" + estructura.getEstrNombreCampo() + ")  al convertir valor a fecha:(" + valor + ") requerido 'dd/mm/yyyy' causa :" + ex.getMessage() + "- en el campo: (" + (i + 1) + ")");
                            setError(false);
                            break;
                        }
                    }

                }
                datosCarguePlano.setValor(valor);
                listaValidados.add(datosCarguePlano);

            }
            if (isError()) {
                CivCarguecomparendo migracionComp = getCargueComparendosDAO().getCargueComparendo(Long.parseLong(listaCampos.get(1).toString()), listaCampos.get(15).toString(), Long.parseLong(listaCampos.get(14).toString()));
                if (migracionComp == null) {
                    getCvCarguecomparendo().setDescripcionError(registro + " - Guardado Exitosamente");
                } else {
                    getCvCarguecomparendo().setDescripcionError(registro + " - Ya se encuentra Registrado");
                    setError(false);
                }

                return listaValidados;
            }
            return null;
        } catch (Exception e) {
            getCvCarguecomparendo().setDescripcionError(registro + " - Error Fatal : " + e + "En el campo (" + nombreCampo + ")(" + numeroCampo + ") valor (" + valor + ")");
            setError(false);
            return null;
        }

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
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * @return the CvCarguecomparendo
     */
    public CivCarguecomparendo getCvCarguecomparendo() {
        return CvCarguecomparendo;
    }

    /**
     * @param CvCarguecomparendo the CvCarguecomparendo to set
     */
    public void setCvCarguecomparendo(CivCarguecomparendo CvCarguecomparendo) {
        this.CvCarguecomparendo = CvCarguecomparendo;
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
}
