package com.example;

import com.example.lanche.*;
import com.example.pagamento.*;
import com.example.pedido.*;
import com.example.validacao.*;

import com.example.lanche.*;
import com.example.pagamento.*;
import com.example.pedido.*;
import com.example.validacao.*;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Chain of Responsibility: validadores encadeados
 * verificam estoque, pagamento e horario antes de confirmar o pedido.
 */
class ValidadorPedidoTest {

    @Test
    void pedidoValidoPassaPorTodaACadeia() {
        ValidadorPedido v1 = new ValidadorEstoque();
        ValidadorPedido v2 = new ValidadorPagamento();
        v1.setProximo(v2);

        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro())
                .noBalcao()
                .comLanche(new HamburguerSimples())
                .fechar();

        assertTrue(v1.validar(pedido));
    }

    @Test
    void pedidoSemItensEhRejeitadoNaValidacaoDeEstoque() {
        ValidadorPedido v = new ValidadorEstoque();
        PedidoBalcao vazio = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro())
                .noBalcao()
                .fechar();
        assertFalse(v.validar(vazio));
    }

    @Test
    void validadorDeHorarioAceitaDentroDoIntervalo() {
        LocalTime abertura   = LocalTime.of(0, 0);
        LocalTime fechamento = LocalTime.of(23, 59);
        ValidadorPedido vh = new ValidadorHorario(abertura, fechamento);

        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoDinheiro())
                .noBalcao()
                .comLanche(new HamburguerSimples())
                .fechar();

        assertTrue(vh.validar(pedido));
    }

    @Test
    void validadoresSaoEncadeaveis() {
        ValidadorEstoque estoque     = new ValidadorEstoque();
        ValidadorPagamento pagamento = new ValidadorPagamento();
        ValidadorHorario horario     = new ValidadorHorario(LocalTime.of(0,0), LocalTime.of(23,59));
        estoque.setProximo(pagamento).setProximo(horario);

        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(new PagamentoPix())
                .noBalcao()
                .comLanche(new XBurguer())
                .fechar();

        assertTrue(estoque.validar(pedido));
    }
}
