/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta.contaDao;

import Model.ConnectionFactory.ConnectionFactory;
import Model.cliente.Cliente;
import Model.conta.ContaCorrente;
import Model.conta.ContaInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dell
 */
public class ContaDao {
    
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private String stmtVincularCC = "INSERT INTO conta (tipo,dep_inicial,limite,cliente_id) VALUES (?,?,?,?)";
    
    public ContaDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    
    
    public ContaCorrente vincularConta(Cliente cliente, String tipo,ContaCorrente cc){
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
        
    public void vincularConta(Cliente cliente, String tipo,ContaInvestimento ci){
    
    }
}
