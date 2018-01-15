/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.tr.bo;

import com.contravenciones.exception.SalarioMinimoException;
import com.contravenciones.jdbc.dao.ITSalarioMinimo;
import com.contravenciones.jsf.bean.BeanSalarioMinimo;
import com.contravenciones.tr.persistence.CivSalariosminimos;
import com.contravenciones.utility.ValidacionDatos;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Roymer Camacho
 */
public class SalarioMinimoImplBO implements SalarioMinimoBO {

    private ITSalarioMinimo salarioMinimoDAO;

    @Override
    public void listVig(BeanSalarioMinimo bean) throws Exception {
        bean.setListVigencia(new ArrayList<>());
        for (CivSalariosminimos vig : getSalarioMinimoDAO().listVigencia()) {
            bean.getListVigencia().add(vig);
        }

    }

    @Override
    public void salarioVigencia(BeanSalarioMinimo bean) throws Exception {

        CivSalariosminimos min = getSalarioMinimoDAO().salarioPorVigencia(bean.getCodeVigencia());

        if (min != null) {
            bean.setVigencia(String.valueOf(min.getSalVigencia()));
            bean.setSalario(min.getSalValor().doubleValue());
        }

    }

    @Override
    public void registrarSalario(BeanSalarioMinimo bean) throws Exception {

        ValidacionDatos v = new ValidacionDatos();
        if (!v.validarSolonumeros(bean.getVigencia()) || v.validarSolonumeros(String.valueOf(bean.getSalario()))) {
            throw new SalarioMinimoException("Los campos deben contener sólo números", 2);
        }

        if (bean.getSalario() == 0 || bean.getVigencia().equals("")) {
            throw new SalarioMinimoException("Campos obligatorios vacíos", 2);
        }

        if (bean.getVigencia().length() != 4) {
            throw new SalarioMinimoException("Vigencia inválida", 2);
        }

        CivSalariosminimos comprobar = getSalarioMinimoDAO().salarioByVigencia(Long.parseLong(bean.getVigencia()));
        if (comprobar == null) {
            CivSalariosminimos sal = new CivSalariosminimos();
            sal.setSalValor(BigDecimal.valueOf(bean.getSalario()));
            sal.setSalVigencia(BigDecimal.valueOf(Integer.parseInt(bean.getVigencia())));
            getSalarioMinimoDAO().insert(sal);
        } else {
            throw new SalarioMinimoException("La vigencia ya tiene asignada un salario mínimo", 2);
        }

    }

    @Override
    public void actualizarVigencia(BeanSalarioMinimo bean) throws Exception {

        ValidacionDatos v = new ValidacionDatos();
        if (!v.validarSolonumeros(bean.getVigencia()) || v.validarSolonumeros(String.valueOf(bean.getSalario()))) {
            throw new SalarioMinimoException("Los campos deben contener sólo números", 2);
        }

        if (bean.getSalario() == 0 || bean.getVigencia().equals("")) {
            throw new SalarioMinimoException("Campos obligatorios vacíos", 2);
        }

        if (bean.getVigencia().length() != 4) {
            throw new SalarioMinimoException("Vigencia inválida", 2);
        }

        CivSalariosminimos sal = new CivSalariosminimos();
        sal.setSalId(BigDecimal.valueOf(bean.getCodeVigencia()));
        sal.setSalValor(BigDecimal.valueOf(bean.getSalario()));
        sal.setSalVigencia(BigDecimal.valueOf(Integer.parseInt(bean.getVigencia())));
        getSalarioMinimoDAO().update(sal);

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
}
