/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 *
 * 
 */
public class Cliente implements Comparable{
    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private long cpf;
    private String endereco;
    
    public Cliente(){
    }
    
    public Cliente(String nome, String sobrenome , String rg, long cpf, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente(int id, String nome, String sobrenome, String rg, Long cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    // funcao propia da interface comparable
    @Override
    public int compareTo(Object o) {
        Cliente c2 = (Cliente)o;
        return (this.getNome().compareToIgnoreCase(c2.getNome()));  
    }
    
    public static List<Cliente> orderByName(List<Cliente> lista){
         Collections.sort(lista, (Cliente c1, Cliente c2) -> {
                return c1.compareTo(c2);
            });
         return lista;
    }
}
