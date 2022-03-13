/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente;

/**
 *
 * @author dell
 */
public class Cliente {
    private long id;
    private String nome;
    private String sobrenome;
    private String rg;
    private long cpf;
    private String endereco;
    
    public Cliente(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
}
