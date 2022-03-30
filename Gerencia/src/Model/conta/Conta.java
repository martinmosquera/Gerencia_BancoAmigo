/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author dell
 */
public abstract class Conta implements ContaI{
    
    private Cliente cliente;
    private int num;
    private double saldo;
    private double depositoInicial;
    
    public Conta(int num,double saldo,double depini){
        this.num = num;
        this.saldo = saldo;
        this.depositoInicial = depini;
    }
    public Conta(double valor){
        this.num = (int)(Math.random()*1000+1);
        saldo = valor;
        depositoInicial = valor;
    }
    
    @Override
    public boolean deposita(double valor) {
        if(valor < 0) return false;
        saldo += valor;
        return true;
        
    }

    @Override
    public boolean saca(double valor) {
        if(valor < 0) return false;
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
    public void setSaldo(double valor){
    this.saldo = valor;
    }
    
}
