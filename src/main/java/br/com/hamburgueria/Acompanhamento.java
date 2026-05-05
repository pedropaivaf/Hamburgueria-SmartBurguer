package br.com.hamburgueria;

import java.util.Locale;

public abstract class Acompanhamento {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public abstract String getNome();

    public abstract double getPreco();

    public final String imprimirFicha() {
        return String.format(PT_BR, "%s - R$ %.2f", getNome(), getPreco());
    }
}
