/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services.impl;

import br.com.pontointeligente.api.entities.Lancamento;
import br.com.pontointeligente.api.repository.LancamentoRepository;
import br.com.pontointeligente.api.services.LancamentoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvio
 */
@Service
public class LancamentoServiceImpl implements LancamentoService {

    private static final Logger logger = LoggerFactory.getLogger(LancamentoServiceImpl.class);

    @Autowired
    LancamentoRepository lancamentoRepository;

//    @Cacheable("lancamentoPorId")
//    public Optional<Lancamento> buscarPorId(Long id) {
//        logger.info("Buscando um lançamento pelo ID {}", id);
//        return Optional.ofNullable(this.lancamentoRepository.findOne(id));
//    }
    @Override
    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        logger.info("Buscando lançamentos para o funcionario ID: {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    @Override
    public Lancamento persistir(Lancamento lancamento) {
        logger.info("Persistindo o lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    @Override
    public void remover(Long id) {
        logger.info("Removendo o lançamento ID {}", id);
        this.lancamentoRepository.deleteById(id);
    }

    @Override
    public Optional<Lancamento> buscarPorId(Long id) {
        logger.info("Buscando o lançamento ID {}", id);
        return this.lancamentoRepository.findById(id);
    }

}
