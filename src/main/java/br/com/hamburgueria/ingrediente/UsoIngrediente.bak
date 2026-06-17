package br.com.hamburgueria.ingrediente;

/**
 * Flyweight — parte extrinseca: uso especifico do ingrediente em um lanche.
 * Combina o flyweight (TipoIngrediente) com dados variaveis (quantidade, obs.).
 */
public class UsoIngrediente {
    private final TipoIngrediente tipo;   // compartilhado
    private final int quantidade;         // extrinseco
    private final String observacao;      // extrinseco

    public UsoIngrediente(TipoIngrediente tipo, int quantidade, String observacao) {
        this.tipo        = tipo;
        this.quantidade  = quantidade;
        this.observacao  = observacao;
    }

    public TipoIngrediente getTipo()  { return tipo; }
    public int getQuantidade()        { return quantidade; }
    public String getObservacao()     { return observacao; }

    @Override
    public String toString() {
        return quantidade + "x " + tipo.getNome()
            + (observacao.isEmpty() ? "" : " (" + observacao + ")");
    }
}
