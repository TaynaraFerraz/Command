package command;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditorTest {

    Editor editor;
    Documento documento;

    @BeforeEach
    void setUp() {
        editor = new Editor();
        documento = new Documento();
    }

    @Test
    void deveInserirTexto() {
        Comando inserirTexto = new InserirTextoComando(documento, "Olá, mundo!");
        editor.executarComando(inserirTexto);

        assertEquals("Olá, mundo!", documento.getConteudo());
    }

    @Test
    void deveApagarTexto() {
        Comando inserirTexto = new InserirTextoComando(documento, "Olá, mundo!");
        Comando apagarTexto = new ApagarTextoComando(documento, 6);

        editor.executarComando(inserirTexto);
        editor.executarComando(apagarTexto);

        assertEquals("Olá, ", documento.getConteudo());
    }

    @Test
    void deveCancelarApagarTexto() {
        Comando inserirTexto = new InserirTextoComando(documento, "Olá, mundo!");
        Comando apagarTexto = new ApagarTextoComando(documento, 6);

        editor.executarComando(inserirTexto);
        editor.executarComando(apagarTexto);

        editor.cancelarUltimoComando();

        assertEquals("Olá, mundo!", documento.getConteudo());
    }

    @Test
    void deveCancelarInserirTexto() {
        Comando inserirOla = new InserirTextoComando(documento, "Olá, ");
        Comando inserirMundo = new InserirTextoComando(documento, "mundo!");

        editor.executarComando(inserirOla);
        editor.executarComando(inserirMundo);

        editor.cancelarUltimoComando();

        assertEquals("Olá, ", documento.getConteudo());
    }

}
