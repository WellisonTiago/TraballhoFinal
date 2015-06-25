/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Entidade;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WellisonTiago
 */
public class Mensalidade {

    private int idMensalidade;
    private Date vencimento;
    private Date dataPagamento;
    private double valor;
    private int idAnunciante;
    private Anunciante anunciante;
    private int idDiretor_Dono;

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public int getIdMensalidade() {
        return idMensalidade;
    }

    public void setIdMensalidade(int idMensalidade) {
        this.idMensalidade = idMensalidade;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date Vencimento) {
        this.vencimento = Vencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date DataPagamento) {
        this.dataPagamento = DataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double Valor) {
        this.valor = Valor;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }

    public int getIdDiretor_Dono() {
        return idDiretor_Dono;
    }

    public void setIdDiretor_Dono(int idDiretor_Dono) {
        this.idDiretor_Dono = idDiretor_Dono;
    }

    public String getDataFormatadaPagamento() {
        String data;
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        data = dt.format(this.dataPagamento);
        return data;
    }

    public String getDataFormatadaVencimento() {
        String data;
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        data = dt.format(this.vencimento);
        return data;
    }

}
