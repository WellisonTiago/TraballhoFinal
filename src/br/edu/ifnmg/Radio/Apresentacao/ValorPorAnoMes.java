/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package br.edu.ifnmg.Radio.Apresentacao;
import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import br.edu.ifnmg.Radio.Negocio.MensalidadeBO;
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
public class ValorPorAnoMes extends javax.swing.JFrame {
  List<Mensalidade> mensalidadeA;
  List<Mensalidade> mensalidadeM;
    List<Mensalidade> mensalidadeS;
    /**
     * Creates new form ValorPorMens
     */
    public ValorPorAnoMes() {
        initComponents();
        this.exibirDadosTabela();
    }
    
    private void exibirDadosTabela() {
        try {
            this.carregarListaMensalidade();
            ModeloDadosMensalidade modelo = new ModeloDadosMensalidade();
            tbPorAno.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(ValorPorAnoMes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

      private void carregarListaMensalidade() throws SQLException {
        MensalidadeBO mensalidadeBO = new MensalidadeBO();
        mensalidadeA = mensalidadeBO.ValorPorAno();
        mensalidadeM = mensalidadeBO.ValorPorMes();
         mensalidadeS = mensalidadeBO.Valor_Mes();
       
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        titulo = "Erro ao recuperar Valor";
        mensagem = "Erro desconhecido. Entre em contato com administrador";
        JOptionPane.showMessageDialog(this, titulo, mensagem, JOptionPane.ERROR_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnValorAno = new javax.swing.JInternalFrame();
        lbValorAno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPorAno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnValorAno.setVisible(true);

        lbValorAno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbValorAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValorAno.setText("Renda por Mês");

        tbPorAno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPorAno);

        javax.swing.GroupLayout pnValorAnoLayout = new javax.swing.GroupLayout(pnValorAno.getContentPane());
        pnValorAno.getContentPane().setLayout(pnValorAnoLayout);
        pnValorAnoLayout.setHorizontalGroup(
            pnValorAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addComponent(lbValorAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnValorAnoLayout.setVerticalGroup(
            pnValorAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnValorAnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbValorAno)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnValorAno)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnValorAno)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ValorPorAnoMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValorPorAnoMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValorPorAnoMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValorPorAnoMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValorPorAnoMes().setVisible(true);
            }
        });
    }
    
     class ModeloDadosMensalidade extends AbstractTableModel {

       

        @Override
        public int getRowCount() {
            return mensalidadeS.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "ANO ";
            } if (column == 1) {
                return "MES ";
            }
            
            else {
                return "RENDA";
            }
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Mensalidade meA = mensalidadeA.get(rowIndex);
            Mensalidade meM = mensalidadeM.get(rowIndex);
            Mensalidade meS = mensalidadeS.get(rowIndex);
             if (columnIndex == 0) {
                return meA.getValor();
            }  if (columnIndex == 1) {
                return meM.getValor();
            }
             
             else {
                return meS.getValor();
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbValorAno;
    private javax.swing.JInternalFrame pnValorAno;
    private javax.swing.JTable tbPorAno;
    // End of variables declaration//GEN-END:variables
}
