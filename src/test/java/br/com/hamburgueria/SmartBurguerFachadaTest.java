package br.com.hamburgueria;

import br.com.hamburgueria.desconto.*;
import br.com.hamburgueria.ficha.*;
import br.com.hamburgueria.loja.*;
import br.com.hamburgueria.pagamento.*;

import br.com.hamburgueria.desconto.*;
import br.com.hamburgueria.ficha.*;
import br.com.hamburgueria.loja.*;
import br.com.hamburgueria.pagamento.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Facade: SmartBurguerFachada simplifica as operacoes
 * mais comuns do sistema em chamadas de alto nivel.
 */
class SmartBurguerFachadaTest {

    @Test
    void realizarPedidoRapidoRetornaFichaEmPreparo() {
        SmartBurguerFachada app = new SmartBurguerFachada();
        Ficha ficha = app.realizarPedidoRapido("F001", new PagamentoDinheiro());
        assertEquals("Em Preparo", ficha.getSituacao());
    }

    @Test
    void concluirEEntregarProgrideEstado() {
        SmartBurguerFachada app = new SmartBurguerFachada();
        Ficha ficha = app.realizarPedidoRapido("F002", new PagamentoPix());
        assertTrue(app.concluirEEntregar(ficha));
    }

    @Test
    void fachadaRegistraComandoNoHistorico() {
        SmartBurguerFachada app = new SmartBurguerFachada();
        app.realizarPedidoRapido("F003", new PagamentoCartao());
        assertTrue(app.getControleOrdens().totalNoHistorico() >= 1);
    }

    @Test
    void politicaDeDescontoEhTrocavelViaFachada() {
        SmartBurguerFachada app = new SmartBurguerFachada();
        app.setPoliticaDesconto(new DescontoClubeFidelidade());
        double totalComDesc = app.getCaixa().calcularTotalComDesconto(100.0);
        assertEquals(90.0, totalComDesc, 0.001);
    }
}
