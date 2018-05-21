/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Empresa;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvio
 */

public interface EmpresaService {
    
    /**
     * Retorna uma empresa pelo CNPJ.
     * 
     * @param cnpj
     * @return Optional<Empresa>
     */
    Optional<Empresa> buscarPorCnpj(String cnpj);
    
    /**
     * Cadastra uma empresa no banco de dados.
     * 
     * @param empresa
     * @return Empresa
     */
    Empresa persistir(Empresa empresa);
    
}
