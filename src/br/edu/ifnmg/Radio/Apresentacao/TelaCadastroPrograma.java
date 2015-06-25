/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
import br.edu.ifnmg.Radio.Negocio.ProgramaBO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WellisonTiago
 */
public class TelaCadastroPrograma extends javax.swing.JFrame {

    Programa programa;
    List<Admin> Diretor;
    List<Programa> listaPrograma = new ArrayList<Programa>();
    List<Admin> listaAdmin = new ArrayList<Admin>();
    Admin admin = new Admin();
    int posicaoDiretorSelecionado;

    public TelaCadastroPrograma(Programa programa, String tipoTela) {
        initComponents();
        this.programa = programa;
        if (tipoTela.equals("cadastro")) {
            this.btAlterar.setVisible(false);
            this.lbAlterar.setVisible(false);
            this.btAdcionar.setVisible(true);
            this.lbCadastrarPrograma.setVisible(true);
            this.carregarComoBox();
        } else {
            this.txtNome.setText(programa.getNome());
            this.btAlterar.setVisible(true);
            this.lbAlterar.setVisible(true);
            this.btAdcionar.setVisible(false);
            this.lbCadastrarPrograma.setVisible(true);
            this.carregarComoBox();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCadastrarPrograma = new javax.swing.JPanel();
        lbCadastrarPrograma = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbDiretor = new javax.swing.JLabel();
        cmbDiretor = new javax.swing.JComboBox();
        btAdcionar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        lbAlterar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastraer Programa");

        lbCadastrarPrograma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbCadastrarPrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCadastrarPrograma.setText("Cadastrar Programa");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNome.setText("Nome:");

        lbDiretor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDiretor.setText("Diretor:");

        cmbDiretor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiretorActionPerformed(evt);
            }
        });

        btAdcionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/save31.png"))); // NOI18N
        btAdcionar.setText("Adcionar");
        btAdcionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdcionarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        lbAlterar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbAlterar.setText("Alterar");

        javax.swing.GroupLayout pnCadastrarProgramaLayout = new javax.swing.GroupLayout(pnCadastrarPrograma);
        pnCadastrarPrograma.setLayout(pnCadastrarProgramaLayout);
        pnCadastrarProgramaLayout.setHorizontalGroup(
            pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastrarProgramaLayout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(lbAlterar)
                .addGap(401, 401, 401))
            .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                .addGroup(pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                                .addComponent(lbDiretor)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btAdcionar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastrarProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCadastrarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCadastrarProgramaLayout.setVerticalGroup(
            pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarProgramaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbCadastrarPrograma)
                .addGap(18, 18, 18)
                .addComponent(lbAlterar)
                .addGap(63, 63, 63)
                .addGroup(pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(pnCadastrarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiretor)
                    .addComponent(cmbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btAdcionar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCadastrarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCadastrarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lerDadosTela() throws ParseException {
        programa = new Programa();
        posicaoDiretorSelecionado = cmbDiretor.getSelectedIndex();
        programa.setNome(txtNome.getText().trim());
        admin = listaAdmin.get(posicaoDiretorSelecionado);

        programa.setIdAdim(admin.getIdAdim());
    }

    private void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Programa", JOptionPane.INFORMATION_MESSAGE);

    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao cadastra Programa", JOptionPane.ERROR_MESSAGE);
    }

    public void carregarComoBox() {

        AdminBO adminBO = new AdminBO();
        try {
            listaAdmin = adminBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroPrograma.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbDiretor.removeAllItems();
        int linhaselecionada = this.cmbDiretor.getSelectedIndex();
        for (int registro = 0; registro < listaAdmin.size(); registro++) {
            //  System.out.println(listaAnunciante);
            admin = listaAdmin.get(registro);
            cmbDiretor.addItem(admin.getnome());
            //cbDiretor.setSelectedItem(admin);

            // adminstradorSelecionado = cbDiretor.getSelectedIndex();
        }
    }
    private void cmbDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiretorActionPerformed
        posicaoDiretorSelecionado = cmbDiretor.getSelectedIndex();
        cmbDiretor.setSelectedItem(admin.getIdAdim());
    }//GEN-LAST:event_cmbDiretorActionPerformed

    private void limparCamposTela() {
        this.txtNome.setText("");
    }

    /*  private void verificaCampoVazio() throws FuncionarioNuloException {
     if (txtNome.getText().isEmpty() && txtMatricula.getText().isEmpty() && txtSalario.getText().isEmpty()) {
     throw new FuncionarioNuloException();
     }
     }*/
    private void btAdcionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdcionarActionPerformed

        try {
            lerDadosTela();
        } catch (ParseException ex) {
            Logger.getLogger(TelaLocutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProgramaBO programaBO = new ProgramaBO();

        try {
            programaBO.criar(programa);
            System.out.println("Programa cadastrado com sucesso!");
            String mensagem = "Programa cadastrado com sucesso!";
            String titulo = "Cadastro de Programa";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTela();
        } catch (SQLException e) {
            //System.err.println(e.getMessage());

        } catch (Exception e) {
            String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
            this.exibirMensagemErro(mensagem);
        }
    }//GEN-LAST:event_btAdcionarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {

            ProgramaBO programaBO = new ProgramaBO();

            this.programa.setNome(txtNome.getText());
            this.programa.setIdAdim(posicaoDiretorSelecionado);
            posicaoDiretorSelecionado = cmbDiretor.getSelectedIndex();
            // programa.setNome(txtNome.getText().trim());
            admin = listaAdmin.get(posicaoDiretorSelecionado);
            programaBO.alterar(this.programa);

            this.exibirMensagemSucesso("Programa Alterado");
            this.limparCamposTela();
            // ListarLocutores listarLocutores = new ListarLocutores();

        } catch (SQLException ex) {
            Logger.getLogger(TelaLocutor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }


    }//GEN-LAST:event_btAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // funções para alterar
    public void passaValoresPrograma(Programa programa) {
        this.btAdcionar.setVisible(false);
        this.btAlterar.setVisible(true);
        this.lbAlterar.setVisible(true);
        this.lbCadastrarPrograma.setVisible(false);
        this.txtNome.setText(programa.getNome());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdcionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JComboBox cmbDiretor;
    private javax.swing.JLabel lbAlterar;
    private javax.swing.JLabel lbCadastrarPrograma;
    private javax.swing.JLabel lbDiretor;
    private javax.swing.JLabel lbNome;
    private javax.swing.JPanel pnCadastrarPrograma;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
