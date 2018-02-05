/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanGestionPersona;
import com.contravenciones.jsf.bean.BeanPlanos;
import com.contravenciones.tr.persistence.CivCarguecomparendo;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Soporte 2
 */
public interface PlanosBO {
    
    public List obtenerCampos(String text) throws Exception;
    
    public boolean validarlineaComparendo(List listaCampos, int tipo) throws Exception;
    
    public boolean guardarComparendoPlano(BeanPlanos bean)throws Exception;
    
    public boolean guardarCargueComparendo(List listaDatosValidados) throws Exception;
    
    public boolean guardarComparendo(CivCarguecomparendo cargueComparendo) throws SQLException, ParseException, Exception;
}
