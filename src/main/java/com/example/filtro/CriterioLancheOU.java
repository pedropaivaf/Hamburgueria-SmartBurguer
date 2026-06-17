package com.example.filtro;

import com.example.lanche.*;

/**
 * Interpreter — nao-terminal: combina dois criterios com OU logico.
 */
public class CriterioLancheOU implements CriterioLanche {
    private final CriterioLanche esquerdo;
    private final CriterioLanche direito;

    public CriterioLancheOU(CriterioLanche esquerdo, CriterioLanche direito) {
        this.esquerdo = esquerdo;
        this.direito  = direito;
    }

    @Override
    public boolean testar(Lanche lanche) {
        return esquerdo.testar(lanche) || direito.testar(lanche);
    }
}
