/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repository;

import br.com.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvio
 */

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
    @Transactional(readOnly = true)
    Empresa findByCnpj(String cnpj); 
    
}
