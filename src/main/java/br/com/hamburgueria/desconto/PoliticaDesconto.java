package br.com.hamburgueria.desconto;

/**
 * Strategy — interface da politica de desconto aplicada sobre o total do pedido.
 */
public interface PoliticaDesconto {
    double calcularDesconto(double totalBruto);
    String descricao();
}
