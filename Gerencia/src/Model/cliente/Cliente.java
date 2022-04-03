/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente;

import java.time.LocalDate;

/**
 *
 * 
 */
public class Cliente implements Comparable{
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String endereco;
    
    public Cliente(String nome, String sobrenome , String rg, String cpf, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }
       
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    // esta funcao permite comparar valores e temos que implementar para retornar a lista ordenada segundo os parametros que a gente estabeleça 
    @Override
    public int compareTo(Object o) {
     return 0;   
    }
    
}
