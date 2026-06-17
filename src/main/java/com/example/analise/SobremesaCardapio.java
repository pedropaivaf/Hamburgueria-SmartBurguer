package com.example.analise;

/**
 * Visitor — elemento concreto: sobremesa registrada no cardapio.
 */
public class SobremesaCardapio implements ItemVisitavel {
    private final String nome;
    private final double preco;
    private final int calorias;

    public SobremesaCardapio(String nome, double preco, int calorias) {
        this.nome     = nome;
        this.preco    = preco;
        this.calorias = calorias;
    }

    @Override public String aceitar(VisitanteCardapio v) { return v.visitarSobremesaCardapio(this); }
    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }
    public int getCalorias()           { return calorias; }
}
