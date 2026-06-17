package br.com.hamburgueria.filtro;

import br.com.hamburgueria.lanche.*;

/**
 * Interpreter — interface da expressao de filtro de lanches.
 */
public interface CriterioLanche {
    boolean testar(Lanche lanche);
}
