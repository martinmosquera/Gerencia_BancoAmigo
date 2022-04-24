/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;

/**
 *
 * @author dell
 */
public class ContaInvestimento extends Conta{
    
    private double depositoMinimo;
    private double montanteMinimo;
    private String msg;
    
    public ContaInvestimento(Cliente cliente,int num, double saldo, double depositoini) {
        super(cliente, num, saldo, depositoini);
    }
    
    public ContaInvestimento(){
        depositoMinimo = 100.0;
        montanteMinimo = 100.0;
    }
    
@Override
    public boolean deposita(double valor){
        if(valor >= depositoMinimo){
            super.deposita(valor);
            return true;
        }else{
            throw new RuntimeException("O valor é menor que o permitido!!");
        }
        
    }
    
@Override
    public boolean saca(double valor){
        if((this.getSaldo()-valor) >= montanteMinimo){
            try{
                super.saca(valor);
                return true;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }else{
            throw new RuntimeException("O valor do saque é maior que o permitido para manter a conta - (Montante Minimo)!!");
        }        
    }
    
@Override
    public void remunera(){
        super.deposita(this.getSaldo()*0.02);
    }

    public double getMontanteMin() {
        return montanteMinimo;
    }
    
   
    public double getDepositoMin() {
         return depositoMinimo;
    }

    public void setMsg(String msg) {
         
        this.msg = msg;
    
    }

    public String getMsg() {
          return this.msg;
    }
}
