package br.com.hamburgueria;

/**
 * Iterator — interface do iterador de itens do cardapio.
 */
public interface IteradorMenu {
    boolean temProximo();
    ItemMenu proximo();
    void reiniciar();
}
