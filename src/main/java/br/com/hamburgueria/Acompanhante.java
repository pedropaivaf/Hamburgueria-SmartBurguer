package br.com.hamburgueria;

/**
 * Observer.
 * Contrato dos interessados em mudancas de Status do Pedido.
 * Implementacoes concretas (Cozinha, PainelCliente) recebem notificacao
 * sempre que o Pedido (subject) muda de estado.
 */
public interface Acompanhante {

    void avisar(Pedido pedido, Status novoStatus);
}
