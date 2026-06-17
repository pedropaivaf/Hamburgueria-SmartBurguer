package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.loja.*;

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
