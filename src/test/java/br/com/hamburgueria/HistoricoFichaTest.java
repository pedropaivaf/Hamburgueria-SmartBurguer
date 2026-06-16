package br.com.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Memento: HistoricoFicha salva e restaura snapshots
 * do estado de uma Ficha sem expor seus internos.
 */
class HistoricoFichaTest {

    @Test
    void salvarCriaSnapshotComEstadoAtual() {
        Ficha ficha = new Ficha("H001");
        HistoricoFicha historico = new HistoricoFicha();
        historico.salvar(ficha);
        assertEquals(1, historico.tamanho());
    }

    @Test
    void desfazerRetornaSnapshotSalvo() {
        Ficha ficha = new Ficha("H002");
        HistoricoFicha historico = new HistoricoFicha();
        historico.salvar(ficha);
        SnapshotFicha snap = historico.desfazer();
        assertNotNull(snap);
        assertEquals("Pendente", snap.getSituacao());
    }

    @Test
    void multiplosSnapshotsSaoEmpilhados() {
        Ficha ficha = new Ficha("H003");
        HistoricoFicha historico = new HistoricoFicha();

        historico.salvar(ficha);
        ficha.iniciarPreparo();
        historico.salvar(ficha);

        assertEquals(2, historico.tamanho());
        assertEquals("Em Preparo", historico.desfazer().getSituacao());
        assertEquals("Pendente",   historico.desfazer().getSituacao());
    }

    @Test
    void desfazerEmHistoricoVazioRetornaNull() {
        HistoricoFicha historico = new HistoricoFicha();
        assertNull(historico.desfazer());
    }

    @Test
    void snapshotPreservaNumeroDoPedido() {
        Ficha ficha = new Ficha("H099");
        HistoricoFicha historico = new HistoricoFicha();
        historico.salvar(ficha);
        assertEquals("H099", historico.desfazer().getNumeroPedido());
    }
}
