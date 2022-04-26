/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class Moeda {
    
    // Um atributo que guarda o valor no tipo BigDecimal
    private BigDecimal valor;
    // Uma string que será utilizada no momento de apresentar o valor
    private static final String REAIS = "R$";
    // O formato permitindo apenas duas casas depois do ponto, separados por virgula 
    private static final DecimalFormat FORMAT = new DecimalFormat(REAIS + " #,###,##0.00");
    
    // Construtores - Vacio
    public Moeda (){
    
    }
    // Construtor para quando é lida uma String
    public Moeda(String v){
        try{
            this.valor = new BigDecimal(v).setScale(4,RoundingMode.HALF_EVEN);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        
    }
    
    // Construtor para quando é lido um double
    public Moeda(double v){
        try{
            this.valor = new BigDecimal(v).setScale(4,RoundingMode.HALF_EVEN);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    //construtor pasasndo un BigDecimal
    public Moeda(BigDecimal b){
        this.valor = b;
    }
    
    
    // seto o valor 
    public void setValor(BigDecimal v){
        this.valor = v;
    }
    // obtenho o valor
    public BigDecimal getValor(){
        return this.valor;
    }
    // sobreecrevo o metodo toString para apresentar o dinheiro -> R$ 1,892,890.43 
    @Override
    public String toString(){
        return FORMAT.format(valor);
    }
    // soma o valor desta moeda com o valor de outra, retorna esta moeda com o novo valor 
    public Moeda soma(Moeda m){
        this.valor = this.valor.add(m.getValor());
        return this;
    }
    // resta o valor de outra moeda nesta, retorna esta moeda com o novo valor
    public Moeda resta(Moeda m){
        this.valor = this.valor.subtract(m.getValor());
        return this;
    }
    // Multiplica o valor desta moeda por o valor de outra, retorna essa moeda com o novo valor
    public Moeda multiplica(Moeda m){
        m.setValor(this.valor.multiply(m.getValor()));
        return m;
    }
    // verifica se o valor da moeda instanciada é negativo
    public boolean isNegative(){
        return(this.getValor().doubleValue()<0);
    }
    
    public int isCero(){
        return (this.getValor().compareTo(BigDecimal.ZERO));
    }
    
}
