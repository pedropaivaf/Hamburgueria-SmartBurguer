package com.example;

import com.example.filtro.*;
import com.example.lanche.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Interpreter: CriterioLanche compoe expressoes de
 * filtro sobre Lanches com E e OU logicos.
 */
class CriterioLancheTest {

    @Test
    void criterioNomeFiltraCorretamente() {
        CriterioLanche criterio = new CriterioNomeLanche("x-");
        assertTrue(criterio.testar(new XBurguer()));
        assertFalse(criterio.testar(new HamburguerSimples()));
    }

    @Test
    void criterioPrecoMaximoFiltraCorretamente() {
        CriterioLanche criterio = new CriterioPrecoLanche(15.0);
        assertTrue(criterio.testar(new HamburguerSimples())); // 12.00
        assertFalse(criterio.testar(new XTudo()));            // preco > 15
    }

    @Test
    void criterioEExigeAmbosVerdadeiros() {
        CriterioLanche nome   = new CriterioNomeLanche("x-");
        CriterioLanche preco  = new CriterioPrecoLanche(20.0);
        CriterioLanche ambos  = new CriterioLancheE(nome, preco);

        assertTrue(ambos.testar(new XBurguer()));
        assertFalse(ambos.testar(new HamburguerSimples())); // nome nao bate
    }

    @Test
    void criterioOUAceitaQualquerUm() {
        // nome bate em HamburguerSimples; preco (<=20.0) bate em XBurguer (16.00)
        CriterioLanche nome  = new CriterioNomeLanche("hamburguer");
        CriterioLanche preco = new CriterioPrecoLanche(20.0);
        CriterioLanche ou    = new CriterioLancheOU(nome, preco);

        assertTrue(ou.testar(new HamburguerSimples())); // nome bate
        assertTrue(ou.testar(new XBurguer()));          // preco bate
    }

    @Test
    void composicaoTresNiveisNaoTerminalTerminal() {
        CriterioLanche xOuHamb = new CriterioLancheOU(
                new CriterioNomeLanche("x-"),
                new CriterioNomeLanche("hamburguer"));
        CriterioLanche barato  = new CriterioPrecoLanche(18.0);
        CriterioLanche filtro  = new CriterioLancheE(xOuHamb, barato);

        assertTrue(filtro.testar(new HamburguerSimples()));
        assertTrue(filtro.testar(new XBurguer()));
        assertFalse(filtro.testar(new XTudo()));
    }

    @Test
    void criterioNomeCasoInsensivel() {
        CriterioLanche criterio = new CriterioNomeLanche("X-BURGUER");
        assertTrue(criterio.testar(new XBurguer()));
    }

    @Test
    void criterioPrecoExatoAindaPassa() {
        CriterioLanche criterio = new CriterioPrecoLanche(16.00);
        assertTrue(criterio.testar(new XBurguer()));
    }
}

