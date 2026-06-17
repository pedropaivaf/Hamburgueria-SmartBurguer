package br.com.hamburgueria.adicional;

import br.com.hamburgueria.lanche.*;

/**
 * Classe base do padrao Decorator.
 * E um Lanche (heranca) e tem um Lanche (composicao) — exatamente a
 * estrutura do Decorator. Cada adicional concreto sobrescreve
 * getDescricao() e getPreco() delegando para o lanche envolvido e
 * adicionando sua propria parte.
 */
public abstract class Adicional extends Lanche {

    protected final Lanche lancheBase;

    protected Adicional(Lanche lancheBase) {
        this.lancheBase = lancheBase;
    }
}
