/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Negocio.LocutorBO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WellisonTiago
 */
public class ListarLocutores extends javax.swing.JFrame {

    List<Locutor> locutor;
    Locutor locutorselecionado = new Locutor();
    int linhaselecionada;

    /**
     * Creates new form MonstarLocutor
     */
    public ListarLocutores() {
        initComponents();
        this.exibirDadosTabela();

    }

    private void exibirDadosTabela() {
        try {
            this.carregarListaLocutor();
            ModeloDadosLocutores modelo = new ModeloDadosLocutores();
            tlbLocutor.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarLocutores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carregarListaLocutor() throws SQLException {
        LocutorBO locutorBO = new LocutorBO();
        locutor = locutorBO.buscarTodos();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Locutores";
        mensagem = "Erro desconhecido. Entre em contato com administrador";
        JOptionPane.showMessageDialog(this, titulo, mensagem, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMontrarLocutor = new javax.swing.JInternalFrame();
        lbLocutores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbLocutor = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btExcuir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnMontrarLocutor.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        pnMontrarLocutor.setVisible(true);

        lbLocutores.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        lbLocutores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLocutores.setText("Locutores");

        tlbLocutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Locutor:", "Nome:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tlbLocutor);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/icone_lixeira.png"))); // NOI18N
        btExcuir.setText("Excluir");
        btExcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcuirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMontrarLocutorLayout = new javax.swing.GroupLayout(pnMontrarLocutor.getContentPane());
        pnMontrarLocutor.getContentPane().setLayout(pnMontrarLocutorLayout);
        pnMontrarLocutorLayout.setHorizontalGroup(
            pnMontrarLocutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMontrarLocutorLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcuir)
                .addGap(124, 124, 124))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addComponent(lbLocutores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMontrarLocutorLayout.setVerticalGroup(
            pnMontrarLocutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMontrarLocutorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLocutores)
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnMontrarLocutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcuir))
                .addGap(126, 126, 126))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMontrarLocutor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMontrarLocutor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:

        try {
            LocutorBO locutorBO = new LocutorBO();
            int linhaselecionada = this.tlbLocutor.getSelectedRow();
            locutorselecionado = this.locutor.get(linhaselecionada);
            TelaLocutor telaLocutor = new TelaLocutor(locutorselecionado,"editar");
            telaLocutor.setVisible(true);
            this.exibirDadosTabela();

            locutorBO.alterar(locutorselecionado);
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum funcionario selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } catch (SQLException ex) {
            Logger.getLogger(ListarLocutores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.exibirDadosTabela();
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcuirActionPerformed
        // TODO add your handling code here:
        try {
            linhaselecionada = this.tlbLocutor.getSelectedRow();
            Locutor locutorselecionado = this.locutor.get(linhaselecionada);
            String mensagem = "Deseja excluir " + locutorselecionado.getNome() + " ?";
            String titulo = "Excluir Locutor";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                LocutorBO locutorBO = new LocutorBO();
                try {
                    locutorBO.excluir(locutorselecionado);
                    this.exibirDadosTabela();

                } catch (SQLException e) {
                    String mensagemerro = "Houve um erro ao excluir Locutor";
                    String tituloerro = "Erro excluir locutor";
                    this.exibirMensagemErro(mensagemerro, tituloerro);
                }
            } else if (resultado == JOptionPane.NO_OPTION) {

            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum locutor selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } finally {
            this.exibirDadosTabela();
        }
    }//GEN-LAST:event_btExcuirActionPerformed

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
            java.util.logging.Logger.getLogger(ListarLocutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarLocutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarLocutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarLocutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarLocutores().setVisible(true);
            }
        });
    }

    class ModeloDadosLocutores extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return locutor.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "ID";

            } else {
                return "Nome";
            }
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override

        public Object getValueAt(int linha, int coluna) {
            Locutor locutores = locutor.get(linha);
            if (coluna == 0) {
                return locutores.getIdLocutor();
            } else {
                return locutores.getNome();

            }
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcuir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLocutores;
    private javax.swing.JInternalFrame pnMontrarLocutor;
    private javax.swing.JTable tlbLocutor;
    // End of variables declaration//GEN-END:variables
}
