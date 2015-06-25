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
public class Anunciante {
    
   private int idAnunciante ;
   private String nome ;
   private String cpf ;
   private String telefone ;
   private String bairro ;
   private String  rua ;
   private String cidade ;
   private int numResidencia ;

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String Telefone) {
        this.telefone = Telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String Bairro) {
        this.bairro = Bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String Rua) {
        this.rua = Rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    public int getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(int NumResidencia) {
        this.numResidencia = NumResidencia;
    }
    
   
}
