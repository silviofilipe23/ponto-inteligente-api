/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Lancamento;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author silvio
 */
public interface LancamentoService {

    /**
     * Retorna um lançamento por ID.
     *
     * @param id
     * @return Optional<Lancamento>
     */
    Optional<Lancamento> buscarPorId(Long id);

    /**
     * Busca os lançamentos de um funcionário e retorna um objeto de paginação.
     *
     * @param funcionarioId
     * @param pageRequest
     * @return
     */
    Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

    /**
     * Persistir um lançamento no banco de dados.
     *
     * @param lancamento
     * @return
     */
    Lancamento persistir(Lancamento lancamento);

    /**
     * Remover lançamento pelo id
     *
     * @param id
     */
    void remover(Long id);

}
