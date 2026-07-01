package com.example;

import com.example.modelo.*;
import com.example.notificacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Valida o padrao Observer: o Pedido (subject) notifica todos os
 * Acompanhantes registrados a cada mudanca de Status, e o status
 * atual fica disponivel via getStatus().
 */
class AcompanhanteTest {

    /**
     * Acompanhante de teste: guarda em listas as notificacoes recebidas
     * para que possamos verificar quantas vezes e com quais valores foi avisado.
     */
    private static class Espiao implements Acompanhante {
        final List<Status> recebidos = new ArrayList<>();

        @Override
        public void avisar(Pedido pedido, Status novoStatus) {
            recebidos.add(novoStatus);
        }
    }

    @Test
    void statusInicialEhRecebido() {
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro());
        assertEquals(Status.RECEBIDO, pedido.getStatus());
    }

    @Test
    void mudarStatusAtualizaOEstadoDoPedido() {
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro());
        pedido.mudarStatus(Status.PREPARANDO);
        assertEquals(Status.PREPARANDO, pedido.getStatus());
    }

    @Test
    void unicoAcompanhanteRecebeAvisoDeTodasAsMudancas() {
        Espiao espiao = new Espiao();
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro())
                .adicionarAcompanhante(espiao);

        pedido.mudarStatus(Status.PREPARANDO);
        pedido.mudarStatus(Status.PRONTO);
        pedido.mudarStatus(Status.ENTREGUE);

        assertEquals(List.of(Status.PREPARANDO, Status.PRONTO, Status.ENTREGUE), espiao.recebidos);
    }

    @Test
    void multiplosAcompanhantesRecebemAMesmaNotificacao() {
        Espiao cozinha = new Espiao();
        Espiao painel = new Espiao();
        Pedido pedido = new PedidoDelivery(new PagamentoPix())
                .adicionarAcompanhante(cozinha)
                .adicionarAcompanhante(painel);

        pedido.mudarStatus(Status.PREPARANDO);

        assertEquals(List.of(Status.PREPARANDO), cozinha.recebidos);
        assertEquals(List.of(Status.PREPARANDO), painel.recebidos);
    }

    @Test
    void acompanhanteRemovidoNaoRecebeMaisAvisos() {
        Espiao espiao = new Espiao();
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro())
                .adicionarAcompanhante(espiao);

        pedido.mudarStatus(Status.PREPARANDO);
        pedido.removerAcompanhante(espiao);
        pedido.mudarStatus(Status.PRONTO);

        assertEquals(List.of(Status.PREPARANDO), espiao.recebidos);
    }

    @Test
    void cozinhaEPainelClienteImplementamAcompanhante() {
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro())
                .adicionarAcompanhante(new Cozinha())
                .adicionarAcompanhante(new PainelCliente());
        assertTrue(true, "construcao com observers reais nao lanca");
        pedido.mudarStatus(Status.PRONTO);
    }
}
