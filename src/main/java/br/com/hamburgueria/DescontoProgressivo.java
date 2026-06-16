package br.com.hamburgueria;

/**
 * Strategy — desconto escalonado por faixa de valor do pedido.
 *   >= R$100 => 15%  |  >= R$50 => 8%  |  < R$50 => 0%
 */
public class DescontoProgressivo implements PoliticaDesconto {
    @Override
    public double calcularDesconto(double totalBruto) {
        if (totalBruto >= 100.0) return totalBruto * 0.15;
        if (totalBruto >= 50.0)  return totalBruto * 0.08;
        return 0.0;
    }

    @Override public String descricao() { return "Desconto Progressivo (ate 15%)"; }
}
