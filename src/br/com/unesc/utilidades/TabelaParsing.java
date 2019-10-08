package br.com.unesc.utilidades;

import br.com.unesc.compilador.analisadorLexico.Token;
import br.com.unesc.compilador.services.Gramatica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author marcelo
 */
public class TabelaParsing {
    
    
    public List<Token> valida(Token terminal, Token naoTerminal){
        List<Token> listaVazia = new ArrayList<Token>();
        
        if(naoTerminal.getCodigo() == 52 && terminal.getCodigo() == 1)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("PROGRAM","IDENTIFICADOR",";","BLOCO","."));
            
        if(naoTerminal.getCodigo() == 53 && (terminal.getCodigo() >= 2 && terminal.getCodigo() <= 6))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("DCLROT","DCLCONST","DCLVAR","DCLPROC","CORPO"));
        
        if(naoTerminal.getCodigo() == 54 && terminal.getCodigo() == 2)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("LABEL","LID",";"));
        
        if(naoTerminal.getCodigo() == 54 && (terminal.getCodigo() >= 3 && terminal.getCodigo() <= 6))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 55 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IDENTIFICADOR","REPIDENT"));
        
        if(naoTerminal.getCodigo() == 56 && terminal.getCodigo() == 39)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 56 && terminal.getCodigo() == 46)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(",","IDENTIFICADOR","REPIDENT"));
        
        if(naoTerminal.getCodigo() == 56 && terminal.getCodigo() == 47)
            return listaVazia;

        if(naoTerminal.getCodigo() == 57 && terminal.getCodigo() == 3)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("CONST","IDENTIFICADOR","=","INTEIRO",";","LDCONST"));

        if(naoTerminal.getCodigo() == 57 && (terminal.getCodigo() >= 4 && terminal.getCodigo() <= 6))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 58 && (terminal.getCodigo() >= 4 && terminal.getCodigo() <= 6))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 58 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IDENTIFICADOR","=","INTEIRO",";","LDCONST"));
        
        if(naoTerminal.getCodigo() == 59 && terminal.getCodigo() == 4)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("VAR","LID",":","TIPO",";","LDVAR"));
        
        if((naoTerminal.getCodigo() >= 59 && naoTerminal.getCodigo() <= 60) && (terminal.getCodigo() >= 5 && terminal.getCodigo() <= 6))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 60 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("LID",":","TIPO","TIPO",";","LDVAR"));
        
        if(naoTerminal.getCodigo() == 61 && terminal.getCodigo() == 8)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("INTEGER"));
        
        if(naoTerminal.getCodigo() == 61 && terminal.getCodigo() == 9)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("ARRAY","[","INTEIRO","..","INTEIRO","]","OF","INTEGER"));
        
        if(naoTerminal.getCodigo() == 62 && terminal.getCodigo() == 5)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("PROCEDURE","IDENTIFICADOR","DEFPAR",";","BLOCO",";","BLOCO",";","DCLPROC"));
        
        if(naoTerminal.getCodigo() == 62 && terminal.getCodigo() == 6)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 63 && terminal.getCodigo() == 6)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("LID",":","INTEGER"));
        
        if(naoTerminal.getCodigo() == 63 && terminal.getCodigo() == 39)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 64 && terminal.getCodigo() == 6)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("BEGIN","COMANDO","REPCOMANDO","END"));
        
        if(naoTerminal.getCodigo() == 65 && terminal.getCodigo() == 7)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 65 && terminal.getCodigo() == 47)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(";","COMANDO","REPCOMANDO"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 6)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("CORPO"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 7)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 11)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("CALL","IDENTIFICADOR","PARAMETROS"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 12)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("GOTO","IDENTIFICADOR"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 13)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IF","EXPRESSAO","THEN","COMANDO","ELSEPARTE"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 13)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IF","EXPRESSAO","THEN","COMANDO","ELSEPARTE"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 15)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 16)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("WHILE","EXPRESSAO","DO","COMANDO"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 18)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("REPEAT","COMANDO","UNTIL","EXPRESSAO"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 19)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 20)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("READLN", "(", "VARIAVEL","REPVARIAVEL",")"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IDENTIFICADOR", "RCOMID"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 27)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("FOR", "IDENTIFICADOR", ":=", "EXPRESSAO", "EXPRESSAO", "EXPRESSAO", "DO", "COMANDO"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 29)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("CASE", "EXPRESSAO", "OF", "END"));
        
        if(naoTerminal.getCodigo() == 66 && terminal.getCodigo() == 47)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 67 && (terminal.getCodigo() >= 34 && terminal.getCodigo() <= 38))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("RVAR", ":=", "EXPRESSAO"));
        
        if(naoTerminal.getCodigo() == 67 && terminal.getCodigo() == 39)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(":", "COMANDO"));
        
        if(naoTerminal.getCodigo() == 68 && terminal.getCodigo() == 34)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("[", "EXPRESSAO", "]"));
        
        if(naoTerminal.getCodigo() == 68 && terminal.getCodigo() == 38)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 69 && (terminal.getCodigo() >= 7 && terminal.getCodigo() <= 19))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 69 && terminal.getCodigo() == 36)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("(", "EXPRESSAO", "REPPAR", ")"));
        
        if(naoTerminal.getCodigo() == 69 && terminal.getCodigo() == 47)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 70 && terminal.getCodigo() == 37)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 70 && terminal.getCodigo() == 46)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(",", "EXPRESSAO", "REPPAR"));
        
        if(naoTerminal.getCodigo() == 71 && terminal.getCodigo() == 7)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 71 && terminal.getCodigo() == 15)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("ELSE", "COMANDO"));
        
        if(naoTerminal.getCodigo() == 71 && (terminal.getCodigo() >= 19 && terminal.getCodigo() <= 47))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 72 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("IDENTIFICADOR", "VARIAVEL1"));
        
        if(naoTerminal.getCodigo() == 73 && terminal.getCodigo() == 34)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("[", "EXPRESSAO", "]"));
        
        if(naoTerminal.getCodigo() == 73 && (terminal.getCodigo() >= 7 && terminal.getCodigo() <= 47))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 74 && terminal.getCodigo() == 37)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 74 && terminal.getCodigo() == 46)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(",", "VARIAVEL", "REPVARIAVEL"));
        
        if(naoTerminal.getCodigo() == 75 && (terminal.getCodigo() >= 24 && terminal.getCodigo() <= 36))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("EXPRESSAO"));
        
        if(naoTerminal.getCodigo() == 75 && terminal.getCodigo() == 48)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("LITERAL"));
        
        if(naoTerminal.getCodigo() == 76 && terminal.getCodigo() == 37)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 76 && terminal.getCodigo() == 46)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(",", "VARIAVEL", "REPVARIAVEL"));
        
        if(naoTerminal.getCodigo() == 77 && (terminal.getCodigo() >= 24 && terminal.getCodigo() <= 36))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("EXPSIMP", "REPEXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && (terminal.getCodigo() >= 7 && terminal.getCodigo() <= 37))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 40)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("=", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 41)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(">", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 42)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(">=", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 43)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("<", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 44)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("<=", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && terminal.getCodigo() == 42)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("<>", "EXPSIMP"));
        
        if(naoTerminal.getCodigo() == 78 && (terminal.getCodigo() >= 46 && terminal.getCodigo() <= 47))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 79 && (terminal.getCodigo() >= 24 && terminal.getCodigo() <= 26))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 79 && terminal.getCodigo() == 30)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("+", "TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 79 && terminal.getCodigo() == 31)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("-", "TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 79 && terminal.getCodigo() == 36)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 80 && (terminal.getCodigo() >= 7 && terminal.getCodigo() <= 19))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 80 && terminal.getCodigo() == 22)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("OR", "TERMO", "REPEXP"));
         
        if(naoTerminal.getCodigo() == 80 && terminal.getCodigo() == 28)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 80 && terminal.getCodigo() == 30)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("+", "TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 80 && terminal.getCodigo() == 31)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("-", "TERMO", "REPEXP"));
        
        if(naoTerminal.getCodigo() == 80 && (terminal.getCodigo() >= 35 && terminal.getCodigo() <= 47))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 81 && (terminal.getCodigo() >= 24 && terminal.getCodigo() <= 36))
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("FATOR", "REPTERMO"));
        
        if(naoTerminal.getCodigo() == 82 && (terminal.getCodigo() >= 7 && terminal.getCodigo() <= 22))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 82 && terminal.getCodigo() == 23)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("AND", "FATOR", "REPTERMO"));
        
        if(naoTerminal.getCodigo() == 82 && (terminal.getCodigo() >= 28 && terminal.getCodigo() <= 31))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 82 && terminal.getCodigo() == 32)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("*", "FATOR", "REPTERMO"));
        
        if(naoTerminal.getCodigo() == 82 && terminal.getCodigo() == 33)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("/", "FATOR", "REPTERMO"));
        
        if(naoTerminal.getCodigo() == 82 && (terminal.getCodigo() >= 35 && terminal.getCodigo() <= 47))
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 83 && terminal.getCodigo() == 24)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("NOT", "FATOR"));
        
        if(naoTerminal.getCodigo() == 83 && terminal.getCodigo() == 25)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("VARIAVEL"));
        
        if(naoTerminal.getCodigo() == 83 && terminal.getCodigo() == 26)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("INTEIRO"));
        
        if(naoTerminal.getCodigo() == 83 && terminal.getCodigo() == 36)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("(", "EXPRESSAO", ")"));
        
        if(naoTerminal.getCodigo() == 84 && terminal.getCodigo() == 26)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList("INTEIRO", "RPINTEIRO", ":", "COMANDO", "CONTCASE"));
        
        if(naoTerminal.getCodigo() == 85 && terminal.getCodigo() == 7)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 85 && terminal.getCodigo() == 47)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(";", "CONDCASE"));
        
        if(naoTerminal.getCodigo() == 86 && terminal.getCodigo() == 39)
            return listaVazia;
        
        if(naoTerminal.getCodigo() == 86 && terminal.getCodigo() == 46)
            return Gramatica.getInstance().getTokenByNames(Arrays.asList(",", "INTEIRO", "RPINTEIRO"));
        
        return listaVazia;
    }
}
