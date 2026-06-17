package br.com.hamburgueria.setor;

import br.com.hamburgueria.ficha.*;

/**
 * Mediator — setor de delivery; ativa rota de entrega ao receber sinal.
 */
public class SetorEntrega extends SetorRestaurante {
    public SetorEntrega() { super("Entrega"); }

    @Override
    public void receberEvento(String evento, Ficha ficha) {
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[Entrega] Iniciando rota para pedido " + ficha.getNumeroPedido() + ".");
            ficha.entregar();
        }
    }
}
