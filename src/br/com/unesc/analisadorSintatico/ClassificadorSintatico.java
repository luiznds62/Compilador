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

    public Stack<Token> classificaSintatico(Stack<Token> lexico) throws Exception {
        Stack<Token> pilhaAuxiliar = new Stack();
        TabelaParsing M = new TabelaParsing();
        Stack<Token> X = new Stack();

        X.push(new Token(52, "PROGRAMA"));

        Token entrada = null;
        while (!X.isEmpty()) {

            entrada = lexico.get(0);

            // Se X é terminal
            if (X.get(0).getCodigo() < 52) {
                if (X.get(0).getCodigo() == entrada.getCodigo()) {
                    X.remove(0);
                    lexico.remove(0);
                } else {
                    throw new Exception("A derivação ["+ entrada.getCodigo()  + "," + X.get(0).getCodigo() + "] '" + X.get(0).getPalavra() + "," + entrada.getPalavra() + "' não existe na tabela de Parsing");
                }
            } else {
                List<Token> listaDerivacoes = M.valida(entrada, X.get(0));
                if (!listaDerivacoes.isEmpty()) {
                    X.remove(0);
                    if (!X.isEmpty()) {
                        for(Token prod: X){
                            pilhaAuxiliar.push(prod);
                        }
                        X.clear();
                    }
                    for (Token prod : listaDerivacoes) {
                        X.push(prod);
                    }
                    if (!pilhaAuxiliar.isEmpty()) {
                        for (Token prod : pilhaAuxiliar) {
                            X.push(prod);
                        }
                        pilhaAuxiliar.clear();
                    }
                } else{
                    X.remove(0);
                }
            }
        }
        return X;
    }
}
