package br.com.hamburgueria;

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
