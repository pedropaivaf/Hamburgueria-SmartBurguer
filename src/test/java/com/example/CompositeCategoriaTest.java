package com.example;

import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.menu.*;
import com.example.modelo.*;

import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.menu.*;
import com.example.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Composite: CategoriaMenu agrupa ItemMenu de forma
 * recursiva; ProdutoMenu e a folha.
 */
class CompositeCategoriaTest {

    @Test
    void produtoMenuImprimeSuaFicha() {
        ItemMenu produto = new ProdutoMenu("X-Burguer", 16.0, "Lanches");
        assertTrue(produto.imprimirItem().contains("X-Burguer"));
        assertTrue(produto.imprimirItem().contains("16,00"));
    }

    @Test
    void categoriaAgrupaProdutos() {
        CategoriaMenu categoria = new CategoriaMenu("Combos");
        categoria.adicionar(new ProdutoMenu("X-Salada", 15.0, "Lanche"));
        categoria.adicionar(new ProdutoMenu("Refrigerante", 6.0, "Bebida"));
        assertEquals(2, categoria.getItens().size());
    }

    @Test
    void categoriaPrecoEhSomaDosFilhos() {
        CategoriaMenu categoria = new CategoriaMenu("Almoco");
        categoria.adicionar(new ProdutoMenu("X-Burguer", 16.0, "Lanche"));
        categoria.adicionar(new ProdutoMenu("Suco", 7.0, "Bebida"));
        assertEquals(23.0, categoria.getPreco(), 0.001);
    }

    @Test
    void categoriaImprimeTodosOsFilhos() {
        CategoriaMenu categoria = new CategoriaMenu("Lanches");
        categoria.adicionar(new ProdutoMenu("X-Tudo", 19.0, "Lanche"));
        assertTrue(categoria.imprimirItem().contains("X-Tudo"));
        assertTrue(categoria.imprimirItem().contains("Lanches"));
    }

    @Test
    void categoriaAninhada() {
        CategoriaMenu pai  = new CategoriaMenu("Cardapio Completo");
        CategoriaMenu sub  = new CategoriaMenu("Bebidas");
        sub.adicionar(new ProdutoMenu("Agua", 3.0, "Bebida"));
        pai.adicionar(sub);
        assertEquals(1, pai.getItens().size());
        assertEquals(3.0, pai.getPreco(), 0.001);
    }
}
