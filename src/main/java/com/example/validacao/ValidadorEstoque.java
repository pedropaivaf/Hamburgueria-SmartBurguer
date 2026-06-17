package com.example.validacao;

import com.example.pedido.*;

/**
 * Chain of Responsibility — verifica se o cardapio tem itens disponiveis.
 */
public class ValidadorEstoque extends ValidadorPedido {
    @Override
    public boolean validar(PedidoBalcao pedido) {
        if (pedido.getLanches().isEmpty() && pedido.getCombos().isEmpty()) {
            System.out.println("[Estoque] Pedido sem itens — rejeitado.");
            return false;
        }
        System.out.println("[Estoque] Itens em estoque — ok.");
        return passarAdiante(pedido);
    }
}
