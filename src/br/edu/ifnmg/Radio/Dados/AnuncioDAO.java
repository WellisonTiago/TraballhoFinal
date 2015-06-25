/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WellisonTiago
 */
public class AnuncioDAO {

    private static final String SQL_INSERT = "INSERT INTO ANUNCIO(DESCRICAO,QUANPORDIA,INICIOANUNCIO,ENCERRAMENTOANUNCIO,IDANUNCIANTE) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT IDANUNCIO,DESCRICAO,QUANPORDIA,INICOANUNCIO,ENCERRAMENTOANUNCIO,IDANUNCIANTE FROM ANUNCIO ORDER BY DESCRICAO DESC ";
    private static final String SQL_VIEWANUNCIOS = "SELECT * FROM ANUNCIOS";
    private static final String SQL_DELETE = "DELETE FROM ANUNCIO WHERE IDANUNCIO = ?";
    private static final String SQL_SELECT_POR_ID = "SELECT IDANUNCIO,DESCRICAO,QUANPORDIA,INICIOANUNCIO,ENCERRAMENTOANUNCIO,IDANUNCIANTE FROM ANUNCIO WHERE IDANUNCIO = ?";
    private static final String SQL_View_Locutor_Programa = "SELECT * FROM LOCUTOR_PROGRAMAS";
    private static final String SQL_UPDATE = "UPDATE ANUNCIO SET  DESCRICAO = ?, QUANPORDIA =? ,ENCERRAMENTOANUNCIO = ?,IDANUNCIANTE = ? WHERE IDANUNCIO = ? ";

    public void criar(Anuncio anuncio) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        String dataformatada = formata.format(anuncio.getEncerramentoAnuncio());

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, anuncio.getDescricao());
            comando.setInt(2, anuncio.getQuanPorDia());
            java.sql.Date sqldate = new java.sql.Date(anuncio.getInicoAnuncio().getTime());
            java.sql.Date sqldat = new java.sql.Date(anuncio.getEncerramentoAnuncio().getTime());
            //comando.setString(2, dataformatada); metodo 2
            comando.setDate(3, sqldate);
            comando.setDate(4, sqldat);
          // comando.setDate(4, (Date)anuncio.getInicoAnuncio());

            //comando.setString (4, dataformatada);
            comando.setInt(5, anuncio.getIdAnunciante());

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

    public void alterar(Anuncio anuncio) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        String dataformatada = formata.format(anuncio.getEncerramentoAnuncio());
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)

            comando.setString(1, anuncio.getDescricao());
            comando.setInt(2, anuncio.getQuanPorDia());
            //java.sql.Date sqldate = new java.sql.Date(anuncio.getInicoAnuncio().getTime());
            java.sql.Date sqldat = new java.sql.Date(anuncio.getEncerramentoAnuncio().getTime());
           // comando.setDate(3, sqldate);
            comando.setDate(3, sqldat);
            comando.setInt(4, anuncio.getIdAnunciante());
            comando.setInt(5, anuncio.getIdAnuncio());
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

    public List<Anuncio> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();
        List<Anunciante> listaAnunciante = new ArrayList<Anunciante>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_VIEWANUNCIOS);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Anuncio anuncio = new Anuncio();
                Anunciante anunciante = new Anunciante();
                anuncio.setIdAnuncio(resultado.getInt(1));
                anuncio.setDescricao(resultado.getString(2));
                anuncio.setQuanPorDia(resultado.getInt(3));
                anuncio.setInicoAnuncio(resultado.getDate(4));
                anuncio.setEncerramentoAnuncio(resultado.getDate(5));
                anunciante.setNome(resultado.getString(6));
//Adiciona um item à lista que será retornada
                listaAnuncio.add(anuncio);
                listaAnunciante.add(anunciante);
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
        return listaAnuncio;
    }

    public void excluir(Anuncio anuncio) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, anuncio.getIdAnuncio());

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

    public Anuncio buscarPorID(int ID) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Anuncio anuncio = null;
        Anunciante anunciante = null;
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
                anuncio = new Anuncio();
                anunciante = new Anunciante();
                anuncio.setIdAnuncio(resultado.getInt(1));
                anuncio.setDescricao(resultado.getString(2));
                anuncio.setInicoAnuncio(resultado.getDate(3));
                anuncio.setEncerramentoAnuncio(resultado.getDate(4));
                anunciante.setNome(resultado.getString(5));
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
        return anuncio;
    }

}
