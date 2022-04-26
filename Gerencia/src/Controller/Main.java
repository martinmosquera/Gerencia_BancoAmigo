/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectionFactory.ConnectionFactory;
import Model.cliente.clienteDao.ClienteDao;
import Model.conta.contaDao.ContaDao;
import View.BancoView;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //model
        ConnectionFactory conn = new ConnectionFactory();
        ClienteDao clienteDao = new ClienteDao(conn);
        ContaDao contaDao = new ContaDao(conn);
        // view
         BancoView view = new BancoView();
        // controller
        GerenciaController controller = new GerenciaController(view,clienteDao,contaDao);
        
    }
    
}
