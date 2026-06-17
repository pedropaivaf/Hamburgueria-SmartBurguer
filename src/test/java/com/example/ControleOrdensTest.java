package com.example;

import com.example.lanche.*;
import com.example.operacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import com.example.lanche.*;
import com.example.operacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Command: ControleOrdens executa e desfaz comandos
 * sobre pedidos de forma rastreavel.
 */
class ControleOrdensTest {

    @Test
    void executarAdicionaLancheAoPedido() {
        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro()).noBalcao().fechar();
        ControleOrdens ctrl = new ControleOrdens();

        ctrl.executar(new AdicionarLancheNaFicha(pedido, new HamburguerSimples()));

        assertEquals(1, pedido.getLanches().size());
    }

    @Test
    void desfazerRemoveLancheAdicionado() {
        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro()).noBalcao().fechar();
        ControleOrdens ctrl = new ControleOrdens();
        Lanche lanche = new HamburguerSimples();

        ctrl.executar(new AdicionarLancheNaFicha(pedido, lanche));
        assertTrue(ctrl.desfazer());
        assertTrue(pedido.getLanches().isEmpty());
    }

    @Test
    void desfazerSemHistoricoRetornaFalse() {
        ControleOrdens ctrl = new ControleOrdens();
        assertFalse(ctrl.desfazer());
    }

    @Test
    void historicoRegistraMultiplosComandos() {
        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro()).noBalcao().fechar();
        ControleOrdens ctrl = new ControleOrdens();

        ctrl.executar(new AdicionarLancheNaFicha(pedido, new HamburguerSimples()));
        ctrl.executar(new AdicionarLancheNaFicha(pedido, new XBurguer()));

        assertEquals(2, ctrl.totalNoHistorico());
    }

    @Test
    void removerLancheEDesfazerRestauraPedido() {
        Lanche lanche = new HamburguerSimples();
        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro()).noBalcao().comLanche(lanche).fechar();
        ControleOrdens ctrl = new ControleOrdens();

        ctrl.executar(new RemoverLancheDaFicha(pedido, lanche));
        assertTrue(pedido.getLanches().isEmpty());

        ctrl.desfazer();
        assertEquals(1, pedido.getLanches().size());
    }
}
