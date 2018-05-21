/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.repositories;

import br.com.pontointeligente.api.entities.Empresa;
import br.com.pontointeligente.api.entities.Funcionario;
import br.com.pontointeligente.api.entities.Lancamento;
import br.com.pontointeligente.api.enums.PerfilEnum;
import br.com.pontointeligente.api.enums.TipoEnum;
import br.com.pontointeligente.api.repository.EmpresaRepository;
import br.com.pontointeligente.api.repository.FuncionarioRepository;
import br.com.pontointeligente.api.repository.LancamentoRepository;
import br.com.pontointeligente.api.utils.PasswordUtils;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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
public class LancamentoRepositoryTest {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    LancamentoRepository lancamentoRepository;
    
    private Long funcionarioId;

    @Before
    public void setUp() {
        Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
        Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
        
        funcionarioId = funcionario.getId();
        
        this.lancamentoRepository.save(obterDadosLancamento(funcionario));
        this.lancamentoRepository.save(obterDadosLancamento(funcionario));
    }
    
    @After
    public void tearDown(){
        this.empresaRepository.deleteAll();
    }
    
    @Test
    public void testFindByFuncionarioId(){
        List<Lancamento> lstLancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
        
        Assert.assertEquals(2, lstLancamentos.size());        
    }
    
    @Test
    public void testFindByFuncionarioIdPageable(){
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<Lancamento> lstLancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
        
        Assert.assertEquals(2, lstLancamentos.getTotalElements());        
    }
    
    public Lancamento obterDadosLancamento(Funcionario funcionario){
        Lancamento lancamento = new Lancamento();
        lancamento.setData(new Date());
        lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
        lancamento.setFuncionario(funcionario);
        return lancamento;
    }

    public Funcionario obterDadosFuncionario(Empresa empresa) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("03588477101");
        funcionario.setEmail("silvio.dionizio23@gmail.com");
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
