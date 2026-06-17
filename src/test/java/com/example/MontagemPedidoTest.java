package com.example;

import com.example.adicional.*;
import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import com.example.adicional.*;
import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Valida o padrao Builder: montagem fluente e progressiva de um Pedido,
 * com escolha de modalidade e forma de pagamento, finalizada por fechar().
 */
class MontagemPedidoTest {

    private static final double DELTA = 0.0001;

    @Test
    void montaPedidoBalcaoComLancheEPagamentoPix() {
        Pedido pedido = new MontagemPedido()
                .noBalcao()
                .pagarCom(new PagamentoPix())
                .comLanche(new XBurguer())
                .fechar();

        assertInstanceOf(PedidoBalcao.class, pedido);
        assertEquals(16.00 * 0.95, pedido.getTotal(), DELTA);
    }

    @Test
    void montaPedidoDeliveryComComboECartao() {
        Combo combo = new CardapioTradicional().montarCombo();
        Pedido pedido = new MontagemPedido()
                .paraDelivery()
                .pagarCom(new PagamentoCartao())
                .comCombo(combo)
                .fechar();

        assertInstanceOf(PedidoDelivery.class, pedido);
        assertEquals((combo.getPreco() + 8.00) * 1.03, pedido.getTotal(), DELTA);
    }

    @Test
    void montaPedidoCombinandoLanchesECombo() {
        Combo combo = new CardapioVegano().montarCombo();
        Pedido pedido = new MontagemPedido()
                .pagarCom(new PagamentoDinheiro())
                .comLanche(new Bacon(new XBurguer()))
                .comCombo(combo)
                .fechar();

        double esperado = (16.00 + 4.00) + combo.getPreco();
        assertEquals(esperado, pedido.getTotal(), DELTA);
    }

    @Test
    void semFormaPagamentoLancaErroAoFechar() {
        MontagemPedido montagem = new MontagemPedido().comLanche(new XBurguer());
        assertThrows(IllegalStateException.class, montagem::fechar);
    }

    @Test
    void modalidadePadraoEBalcaoQuandoNaoEspecificada() {
        Pedido pedido = new MontagemPedido()
                .pagarCom(new PagamentoDinheiro())
                .comLanche(new XBurguer())
                .fechar();
        assertInstanceOf(PedidoBalcao.class, pedido);
    }

    @Test
    void ordemDosPassosNaoAfetaResultado() {
        Pedido a = new MontagemPedido()
                .paraDelivery()
                .pagarCom(new PagamentoDinheiro())
                .comLanche(new XBurguer())
                .fechar();
        Pedido b = new MontagemPedido()
                .comLanche(new XBurguer())
                .pagarCom(new PagamentoDinheiro())
                .paraDelivery()
                .fechar();
        assertEquals(a.getTotal(), b.getTotal(), DELTA);
    }
}
