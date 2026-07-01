package com.example;

import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Valida o padrao Abstract Factory: cada fabrica concreta produz
 * a familia coerente de produtos (Lanche + Bebida + Acompanhamento)
 * e o agregado Combo aplica o desconto padrao de 10%.
 */
class CardapioTest {

    private static final double DELTA = 0.0001;

    @Test
    void tradicionalProduzXBurguerRefrigeranteEBatata() {
        Cardapio cardapio = new CardapioTradicional();
        Combo combo = cardapio.montarCombo();

        assertEquals("Combo Tradicional", combo.getNome());
        assertInstanceOf(XBurguer.class, combo.getLanche());
        assertInstanceOf(Refrigerante.class, combo.getBebida());
        assertInstanceOf(BatataFrita.class, combo.getAcompanhamento());
    }

    @Test
    void veganoProduzHamburguerSucoESalada() {
        Cardapio cardapio = new CardapioVegano();
        Combo combo = cardapio.montarCombo();

        assertEquals("Combo Vegano", combo.getNome());
        assertInstanceOf(HamburguerSimples.class, combo.getLanche());
        assertInstanceOf(Suco.class, combo.getBebida());
        assertInstanceOf(Salada.class, combo.getAcompanhamento());
    }

    @Test
    void infantilProduzHamburguerSucoEBatata() {
        Cardapio cardapio = new CardapioInfantil();
        Combo combo = cardapio.montarCombo();

        assertEquals("Combo Infantil", combo.getNome());
        assertInstanceOf(HamburguerSimples.class, combo.getLanche());
        assertInstanceOf(Suco.class, combo.getBebida());
        assertInstanceOf(BatataFrita.class, combo.getAcompanhamento());
    }

    @Test
    void precoSemDescontoEaSomaDosTresProdutos() {
        Combo combo = new CardapioTradicional().montarCombo();
        assertEquals(16.00 + 7.00 + 10.00, combo.getPrecoSemDesconto(), DELTA);
    }

    @Test
    void precoFinalAplicaDescontoDeDezPorCentoDoCombo() {
        Combo combo = new CardapioTradicional().montarCombo();
        double esperado = (16.00 + 7.00 + 10.00) * 0.90;
        assertEquals(esperado, combo.getPreco(), DELTA);
    }

    @Test
    void comboVeganoPrecoSemDescontoCorreto() {
        Combo combo = new CardapioVegano().montarCombo();
        assertEquals(29.00, combo.getPrecoSemDesconto(), DELTA);
    }

    @Test
    void comboInfantilPrecoComDescontoCorreto() {
        Combo combo = new CardapioInfantil().montarCombo();
        assertEquals(27.90, combo.getPreco(), DELTA);
    }
}

