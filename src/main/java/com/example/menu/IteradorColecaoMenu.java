package com.example.menu;

import java.util.List;

/**
 * Iterator — implementacao concreta que percorre a colecao do menu.
 */
public class IteradorColecaoMenu implements IteradorMenu {
    private final List<ItemMenu> itens;
    private int posicao = 0;

    public IteradorColecaoMenu(List<ItemMenu> itens) { this.itens = itens; }

    @Override public boolean temProximo() { return posicao < itens.size(); }
    @Override public ItemMenu proximo()   { return itens.get(posicao++); }
    @Override public void reiniciar()     { posicao = 0; }
}
