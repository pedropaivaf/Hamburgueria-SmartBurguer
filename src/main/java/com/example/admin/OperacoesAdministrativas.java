package com.example.admin;

/**
 * Proxy — interface das operacoes sensiveis do sistema gerencial.
 */
public interface OperacoesAdministrativas {
    boolean aplicarDesconto(String numeroPedido, double percentual);
    boolean cancelarPedido(String numeroPedido, String motivo);
    String gerarRelatorio();
}
