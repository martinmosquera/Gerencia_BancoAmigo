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
    private Moeda limite;
    
    public ContaCorrente(Cliente cliente,int num,Moeda saldo,Moeda depositoinicial,Moeda limite){
        super(cliente,num,saldo,depositoinicial);
        this.limite = limite;
    }
    public ContaCorrente(Moeda valor){
        super(valor);     
    }
    public ContaCorrente(){
    
    }
    
    @Override
    public boolean saca(Moeda valor) {
        try{
            if(valor.getValor().doubleValue() > (this.getSaldo().getValor().doubleValue() + (this.limite.getValor().doubleValue()))){
            throw new RuntimeException("Sua conta não tem saldo Suficiente!!");
        };
            super.saca(valor);
            return true;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        
    }

    public void setLimite(Moeda d) {
        if(d.isNegative()) throw new RuntimeException("Não pode Adicionar valores negativos no Limite!!");
        this.limite = d;
    }

    public Moeda getLimite() {
        return this.limite;
    }
    
    @Override
    public void remunera(){
        String dado = "0.01";
        Moeda m = this.getSaldo().multiplica(new Moeda(dado));
        super.deposita(m);
    }
}
