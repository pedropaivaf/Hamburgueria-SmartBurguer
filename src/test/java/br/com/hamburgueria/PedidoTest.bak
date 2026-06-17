package br.com.hamburgueria;

import br.com.hamburgueria.cardapio.*;
import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.pagamento.*;
import br.com.hamburgueria.pedido.*;

import br.com.hamburgueria.cardapio.*;
import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.pagamento.*;
import br.com.hamburgueria.pedido.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Valida o padrao Bridge: qualquer subclasse de Pedido (abstraction)
 * pode ser combinada com qualquer FormaPagamento (implementor) sem
 * subclasses cruzadas. Balcao nao tem taxa; Delivery soma R$ 8,00.
 * Pix da 5% de desconto; Cartao cobra 3% de taxa; Dinheiro e neutro.
 */
class PedidoTest {

    private static final double DELTA = 0.0001;

    @Test
    void balcaoComDinheiroNaoAlteraSubtotal() {
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00, pedido.getTotal(), DELTA);
    }

    @Test
    void balcaoComPixAplicaCincoPorCentoDeDesconto() {
        Pedido pedido = new PedidoBalcao(new PagamentoPix())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00 * 0.95, pedido.getTotal(), DELTA);
    }

    @Test
    void balcaoComCartaoAplicaTresPorCentoDeTaxa() {
        Pedido pedido = new PedidoBalcao(new PagamentoCartao())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00 * 1.03, pedido.getTotal(), DELTA);
    }

    @Test
    void deliveryComDinheiroApenasSomaTaxaDeEntrega() {
        Pedido pedido = new PedidoDelivery(new PagamentoDinheiro())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00 + 8.00, pedido.getTotal(), DELTA);
    }

    @Test
    void deliveryComPixSomaTaxaEAplicaDesconto() {
        Pedido pedido = new PedidoDelivery(new PagamentoPix())
                .adicionarLanche(new XBurguer());
        assertEquals((16.00 + 8.00) * 0.95, pedido.getTotal(), DELTA);
    }

    @Test
    void deliveryComCartaoSomaTaxaEAplicaTaxaDoCartao() {
        Pedido pedido = new PedidoDelivery(new PagamentoCartao())
                .adicionarLanche(new XBurguer());
        assertEquals((16.00 + 8.00) * 1.03, pedido.getTotal(), DELTA);
    }

    @Test
    void pedidoAceitaCombinarLanchesEComboNoMesmoCarrinho() {
        var combo = new CardapioTradicional().montarCombo();
        Pedido pedido = new PedidoBalcao(new PagamentoDinheiro())
                .adicionarLanche(new XBurguer())
                .adicionarCombo(combo);
        double esperado = 16.00 + combo.getPreco();
        assertEquals(esperado, pedido.getTotal(), DELTA);
    }
}
