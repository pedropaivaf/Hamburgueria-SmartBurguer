package com.example;

import com.example.lanche.*;
import com.example.modelo.*;

import com.example.lanche.*;
import com.example.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Valida o padrao Abstract: cada subclasse concreta de Lanche
 * fornece descricao e preco proprios, e o Template Method
 * imprimirFicha() combina os dois no formato padrao.
 */
class LancheTest {

    private static final double DELTA = 0.0001;

    @Test
    void hamburguerSimplesTemDescricaoEPreco() {
        Lanche lanche = new HamburguerSimples();
        assertEquals("Hamburguer Simples", lanche.getDescricao());
        assertEquals(12.00, lanche.getPreco(), DELTA);
    }

    @Test
    void xBurguerTemDescricaoEPreco() {
        Lanche lanche = new XBurguer();
        assertEquals("X-Burguer", lanche.getDescricao());
        assertEquals(16.00, lanche.getPreco(), DELTA);
    }

    @Test
    void xSaladaTemDescricaoEPreco() {
        Lanche lanche = new XSalada();
        assertEquals("X-Salada", lanche.getDescricao());
        assertEquals(18.00, lanche.getPreco(), DELTA);
    }

    @Test
    void xTudoTemDescricaoEPreco() {
        Lanche lanche = new XTudo();
        assertEquals("X-Tudo", lanche.getDescricao());
        assertEquals(24.00, lanche.getPreco(), DELTA);
    }

    @Test
    void templateMethodImprimirFichaUsaDescricaoEPrecoDaSubclasse() {
        Lanche lanche = new XBurguer();
        assertEquals("X-Burguer - R$ 16,00", lanche.imprimirFicha());
    }
}
