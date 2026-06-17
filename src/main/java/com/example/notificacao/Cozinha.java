package com.example.notificacao;

import com.example.modelo.*;
import com.example.pedido.*;

/**
 * Observer concreto.
 * Reage a mudancas de Status do Pedido do ponto de vista da cozinha:
 * sabe quando comecar a preparar e quando o item esta pronto.
 */
public class Cozinha implements Acompanhante {

    @Override
    public void avisar(Pedido pedido, Status novoStatus) {
        switch (novoStatus) {
            case RECEBIDO:
                System.out.println("[COZINHA] Pedido recebido, aguardando inicio.");
                break;
            case PREPARANDO:
                System.out.println("[COZINHA] Preparando o pedido agora.");
                break;
            case PRONTO:
                System.out.println("[COZINHA] Pedido pronto para entrega/balcao.");
                break;
            case ENTREGUE:
                System.out.println("[COZINHA] Pedido entregue, encerrando ordem.");
                break;
        }
    }
}
