package src.br.com.unesc.analisadorSemantico;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import br.com.unesc.utilidades.TabelaParsing;
import br.com.unesc.compilador.analisadorLexico.Token;
import javafx.scene.control.Tab;
import src.br.com.unesc.utilidades.TabelaDeSimbolos;

public class ClassificadorSemantico {
    List<TabelaDeSimbolos> tabelaDeSimbolos = new ArrayList<>();

    public TabelaDeSimbolos buscaItemNaTabela(Token tokenBusca, Integer nivel) throws Exception {
        TabelaDeSimbolos tab = new TabelaDeSimbolos();
        for (TabelaDeSimbolos it : tabelaDeSimbolos) {
            if (it.getNome().toUpperCase().equals(tokenBusca.getPalavra().toUpperCase()) && it.getNivel() == nivel) {
                tab = it;
            }
        }

        if (tab.getNome().equals("")) {
            throw new Exception("Identificador não declarado: " + tokenBusca.getPalavra());
        }

        return tab;
    }

    public TabelaDeSimbolos verificaSeItemExiste(Token tokenVerificar, Integer nivel) throws Exception {
        List<TabelaDeSimbolos> tab = new ArrayList<>();
        if (nivel == 0) {
            tab = tabelaDeSimbolos.stream()
                    .filter(item -> item.getNome().toUpperCase().equals(tokenVerificar.getPalavra().toUpperCase()) && item.getNivel() == nivel)
                    .collect(Collectors.toList());
        } else {
            tab = tabelaDeSimbolos.stream()
                    .filter(item -> item.getNome().toUpperCase().equals(tokenVerificar.getPalavra().toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (tab.isEmpty()) {
            throw new Exception("Identificador: '" + tokenVerificar.getPalavra() + "' não declarado");
        }

        return tab.get(0);
    }

    public void verificaSePodeInserir(TabelaDeSimbolos itemToAdd, Integer nivel) throws Exception {
            List<TabelaDeSimbolos> jaExiste = tabelaDeSimbolos.stream()
                .filter(item -> item.getNome().toUpperCase().equals(itemToAdd.getNome().toUpperCase()) && item.getNivel() == nivel)
                .collect(Collectors.toList());

        if (!jaExiste.isEmpty()) {
            if (itemToAdd.getCategoria().equals("PARAMETRO") || itemToAdd.getCategoria().equals("ROTULO")) {
                throw new Exception(itemToAdd.getCategoria() + " '" + itemToAdd.getNome() + "' declarado em duplicidade");
            } else {
                throw new Exception(itemToAdd.getCategoria() + " '" + itemToAdd.getNome() + "' declarada em duplicidade");
            }
        }
    }

    public void removeTodosPorNivel() {
        List<TabelaDeSimbolos> tabelaAuxiliar = new ArrayList<>();
        tabelaDeSimbolos.stream()
                .filter(item -> item.getNivel() == 1)
                .forEach(item -> {
                    tabelaAuxiliar.add(item);
                });
        tabelaDeSimbolos.removeAll(tabelaAuxiliar);
    }

    public void criaTabelaDeSimbolos(Stack<Token> lexico) throws Exception {
        Stack<Token> pilhaAuxiliar = new Stack();
        TabelaParsing M = new TabelaParsing();
        Stack<Token> X = new Stack();
        X.push(new Token(52, "PROGRAMA"));
        int nivel = 0;
        Token entrada = null;
        while (!X.isEmpty()) {

            entrada = lexico.get(0);

            // Se X é terminal
            if (X.get(0).getCodigo() < 52) {
                if (X.get(0).getCodigo() == entrada.getCodigo()) {

                    //Verifica saída da procedure
                    if (nivel == 1 && entrada.getCodigo() == 7) {
                        nivel = 0;
                        removeTodosPorNivel();
                    }

                    //Verifica entrada em procedure
                    if (entrada.getCodigo() == 5) {
                        nivel = 1;
                    }

                    //Verifica chamada de procedure
                    if (entrada.getCodigo() == 11) {
                        Boolean entrouNaProcedure = false;
                        Token entradaSemantica = lexico.get(1);
                        List<TabelaDeSimbolos> listaDeParametros = new ArrayList<>();
                        TabelaDeSimbolos procedure = new TabelaDeSimbolos();
                        int i = 1;
                        while (entradaSemantica.getCodigo() != 37) {
                            if(entradaSemantica.getCodigo() == 25 && listaDeParametros.isEmpty()){
                                procedure = buscaItemNaTabela(entradaSemantica,0);
                                for(int j = 0; j < tabelaDeSimbolos.size(); j++){
                                    if(tabelaDeSimbolos.get(j).getNome().equals(procedure.getNome())){
                                        j++;
                                        listaDeParametros.add(tabelaDeSimbolos.get(j));
                                    }
                                }
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                            if(entradaSemantica.getCodigo() == 25 && !listaDeParametros.isEmpty()){
                                TabelaDeSimbolos parametro = buscaItemNaTabela(entradaSemantica,0);
                                Boolean encontrouParametro = false;
                                for(int j = 0; j < listaDeParametros.size(); j++){
                                    if(parametro.getTipo().equals(listaDeParametros.get(j).getTipo())){
                                        encontrouParametro = true;
                                    }
                                }
                                if(!encontrouParametro){
                                    throw new Exception("Parâmetro: " + parametro.getNome() + " inválido para procedure: " + procedure.getNome());
                                }
                            }
                        }
                    }

                    //Verificação de Procedures
                    if (entrada.getCodigo() == 5) {
                        Token entradaSemantica = lexico.get(1);
                        int i = 1;
                        while (entradaSemantica.getCodigo() != 47) {
                            if (entradaSemantica.getCodigo() == 25) {
                                TabelaDeSimbolos tabela = new TabelaDeSimbolos();
                                tabela.setNome(entradaSemantica.getPalavra());
                                tabela.setCategoria("PROCEDURE");
                                tabela.setTipo("LITERAL");
                                tabela.setNivel(0);
                                tabela.setLinha(entradaSemantica.getLinha().toString());
                                verificaSePodeInserir(tabela, 0);
                                tabelaDeSimbolos.add(tabela);
                            }
                            if (entradaSemantica.getCodigo() == 36) {
                                i++;
                                entradaSemantica = lexico.get(i);
                                //verifica tipo do parametro
                                if (entradaSemantica.getCodigo() == 25) {
                                    String tipo = lexico.get(i + 2).getPalavra();
                                    TabelaDeSimbolos tabela = new TabelaDeSimbolos();
                                    tabela.setNome(entradaSemantica.getPalavra());
                                    tabela.setCategoria("PARAMETRO");
                                    tabela.setTipo(tipo);
                                    tabela.setNivel(0);
                                    tabela.setLinha(entradaSemantica.getLinha().toString());
                                    verificaSePodeInserir(tabela, nivel);
                                    ;
                                    tabelaDeSimbolos.add(tabela);
                                }
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                        }
                    }

                    // Verificação de LABEL
                    if (entrada.getCodigo() == 2) {
                        Token entradaSemantica = lexico.get(1);
                        int i = 1;
                        while (entradaSemantica.getCodigo() != 47) {
                            if (entradaSemantica.getCodigo() == 25) {
                                TabelaDeSimbolos tabela = new TabelaDeSimbolos();
                                tabela.setNome(entradaSemantica.getPalavra());
                                tabela.setCategoria("LABEL");
                                tabela.setTipo("LITERAL");
                                tabela.setNivel(nivel);
                                tabela.setLinha(entradaSemantica.getLinha().toString());
                                verificaSePodeInserir(tabela, nivel);
                                ;
                                tabelaDeSimbolos.add(tabela);
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                        }
                    }

                    //Verificação de CONST
                    if (entrada.getCodigo() == 3) {
                        Token entradaSemantica = lexico.get(1);
                        int i = 1;
                        while (entradaSemantica.getCodigo() != 47) {
                            if (entradaSemantica.getCodigo() == 25) {
                                TabelaDeSimbolos tabela = new TabelaDeSimbolos();
                                tabela.setNome(entradaSemantica.getPalavra());
                                tabela.setCategoria("CONST");
                                tabela.setTipo("INTEGER");
                                tabela.setNivel(nivel);
                                tabela.setLinha(entradaSemantica.getLinha().toString());
                                verificaSePodeInserir(tabela, nivel);
                                ;
                                tabelaDeSimbolos.add(tabela);
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                            if (entradaSemantica.getCodigo() == 47 && lexico.get(i + 1).getCodigo() == 25) {
                                i++;
                                entradaSemantica = lexico.get(i);
                            }
                        }
                    }

                    //Verificação de VAR
                    if (entrada.getCodigo() == 4) {
                        Token entradaSemantica = lexico.get(1);
                        int i = 1;
                        String tipo = "";

                        // Deve ser primeiro achado o tipo
                        while (entradaSemantica.getCodigo() != 39) {
                            i++;
                            entradaSemantica = lexico.get(i);
                        }
                        i++;
                        tipo = lexico.get(i).getPalavra();

                        i = 1;
                        entradaSemantica = lexico.get(1);
                        while (entradaSemantica.getCodigo() != 47) {
                            if (entradaSemantica.getCodigo() == 25) {
                                TabelaDeSimbolos tabela = new TabelaDeSimbolos();
                                tabela.setNome(entradaSemantica.getPalavra());
                                tabela.setCategoria("VARIAVEL");
                                tabela.setTipo(tipo);
                                tabela.setNivel(nivel);
                                tabela.setLinha(entradaSemantica.getLinha().toString());
                                verificaSePodeInserir(tabela, nivel);
                                ;
                                tabelaDeSimbolos.add(tabela);
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                            if (entradaSemantica.getCodigo() == 47 && lexico.get(i + 1).getCodigo() == 25) {
                                i++;
                                entradaSemantica = lexico.get(i);
                                //Verifica o tipo
                                int j = i + 1;
                                Token entradaAux = lexico.get(j);
                                while (entradaAux.getCodigo() != 39) {
                                    j++;
                                    entradaAux = lexico.get(j);
                                }
                                j++;
                                tipo = lexico.get(j).getPalavra();
                            }
                        }
                    }


                    // Verifica execução de bloco
                    if (entrada.getCodigo() == 6) {
                        int i = 0;
                        Token entradaSemantica = lexico.get(0);

                        while (entradaSemantica.getCodigo() != 7) {
                            if (entradaSemantica.getCodigo() == 25) {
                                TabelaDeSimbolos tab = verificaSeItemExiste(entradaSemantica, nivel);
                                i++;
                                entradaSemantica = lexico.get(i);
                                /*if (entradaSemantica.getCodigo() == 38) {
                                    i++;
                                    entradaSemantica = lexico.get(i);
                                    String tipo = "";
                                    if (entradaSemantica.getCodigo() == 26) {
                                        tipo = "INTEGER";
                                    } else {
                                        tipo = "LITERAL";
                                    }
                                    if (tab.getTipo() != tipo) {
                                        throw new Exception("Atribuição inválida para " + tab.getCategoria() + ", esperado: " + tab.getTipo());
                                    }
                                }*/
                            }
                            i++;
                            entradaSemantica = lexico.get(i);
                        }
                    }


                    X.remove(0);
                    lexico.remove(0);
                } else {
                    throw new Exception("A derivação na linha: " + entrada.getLinha() + "  - [" + X.get(0).getCodigo() + "," + entrada.getCodigo() + "] - '" + X.get(0).getPalavra() + "," + entrada.getPalavra() + "' não existe na tabela de Parsing");
                }
            } else {
                List<Token> listaDerivacoes = M.valida(entrada, X.get(0));
                if (!listaDerivacoes.isEmpty()) {
                    if (listaDerivacoes.get(0).getCodigo() == 999) {
                        Token descricaoPalavra = br.com.unesc.compilador.services.Gramatica.getInstance().getTokenByCode(entrada.getCodigo());
                        throw new Exception("A derivação na linha: " + entrada.getLinha() + "  - [" + X.get(0).getCodigo() + "," + entrada.getCodigo() + "] - '" + X.get(0).getPalavra() + "," + descricaoPalavra.getPalavra() + "' não existe na tabela de Parsing");
                    }
                    X.remove(0);
                    if (!X.isEmpty()) {
                        for (Token prod : X) {
                            pilhaAuxiliar.push(prod);
                        }
                        X.clear();
                    }
                    for (Token prod : listaDerivacoes) {
                        X.push(prod);
                    }
                    if (!pilhaAuxiliar.isEmpty()) {
                        for (Token prod : pilhaAuxiliar) {
                            X.push(prod);
                        }
                        pilhaAuxiliar.clear();
                    }
                } else {
                    X.remove(0);
                }
            }
        }
    }
}
