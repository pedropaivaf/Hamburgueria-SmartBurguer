package com.example.setor;

import com.example.ficha.*;

/**
 * Mediator — colaborador abstrato; cada setor conhece apenas o mediador.
 */
public abstract class SetorRestaurante {
    protected final String nome;
    protected MediadorPedidos mediador;

    public SetorRestaurante(String nome) { this.nome = nome; }

    public void setMediador(MediadorPedidos mediador) { this.mediador = mediador; }
    public String getNome()                           { return nome; }

    public abstract void receberEvento(String evento, Ficha ficha);

    protected void enviarEvento(String evento, Ficha ficha) {
        if (mediador != null) mediador.notificar(this, evento, ficha);
    }
}
