/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanPlanos;
import com.contravenciones.tr.persistence.CivEstructuraSimit;
import java.util.List;

/**
 *
 * @author Soporte 2
 */
public interface PlanosBO {

    public void getListEstructura(BeanPlanos bean) throws Exception;

    public String validarLiena(List<String> list) throws Exception;

}
