/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
//            mudar o nome do usuario e adicionar senha caso precissar
             return DriverManager.getConnection("jdbc:mysql://localhost/lpoo", "root", "");//"rrw@and14"
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
