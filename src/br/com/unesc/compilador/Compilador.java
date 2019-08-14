/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.compilador;

import br.com.unesc.compilador.analisadorLexico.Classificador;
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
    Classificador classificador = new Classificador();
    ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

    void Compilar() {
        String path = "D:\\compiladores\\codigo1.txt";
        List<String> arquivo = leArquivo(path);
        Stack<Token> pilhaTokens = mandaClassificar(arquivo);
        
        System.out.println(pilhaTokens);
    }

    List<String> leArquivo(String path) {
        return this.manipuladorArquivo.lerEspecial(path);
    }
    
    Stack<Token> mandaClassificar(List<String> arquivo){
        return this.classificador.classificar(arquivo);
    }
}