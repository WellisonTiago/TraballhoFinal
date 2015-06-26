/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Locutor;

import br.edu.ifnmg.Radio.Negocio.LocutorBO;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WellisonTiago
 */
public class TelaLocutor extends javax.swing.JFrame {

    private Locutor locutor = new Locutor();

    /**
     * Creates new form TelaLocutor
     */
    public TelaLocutor(Locutor locutor, String tipoTela) {
        initComponents();
        this.locutor = locutor;
        if (tipoTela.equals("cadastro")) {
            this.btAlterar.setVisible(false);
            this.lbtAlterar.setVisible(false);
            this.tbAdicionar.setVisible(true);
            this.lbCadastrarLouctor.setVisible(true);
        } else {
            this.txtNome.setText(locutor.getNome());
            this.tbAdicionar.setVisible(false);
            this.lbCadastrarLouctor.setVisible(false);
            this.btAlterar.setVisible(true);
            this.lbtAlterar.setVisible(true);
        }
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
        lbLocutor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        tbAdicionar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        lbCadastrarLouctor = new javax.swing.JLabel();
        lbtAlterar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Locutor");

        lbLocutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLocutor.setText("Nome Locutor:");

        tbAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/save31.png"))); // NOI18N
        tbAdicionar.setText("Adiconar Locutor");
        tbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAdicionarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        lbCadastrarLouctor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbCadastrarLouctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCadastrarLouctor.setText("Cadastrar Louctor");

        lbtAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbtAlterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtAlterar.setText("Alterar Locutor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(213, 213, 213))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbLocutor)
                .addGap(29, 29, 29)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbCadastrarLouctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbCadastrarLouctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbtAlterar)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocutor))
                .addGap(69, 69, 69)
                .addComponent(tbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void lerDadosTela() throws ParseException {
        locutor = new Locutor();

        locutor.setNome(txtNome.getText().trim());
       
    }

    private void tbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAdicionarActionPerformed
        // TODO add your handling code here:
        LocutorBO locutorBO = new LocutorBO();
             
        try {
            lerDadosTela();
            locutorBO.criar(this.locutor);
            System.out.println("Locutor cadastrado com sucesso!");
            String mensagem = "Locutor cadastrado com sucesso!";
            String titulo = "Cadastro de Locutor";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
           // this.limparCamposTela();
        } catch (SQLException e) {
            //System.err.println(e.getMessage());

        } catch (ParseException ex) {
            Logger.getLogger(TelaLocutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
        String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
        this.exibirMensagemErro(mensagem);
        }
    }//GEN-LAST:event_tbAdicionarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:

        try {

            LocutorBO locutorBO = new LocutorBO();

            this.locutor.setNome(txtNome.getText());
            locutorBO.alterar(this.locutor);

            this.exibirMensagemSucesso("Locutor Alterado");
            this.limparCamposTela();

        } catch (SQLException ex) {
            Logger.getLogger(TelaLocutor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }
        ListarLocutores c = new ListarLocutores();
        c.setVisible(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Locutor", JOptionPane.INFORMATION_MESSAGE);

    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao cadastra Locutor", JOptionPane.ERROR_MESSAGE);
    }

    private void limparCamposTela() {

        this.txtNome.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCadastrarLouctor;
    private javax.swing.JLabel lbLocutor;
    private javax.swing.JLabel lbtAlterar;
    private javax.swing.JButton tbAdicionar;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
