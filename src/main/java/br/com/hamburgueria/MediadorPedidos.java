package br.com.hamburgueria;

/**
 * Mediator — interface da central que coordena os setores do restaurante.
 */
public interface MediadorPedidos {
    void registrar(SetorRestaurante setor);
    void notificar(SetorRestaurante origem, String evento, Ficha ficha);
}
