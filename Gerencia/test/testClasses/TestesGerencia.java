/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses;

import Model.cliente.Cliente;
import Model.conta.ContaCorrente;
import Model.conta.Moeda;
import java.math.BigDecimal;
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
    @Test
        public void testeContaCSaldo(){
        ContaCorrente cc = new ContaCorrente(new Moeda(String.valueOf(1000.00)));
        Moeda limite;
        limite = cc.getSaldo();
        assertEquals(1000.00,limite.getValor().doubleValue(),0.0);
        }
        
    @Test
        public void testeContaC2LimteNegativo(){
        ContaCorrente cc = new ContaCorrente(new Moeda(String.valueOf(5000.0)));
        String message = "";
        try{
            cc.setLimite(new Moeda("-13.6"));
        }catch(Exception e){
            message = e.getMessage();
        }
        assertEquals("Não pode Adicionar valores negativos no Limite!!",message);
        }
        
    @Test
        public void testeContaC3Remunera(){
            ContaCorrente cc = new ContaCorrente(new Moeda(String.valueOf(100.00)));
            cc.remunera();
            Moeda num = cc.getSaldo();
            assertEquals(101.00,num.getValor().doubleValue(),0.0);
        }
        
    @Test
        public void testeContaC4Saca(){
            ContaCorrente cc = new ContaCorrente();
            cc.setSaldo(new Moeda("100.00"));
            cc.saca(new Moeda("10.00"));
            Moeda num = cc.getSaldo();
            assertEquals(90.00,num.getValor().doubleValue(),0.0);
        }
     
    @Test
        public void testeContaC4Saca21(){
            ContaCorrente cc = new ContaCorrente(new Moeda(String.valueOf(100.00)));
            cc.saca(new Moeda(String.valueOf(10.00)));
            Moeda num = cc.getSaldo();
            assertEquals(90.00,num.getValor().doubleValue(),0.0);
        }
        
        
     @Test
        public void testeContaC4Saca2(){
            ContaCorrente cc = new ContaCorrente();
            Moeda m = new Moeda("100.00");
            try{
                
                cc.setDepositoInicial(m);
                cc.setSaldo(m);
                m.setValor(BigDecimal.valueOf(-10.00));
                cc.saca(m);
            }catch(Exception e){
                assertEquals("Não pode sacar valores negativos!!",e.getMessage());

            }
            
        }
        
    @Test
        public void testeContaC4Saca3(){
            ContaCorrente cc = new ContaCorrente(new Moeda(String.valueOf(100.00)));
            String message = "";
            try{
                cc.saca(new Moeda(String.valueOf(200.00)));
            }catch(Exception e){
                message = e.getMessage();
            }
            assertEquals("Sua conta não tem saldo Suficiente!!",message);
        }
        
}