package br.com.hamburgueria;

/**
 * Memento — armazena o estado interno de uma Ficha num dado instante.
 * Classe imutavel; somente FichaOriginator pode criar e ler snapshots.
 */
public class SnapshotFicha {
    private final String numeroPedido;
    private final String situacao;

    SnapshotFicha(String numeroPedido, String situacao) {
        this.numeroPedido = numeroPedido;
        this.situacao     = situacao;
    }

    String getNumeroPedido() { return numeroPedido; }
    String getSituacao()     { return situacao; }

    @Override
    public String toString() {
        return "Snapshot[pedido=" + numeroPedido + ", situacao=" + situacao + "]";
    }
}
