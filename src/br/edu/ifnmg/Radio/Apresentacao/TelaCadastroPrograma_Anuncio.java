/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Entidade.Programa_Anuncio;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import br.edu.ifnmg.Radio.Negocio.Programa_AnuncioBO;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumProgramaOuAnuncianteException;
import br.edu.ifnmg.Radio.Negocio.AnuncioBO;
import br.edu.ifnmg.Radio.Negocio.ProgramaBO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCadastroPrograma_Anuncio extends javax.swing.JFrame {

    private Programa_Anuncio programa_Anuncio;
    List<Programa_Anuncio> Programa_Anuncios;

    List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();
    List<Programa> listaPrograma = new ArrayList<Programa>();
    Programa programa = new Programa();
    Anuncio anuncio = new Anuncio();
    int posicaoProgramaSelecionado;
    int anuncioSelecionado;

    public TelaCadastroPrograma_Anuncio() {
        initComponents();
        this. carregarComoBox();
        this. carregarComoBox2();
    }
    
    private void lerDadosTela() throws ParseException {
        programa_Anuncio = new Programa_Anuncio();
        anuncioSelecionado = cmbAnuncio.getSelectedIndex();
        posicaoProgramaSelecionado = cbmPrograma.getSelectedIndex();
        
        anuncio = listaAnuncio.get(anuncioSelecionado);
        programa_Anuncio.setIdAnuncio(anuncio.getIdAnuncio());
        
     
        programa = listaPrograma.get(posicaoProgramaSelecionado);
        programa_Anuncio.setIdPrograma(programa.getIdPrograma());
     
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
        lbPro_Anuncio = new javax.swing.JLabel();
        lbAnuncio = new javax.swing.JLabel();
        lbPrograma = new javax.swing.JLabel();
        cbmPrograma = new javax.swing.JComboBox();
        cmbAnuncio = new javax.swing.JComboBox();
        btAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Locutor Programa");

        lbPro_Anuncio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPro_Anuncio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPro_Anuncio.setText("Programa -Anuncios");

        lbAnuncio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbAnuncio.setText("Anuncio");

        lbPrograma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbPrograma.setText("Programa");

        cbmPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbmPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmProgramaActionPerformed(evt);
            }
        });

        cmbAnuncio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAnuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnuncioActionPerformed(evt);
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
                .addGap(83, 83, 83)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAnuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnLocProgramaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbAnuncio)))
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
            .addComponent(lbPro_Anuncio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLocProgramaLayout.setVerticalGroup(
            pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPro_Anuncio)
                .addGap(62, 62, 62)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAnuncio)
                    .addComponent(lbPrograma))
                .addGap(18, 18, 18)
                .addGroup(pnLocProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        AnuncioBO anuncioBO = new AnuncioBO();
        try {
            listaAnuncio = anuncioBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbAnuncio.removeAllItems();
        int linhaselecionada = this.cmbAnuncio.getSelectedIndex();
        for (int registro = 0; registro < listaAnuncio.size(); registro++) {
            //  System.out.println(listaAnunciante);
            anuncio = listaAnuncio.get(registro);
            cmbAnuncio.addItem(anuncio.getDescricao());

        }
    }
    private void cmbAnuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnuncioActionPerformed
        anuncioSelecionado = cmbAnuncio.getSelectedIndex();
        
        cmbAnuncio.setSelectedItem(anuncio.getIdAnuncio());
    }//GEN-LAST:event_cmbAnuncioActionPerformed
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

        Programa_AnuncioBO programa_AnuncioBO = new Programa_AnuncioBO();

        try {
            programa_AnuncioBO.criar(programa_Anuncio);
            String mensagem = " Programa Anuncio Cadastrado com Sucesso.";
            exibirMensagemSucesso(mensagem);
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NenhumProgramaOuAnuncianteException ex) {
            Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(Level.SEVERE, null, ex);
         String mensagem = "Nenhum   Programa ou Anunciante Cadastrados .";
        this.exibirMensagemErro(mensagem);
       } /*catch (Exception e) {
        String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
        this.exibirMensagemErro(mensagem);
        
        
        }*/
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
            java.util.logging.Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPrograma_Anuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPrograma_Anuncio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JComboBox cbmPrograma;
    private javax.swing.JComboBox cmbAnuncio;
    private javax.swing.JLabel lbAnuncio;
    private javax.swing.JLabel lbPro_Anuncio;
    private javax.swing.JLabel lbPrograma;
    private javax.swing.JPanel pnLocPrograma;
    // End of variables declaration//GEN-END:variables
}
