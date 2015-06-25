/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Programa_Anuncio;
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
public class Programa_AnuncioDAO {

    private static final String SQL_INSERT = "INSERT INTO PROGRAMA__ANUNCIO (IDPROGRAMA,IDANUNCIO) VALUES (?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT IDPROGRAMA, IDANUNCIO FROM PROGRAMA_ANUNCIO ";
    private static final String SQL_UPDATE = "UPDATE PROGRAMA_ANUNCIO SET  IDPROGRMA=?, IDANUNCIO = ? WHERE IDROGRAMA = ? ";

    public void criar(Programa_Anuncio programa_Anuncio) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)

            comando.setInt(1, programa_Anuncio.getIdPrograma());
            comando.setInt(2, programa_Anuncio.getIdAnuncio());
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

    public void alterar(Programa_Anuncio programa_Anuncio) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            //comando.setInt(2, ID);

            comando.setInt(1, programa_Anuncio.getIdPrograma());
            comando.setInt(2, programa_Anuncio.getIdAnuncio());
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

    public List<Programa_Anuncio> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Programa_Anuncio> Listaprograma_Anuncio = new ArrayList<Programa_Anuncio>();

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
                Programa_Anuncio programa_Anuncio = new Programa_Anuncio();

                programa_Anuncio.setIdPrograma(resultado.getInt(1));
                programa_Anuncio.setIdAnuncio(resultado.getInt(2));

//Adiciona um item à lista que será retornada
                Listaprograma_Anuncio.add(programa_Anuncio);
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
        return Listaprograma_Anuncio;
    }

}
