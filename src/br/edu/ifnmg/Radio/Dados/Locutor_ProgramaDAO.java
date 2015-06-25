/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Locutor;
import br.edu.ifnmg.Radio.Entidade.Locutor_Programa;
import br.edu.ifnmg.Radio.Entidade.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WellisonTiago
 */
public class Locutor_ProgramaDAO {

    private static final String SQL_INSERT = "INSERT INTO LOCUTOR_PROGRAMA(IDLOCUTOR,IDPROGRAMA) VALUES (?,?)";
    private static final String SQL_View_Locutor_Programa = "SELECT * FROM LOCUTOR_PROGRAMAS";
    private static final String SQL_UPDATE = "UPDATE LOCUTOR_PROGRAMA SET  IDLOCUTOR=?, IDPROGRAMA = ? WHERE IDLOCUTOR = ? ";

    public void criar(Locutor_Programa locutor_Programa) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, locutor_Programa.getIdLocutor());
            comando.setInt(2, locutor_Programa.getIdPrograma());
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
    
    public void alterar(Locutor_Programa locutor_Programa) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            //comando.setInt(2, ID);
            
            comando.setInt(1, locutor_Programa.getIdLocutor());
            comando.setInt(2, locutor_Programa.getIdPrograma());
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

    public List<Locutor_Programa> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Locutor_Programa> listalocutor_Programa = new ArrayList<Locutor_Programa>();
        List<Locutor> listalocutor = new ArrayList<Locutor>();
        List<Programa> listaPrograma = new ArrayList<Programa>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_View_Locutor_Programa);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
              //  Locutor_Programa locutor_Pograma = new Locutor_Programa();
                Locutor locutor = new Locutor();
                Programa programa = new Programa();
                locutor.setNome(resultado.getString(1));
                programa.setNome(resultado.getString(2));

//Adiciona um item à lista que será retornada
                //listalocutor_Programa.add(locutor_Pograma);
                listaPrograma.add(programa);
                listalocutor.add(locutor);
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
        return listalocutor_Programa;
    }

}
