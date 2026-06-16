package br.com.hamburgueria;

/**
 * Command — remove um lanche do pedido da ficha (reversivel).
 */
public class RemoverLancheDaFicha implements ComandoPedido {
    private final PedidoBalcao pedido;
    private final Lanche lanche;

    public RemoverLancheDaFicha(PedidoBalcao pedido, Lanche lanche) {
        this.pedido = pedido;
        this.lanche = lanche;
    }

    @Override public void executar()         { pedido.removerLanche(lanche); }
    @Override public void desfazer()         { pedido.adicionarLanche(lanche); }
    @Override public String descricao()      { return "Remover " + lanche.getDescricao(); }
}
