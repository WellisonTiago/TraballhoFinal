package br.edu.ifnmg.Radio.Negocio;

import br.edu.ifnmg.Radio.Dados.AnuncioDAO;
import br.edu.ifnmg.Radio.Entidade.Locutor_Programa;

import br.edu.ifnmg.Radio.Dados.ProgramaDAO;
import br.edu.ifnmg.Radio.Dados.Programa_AnuncioDAO;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Entidade.Programa_Anuncio;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumAnuncianteCadastradoException;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumProgramaOuAnuncianteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class Programa_AnuncioBO {

    public void criar(Programa_Anuncio programa_Anuncio) throws SQLException, NenhumProgramaOuAnuncianteException {
       Programa_AnuncioDAO Programa_AnuncioDAO = new Programa_AnuncioDAO();
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        ProgramaDAO programaDAO = new ProgramaDAO();
        List<Anuncio> anuncio
                = anuncioDAO.buscarTodos();

        List<Programa> programa
                = programaDAO.buscarTodos();
        if (anuncio == null || programa == null) {
            throw new NenhumProgramaOuAnuncianteException ();
        } else {
            try {

                Programa_AnuncioDAO.criar(programa_Anuncio);

            } catch (SQLException ex) {
                Logger.getLogger(Programa_AnuncioBO.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
  
     public List<Programa_Anuncio> buscarTodos() throws SQLException {
        Programa_AnuncioDAO programa_AnuncioDAO = new Programa_AnuncioDAO();

        return programa_AnuncioDAO.buscarTodos();
        
    }
}
