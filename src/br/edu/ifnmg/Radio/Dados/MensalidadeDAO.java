/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Dados;

import br.edu.ifnmg.Radio.Entidade.Admin;
import br.edu.ifnmg.Radio.Entidade.Anunciante;
import br.edu.ifnmg.Radio.Entidade.Mensalidade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WellisonTiago
 */
public class MensalidadeDAO {

    private static final String SQL_INSERT = "INSERT INTO MENSALIDADE (VENCIMENTO,DATAPAGAMENTO,IDANUNCIANTE,IDDIRETOR_DONO,VALOR) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT IDMENSALIDADE,VENCIMENTO,DATAPAGAMENTO,IDANUNCIANTE,IDDIRETOR_DONO,VALOR FROM MENSALIDADE ORDER BY VALOR DESC ";
    private static final String SQL_VIEW_MENSALIDADES = "SELECT * FROM MENSALIDADES";
    private static final String SQL_VIEW_VALORANO = "SELECT * FROM VALORANO";
    private static final String SQL_UPDATE = "UPDATE MENSALIDADE SET VENCIMENTO = ?, DATAPAGAMENTO = ?, IDANUNCIANTE = ?, IDDIRETOR_DONO =?, VALOR = ? WHERE IDMENSALIDADE = ? ";
    private static final String SQL_DELETE = "DELETE FROM MENSALIDADE WHERE IDMENSALIDADE = ?";
    private static final String SQL_MensalidadePorMes ="SELECT sum(Valor) as valor,EXTRACT(MONTH FROM datapagamento) as Mes,EXTRACT(YEAR FROM datapagamento) as ANO FROM mensalidade GROUP BY ANO,MES ORDER BY  ANO DESC";
;
    private static final String SQL_Mes = "SELECT EXTRACT(MONTH FROM datapagamento) as Mes FROM mensalidade GROUP BY Mes ORDER BY Mes";
    private static final String SQL_Ano = "SELECT EXTRACT(YEAR FROM datapagamento) as ANO FROM mensalidade GROUP BY ANO ORDER BY ANO ";
    private static final String SQL_A = "SELECT * FROM A";
    private static final String SQL_M = "SELECT * FROM M";
    private static final String SQL_S = "SELECT * FROM S";
    
    public void criar(Mensalidade mensalidade) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            java.sql.Date sqldate = new java.sql.Date(mensalidade.getVencimento().getTime());
            java.sql.Date sqldat = new java.sql.Date(mensalidade.getDataPagamento().getTime());
            comando.setDate(1, sqldate);
            comando.setDate(2, sqldat);
            comando.setInt(3, mensalidade.getIdAnunciante());
            comando.setInt(4, mensalidade.getIdDiretor_Dono());
            comando.setDouble(5, mensalidade.getValor());

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

    public void alterar(Mensalidade mensalidade) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            //comando.setInt(2, ID);
            java.sql.Date sqldate = new java.sql.Date(mensalidade.getVencimento().getTime());
            java.sql.Date sqldat = new java.sql.Date(mensalidade.getDataPagamento().getTime());
            comando.setDate(1, sqldate);
            comando.setDate(2, sqldat);
            comando.setInt(3, mensalidade.getIdAnunciante());
            comando.setInt(4, mensalidade.getIdDiretor_Dono());
            comando.setDouble(5, mensalidade.getValor());
            comando.setInt(6, mensalidade.getIdMensalidade());
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

    public List<Mensalidade> buscarTodos() throws SQLException {
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
        return listaMensalidade;
    }

    public List<Mensalidade> Valor_Ano() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_VIEW_VALORANO);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();

                mensalidade.setValor(resultado.getDouble(1));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);

            }
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
        return listaMensalidade;
    }

    // exbir o Ano 
    public List<Mensalidade> Ano() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_Ano);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();

                mensalidade.setValor(resultado.getDouble(1));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);

            }
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
        return listaMensalidade;
    }

    public List<Mensalidade> Valor_Mes() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_S);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();

                mensalidade.setValor(resultado.getDouble(1));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);

            }
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
        return listaMensalidade;
    }


    
    // retorna o ano
    public List<Mensalidade> ValorPorAno() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_A);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();

                mensalidade.setValor(resultado.getDouble(1));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);

            }
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
        return listaMensalidade;
    }
    
        public List<Mensalidade> ValorPorMes() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Mensalidade> listaMensalidade = new ArrayList<Mensalidade>();

        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_M);
//Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
//O método next retornar boolean informando se existe um próximo
//elemento para iterar
            while (resultado.next()) {
//Instancia um novo objeto e atribui os valores vindo do BD
//(Note que no BD o index inicia por 1)
                Mensalidade mensalidade = new Mensalidade();

                mensalidade.setValor(resultado.getDouble(1));

//Adiciona um item à lista que será retornada
                listaMensalidade.add(mensalidade);

            }
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
        return listaMensalidade;
    }
   
    public void excluir(Mensalidade mensalidade) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, mensalidade.getIdMensalidade());

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
