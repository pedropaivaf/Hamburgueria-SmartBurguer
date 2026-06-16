package br.com.hamburgueria;

/**
 * Chain of Responsibility — elo abstrato da cadeia de validacao de pedidos.
 */
public abstract class ValidadorPedido {
    protected ValidadorPedido proximo;

    public ValidadorPedido setProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract boolean validar(PedidoBalcao pedido);

    protected boolean passarAdiante(PedidoBalcao pedido) {
        if (proximo != null) return proximo.validar(pedido);
        return true;
    }
}
