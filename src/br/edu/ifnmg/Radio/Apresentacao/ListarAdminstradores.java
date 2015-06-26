/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ListarAdminstradores extends javax.swing.JFrame {

    List<Admin> admin;
    int linhaselecionada;
    Admin adminSelecionado = new Admin();

    public ListarAdminstradores() {
        initComponents();
        exibirDadosTabela();
    }

    private void exibirDadosTabela() {
        try {
            this.carregarAdmin();
            ModeloDadosAdmin modelo = new ModeloDadosAdmin();
            tbAdmistradores.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarLocutores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnListarAdmin = new javax.swing.JInternalFrame();
        lbAdmin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdmistradores = new javax.swing.JTable();
        btExcuir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnListarAdmin.setVisible(true);

        lbAdmin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAdmin.setText("Adminstradores");

        tbAdmistradores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbAdmistradores);

        btExcuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/icone_lixeira.png"))); // NOI18N
        btExcuir.setText("Excluir");
        btExcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcuirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnListarAdminLayout = new javax.swing.GroupLayout(pnListarAdmin.getContentPane());
        pnListarAdmin.getContentPane().setLayout(pnListarAdminLayout);
        pnListarAdminLayout.setHorizontalGroup(
            pnListarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListarAdminLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btExcuir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditar)
                .addGap(58, 58, 58))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            .addComponent(lbAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnListarAdminLayout.setVerticalGroup(
            pnListarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListarAdminLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbAdmin)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnListarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcuir)
                    .addComponent(btEditar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnListarAdmin)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnListarAdmin)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcuirActionPerformed
        try {
            linhaselecionada = this.tbAdmistradores.getSelectedRow();
            Admin adminSelecionado = this.admin.get(linhaselecionada);
            String mensagem = "Deseja excluir " + adminSelecionado.getnome() + " ?";
            String titulo = "Excluir Adminstrador";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                AdminBO adminBO = new AdminBO();
                try {
                    adminBO.excluir(adminSelecionado);
                    this.exibirDadosTabela();

                } catch (SQLException e) {
                    String mensagemerro = "Houve um erro ao excluir Adminstrador";
                    String tituloerro = "Erro excluir Adminstrador";
                    this.exibirMensagemErro(mensagemerro, tituloerro);
                }
            } else if (resultado == JOptionPane.NO_OPTION) {

            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum Adminstrador selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } finally {
            this.exibirDadosTabela();
        }
    }//GEN-LAST:event_btExcuirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {
            AdminBO adminBO = new AdminBO();
            int linhaselecionada = this.tbAdmistradores.getSelectedRow();
            adminSelecionado = this.admin.get(linhaselecionada);
            CadastroAdmin cadastroAdmin = new CadastroAdmin(adminSelecionado, "editar");
            cadastroAdmin.setVisible(true);
            this.exibirDadosTabela();

            adminBO.alterar(adminSelecionado);
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum Adminstrador selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             this.dispose();
        }
      this.dispose();
    }//GEN-LAST:event_btEditarActionPerformed
    private void carregarAdmin() throws SQLException {
        AdminBO adminBO = new AdminBO();
        admin = adminBO.buscarTodos();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Adminstradores";
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
            java.util.logging.Logger.getLogger(ListarAdminstradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAdminstradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAdminstradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAdminstradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAdminstradores().setVisible(true);
            }
        });
    }

    class ModeloDadosAdmin extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return admin.size();
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
            Admin admins = admin.get(linha);
            if (coluna == 0) {
                return admins.getIdAdim();
            } else {
                return admins.getnome();

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcuir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAdmin;
    private javax.swing.JInternalFrame pnListarAdmin;
    private javax.swing.JTable tbAdmistradores;
    // End of variables declaration//GEN-END:variables
}
