/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

/**
 *
 * @author dell
 */
public class ContaCorriente extends Conta{
    private double limite;
    
    public ContaCorriente(int num,double saldo,double depositoinicial,double limite){
        super(num,saldo,depositoinicial);
        this.limite = limite;
    }
    public ContaCorriente(double valor){
        super(valor);     
        
    }
    
    
    @Override
    public boolean saca(double valor) {
        if(valor < 0 ){
            throw new RuntimeException("Não pode sacar valores negativos!!");
        }
        if(valor > this.getSaldo()){
            throw new RuntimeException("Sua conta não tem saldo Suficiente!!");
        };
        this.setSaldo(this.getSaldo()-valor);
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