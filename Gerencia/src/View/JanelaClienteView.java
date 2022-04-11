/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerenciaController;
import Model.cliente.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class JanelaClienteView extends javax.swing.JPanel {

    /**
     * Creates new form CienteView
     */
    public JanelaClienteView() {

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

        botoesClienteView1 = new View.ClienteBotoesView();
        tabelaClienteView1 = new View.ClienteTabelaView();
        formularioCliente1 = new View.ClienteFormularioView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabelaClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botoesClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(formularioCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botoesClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabelaClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.ClienteBotoesView botoesClienteView1;
    private View.ClienteFormularioView formularioCliente1;
    private View.ClienteTabelaView tabelaClienteView1;
    // End of variables declaration//GEN-END:variables
    
    public void setController(GerenciaController controller) {
        botoesClienteView1.setController(controller);
        tabelaClienteView1.setController(controller);
        
    }
  
    public void initView() {
        /* Create and display the form */
        tabelaClienteView1.setJanelaView(this);
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }
    
    public Cliente getClienteFormulario() {
       return this.formularioCliente1.getClienteFormulario();
    }
        
    public void inserirClienteView(Cliente cliente) {
        tabelaClienteView1.inserirClienteTabela(cliente);
    }
    
    public void apresentaErro(String erro) {
    JOptionPane.showMessageDialog(null,erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarListaClientes(List<Cliente> lista) {
        tabelaClienteView1.setListaClientesTabela(lista);
    }
    
    public List<Cliente> getClientesParaExcluir() {
        return this.tabelaClienteView1.getClientesParaExcluirDaTabela();
    }
    
    
    public void excluirClientesView(List<Cliente> lista) {
        tabelaClienteView1.excluirClientesDaTabela(lista); 
    
    }
    
    public Cliente getClienteParaAtualizar() {
        return formularioCliente1.getClienteParaAtualizar();
    
    }
    
    public void atualizarClientes(Cliente cliente){
        tabelaClienteView1.atualizarClienteNaTabela(cliente);   
    
    
    }
    
    
   public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null,info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }



    public ClienteBotoesView getBotoesClienteView() {
        return botoesClienteView1;
    }



    public ClienteFormularioView getFormularioClienteView() {
        return formularioCliente1;
    }



    public ClienteTabelaView getTabelaClienteView() {
    return tabelaClienteView1;
}
    
    public void setListaClientes(List<Cliente> lista) {
        tabelaClienteView1.setLista(lista);
    }
        
    public ClienteFormularioView getClienteFormularioView(){
        return this.formularioCliente1;
    }
    
    
       public void setJanela(JanelaClienteView janela){
        tabelaClienteView1.setJanela(janela);
    }
    
    
    
}

 
