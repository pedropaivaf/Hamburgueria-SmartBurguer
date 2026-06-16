package br.com.hamburgueria;

public class Ovo extends Adicional {

    public Ovo(Lanche lancheBase) {
        super(lancheBase);
    }

    @Override
    public String getDescricao() {
        return lancheBase.getDescricao() + " + Ovo";
    }

    @Override
    public double getPreco() {
        return lancheBase.getPreco() + 2.50;
    }
}
