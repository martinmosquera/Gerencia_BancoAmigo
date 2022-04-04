/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
//import org.ufpr.contato.controller.ContatoController;
import Model.cliente.Cliente;
/**
 *
 * 
 */
public class ClienteTabelaView extends javax.swing.JPanel {
    /**
     * Creates new form TabelaClienteView
     */
    private ClienteTableModel modeloTabelaCliente = new ClienteTableModel();
    private JanelaClienteView janela;
    private int linhaClicadaParaAtualizacao = -1;
    
    
    
    public ClienteTabelaView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        tabelaCliente.setModel(modeloTabelaCliente);
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        //Pega a linha clicada
        linhaClicadaParaAtualizacao = this.tabelaCliente.rowAtPoint(evt.getPoint());
        //Pega o contato da linha clicada
        Cliente cliente = modeloTabelaCliente.getCliente(linhaClicadaParaAtualizacao);
        //Seta os dados no formulário
      //  janela.getFormularioContatoView().setCliente(cliente);
      // fazer o formularioClienteView
    }//GEN-LAST:event_tabelaClienteMouseClicked


    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables
}
