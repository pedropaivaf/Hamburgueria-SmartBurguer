package br.com.hamburgueria;

/**
 * Mediator — setor de atendimento ao cliente (atende + entrega).
 */
public class SetorBalcao extends SetorRestaurante {
    public SetorBalcao() { super("Balcao"); }

    public void registrarPedido(Ficha ficha) {
        System.out.println("[Balcao] Pedido " + ficha.getNumeroPedido() + " registrado.");
        enviarEvento("PEDIDO_REGISTRADO", ficha);
    }

    public void entregarPedido(Ficha ficha) {
        System.out.println("[Balcao] Entregando pedido " + ficha.getNumeroPedido() + " ao cliente.");
        ficha.entregar();
    }

    @Override
    public void receberEvento(String evento, Ficha ficha) {
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[Balcao] Sinal: pedido " + ficha.getNumeroPedido() + " pronto para retirada.");
        }
    }
}
