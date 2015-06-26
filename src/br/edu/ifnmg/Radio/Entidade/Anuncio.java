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
public class Anuncio {
    
   private int idAnuncio;
   private String descricao;
   private int quanPorDia;
   private Date inicoAnuncio;
   private Date encerramentoAnuncio;
   private int idAnunciante;
   Anunciante anunciante;

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int IdAnunciante) {
        this.idAnunciante = IdAnunciante;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String Descricao) {
        this.descricao = Descricao;
    }

    public int getQuanPorDia() {
        return quanPorDia;
    }

    public void setQuanPorDia(int QuanPorDia) {
        this.quanPorDia = QuanPorDia;
    }

    public Date getInicoAnuncio() {
        return inicoAnuncio;
    }

    public void setInicoAnuncio(Date InicoAnuncio) {
        this.inicoAnuncio = InicoAnuncio;
    }

    public Date getEncerramentoAnuncio() {
        return encerramentoAnuncio;
    }

    public void setEncerramentoAnuncio(Date EncerramentoAnuncio) {
        this.encerramentoAnuncio = EncerramentoAnuncio;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante Anunciante) {
        this.anunciante = Anunciante;
    }

   
    public String getDataFormatadaEncerramento(){
        String data;
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        data = dt.format(this.encerramentoAnuncio);
        return data;
    }
   
    
}
