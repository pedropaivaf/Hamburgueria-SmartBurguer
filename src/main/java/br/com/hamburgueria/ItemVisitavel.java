package br.com.hamburgueria;

/**
 * Visitor — interface do elemento que aceita um visitante.
 */
public interface ItemVisitavel {
    String aceitar(VisitanteCardapio visitante);
    String getNome();
    double getPreco();
}
