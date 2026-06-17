package br.com.hamburgueria.operacao;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Command — Invoker que executa e desfaz comandos sobre pedidos.
 */
public class ControleOrdens {
    private final Deque<ComandoPedido> historico = new ArrayDeque<>();

    public void executar(ComandoPedido cmd) {
        cmd.executar();
        historico.push(cmd);
        System.out.println("Executado: " + cmd.descricao());
    }

    public boolean desfazer() {
        if (historico.isEmpty()) return false;
        ComandoPedido cmd = historico.pop();
        cmd.desfazer();
        System.out.println("Desfeito: " + cmd.descricao());
        return true;
    }

    public int totalNoHistorico() { return historico.size(); }
}
