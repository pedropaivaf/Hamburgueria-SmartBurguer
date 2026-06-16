package br.com.hamburgueria;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public String getNome() {
        return "Dinheiro";
    }

    @Override
    public double aplicarSobre(double subtotal) {
        return subtotal;
    }
}
