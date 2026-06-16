package br.com.hamburgueria;

/**
 * Interpreter — terminal: filtra por trecho do nome do lanche.
 */
public class CriterioNomeLanche implements CriterioLanche {
    private final String trecho;
    public CriterioNomeLanche(String trecho) { this.trecho = trecho.toLowerCase(); }

    @Override
    public boolean testar(Lanche lanche) {
        return lanche.getDescricao().toLowerCase().contains(trecho);
    }
}
