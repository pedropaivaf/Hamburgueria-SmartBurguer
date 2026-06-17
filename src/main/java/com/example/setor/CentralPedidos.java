package com.example.setor;

import com.example.ficha.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator — implementacao concreta que coordena todos os setores.
 */
public class CentralPedidos implements MediadorPedidos {
    private final List<SetorRestaurante> setores = new ArrayList<>();

    @Override
    public void registrar(SetorRestaurante setor) {
        setor.setMediador(this);
        setores.add(setor);
    }

    @Override
    public void notificar(SetorRestaurante origem, String evento, Ficha ficha) {
        for (SetorRestaurante s : setores) {
            if (s != origem) s.receberEvento(evento, ficha);
        }
    }
}
