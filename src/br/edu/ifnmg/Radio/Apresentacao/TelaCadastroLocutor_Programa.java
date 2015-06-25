/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Entidade.Locutor_Programa;
import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Negocio.Locutor_ProgramaBO;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumLocutouOuProgramaException;
import br.edu.ifnmg.Radio.Negocio.LocutorBO;
import br.edu.ifnmg.Radio.Negocio.ProgramaBO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCadastroLocutor_Programa extends javax.swing.JFrame {

    private Locutor_Programa locutor_Programa;
    List<Locutor_Programa> locutor_Programas;

    List<Locutor> listaLocutor = new ArrayList<Locutor>();
    List<Programa> listaPrograma = new ArrayList<Programa>();
    Programa programa = new Programa();
    Locutor locutor = new Locutor();
    int posicaoProgramaSelecionado;
    int locutorSelecionado;

    public TelaCadastroLocutor_Programa() {
        initComponents();
        this. carregarComoBox();
        this. carregarComoBox2();
    }
    
    private void lerDadosTela() throws ParseException {
        locutor_Programa = new Locutor_Programa();
        locutorSelecionado = cmbLocutor.getSelectedIndex();
        posicaoProgramaSelecionado = cbmPrograma.getSelectedIndex();
        
        locutor = listaLocutor.get(locutorSelecionado);
        locutor_Programa.setIdLocutor(locutor.getIdLocutor());
        
     
        programa = listaPrograma.get(posicaoProgramaSelecionado);
        locutor_Programa.setIdPrograma(programa.getIdPrograma());
     
    }
    
     private void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Locutor/Programa", JOptionPane.INFORMATION_MESSAGE);

    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao cadastrar Locutor/Programa", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLocPrograma = new javax.swing.JPanel();
        lbLocPrograma = new javax.swing.JLabel();
        blLocutor = new javax.swing.JLabel();
        lbPrograma = new javax.swing.JLabel();
        cbmPrograma = new javax.swing.JComboBox();
        cmbLocutor = new javax.swing.JComboBox();
        btAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Locutor Programa");

        lbLocPrograma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbLocPrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLocPrograma.setText("Locutor - Programa");

        blLocutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        blLocutor.setText("Locutor");

        lbPrograma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbPrograma.setText("Programa");

        cbmPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbmPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmProgramaActionPerformed(evt);
            }
        });

        cmbLocutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLocutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocutorActionPerformed(evt);
            }
        });

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/save31.png"))); // NOI18N
        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLocProgramaLayout = new javax.swing.GroupLayout(pnLocPrograma);
        pnLocPrograma.setLayout(pnLocProgramaLayout);
        pnLocProgramaLayout.setHorizontalGroup(
            pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocProgramaLayout.createSequentialGroup()
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLocProgramaLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(blLocutor))
                    .addGroup(pnLocProgramaLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cmbLocutor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocProgramaLayout.createSequentialGroup()
                        .addComponent(lbPrograma)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocProgramaLayout.createSequentialGroup()
                        .addComponent(cbmPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(pnLocProgramaLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbLocPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLocProgramaLayout.setVerticalGroup(
            pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLocPrograma)
                .addGap(62, 62, 62)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blLocutor)
                    .addComponent(lbPrograma))
                .addGap(18, 18, 18)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLocutor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnLocPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLocPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void carregarComoBox() {

        LocutorBO locutorBO = new LocutorBO();
        try {
            listaLocutor = locutorBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbLocutor.removeAllItems();
        int linhaselecionada = this.cmbLocutor.getSelectedIndex();
        for (int registro = 0; registro < listaLocutor.size(); registro++) {
            //  System.out.println(listaAnunciante);
            locutor = listaLocutor.get(registro);
            cmbLocutor.addItem(locutor.getNome());

        }
    }
    private void cmbLocutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocutorActionPerformed
        locutorSelecionado = cmbLocutor.getSelectedIndex();
        Locutor locutorSelecionado;
        cmbLocutor.setSelectedItem(locutor.getIdLocutor());
    }//GEN-LAST:event_cmbLocutorActionPerformed
    public void carregarComoBox2() {

        ProgramaBO programaBO = new ProgramaBO();
        try {
            listaPrograma = programaBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbmPrograma.removeAllItems();
        int linhaselecionada = this.cbmPrograma.getSelectedIndex();
        for (int registro = 0; registro < listaPrograma.size(); registro++) {
            //  System.out.println(listaAnunciante);
            programa = listaPrograma.get(registro);
            cbmPrograma.addItem(programa.getNome());

        }
    }
    private void cbmProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmProgramaActionPerformed
         Programa programaSelecionado;
         posicaoProgramaSelecionado = cbmPrograma.getSelectedIndex();
        cbmPrograma.setSelectedItem(programa.getIdPrograma());
    }//GEN-LAST:event_cbmProgramaActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
       try {
            // TODO add your handling code here:
            lerDadosTela();
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastroAnunciante.class.getName()).log(Level.SEVERE, null, ex);
        }

        Locutor_ProgramaBO locutor_ProgramaBO = new Locutor_ProgramaBO();

        try {
            locutor_ProgramaBO.criar(locutor_Programa);
            String mensagem = "Locutor Programa Cadastrado com Sucesso.";
            exibirMensagemSucesso(mensagem);
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroAnunciante.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NenhumLocutouOuProgramaException ex) {
            Logger.getLogger(TelaCadastroLocutor_Programa.class.getName()).log(Level.SEVERE, null, ex);
         String mensagem = "Nenhum Locutor ou Programa Cadastrados .";
        this.exibirMensagemErro(mensagem);
        } catch (Exception e) {
        String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
        this.exibirMensagemErro(mensagem);
       
        
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroLocutor_Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLocutor_Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLocutor_Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLocutor_Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLocutor_Programa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blLocutor;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JComboBox cbmPrograma;
    private javax.swing.JComboBox cmbLocutor;
    private javax.swing.JLabel lbLocPrograma;
    private javax.swing.JLabel lbPrograma;
    private javax.swing.JPanel pnLocPrograma;
    // End of variables declaration//GEN-END:variables
}
