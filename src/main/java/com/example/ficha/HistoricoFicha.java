package com.example.ficha;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Memento — Caretaker: empilha e restaura snapshots de Ficha.
 */
public class HistoricoFicha {
    private final Deque<SnapshotFicha> pilha = new ArrayDeque<>();

    public void salvar(Ficha ficha) {
        SnapshotFicha snap = new SnapshotFicha(ficha.getNumeroPedido(), ficha.getSituacao());
        pilha.push(snap);
        System.out.println("Historico: salvo " + snap);
    }

    public SnapshotFicha desfazer() {
        if (pilha.isEmpty()) return null;
        return pilha.pop();
    }

    public int tamanho() { return pilha.size(); }
}
