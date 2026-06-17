package com.example.validacao;

import com.example.pedido.*;

import java.time.LocalTime;

/**
 * Chain of Responsibility — verifica se o pedido foi feito dentro do horario.
 */
public class ValidadorHorario extends ValidadorPedido {
    private final LocalTime abertura;
    private final LocalTime fechamento;

    public ValidadorHorario(LocalTime abertura, LocalTime fechamento) {
        this.abertura   = abertura;
        this.fechamento = fechamento;
    }

    @Override
    public boolean validar(PedidoBalcao pedido) {
        LocalTime agora = LocalTime.now();
        if (agora.isBefore(abertura) || agora.isAfter(fechamento)) {
            System.out.println("[Horario] Fora do horario de atendimento — rejeitado.");
            return false;
        }
        System.out.println("[Horario] Dentro do horario — ok.");
        return passarAdiante(pedido);
    }
}
