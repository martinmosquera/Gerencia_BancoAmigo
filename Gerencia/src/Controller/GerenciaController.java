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
import Model.conta.Moeda;
import Model.conta.contaDao.ContaDao;
import View.BancoView;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class GerenciaController {
    private final BancoView view;
    private final ClienteDao clienteDao;
    private final ContaDao contaDao;

    public GerenciaController(BancoView view, ClienteDao clienteDao,ContaDao contaDao) {
        this.view = view;
        this.clienteDao = clienteDao;
        this.contaDao = contaDao;
        initController();
    }
    
    private void initController(){
        // carrega as views, seta os listeners
        this.view.setController(this);
        // pega a lista dos cliente, carrega na tabela e limpa o form caso tiver dados
        orderClientesBy(this.view.getSelected());
        //pega a lista das contas
        List<Conta> lista = contaDao.getListaContas();
        //carrega as contas na view e seta a lista na view
        this.view.setListaContas(lista);
        // mostra a janela para o usuario
        this.view.initView();
    }
    
    public void atualizarCliente() {        
        try{ 
            Cliente cliente = this.view.getClienteParaAtualizar();
            this.clienteDao.atualizar(cliente);
            orderClientesBy(this.view.getSelected());
        }
        catch (Exception ex){
          this.view.showInfo("Erro ao atualizar clientes.\n"+ex.getMessage());
            
        }
         
    }
    
    public void incluirCliente(){
        try{
            Cliente cliente = this.view.getClienteParaIncluir();
            if(cliente.getNome().equalsIgnoreCase("") || cliente.getEndereco().equalsIgnoreCase("") || cliente.getSobrenome().equalsIgnoreCase("") || cliente.getRg().equalsIgnoreCase("") || cliente.getCpf() == 0)
                throw new RuntimeException("Preencha todas as informações");
            this.clienteDao.inserir(cliente);
            orderClientesBy(this.view.getSelected());
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
                orderClientesBy(this.view.getSelected());
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
                        cc = this.contaDao.vincular(cliente,tipo,cc);
                        this.view.setContaNum(cc.getNum());
                        this.view.showInfo("Conta # "+cc.getNum()+"\n Vinculada com Cliente "+cc.getCliente().getNome());
                        List<Conta> lista = contaDao.getListaContas();
                        this.view.setListaContas(lista);
                    }
                }catch(Exception e){
                    this.view.showInfo("Não é possivel Vincular a Conta \n"+e.getMessage());
            
                }
                break;
                
            case "conta investimento":
                ContaInvestimento ci = null;
                try{
                    ci = this.view.getContaInvestimento();
                    if(ci != null){
                        ci = this.contaDao.vincular(cliente,tipo,ci);
                        this.view.showInfo("Conta # "+ci.getNum()+"\n Vinculada com Cliente "+ci.getCliente().getNome());
                        List<Conta> lista = contaDao.getListaContas();
                        this.view.setListaContas(lista);
                    }  
                }catch(Exception e){
                    this.view.showInfo("Não é possivel Vincular a Conta \n"+e.getMessage());
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
    public void resetTipoContaSelector(){
        this.view.setTipoConta("");
    }
    
    public void setClientebyCpf(){
        // primeiro pega no formulario
        boolean comConta = false;
        try{
            long cpf = this.view.getClientebyCpf();
            List<Conta> lista = this.view.getListaContas();
            for(Conta c : lista){
                if(c.getCliente().getCpf() == cpf){
                    this.view.setContaManipula(c);
                    comConta = true;
                    showSaldo();
                }
            }
            if(!comConta) throw new RuntimeException("Não tem contas com esse Cpf");
        }catch(Exception e){
            this.view.showInfo("Erro na pesquisa!\n"+e.getMessage());
        }
    }
    
    public void showSaldo(){
     this.view.showSaldo();
    }
    
    public void sacar(){ 
        ContaCorrente cc;
        ContaInvestimento ci;
        try{
            Moeda valorSaque = this.view.getValorSaque();
            Conta conta = this.view.getContaAtual();
            if (conta == null) throw new RuntimeException("Nenhuma conta selecionada!");
            if(conta.getTipo().equalsIgnoreCase("Conta Corrente")){
                cc = (ContaCorrente)conta;
                cc.saca(valorSaque);
                contaDao.setSaldo(conta);
                this.view.showInfo("Saque aplicado com sucesso!");
                this.view.showSaldo();
            }else{
                ci = (ContaInvestimento)conta;
                ci.saca(valorSaque);
                contaDao.setSaldo(conta);
                this.view.showInfo("Saque aplicado com sucesso!");
                this.view.showSaldo();
            }
                    
        }catch(Exception e){
            this.view.showInfo("Nao foi possivel Realizar o Saque \n"+e.getMessage());
        }
    }
    
    public void depositar(){
        ContaCorrente cc;
        ContaInvestimento ci;
        try{
            Moeda valorDeposito = this.view.getValorDeposito();
            Conta conta = this.view.getContaAtual();
            if (conta == null) throw new RuntimeException("Nenhuma conta selecionada!");
            if(conta.getTipo().equalsIgnoreCase("Conta Corrente")){
                cc = (ContaCorrente)conta;
                cc.deposita(valorDeposito);
                contaDao.setSaldo(conta);
                this.view.showInfo("Deposito aplicado com sucesso!");
                this.view.showSaldo();
            }else{
                ci = (ContaInvestimento)conta;
                ci.deposita(valorDeposito);
                contaDao.setSaldo(conta);
                this.view.showInfo("Deposito aplicado com sucesso!");
                this.view.showSaldo();
            }
        }catch(Exception e){
            this.view.showInfo(e.getMessage());
        }
    }
    
    public void remunerar(){
        ContaInvestimento ci;
        ContaCorrente cc;
        try{
            Conta conta = this.view.getContaAtual();
            if (conta == null) throw new RuntimeException("Nenhuma conta selecionada!");
            if(conta.getTipo().equalsIgnoreCase("Conta Investimento")){
                ci = (ContaInvestimento)conta;
                ci.remunera();
                contaDao.setSaldo(conta);
                this.view.showInfo("Remuneração Aplicada com sucesso!");
                this.view.showSaldo();
            }else{
                cc = (ContaCorrente)conta;
                cc.remunera();
                contaDao.setSaldo(cc);
                this.view.showInfo("Remuneração Aplicada com sucesso!");
                this.view.showSaldo();
            }
        }catch(Exception e){
            this.view.showInfo(e.getMessage());
        }
    }
        
    public void orderClientesBy(String order){
         try{
             // pega a lista do banco
            List<Cliente> lista = this.clienteDao.getLista(order);
            // verifica se a linha é vazia
            if(lista.isEmpty()) this.view.showInfo("Ainda nao tem Clientes");
            // utilia interface comparable -> ordena a lista
            Collections.sort(lista);
            //mostra a lista na tabela
            view.mostrarListaClientes(lista);
            // tira o cliente do formulario
            view.setClienteNull();
        }catch(Exception ex){
            this.view.showInfo("Erro ao listar clientes.\n"+ex.getMessage());
        }
    }    
}
