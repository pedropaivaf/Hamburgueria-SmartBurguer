package br.com.hamburgueria.modelo;

public class Suco extends Bebida {

    @Override
    public String getNome() {
        return "Suco Natural";
    }

    @Override
    public double getPreco() {
        return 9.00;
    }
}
