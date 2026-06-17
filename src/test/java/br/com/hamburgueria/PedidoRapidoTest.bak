package br.com.hamburgueria;

import br.com.hamburgueria.modelo.*;
import br.com.hamburgueria.pedido.*;

import br.com.hamburgueria.modelo.*;
import br.com.hamburgueria.pedido.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Prototype: PedidoRapido.clonar() produz uma copia
 * independente — alterar a copia nao afeta o original.
 */
class PedidoRapidoTest {

    @Test
    void clonarProduzeObjetoDistinto() {
        PedidoRapido original = new PedidoRapido("Pedido do Joao");
        original.adicionarLanche("X-Burguer");
        PedidoRapido copia = (PedidoRapido) original.clonar();
        assertNotSame(original, copia);
    }

    @Test
    void copiaPreserveLanchesDoOriginal() {
        PedidoRapido original = new PedidoRapido("Favorito");
        original.adicionarLanche("X-Tudo");
        original.adicionarLanche("Refrigerante");
        PedidoRapido copia = (PedidoRapido) original.clonar();
        assertEquals(2, copia.getNomesLanches().size());
    }

    @Test
    void alterarCopiaPreservaOriginal() {
        PedidoRapido original = new PedidoRapido("Original");
        original.adicionarLanche("X-Burguer");
        PedidoRapido copia = (PedidoRapido) original.clonar();
        copia.adicionarLanche("Batata Frita");
        assertEquals(1, original.getNomesLanches().size());
        assertEquals(2, copia.getNomesLanches().size());
    }

    @Test
    void copiaTemApelidoDistinto() {
        PedidoRapido original = new PedidoRapido("Meu Pedido");
        PedidoRapido copia = (PedidoRapido) original.clonar();
        assertNotEquals(original.getApelido(), copia.getApelido());
    }

    @Test
    void apelidoPodeSerAlteradoNaCopia() {
        PedidoRapido original = new PedidoRapido("Favorito");
        PedidoRapido copia = (PedidoRapido) original.clonar();
        copia.setApelido("Segunda via");
        assertEquals("Favorito",    original.getApelido());
        assertEquals("Segunda via", copia.getApelido());
    }
}
