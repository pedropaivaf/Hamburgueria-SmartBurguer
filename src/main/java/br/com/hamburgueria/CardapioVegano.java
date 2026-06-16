package br.com.hamburgueria;

public class CardapioVegano extends Cardapio {

    @Override
    public String getNomeCombo() {
        return "Combo Vegano";
    }

    @Override
    public Lanche criarLanche() {
        return new HamburguerSimples();
    }

    @Override
    public Bebida criarBebida() {
        return new Suco();
    }

    @Override
    public Acompanhamento criarAcompanhamento() {
        return new Salada();
    }
}
