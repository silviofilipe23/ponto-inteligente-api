/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.services;

import br.com.pontointeligente.api.entities.Funcionario;
import br.com.pontointeligente.api.repository.FuncionarioRepository;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author silvio
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

    @MockBean
    private FuncionarioRepository funcionarioRepository;
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @Before
    public void setUp(){
        BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
        BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
        BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
    }
    
    @Test
    public void testPersistirFuncionario(){
        Funcionario funcionario = this.funcionarioService.persistir(new Funcionario());        
        Assert.assertNotNull(funcionario);
    }
    
    @Test
    public void testFindByEmail(){
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("silvio@silvio.com");
        Assert.assertTrue(funcionario.isPresent());
    }
    
    @Test
    public void testFindByCpf(){
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("03588477101");
        Assert.assertTrue(funcionario.isPresent());
    }
    
}
