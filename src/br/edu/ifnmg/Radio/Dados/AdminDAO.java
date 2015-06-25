/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import br.edu.ifnmg.Radio.Entidade.Programa;
import br.edu.ifnmg.Radio.Negocio.Exception.SenhaErradaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WellisonTiago
 */
public class AdminDAO {

    private static final String SQL_INSERT = "INSERT INTO DIRETOR_DONO(NOME,SENHA) VALUES (?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT IDDIRETOR_DONO, NOME FROM DIRETOR_DONO ORDER BY NOME ";
    private static final String SQL_SELECT_POR_ID = "SELECT IDDIRETOR, NOME SENHA FROM DIRETOR_DONO WHERE IDDIRETOR = ?";
    private static final String SQL_COMPARA = "SELECT  NOME, SENHA FROM DIRETOR_DONO WHERE NOME = ? AND SENHA = ? ";
    private static final String SQL_VIEW_MENSALIDADES = "SELECT * FROM MENSALIDADES";
    private static final String SQL_VIEW__PROGRMAS = "SELECT * FROM PROGRAMAS";
    private static final String SQL_DELETE = "DELETE FROM DIRETOR_DONO WHERE IDDIRETOR_DONO = ?";
    private static final String SQL_UPDATE = "UPDATE DIRETOR_DONO SET  NOME = ?, SENHA = ? WHERE IDDIRETOR_DONO = ? ";
    
    public void criar(Admin adimin) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, adimin.getnome());
            comando.setString(2, adimin.getSenha());
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
//Caso aconteça alguma exeção é feito um rollback para o banco de
//dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void alterar(Admin admin) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            //comando.setInt(2, ID);
            comando.setString(1, admin.getnome());
            comando.setString(2, admin.getSenha());
            comando.setInt (3, admin.getIdAdim());
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
//Caso aconteça alguma exeção é feito um rollback para o banco de
//dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

    public List<Admin> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Admin> listaAdmin = new ArrayList<Admin>();
        // Admin admin = new Admin();
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Admin admin = new Admin();
                admin.setIdAdim(resultado.getInt(1));
                admin.setNome(resultado.getString(2));

//Adiciona um item à lista que será retornada
                listaAdmin.add(admin);
            }

        } catch (Exception e) {
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaAdmin;
    }

    public Admin buscarPorID(int ID) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Admin admin = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_POR_ID);
            comando.setInt(1, ID);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//Se tiver algum retorno
            if (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                admin = new Admin();
                admin.setIdAdim(resultado.getInt(1));
                admin.setNome(resultado.getString(2));
                admin.setSenha(resultado.getString(3));
            }
        } catch (Exception e) {
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

        return admin;
    }

    public boolean Compara(String Nome, String Senha) throws SQLException, SenhaErradaException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Admin admin = null;
        boolean Status = false;
        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_COMPARA);
            comando.setString(1, Nome);
            comando.setString(2, Senha);
            resultado = comando.executeQuery();

            if (resultado.next()) {

                admin = new Admin();

                admin.setNome(resultado.getString(1));
                admin.setSenha(resultado.getString(2));
                Status = true;

            }
            comando.close();
            return Status;

        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar cliente/ senha.");
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SenhaErradaException();
        }

    }

    public List<Admin> buscarAdmin() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();
        List<Anunciante> listaAnunciante = new ArrayList<Anunciante>();
        List<Admin> listaAdmin = new ArrayList<Admin>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_VIEW_MENSALIDADES);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();
                Anunciante anunciante = new Anunciante();
                Admin admin = new Admin();

                mensalidade.setIdMensalidade(resultado.getInt(1));
                anunciante.setNome(resultado.getString(2));
                mensalidade.setValor(resultado.getDouble(3));
                mensalidade.setDataPagamento(resultado.getDate(4));
                mensalidade.setVencimento(resultado.getDate(5));
                admin.setNome(resultado.getString(6));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);
                listaAnunciante.add(anunciante);
                listaAdmin.add(admin);
            }
        } catch (Exception e) {
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaAdmin;
    }

    public List<Admin> buscarDiretorPrograma() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Programa> listaPrograma = new ArrayList<Programa>();
        List<Admin> listaAdmin = new ArrayList<Admin>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_VIEW__PROGRMAS);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Programa programa = new Programa();
                Admin admin = new Admin();
                programa.setIdPrograma(resultado.getInt(1));
                programa.setNome(resultado.getString(2));
                admin.setNome(resultado.getString(3));

//Adiciona um item à lista que será retornada
                listaPrograma.add(programa);
                listaAdmin.add(admin);
            }
        } catch (Exception e) {
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaAdmin;
    }

    public void excluir(Admin admin) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            
            comando.setInt(1, admin.getIdAdim());

//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
//Caso aconteça alguma exeção é feito um rollback para o banco de
//dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

}
