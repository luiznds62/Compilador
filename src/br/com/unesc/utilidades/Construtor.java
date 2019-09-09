/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Henrique
 */
public class Construtor {

    public static PalavrasReservadas construirPalavrasReservadas() {
        PalavrasReservadas palavrasReservadas = new PalavrasReservadas();
        palavrasReservadas.put(1, "PROGRAM");
        palavrasReservadas.put(2, "LABEL");
        palavrasReservadas.put(3, "CONST");
        palavrasReservadas.put(4, "VAR");
        palavrasReservadas.put(5, "PROCEDURE");
        palavrasReservadas.put(6, "BEGIN");
        palavrasReservadas.put(7, "END");
        palavrasReservadas.put(8, "INTEGER");
        palavrasReservadas.put(9, "ARRAY");
        palavrasReservadas.put(10, "OF");
        palavrasReservadas.put(11, "CALL");
        palavrasReservadas.put(12, "GOTO");
        palavrasReservadas.put(13, "IF");
        palavrasReservadas.put(14, "THEN");
        palavrasReservadas.put(15, "ELSE");
        palavrasReservadas.put(16, "WHILE");
        palavrasReservadas.put(17, "DO");
        palavrasReservadas.put(18, "REPEAT");
        palavrasReservadas.put(19, "UNTIL");
        palavrasReservadas.put(20, "READLN");
        palavrasReservadas.put(21, "WRITELN");
        palavrasReservadas.put(22, "OR");
        palavrasReservadas.put(23, "AND");
        palavrasReservadas.put(24, "NOT");
        palavrasReservadas.put(25, "IDENTIFICADOR");
        palavrasReservadas.put(26, "INTEIRO");
        palavrasReservadas.put(27, "FOR");
        palavrasReservadas.put(28, "TO");
        palavrasReservadas.put(29, "CASE");
        palavrasReservadas.put(30, "+");
        palavrasReservadas.put(31, "-");
        palavrasReservadas.put(32, "*");
        palavrasReservadas.put(33, "/");
        palavrasReservadas.put(34, "[");
        palavrasReservadas.put(35, "]");
        palavrasReservadas.put(36, "(");
        palavrasReservadas.put(37, ")");
        palavrasReservadas.put(38, ":=");
        palavrasReservadas.put(39, ":");
        palavrasReservadas.put(40, "=");
        palavrasReservadas.put(41, ">");
        palavrasReservadas.put(42, ">=");
        palavrasReservadas.put(43, "<");
        palavrasReservadas.put(44, "<=");
        palavrasReservadas.put(45, "<>");
        palavrasReservadas.put(46, ",");
        palavrasReservadas.put(47, ";");
        palavrasReservadas.put(48, "LITERAL");
        palavrasReservadas.put(49, ".");
        palavrasReservadas.put(50, "..");
        //palavrasReservadas.put(51, "$");
        return palavrasReservadas;
    }

    public static List<String> construirDelimitadores() {
        List<String> delimitadores = new ArrayList();
        delimitadores.add("\t");
        delimitadores.add("+");
        delimitadores.add("-");
        delimitadores.add("*");
        delimitadores.add("/");
        delimitadores.add("=");
        delimitadores.add("<");
        delimitadores.add(">");
        delimitadores.add(",");
        delimitadores.add(";");
        delimitadores.add(".");
        delimitadores.add("(");
        delimitadores.add(")");
        delimitadores.add(":");
        delimitadores.add("[");
        delimitadores.add("]");
        delimitadores.add("_");
        delimitadores.add(" ");
        return delimitadores;
    }
}
