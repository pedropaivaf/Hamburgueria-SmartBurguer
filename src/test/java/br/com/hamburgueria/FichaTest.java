package br.com.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao State: Ficha delega cada transicao ao estado atual;
 * transicoes invalidas retornam false sem alterar o estado.
 */
class FichaTest {

    @Test
    void fichaIniciaNoPendente() {
        Ficha ficha = new Ficha("P001");
        assertEquals("Pendente", ficha.getSituacao());
    }

    @Test
    void transicaoParaEmPreparoEhValida() {
        Ficha ficha = new Ficha("P002");
        assertTrue(ficha.iniciarPreparo());
        assertEquals("Em Preparo", ficha.getSituacao());
    }

    @Test
    void transicaoDeEmPreparoParaPronta() {
        Ficha ficha = new Ficha("P003");
        ficha.iniciarPreparo();
        assertTrue(ficha.concluir());
        assertEquals("Pronta", ficha.getSituacao());
    }

    @Test
    void transicaoDeProntaParaEntregue() {
        Ficha ficha = new Ficha("P004");
        ficha.iniciarPreparo();
        ficha.concluir();
        assertTrue(ficha.entregar());
        assertEquals("Entregue", ficha.getSituacao());
    }

    @Test
    void cancelarNoEstadoPendente() {
        Ficha ficha = new Ficha("P005");
        assertTrue(ficha.cancelar());
        assertEquals("Cancelada", ficha.getSituacao());
    }

    @Test
    void transicaoInvalidaRetornaFalse() {
        Ficha ficha = new Ficha("P006");
        ficha.iniciarPreparo();
        assertFalse(ficha.entregar()); // so pode entregar quando Pronta
        assertEquals("Em Preparo", ficha.getSituacao());
    }

    @Test
    void estadosSaoSingletons() {
        assertSame(FichaEstadoPendente.getInstance(), FichaEstadoPendente.getInstance());
        assertSame(FichaEstadoEmPreparo.getInstance(), FichaEstadoEmPreparo.getInstance());
        assertSame(FichaEstadoPronta.getInstance(), FichaEstadoPronta.getInstance());
        assertSame(FichaEstadoEntregue.getInstance(), FichaEstadoEntregue.getInstance());
        assertSame(FichaEstadoCancelada.getInstance(), FichaEstadoCancelada.getInstance());
    }
}
