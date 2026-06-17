package com.example.filtro;

import com.example.lanche.*;

/**
 * Interpreter — nao-terminal: combina dois criterios com E logico.
 */
public class CriterioLancheE implements CriterioLanche {
    private final CriterioLanche esquerdo;
    private final CriterioLanche direito;

    public CriterioLancheE(CriterioLanche esquerdo, CriterioLanche direito) {
        this.esquerdo = esquerdo;
        this.direito  = direito;
    }

    @Override
    public boolean testar(Lanche lanche) {
        return esquerdo.testar(lanche) && direito.testar(lanche);
    }
}
