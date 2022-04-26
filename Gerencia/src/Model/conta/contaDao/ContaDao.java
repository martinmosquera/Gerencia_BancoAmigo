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
import Model.conta.Moeda;
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
public class ContaDao {
    
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private final String stmtVincularCC = "INSERT INTO conta (tipo,dep_inicial,limite,cliente_id,saldo) VALUES (?,?,?,?,?)";
    private final String stmtVincularCI= "INSERT INTO conta (tipo, montante_min, deposito_min, dep_inicial,cliente_id, saldo) VALUES (?, ?, ?, ?, ?, ?)";
    private final String stmtSelectAll = "SELECT * FROM conta";
    private final String stmtSelectClientebyId = "SELECT * FROM clientes WHERE cliente_id = ?"; 
    private final String stmtSacaValorConta = "UPDATE conta SET saldo = ? WHERE num_conta = ?";

    public ContaDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
                    
            
    public ContaCorrente vincular(Cliente cliente, String tipo,ContaCorrente cc){
        String msg = "";
        Connection conn = null;
        PreparedStatement stmtVincular = null;
        ResultSet rs = null;
        try{
            conn = connectionFactory.getConnection();
            stmtVincular = conn.prepareStatement(stmtVincularCC,Statement.RETURN_GENERATED_KEYS);
            stmtVincular.setString(1, tipo);
            stmtVincular.setDouble(2, cc.getDepositoInicial().getValor().doubleValue());
            stmtVincular.setDouble(3, cc.getLimite().getValor().doubleValue());
            stmtVincular.setInt(4, cliente.getId());
            stmtVincular.setDouble(5,cc.getDepositoInicial().getValor().doubleValue());
            stmtVincular.execute();
            rs = stmtVincular.getGeneratedKeys();
            rs.next();
            int num = rs.getInt(1);
            cc.setNum(num);
            cc.setCliente(cliente);
            return cc;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                rs.close();
                stmtVincular.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException("Erro ao fechar a conexão"+e.getMessage());
            }
        }
    }
        
    public ContaInvestimento vincular(Cliente cliente, String tipo,ContaInvestimento ci){
        String msg = "";
        Connection conn = null;
        PreparedStatement stmtVincular = null;
        ResultSet rs = null;
        try{
            conn = connectionFactory.getConnection();
            stmtVincular = conn.prepareStatement(stmtVincularCI,Statement.RETURN_GENERATED_KEYS);
            stmtVincular.setString(1, tipo);
            stmtVincular.setDouble(2, ci.getDepositoInicial().getValor().doubleValue());
            stmtVincular.setDouble(3, ci.getMontanteMin().getValor().doubleValue());
            stmtVincular.setDouble(4, ci.getDepositoMin().getValor().doubleValue());
            stmtVincular.setInt(5, cliente.getId());
            stmtVincular.setDouble(6,ci.getSaldo().getValor().doubleValue());
            stmtVincular.execute();
            rs = stmtVincular.getGeneratedKeys();
            rs.next();
            int num = rs.getInt(1);
            ci.setNum(num);
            ci.setCliente(cliente);
            return ci;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                rs.close();
                stmtVincular.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException("Erro ao fechar a conexão"+e.getMessage());
            }
        }
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
                    cc.setTipo(tipo);
                    cc.setDepositoInicial(new Moeda(rs.getDouble("dep_inicial")));
                    cc.setLimite(new Moeda(rs.getDouble("limite")));
                    cc.setSaldo(new Moeda(rs.getDouble("saldo")));
                    num = rs.getInt("cliente_id");
                    cliente = this.getClientedaConta(num);
                    cc.setCliente(cliente);
                    lista.add(cc);
                }else{
                    ci = new ContaInvestimento();
                    ci.setNum(rs.getInt("num_conta"));
                    ci.setTipo(tipo);
                    ci.setDepositoInicial(new Moeda(rs.getDouble("dep_inicial")));
                    ci.setSaldo(new Moeda(rs.getDouble("saldo")));
                    num = rs.getInt("cliente_id");
                    cliente = this.getClientedaConta(num);
                    ci.setCliente(cliente);
                    lista.add(ci);
                }
             
            }
            return lista;
        
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
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
            cliente.setNome(rs.getString("nome"));
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
    
    public void setSaldo(Conta conta){
        Connection conn = null;
        PreparedStatement stmtSacaValor= null;
        try{
            conn = connectionFactory.getConnection();
            stmtSacaValor = conn.prepareStatement(stmtSacaValorConta);
            stmtSacaValor.setDouble(1, conta.getSaldo().getValor().doubleValue());
            stmtSacaValor.setInt(2, conta.getNum());
            stmtSacaValor.execute();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
               
                stmtSacaValor.close();
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}