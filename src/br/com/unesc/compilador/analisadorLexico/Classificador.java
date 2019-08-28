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

    String literalSalvo = "";
    Boolean isLiteral = false;
    Boolean isComentario = false;
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
            if (this.isLiteral) {
                palavra.append(this.literalSalvo);
                while (this.isLiteral) {
                    if (!pilha.get(i).equals('\'')) {
                        if (i == pilha.size() - 1) {
                            return;
                        }
                    }
                    palavra.append(pilha.get(i));
                    if (!(i == pilha.size() - 1)) {
                        i++;
                    }else{
                        this.isLiteral = false;
                    }
                }
                classificaPalavra(palavra.toString());
                palavra = new StringBuilder();
                this.isLiteral = false;
                if (i == pilha.size() - 1) {
                    return;
                }
            }
            /*
                Verificação de comentário:
                No caso da pilha conter os caracteres ( e * seguidos, o classificador
                Irá entrar em loop até que seja encontrado um * sucedido de )
                Inclusive passando para as próximas linhas.
             */
            if (pilha.get(i).equals('(')) {
                if (pilha.get(i + 1).equals('*')) {
                    this.isComentario = true;
                    i++;
                }
            }

            while (this.isComentario) {
                if (i == pilha.size() - 1) {
                    return;
                }

                if (pilha.get(i).equals('*') && pilha.get(i + 1).equals(')')) {
                    this.isComentario = false;
                    i++;
                    if (i == pilha.size() - 1) {
                        return;
                    }
                    i++;
                }
                if (this.isComentario) {
                    i++;
                }
            }

            /* 
                Verificação das palavras reservadas: <> e <=
                Se a pilha conter o caractér < verifica a próxima posição para assim atender
                o caso da palavra reservada <> e <=, a mesma situação ocorre em caso o buffer
                conter esse caractér.
             */
            if (!(i == pilha.size() - 1)) {
                if (pilha.get(i).equals('<') && (pilha.get(i++).equals('>') || pilha.get(i++).equals('=')) || (palavra.toString().equals("<") && (pilha.get(i).equals('>') || pilha.get(i).equals('=')))) {
                    if (palavra.toString().equals("")) {
                        palavra.append(pilha.get(i));
                        i++;
                        palavra.append(pilha.get(i));
                    } else {
                        palavra.append(pilha.get(i));
                    }

                    if (i != pilha.size() - 1) {
                        i++;
                    } else {
                        return;
                    }
                }
            }

            /* 
                Verificação da palavra reservada: >=
                Se a pilha conter o caractér > verifica a próxima posição para assim atender
                o caso da palavra reservada >=, a mesma situação ocorre em caso o buffer
                conter esse caractér.
             */
            if (!(i == pilha.size() - 1)) {
                if (pilha.get(i).equals('>') && pilha.get(i++).equals('=') || (palavra.toString().equals(">") && pilha.get(i).equals('='))) {
                    if (palavra.toString().equals("")) {
                        palavra.append(pilha.get(i));
                        i++;
                        palavra.append(pilha.get(i));
                    } else {
                        palavra.append(pilha.get(i));
                    }

                    if (i != pilha.size() - 1) {
                        i++;
                    } else {
                        return;
                    }
                }
            }

            /* 
                Verificação da palavra reservada: ..
                Se a pilha conter o caractér . verifica a próxima posição para assim atender
                o caso da palavra reservada .., a mesma situação ocorre em caso o buffer
                conter esse caractér.
             */
            if (!(i == pilha.size() - 1)) {
                if (palavra.equals("") && pilha.get(i).equals('.') && pilha.get(i++).equals('.') || (palavra.toString().equals(".") && pilha.get(i).equals('.'))) {
                    if (palavra.toString().equals("")) {
                        palavra.append(pilha.get(i));
                        i++;
                        palavra.append(pilha.get(i));
                    } else {
                        palavra.append(pilha.get(i));
                    }

                    if (i != pilha.size() - 1) {
                        i++;
                    } else {
                        return;
                    }
                }
            }

            /*
                Esta parte do código faz a verificação se a pilha ou o buffer encontrou um delimitador
             */
            if (isDelimitador((char) pilha.get(i)) || palavra.length() != 0 && isDelimitador((char) palavra.charAt(0))) {
                if (palavra.length() != 0 && !pilha.get(i).equals('_')) {
                    classificaPalavra(palavra.toString());
                    palavra = new StringBuilder();
                }

                while (pilha.get(i).equals('\t') && (i != pilha.size() - 1)) {
                    i++;
                }

                if (pilha.get(i).equals('\t') && (i == pilha.size() - 1)) {
                    return;
                }

                if (pilha.get(i).equals(' ') && (i != pilha.size() - 1)) {
                    i++;
                }
            }

            /*
                Pode ocorrer de no processo acima ser incrementado o inicio de um comentário
                E para que o mesmo não seja classificado é feito uma nova validação.
             */
            if (pilha.get(i).equals('(')) {
                if (pilha.get(i + 1).equals('*')) {
                    i++;
                    i++;
                    while (!pilha.get(i).equals('*')) {
                        i++;
                    }
                    i++;
                    if (pilha.get(i).equals(')') && (i != pilha.size() - 1)) {
                        i++;
                    }
                    if (i == pilha.size() - 1) {
                        return;
                    }
                };
            }

            /*
                Verificação de literais:
                Caso for encontado o caracter ' o buffer irá ser carregado até encontrar um novo '
                Do contrário é passado para próxima linha.
             */
            if (pilha.get(i).equals('\'')) {
                this.isLiteral = true;
                palavra.append(pilha.get(i));
                i++;
                while (!pilha.get(i).equals('\'')) {
                    /*
                        Caso for o ultimo elemento deve ir para próxima linha
                        Até cair na verificação de cima.
                     */
                    if (i == pilha.size() - 1) {
                        palavra.append(pilha.get(i));
                        this.literalSalvo = palavra.toString();
                        return;
                    }
                    palavra.append(pilha.get(i));
                    i++;
                }
                palavra.append(pilha.get(i));
                classificaPalavra(palavra.toString());
                palavra = new StringBuilder();
                this.isLiteral = false;

                if (i == pilha.size() - 1) {
                    return;
                } else {
                    i++;
                }
            }

            palavra.append(pilha.get(i));

            if (i == pilha.size() - 1) {
                if (palavra.toString().equals("")) {
                    return;
                }
                classificaPalavra(palavra.toString());
                palavra = new StringBuilder();
            }
        }
    }

    private Boolean isDelimitador(char token) {
        return this.delimitadores.contains(String.valueOf(token));
    }

    private Boolean isPalavraReservada(String palavra) {
        return this.palavrasReservadas.containsValue(palavra.toUpperCase());
    }

    private void classificaPalavra(String palavra) {
        if (palavra.equals(" ")) {
            return;
        }

        if (isPalavraReservada(palavra)) {
            palavra = palavra.toUpperCase();
        }

        Token newToken = new Token();
        newToken.setCodigo(this.palavrasReservadas.getCodigo(palavra));
        newToken.setPalavra(palavra);
        tokens.push(newToken);
    }
}
