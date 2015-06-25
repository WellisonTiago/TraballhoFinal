/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;
import br.edu.ifnmg.Radio.Dados.AnuncianteDAO;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author WellisonTiago
 */
public class AnuncianteBO {
    
    public void criar(Anunciante anunciante) throws SQLException{
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();

        try {
          
            anuncianteDAO.criar(anunciante);

           
        } catch (SQLException ex) {
            Logger.getLogger(AnuncianteBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Anunciante> buscarTodos() throws SQLException {
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();

        return anuncianteDAO.buscarTodos();
        
    }
    
    public List<Anunciante> buscarAnuciante () throws SQLException {
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();

        return anuncianteDAO.buscarNomeAnunciante();
        
    }
    
     public List<Anunciante> buscarAnuncinateM () throws SQLException {
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();

        return anuncianteDAO.buscarAnun();
        
    }
    
      public void excluir(Anunciante anunciante) throws SQLException {
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();
        Anunciante AuncianteExistente = anuncianteDAO.buscarPorID(anunciante.getIdAnunciante());
        if (AuncianteExistente.getIdAnunciante() == anunciante.getIdAnunciante()) {
            anuncianteDAO.excluir(anunciante);
        }
    }
    
      
    public void alterar(Anunciante anunciante) throws SQLException {
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();
        /* Locutor LocutorExistente = locutorDAO.buscarPorID(locutor.getIdLocutor());
        if (LocutorExistente.getIdLocutor() == locutor.getIdLocutor()) {*/
      
            anuncianteDAO.alterar(anunciante);
       // }
  }
    
    
}
