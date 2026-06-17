package com.example.loja;

import com.example.desconto.*;
import com.example.ficha.*;
import com.example.lanche.*;
import com.example.operacao.*;
import com.example.pagamento.*;
import com.example.pedido.*;
import com.example.setor.*;

/**
 * Facade — ponto de entrada simplificado para as operacoes mais comuns
 * do sistema SmartBurguer, ocultando a complexidade dos subsistemas.
 *
 * Coordena: Builder, Factory Method, Abstract Factory, Observer,
 * State, Mediator, Strategy, Command e Chain of Responsibility.
 */
public class SmartBurguerFachada {

    private final CentralPedidos central   = new CentralPedidos();
    private final SetorBalcao    balcao    = new SetorBalcao();
    private final SetorCozinha   cozinha   = new SetorCozinha();
    private final SetorEntrega   entrega   = new SetorEntrega();
    private final ControleOrdens controle  = new ControleOrdens();
    private final CaixaRegistradora caixa = new CaixaRegistradora(new SemPoliticaDesconto());

    public SmartBurguerFachada() {
        central.registrar(balcao);
        central.registrar(cozinha);
        central.registrar(entrega);
    }

    /**
     * Abre um pedido balcao com o HamburguerSimples, inicia preparo e
     * retorna a Ficha criada — tudo em uma unica chamada.
     */
    public Ficha realizarPedidoRapido(String numeroPedido, FormaPagamento pagamento) {
        // Builder
        PedidoBalcao pedido = (PedidoBalcao) new MontagemPedido()
                .pagarCom(pagamento)
                .noBalcao()
                .comLanche(new HamburguerSimples())
                .fechar();

        // Command — adiciona o padrao lanche ao pedido
        Lanche hamburguer = new HamburguerSimples();
        controle.executar(new AdicionarLancheNaFicha(pedido, hamburguer));

        // State + Mediator
        Ficha ficha = new Ficha(numeroPedido);
        balcao.registrarPedido(ficha);
        cozinha.prepararPedido(ficha);

        // Strategy (politica configuravel)
        double total = caixa.calcularTotalComDesconto(pedido.getTotal());
        System.out.printf("Fachada: total cobrado R$ %.2f%n", total);

        return ficha;
    }

    /** Conclui o preparo e sinaliza entrega ao balcao. */
    public boolean concluirEEntregar(Ficha ficha) {
        cozinha.concluirPedido(ficha);
        return "Entregue".equals(ficha.getSituacao())
            || "Pronta".equals(ficha.getSituacao());
    }

    /** Troca a politica de desconto da caixa. */
    public void setPoliticaDesconto(PoliticaDesconto politica) {
        caixa.setPolitica(politica);
    }

    public ControleOrdens getControleOrdens() { return controle; }
    public CaixaRegistradora getCaixa()       { return caixa; }
}
