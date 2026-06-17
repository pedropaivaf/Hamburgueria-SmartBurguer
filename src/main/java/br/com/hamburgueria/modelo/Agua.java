package br.com.hamburgueria.modelo;

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
