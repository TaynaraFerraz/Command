package org.example;

public class InserirTextoComando implements Comando {

    private Documento documento;
    private String texto;

    public InserirTextoComando(Documento documento, String texto) {
        this.documento = documento;
        this.texto = texto;
    }

    public void executar() {
        this.documento.inserir(texto);
    }

    public void cancelar() {
        this.documento.apagarUltimos(texto.length());
    }
}
