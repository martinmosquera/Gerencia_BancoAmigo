/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses;

import Model.cliente.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author dell
 */
public class TestesGerencia {
    
    public TestesGerencia() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
        public void testeClienteCreate() {
        Cliente cl = new Cliente();
        assertEquals("Cliente",cl.getClass().getSimpleName());
 
    }

    @Test
    public void testeClienteId() {
        Cliente cl = new Cliente();
        cl.setId(92391);
        assertEquals(92391,cl.getId(),0.0);
    }
     
    @Test
        public void testeClienteNome() {
        Cliente cl = new Cliente();
        cl.setNome("martin");
        assertEquals("martin",cl.getNome());
    }
        
    @Test
        public void testeClienteSobreome() {
        Cliente cl = new Cliente();
        cl.setSobrenome("Kutzke");
        assertEquals("Kutzke",cl.getSobrenome());
    }
        
    @Test
        public void testeClienteRg() {
        Cliente cl = new Cliente();
        cl.setRg("G40258-X");
        assertEquals("G40258-X",cl.getRg());
    }
        
    @Test
        public void testeClienteCpf() {
        Cliente cl = new Cliente();
        cl.setCpf(80058267964L);
        assertEquals(80058267964L,cl.getCpf());
    }
        
    @Test
        public void testeClienteEndereco() {
        Cliente cl = new Cliente();
        cl.setEndereco("Rua dos esquecidos");
        assertEquals("Rua dos esquecidos",cl.getEndereco());
    }
        
}
