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

/**
 *
 * @author dell
 */
public class BancoView extends javax.swing.JFrame {

    /**
     * Creates new form GerenciaView
     */
    public BancoView() {
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        cienteView1 = new View.JanelaClienteView();
        contaView2 = new View.JanelaContaView();
        janelaManipulaView1 = new View.JanelaManipulaView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Banco Bom Amigo");

        jTabbedPane1.addTab("Clientes", cienteView1);
        jTabbedPane1.addTab("Conta", contaView2);
        jTabbedPane1.addTab("Manipula", janelaManipulaView1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Clientes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 public void setController(GerenciaController controller) {
        cienteView1.setController(controller);
        
    }
 
 public void initView() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->  this.setVisible(true));
    }
 
     public void mostrarListaClientes(List<Cliente> lista) {
        cienteView1.setListaClientes(lista);
        contaView2.setListaClientes(lista);
    }
public void setJanela(JanelaClienteView janela) {
    cienteView1.setJanela(janela);


}


public Cliente getClienteParaAtualizar(){
    Cliente cliente = cienteView1.getClienteParaAtualizar();
    return cliente;
}

public Cliente getClienteParaExcluir(){
    Cliente cliente = cienteView1.getClienteParaExcluir();
    return cliente;
}

public JanelaClienteView getJanela(){
     return cienteView1.getJanela();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.JanelaClienteView cienteView1;
    private View.JanelaContaView contaView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private View.JanelaManipulaView janelaManipulaView1;
    // End of variables declaration//GEN-END:variables

    public int opcaoDelete(String info) {
        int resultado = JOptionPane.showConfirmDialog(null,info,"Excluir Usuário",JOptionPane.YES_NO_OPTION);
        return resultado;
    }
}
