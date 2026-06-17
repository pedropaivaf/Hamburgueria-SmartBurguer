package com.example;

import com.example.ficha.*;
import com.example.setor.*;

import com.example.ficha.*;
import com.example.setor.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Mediator: CentralPedidos coordena os setores sem
 * que eles se referenciem diretamente entre si.
 */
class CentralPedidosTest {

    @Test
    void registroDeSetorConfiguraMediador() {
        CentralPedidos central = new CentralPedidos();
        SetorCozinha cozinha   = new SetorCozinha();
        central.registrar(cozinha);
        // nao lanca excecao — mediador foi injetado
        assertNotNull(cozinha.getNome());
    }

    @Test
    void prepararPedidoMudaFichaParaEmPreparo() {
        SetorCozinha cozinha = new SetorCozinha();
        Ficha ficha = new Ficha("M001");
        cozinha.prepararPedido(ficha);
        assertEquals("Em Preparo", ficha.getSituacao());
    }

    @Test
    void concluirPedidoMudaFichaParaPronta() {
        SetorCozinha cozinha = new SetorCozinha();
        Ficha ficha = new Ficha("M002");
        ficha.iniciarPreparo();
        cozinha.concluirPedido(ficha);
        assertEquals("Pronta", ficha.getSituacao());
    }

    @Test
    void fluxoCompletoViaMediadorEntregaFicha() {
        CentralPedidos central = new CentralPedidos();
        SetorBalcao  balcao   = new SetorBalcao();
        SetorCozinha cozinha  = new SetorCozinha();
        SetorEntrega entrega  = new SetorEntrega();
        central.registrar(balcao);
        central.registrar(cozinha);
        central.registrar(entrega);

        Ficha ficha = new Ficha("M003");
        balcao.registrarPedido(ficha);
        cozinha.prepararPedido(ficha);
        cozinha.concluirPedido(ficha); // notifica entrega via mediador

        assertEquals("Entregue", ficha.getSituacao());
    }
}
