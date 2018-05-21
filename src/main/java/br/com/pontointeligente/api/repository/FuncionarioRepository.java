/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repository;

import br.com.pontointeligente.api.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvio
 */
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByCpf(String cpf);

    Funcionario findByEmail(String email);

    Funcionario findByCpfOrEmail(String cpf, String email);
}
