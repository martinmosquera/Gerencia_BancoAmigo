/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente.clienteDao;

import Model.ConnectionFactory.ConnectionFactory;
import Model.cliente.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ClienteDao {
    
    private ConnectionFactory connectionFactory;
    
    private final String insert = "insert into clientes (nome,sobrenome,rg,cpf,endereco) values (?,?,?,?,?)";
    private final String select = "select * from clientes";
    private final String update = "update clientes set nome=?, sobrenome=?, rg=?, cpf=?,endereco=? WHERE id=?";
    private final String delete = "delete from clientes WHERE id=?";

    public ClienteDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Cliente cliente) {
        Connection connection=connectionFactory.getConnection();
        try {
            // prepara o statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            stmtAdiciona.setString(1, (String)cliente.getNome());
            stmtAdiciona.setString(2, (String)cliente.getSobrenome());
            stmtAdiciona.setString(3, cliente.getRg());
            stmtAdiciona.setLong(4, cliente.getCpf());
            stmtAdiciona.setString(5, cliente.getEndereco());
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            cliente.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public List<Cliente> getLista() throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                int id = rs.getInt("cliente_id");
                String nome= rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String rg = rs.getString("rg");
                Long cpf = rs.getLong("cpf");
                String endereco = rs.getString("endereco");
                
                // adicionando o objeto à lista
                clientes.add(new Cliente(id,nome,sobrenome,rg,cpf,endereco));
            }
            
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }


    public void atualizar(Cliente cliente) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setString(1, (String)cliente.getNome());
            stmtAtualiza.setString(2, (String)cliente.getSobrenome());
            stmtAtualiza.setString(3, (String)cliente.getRg());
            stmtAtualiza.setLong(4, (Long)cliente.getCpf());
            stmtAtualiza.setString(5, (String)cliente.getEndereco());
            stmtAtualiza.setInt(6, cliente.getId());
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }

    }
    
    public void exluirLista(List<Cliente> clientes) throws SQLException {
        for(Cliente cliente:clientes){
            excluir(cliente);
        }
    }

    public void excluir(Cliente cliente) throws SQLException {
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setLong(1, cliente.getId());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }

    }    
}
