/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.cliente.Cliente;
import Model.cliente.ValidaCpf;
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
            view.setClienteNull();
        }catch(Exception ex){
            this.view.showInfo("Erro ao listar clientes.\n"+ex.getMessage());
        }
    }
    
    public void atualizarCliente() {        
        try{ 
            Cliente cliente = this.view.getClienteParaAtualizar();
            this.clienteDao.atualizar(cliente);
            listarCliente();
        }
        catch (Exception ex){
          this.view.showInfo("Erro ao atualizar clientes.\n"+ex.getMessage());
            
        }
         
    }
    
    public void incluirCliente(){
        try{
            Cliente cliente = this.view.getClienteParaIncluir();
            this.clienteDao.inserir(cliente);
            listarCliente();
        }
        catch (Exception ex){
            this.view.showInfo("Erro ao inserir o Cliente. \n"+ex.getMessage());
        }
    }
    
    public void excluirCliente(){        
        try{
            Cliente cliente = this.view.getClienteParaExcluir();
            int resultado = this.view.opcaoDelete("Tem certeza que deseja excluir o usuário? \n Todas as contas serão apagadas!");
            if (cliente != null){
            if(resultado==JOptionPane.YES_OPTION){
                
                this.clienteDao.excluir(cliente);
                
                listarCliente();
            };}
        }catch (Exception ex) {
            this.view.showInfo("Erro ao excluir cliente.\n"+ex.getMessage());                   
        }
    
    }
    
    
    public void setJanela(JanelaClienteView janela){
        view.setJanela(janela);
    
    }
    
    public JPanel getJanela(){
     return view.getJanela();
    }
    
    public void setCliente(Cliente cliente){
        try{
            this.view.setCliente(cliente);
        }catch(Exception e){
            this.view.showInfo(e.getMessage());
        }
        
    }
    
    public boolean validaCPF(String cpf){
        return ValidaCpf.isCPF(cpf);
    }
    
    public void vincularConta(String tipoConta,Cliente cliente){
        // criar uma conta vinculada com o cliente
        
//        this.clienteDao.vincular(cliente, tipoConta);
        
        this.view.showInfo(tipoConta+"Holaa");
    }
    
    public int NumeroJanela(){
        return this.view.NumeroJanela();
    }
    
    public void setJanelaCliente(JanelaClienteView janela){
        this.view.setJanela(janela);
    }
  
}
