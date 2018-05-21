/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Lancamento;
import java.util.Optional;

/**
 *
 * @author silvio
 */
public interface LancamentoService {
    
    /**
     *
     * 
     * @param id
     * @return 
     */
    Optional<Lancamento> buscarPorFuncionarioId(Long id);
    
    
}
