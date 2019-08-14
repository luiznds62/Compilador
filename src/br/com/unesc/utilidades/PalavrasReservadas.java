/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.utilidades;

import java.util.HashMap;

/**
 *
 * @author Luiz Henrique
 */
public class PalavrasReservadas extends HashMap<Integer, String> {

    public Integer getCodigo(String value) {
        int retorno = 25;
        
        if(isInteger(value)) return 26;
        
        if (this.containsValue(value)) {
            retorno = this.entrySet()
                    .stream()
                    .filter(v -> v.getValue().equals(value))
                    .findFirst()
                    .get()
                    .getKey();
        }
        return retorno;
    }

    private Boolean isInteger(String value) {
        Boolean isInteger = false;
        int valor = 0;
        try {
            valor = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Valor não é inteiro");
        }
        return valor != 0;
    }
}
