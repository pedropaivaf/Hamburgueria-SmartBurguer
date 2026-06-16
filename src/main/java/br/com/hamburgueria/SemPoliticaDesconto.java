package br.com.hamburgueria;

/**
 * Strategy — sem desconto (estrategia padrao).
 */
public class SemPoliticaDesconto implements PoliticaDesconto {
    @Override public double calcularDesconto(double totalBruto) { return 0.0; }
    @Override public String descricao()                         { return "Sem desconto"; }
}
