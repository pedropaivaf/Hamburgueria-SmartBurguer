package br.com.hamburgueria;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Abstraction do padrao Bridge.
 * Mantem a referencia para FormaPagamento (implementor) e delega nela
 * a aplicacao do ajuste financeiro. Subclasses (PedidoBalcao, PedidoDelivery)
 * variam a modalidade do pedido sem precisar multiplicar com as formas de
 * pagamento — qualquer combinacao funciona.
 *
 * Tambem assume o papel de Subject do padrao Observer: mantem uma lista
 * de Acompanhantes interessados em mudancas de Status e os notifica
 * sempre que mudarStatus() e chamado.
 */
public abstract class Pedido {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    protected final FormaPagamento formaPagamento;
    protected final List<Lanche> lanches = new ArrayList<>();
    protected final List<Combo> combos = new ArrayList<>();
    protected final List<Acompanhante> acompanhantes = new ArrayList<>();
    protected Status status = Status.RECEBIDO;

    protected Pedido(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Pedido adicionarLanche(Lanche lanche) {
        lanches.add(lanche);
        return this;
    }

    public Pedido adicionarCombo(Combo combo) {
        combos.add(combo);
        return this;
    }

    public Pedido adicionarAcompanhante(Acompanhante acompanhante) {
        acompanhantes.add(acompanhante);
        return this;
    }

    public Pedido removerAcompanhante(Acompanhante acompanhante) {
        acompanhantes.remove(acompanhante);
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void mudarStatus(Status novoStatus) {
        this.status = novoStatus;
        for (Acompanhante a : acompanhantes) {
            a.avisar(this, novoStatus);
        }
    }

    public double getSubtotalItens() {
        double soma = 0.0;
        for (Lanche l : lanches) {
            soma += l.getPreco();
        }
        for (Combo c : combos) {
            soma += c.getPreco();
        }
        return soma;
    }

    /**
     * Acrescimo/ajuste que a modalidade do pedido aplica sobre os itens.
     * Ex.: delivery soma taxa de entrega; balcao nao altera.
     */
    public abstract double getTaxaModalidade();

    public abstract String getModalidade();

    public double getTotal() {
        double subtotal = getSubtotalItens() + getTaxaModalidade();
        return formaPagamento.aplicarSobre(subtotal);
    }

    public Pedido removerLanche(Lanche lanche) {
        lanches.remove(lanche);
        return this;
    }

    public List<Lanche> getLanches()            { return lanches; }
    public List<Combo>  getCombos()             { return combos; }
    public FormaPagamento getFormaPagamento()    { return formaPagamento; }

    public String imprimirCupom() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CUPOM - ").append(getModalidade()).append(" ===").append(System.lineSeparator());
        for (Lanche l : lanches) {
            sb.append("  ").append(l.imprimirFicha()).append(System.lineSeparator());
        }
        for (Combo c : combos) {
            sb.append(c.imprimirFicha()).append(System.lineSeparator());
        }
        sb.append(String.format(PT_BR, "Subtotal itens:    R$ %.2f%n", getSubtotalItens()));
        sb.append(String.format(PT_BR, "Taxa %s: R$ %.2f%n", getModalidade().toLowerCase(), getTaxaModalidade()));
        sb.append(String.format(PT_BR, "Pagamento:         %s%n", formaPagamento.getNome()));
        sb.append(String.format(PT_BR, "TOTAL:             R$ %.2f", getTotal()));
        return sb.toString();
    }
}
