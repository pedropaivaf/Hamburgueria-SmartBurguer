package br.com.hamburgueria;

/**
 * Chain of Responsibility — verifica se a forma de pagamento e aceita.
 */
public class ValidadorPagamento extends ValidadorPedido {
    @Override
    public boolean validar(PedidoBalcao pedido) {
        if (pedido.getFormaPagamento() == null) {
            System.out.println("[Pagamento] Forma de pagamento ausente — rejeitado.");
            return false;
        }
        System.out.println("[Pagamento] Pagamento valido — ok.");
        return passarAdiante(pedido);
    }
}
