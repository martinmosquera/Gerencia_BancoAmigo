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
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class JanelaClienteView extends javax.swing.JPanel {
    
    Cliente clienteclicado;

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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formularioCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addComponent(tabelaClienteView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoesClienteView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addContainerGap())
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
        
//        >> aqui paso a referencia da janela para a tabela
        formularioCliente1.setController(controller);
        
    }
  
    public void initView() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }
    
    public Cliente getClienteFormulario() {
       return this.formularioCliente1.getClienteFormulario();
    }
        /*
    public void getClienteParaIncluir(Cliente cliente) {
        tabelaClienteView1.inserirClienteTabela(cliente);
    }
*/    
    public void apresentaErro(String erro) {
    JOptionPane.showMessageDialog(null,erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarListaClientes(List<Cliente> lista) {
        tabelaClienteView1.setListaClientesTabela(lista);
    }
    /*
    public List<Cliente> getClientesParaExcluir() {
        return this.tabelaClienteView1.getClientesParaExcluirDaTabela();
    }*/
    
    public Cliente getClienteParaExcluir() {
        //se o formulario estiver vazio retorna um usuario nullo
        
        //se nao retorna cliente dda tabela
        return this.tabelaClienteView1.getClienteParaExcluirDaTabela();
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
   
    public Cliente getClienteParaIncluir() {
       return formularioCliente1.getClienteFormulario();
       
    }
    
    public void setClienteFormularioNull(Cliente cliente){
        
        this.formularioCliente1.setClienteClicado(cliente);
    }
    
    public void setClienteClicado(Cliente cliente){
        if (this.isVisible())
            this.formularioCliente1.setClienteClicado(cliente);
    }
    
    public void setClienteNull(){
        tabelaClienteView1.setLinhaNull();
    }
    
    public void setLinhaClicadaNull(){
        tabelaClienteView1.getTabelaCliente().getSelectionModel().removeSelectionInterval(0,10);
        tabelaClienteView1.setLinhaNull();
    }
    public String getSelected(){
      return botoesClienteView1.getSelected();
    }
    
}

 
