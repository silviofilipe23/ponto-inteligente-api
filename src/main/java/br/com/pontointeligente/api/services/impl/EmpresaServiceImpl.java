/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services.impl;

import br.com.pontointeligente.api.entities.Empresa;
import br.com.pontointeligente.api.repository.EmpresaRepository;
import br.com.pontointeligente.api.services.EmpresaService;
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
public class EmpresaServiceImpl implements EmpresaService{
    
    private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCnpj(String cnpj) {
        logger.info("Buscando uma empresa pelo CNPJ: {}", cnpj);
        
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa persistir(Empresa empresa) {
        logger.info("Adicionando uma nova empresa: {}", empresa);
        
        return this.empresaRepository.save(empresa);
    }
    
}
