/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class Cliente implements Comparable<Cliente>,Autenticavel{

   
    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private long cpf;
    private String endereco;
    private String orderBy;
    
    public Cliente(){
    }
    
    public Cliente(String nome, String sobrenome , String rg, long cpf, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.orderBy = "nome";
    }

    public Cliente(int id, String nome, String sobrenome, String rg, Long cpf, String endereco,String order) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.orderBy =order;
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
    
    public void setOrderBy(String order){
        this.orderBy = order;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    } 

    @Override
    public int compareTo(Cliente o) {
        if(orderBy.equalsIgnoreCase("nome")){
            return this.getNome().compareToIgnoreCase(o.getNome());
        }else if(orderBy.equalsIgnoreCase("sobrenome")){
            return this.getSobrenome().compareToIgnoreCase(o.getSobrenome());
        }else if(orderBy.equalsIgnoreCase("cpf")){
            if(this.getCpf() > (o.getCpf()))return 1;
            else if(this.getCpf() < (o.getCpf()))return -1;
            else return 0;
        }else if(orderBy.equalsIgnoreCase("id")){
            if(this.getId() > (o.getId()))return 1;
            else if(this.getId() < (o.getId()))return -1;
            else return 0;
        }else
            throw new RuntimeException("Erro na comparação");
    }

    @Override
    public boolean isValid() {
        
        if(this.getNome().matches("[(+=-*/^)0-9]!@#$")) throw new RuntimeException("Só é permitido caracteres no nome"); 
        if(this.getEndereco().matches("[(+=*/^)]")) throw new RuntimeException("Só é permitido caracteres e numeros no endereço");
        if(this.getSobrenome().matches("[(+=-*/^)0-9]")) throw new RuntimeException("Só é permitido caracteres no sobrenome");
        if(this.getRg().matches("[(+=%$#@*/^)]")) throw new RuntimeException("Só é permitido numeros e letras no Rg");
        return true;
    }
}
// 