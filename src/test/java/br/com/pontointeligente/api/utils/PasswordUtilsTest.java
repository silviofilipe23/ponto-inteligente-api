/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontointeligente.api.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author silvio
 */
public class PasswordUtilsTest {
    
    private static final String SENHA = "123456";
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @Test
    public void testSenhaNula(){
        Assert.assertNull(PasswordUtils.gerarBCrypt(null));
    }
    
    @Test
    public void testGerarBCrypt(){
        String hash = bCryptPasswordEncoder.encode(SENHA);        
        
        Assert.assertTrue(bCryptPasswordEncoder.matches(SENHA, hash));
    }
        
}
