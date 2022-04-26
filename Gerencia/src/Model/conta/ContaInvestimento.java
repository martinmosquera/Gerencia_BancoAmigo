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
public class ContaInvestimento extends Conta{
    
    private Moeda depositoMinimo = new Moeda("100.00");
    private Moeda montanteMinimo = new Moeda("100.00");
    
    public ContaInvestimento(Cliente cliente,int num, Moeda saldo, Moeda depositoini) {
        super(cliente, num, saldo, depositoini);
    }
    
    public ContaInvestimento(){
    }
    
@Override
    public boolean deposita(Moeda valor){
        if((valor.getValor().compareTo(this.depositoMinimo.getValor())) == -1){
            throw new RuntimeException("O valor é menor que o permitido!!");
        }else{
            super.deposita(valor);
            return true;
        }
    }
    
@Override
    public boolean saca(Moeda valor){
        if((this.getSaldo().getValor().doubleValue() - valor.getValor().doubleValue()) >= montanteMinimo.getValor().doubleValue()){
            try{
                super.saca(valor);
                return true;
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }else{
            throw new RuntimeException("O valor do saque é maior que o permitido para manter a conta - (Montante Minimo)!!");
        }        
    }
    
@Override
    public void remunera(){
        super.deposita(this.getSaldo().multiplica(new Moeda(0.02)));
    }

    public Moeda getMontanteMin() {
        return montanteMinimo;
    }
    
   
    public Moeda getDepositoMin() {
         return depositoMinimo;
    }
}
