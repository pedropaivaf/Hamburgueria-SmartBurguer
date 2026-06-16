package br.com.hamburgueria;

public class PagamentoCartao implements FormaPagamento {

    @Override
    public String getNome() {
        return "Cartao de Credito (taxa 3%)";
    }

    @Override
    public double aplicarSobre(double subtotal) {
        return subtotal * (1 + ConfiguracaoLoja.getInstancia().getTaxaCartao());
    }
}
