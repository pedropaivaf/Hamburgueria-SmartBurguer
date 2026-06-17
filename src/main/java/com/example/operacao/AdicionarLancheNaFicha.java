package com.example.operacao;

import com.example.lanche.*;
import com.example.pedido.*;

/**
 * Command — adiciona um lanche ao pedido da ficha (reversivel).
 */
public class AdicionarLancheNaFicha implements ComandoPedido {
    private final PedidoBalcao pedido;
    private final Lanche lanche;

    public AdicionarLancheNaFicha(PedidoBalcao pedido, Lanche lanche) {
        this.pedido = pedido;
        this.lanche = lanche;
    }

    @Override public void executar()         { pedido.adicionarLanche(lanche); }
    @Override public void desfazer()         { pedido.removerLanche(lanche); }
    @Override public String descricao()      { return "Adicionar " + lanche.getDescricao(); }
}
