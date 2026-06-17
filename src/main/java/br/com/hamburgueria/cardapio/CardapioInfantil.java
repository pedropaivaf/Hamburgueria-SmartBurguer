package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.modelo.*;

public class CardapioInfantil extends Cardapio {

    @Override
    public String getNomeCombo() {
        return "Combo Infantil";
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
        return new BatataFrita();
    }
}
