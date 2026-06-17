package br.com.hamburgueria.notificacao;

import br.com.hamburgueria.modelo.*;
import br.com.hamburgueria.pedido.*;

/**
 * Observer.
 * Contrato dos interessados em mudancas de Status do Pedido.
 * Implementacoes concretas (Cozinha, PainelCliente) recebem notificacao
 * sempre que o Pedido (subject) muda de estado.
 */
public interface Acompanhante {

    void avisar(Pedido pedido, Status novoStatus);
}
