package src.br.com.unesc.utilidades;

public class TabelaDeSimbolos {
    String nome;
    String categoria;
    String tipo;
    Integer nivel;
    String linha;

    public TabelaDeSimbolos(){

    }

    public TabelaDeSimbolos(String nome, String categoria, String tipo, Integer nivel) {
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
