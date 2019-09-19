/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unesc.utilidades;

import br.com.unesc.compilador.analisadorLexico.TabelaParsing;
import br.com.unesc.compilador.analisadorLexico.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static Stack<Token> construirNaoTerminais() {
        Stack<Token> naoTerminais = new Stack<>();
        naoTerminais.push(new Token(52, "PROGRAMA", 0, false));
        naoTerminais.push(new Token(53, "BLOCO", 0, false));
        naoTerminais.push(new Token(54, "DCLROT", 0, false));
        naoTerminais.push(new Token(55, "LID", 0, false));
        naoTerminais.push(new Token(56, "REPIDENT", 0, false));
        naoTerminais.push(new Token(57, "DCLCONST", 0, false));
        naoTerminais.push(new Token(58, "LDCONST", 0, false));
        naoTerminais.push(new Token(59, "DCLVAR", 0, false));
        naoTerminais.push(new Token(60, "LDVAR", 0, false));
        naoTerminais.push(new Token(61, "TIPO", 0, false));
        naoTerminais.push(new Token(62, "DCLPROC", 0, false));
        naoTerminais.push(new Token(63, "DEFPAR", 0, false));
        naoTerminais.push(new Token(64, "CORPO", 0, false));
        naoTerminais.push(new Token(65, "REPCOMANDO", 0, false));
        naoTerminais.push(new Token(66, "COMANDO", 0, false));
        naoTerminais.push(new Token(67, "RCOMID", 0, false));
        naoTerminais.push(new Token(68, "RVAR", 0, false));
        naoTerminais.push(new Token(69, "PARAMETROS", 0, false));
        naoTerminais.push(new Token(70, "REPPAR", 0, false));
        naoTerminais.push(new Token(71, "ELSEPARTE", 0, false));
        naoTerminais.push(new Token(72, "VARIAVEL", 0, false));
        naoTerminais.push(new Token(73, "VARIAVEL1", 0, false));
        naoTerminais.push(new Token(74, "REPVARIAVEL", 0, false));
        naoTerminais.push(new Token(75, "ITEMSAIDA", 0, false));
        naoTerminais.push(new Token(76, "REPITEM", 0, false));
        naoTerminais.push(new Token(77, "EXPRESSAO", 0, false));
        naoTerminais.push(new Token(78, "REPEXPSIMP", 0, false));
        naoTerminais.push(new Token(79, "EXPSIMP", 0, false));
        naoTerminais.push(new Token(80, "REPEXP", 0, false));
        naoTerminais.push(new Token(81, "TERMO", 0, false));
        naoTerminais.push(new Token(82, "REPTERMO", 0, false));
        naoTerminais.push(new Token(83, "FATOR", 0, false));
        naoTerminais.push(new Token(84, "CONDCASE", 0, false));
        naoTerminais.push(new Token(85, "CONTCASE", 0, false));
        naoTerminais.push(new Token(86, "RPINTEIRO", 0, false));
        naoTerminais.push(new Token(87, "SEM EFEITO", 0, false));
        return naoTerminais;
    }
    
    public static Stack<TabelaParsing> construirTabelaParsing(){
        Stack<TabelaParsing> tabelaParsing = new Stack();

        int[] p1 = {1,25,47,53,49};
        tabelaParsing.push(new TabelaParsing(52,1,p1));
        
        int[] p2 = {54,57,59,62,64};
        tabelaParsing.push(new TabelaParsing(53,2,p2));
        
        int[] p3 = {54,57,59,62,64};
        tabelaParsing.push(new TabelaParsing(53,3,p3));
        
        int[] p4 = {54,57,59,62,64};
        tabelaParsing.push(new TabelaParsing(53,4,p4));
        
        int[] p5 = {54,57,59,62,64};
        tabelaParsing.push(new TabelaParsing(53,5,p5));
        
        int[] p6 = {54,57,59,62,64};
        tabelaParsing.push(new TabelaParsing(53,6,p6));
        
        int[] p7 = {2,55,47};
        tabelaParsing.push(new TabelaParsing(54,2,p7));
        
        int[] p8 = {};
        tabelaParsing.push(new TabelaParsing(54,3,p8));
        
        int[] p9 = {};
        tabelaParsing.push(new TabelaParsing(54,4,p9));
        
        int[] p10 = {};
        tabelaParsing.push(new TabelaParsing(54,5,p10));
        
        int[] p11 = {};
        tabelaParsing.push(new TabelaParsing(54,6,p11));
        
        int[] p12 = {25,56};
        tabelaParsing.push(new TabelaParsing(55,25,p12));
        
        int[] p13 = {};
        tabelaParsing.push(new TabelaParsing(56,39,p13));
        
        int[] p14 = {};
        tabelaParsing.push(new TabelaParsing(56,46,p14));
        
        int[] p15 = {};
        tabelaParsing.push(new TabelaParsing(56,47,p15));
        
        int[] p16 = {3,25,40,26,47,58};
        tabelaParsing.push(new TabelaParsing(57,3,p16));
        
        int[] p17 = {};
        tabelaParsing.push(new TabelaParsing(57,4,p17));
        
        int[] p18 = {};
        tabelaParsing.push(new TabelaParsing(57,5,p18));
        
        int[] p19 = {};
        tabelaParsing.push(new TabelaParsing(57,6,p19));
        
        int[] p20 = {};
        tabelaParsing.push(new TabelaParsing(58,4,p20));
        
        int[] p21 = {};
        tabelaParsing.push(new TabelaParsing(58,5,p21));
        
        int[] p22 = {};
        tabelaParsing.push(new TabelaParsing(58,6,p22));
        
        int[] p23 = {25,40,26,47,58};
        tabelaParsing.push(new TabelaParsing(58,25,p23));
        
        int[] p24 = {4,55,39,61,47};
        tabelaParsing.push(new TabelaParsing(59,4,p24));
        
        int[] p25 = {};
        tabelaParsing.push(new TabelaParsing(59,5,p25));
        
        int[] p26 = {};
        tabelaParsing.push(new TabelaParsing(59,6,p26));
        
        int[] p27 = {};
        tabelaParsing.push(new TabelaParsing(60,5,p27));
        
        int[] p28 = {};
        tabelaParsing.push(new TabelaParsing(60,6,p28));
        
        int[] p29 = {55,39,61,47,60};
        tabelaParsing.push(new TabelaParsing(60,25,p29));
        
        int[] p30 = {};
        tabelaParsing.push(new TabelaParsing(61,8,p30));
        
        int[] p31 = {9,34,26,50,26,35,10,26};
        tabelaParsing.push(new TabelaParsing(61,9,p31));
        
        int[] p32 = {5,25,63,47,53,47,62};
        tabelaParsing.push(new TabelaParsing(62,5,p32));
        
        int[] p33 = {};
        tabelaParsing.push(new TabelaParsing(62,6,p33));
        
        int[] p34 = {36,55,39,26,37};
        tabelaParsing.push(new TabelaParsing(63,36,p34));
        
        int[] p35 = {};
        tabelaParsing.push(new TabelaParsing(63,39,p35));
        
        int[] p36 = {6,66,65,7};
        tabelaParsing.push(new TabelaParsing(64,6,p36));
        
        int[] p37 = {};
        tabelaParsing.push(new TabelaParsing(65,7,p37));
        
        int[] p38 = {47,66,65};
        tabelaParsing.push(new TabelaParsing(65,47,p38));
        
        int[] p39 = {64};
        tabelaParsing.push(new TabelaParsing(66,6,p39));
        
        int[] p40 = {};
        tabelaParsing.push(new TabelaParsing(66,7,p40));
        
        int[] p41 = {11,25,69};
        tabelaParsing.push(new TabelaParsing(66,11,p41));
        
        int[] p42 = {12,25};
        tabelaParsing.push(new TabelaParsing(66,12,p42));
        
        int[] p43 = {13,77,14,66,71};
        tabelaParsing.push(new TabelaParsing(66,13,p43));
        
        int[] p44 = {};
        tabelaParsing.push(new TabelaParsing(66,15,p44));
        
        int[] p45 = {16,77,17,66};
        tabelaParsing.push(new TabelaParsing(66,16,p45));
        
        int[] p46 = {18,66,19,77};
        tabelaParsing.push(new TabelaParsing(66,18,p46));
        
        int[] p47 = {};
        tabelaParsing.push(new TabelaParsing(66,19,p47));
        
        int[] p48 = {20,36,72,74,37};
        tabelaParsing.push(new TabelaParsing(66,20,p48));
        
        int[] p49 = {21,36,75,76,37};
        tabelaParsing.push(new TabelaParsing(66,21,p49));
        
        int[] p50 = {};
        tabelaParsing.push(new TabelaParsing(66,21,p50));
        
        int[] p51 = {25,67};
        tabelaParsing.push(new TabelaParsing(66,25,p51));
        
        int[] p52 = {27,25,38,77,28,77,17,66};
        tabelaParsing.push(new TabelaParsing(66,27,p52));
        
        int[] p53 = {29,77,10,84,7};
        tabelaParsing.push(new TabelaParsing(66,29,p53));
        
        int[] p54 = {};
        tabelaParsing.push(new TabelaParsing(66,47,p54));
        
        int[] p55 = {68,38,77};
        tabelaParsing.push(new TabelaParsing(67,34,p55));
        
        int[] p56 = {68,38,77};
        tabelaParsing.push(new TabelaParsing(67,38,p56));
        
        int[] p57 = {39,66};
        tabelaParsing.push(new TabelaParsing(67,39,p57));
        
        int[] p58 = {34,77,35};
        tabelaParsing.push(new TabelaParsing(68,34,p58));
        
        int[] p59 = {};
        tabelaParsing.push(new TabelaParsing(68,38,p59));
        
        int[] p60 = {};
        tabelaParsing.push(new TabelaParsing(69,7,p60));
        
        int[] p61 = {};
        tabelaParsing.push(new TabelaParsing(69,15,p61));
        
        int[] p62 = {};
        tabelaParsing.push(new TabelaParsing(69,19,p62));
        
        int[] p63 = {36,77,70};
        tabelaParsing.push(new TabelaParsing(69,36,p63));
        
        int[] p64 = {};
        tabelaParsing.push(new TabelaParsing(69,47,p64));
        
        int[] p65 = {};
        tabelaParsing.push(new TabelaParsing(70,37,p65));
        
        int[] p66 = {46,77,70};
        tabelaParsing.push(new TabelaParsing(70,46,p66));
        
        int[] p67 = {};
        tabelaParsing.push(new TabelaParsing(71,7,p67));
        
        int[] p68 = {15,66};
        tabelaParsing.push(new TabelaParsing(71,15,p68));
        
        int[] p69 = {};
        tabelaParsing.push(new TabelaParsing(71,19,p69));
        
        int[] p70 = {};
        tabelaParsing.push(new TabelaParsing(71,47,p70));
        
        int[] p71 = {25,73};
        tabelaParsing.push(new TabelaParsing(72,25,p71));
        
        int[] p72 = {};
        tabelaParsing.push(new TabelaParsing(73,7,p72));
        
        int[] p73 = {};
        tabelaParsing.push(new TabelaParsing(73,10,p73));
        
        int[] p74 = {};
        tabelaParsing.push(new TabelaParsing(73,14,p74));
        
        int[] p75 = {};
        tabelaParsing.push(new TabelaParsing(73,15,p75));
        
        int[] p76 = {};
        tabelaParsing.push(new TabelaParsing(73,17,p76));
        
        int[] p77 = {};
        tabelaParsing.push(new TabelaParsing(73,19,p77));
        
        int[] p78 = {};
        tabelaParsing.push(new TabelaParsing(73,22,p78));
        
        int[] p79 = {};
        tabelaParsing.push(new TabelaParsing(73,23,p79));
        
        int[] p80 = {};
        tabelaParsing.push(new TabelaParsing(73,28,p80));
        
        int[] p81 = {};
        tabelaParsing.push(new TabelaParsing(73,30,p81));
        
        int[] p82 = {};
        tabelaParsing.push(new TabelaParsing(73,31,p82));
        
        int[] p83 = {};
        tabelaParsing.push(new TabelaParsing(73,32,p83));
        
        int[] p84 = {};
        tabelaParsing.push(new TabelaParsing(73,33,p84));
        
        int[] p85 = {34,77,35};
        tabelaParsing.push(new TabelaParsing(73,34,p85));
        
        int[] p86 = {};
        tabelaParsing.push(new TabelaParsing(73,35,p86));
        
        int[] p87 = {};
        tabelaParsing.push(new TabelaParsing(73,37,p87));
        
        int[] p88 = {};
        tabelaParsing.push(new TabelaParsing(73,40,p88));
        
        int[] p89 = {};
        tabelaParsing.push(new TabelaParsing(73,41,p89));
        
        int[] p90 = {};
        tabelaParsing.push(new TabelaParsing(73,42,p90));
        
        int[] p91 = {};
        tabelaParsing.push(new TabelaParsing(73,43,p91));
        
        int[] p92 = {};
        tabelaParsing.push(new TabelaParsing(73,44,p92));
        
        int[] p93 = {};
        tabelaParsing.push(new TabelaParsing(73,45,p93));
        
        int[] p94 = {};
        tabelaParsing.push(new TabelaParsing(73,46,p94));
        
        int[] p95 = {};
        tabelaParsing.push(new TabelaParsing(73,47,p95));
        
        int[] p96 = {};
        tabelaParsing.push(new TabelaParsing(74,37,p96));
        
        int[] p97 = {46,72,74};
        tabelaParsing.push(new TabelaParsing(74,46,p97));
        
        int[] p98 = {77};
        tabelaParsing.push(new TabelaParsing(75,24,p98));
        
        int[] p99 = {77};
        tabelaParsing.push(new TabelaParsing(75,25,p99));
        
        int[] p100 = {77};
        tabelaParsing.push(new TabelaParsing(75,25,p100));
        
        int[] p101 = {77};
        tabelaParsing.push(new TabelaParsing(75,26,p101));
        
        int[] p102 = {77};
        tabelaParsing.push(new TabelaParsing(75,30,p102));
        
        int[] p103 = {77};
        tabelaParsing.push(new TabelaParsing(75,31,p103));
        
        int[] p104 = {77};
        tabelaParsing.push(new TabelaParsing(75,36,p104));
        
        int[] p105 = {48};
        tabelaParsing.push(new TabelaParsing(75,48,p105));
        
        int[] p106 = {};
        tabelaParsing.push(new TabelaParsing(76,37,p106));
        
        int[] p107 = {46,75,76};
        tabelaParsing.push(new TabelaParsing(76,46,p107));
        
        int[] p108 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,24,p108));
        
        int[] p109 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,25,p109));
        
        int[] p110 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,26,p110));
        
        int[] p111 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,30,p111));
        
        int[] p112 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,31,p112));
        
        int[] p113 = {79,78};
        tabelaParsing.push(new TabelaParsing(77,36,p113));
        
        int[] p114 = {};
        tabelaParsing.push(new TabelaParsing(78,7,p114));
        
        int[] p115 = {};
        tabelaParsing.push(new TabelaParsing(78,10,p115));
        
        int[] p116 = {};
        tabelaParsing.push(new TabelaParsing(78,14,p116));
        
        int[] p117 = {};
        tabelaParsing.push(new TabelaParsing(78,15,p117));
        
        int[] p118 = {};
        tabelaParsing.push(new TabelaParsing(78,17,p118));
        
        int[] p119 = {};
        tabelaParsing.push(new TabelaParsing(78,19,p119));
        
        int[] p120 = {};
        tabelaParsing.push(new TabelaParsing(78,28,p120));
        
        int[] p121 = {};
        tabelaParsing.push(new TabelaParsing(78,35,p114));
        
        int[] p122 = {};
        tabelaParsing.push(new TabelaParsing(78,37,p122));
        
        int[] p123 = {40,79};
        tabelaParsing.push(new TabelaParsing(78,40,p123));
        
        int[] p124 = {41,79};
        tabelaParsing.push(new TabelaParsing(78,41,p124));
        
        int[] p125 = {42,79};
        tabelaParsing.push(new TabelaParsing(78,42,p125));
        
        int[] p126 = {43,79};
        tabelaParsing.push(new TabelaParsing(78,43,p126));
        
        int[] p127 = {44,79};
        tabelaParsing.push(new TabelaParsing(78,44,p127));
        
        int[] p128 = {45,79};
        tabelaParsing.push(new TabelaParsing(78,45,p128));
        
        int[] p129 = {};
        tabelaParsing.push(new TabelaParsing(78,46,p129));
        
        int[] p130 = {};
        tabelaParsing.push(new TabelaParsing(78,47,p130));
        
        int[] p131 = {81,80};
        tabelaParsing.push(new TabelaParsing(79,24,p131));
        
        int[] p132 = {81,80};
        tabelaParsing.push(new TabelaParsing(79,25,p132));
        
        int[] p133 = {81,80};
        tabelaParsing.push(new TabelaParsing(79,26,p133));
        
        int[] p134 = {30,81,80};
        tabelaParsing.push(new TabelaParsing(79,30,p134));
        
        int[] p135 = {31,80};
        tabelaParsing.push(new TabelaParsing(79,31,p135));
        
        int[] p136 = {81,80};
        tabelaParsing.push(new TabelaParsing(79,36,p136));
        
        int[] p137 = {};
        tabelaParsing.push(new TabelaParsing(80,7,p137));
        
        int[] p138 = {};
        tabelaParsing.push(new TabelaParsing(80,10,p138));
        
        int[] p139 = {};
        tabelaParsing.push(new TabelaParsing(80,14,p139));
        
        int[] p140 = {};
        tabelaParsing.push(new TabelaParsing(80,15,p140));
        
        int[] p141 = {};
        tabelaParsing.push(new TabelaParsing(80,19,p141));
        
        int[] p142 = {22,81,80};
        tabelaParsing.push(new TabelaParsing(80,22,p142));
        
        int[] p143 = {};
        tabelaParsing.push(new TabelaParsing(80,28,p143));
        
        int[] p144 = {30,81,80};
        tabelaParsing.push(new TabelaParsing(80,30,p143));
        
        int[] p145 = {31,81,80};
        tabelaParsing.push(new TabelaParsing(80,31,p145));
        
        int[] p146 = {};
        tabelaParsing.push(new TabelaParsing(80,35,p146));
        
        int[] p147 = {};
        tabelaParsing.push(new TabelaParsing(80,37,p147));
        
        int[] p148 = {};
        tabelaParsing.push(new TabelaParsing(80,40,p148));
        
        int[] p149 = {};
        tabelaParsing.push(new TabelaParsing(80,37,p149));
        
        int[] p150 = {};
        tabelaParsing.push(new TabelaParsing(80,40,p150));
        
        int[] p151 = {};
        tabelaParsing.push(new TabelaParsing(80,41,p151));
        
        int[] p152 = {};
        tabelaParsing.push(new TabelaParsing(80,42,p152));
        
        int[] p153 = {};
        tabelaParsing.push(new TabelaParsing(80,43,p153));
        
        int[] p154 = {};
        tabelaParsing.push(new TabelaParsing(80,44,p154));
        
        int[] p155 = {};
        tabelaParsing.push(new TabelaParsing(80,45,p155));
        
        int[] p156 = {};
        tabelaParsing.push(new TabelaParsing(80,46,p156));
        
        int[] p157 = {};
        tabelaParsing.push(new TabelaParsing(80,47,p157));
        
        int[] p158 = {83,82};
        tabelaParsing.push(new TabelaParsing(81,24,p158));
        
        int[] p159 = {83,82};
        tabelaParsing.push(new TabelaParsing(81,25,p159));
        
        int[] p160 = {83,82};
        tabelaParsing.push(new TabelaParsing(81,26,p160));
        
        int[] p161 = {83,82};
        tabelaParsing.push(new TabelaParsing(81,36,p161));
        
        int[] p162 = {};
        tabelaParsing.push(new TabelaParsing(82,10,p162));
        
        int[] p163 = {};
        tabelaParsing.push(new TabelaParsing(82,14,p163));
        
        int[] p164 = {};
        tabelaParsing.push(new TabelaParsing(82,15,p164));
        
        int[] p165 = {};
        tabelaParsing.push(new TabelaParsing(82,17,p165));
        
        int[] p166 = {};
        tabelaParsing.push(new TabelaParsing(82,19,p166));
        
        int[] p167 = {};
        tabelaParsing.push(new TabelaParsing(82,22,p167));
        
        int[] p168 = {23,83,82};
        tabelaParsing.push(new TabelaParsing(82,23,p168));
        
        int[] p169 = {};
        tabelaParsing.push(new TabelaParsing(82,28,p169));
        
        int[] p170 = {};
        tabelaParsing.push(new TabelaParsing(82,30,p170));
        
        int[] p171 = {};
        tabelaParsing.push(new TabelaParsing(82,31,p171));
        
        int[] p172 = {32,83,82};
        tabelaParsing.push(new TabelaParsing(82,32,p172));
        
        int[] p173 = {33,83,82};
        tabelaParsing.push(new TabelaParsing(82,32,p173));
        
        int[] p174 = {};
        tabelaParsing.push(new TabelaParsing(82,35,p174));
        
        int[] p175 = {};
        tabelaParsing.push(new TabelaParsing(82,37,p175));
        
        int[] p176 = {};
        tabelaParsing.push(new TabelaParsing(82,40,p176));
        
        int[] p177 = {};
        tabelaParsing.push(new TabelaParsing(82,41,p177));
        
        int[] p178 = {};
        tabelaParsing.push(new TabelaParsing(82,42,p178));
        
        int[] p179 = {};
        tabelaParsing.push(new TabelaParsing(82,43,p179));
        
        int[] p180 = {};
        tabelaParsing.push(new TabelaParsing(82,44,p180));
        
        int[] p181 = {};
        tabelaParsing.push(new TabelaParsing(82,45,p181));
        
        int[] p182 = {};
        tabelaParsing.push(new TabelaParsing(82,46,p182));
        
        int[] p183 = {};
        tabelaParsing.push(new TabelaParsing(82,47,p183));
        
        int[] p184 = {24,83};
        tabelaParsing.push(new TabelaParsing(83,24,p184));
        
        int[] p185 = {72};
        tabelaParsing.push(new TabelaParsing(83,25,p185));
        
        int[] p186 = {26};
        tabelaParsing.push(new TabelaParsing(83,26,p186));
        
        int[] p187 = {36,77,37};
        tabelaParsing.push(new TabelaParsing(83,36,p187));
        
        int[] p188 = {26,86,39,66,85};
        tabelaParsing.push(new TabelaParsing(84,66,p188));
        
        int[] p189 = {};
        tabelaParsing.push(new TabelaParsing(85,7,p189));
        
        int[] p190 = {47,84};
        tabelaParsing.push(new TabelaParsing(85,47,p190));
        
        int[] p191 = {};
        tabelaParsing.push(new TabelaParsing(86,39,p191));
        
        int[] p192 = {46,26,86};
        tabelaParsing.push(new TabelaParsing(86,46,p192));

        return tabelaParsing;
    }
}
