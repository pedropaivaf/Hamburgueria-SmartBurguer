package br.com.hamburgueria.setor;

import br.com.hamburgueria.ficha.*;
import br.com.hamburgueria.notificacao.*;
import br.com.hamburgueria.pedido.*;

/**
 * Mediator — setor de preparo dos pedidos.
 */
public class SetorCozinha extends SetorRestaurante {
    public SetorCozinha() { super("Cozinha"); }

    public void prepararPedido(Ficha ficha) {
        ficha.iniciarPreparo();
        System.out.println("[Cozinha] Preparando pedido " + ficha.getNumeroPedido() + "...");
    }

    public void concluirPedido(Ficha ficha) {
        ficha.concluir();
        System.out.println("[Cozinha] Pedido " + ficha.getNumeroPedido() + " concluido.");
        enviarEvento("PEDIDO_PRONTO", ficha);
    }

    @Override
    public void receberEvento(String evento, Ficha ficha) {
        if ("PEDIDO_REGISTRADO".equals(evento)) {
            System.out.println("[Cozinha] Novo pedido recebido: " + ficha.getNumeroPedido());
        }
    }
}
