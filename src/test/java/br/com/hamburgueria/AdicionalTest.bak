package br.com.hamburgueria;

import br.com.hamburgueria.adicional.*;
import br.com.hamburgueria.lanche.*;

import br.com.hamburgueria.adicional.*;
import br.com.hamburgueria.lanche.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Valida o padrao Decorator: cada adicional envolve um Lanche
 * e soma sua parte ao preco e a descricao; multiplos adicionais
 * podem ser empilhados em qualquer ordem.
 */
class AdicionalTest {

    private static final double DELTA = 0.0001;

    @Test
    void baconAdicionaPrecoEDescricao() {
        Lanche base = new XBurguer();
        Lanche comBacon = new Bacon(base);
        assertEquals("X-Burguer + Bacon", comBacon.getDescricao());
        assertEquals(16.00 + 4.00, comBacon.getPreco(), DELTA);
    }

    @Test
    void queijoExtraAdicionaPrecoEDescricao() {
        Lanche comQueijo = new QueijoExtra(new HamburguerSimples());
        assertEquals("Hamburguer Simples + Queijo Extra", comQueijo.getDescricao());
        assertEquals(12.00 + 3.00, comQueijo.getPreco(), DELTA);
    }

    @Test
    void ovoAdicionaPrecoEDescricao() {
        Lanche comOvo = new Ovo(new XBurguer());
        assertEquals("X-Burguer + Ovo", comOvo.getDescricao());
        assertEquals(16.00 + 2.50, comOvo.getPreco(), DELTA);
    }

    @Test
    void catupiryAdicionaPrecoEDescricao() {
        Lanche comCatupiry = new Catupiry(new XBurguer());
        assertEquals("X-Burguer + Catupiry", comCatupiry.getDescricao());
        assertEquals(16.00 + 3.50, comCatupiry.getPreco(), DELTA);
    }

    @Test
    void empilhandoVariosAdicionaisSomaTodosOsPrecos() {
        Lanche lanche = new Bacon(new QueijoExtra(new Ovo(new XBurguer())));
        assertEquals("X-Burguer + Ovo + Queijo Extra + Bacon", lanche.getDescricao());
        assertEquals(16.00 + 2.50 + 3.00 + 4.00, lanche.getPreco(), DELTA);
    }

    @Test
    void ordemDosAdicionaisAfetaApenasADescricaoNaoOPreco() {
        Lanche a = new Bacon(new QueijoExtra(new XBurguer()));
        Lanche b = new QueijoExtra(new Bacon(new XBurguer()));
        assertEquals(a.getPreco(), b.getPreco(), DELTA);
    }
}
