/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class ContaCorrente extends Conta{
    private double limite;
    
    public ContaCorrente(Cliente cliente,int num,double saldo,double depositoinicial,double limite){
        super(cliente,num,saldo,depositoinicial);
        this.limite = limite;
    }
    public ContaCorrente(double valor){
        super(valor);     
        
    }
    public ContaCorrente(){
    
    }
    
    @Override
    public boolean saca(double valor) {
        if(valor > (this.getSaldo()+this.limite)){
            throw new RuntimeException("Sua conta não tem saldo Suficiente!!");
        };
        super.saca(valor);
        return true;
    }

    public void setLimite(double d) {
        if(d<0) throw new RuntimeException("Não pode Adicionar valores negativos no Limite!!");
        this.limite = d;
    }

    public double getLimite() {
        return this.limite;
    }
    
    @Override
    public void remunera(){
        this.deposita(this.getSaldo()*0.01);
    }
}
