package com.example.notificacao;

import com.example.modelo.*;
import com.example.pedido.*;

/**
 * Observer concreto.
 * Mostra ao cliente o status atual do seu pedido em linguagem
 * amigavel, sempre que o Pedido (subject) muda de estado.
 */
public class PainelCliente implements Acompanhante {

    @Override
    public void avisar(Pedido pedido, Status novoStatus) {
        switch (novoStatus) {
            case RECEBIDO:
                System.out.println("[CLIENTE] Recebemos seu pedido, obrigado!");
                break;
            case PREPARANDO:
                System.out.println("[CLIENTE] Seu pedido ja esta sendo preparado.");
                break;
            case PRONTO:
                System.out.println("[CLIENTE] Seu pedido esta pronto!");
                break;
            case ENTREGUE:
                System.out.println("[CLIENTE] Pedido entregue. Bom apetite!");
                break;
        }
    }
}
