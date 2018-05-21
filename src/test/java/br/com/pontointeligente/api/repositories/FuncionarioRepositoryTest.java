/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repositories;

import br.com.pontointeligente.api.entities.Empresa;
import br.com.pontointeligente.api.entities.Funcionario;
import br.com.pontointeligente.api.enums.PerfilEnum;
import br.com.pontointeligente.api.repository.EmpresaRepository;
import br.com.pontointeligente.api.repository.FuncionarioRepository;
import br.com.pontointeligente.api.utils.PasswordUtils;
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
public class FuncionarioRepositoryTest {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    private static final String CPF = "03588477101";
    private static final String EMAIL = "silvio.dionizio23@gmail.com";

    @Before
    public void setUp() throws Exception{
        Empresa empresa = empresaRepository.save(obterDadosEmpresa());
        funcionarioRepository.save(obterDadosFuncionario(empresa));
    }
    
    @After
    public void tearDown(){
       this.empresaRepository.deleteAll();
    }
    
    @Test
    public void testFindByEmail(){
        Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);        
        
        Assert.assertEquals(EMAIL, funcionario.getEmail());
    }
    
    @Test
    public void testFindByCpf(){
        Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);        
        
        Assert.assertEquals(CPF, funcionario.getCpf());
    }
    
    @Test
    public void testFindByCpfOrEmail(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);        
        
        Assert.assertNotNull(funcionario);
    }
    
    @Test
    public void testFindByCpfOrEmailInvalidEmail(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "teste@teste.com");        
        
        Assert.assertNotNull(funcionario);
    }
    
    @Test
    public void testFindByCpfOrEmailInvalidCpf(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("47884088134", EMAIL);        
        
        Assert.assertNotNull(funcionario);
    }

    public Funcionario obterDadosFuncionario(Empresa empresa) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(CPF);
        funcionario.setEmail(EMAIL);
        funcionario.setNome("Silvio Filipe Dionizio Junior");
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
        funcionario.setEmpresa(empresa);
        return funcionario;
    }

    public Empresa obterDadosEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCnpj("51463645000100");
        empresa.setRazaoSocial("Empresa de Exemplo");
        return empresa;
    }

}
