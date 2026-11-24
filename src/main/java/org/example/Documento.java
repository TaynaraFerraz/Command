package org.example;

public class Documento {

    private StringBuilder conteudo = new StringBuilder();

    public String getConteudo() {
        return conteudo.toString();
    }

    public void inserir(String texto) {
        conteudo.append(texto);
    }

    public void apagarUltimos(int quantidade) {
        conteudo.delete(conteudo.length() - quantidade, conteudo.length());
    }

    public String ultimosCaracteres(int quantidade) {
        return conteudo.substring(conteudo.length() - quantidade);
    }

    public int tamanho() {
        return conteudo.length();
    }
}
