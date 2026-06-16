package br.com.hamburgueria;

/**
 * Interpreter — interface da expressao de filtro de lanches.
 */
public interface CriterioLanche {
    boolean testar(Lanche lanche);
}
