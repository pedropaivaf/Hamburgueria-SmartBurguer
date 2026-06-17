package br.com.hamburgueria.filtro;

import br.com.hamburgueria.lanche.*;

/**
 * Interpreter — terminal: filtra por preco maximo do lanche.
 */
public class CriterioPrecoLanche implements CriterioLanche {
    private final double precoMaximo;
    public CriterioPrecoLanche(double precoMaximo) { this.precoMaximo = precoMaximo; }

    @Override
    public boolean testar(Lanche lanche) {
        return lanche.getPreco() <= precoMaximo;
    }
}
