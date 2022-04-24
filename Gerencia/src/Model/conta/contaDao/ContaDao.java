/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta.contaDao;

import Model.ConnectionFactory.ConnectionFactory;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaCorrente;
import Model.conta.ContaInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ContaDao {

    public static void vincularCI(ContaInvestimento ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private final String stmtVincularCC = "INSERT INTO conta (tipo,dep_inicial,limite,cliente_id,saldo) VALUES (?,?,?,?,?)";
    private final String stmtVincularCI= "INSERT INTO conta (tipo, montante_min, deposito_min, dep_inicial,cliente_id, saldo) VALUES (?, ?, ?, ?, ?, ?)";
    private final String stmtSelectAll = "SELECT * FROM conta";
    private final String stmtSelectClientebyId = "SELECT * FROM clientes WHERE cliente_id = ?"; 
    private final String stmtBuscarConta = "SELECT * FROM conta WHERE num_conta = (?)";
    private final String stmtBuscarCliente = "SELECT * FROM conta WHERE cliente_id = (?)";
    private final String stmtBuscarCpf = "SELECT * FROM conta INNER JOIN clientes on conta.cliente_id = clientes.cliente_id WHERE clientes.cpf LIKE CONCAT('%',?,'%')";
    private final String stmtAtualizarCC = "UPDATE conta SET saldo = (?), dep_inicial = (?), limite = (?), tipo = (?) WHERE conta_id = (?)";
    private final String stmtAtualizarCI = "UPDATE conta SET saldo = (?), dep_inicial = (?), deposito_min = (?), montante_min = (?), tipo = (?) WHERE conta_id = (?)";
    private final String stmtExcluir= "DELETE FROM conta WHERE conta_id = (?)";
   

    public ContaDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
                    
            
    public ContaCorrente vincularCC(Cliente cliente, String tipo,ContaCorrente cc){
        String msg = "";
        Connection conn = null;
        PreparedStatement stmtVincular = null;
        ResultSet rs = null;
        try{
            conn = connectionFactory.getConnection();
            stmtVincular = conn.prepareStatement(stmtVincularCC,Statement.RETURN_GENERATED_KEYS);
            stmtVincular.setString(1, tipo);
            stmtVincular.setDouble(2, cc.getDepositoInicial());
            stmtVincular.setDouble(3, cc.getLimite());
            stmtVincular.setInt(4, cliente.getId());
            stmtVincular.setDouble(5,cc.getDepositoInicial());
            stmtVincular.execute();
            rs = stmtVincular.getGeneratedKeys();
            rs.next();
            int num = rs.getInt(1);
            cc.setNum(num);
            cc.setCliente(cliente);
            return cc;
        }catch(SQLException e){
            msg = e.getMessage();
            cc.setMsg(msg);
        }finally{
            try{
                rs.close();
                stmtVincular.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException("Erro ao fechar a conexão"+e.getMessage());
            }
        }
        return cc;
    }
        
    public ContaInvestimento vincularCI(Cliente cliente, String tipo,ContaInvestimento ci){
        String msg = "";
        Connection conn = null;
        PreparedStatement stmtVincular = null;
        ResultSet rs = null;
        try{
            conn = connectionFactory.getConnection();
            stmtVincular = conn.prepareStatement(stmtVincularCI,Statement.RETURN_GENERATED_KEYS);
            stmtVincular.setString(1, tipo);
            stmtVincular.setDouble(2, ci.getDepositoInicial());
            stmtVincular.setDouble(3, ci.getMontanteMin());
            stmtVincular.setDouble(4, ci.getDepositoMin());
            stmtVincular.setInt(5, cliente.getId());
            stmtVincular.setDouble(6,ci.getDepositoInicial());
            stmtVincular.execute();
            rs = stmtVincular.getGeneratedKeys();
            rs.next();
            int num = rs.getInt(1);
            ci.setNum(num);
            ci.setCliente(cliente);
            return ci;
        }catch(SQLException e){
            msg = e.getMessage();
            ci.setMsg(msg);
        }finally{
            try{
                rs.close();
                stmtVincular.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException("Erro ao fechar a conexão"+e.getMessage());
            }
        }
        return ci;

    }
    
    public List<Conta> getListaContas(){
        
        Connection conn = null;
        PreparedStatement stmtListarContas = null;
        ResultSet rs = null;
        List<Conta> lista = new ArrayList<>();
        String tipo;
        ContaCorrente cc = null;
        ContaInvestimento ci = null;
        int num;
        Cliente cliente = null;
        try{
            conn = connectionFactory.getConnection();
            stmtListarContas = conn.prepareStatement(stmtSelectAll);
            
            rs = stmtListarContas.executeQuery();
            
            while(rs.next()){
                tipo = rs.getString("tipo");
                if(tipo.equalsIgnoreCase("Conta Corrente")){
                    cc = new ContaCorrente();
                    cc.setNum(rs.getInt("num_conta"));
                    cc.setDepositoInicial(rs.getDouble("dep_inicial"));
                    cc.setLimite(rs.getDouble("limite"));
                    cc.setSaldo(rs.getDouble("saldo"));
                    num = rs.getInt("cliente_id");
                    cliente = this.getClientedaConta(num);
                    cc.setCliente(cliente);
                    lista.add(cc);
                }else{
                    ci = new ContaInvestimento();
                    cc.setNum(rs.getInt("num_conta"));
                    cc.setDepositoInicial(rs.getDouble("dep_inicial"));
                    cc.setSaldo(rs.getDouble("saldo"));
                    num = rs.getInt("cliente_id");
                    cliente = this.getClientedaConta(num);
                    cc.setCliente(cliente);
                    lista.add(cc);
                }
             
            }
            return lista;
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                rs.close();
                stmtListarContas.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        
        }
        
    }
    
    public Cliente getClientedaConta(int num){
        
        Connection conn = null;
        PreparedStatement stmtSelectCliente = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try{
            conn = connectionFactory.getConnection();
            stmtSelectCliente = conn.prepareStatement(stmtSelectClientebyId);
            stmtSelectCliente.setInt(1,num);
            rs = stmtSelectCliente.executeQuery();
            rs.next();
            cliente = new Cliente();
            cliente.setName(rs.getString("nome"));
            cliente.setId(num);
            cliente.setSobrenome(rs.getString("sobrenome"));
            cliente.setRg(rs.getString("rg"));
            cliente.setCpf(rs.getLong("cpf"));
            cliente.setEndereco(rs.getString("endereco"));
            return cliente;
        
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                rs.close();
                stmtSelectCliente.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}