/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Anuncio;
import br.edu.ifnmg.Radio.Entidade.Mensalidade;

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
public class AnuncianteDAO {

    private static final String SQL_INSERT = "INSERT INTO ANUNCIANTE(NOME, CPF, TELEFONE, BAIRRO, RUA, CIDADE, NUMRESIDENCIA) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT * FROM ANUNCIANTE ORDER BY IDANUNCIANTE";
    private static final String SQL_VIEW_MENSALIDADES = "SELECT * FROM MENSALIDADES";
    private static final String SQL_DELETE = "DELETE FROM ANUNCIANTE WHERE IDANUNCIANTE = ?";
    private static final String SQL_SELECT_POR_ID = "SELECT IDANUNCIANTE, NOME,CPF, TELEFONE, BAIRRO, RUA, CIDADE, NUMRESIDENCIA FROM ANUNCIANTE WHERE IDANUNCIANTE = ?";
    private static final String SQL_VIEWANUNCIOS = "SELECT * FROM ANUNCIOS";
     private static final String SQL_UPDATE = "UPDATE ANUNCIANTE SET  NOME = ?, CPF = ?, TELEFONE = ?, BAIRRO = ? , RUA = ? , CIDADE = ?,  NUMRESIDENCIA = ? WHERE IDANUNCIANTE = ? ";
    
    public void criar(Anunciante anunciante) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, anunciante.getNome());
            comando.setString(2, anunciante.getCpf());
            comando.setString(3, anunciante.getTelefone());
  
            comando.setString(4, anunciante.getBairro());
            comando.setString(5, anunciante.getRua());
            comando.setString(6, anunciante.getCidade());
            comando.setInt(7, anunciante.getNumResidencia());
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

    public List<Anunciante> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Anunciante> listaAnunciante = new ArrayList<Anunciante>();

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
                Anunciante anunciante = new Anunciante();
                anunciante.setIdAnunciante(resultado.getInt(1));
                anunciante.setNome(resultado.getString(2));
                anunciante.setCPF(resultado.getString(3));
                anunciante.setTelefone(resultado.getString(4));
                anunciante.setBairro(resultado.getString(5));
                anunciante.setRua(resultado.getString(6));
                anunciante.setCidade(resultado.getString(7));
                anunciante.setNumResidencia(resultado.getInt(8));
//Adiciona um item à lista que será retornada
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
        return listaAnunciante;
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
    
    public List<Anunciante> buscarNomeAnunciante() throws SQLException {
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
        return listaAnunciante;
    }

   
     public void excluir(Anunciante anunciante) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, anunciante.getIdAnunciante());
            
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
   
     public Anunciante buscarPorID(int ID) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
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
                anunciante = new Anunciante();
                            
                anunciante.setIdAnunciante(resultado.getInt(1));
                anunciante.setNome(resultado.getString(2));
                anunciante.setCPF(resultado.getString(3));
                anunciante.setTelefone(resultado.getString(4));
                anunciante.setBairro(resultado.getString(5));
                anunciante.setRua(resultado.getString(6));
                anunciante.setCidade(resultado.getString(7));
                anunciante.setNumResidencia(resultado.getInt(8));;
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
        return anunciante;
    }
     
      public List<Anunciante> buscarAnunciante() throws SQLException {
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
        return listaAnunciante;
    }

 public List<Anunciante> buscarAnun() throws SQLException {
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
                Anunciante anunciante = new Anunciante ();
                Admin admin = new Admin ();
                
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
        return listaAnunciante;
    }

  public void alterar(Anunciante anunciante) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            
            comando.setString(1, anunciante.getNome());
            comando.setString(2, anunciante.getCpf());
            comando.setString(3, anunciante.getTelefone());
            comando.setString(4, anunciante.getBairro());
            comando.setString(5, anunciante.getRua());
            comando.setString(6, anunciante.getCidade());
            comando.setInt(7, anunciante.getNumResidencia());
            comando.setInt(8, anunciante.getIdAnunciante());
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
