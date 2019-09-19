/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador.analisadorSintatico;

import br.com.unesc.compilador.analisadorLexico.TabelaParsing;
import br.com.unesc.compilador.analisadorLexico.Token;
import java.util.Stack;

/**
 *
 * @author Luiz Henrique
 */
public class ClassificadorSintatico {
    
    public void analiseSintatica(Stack<Token> terminais,Stack<Token> naoTerminais,Stack<TabelaParsing> tabelaParsing){
        for(int i = 0; i < tabelaParsing.size(); i++){
            String x = "";
        }
    }
}
