package br.com.hamburgueria;

public class Agua extends Bebida {

    @Override
    public String getNome() {
        return "Agua Mineral";
    }

    @Override
    public double getPreco() {
        return 4.00;
    }
}
