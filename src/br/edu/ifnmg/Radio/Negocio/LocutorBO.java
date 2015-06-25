/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;
import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Dados.LocutorDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class LocutorBO {
    
     public void criar(Locutor locutor) throws SQLException{
        LocutorDAO locutorDAO = new LocutorDAO();

          try {
          
            locutorDAO.criar(locutor);

            
            } catch (SQLException ex) {
            Logger.getLogger(LocutorBO.class.getName()).log(Level.SEVERE, null, ex);
           
            }
    }

    public List<Locutor> buscarTodos() throws SQLException {
        LocutorDAO locutorDAO = new LocutorDAO();

        return locutorDAO.buscarTodos();
        
    }
    
     public List<Locutor> buscarLocPro() throws SQLException {
        LocutorDAO locutorDAO = new LocutorDAO();

        return locutorDAO.buscarLocPro();
        
    }
    
    
     public void excluir(Locutor locutor) throws SQLException {
        LocutorDAO locutorDAO = new LocutorDAO();
        Locutor LocutorExistente = locutorDAO.buscarPorID(locutor.getIdLocutor());
        if (LocutorExistente.getIdLocutor() == locutor.getIdLocutor()) {
            locutorDAO.excluir(locutor);
        }
    }
     
  public void alterar(Locutor locutor) throws SQLException {
        LocutorDAO locutorDAO = new LocutorDAO();
        /* Locutor LocutorExistente = locutorDAO.buscarPorID(locutor.getIdLocutor());
        if (LocutorExistente.getIdLocutor() == locutor.getIdLocutor()) {*/
      
            locutorDAO.alterar(locutor);
       // }
  }
    
    
}
