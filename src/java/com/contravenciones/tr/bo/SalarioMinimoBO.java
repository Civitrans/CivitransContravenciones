/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.jsf.bean.BeanSalarioMinimo;
import com.contravenciones.tr.persistence.CivSalariosminimos;


/**
 *
 * @author Roymer Camacho
 */
public interface SalarioMinimoBO {

    /**
     *
     * @param bean
     * @throws Exception
     */
    void listVig(BeanSalarioMinimo bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void salarioVigencia(BeanSalarioMinimo bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void registrarSalario(BeanSalarioMinimo bean) throws Exception;
    
    /**
     *
     * @param bean
     * @throws Exception
     */
    void actualizarVigencia(BeanSalarioMinimo bean) throws Exception;
    
}
