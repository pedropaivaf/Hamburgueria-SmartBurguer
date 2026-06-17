package br.com.hamburgueria.ficha;

/**
 * Memento — armazena o estado interno de uma Ficha num dado instante.
 * Classe imutavel; somente FichaOriginator pode criar e ler snapshots.
 */
public class SnapshotFicha {
    private final String numeroPedido;
    private final String situacao;

    public SnapshotFicha(String numeroPedido, String situacao) {
        this.numeroPedido = numeroPedido;
        this.situacao     = situacao;
    }

    public String getNumeroPedido() { return numeroPedido; }
    public String getSituacao()     { return situacao; }

    @Override
    public String toString() {
        return "Snapshot[pedido=" + numeroPedido + ", situacao=" + situacao + "]";
    }
}
