package br.com.hamburgueria;

/**
 * Adapter — adapta ApiIFood para PlataformaDeliveryExterno.
 */
public class AdaptadorIFood implements PlataformaDeliveryExterno {
    private final ApiIFood apiIFood;

    public AdaptadorIFood(ApiIFood apiIFood) { this.apiIFood = apiIFood; }

    @Override
    public boolean enviarPedido(String numeroPedido, String enderecoEntrega, double valorTotal) {
        int centavos = (int) Math.round(valorTotal * 100);
        String resposta = apiIFood.postOrder(numeroPedido, enderecoEntrega, centavos);
        return "IFOOD_OK".equals(resposta);
    }

    @Override
    public String consultarStatusEntrega(String numeroPedido) {
        String raw = apiIFood.getDeliveryStatus(numeroPedido);
        return raw.contains("TRANSIT") ? "Em transito" : "Status desconhecido";
    }
}
