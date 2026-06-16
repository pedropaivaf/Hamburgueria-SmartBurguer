package br.com.hamburgueria;

public class CardapioTradicional extends Cardapio {

    @Override
    public String getNomeCombo() {
        return "Combo Tradicional";
    }

    @Override
    public Lanche criarLanche() {
        return new XBurguer();
    }

    @Override
    public Bebida criarBebida() {
        return new Refrigerante();
    }

    @Override
    public Acompanhamento criarAcompanhamento() {
        return new BatataFrita();
    }
}
