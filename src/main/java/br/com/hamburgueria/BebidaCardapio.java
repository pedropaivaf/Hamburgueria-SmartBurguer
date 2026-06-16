package br.com.hamburgueria;

/**
 * Visitor — elemento concreto: bebida registrada no cardapio.
 */
public class BebidaCardapio implements ItemVisitavel {
    private final String nome;
    private final double preco;
    private final int calorias;
    private final boolean alcoolica;

    public BebidaCardapio(String nome, double preco, int calorias, boolean alcoolica) {
        this.nome      = nome;
        this.preco     = preco;
        this.calorias  = calorias;
        this.alcoolica = alcoolica;
    }

    @Override public String aceitar(VisitanteCardapio v) { return v.visitarBebidaCardapio(this); }
    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }
    public int getCalorias()           { return calorias; }
    public boolean isAlcoolica()       { return alcoolica; }
}
