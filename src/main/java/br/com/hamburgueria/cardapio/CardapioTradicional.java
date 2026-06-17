package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.modelo.*;

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
