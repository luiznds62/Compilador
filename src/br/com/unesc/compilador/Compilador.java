/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador;

import br.com.unesc.analisadorSintatico.ClassificadorSintatico;
import br.com.unesc.compilador.analisadorLexico.ClassificadorLexico;
import br.com.unesc.compilador.analisadorLexico.Token;
import br.com.unesc.utilidades.ManipuladorArquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Henrique
 */
public class Compilador {

    ArrayList<String[]> linhas = new ArrayList<String[]>();
    ClassificadorLexico classificadorLexico = new ClassificadorLexico();
    ClassificadorSintatico classificadorSintatico = new ClassificadorSintatico();
    ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

    Stack<Token> classificarLexico(String path) throws Exception {
        List<String> arquivo = leArquivo(path);
        Stack<Token> pilhaTokens = mandaClassificar(arquivo);

        return pilhaTokens;
    }
    
    void classificarSintatico(Stack<Token> dadosLexico) throws Exception{
        classificadorSintatico.classificaSintatico(dadosLexico);
    }

    List<String> leArquivo(String path) {
        return this.manipuladorArquivo.lerEspecial(path);
    }

    Stack<Token> mandaClassificar(List<String> arquivo) throws Exception {
        return this.classificadorLexico.classificar(arquivo);
    }
}
