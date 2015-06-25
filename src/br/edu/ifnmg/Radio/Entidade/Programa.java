/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Entidade;

/**
 *
 * @author WellisonTiago
 */
public class Programa {
    
    private int idPrograma ;
    private String  Nome;
    private int idAdim; 

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdAdim() {
        return idAdim;
    }

    public void setIdAdim(int idAdim) {
        this.idAdim = idAdim;
    }
    
     
}
