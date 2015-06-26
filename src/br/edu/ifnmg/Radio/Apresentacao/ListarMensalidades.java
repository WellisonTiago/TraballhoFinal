/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import br.edu.ifnmg.Radio.Negocio.MensalidadeBO;
import br.edu.ifnmg.Radio.Negocio.AnuncianteBO;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WellisonTiago
 */
public class ListarMensalidades extends javax.swing.JFrame {

    List<Anunciante> anunciantes;
    List<Mensalidade> mensalidades;
    List<Admin> administrador;
    Mensalidade mensalidadeSelecionada = new Mensalidade(); 

    public ListarMensalidades() {
        initComponents();
        exibirDadosTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnListarMensalidade = new javax.swing.JInternalFrame();
        lbListarMensalidades = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMensalidades = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Mensalidades");

        PnListarMensalidade.setVisible(true);

        lbListarMensalidades.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbListarMensalidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListarMensalidades.setText("Mensalidades");

        tblMensalidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMensalidades);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/icone_lixeira.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnListarMensalidadeLayout = new javax.swing.GroupLayout(PnListarMensalidade.getContentPane());
        PnListarMensalidade.getContentPane().setLayout(PnListarMensalidadeLayout);
        PnListarMensalidadeLayout.setHorizontalGroup(
            PnListarMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnListarMensalidadeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addComponent(lbListarMensalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnListarMensalidadeLayout.setVerticalGroup(
            PnListarMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnListarMensalidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbListarMensalidades)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(PnListarMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnListarMensalidade)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnListarMensalidade)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       try {
            int linhaselecionada = this. tblMensalidades.getSelectedRow();
            Mensalidade mensalidadeSelecionada = this.mensalidades.get(linhaselecionada);
            String mensagem = "Deseja excluir a Mensalidade " + mensalidadeSelecionada.getIdMensalidade() + " ?";
            String titulo = "Excluir Mensalidade";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                MensalidadeBO mensalidadeBO = new MensalidadeBO();
                try {
                    mensalidadeBO.excluir(mensalidadeSelecionada );
                    this.exibirDadosTabela();

                } catch (SQLException e) {
                    String mensagemerro = "Houve um erro ao excluir Mensalidade";
                    String tituloerro = "Erro excluir Mensalidade";
                    this.exibirMensagemErro(mensagemerro, tituloerro);
                }
            } else if (resultado == JOptionPane.NO_OPTION) {

            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhuma Mensalidade selecionada";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } finally {
            this.exibirDadosTabela();
        }
             
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
         try {
            MensalidadeBO mensalidadeBO = new MensalidadeBO();
            int linhaselecionada = this.tblMensalidades.getSelectedRow();
            mensalidadeSelecionada = this.mensalidades.get(linhaselecionada);
            TelaCadastroMensalidade telaCadastroMensalidade = new TelaCadastroMensalidade(mensalidadeSelecionada,"editar");
            telaCadastroMensalidade.setVisible(true);
            this.exibirDadosTabela();

            mensalidadeBO.alterar(mensalidadeSelecionada );
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhuma Mensalidade selecionada";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } catch (SQLException ex) {
            Logger.getLogger(ListarMensalidades.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
            
        }
    }//GEN-LAST:event_btEditarActionPerformed
   private void exibirDadosTabela() {
        try {
            this.carregarListaMensalidade();
            ModeloDadosMensalidade modelo = new ModeloDadosMensalidade();
            tblMensalidades.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarMensalidades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carregarListaMensalidade() throws SQLException {
        MensalidadeBO mensalidadeBO = new MensalidadeBO();
        AnuncianteBO anuncianteBO = new AnuncianteBO();
        AdminBO adminBO = new AdminBO();
        mensalidades = mensalidadeBO.buscarTodos();
        anunciantes = anuncianteBO.buscarAnuncinateM();
        administrador = adminBO.buscarAdminM();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Mensalidade";
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
            java.util.logging.Logger.getLogger(ListarMensalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarMensalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarMensalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarMensalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarMensalidades().setVisible(true);
            }
        });
    }

    class ModeloDadosMensalidade extends AbstractTableModel {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public int getRowCount() {
            return mensalidades.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "ID MENSALIDADE";
            } else if (column == 1) {
                return "ANUNCIANTE";
            } else if (column == 2) {
                return "VALOR";
            } else if (column == 3) {
                return "DATA PAGAMENTO";
            } else if (column == 4) {
                return "DATA VENCIMENTO";
            } else {
                return "ADMINSTRADOR";
            }
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Mensalidade mensalidade = mensalidades.get(rowIndex);
            Anunciante anunciante = anunciantes.get(rowIndex);
            Admin admin = administrador.get(rowIndex);

            if (columnIndex == 0) {
                return mensalidade.getIdMensalidade();
            } else if (columnIndex == 1) {
                return anunciante.getNome();
            } else if (columnIndex == 2) {
                return mensalidade.getvalor();
            } else if (columnIndex == 3) {
                return format.format(mensalidade.getDataPagamento());

            } else if (columnIndex == 4) {
                return format.format(mensalidade.getVencimento());

            } else {
                return admin.getnome();
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame PnListarMensalidade;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbListarMensalidades;
    private javax.swing.JTable tblMensalidades;
    // End of variables declaration//GEN-END:variables
}
