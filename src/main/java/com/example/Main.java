package com.example;

import com.example.adicional.*;
import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.loja.*;
import com.example.modelo.*;
import com.example.notificacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;

import com.example.adicional.*;
import com.example.cardapio.*;
import com.example.lanche.*;
import com.example.loja.*;
import com.example.modelo.*;
import com.example.notificacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;

public class Main {

    public static void main(String[] args) {
        separador("1) DECORATOR - adicionais sobre um lanche");
        Lanche xsaladaCompleto = new Bacon(new QueijoExtra(new Ovo(new XSalada())));
        System.out.println(xsaladaCompleto.imprimirFicha());

        separador("2) ABSTRACT FACTORY - montando combos por familia");
        Cardapio cardapioTradicional = new CardapioTradicional();
        Cardapio cardapioVegano = new CardapioVegano();
        Combo tradicional = cardapioTradicional.montarCombo();
        Combo vegano = cardapioVegano.montarCombo();
        System.out.println(tradicional.imprimirFicha());
        System.out.println();
        System.out.println(vegano.imprimirFicha());

        separador("3) BRIDGE - Pedido (Balcao/Delivery) x FormaPagamento (Pix/Cartao)");
        FormaPagamento pix = new PagamentoPix();
        Pedido pedidoBalcao = new PedidoBalcao(pix)
                .adicionarLanche(new Bacon(new XBurguer()))
                .adicionarCombo(tradicional);
        System.out.println(pedidoBalcao.imprimirCupom());
        System.out.println();

        FormaPagamento cartao = new PagamentoCartao();
        Pedido pedidoDelivery = new PedidoDelivery(cartao)
                .adicionarCombo(vegano)
                .adicionarLanche(xsaladaCompleto);
        System.out.println(pedidoDelivery.imprimirCupom());

        separador("4) BUILDER - montando um pedido passo a passo");
        Pedido pedidoMontado = new MontagemPedido()
                .paraDelivery()
                .pagarCom(new PagamentoPix())
                .comLanche(new QueijoExtra(new XTudo()))
                .comCombo(tradicional)
                .fechar();
        System.out.println(pedidoMontado.imprimirCupom());

        separador("5) SINGLETON - configuracao global da loja");
        ConfiguracaoLoja config = ConfiguracaoLoja.getInstancia();
        System.out.println("Taxa de entrega:     R$ " + config.getTaxaEntrega());
        System.out.println("Desconto Pix:        " + (config.getDescontoPix() * 100) + "%");
        System.out.println("Taxa cartao:         " + (config.getTaxaCartao() * 100) + "%");
        System.out.println("Desconto combo:      " + (config.getDescontoCombo() * 100) + "%");
        System.out.println("Mesma instancia? " + (config == ConfiguracaoLoja.getInstancia()));

        separador("6) FACTORY METHOD - atendente cria FormaPagamento por codigo");
        Atendente atendente = new Atendente();
        FormaPagamento porCodigo = atendente.prepararPagamento("pix");
        Pedido pedidoFactory = new MontagemPedido()
                .noBalcao()
                .pagarCom(porCodigo)
                .comLanche(new XBurguer())
                .fechar();
        System.out.println("Pagamento criado pelo atendente: " + porCodigo.getNome());
        System.out.println("Total do pedido: R$ " + String.format("%.2f", pedidoFactory.getTotal()));

        separador("7) OBSERVER - acompanhantes reagem a mudanca de Status");
        Pedido pedidoObservado = new MontagemPedido()
                .paraDelivery()
                .pagarCom(new PagamentoDinheiro())
                .comLanche(new XBurguer())
                .fechar();
        pedidoObservado.adicionarAcompanhante(new Cozinha());
        pedidoObservado.adicionarAcompanhante(new PainelCliente());
        pedidoObservado.mudarStatus(Status.PREPARANDO);
        pedidoObservado.mudarStatus(Status.PRONTO);
        pedidoObservado.mudarStatus(Status.ENTREGUE);
    }

    private static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println(titulo);
        System.out.println("============================================================");
    }
}
