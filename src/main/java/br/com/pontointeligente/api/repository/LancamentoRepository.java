/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repository;

import br.com.pontointeligente.api.entities.Lancamento;
import java.util.List;
import java.util.Optional;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvio
 */
@Transactional(readOnly = true)
@Repository
@NamedQueries({
        @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
                query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId")
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
    
    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
    
    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
    
    @Override
    Optional<Lancamento> findById(Long id);
    
}
