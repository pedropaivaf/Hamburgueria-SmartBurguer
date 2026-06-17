package com.example.filtro;

import com.example.lanche.*;

/**
 * Interpreter — interface da expressao de filtro de lanches.
 */
public interface CriterioLanche {
    boolean testar(Lanche lanche);
}
