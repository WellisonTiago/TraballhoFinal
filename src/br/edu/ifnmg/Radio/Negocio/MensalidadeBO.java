/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;

import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import br.edu.ifnmg.Radio.Dados.MensalidadeDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class MensalidadeBO {

    public void criar(Mensalidade mensalidade) throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        try {

            mensalidadeDAO.criar(mensalidade);

        } catch (SQLException ex) {
            Logger.getLogger(MensalidadeBO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List<Mensalidade> buscarTodos() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.buscarTodos();

    }
    
    public void alterar(Mensalidade mensalidade) throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
   
            mensalidadeDAO.alterar(mensalidade);
       
    }
    
    public void excluir(Mensalidade mensalidade) throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
   
            mensalidadeDAO.excluir(mensalidade);
       
    }
    
     public List<Mensalidade> buscarValorMes() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.Valor_Mes();

    }

    
     
     public List<Mensalidade> buscarValor() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.Valor_Ano();

    }
   
   public List<Mensalidade> buscarAno() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.Ano();

    }
     
    public List<Mensalidade> ValorPorAno() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.ValorPorAno();

    }
    
     public List<Mensalidade> ValorPorMes () throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.ValorPorMes();

    }
    
      public List<Mensalidade> Valor_Mes() throws SQLException {
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        return mensalidadeDAO.Valor_Mes();

    }
}
