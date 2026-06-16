package br.com.hamburgueria;

import java.util.Locale;

/**
 * Produto agregado retornado pelo Abstract Factory.
 * Reune a familia coerente de tres produtos (Lanche, Bebida e Acompanhamento)
 * e aplica um desconto de combo sobre a soma dos precos individuais.
 */
public class Combo {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    private final String nome;
    private final Lanche lanche;
    private final Bebida bebida;
    private final Acompanhamento acompanhamento;

    public Combo(String nome, Lanche lanche, Bebida bebida, Acompanhamento acompanhamento) {
        this.nome = nome;
        this.lanche = lanche;
        this.bebida = bebida;
        this.acompanhamento = acompanhamento;
    }

    public String getNome() {
        return nome;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public double getPrecoSemDesconto() {
        return lanche.getPreco() + bebida.getPreco() + acompanhamento.getPreco();
    }

    public double getPreco() {
        return getPrecoSemDesconto() * (1 - ConfiguracaoLoja.getInstancia().getDescontoCombo());
    }

    public String imprimirFicha() {
        return String.format(
                PT_BR,
                "%s%n  - %s%n  - %s%n  - %s%n  Total do combo: R$ %.2f (10%% off)",
                nome,
                lanche.imprimirFicha(),
                bebida.imprimirFicha(),
                acompanhamento.imprimirFicha(),
                getPreco()
        );
    }
}
