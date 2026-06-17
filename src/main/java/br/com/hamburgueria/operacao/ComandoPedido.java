package br.com.hamburgueria.operacao;

import br.com.hamburgueria.ficha.*;

/**
 * Command — interface dos comandos reversiveis sobre uma Ficha.
 */
public interface ComandoPedido {
    void executar();
    void desfazer();
    String descricao();
}
