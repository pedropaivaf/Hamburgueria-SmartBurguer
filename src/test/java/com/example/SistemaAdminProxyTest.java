package com.example;

import com.example.admin.*;

import com.example.admin.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Proxy: SistemaAdminProxy controla o acesso ao
 * SistemaAdmin conforme o cargo do funcionario.
 */
class SistemaAdminProxyTest {

    @Test
    void gerentePoderAplicarDesconto() {
        Funcionario gerente = new Funcionario("Ana", Cargo.GERENTE);
        OperacoesAdministrativas sistema = new SistemaAdminProxy(gerente);
        assertTrue(sistema.aplicarDesconto("P001", 0.10));
    }

    @Test
    void atendenteNaoPoderAplicarDesconto() {
        Funcionario atendente = new Funcionario("Carlos", Cargo.ATENDENTE);
        OperacoesAdministrativas sistema = new SistemaAdminProxy(atendente);
        assertFalse(sistema.aplicarDesconto("P001", 0.10));
    }

    @Test
    void gerentePodeCancelarPedido() {
        Funcionario gerente = new Funcionario("Ana", Cargo.GERENTE);
        OperacoesAdministrativas sistema = new SistemaAdminProxy(gerente);
        assertTrue(sistema.cancelarPedido("P002", "Erro no pedido"));
    }

    @Test
    void atendenteNaoPodeCancelarPedido() {
        Funcionario caixa = new Funcionario("Pedro", Cargo.CAIXA);
        OperacoesAdministrativas sistema = new SistemaAdminProxy(caixa);
        assertFalse(sistema.cancelarPedido("P002", "Engano"));
    }

    @Test
    void gerenteEAtendentePodemGerarRelatorio() {
        OperacoesAdministrativas sysGer = new SistemaAdminProxy(new Funcionario("Dir", Cargo.GERENTE));
        OperacoesAdministrativas sysAte = new SistemaAdminProxy(new Funcionario("Ate", Cargo.ATENDENTE));
        assertNotNull(sysGer.gerarRelatorio());
        assertNotNull(sysAte.gerarRelatorio());
    }

    @Test
    void caixaNaoPodeGerarRelatorio() {
        OperacoesAdministrativas sistema = new SistemaAdminProxy(new Funcionario("Kai", Cargo.CAIXA));
        assertNull(sistema.gerarRelatorio());
    }
}
