/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.analisadorSintatico;

import br.com.unesc.compilador.analisadorLexico.Token;
import br.com.unesc.utilidades.TabelaParsing;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Luiz Henrique
 */
public class ClassificadorSintatico {

    public void classificaSintatico(Stack<Token> lexico) throws Exception {
        TabelaParsing M = new TabelaParsing();
        Stack<Token> X = new Stack();

        X.push(new Token(52, "PROGRAMA"));

        int i = 0;
        Token entrada = null;
        while (!X.isEmpty()) {

            entrada = lexico.get(i);

            for(int j = 0 ; j < X.size(); j++){
                // Se X é terminal
                if (X.get(j).getCodigo() < 52) {
                    if (X.get(j).getCodigo() == entrada.getCodigo()) {
                        X.pop();
                        lexico.pop();
                    }
                } else {
                    List<Token> listaDerivacoes = M.valida(entrada, X.get(j));
                    if(!listaDerivacoes.isEmpty()){
                        X.pop();
                        for(Token prod: listaDerivacoes){
                            X.push(prod);
                        }
                    }else{
                        throw new Exception("Errou mermão");
                    }
                }
            }
        }
    }
}
