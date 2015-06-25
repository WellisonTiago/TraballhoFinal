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
public class Admin {
    
    private int idAdmin;
    private String nome;
    private String senha;

    public int getIdAdim() {
        return idAdmin;
    }

    public void setIdAdim(int IdAdim) {
        this.idAdmin = IdAdim;
    }

    public String getnome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    
    
    
}
