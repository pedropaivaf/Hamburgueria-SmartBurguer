package br.com.hamburgueria;

/**
 * Iterator (e Composite) — componente do menu iteravel.
 */
public interface ItemMenu {
    String getNome();
    double getPreco();
    String getCategoria();
    String imprimirItem();
}
