package br.com.hamburgueria;

import br.com.hamburgueria.pagamento.*;

import br.com.hamburgueria.pagamento.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Valida o padrao Factory Method: o Atendente recebe um codigo
 * e devolve a FormaPagamento concreta correspondente, sem que o
 * cliente precise instanciar diretamente.
 */
class AtendenteTest {

    @Test
    void pixProduzPagamentoPix() {
        FormaPagamento p = new Atendente().prepararPagamento("pix");
        assertInstanceOf(PagamentoPix.class, p);
    }

    @Test
    void cartaoProduzPagamentoCartao() {
        FormaPagamento p = new Atendente().prepararPagamento("cartao");
        assertInstanceOf(PagamentoCartao.class, p);
    }

    @Test
    void dinheiroProduzPagamentoDinheiro() {
        FormaPagamento p = new Atendente().prepararPagamento("dinheiro");
        assertInstanceOf(PagamentoDinheiro.class, p);
    }

    @Test
    void codigoEmCaixaAltaTambemFunciona() {
        FormaPagamento p = new Atendente().prepararPagamento("PIX");
        assertInstanceOf(PagamentoPix.class, p);
    }

    @Test
    void cartaoComAcentoTambemFunciona() {
        FormaPagamento p = new Atendente().prepararPagamento("cartão");
        assertInstanceOf(PagamentoCartao.class, p);
    }

    @Test
    void codigoDesconhecidoLancaErro() {
        Atendente a = new Atendente();
        assertThrows(IllegalArgumentException.class, () -> a.prepararPagamento("boleto"));
    }

    @Test
    void codigoNuloLancaErro() {
        Atendente a = new Atendente();
        assertThrows(IllegalArgumentException.class, () -> a.prepararPagamento(null));
    }
}
