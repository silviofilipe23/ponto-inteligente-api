/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Lancamento;
import br.com.pontointeligente.api.repository.LancamentoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author silvio
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {
    
    @MockBean
    LancamentoRepository lancamentoRepository;
    
    @Autowired
    LancamentoService lancamentoService;    
    
    @Before
    public void setUp(){
        BDDMockito.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
                .willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
        BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
    }
    
    @Test
    public void testBuscarLancamentoPorID(){
        Page<Lancamento> lancamentos = this.lancamentoService.buscarPorFuncionarioId(1L, new PageRequest(0, 10));
        Assert.assertNotNull(lancamentos);       
    }
    
    @Test
    public void testBuscarLancamentoId(){       
        Optional<Lancamento> lancamento = this.lancamentoService.buscarPorId(1L);
        Assert.assertNotNull(lancamento.isPresent());
    }
    
    @Test
    public void testPersistirLancamento(){
        Lancamento lancamento = this.lancamentoService.persistir(new Lancamento());
        Assert.assertNotNull(lancamento);
    }
    
}
