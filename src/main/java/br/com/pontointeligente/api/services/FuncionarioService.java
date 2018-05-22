/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Funcionario;
import java.util.Optional;

/**
 *
 * @author silvio
 */
public interface FuncionarioService {

    /**
     * Persiste um funcionário na base de dados.
     *
     * @param funcionario
     * @return Funcionario
     */
    Funcionario persistir(Funcionario funcionario);

    /**
     * Busca e retorna um funcionário dado um CPF.
     *
     * @param cpf
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorCpf(String cpf);

    /**
     * Busca e retorna um funcionário dado um email.
     *
     * @param email
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorEmail(String email);


}
