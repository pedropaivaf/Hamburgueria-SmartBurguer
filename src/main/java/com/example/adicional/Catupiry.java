package com.example.adicional;

import com.example.lanche.*;

public class Catupiry extends Adicional {

    public Catupiry(Lanche lancheBase) {
        super(lancheBase);
    }

    @Override
    public String getDescricao() {
        return lancheBase.getDescricao() + " + Catupiry";
    }

    @Override
    public double getPreco() {
        return lancheBase.getPreco() + 3.50;
    }
}
