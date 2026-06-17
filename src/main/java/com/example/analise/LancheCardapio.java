package com.example.analise;

/**
 * Visitor — elemento concreto: lanche registrado no cardapio com dados nutricionais.
 */
public class LancheCardapio implements ItemVisitavel {
    private final String nome;
    private final double preco;
    private final int calorias;
    private final double percentualImposto;

    public LancheCardapio(String nome, double preco, int calorias, double percentualImposto) {
        this.nome              = nome;
        this.preco             = preco;
        this.calorias          = calorias;
        this.percentualImposto = percentualImposto;
    }

    @Override public String aceitar(VisitanteCardapio v) { return v.visitarLancheCardapio(this); }
    @Override public String getNome()    { return nome; }
    @Override public double getPreco()   { return preco; }
    public int getCalorias()             { return calorias; }
    public double getPercentualImposto() { return percentualImposto; }
}
