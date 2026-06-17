package com.example.pagamento;

import com.example.pedido.*;

/**
 * Implementor do padrao Bridge.
 * Define a interface de pagamento que a abstracao (Pedido) usa.
 * Cada implementacao concreta (Pix, Cartao, Dinheiro) varia o acrescimo/desconto
 * aplicado ao subtotal, sem que a abstracao precise saber o "como".
 */
public interface FormaPagamento {

    String getNome();

    double aplicarSobre(double subtotal);
}
