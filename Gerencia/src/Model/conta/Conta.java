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
 * @author dell
 */
public abstract class Conta implements ContaI{
    
    private Cliente cliente;
    private int num;
    private double saldo;
    private double depositoInicial;
    private String tipo;
    
    public Conta(Cliente cliente,int num,double saldo,double depini){
        this.cliente = cliente;
        this.num = num;
        this.saldo = saldo;
        this.depositoInicial = depini;
    }
    public Conta(double valor){
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

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }
    
    @Override
    public boolean deposita(double valor) {
        if(valor < 0) return false;
        saldo += valor;
        return true;
        
    }

    @Override
    public boolean saca(double valor) {
        if(valor < 0 ){
            throw new RuntimeException("Não pode sacar valores negativos!!");
        }
        saldo -= valor;
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
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void remunera() {
        
    }

    public String getTipo() {
        return this.tipo;
    }

    
   
}
