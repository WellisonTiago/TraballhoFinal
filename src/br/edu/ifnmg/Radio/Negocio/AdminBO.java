/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Dados.AdminDAO;
import br.edu.ifnmg.Radio.Negocio.Exception.SenhaErradaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class AdminBO {

    public void criar(Admin admin) throws SQLException {

        AdminDAO adminDAO = new AdminDAO();

        try {

            adminDAO.criar(admin);

        } catch (SQLException ex) {
            Logger.getLogger(AdminBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Admin> buscarTodos() throws SQLException {
        AdminDAO adminDAO = new AdminDAO();

        return adminDAO.buscarTodos();

    }

    public List<Admin> buscarAdminM() throws SQLException {
        AdminDAO adminDAO = new AdminDAO();

        return adminDAO.buscarAdmin();

    }

    public List<Admin> buscarProgra_Diretor() throws SQLException {
        AdminDAO adminDAO = new AdminDAO();

        return adminDAO.buscarDiretorPrograma();

    }

    public boolean Comparar(String Nome, String Senha) throws SQLException, SenhaErradaException {
        AdminDAO adminDAO = new AdminDAO();

        return adminDAO.Compara(Nome, Senha);

    }
    
        public void excluir(Admin admin) throws SQLException {
        AdminDAO adminDAO = new AdminDAO();
        
            adminDAO.excluir(admin);
        
    }
  
  public void alterar(Admin admin) throws SQLException {
        AdminDAO adminDAO = new AdminDAO();
        /* Locutor LocutorExistente = locutorDAO.buscarPorID(locutor.getIdLocutor());
        if (LocutorExistente.getIdLocutor() == locutor.getIdLocutor()) {*/
      
            adminDAO.alterar(admin);
       // }
  }

}
