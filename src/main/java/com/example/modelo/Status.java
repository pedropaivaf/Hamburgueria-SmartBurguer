package com.example.modelo;

import com.example.pedido.*;

/**
 * Estados do ciclo de vida de um Pedido.
 * Cada transicao dispara notificacao para os Acompanhantes
 * registrados no Pedido (papel de "concrete observers" do Observer).
 */
public enum Status {
    RECEBIDO,
    PREPARANDO,
    PRONTO,
    ENTREGUE
}
