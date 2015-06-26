/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Negocio.ProgramaBO;
import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
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
public class ListarProgramas extends javax.swing.JFrame {

    List<Programa> programas;
    List<Admin> diretores;
   Programa programaSelecionado = new Programa ();

    public ListarProgramas() {
        initComponents();
        this.exibirDadosTabela();
    }

    private void exibirDadosTabela() {
        try {
            this.carregarProgrmas();
            ModeloDadosProgramas modelo = new ModeloDadosProgramas();
            tbListarPrograma.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarProgramas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnListarPrograma = new javax.swing.JInternalFrame();
        lbListarPrograma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarPrograma = new javax.swing.JTable();
        btExluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Programas");

        pnListarPrograma.setLayer(5);
        pnListarPrograma.setVisible(true);

        lbListarPrograma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbListarPrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListarPrograma.setText("PROGRAMAS ");

        tbListarPrograma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbListarPrograma);

        btExluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/icone_lixeira.png"))); // NOI18N
        btExluir.setText("Excluir");
        btExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExluirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnListarProgramaLayout = new javax.swing.GroupLayout(pnListarPrograma.getContentPane());
        pnListarPrograma.getContentPane().setLayout(pnListarProgramaLayout);
        pnListarProgramaLayout.setHorizontalGroup(
            pnListarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListarProgramaLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addComponent(lbListarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnListarProgramaLayout.setVerticalGroup(
            pnListarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListarProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbListarPrograma)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(pnListarProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListarPrograma)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnListarPrograma)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExluirActionPerformed
        try {
            int linhaselecionada = this.tbListarPrograma.getSelectedRow();
            Programa programaSelecionado = this.programas.get(linhaselecionada);
            String mensagem = "Deseja excluir " + programaSelecionado.getNome() + " ?";
            String titulo = "Excluir Programa";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                ProgramaBO programaBO = new ProgramaBO();
                try {
                    programaBO.excluir(programaSelecionado);
                    this.exibirDadosTabela();

                } catch (SQLException e) {
                    String mensagemerro = "Houve um erro ao excluir Programa";
                    String tituloerro = "Erro excluir Programa";
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
    }//GEN-LAST:event_btExluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {
            ProgramaBO programaBO = new ProgramaBO();
            int linhaselecionada = this.tbListarPrograma.getSelectedRow();
            programaSelecionado = this.programas.get(linhaselecionada);
            TelaCadastroPrograma telaCadastroPrograma = new TelaCadastroPrograma(programaSelecionado,"editar");
            telaCadastroPrograma.setVisible(true);
            this.exibirDadosTabela();

            programaBO.alterar(programaSelecionado);
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum Programa selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } catch (SQLException ex) {
            Logger.getLogger(ListarLocutores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }
         this.exibirDadosTabela();
    }//GEN-LAST:event_btEditarActionPerformed

    private void carregarProgrmas() throws SQLException {
        ProgramaBO programaBO = new ProgramaBO();
        AdminBO adminBO = new AdminBO();
        programas = programaBO.buscarTodos();
        diretores = adminBO.buscarProgra_Diretor();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Programa";
        mensagem = "Erro desconhecido. Entre em contato com administrador";
        JOptionPane.showMessageDialog(this, titulo, mensagem, JOptionPane.ERROR_MESSAGE);
    }

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
            java.util.logging.Logger.getLogger(ListarProgramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarProgramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarProgramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarProgramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarProgramas().setVisible(true);
            }
        });
    }

    class ModeloDadosProgramas extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return programas.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "ID PROGRAMA";

            } else if (column == 1) {
                return "NOME";

            } else {
                return "DIRETOR";
            }
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override

        public Object getValueAt(int linha, int coluna) {
            Programa programa = programas.get(linha);
            Admin diretor = diretores.get(linha);

            if (coluna == 0) {
                return programa.getIdPrograma();
            } else if (coluna == 1) {
                return programa.getNome();

            } else {
                return diretor.getnome();

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbListarPrograma;
    private javax.swing.JInternalFrame pnListarPrograma;
    private javax.swing.JTable tbListarPrograma;
    // End of variables declaration//GEN-END:variables
}
