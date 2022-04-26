/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerenciaController;
import Model.conta.Conta;
import Model.conta.Moeda;
import java.awt.Color;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class ManipulaBotoesView extends javax.swing.JPanel {
    
    GerenciaController controller;
    /**
     * Creates new form ManipulaBotoesView
     */
    public ManipulaBotoesView() {
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

        jPanel1 = new javax.swing.JPanel();
        BtnRemunera = new javax.swing.JButton();
        labelSaldo = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        labelSaque = new javax.swing.JLabel();
        valorSaque = new javax.swing.JTextField();
        BtnSacar = new javax.swing.JButton();
        labelDeposito = new javax.swing.JLabel();
        valorDeposito = new javax.swing.JTextField();
        BtnDepositar = new javax.swing.JButton();

        BtnRemunera.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnRemunera.setText("Remunera");

        labelSaldo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        labelSaldo.setText("Saldo:");

        saldo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        saldo.setText("####");

        labelSaque.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelSaque.setText("Valor do Saque :");

        valorSaque.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        valorSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorSaqueActionPerformed(evt);
            }
        });

        BtnSacar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnSacar.setText("Sacar");

        labelDeposito.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelDeposito.setText("Valor Deposito :");

        valorDeposito.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        BtnDepositar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnDepositar.setText("Depositar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelDeposito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSaque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRemunera)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valorSaque, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                    .addComponent(valorDeposito))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnDepositar)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldo)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaldo)
                    .addComponent(saldo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaque)
                    .addComponent(valorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSacar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDeposito)
                    .addComponent(valorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDepositar))
                .addGap(18, 18, 18)
                .addComponent(BtnRemunera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void valorSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorSaqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorSaqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDepositar;
    private javax.swing.JButton BtnRemunera;
    private javax.swing.JButton BtnSacar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDeposito;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelSaque;
    private javax.swing.JLabel saldo;
    private javax.swing.JTextField valorDeposito;
    private javax.swing.JTextField valorSaque;
    // End of variables declaration//GEN-END:variables

    public void setController(GerenciaController controller){
        this.controller = controller;
        BtnSacar.addActionListener(e -> controller.sacar());
        BtnDepositar.addActionListener(e -> controller.depositar());
        BtnRemunera.addActionListener(e-> controller.remunerar());
    }
    
    public void setConta(Conta c){
        if(c.getSaldo().isNegative()) saldo.setForeground(Color.red);
        else
            saldo.setForeground(Color.GREEN.darker());
        saldo.setText(c.getSaldo().toString());
    }
    
    public Moeda getValorSaque(){
        try{
            if(valorSaque.getText().equalsIgnoreCase(""))throw new RuntimeException("Preencha o campo do Valor do Saque");
            Moeda saque = new Moeda(valorSaque.getText());
            return saque;
        }catch(RuntimeException e){
            throw new RuntimeException ("Valor invalido!\n"+e.getMessage());
        }
    }
    
    public Moeda getValorDeposito(){
        try{
            if(valorDeposito.getText().equalsIgnoreCase(""))throw new RuntimeException("Preencha o campo do Valor do Deposito");
            Moeda deposito = new Moeda(valorDeposito.getText());
            return deposito;
        }catch(RuntimeException e){
            throw new RuntimeException ("Valor invalido!\n"+e.getMessage());
        }
    }
    
}
