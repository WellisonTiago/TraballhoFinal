/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Negocio.Exception.SenhaIncorretaException;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
public class CadastroAdmin extends javax.swing.JFrame {

    Admin admin;
    String codigoHashFinal;
    String Texto;

    /**
     * Creates new form CadastroAdmin
     */
    public CadastroAdmin(Admin admin, String tipoTela) {
        initComponents();
        this.admin = admin;
        if (tipoTela.equals("cadastro")) {
            this.btEditar.setVisible(false);
            this.lbEditar.setVisible(false);
            this.lbAdmin.setVisible(true);
            this.btAdcionar.setVisible(true);
        } else {
            this.txtNome.setText(admin.getnome());
            // this.txtSenha.setText(admin.getSenha());
            this.btEditar.setVisible(true);
            this.lbEditar.setVisible(true);
            this.lbAdmin.setVisible(false);
            this.btAdcionar.setVisible(false);
        }

    }

    private void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Adminstrador", JOptionPane.INFORMATION_MESSAGE);

    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao cadastra Adminstrador", JOptionPane.ERROR_MESSAGE);
    }

    private void lerDadosTela() throws ParseException, NoSuchAlgorithmException {
        admin = new Admin();
        Texto = this.txtSenha.getText().trim();
        Codificação codificação = new Codificação();
        admin.setNome(txtNome.getText().trim());
        try {
            admin.setSenha(codificação.Criptografia(Texto));
            System.out.println(codificação.Criptografia(Texto));
        } catch (UnsupportedEncodingException ex) {

            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparCamposTela() {

        this.txtNome.setText("");
        this.txtSenha.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnAdmin = new javax.swing.JPanel();
        lbAdmin = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btAdcionar = new javax.swing.JButton();
        lbConfirmaSenha = new javax.swing.JLabel();
        confirSenha = new javax.swing.JPasswordField();
        lbEditar = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Admin");

        lbAdmin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAdmin.setText("Cadastro Adminstrador");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNome.setText("Nome:");

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSenha.setText("Senha:");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        btAdcionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/save31.png"))); // NOI18N
        btAdcionar.setText("Adcionar");
        btAdcionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdcionarActionPerformed(evt);
            }
        });

        lbConfirmaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbConfirmaSenha.setText("Confirmar Senha:");

        confirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirSenhaActionPerformed(evt);
            }
        });

        lbEditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEditar.setText("Editar Adminatrador");

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnAdminLayout = new javax.swing.GroupLayout(PnAdmin);
        PnAdmin.setLayout(PnAdminLayout);
        PnAdminLayout.setHorizontalGroup(
            PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAdminLayout.createSequentialGroup()
                .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnAdminLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnAdminLayout.createSequentialGroup()
                                .addComponent(lbSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnAdminLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnAdminLayout.createSequentialGroup()
                                .addComponent(lbConfirmaSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btAdcionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PnAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnAdminLayout.setVerticalGroup(
            PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEditar)
                .addGap(21, 21, 21)
                .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(PnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConfirmaSenha)
                    .addComponent(confirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(btAdcionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdcionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdcionarActionPerformed

        AdminBO adminBO = new AdminBO();
        String texto = txtSenha.getText().trim();
        String tex = confirSenha.getText().trim();
        Codificação codificação = new Codificação();
        try {
            codificação.Criptografia(texto);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Codificação cod = new Codificação();
        try {
            cod.Criptografia(tex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tex.equals(texto)) {

            try {
                //lerDadosTela();
                adminBO.criar(admin);
                System.out.println("Adminstrador cadastrado com sucesso!");
                String mensagem = "Adminstrador cadastrado com sucesso!";
                String titulo = "Cadastro de Adminstrador";
                JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
                this.limparCamposTela();
            } catch (SQLException e) {
                //System.err.println(e.getMessage());

            } catch (Exception e) {
                String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
                this.exibirMensagemErro(mensagem);
            }

        } else {
            String mensagem = "Senha  não confere com a confirmação ";
            this.exibirMensagemErro(mensagem);
            System.err.println("Senha não confirmada");

        }
    }//GEN-LAST:event_btAdcionarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void confirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirSenhaActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        AdminBO adminBO = new AdminBO();
        Texto = txtSenha.getText().trim();
        String tex = confirSenha.getText().trim();
        Codificação codificação = new Codificação();
        try {
            codificação.Criptografia(Texto);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Codificação cod = new Codificação();
        try {
            cod.Criptografia(tex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tex.equals(Texto)) {

            try {

                /*this.admin.setNome(txtNome.getText());
                 this.admin.setSenha(texto);*/
                lerDadosTela();
                adminBO.alterar(this.admin);

                this.exibirMensagemSucesso("Adminstrador Alterado");
                this.limparCamposTela();

            } catch (SQLException ex) {
                Logger.getLogger(TelaLocutor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.dispose();
                ListarAdminstradores c = new ListarAdminstradores();
                c.setVisible(true);
            }
            ListarAdminstradores c = new ListarAdminstradores();
            c.setVisible(true);
            this.dispose();
        } else {
            String mensagem = "Senha  incorreta";
            this.exibirMensagemErro(mensagem);
            System.err.println("Senha não confirmada");
            
        }

      // this.dispose();
    }//GEN-LAST:event_btEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnAdmin;
    private javax.swing.JButton btAdcionar;
    private javax.swing.JButton btEditar;
    private javax.swing.JPasswordField confirSenha;
    private javax.swing.JLabel lbAdmin;
    private javax.swing.JLabel lbConfirmaSenha;
    private javax.swing.JLabel lbEditar;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
