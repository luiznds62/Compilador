/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Henrique
 */
public class ManipuladorArquivo {

    public List<String> lerEspecial(String path) {
        Path text_path = Paths.get(path);
        String palavra;
        try {
            List<String> FullText = Files.readAllLines(text_path);
            return FullText;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static StringBuilder ler(String path) throws FileNotFoundException, IOException {
        StringBuilder result = new StringBuilder();
        FileInputStream arq = null;
        try {
            File f = new File(path);
            arq = new FileInputStream(f);
            int caracterLido = arq.read();

            while (caracterLido != -1) {
                result.append((char) caracterLido);
                caracterLido = arq.read();
            }
        } finally {
            if (arq != null) {
                arq.close();
            }
        }
        return result;
    }

    public static void gravar(String path, String str) throws FileNotFoundException, IOException {
        FileOutputStream arq = null;
        PrintStream ps = null;
        try {
            File f = new File(path);
            arq = new FileOutputStream(f);

            try {
                ps = new PrintStream(arq);
                ps.println(str);
            } finally {
                if (ps == null) {
                    ps.close();
                }
            }
        } finally {
            if (arq != null) {
                arq.close();
            }
        }
    }
}
