/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerenciaController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaCorrente;
import Model.conta.ContaInvestimento;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class JanelaContaView extends JPanel {
    
    private GerenciaController controller;
    private Cliente clienteClicado;
    private String TipoConta = "";

    /**
     * Creates new form Conta
     */
    public JanelaContaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesConta1 = new View.ContaBotoesView();
        tabelaClienteView1 = new View.ClienteTabelaView();
        formularioContaCorrienteView1 = new View.ContaCorrenteFormularioView();
        formularioContaInvestimento1 = new View.ContaInvestimentoFormularioView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tabelaClienteView1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(formularioContaInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonesConta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formularioContaCorrienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabelaClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(botonesConta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formularioContaCorrienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formularioContaInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.ContaBotoesView botonesConta1;
    private View.ContaCorrenteFormularioView formularioContaCorrienteView1;
    private View.ContaInvestimentoFormularioView formularioContaInvestimento1;
    private View.ClienteTabelaView tabelaClienteView1;
    // End of variables declaration//GEN-END:variables

    
    public void setListaClientes(List<Cliente> lista) {
        tabelaClienteView1.setLista(lista);
        
    }

    public void setClienteClicado(Conta c){
        clienteClicado = c.getCliente();
        botonesConta1.setClienteClicado(c);
    }
    
    public void setClienteClicado(Cliente c){
        clienteClicado = c;
        botonesConta1.setClienteClicado(c);
    }
    
    public Cliente getClienteClicado(){
        return clienteClicado;
    }
    
    public void setController(GerenciaController controller){
        this.controller = controller;
        this.botonesConta1.setController(controller);
        this.tabelaClienteView1.setController(controller);
    }
    
    public void setInvestimentoNull(){
        this.TipoConta = "Conta Corrente";
        formularioContaCorrienteView1.setVisible();
        formularioContaInvestimento1.setNull();
    }
    
    public void setCorrenteNull(){
        this.TipoConta = "Conta Investimento";
        formularioContaInvestimento1.setVisible();
        formularioContaCorrienteView1.setNull();
    }
    public String getTipoConta(){
        return TipoConta;
    }
    
    public ContaCorrente getContaCorrente(){
        try{
            return formularioContaCorrienteView1.getContaCorrente();
        }catch(Exception e){    
            throw new RuntimeException(e.getMessage());
        } 
    }
    
    public void setLinhaClicadaNull(){
        tabelaClienteView1.getTabelaCliente().getSelectionModel().removeSelectionInterval(0,10);
        tabelaClienteView1.setLinhaNull();
        Cliente cliente = null;
        Conta c = null;
        this.botonesConta1.setClienteClicado(c);
        this.clienteClicado = null;
    }
    
    public void setTipoConta(String tipo){
        this.TipoConta = tipo;
    }

    public ContaInvestimento getContaInvestimento() {
         try{
            return formularioContaInvestimento1.getContaInvestimento();
        }catch(Exception e){    
            throw new RuntimeException(e.getMessage());
        } 
    }
    
    public void setContaNum(int num){
        botonesConta1.setContaNum(num);
    }
    
}

