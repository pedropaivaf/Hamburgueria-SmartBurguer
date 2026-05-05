package br.com.hamburgueria;

public class Refrigerante extends Bebida {

    @Override
    public String getNome() {
        return "Refrigerante";
    }

    @Override
    public double getPreco() {
        return 7.00;
    }
}
