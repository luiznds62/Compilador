package br.com.unesc.compilador.services;

import br.com.unesc.compilador.analisadorLexico.Token;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author marcelo
 */
public class Gramatica {

    private static final Stack<Token> gramatica = new Stack();
    
    static {
        gramatica.push(new Token(1, "PROGRAM"));
        gramatica.push(new Token(2, "LABEL"));
        gramatica.push(new Token(3, "CONST"));
        gramatica.push(new Token(4, "VAR"));
        gramatica.push(new Token(5, "PROCEDURE"));
        gramatica.push(new Token(6, "BEGIN"));
        gramatica.push(new Token(7, "END"));
        gramatica.push(new Token(8, "INTEGER"));
        gramatica.push(new Token(9, "ARRAY"));
        gramatica.push(new Token(10, "OF"));
        gramatica.push(new Token(11, "CALL"));
        gramatica.push(new Token(12, "GOTO"));
        gramatica.push(new Token(13, "IF"));
        gramatica.push(new Token(14, "THEN"));
        gramatica.push(new Token(15, "ELSE"));
        gramatica.push(new Token(16, "WHILE"));
        gramatica.push(new Token(17, "DO"));
        gramatica.push(new Token(18, "REPEAT"));
        gramatica.push(new Token(19, "UNTIL"));
        gramatica.push(new Token(20, "READLN"));
        gramatica.push(new Token(21, "WRITELN"));
        gramatica.push(new Token(22, "OR"));
        gramatica.push(new Token(23, "AND"));
        gramatica.push(new Token(24, "NOT"));
        gramatica.push(new Token(25, "IDENTIFICADOR"));
        gramatica.push(new Token(26, "INTEIRO"));
        gramatica.push(new Token(27, "FOR"));
        gramatica.push(new Token(28, "TO"));
        gramatica.push(new Token(29, "CASE"));
        gramatica.push(new Token(30, "+"));
        gramatica.push(new Token(31, "-"));
        gramatica.push(new Token(32, "*"));
        gramatica.push(new Token(33, "/"));
        gramatica.push(new Token(34, "["));
        gramatica.push(new Token(35, "]"));
        gramatica.push(new Token(36, "("));
        gramatica.push(new Token(37, ")"));
        gramatica.push(new Token(38, ":="));
        gramatica.push(new Token(39, ":"));
        gramatica.push(new Token(40, "="));
        gramatica.push(new Token(41, ">"));
        gramatica.push(new Token(42, ">="));
        gramatica.push(new Token(43, "<"));
        gramatica.push(new Token(44, "<="));
        gramatica.push(new Token(45, "<>"));
        gramatica.push(new Token(46, ","));
        gramatica.push(new Token(47, ";"));
        gramatica.push(new Token(48, "LITERAL"));
        gramatica.push(new Token(49, "."));
        gramatica.push(new Token(50, ".."));
        gramatica.push(new Token(51, "$"));
        gramatica.push(new Token(52, "PROGRAMA"));
        gramatica.push(new Token(53, "BLOCO"));
        gramatica.push(new Token(54, "DCLROT"));
        gramatica.push(new Token(55, "LID"));
        gramatica.push(new Token(56, "REPIDENT"));
        gramatica.push(new Token(57, "DCLCONST"));
        gramatica.push(new Token(58, "LDCONST"));
        gramatica.push(new Token(59, "DCLVAR"));
        gramatica.push(new Token(60, "LDVAR"));
        gramatica.push(new Token(61, "TIPO"));
        gramatica.push(new Token(62, "DCLPROC"));
        gramatica.push(new Token(63, "DEFPAR"));
        gramatica.push(new Token(64, "CORPO"));
        gramatica.push(new Token(65, "REPCOMANDO"));
        gramatica.push(new Token(66, "COMANDO"));
        gramatica.push(new Token(67, "RCOMID"));
        gramatica.push(new Token(68, "RVAR"));
        gramatica.push(new Token(69, "PARAMETROS"));
        gramatica.push(new Token(70, "REPPAR"));
        gramatica.push(new Token(71, "ELSEPARTE"));
        gramatica.push(new Token(72, "VARIAVEL"));
        gramatica.push(new Token(73, "VARIAVEL1"));
        gramatica.push(new Token(74, "REPVARIAVEL"));
        gramatica.push(new Token(75, "ITEMSAIDA"));
        gramatica.push(new Token(76, "REPITEM"));
        gramatica.push(new Token(77, "EXPRESSAO"));
        gramatica.push(new Token(78, "REPEXPSIMP"));
        gramatica.push(new Token(79, "EXPSIMP"));
        gramatica.push(new Token(80, "REPEXP"));
        gramatica.push(new Token(81, "TERMO"));
        gramatica.push(new Token(82, "REPTERMO"));
        gramatica.push(new Token(83, "FATOR"));
        gramatica.push(new Token(84, "CONDCASE"));
        gramatica.push(new Token(85, "CONTCASE"));
        gramatica.push(new Token(86, "RPINTEIRO"));
        gramatica.push(new Token(87, "SEMEFEITO"));
    }
    
    private static final Gramatica instance = new Gramatica();
    
    //pattern singleton
    private Gramatica(){
    }
    
    public static Gramatica getInstance(){
        return instance;
    }

    public Stack<Token> getTerminais() {
//        verifiGramatica();
        Stack<Token> list = new Stack<Token>();
        list.addAll(gramatica.subList(0, 53));
        return list;
    }

    public Stack<Token> getNaoTerminais() {
//        verifiGramatica();
        Stack<Token> list = new Stack<Token>();
        list.addAll(gramatica.subList(53, 88));
        return list;
    }

    public Token getTokenByName(String name) {
//        verifiGramatica();
        return gramatica.stream()
                .filter(token -> name.equals(token.getPalavra()))
                .findAny()
                .orElse(null);
    }

    public List<Token> getTokenByNames(List<String> names) {
//        verifiGramatica();
        return gramatica.stream()
                .filter(token -> names.contains(token.getPalavra()))
                .collect(Collectors.toList());
    }

    public Token getTokenByCode(int codigo) {
//        verifiGramatica();
        return gramatica.stream()
                .filter(token -> codigo == token.getCodigo())
                .findAny()
                .orElse(null);
    }

//
//    private static void verifiGramatica() {
//        if (gramatica == null) {
//            createGramatica();
//        }
//    }

}
