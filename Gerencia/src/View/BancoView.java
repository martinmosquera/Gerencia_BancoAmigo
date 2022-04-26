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
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public class BancoView extends javax.swing.JFrame {
    
    GerenciaController controller;
    Cliente clienteClicado = null;
    List<Conta> lista;
    List<Cliente> clientes;
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
        labelTotalCo = new javax.swing.JLabel();
        labelTotalCli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setName("Banco Amigo"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto Slab Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 156, 125));
        jLabel1.setText("BANCO BOM AMIGO");

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addTab("Clientes", cienteView1);
        jTabbedPane1.addTab("Conta", contaView2);
        jTabbedPane1.addTab("Manipula", janelaManipulaView1);

        labelTotalCo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelTotalCo.setForeground(new java.awt.Color(0, 102, 102));
        labelTotalCo.setText("Contas: ");

        labelTotalCli.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelTotalCli.setForeground(new java.awt.Color(0, 102, 102));
        labelTotalCli.setText("Clientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalCo)
                            .addComponent(labelTotalCli))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTotalCo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotalCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Clientes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        this.clienteClicado = new Cliente();
        cienteView1.setClienteFormularioNull(clienteClicado);
        cienteView1.setLinhaClicadaNull();
        contaView2.setLinhaClicadaNull();
        this.clienteClicado = null;
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    /**
     * @param args the command line arguments
     */
 public void setController(GerenciaController controller) {
        cienteView1.setController(controller);
        contaView2.setController(controller);
        janelaManipulaView1.setController(controller);
        
    }
 
 public void initView() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->  this.setVisible(true));
    }
 
     public void mostrarListaClientes(List<Cliente> lista) {
        cienteView1.setListaClientes(lista);
        contaView2.setListaClientes(lista);
        cienteView1.setClienteNull();
        labelTotalCli.setText("Clientes: "+lista.size());
    } 


public Cliente getClienteParaAtualizar(){
    Cliente cliente = cienteView1.getClienteParaAtualizar();
    return cliente;
}

public void setClienteNull(){
    Cliente cliente = new Cliente();
    cienteView1.setClienteFormularioNull(cliente);
}


public Cliente getClienteParaExcluir(){
    Cliente cliente = cienteView1.getClienteParaExcluir();
    return cliente;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.JanelaClienteView cienteView1;
    private View.JanelaContaView contaView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private View.JanelaManipulaView janelaManipulaView1;
    private javax.swing.JLabel labelTotalCli;
    private javax.swing.JLabel labelTotalCo;
    // End of variables declaration//GEN-END:variables

    public int opcaoDelete(String info) {
        int resultado = JOptionPane.showConfirmDialog(null,info,"Excluir Usuário",JOptionPane.YES_NO_OPTION);
        return resultado;
    }
    
    public void showInfo(String info){
        JOptionPane.showMessageDialog(null,info,"Atenção" ,JOptionPane.ERROR_MESSAGE);
    }
    
public Cliente getClienteParaIncluir(){
    Cliente cliente = cienteView1.getClienteParaIncluir();
    return cliente;
}
public void setClienteClicado(Cliente cliente){
    this.clienteClicado = cliente;
    this.cienteView1.setClienteClicado(cliente);
    boolean comConta = false;
    for(Conta c : lista){
        if(cliente.getCpf() == c.getCliente().getCpf()){
            this.contaView2.setClienteClicado(c);
            comConta = true;
        }
    }
    if(!comConta){
        this.contaView2.setClienteClicado(cliente);
    }
}

    public void setInvestimentoNull(){
        contaView2.setInvestimentoNull();
    }
    
    public void setCorrenteNull(){
        contaView2.setCorrenteNull();
    }
    
    public Cliente getClienteClicado(){
            return this.clienteClicado;
        }
    public String getTipoConta(){
        return contaView2.getTipoConta();
    }
    
    public ContaCorrente getContaCorrente(){
        try{
            return contaView2.getContaCorrente();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void setTipoConta(String tipo){
        this.contaView2.setTipoConta(tipo);
    }

   

    public ContaInvestimento getContaInvestimento() {
        try{
            return contaView2.getContaInvestimento();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void setContaNum(int num){
        this.contaView2.setContaNum(num);
    }
    
    public void setListaContas(List<Conta> contas){
        this.lista = contas;
        labelTotalCo.setText("Contas: "+contas.size());
    }
    
    public long getClientebyCpf(){
        return janelaManipulaView1.getClienteByCpf();
    }
    
    public List<Conta> getListaContas(){
        return this.lista;
    }
    
    public void setContaManipula(Conta c){
        janelaManipulaView1.setContaManipula(c);
    }
    
    public void showSaldo(){
        janelaManipulaView1.showSaldo();
    }
    
    public double getValorSaque(){
        return janelaManipulaView1.getValorSaque();
    }
    public double getValorDeposito(){
        return janelaManipulaView1.getValorDeposito();
    }
    
    public Conta getContaAtual(){
        return janelaManipulaView1.getContaAtual();
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("View/img/icono.png"));
        
   return retValue;
}
    public String getSelected(){
      return cienteView1.getSelected();
    }
}

