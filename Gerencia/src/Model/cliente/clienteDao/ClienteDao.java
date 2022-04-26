/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.cliente.clienteDao;

import Model.ConnectionFactory.ConnectionFactory;
import Model.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class ClienteDao {
    
    private ConnectionFactory connectionFactory;
    
    private final String insert = "insert into clientes (nome,sobrenome,rg,cpf,endereco) values (?,?,?,?,?)";
    private final String select = "select * from clientes";
    private final String update = "update clientes set nome=?, sobrenome=?, rg=?, cpf=?,endereco=? WHERE cliente_id=?";
    private final String delete = "delete from clientes WHERE cpf=?";

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
            throw new RuntimeException("Falha na conexão com o Banco de Dados ao Inserir " + e.getMessage());
        } 
    }

    public List<Cliente> getLista(String order){
        ResultSet rs = null;
        PreparedStatement stmtLista = null;
        try {
            Connection connection=connectionFactory.getConnection();
            stmtLista = connection.prepareStatement(select);
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
               
                clientes.add(new Cliente(id,nome,sobrenome,rg,cpf,endereco,order));
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException("Falha na conexão com o Banco de Dados ao Listar " +e.getMessage());
        } finally{
            try{rs.close();}catch(SQLException e){throw new RuntimeException(e.getMessage());};
            try{stmtLista.close();}catch(SQLException e){throw new RuntimeException(e.getMessage());};
        }

    }


    public void atualizar(Cliente cliente){
        PreparedStatement stmtAtualiza = null;
        try {
            Connection connection=connectionFactory.getConnection();
            stmtAtualiza = connection.prepareStatement(update);
            stmtAtualiza.setString(1, (String)cliente.getNome());
            stmtAtualiza.setString(2, (String)cliente.getSobrenome());
            stmtAtualiza.setString(3, (String)cliente.getRg());
            stmtAtualiza.setLong(4, (Long)cliente.getCpf());
            stmtAtualiza.setString(5, (String)cliente.getEndereco());
            stmtAtualiza.setInt(6, cliente.getId());
            stmtAtualiza.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Falha na conexão com o Banco de Dados ao Atualizar " +e.getMessage());
        } finally{
            try{stmtAtualiza.close();}catch(SQLException e){throw new RuntimeException(e.getMessage());};
        }

    }
    
    public void exluirLista(List<Cliente> clientes) throws SQLException {
        for(Cliente cliente:clientes){
            excluir(cliente);
        }
    }

    public void excluir(Cliente cliente){
        PreparedStatement stmtExcluir = null;
        try {
            Connection connection=connectionFactory.getConnection();
            stmtExcluir = connection.prepareStatement(delete);
            stmtExcluir.setLong(1, cliente.getCpf());
            stmtExcluir.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Falha na conexão com o Banco de Dados ao Excluir " +e.getMessage());
        } finally{
            try{stmtExcluir.close();}catch(SQLException e){throw new RuntimeException(e.getMessage());};
        }

    }
}
