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
            
            return DriverManager.getConnection("jdbc:mysql://localhost/lpoo", "root", "");
        } catch (SQLException e) {
//            Algum codifooasd
            throw new RuntimeException(e);
        }
    }
}
