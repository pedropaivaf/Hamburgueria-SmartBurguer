package br.com.hamburgueria.lanche;

import java.util.Locale;

/**
 * Classe abstrata base do padrao Abstract.
 * Define o contrato de descricao e preco que todo lanche e todo
 * decorator de adicional deve respeitar. O metodo imprimirFicha()
 * e um Template Method: o esqueleto de formatacao e fixo, mas os
 * detalhes vem de getDescricao() e getPreco() das subclasses.
 */
public abstract class Lanche {

    protected static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public abstract String getDescricao();

    public abstract double getPreco();

    public final String imprimirFicha() {
        return String.format(PT_BR, "%s - R$ %.2f", getDescricao(), getPreco());
    }
}
