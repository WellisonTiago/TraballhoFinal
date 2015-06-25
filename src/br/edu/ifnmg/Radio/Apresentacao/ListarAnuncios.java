/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Anuncio;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Negocio.AnuncioBO;
import br.edu.ifnmg.Radio.Negocio.AnuncianteBO;
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
public class ListarAnuncios extends javax.swing.JFrame {

    List<Anunciante> anunciantes;
    List<Anuncio> anuncios;
     Anuncio anuncioselecionado = new Anuncio ();

    /**
     * Creates new form ListarAnuncios
     */
    public ListarAnuncios() {
        initComponents();
        exibirDadosTabela();
    }

    private void exibirDadosTabela() {
        try {
            this.carregarListaAnuncios();
            ModeloDadosAnuncios modelo = new ModeloDadosAnuncios();
            tblAnuncios.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarAnunciante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carregarListaAnuncios() throws SQLException {
        AnuncioBO anuncioBO = new AnuncioBO();
        AnuncianteBO anuncianteBO = new AnuncianteBO();
        anuncios = anuncioBO.buscarTodos();
        anunciantes = anuncianteBO.buscarAnuciante();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Anuncios";
        mensagem = "Erro desconhecido. Entre em contato com administrador";
        JOptionPane.showMessageDialog(this, titulo, mensagem, JOptionPane.ERROR_MESSAGE);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        PnListarAnuncios = new javax.swing.JInternalFrame();
        lbListarAnuncios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnuncios = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Anuncios");

        PnListarAnuncios.setVisible(true);

        lbListarAnuncios.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbListarAnuncios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListarAnuncios.setText(" Anuncios");

        tblAnuncios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4", "Título 5", "Título 6"
            }
        ));
        jScrollPane1.setViewportView(tblAnuncios);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/icone_lixeira.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnListarAnunciosLayout = new javax.swing.GroupLayout(PnListarAnuncios.getContentPane());
        PnListarAnuncios.getContentPane().setLayout(PnListarAnunciosLayout);
        PnListarAnunciosLayout.setHorizontalGroup(
            PnListarAnunciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnListarAnunciosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnListarAnunciosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PnListarAnunciosLayout.createSequentialGroup()
                .addComponent(lbListarAnuncios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PnListarAnunciosLayout.setVerticalGroup(
            PnListarAnunciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnListarAnunciosLayout.createSequentialGroup()
                .addComponent(lbListarAnuncios)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(PnListarAnunciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnListarAnunciosLayout.createSequentialGroup()
                        .addComponent(btAlterar)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnListarAnunciosLayout.createSequentialGroup()
                        .addComponent(btExcluir)
                        .addGap(37, 37, 37))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnListarAnuncios)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnListarAnuncios)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        try {
            int linhaselecionada = this.tblAnuncios.getSelectedRow();
             anuncioselecionado = this.anuncios.get(linhaselecionada);
            String mensagem = "Deseja excluir " + anuncioselecionado.getDescricao() + " ?";
            String titulo = "Excluir Anuncio";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                AnuncioBO anuncioBO = new AnuncioBO();
                try {
                    anuncioBO.excluir(anuncioselecionado);
                    this.exibirDadosTabela();

                } catch (SQLException e) {
                    String mensagemerro = "Houve um erro ao excluir Anuncio";
                    String tituloerro = "Erro excluir Anuncio";
                    this.exibirMensagemErro(mensagemerro, tituloerro);
                }
            } else if (resultado == JOptionPane.NO_OPTION) {

            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum Anuncio selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } finally {
            this.exibirDadosTabela();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {
            AnuncioBO anuncioBO = new AnuncioBO();
            int linhaselecionada = this.tblAnuncios.getSelectedRow();
            anuncioselecionado = this.anuncios.get(linhaselecionada);
            TelaCadastroAnuncio telaCadastroAnuncio = new TelaCadastroAnuncio(anuncioselecionado,"editar");
            telaCadastroAnuncio.setVisible(true);
            this.exibirDadosTabela();

            anuncioBO.alterar(anuncioselecionado);
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            String mensagem = "Nenhum Anuncio selecionado";
            String titulo = "Erro";
            exibirMensagemErro(mensagem, titulo);
        } catch (SQLException ex) {
            Logger.getLogger(ListarAnuncios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.exibirDadosTabela();
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
            java.util.logging.Logger.getLogger(ListarAnuncios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAnuncios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAnuncios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAnuncios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAnuncios().setVisible(true);
            }
        });
    }

    class ModeloDadosAnuncios extends AbstractTableModel {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public int getRowCount() {
            return anuncios.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Id Anuncio";
            } else if (column == 1) {
                return "DESCRIÇÃO";
            } else if (column == 2) {
                return "QUANTIDADE DE ANUNCIOS POR DIA";
            } else if (column == 3) {
                return "DATA INCIO";
            } else if (column == 4) {
                return "DATA ENCERRAMENTO";
            } else {
                return "ANUNCIANTE";
            }
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Anuncio anuncio = anuncios.get(rowIndex);
            Anunciante anunciante = anunciantes.get(rowIndex);

            if (columnIndex == 0) {
                return anuncio.getIdAnuncio();
            } else if (columnIndex == 1) {
                return anuncio.getDescricao();
            } else if (columnIndex == 2) {
                return anuncio.getQuanPorDia();
            } else if (columnIndex == 3) {
                return format.format(anuncio.getInicoAnuncio());

            } else if (columnIndex == 4) {
                return format.format(anuncio.getEncerramentoAnuncio());

            } else {
                return anunciante.getNome();
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame PnListarAnuncios;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbListarAnuncios;
    private javax.swing.JTable tblAnuncios;
    // End of variables declaration//GEN-END:variables
}
