package br.com.hamburgueria;

import java.util.Locale;

/**
 * Visitor — visitante que calcula o imposto de cada item do cardapio.
 */
public class CalculoFiscal implements VisitanteCardapio {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    @Override
    public String visitarLancheCardapio(LancheCardapio lanche) {
        double imposto = lanche.getPreco() * lanche.getPercentualImposto();
        return String.format(PT_BR, "%s: imposto R$ %.2f (%.0f%%)",
            lanche.getNome(), imposto, lanche.getPercentualImposto() * 100);
    }

    @Override
    public String visitarBebidaCardapio(BebidaCardapio bebida) {
        double pct    = bebida.isAlcoolica() ? 0.30 : 0.10;
        double imposto = bebida.getPreco() * pct;
        return String.format(PT_BR, "%s: imposto R$ %.2f (%.0f%%)",
            bebida.getNome(), imposto, pct * 100);
    }

    @Override
    public String visitarSobremesaCardapio(SobremesaCardapio sobremesa) {
        double imposto = sobremesa.getPreco() * 0.12;
        return String.format(PT_BR, "%s: imposto R$ %.2f (12%%)", sobremesa.getNome(), imposto);
    }
}
