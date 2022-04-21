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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
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
           // view.setClienteNull();
        }catch(Exception ex){
            ex.printStackTrace();
          System.out.println("Erro ao listar clientes.");
        }
    }
    
    public void atualizarCliente() {
        Cliente cliente = this.view.getClienteParaAtualizar();
        
        try{ 
            this.clienteDao.atualizar(cliente);
            listarCliente();
        }
        catch (Exception ex){
            ex.printStackTrace();
          System.out.println("Erro ao atualizar clientes.");
            
        }
         
    }
    
    public void incluirCliente(){
        Cliente cliente = this.view.getClienteParaIncluir();
        try{
            this.clienteDao.inserir(cliente);
            listarCliente();
        }
        catch (Exception ex){
           ex.printStackTrace();
          System.out.println("Erro ao inserir clientes.");
        }
    }
    
    public void excluirCliente(){
        Cliente cliente = this.view.getClienteParaExcluir();
        int resultado = this.view.opcaoDelete("Tem certeza que deseja excluir o usuário? \n Todas as contas serão apagadas!");
        
        try{
            if (cliente != null){
            if(resultado==JOptionPane.YES_OPTION){
                
                this.clienteDao.excluir(cliente);
                
                listarCliente();
            };}
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao excluir cliente");
                   
        }
    
    }
    
    
    public void setJanela(JanelaClienteView janela){
        view.setJanela(janela);
    
    }
    
    public JanelaClienteView getJanela(){
     return view.getJanela();
    }
}
