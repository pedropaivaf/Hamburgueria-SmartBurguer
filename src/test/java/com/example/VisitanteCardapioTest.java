package com.example;

import com.example.analise.*;
import com.example.modelo.*;

import com.example.analise.*;
import com.example.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Visitor: CalculoNutricional e CalculoFiscal percorrem
 * elementos do cardapio sem alterar suas classes.
 */
class VisitanteCardapioTest {

    @Test
    void calculoNutricionalParaLanche() {
        LancheCardapio lanche = new LancheCardapio("X-Burguer", 16.0, 700, 0.12);
        String resultado = new CalculoNutricional().visitarLancheCardapio(lanche);
        assertTrue(resultado.contains("700 kcal"));
        assertTrue(resultado.contains("ALTO VALOR CALORICO"));
    }

    @Test
    void calculoNutricionalParaBebidaNaoAlcoolica() {
        BebidaCardapio bebida = new BebidaCardapio("Suco Natural", 8.0, 120, false);
        String resultado = new CalculoNutricional().visitarBebidaCardapio(bebida);
        assertTrue(resultado.contains("120 kcal"));
        assertFalse(resultado.contains("ALCOOLICA"));
    }

    @Test
    void calculoNutricionalParaSobremesa() {
        SobremesaCardapio sob = new SobremesaCardapio("Sorvete", 7.0, 250);
        String resultado = new CalculoNutricional().visitarSobremesaCardapio(sob);
        assertTrue(resultado.contains("250 kcal"));
        assertTrue(resultado.contains("SOBREMESA"));
    }

    @Test
    void calculoFiscalParaBebidaAlcoolica() {
        BebidaCardapio bebida = new BebidaCardapio("Cerveja", 10.0, 200, true);
        String resultado = new CalculoFiscal().visitarBebidaCardapio(bebida);
        assertTrue(resultado.contains("30%"));
    }

    @Test
    void aceitarDespachaNoChatVisitante() {
        LancheCardapio lanche = new LancheCardapio("Hamburguer", 12.0, 500, 0.08);
        VisitanteCardapio fiscal = new CalculoFiscal();
        String resultado = lanche.aceitar(fiscal);
        assertTrue(resultado.contains("8%"));
    }
}
