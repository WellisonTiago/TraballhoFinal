/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Radio.Apresentacao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author WellisonTiago
 */
public class Codificação {
    
    
        public String ConvertHexadecimalParaString(byte[] ValorHexadecimal) {
        StringBuilder valorConvertido = new StringBuilder();
        for (byte caracter : ValorHexadecimal) {
            valorConvertido.append(String.format("%02X", 0xFF & caracter));

        }
        return valorConvertido.toString();
    }

    public String Criptografia(String texto ) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
       
        MessageDigest algoritmo = MessageDigest.getInstance("MD5");
        byte[] codigoHashHexaDecimal
                = algoritmo.digest(texto.getBytes("UTF-8"));
       String codigoHashFinal 
               = ConvertHexadecimalParaString(codigoHashHexaDecimal);
       // System.out.println(codigoHashFinal);
       return codigoHashFinal;
    }
    
    
}
