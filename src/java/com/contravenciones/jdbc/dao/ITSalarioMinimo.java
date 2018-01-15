/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package com.contravenciones.jdbc.dao;

import com.contravenciones.tr.persistence.CivSalariosminimos;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITSalarioMinimo {

    /**
     *
     * @param oficinasJuridicas
     * @return
     * @throws Exception
     */
    public long insert(CivSalariosminimos oficinasJuridicas) throws Exception;

    /**
     *
     * @param oficinasJuridicas
     * @return
     * @throws Exception
     */
    public boolean update(CivSalariosminimos oficinasJuridicas) throws Exception;

    /**
     *
     * @param vigencia
     * @return
     * @throws Exception
     */
    public CivSalariosminimos salarioPorVigencia(long vigencia) throws Exception;
    
    /**
     *
     * @param vigencia
     * @return
     * @throws Exception
     */
    public CivSalariosminimos salarioByVigencia(long vigencia) throws Exception;
    
    /**
     
     * @return
     * @throws Exception
     */
    public List<CivSalariosminimos> listVigencia() throws Exception;
    
    
}
