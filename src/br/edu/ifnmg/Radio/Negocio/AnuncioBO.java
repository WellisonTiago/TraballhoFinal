/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;

import br.edu.ifnmg.Radio.Dados.AnuncianteDAO;
import br.edu.ifnmg.Radio.Negocio.Exception.NenhumAnuncianteCadastradoException;
import br.edu.ifnmg.Radio.Dados.AnuncioDAO;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class AnuncioBO {

    public void criar(Anuncio anuncio) throws SQLException, NenhumAnuncianteCadastradoException {
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        AnuncianteDAO anuncianteDAO = new AnuncianteDAO();
        List<Anunciante> anunciante
                = anuncianteDAO.buscarTodos();
        if (anunciante == null) {
            throw new NenhumAnuncianteCadastradoException();
        } else {
            try {

                anuncioDAO.criar(anuncio);

            } catch (SQLException ex) {
                Logger.getLogger(AnuncioBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Anuncio> buscarTodos() throws SQLException {
        AnuncioDAO anuncioDAO = new AnuncioDAO();

        return anuncioDAO.buscarTodos();

    }

    public void excluir(Anuncio anuncio) throws SQLException {
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        /*   Anuncio AuncioExistente = anuncioDAO.buscarPorID (anuncio.getIdAnuncio());
        if (AuncioExistente.getIdAnuncio() == anuncio.getIdAnuncio()) {*/
            anuncioDAO.excluir(anuncio);
        
    }
    
    
    public void alterar(Anuncio anuncio) throws SQLException {
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        /*   Anuncio AuncioExistente = anuncioDAO.buscarPorID (anuncio.getIdAnuncio());
        if (AuncioExistente.getIdAnuncio() == anuncio.getIdAnuncio()) {*/
            anuncioDAO.alterar(anuncio);
        
    }



}
