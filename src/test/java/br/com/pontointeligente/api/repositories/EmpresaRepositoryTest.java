/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repositories;

import br.com.pontointeligente.api.entities.Empresa;
import br.com.pontointeligente.api.repository.EmpresaRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author silvio
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
    
    @Autowired
    EmpresaRepository empresaRepository;
    
    private static final String CNPJ = "51463645000100";
    
    @Before
    public void setUp() {
        Empresa empresa = new Empresa();
        empresa.setCnpj(CNPJ);
        empresa.setRazaoSocial("Empresa de Exemplo");
        
        this.empresaRepository.save(empresa);
    }
    
    @After
    public final void tearDown(){
        this.empresaRepository.deleteAll();
    }
    
    @Test
    public void testBuscarPorCnpj(){
        Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
        
        Assert.assertEquals(CNPJ, empresa.getCnpj());
    }
    
    
}
