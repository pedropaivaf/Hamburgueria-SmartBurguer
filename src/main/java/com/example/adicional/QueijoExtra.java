package com.example.adicional;

import com.example.lanche.*;

public class QueijoExtra extends Adicional {

    public QueijoExtra(Lanche lancheBase) {
        super(lancheBase);
    }

    @Override
    public String getDescricao() {
        return lancheBase.getDescricao() + " + Queijo Extra";
    }

    @Override
    public double getPreco() {
        return lancheBase.getPreco() + 3.00;
    }
}
