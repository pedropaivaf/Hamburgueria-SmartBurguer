package com.example.desconto;

import java.util.Locale;

/**
 * Strategy — contexto que aplica a PoliticaDesconto sobre o total do pedido.
 */
public class CaixaRegistradora {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");
    private PoliticaDesconto politica;

    public CaixaRegistradora(PoliticaDesconto politica) {
        this.politica = politica;
    }

    public void setPolitica(PoliticaDesconto politica) { this.politica = politica; }

    public double calcularTotalComDesconto(double totalBruto) {
        double desconto = politica.calcularDesconto(totalBruto);
        return totalBruto - desconto;
    }

    public String imprimirDesconto(double totalBruto) {
        double desconto  = politica.calcularDesconto(totalBruto);
        double totalFinal = totalBruto - desconto;
        return String.format(PT_BR,
            "Politica: %s | Bruto: R$ %.2f | Desconto: R$ %.2f | Final: R$ %.2f",
            politica.descricao(), totalBruto, desconto, totalFinal);
    }
}
