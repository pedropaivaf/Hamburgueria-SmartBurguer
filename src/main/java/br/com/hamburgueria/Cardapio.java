package br.com.hamburgueria;

/**
 * Abstract Factory.
 * Cada familia de combo (Tradicional, Vegano, Infantil) e uma subclasse
 * concreta que sabe produzir o trio de produtos coerente entre si.
 * O metodo montarCombo() e a "fabrica principal": orquestra a criacao
 * dos tres produtos relacionados e empacota no agregado Combo.
 */
public abstract class Cardapio {

    public abstract String getNomeCombo();

    public abstract Lanche criarLanche();

    public abstract Bebida criarBebida();

    public abstract Acompanhamento criarAcompanhamento();

    public Combo montarCombo() {
        return new Combo(
                getNomeCombo(),
                criarLanche(),
                criarBebida(),
                criarAcompanhamento()
        );
    }
}
