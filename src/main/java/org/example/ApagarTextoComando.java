package org.example;

public class ApagarTextoComando implements Comando {

    private Documento documento;
    private int quantidade;
    private String textoApagado;

    public ApagarTextoComando(Documento documento, int quantidade) {
        this.documento = documento;
        this.quantidade = quantidade;
    }

    public void executar() {
        int qtd = Math.min(quantidade, documento.tamanho());
        this.textoApagado = documento.ultimosCaracteres(qtd);   // guarda para poder desfazer
        this.documento.apagarUltimos(qtd);
    }

    public void cancelar() {
        this.documento.inserir(textoApagado);
    }
}
