package com.example;

import com.example.menu.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Iterator: IteradorColecaoMenu percorre itens do menu
 * sem expor a lista interna da colecao.
 */
class IteradorMenuTest {

    @Test
    void iteradorPercorreTodosOsItens() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        menu.adicionar(new ProdutoMenu("X-Burguer", 16.0, "Lanches"));
        menu.adicionar(new ProdutoMenu("Refrigerante", 6.0, "Bebidas"));

        IteradorMenu it = menu.criarIterador();
        int cont = 0;
        while (it.temProximo()) { it.proximo(); cont++; }
        assertEquals(2, cont);
    }

    @Test
    void iteradorReiniciaDoComecoAposReiniciar() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        menu.adicionar(new ProdutoMenu("X-Salada", 15.0, "Lanches"));

        IteradorMenu it = menu.criarIterador();
        it.proximo();
        it.reiniciar();
        assertTrue(it.temProximo());
    }

    @Test
    void iteradorRetornaItensNaOrdemDeInsercao() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        ItemMenu primeiro  = new ProdutoMenu("Primeiro", 10.0, "A");
        ItemMenu segundo   = new ProdutoMenu("Segundo",  20.0, "B");
        menu.adicionar(primeiro);
        menu.adicionar(segundo);

        IteradorMenu it = menu.criarIterador();
        assertSame(primeiro, it.proximo());
        assertSame(segundo,  it.proximo());
    }

    @Test
    void colecaoVaziaTemProximoRetornaFalse() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        assertFalse(menu.criarIterador().temProximo());
    }

    @Test
    void iteradorSemElementosLancaExceptionAoChamarProximo() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        IteradorMenu it = menu.criarIterador();
        assertThrows(IndexOutOfBoundsException.class, it::proximo);
    }

    @Test
    void iteradorReiniciadoMantemElementos() {
        ColecaoItensMenu menu = new ColecaoItensMenu();
        menu.adicionar(new ProdutoMenu("Agua", 3.0, "Bebidas"));
        IteradorMenu it = menu.criarIterador();
        assertTrue(it.temProximo());
        assertEquals("Agua", it.proximo().getNome());
        assertFalse(it.temProximo());
        it.reiniciar();
        assertTrue(it.temProximo());
    }
}

