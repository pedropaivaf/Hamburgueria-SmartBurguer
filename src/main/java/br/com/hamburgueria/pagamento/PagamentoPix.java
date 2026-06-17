package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.loja.*;

public class PagamentoPix implements FormaPagamento {

    @Override
    public String getNome() {
        return "Pix (5% de desconto)";
    }

    @Override
    public double aplicarSobre(double subtotal) {
        return subtotal * (1 - ConfiguracaoLoja.getInstancia().getDescontoPix());
    }
}
