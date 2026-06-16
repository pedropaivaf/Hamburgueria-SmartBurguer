package br.com.hamburgueria;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder do padrao Builder.
 * Permite montar um Pedido passo a passo, com encadeamento fluente,
 * deixando a escolha de modalidade (Balcao/Delivery) e forma de pagamento
 * postergada ate o momento de fechar() o pedido. Assim o cliente nao
 * precisa decidir tudo de uma vez no construtor e a ordem das chamadas
 * fica livre.
 */
public class MontagemPedido {

    private FormaPagamento formaPagamento;
    private boolean delivery = false;
    private final List<Lanche> lanches = new ArrayList<>();
    private final List<Combo> combos = new ArrayList<>();

    public MontagemPedido pagarCom(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public MontagemPedido noBalcao() {
        this.delivery = false;
        return this;
    }

    public MontagemPedido paraDelivery() {
        this.delivery = true;
        return this;
    }

    public MontagemPedido comLanche(Lanche lanche) {
        this.lanches.add(lanche);
        return this;
    }

    public MontagemPedido comCombo(Combo combo) {
        this.combos.add(combo);
        return this;
    }

    /**
     * Metodo terminal do Builder: valida o estado acumulado e
     * constroi o Pedido concreto da modalidade escolhida.
     */
    public Pedido fechar() {
        if (formaPagamento == null) {
            throw new IllegalStateException("Forma de pagamento e obrigatoria");
        }
        Pedido pedido = delivery
                ? new PedidoDelivery(formaPagamento)
                : new PedidoBalcao(formaPagamento);
        for (Lanche l : lanches) {
            pedido.adicionarLanche(l);
        }
        for (Combo c : combos) {
            pedido.adicionarCombo(c);
        }
        return pedido;
    }
}
