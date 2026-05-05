package br.com.hamburgueria;

public class Bacon extends Adicional {

    public Bacon(Lanche lancheBase) {
        super(lancheBase);
    }

    @Override
    public String getDescricao() {
        return lancheBase.getDescricao() + " + Bacon";
    }

    @Override
    public double getPreco() {
        return lancheBase.getPreco() + 4.00;
    }
}
