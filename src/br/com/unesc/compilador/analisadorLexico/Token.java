/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador.analisadorLexico;

/**
 *
 * @author Luiz Henrique
 */
public class Token {

    private Integer codigo;
    private String palavra;

    public Token() {

    }

    public Token(Integer codigo, String palavra) {
        this.codigo = codigo;
        this.palavra = palavra;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public String toString() {
        return "Token{" + "codigo=" + codigo + ", palavra=" + palavra + '}';
    }
}
