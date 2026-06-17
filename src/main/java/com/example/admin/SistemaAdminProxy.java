package com.example.admin;

/**
 * Proxy — controla acesso ao SistemaAdmin baseado no cargo do funcionario.
 * Gerentes tem acesso total; Atendentes apenas leem; Caixas sem acesso.
 */
public class SistemaAdminProxy implements OperacoesAdministrativas {
    private final SistemaAdmin sistemaReal = new SistemaAdmin();
    private final Funcionario funcionario;

    public SistemaAdminProxy(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean aplicarDesconto(String numeroPedido, double percentual) {
        if (funcionario.getCargo() == Cargo.GERENTE) {
            return sistemaReal.aplicarDesconto(numeroPedido, percentual);
        }
        System.out.println("[Proxy] " + funcionario.getNome() + " nao tem permissao para aplicar desconto.");
        return false;
    }

    @Override
    public boolean cancelarPedido(String numeroPedido, String motivo) {
        if (funcionario.getCargo() == Cargo.GERENTE) {
            return sistemaReal.cancelarPedido(numeroPedido, motivo);
        }
        System.out.println("[Proxy] " + funcionario.getNome() + " nao tem permissao para cancelar pedido.");
        return false;
    }

    @Override
    public String gerarRelatorio() {
        if (funcionario.getCargo() == Cargo.GERENTE
            || funcionario.getCargo() == Cargo.ATENDENTE) {
            return sistemaReal.gerarRelatorio();
        }
        System.out.println("[Proxy] " + funcionario.getNome() + " nao tem permissao para ver relatorio.");
        return null;
    }
}
