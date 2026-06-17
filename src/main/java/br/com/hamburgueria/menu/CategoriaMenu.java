package br.com.hamburgueria.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite (galho) — agrupa produtos em uma categoria do cardapio.
 */
public class CategoriaMenu implements ItemMenu {
    private final String nome;
    private final List<ItemMenu> itens = new ArrayList<>();

    public CategoriaMenu(String nome) { this.nome = nome; }

    public void adicionar(ItemMenu item) { itens.add(item); }
    public void remover(ItemMenu item)   { itens.remove(item); }
    public List<ItemMenu> getItens()     { return itens; }

    @Override public String getNome()      { return nome; }
    @Override public double getPreco()     { return itens.stream().mapToDouble(ItemMenu::getPreco).sum(); }
    @Override public String getCategoria() { return "CATEGORIA"; }

    @Override public String imprimirItem() {
        StringBuilder sb = new StringBuilder("=== " + nome + " ===\n");
        for (ItemMenu i : itens) sb.append("  ").append(i.imprimirItem()).append("\n");
        return sb.toString().trim();
    }
}
