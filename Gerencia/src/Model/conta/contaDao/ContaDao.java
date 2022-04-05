/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta.contaDao;

import Model.ConnectionFactory.ConnectionFactory;

/**
 *
 * @author dell
 */
public class ContaDao {
    
    private ConnectionFactory connectionFactory;
    
    public ContaDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    
}
