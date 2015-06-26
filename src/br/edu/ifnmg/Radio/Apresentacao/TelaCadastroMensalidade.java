/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import br.edu.ifnmg.Radio.Negocio.AdminBO;
import br.edu.ifnmg.Radio.Negocio.AnuncianteBO;
import br.edu.ifnmg.Radio.Negocio.MensalidadeBO;
import java.util.List;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;
import javax.swing.JOptionPane;

/**
 *
 * @author WellisonTiago
 */
public class TelaCadastroMensalidade extends javax.swing.JFrame {

    private Mensalidade mensalidade;
    List<Anunciante> Anunciantes;
    List<Admin> Diretor;
    List<Anunciante> listaAnunciante = new ArrayList<Anunciante>();
    List<Admin> listaAdmin = new ArrayList<Admin>();
    Anunciante anunciante = new Anunciante();
    Admin admin = new Admin();
    int posicaoAnuncianteSelecionado;
    int adminstradorSelecionado;

    public TelaCadastroMensalidade(Mensalidade mensalidade, String tipoTela) {
        initComponents();
        this.mensalidade = mensalidade;
        if (tipoTela.equals("cadastro")) {
            this.carregarComoBox();
            this.carregarComoBox2();
            this.btEditar.setVisible(false);
            this.lbEditar.setVisible(false);
            this.btAdicionar.setVisible(true);
            this.lbMensalidade.setVisible(true);
        } else {

            this.txtDataPagamento.setText(mensalidade.getDataFormatadaPagamento());
            this.txtDataVencimento.setText(mensalidade.getDataFormatadaVencimento());
            this.txtValor.setText(String.valueOf(mensalidade.getvalor()));
            this.carregarComoBox();
            this.carregarComoBox2();
            this.btEditar.setVisible(true);
            this.lbEditar.setVisible(true);
            this.btAdicionar.setVisible(false);
            this.lbMensalidade.setVisible(false);

        }
    }

    private void lerDadosTela() throws ParseException {
        mensalidade = new Mensalidade();

        String form = "dd/MM/yyyy";
        Date date = new SimpleDateFormat(form).parse(txtDataPagamento.getText().trim());
        mensalidade.setDataPagamento(date);
        String formt = "dd/MM/yyyy";
        Date dat = new SimpleDateFormat(formt).parse(txtDataVencimento.getText().trim());
        mensalidade.setVencimento(dat);
        String valor = txtValor.getText().trim();
        DecimalFormat formatador = new DecimalFormat("#,##0.00");
        mensalidade.setValor(formatador.parse(valor).doubleValue());
        posicaoAnuncianteSelecionado = CbAnunciante.getSelectedIndex();
        anunciante = listaAnunciante.get(posicaoAnuncianteSelecionado);
        mensalidade.setIdAnunciante(anunciante.getIdAnunciante());
        admin = listaAdmin.get(adminstradorSelecionado);
        mensalidade.setIdDiretor_Dono(admin.getIdAdim());

    }

    private void limparCamposTela() {

        this.txtDataPagamento.setText("");
        this.txtDataVencimento.setText("");
        this.txtValor.setText("");

    }

    private void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Mensalidade", JOptionPane.INFORMATION_MESSAGE);

    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao cadastrar Mensalidade", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnMensalidade = new javax.swing.JLayeredPane();
        lbMensalidade = new javax.swing.JLabel();
        lbDataPagamento = new javax.swing.JLabel();
        txtDataPagamento = new javax.swing.JTextField();
        lbDataVencimento = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JTextField();
        lbValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lbAnunciante = new javax.swing.JLabel();
        lbDiretor = new javax.swing.JLabel();
        CbAnunciante = new javax.swing.JComboBox();
        cbDiretor = new javax.swing.JComboBox();
        btAdicionar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        lbEditar = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Mensalidade");

        lbMensalidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbMensalidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensalidade.setText("Cadastro Mensalidade");

        lbDataPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDataPagamento.setText("Data Pagamento:");

        txtDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataPagamentoActionPerformed(evt);
            }
        });

        lbDataVencimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDataVencimento.setText("Data Vencimento:");

        lbValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbValor.setText("Valor:");

        lbAnunciante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAnunciante.setText("Anunciante:");

        lbDiretor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDiretor.setText("Adminstrador:");

        CbAnunciante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbAnunciante.setSelectedItem(anunciante);
        CbAnunciante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbAnuncianteActionPerformed(evt);
            }
        });

        cbDiretor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDiretor.setSelectedItem(admin.getIdAdim());
        cbDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiretorActionPerformed(evt);
            }
        });

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/save31.png"))); // NOI18N
        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        lbEditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEditar.setText("Editar Mensalidade");

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Radio/Apresentacao/imagens/edit5.png"))); // NOI18N
        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnMensalidadeLayout = new javax.swing.GroupLayout(PnMensalidade);
        PnMensalidade.setLayout(PnMensalidadeLayout);
        PnMensalidadeLayout.setHorizontalGroup(
            PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMensalidadeLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PnMensalidadeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addComponent(lbDataVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addComponent(lbValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addComponent(lbDataPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnMensalidadeLayout.createSequentialGroup()
                                .addComponent(lbDiretor)
                                .addGap(18, 18, 18)
                                .addComponent(cbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnMensalidadeLayout.createSequentialGroup()
                                .addComponent(lbAnunciante)
                                .addGap(18, 18, 18)
                                .addComponent(CbAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addComponent(lbMensalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnMensalidadeLayout.setVerticalGroup(
            PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMensalidadeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbMensalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEditar)
                .addGap(28, 28, 28)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataPagamento)
                    .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAnunciante)
                    .addComponent(CbAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataVencimento)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiretor)
                    .addComponent(cbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnMensalidadeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(PnMensalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnMensalidadeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PnMensalidade.setLayer(lbMensalidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbDataPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(txtDataPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbDataVencimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(txtDataVencimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbValor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(txtValor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbAnunciante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbDiretor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(CbAnunciante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(cbDiretor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(btAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(btLimpar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(lbEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PnMensalidade.setLayer(btEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(PnMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnMensalidade, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        try {
            // TODO add your handling code here:
            lerDadosTela();
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastroAnunciante.class.getName()).log(Level.SEVERE, null, ex);
        }

        MensalidadeBO mensalidadeBO = new MensalidadeBO();

        try {
            mensalidadeBO.criar(mensalidade);
            String mensagem = "mensalidade Cadastrado com Sucesso.";
            exibirMensagemSucesso(mensagem);
            this.limparCamposTela();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroAnunciante.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception e) {
            String mensagem = "Erro desconhecido. Entre em contato com o administrador do sistema.";
            this.exibirMensagemErro(mensagem);
            this.limparCamposTela();
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.limparCamposTela();
    }//GEN-LAST:event_btLimparActionPerformed

    public void carregarComoBox() {

        AnuncianteBO anuncianteBO = new AnuncianteBO();
        try {
            listaAnunciante = anuncianteBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        CbAnunciante.removeAllItems();
        int linhaselecionada = this.CbAnunciante.getSelectedIndex();
        for (int registro = 0; registro < listaAnunciante.size(); registro++) {
            //  System.out.println(listaAnunciante);
            anunciante = listaAnunciante.get(registro);
            CbAnunciante.addItem(anunciante.getNome());
            //CbAnunciante.setSelectedItem(anunciante);
        }
    }
    private void CbAnuncianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbAnuncianteActionPerformed
        posicaoAnuncianteSelecionado = CbAnunciante.getSelectedIndex();
        CbAnunciante.setSelectedItem(anunciante.getIdAnunciante());
        System.out.println(posicaoAnuncianteSelecionado);
    }//GEN-LAST:event_CbAnuncianteActionPerformed

    public void carregarComoBox2() {

        AdminBO adminBO = new AdminBO();
        try {
            listaAdmin = adminBO.buscarTodos();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbDiretor.removeAllItems();
        int linhaselecionada = this.cbDiretor.getSelectedIndex();
        for (int registro = 0; registro < listaAdmin.size(); registro++) {
            //  System.out.println(listaAnunciante);
            admin = listaAdmin.get(registro);
            cbDiretor.addItem(admin.getnome());
            //cbDiretor.setSelectedItem(admin);

            // adminstradorSelecionado = cbDiretor.getSelectedIndex();
        }
    }
    private void cbDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiretorActionPerformed
        adminstradorSelecionado = cbDiretor.getSelectedIndex();
        cbDiretor.setSelectedItem(admin.getIdAdim());
        System.out.println(adminstradorSelecionado);
    }//GEN-LAST:event_cbDiretorActionPerformed

    private void txtDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataPagamentoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {

            MensalidadeBO mensalidadeBO = new MensalidadeBO();
            
        String form = "dd/MM/yyyy";
        Date date = new SimpleDateFormat(form).parse(txtDataPagamento.getText().trim());
        this.mensalidade.setDataPagamento(date);
        String formt = "dd/MM/yyyy";
        Date dat = new SimpleDateFormat(formt).parse(txtDataVencimento.getText().trim());
        this.mensalidade.setVencimento(dat);
        String valor = txtValor.getText().trim();
        DecimalFormat formatador = new DecimalFormat("#,##0.00");
        this.mensalidade.setValor(formatador.parse(valor).doubleValue());
        posicaoAnuncianteSelecionado = CbAnunciante.getSelectedIndex();
        this.anunciante = listaAnunciante.get(posicaoAnuncianteSelecionado);
        this.mensalidade.setIdAnunciante(anunciante.getIdAnunciante());
        this.admin = listaAdmin.get(adminstradorSelecionado);
        this.mensalidade.setIdDiretor_Dono(admin.getIdAdim());

            mensalidadeBO.alterar(this.mensalidade);

            this.exibirMensagemSucesso("Mensalidade Alterada");
            this.limparCamposTela();
            // ListarLocutores listarLocutores = new ListarLocutores();

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastroMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
            ListarMensalidades c = new ListarMensalidades();
            c.setVisible(true);
        }
    }//GEN-LAST:event_btEditarActionPerformed

   
    public static void main(String args[]) {
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CbAnunciante;
    private javax.swing.JLayeredPane PnMensalidade;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JComboBox cbDiretor;
    private javax.swing.JLabel lbAnunciante;
    private javax.swing.JLabel lbDataPagamento;
    private javax.swing.JLabel lbDataVencimento;
    private javax.swing.JLabel lbDiretor;
    private javax.swing.JLabel lbEditar;
    private javax.swing.JLabel lbMensalidade;
    private javax.swing.JLabel lbValor;
    private javax.swing.JTextField txtDataPagamento;
    private javax.swing.JTextField txtDataVencimento;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
