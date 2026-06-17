package com.example.operacao;

import com.example.ficha.*;

/**
 * Command — interface dos comandos reversiveis sobre uma Ficha.
 */
public interface ComandoPedido {
    void executar();
    void desfazer();
    String descricao();
}
