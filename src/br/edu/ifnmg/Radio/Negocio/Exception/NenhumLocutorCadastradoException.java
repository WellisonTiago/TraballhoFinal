/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Negocio.Exception;

/**
 *
 * @author WellisonTiago
 */
public class NenhumLocutorCadastradoException  extends Exception {
    
     public NenhumLocutorCadastradoException (){
        
        super("Não e possivel cadastrar Porgrama: Nenhum Locutor Cadastrado");
        
        
    }
    
}
