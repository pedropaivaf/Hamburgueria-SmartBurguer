package com.example.menu;

import java.util.Locale;

/**
 * Composite (folha) — produto individual no cardapio.
 */
public class ProdutoMenu implements ItemMenu {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");
    private final String nome;
    private final double preco;
    private final String categoria;

    public ProdutoMenu(String nome, double preco, String categoria) {
        this.nome      = nome;
        this.preco     = preco;
        this.categoria = categoria;
    }

    @Override public String getNome()      { return nome; }
    @Override public double getPreco()     { return preco; }
    @Override public String getCategoria() { return categoria; }

    @Override public String imprimirItem() {
        return String.format(PT_BR, "[%s] %s — R$ %.2f", categoria, nome, preco);
    }
}
