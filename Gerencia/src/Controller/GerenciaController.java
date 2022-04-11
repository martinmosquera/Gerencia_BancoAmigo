/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.cliente.Cliente;
import Model.cliente.clienteDao.ClienteDao;
import Model.conta.contaDao.ContaDao;
import View.BancoView;
import View.JanelaClienteView;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class GerenciaController {
    private BancoView view;
    private ClienteDao clienteDao;
    private ContaDao contaDao;

    public GerenciaController(BancoView view, ClienteDao clienteDao,ContaDao contaDao) {
        this.view = view;
        this.clienteDao = clienteDao;
        this.contaDao = contaDao;
        initController();
    }
    
    private void initController(){
        this.view.setController(this);
        listarCliente();
        this.view.initView();
    }

    public void listarCliente() {
        try{
            List<Cliente> lista = this.clienteDao.getLista();
            view.mostrarListaClientes(lista);
        }catch(Exception ex){
            ex.printStackTrace();
          System.out.println("Erro ao listar clientes.");
        }
    }
    
    public void setJanela(JanelaClienteView janela){
        view.setJanela(janela);
    
    }
    
    public JanelaClienteView getJanela(){
     return view.getJanela();
    }
}
