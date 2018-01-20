/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jdbc.dao.ITEstructuraSimit;
import com.contravenciones.jsf.bean.BeanPlanos;
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
            String msg = "";
            for (String string : param) {

                long idx = param.indexOf(string) + 1;
                CivEstructuraSimit ces = getEstructuraSimitDAO().getEstructuraSimit(idx, 1);

                msg = "";

                if (ces.getEstrObligatorio().equals("S") && string.isEmpty()) {
                    msg += "Line:" + line + " Error: El Campo " + ces.getEstrNombreCampo().trim().toLowerCase() + " es obligatorio. \r\n";
                    break;
                }

                int i;

                switch (ces.getEstrTipoDato()) {

                    case "numerico": {
                        try {
                            i = Integer.parseInt(string);
                            if (i > 19999 && idx == 1) {
                                msg += "El indice supero los 19999 registros. \r\n";
                            }
                        } catch (NumberFormatException e) {
                            msg += "El campo " + ces.getEstrNombreCampo().trim().toLowerCase() + " no tiene un formato valido o supero la cantidad aceptada por un numero entero. \r\n";
                        }
                    }
                    break;

                    case "alfanumerico": {
                        if (!(string.length() >= ces.getEstrLongitudMin().intValue()) && !(string.length() <= ces.getEstrLongitudMax().intValue())) {
                            msg += "La longitud de " + ces.getEstrNombreCampo().trim().toLowerCase() + " no es correcta. \r\n";
                        }
                    }
                    break;
                    case "fecha": {
                        if (string.length() == ces.getEstrLongitudMax().intValue()) {
                            try {
                                Date date = new Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(string).getTime());
                            } catch (ParseException e) {
                                msg += "El campo " + ces.getEstrNombreCampo().trim().toLowerCase() + " no tiene un formato valido \r\n";
                            }
                        } else {
                            msg += "La longitud de " + ces.getEstrNombreCampo().trim().toLowerCase() + " no es correcta. \r\n";
                        }
                    }
                    break;
                }
                if (!msg.isEmpty()) {
                    bean.setNoCargados((bean.getNoCargados() + 1));
                    bean.getHashLine().put("linea", line + "");
                    bean.getHashLine().put("msg", msg);
                    bean.getHashLine().put("value", string);
                    bean.getListLinea().add(bean.getHashLine());
                    break;
                }
            }//next 
            if (!msg.isEmpty()) {
                continue;
            }
            bean.setCargados((bean.getCargados() + 1));
        }
    }

    @Override
    public String validarLiena(List<String> list) throws Exception {
        try {
            for (String string : list) {
                int indx = list.indexOf(string);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
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

}
