package br.com.hamburgueria.menu;

/**
 * Iterator (e Composite) — componente do menu iteravel.
 */
public interface ItemMenu {
    String getNome();
    double getPreco();
    String getCategoria();
    String imprimirItem();
}
