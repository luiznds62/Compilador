/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Luiz Henrique
 */
public class Arquivos {

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
