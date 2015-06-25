/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;
import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Dados.ProgramaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author WellisonTiago
 */
public class ProgramaBO {
    
     public void criar(Programa programa) throws SQLException{
        ProgramaDAO programaDAO = new ProgramaDAO();

        try {
          
            programaDAO.criar(programa);

           
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Programa> buscarTodos() throws SQLException {
        ProgramaDAO programaDAO = new ProgramaDAO();

        return programaDAO.buscarTodos();
        
    }
    
     public void excluir(Programa programa) throws SQLException {
        ProgramaDAO programaDAO = new ProgramaDAO();
   
            programaDAO.excluir(programa);
       
    }
     
      public void alterar(Programa programa) throws SQLException {
        
        ProgramaDAO programaDAO = new ProgramaDAO();
        programaDAO.alterar(programa);
    }
      
     public List<Programa> buscarLocPro() throws SQLException {
        ProgramaDAO programaDAO = new ProgramaDAO();

        return programaDAO.buscarLocPro();
        
    }
    
    
}
