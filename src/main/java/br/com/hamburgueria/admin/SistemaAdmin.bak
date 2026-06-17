package br.com.hamburgueria.admin;

import br.com.hamburgueria.pedido.*;

/**
 * Proxy — RealSubject: implementacao real do sistema administrativo.
 */
public class SistemaAdmin implements OperacoesAdministrativas {

    @Override
    public boolean aplicarDesconto(String numeroPedido, double percentual) {
        System.out.println("[Admin] Desconto de " + (int)(percentual*100) + "% aplicado ao pedido " + numeroPedido);
        return true;
    }

    @Override
    public boolean cancelarPedido(String numeroPedido, String motivo) {
        System.out.println("[Admin] Pedido " + numeroPedido + " cancelado. Motivo: " + motivo);
        return true;
    }

    @Override
    public String gerarRelatorio() {
        return "[Admin] Relatorio gerado com todos os pedidos do dia.";
    }
}
