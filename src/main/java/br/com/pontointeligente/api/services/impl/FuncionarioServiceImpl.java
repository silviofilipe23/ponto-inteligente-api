/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services.impl;

import br.com.pontointeligente.api.entities.Funcionario;
import br.com.pontointeligente.api.repository.FuncionarioRepository;
import br.com.pontointeligente.api.services.FuncionarioService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvio
 */
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final Logger logger = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario persistir(Funcionario funcionario) {
        logger.info("Persistindo funcionario: {}", funcionario);

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpf) {
        logger.info("Buscando funcionário pelo CPF: {}", cpf);

        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        logger.info("Buscando funcionário pelo email: {}", email);

        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

}
