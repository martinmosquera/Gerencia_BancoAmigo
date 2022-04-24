/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.cliente.Cliente;
import Model.cliente.ValidaCpf;
import Model.cliente.clienteDao.ClienteDao;
import Model.conta.Conta;
import Model.conta.ContaCorrente;
import Model.conta.ContaInvestimento;
import Model.conta.contaDao.ContaDao;
import View.BancoView;
import View.JanelaClienteView;
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
        List<Conta> lista = contaDao.getListaContas();
        this.view.setListaContas(lista);
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
                List<Conta> lista = contaDao.getListaContas();
                this.view.setListaContas(lista);
                listarCliente();
            };}
        }catch (Exception ex) {
            this.view.showInfo("Erro ao excluir cliente.\n"+ex.getMessage());                   
        }
    
    }
    
    // pega a informacao do cliente clicado da tabela
    public void setClienteClicado(Cliente cliente){
    // envia o cliente para BancoView
        this.view.setClienteClicado(cliente);
    }
    
    public Cliente getClienteClicado(){
        return this.view.getClienteClicado();
    }
    
    public boolean validaCPF(String cpf){
        return ValidaCpf.isCPF(cpf);
    }
    
    public void VincularConta(){
        Cliente cliente = this.view.getClienteClicado();
        String tipo = this.view.getTipoConta();
        if(cliente == null){
            this.view.showInfo("Escolha um Cliente para vincular");
            return;
        }
        
        switch(tipo.toLowerCase()){
        
            case "conta corrente":
                ContaCorrente cc = null;
                try{
                    cc = this.view.getContaCorrente();
                    if(cc != null){
                        cc = this.contaDao.vincularCC(cliente,tipo,cc);
                        this.view.setContaNum(cc.getNum());
                        this.view.showInfo("Conta # "+cc.getNum()+"\n Vinculada com Cliente "+cc.getCliente().getNome());
                        List<Conta> lista = contaDao.getListaContas();
                        this.view.setListaContas(lista);
                    }
                }catch(Exception e){
                    if(cc == null) cc.setMsg("");
                    this.view.showInfo("Não é possivel Vincular a Conta \n"+cc.getMsg());
            
                }
                break;
                
            case "conta investimento":
                ContaInvestimento ci = null;
                try{
                    ci = this.view.getContaInvestimento();
                    if(ci.getDepositoInicial() == 0.0) throw new RuntimeException("-");
                    ci = this.contaDao.vincularCI(cliente,tipo,ci);
                    this.view.showInfo("Conta # "+ci.getNum()+"\n Vinculada com Cliente "+ci.getCliente().getNome());
                    List<Conta> lista = contaDao.getListaContas();
                    this.view.setListaContas(lista);
                }catch(Exception e){
                    if(ci == null) ci.setMsg("");
                    this.view.showInfo("Não é possivel Vincular a Conta \n"+ci.getMsg());
                }
                break;
               
            default:
                this.view.showInfo("Escolha uma das opções");
                break;
        }
 
        
    }
    
    public void setInvestimentoNull(){
        this.view.setInvestimentoNull();
    }
    public void setCorrenteNull(){
        this.view.setCorrenteNull();
    }
    
    public void showErro(String info){
        this.view.showInfo(info);
    }
    
    public void resetTipoContaSelector(){
        this.view.setTipoConta("");
    }
    
    public void setClientebyCpf(){
        // primeiro pega no formulario
        try{
            long cpf = this.view.getClientebyCpf();
            List<Conta> lista = this.view.getListaContas();
            for(Conta c : lista){
                if(c.getCliente().getCpf() == cpf){
                    this.view.setContaManipula(c);
                }
            }
            
        }catch(Exception e){
            this.view.showInfo(e.getMessage());
        }
        
       
    }
    
    public void showSaldo(){
     this.view.showSaldo();
    }
    
    public void sacar(){ 
        ContaCorrente cc;
        try{
            double valorSaque = this.view.getValorSaque();
            if (valorSaque == 0.0) throw new RuntimeException("Inisira um valor para saque!");
            Conta conta = this.view.getContaAtual();
            if (conta == null) throw new RuntimeException("Nenhuma conta selecionada!");
            if(conta.getTipo().equalsIgnoreCase("Conta Corrente")){
                cc = (ContaCorrente)conta;
                cc.saca(valorSaque);
                contaDao.setSaldo(conta);
                this.view.showInfo("Saque aplicado com sucesso!\n Saldo Atual :"+conta.getSaldo());
                this.view.showSaldo();
            }else
                this.view.showInfo("Não é possivel aplicar o saque na Conta Investimento");    
        }catch(Exception e){
            this.view.showInfo("Nao foi possivel Realizar o Saque \n"+e.getMessage());
        }
    }
}
