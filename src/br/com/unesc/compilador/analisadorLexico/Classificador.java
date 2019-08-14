/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador.analisadorLexico;

import br.com.unesc.utilidades.Construtor;
import br.com.unesc.utilidades.PalavrasReservadas;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Luiz Henrique
 */
public class Classificador {

    PalavrasReservadas palavrasReservadas;
    List<String> delimitadores;
    Stack<Token> tokens;

    public Classificador() {
        palavrasReservadas = Construtor.construirPalavrasReservadas();
        delimitadores = Construtor.construirDelimitadores();
        tokens = new Stack<>();
    }

    public Stack<Token> classificar(List<String> arquivo) {
        arquivo.forEach((linha) -> {
            if(linha.equals("\t")) return;
            tokenizarLinha(linha);
        });
        return this.tokens;
    }

    private void tokenizarLinha(String linha) {
        Stack palavra = new Stack();
        for (char token : linha.toCharArray()) {
            palavra.push(token);
        }
        desenpilharPalavras(palavra);
    }

    private void desenpilharPalavras(Stack pilha) {
        StringBuilder palavra = new StringBuilder();
        for (int i = 0; i < pilha.size(); i++) {
            // Verificação de comentários
            if (pilha.get(i).equals('(')) {
                if (pilha.get(i + 1).equals('*')) {
                    i++;
                    i++;
                    while (!pilha.get(i).equals(')')) {
                        i++;
                    }
                    if (pilha.get(i).equals(')')) {
                        i++;
                    }
                }
            }

            if (isDelimitador((char) pilha.get(i))) {
                if (palavra.length() != 0 && !pilha.get(i).equals('_')) {
                    classificaPalavra(palavra.toString());
                    palavra = new StringBuilder();
                }
                
                while(pilha.get(i).equals('\t')){
                    i++;
                }
                
                if (pilha.get(i).equals(' ') && (i != pilha.size() -1)) {
                    i++;
                }
            }

            palavra.append(pilha.get(i));
            if(i == pilha.size() -1){
                if(!palavra.toString().equals("")) return;
                classificaPalavra(palavra.toString());
                palavra = new StringBuilder();
            }
        }
    }

    private Boolean isDelimitador(char token) {
        return this.delimitadores.contains(String.valueOf(token));
    }

    private void classificaPalavra(String palavra) {
        Token newToken = new Token();
        newToken.setCodigo(this.palavrasReservadas.getCodigo(palavra));
        newToken.setPalavra(palavra);
        tokens.push(newToken);
    }
}
