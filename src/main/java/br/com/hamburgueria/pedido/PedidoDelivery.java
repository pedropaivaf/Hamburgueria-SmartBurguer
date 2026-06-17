package br.com.hamburgueria.pedido;

import br.com.hamburgueria.loja.*;
import br.com.hamburgueria.pagamento.*;

public class PedidoDelivery extends Pedido {

    public PedidoDelivery(FormaPagamento formaPagamento) {
        super(formaPagamento);
    }

    @Override
    public String getModalidade() {
        return "Delivery";
    }

    @Override
    public double getTaxaModalidade() {
        return ConfiguracaoLoja.getInstancia().getTaxaEntrega();
    }
}
