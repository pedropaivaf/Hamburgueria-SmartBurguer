package br.com.hamburgueria;

/**
 * Adapter — interface alvo que o sistema SmartBurguer conhece.
 */
public interface PlataformaDeliveryExterno {
    boolean enviarPedido(String numeroPedido, String enderecoEntrega, double valorTotal);
    String consultarStatusEntrega(String numeroPedido);
}
