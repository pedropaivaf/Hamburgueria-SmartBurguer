package br.com.hamburgueria;

import java.util.ArrayList;
import java.util.List;

/**
 * State — Subject que delega comportamento ao FichaEstado atual.
 * Observer — notifica Acompanhantes a cada transicao de estado.
 * Representa o ticket fisico enviado a cozinha para cada pedido.
 */
public class Ficha {
    private final String numeroPedido;
    private FichaEstado estado;
    private final List<Acompanhante> acompanhantes = new ArrayList<>();

    public Ficha(String numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.estado = FichaEstadoPendente.getInstance();
    }

    public void setEstado(FichaEstado estado) {
        this.estado = estado;
        for (Acompanhante a : acompanhantes) {
            a.avisar(null, Status.valueOf(traduzir(estado.getSituacao())));
        }
    }

    private String traduzir(String situacao) {
        return switch (situacao) {
            case "Em Preparo" -> "PREPARANDO";
            case "Pronta"     -> "PRONTO";
            case "Entregue"   -> "ENTREGUE";
            default           -> "RECEBIDO";
        };
    }

    public boolean iniciarPreparo() { return estado.iniciarPreparo(this); }
    public boolean concluir()       { return estado.concluir(this); }
    public boolean entregar()       { return estado.entregar(this); }
    public boolean cancelar()       { return estado.cancelar(this); }

    public String getSituacao()     { return estado.getSituacao(); }
    public FichaEstado getEstado()  { return estado; }
    public String getNumeroPedido() { return numeroPedido; }

    public void adicionarAcompanhante(Acompanhante a) { acompanhantes.add(a); }
    public void removerAcompanhante(Acompanhante a)   { acompanhantes.remove(a); }
}
