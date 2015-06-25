package br.edu.ifnmg.Radio.Negocio;

import br.edu.ifnmg.Radio.Dados.LocutorDAO;
import br.edu.ifnmg.Radio.Entidade.Locutor_Programa;
import br.edu.ifnmg.Radio.Dados.Locutor_ProgramaDAO;
import br.edu.ifnmg.Radio.Dados.ProgramaDAO;
import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumLocutouOuProgramaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class Locutor_ProgramaBO {

    public void criar(Locutor_Programa locutor_Programa) throws SQLException, NenhumLocutouOuProgramaException {
        Locutor_ProgramaDAO locutor_ProgramaDAO = new Locutor_ProgramaDAO();
        LocutorDAO locutorDAO = new LocutorDAO();
        ProgramaDAO programaDAO = new ProgramaDAO();
        List<Locutor> locutor
                = locutorDAO.buscarTodos();

        List<Programa> programa
                = programaDAO.buscarTodos();
        if (locutor == null || programa == null) {
            throw new NenhumLocutouOuProgramaException();
        } else {
            try {

                locutor_ProgramaDAO.criar(locutor_Programa);

            } catch (SQLException ex) {
                Logger.getLogger(Locutor_ProgramaBO.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
  
     public List<Locutor_Programa> buscarTodos() throws SQLException {
        Locutor_ProgramaDAO locutor_ProgramaDAO = new Locutor_ProgramaDAO();

        return locutor_ProgramaDAO.buscarTodos();
        
    }
}
