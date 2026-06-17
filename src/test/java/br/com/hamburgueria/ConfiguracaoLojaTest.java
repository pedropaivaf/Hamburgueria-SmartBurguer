package br.com.hamburgueria;

import br.com.hamburgueria.cardapio.*;
import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.loja.*;
import br.com.hamburgueria.pagamento.*;
import br.com.hamburgueria.pedido.*;

import br.com.hamburgueria.cardapio.*;
import br.com.hamburgueria.lanche.*;
import br.com.hamburgueria.loja.*;
import br.com.hamburgueria.pagamento.*;
import br.com.hamburgueria.pedido.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Valida o padrao Singleton: getInstancia() sempre devolve a mesma
 * instancia e mudancas de configuracao sao visiveis para toda a
 * aplicacao (PedidoDelivery, PagamentoPix, PagamentoCartao, Combo).
 */
class ConfiguracaoLojaTest {

    private static final double DELTA = 0.0001;

    @AfterEach
    void resetarConfiguracaoParaPadrao() {
        ConfiguracaoLoja c = ConfiguracaoLoja.getInstancia();
        c.setTaxaEntrega(8.00);
        c.setDescontoPix(0.05);
        c.setTaxaCartao(0.03);
        c.setDescontoCombo(0.10);
    }

    @Test
    void getInstanciaSempreDevolveOMesmoObjeto() {
        ConfiguracaoLoja a = ConfiguracaoLoja.getInstancia();
        ConfiguracaoLoja b = ConfiguracaoLoja.getInstancia();
        assertSame(a, b);
    }

    @Test
    void valoresPadraoEstaoCorretos() {
        ConfiguracaoLoja c = ConfiguracaoLoja.getInstancia();
        assertEquals(8.00, c.getTaxaEntrega(), DELTA);
        assertEquals(0.05, c.getDescontoPix(), DELTA);
        assertEquals(0.03, c.getTaxaCartao(), DELTA);
        assertEquals(0.10, c.getDescontoCombo(), DELTA);
    }

    @Test
    void mudarTaxaEntregaAfetaPedidoDelivery() {
        ConfiguracaoLoja.getInstancia().setTaxaEntrega(15.00);
        Pedido pedido = new PedidoDelivery(new PagamentoDinheiro())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00 + 15.00, pedido.getTotal(), DELTA);
    }

    @Test
    void mudarDescontoPixAfetaPagamentoPix() {
        ConfiguracaoLoja.getInstancia().setDescontoPix(0.20);
        Pedido pedido = new PedidoBalcao(new PagamentoPix())
                .adicionarLanche(new XBurguer());
        assertEquals(16.00 * 0.80, pedido.getTotal(), DELTA);
    }

    @Test
    void mudarDescontoComboAfetaCombo() {
        ConfiguracaoLoja.getInstancia().setDescontoCombo(0.50);
        Combo combo = new CardapioTradicional().montarCombo();
        assertEquals((16.00 + 7.00 + 10.00) * 0.50, combo.getPreco(), DELTA);
    }
}
