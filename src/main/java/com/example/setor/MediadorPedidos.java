package com.example.setor;

import com.example.ficha.*;

/**
 * Mediator — interface da central que coordena os setores do restaurante.
 */
public interface MediadorPedidos {
    void registrar(SetorRestaurante setor);
    void notificar(SetorRestaurante origem, String evento, Ficha ficha);
}
