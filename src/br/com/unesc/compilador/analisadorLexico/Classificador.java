/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador.analisadorLexico;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Luiz Henrique
 */
public class Classificador {

    ArrayList<String> delimitadores = new ArrayList<>();
    Stack<Token> tokens = new Stack<>();

    public Stack<Token> classificar(List<String> arquivo) {
        construirDelimitadores();

        arquivo.forEach((linha) -> {
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
    
    private void desenpilharPalavras(Stack pilha){
        String palavra = "";
        for(int i = 0; i < pilha.size(); i++){
            // Verificação de comentários
            if(pilha.get(i).equals('(')){
                if(pilha.get(i+1).equals('*')){
                    i++;
                    i++;
                    while(!pilha.get(i).equals(')')){
                        i++;
                    }
                    if(pilha.get(i).equals(')')){
                        i++;
                    }
                }
            }
            
            if(isDelimitador((char) pilha.get(i))){
                i++;
            }
            
            palavra.concat((String) pilha.get(i));
            
            System.out.println(pilha.get(i));
        }
    }

    private Boolean isDelimitador(char token) {
        return this.delimitadores.contains(token);
    }

    private void construirDelimitadores() {
        this.delimitadores.add("+");
        this.delimitadores.add("-");
        this.delimitadores.add("*");
        this.delimitadores.add("/");
        this.delimitadores.add("=");
        this.delimitadores.add("<");
        this.delimitadores.add(">");
        this.delimitadores.add(",");
        this.delimitadores.add(";");
        this.delimitadores.add(".");
        this.delimitadores.add("(");
        this.delimitadores.add(")");
        this.delimitadores.add(":");
        this.delimitadores.add("[");
        this.delimitadores.add("]");
        this.delimitadores.add("_");
        this.delimitadores.add(" ");
    }
}
