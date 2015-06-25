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
   private String Descricao;
   private int QuanPorDia;
   private Date InicoAnuncio;
   private Date EncerramentoAnuncio;
   private int IdAnunciante;
   Anunciante Anunciante;

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public int getIdAnunciante() {
        return IdAnunciante;
    }

    public void setIdAnunciante(int IdAnunciante) {
        this.IdAnunciante = IdAnunciante;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getQuanPorDia() {
        return QuanPorDia;
    }

    public void setQuanPorDia(int QuanPorDia) {
        this.QuanPorDia = QuanPorDia;
    }

    public Date getInicoAnuncio() {
        return InicoAnuncio;
    }

    public void setInicoAnuncio(Date InicoAnuncio) {
        this.InicoAnuncio = InicoAnuncio;
    }

    public Date getEncerramentoAnuncio() {
        return EncerramentoAnuncio;
    }

    public void setEncerramentoAnuncio(Date EncerramentoAnuncio) {
        this.EncerramentoAnuncio = EncerramentoAnuncio;
    }

    public Anunciante getAnunciante() {
        return Anunciante;
    }

    public void setAnunciante(Anunciante Anunciante) {
        this.Anunciante = Anunciante;
    }

   
    public String getDataFormatadaEncerramento(){
        String data;
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        data = dt.format(this.EncerramentoAnuncio);
        return data;
    }
   
    
}
