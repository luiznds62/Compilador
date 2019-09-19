/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador.analisadorLexico;

import java.util.List;

/**
 *
 * @author Luiz Henrique
 */
public class TabelaParsing {
    int codigoNaoTerminal;
    int codigoTerminal;
    int[] derivacoes;

    public int getCodigoNaoTerminal() {
        return codigoNaoTerminal;
    }

    public void setCodigoNaoTerminal(Integer codigoNaoTerminal) {
        this.codigoNaoTerminal = codigoNaoTerminal;
    }

    public int getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(Integer codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
    }

    public int[] getDerivacoes() {
        return derivacoes;
    }

    public void setDerivacoes(int[] derivacoes) {
        this.derivacoes = derivacoes;
    }

    public TabelaParsing() {
    }

    public TabelaParsing(int codigoNaoTerminal, int codigoTerminal, int[] derivacoes) {
        this.codigoNaoTerminal = codigoNaoTerminal;
        this.codigoTerminal = codigoTerminal;
        this.derivacoes = derivacoes;
    }
}
