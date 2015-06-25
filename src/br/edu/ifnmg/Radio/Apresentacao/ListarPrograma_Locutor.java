/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Negocio.ProgramaBO;
import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Entidade.Locutor_Programa;
import br.edu.ifnmg.Radio.Negocio.LocutorBO;
import br.edu.ifnmg.Radio.Negocio.Locutor_ProgramaBO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class ListarPrograma_Locutor extends javax.swing.JFrame {

    List<Programa> programas;
    List<Locutor> locutores;
    List<Locutor_Programa> programa_Locutor;

    public ListarPrograma_Locutor() {
        initComponents();
        this.exibirDadosTabela();
    }

    @SuppressWarnings("unchecked")
    
    private void exibirDadosTabela() {
        try {
            this.carregarLocutorPrograma();
            ModeloDadosLocutor_Programa modelo = new ModeloDadosLocutor_Programa();
            tbLocPro.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ListarPrograma_Locutor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrograma_Locutor = new javax.swing.JInternalFrame();
        lbProLoc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLocPro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lisatar Programa Locutor");

        pnPrograma_Locutor.setVisible(true);

        lbProLoc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbProLoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProLoc.setText("Programas e seus Locutores");

        tbLocPro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbLocPro);

        javax.swing.GroupLayout pnPrograma_LocutorLayout = new javax.swing.GroupLayout(pnPrograma_Locutor.getContentPane());
        pnPrograma_Locutor.getContentPane().setLayout(pnPrograma_LocutorLayout);
        pnPrograma_LocutorLayout.setHorizontalGroup(
            pnPrograma_LocutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
            .addComponent(lbProLoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPrograma_LocutorLayout.setVerticalGroup(
            pnPrograma_LocutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrograma_LocutorLayout.createSequentialGroup()
                .addComponent(lbProLoc)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrograma_Locutor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrograma_Locutor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void carregarLocutorPrograma() throws SQLException {
        ProgramaBO programaBO = new ProgramaBO();
        LocutorBO locutorBO = new LocutorBO();
        Locutor_ProgramaBO locutor_PorgramaBO = new Locutor_ProgramaBO();
        programas = programaBO.buscarLocPro();
        locutores = locutorBO.buscarLocPro();
        programa_Locutor = locutor_PorgramaBO.buscarTodos();
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Programa_Locutor";
        mensagem = "Erro desconhecido. Entre em contato com administrador";
        JOptionPane.showMessageDialog(this, titulo, mensagem, JOptionPane.ERROR_MESSAGE);
    }

    class ModeloDadosLocutor_Programa extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return programa_Locutor.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "LOCUTOR";

            } else {
                return "PROGRAMA";
            }
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override

        public Object getValueAt(int linha, int coluna) {
            Locutor_Programa locutorPrograma = programa_Locutor.get(linha);
            Programa programa = programas.get(linha);
            Locutor locutor = locutores.get(linha);

            if (coluna == 0) {
                return locutor.getNome();
            } else {
                return programa.getNome();

            }
        }

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
            java.util.logging.Logger.getLogger(ListarPrograma_Locutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPrograma_Locutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPrograma_Locutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPrograma_Locutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPrograma_Locutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProLoc;
    private javax.swing.JInternalFrame pnPrograma_Locutor;
    private javax.swing.JTable tbLocPro;
    // End of variables declaration//GEN-END:variables
}
