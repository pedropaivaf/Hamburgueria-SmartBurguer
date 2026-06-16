package br.com.hamburgueria;

public class Salada extends Acompanhamento {

    @Override
    public String getNome() {
        return "Salada";
    }

    @Override
    public double getPreco() {
        return 8.00;
    }
}
