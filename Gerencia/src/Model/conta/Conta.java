/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;
//import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public abstract class Conta implements ContaI{
    
    private Cliente cliente;
    private int num;
    private Moeda saldo;
    private Moeda depositoInicial;
    private String tipo;
    
    public Conta(Cliente cliente,int num,Moeda saldo,Moeda depini){
        this.cliente = cliente;
        this.num = num;
        this.saldo = saldo;
        this.depositoInicial = depini;
    }
    public Conta(Moeda valor){
        this.num = (int)(Math.random()*1000+1);
        saldo = valor;
        depositoInicial = valor;
    }
    public Conta(){
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Moeda getDepositoInicial() {
        return depositoInicial;
    }

    public void setDepositoInicial(Moeda deposito) {
        if(deposito.isNegative()) {
            throw new RuntimeException("O deposito Inicial não pode ser negativo!!");
        }
        this.depositoInicial = deposito;
    }
    
    @Override
    public boolean deposita(Moeda valor) {
        if(valor.isNegative()){
            throw new RuntimeException("Não pode depositar valores negativos!!");
        }
        saldo = saldo.soma(valor);
        return true;
        
    }

    @Override
    public boolean saca(Moeda valor) {
        if(valor.isNegative()){
            throw new RuntimeException("Não pode sacar valores negativos!!");
        }
        saldo = saldo.resta(valor);
        return true;
    }

    @Override
    public Cliente getDono() {
        return cliente;
    }

    @Override
    public int getNumero() {
        return this.num;
    }

    @Override
    public Moeda getSaldo() {
        return this.saldo;
    }

    @Override
    public void remunera() {
        
    }

    public String getTipo() {
        return this.tipo;
    }
    
    public void setSaldo(Moeda saldo){
        this.saldo  = saldo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
   
}
