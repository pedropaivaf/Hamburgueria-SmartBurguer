package br.com.hamburgueria.desconto;

/**
 * Strategy — 10% de desconto para clientes do clube de fidelidade.
 */
public class DescontoClubeFidelidade implements PoliticaDesconto {
    private static final double PERCENTUAL = 0.10;

    @Override
    public double calcularDesconto(double totalBruto) {
        return totalBruto * PERCENTUAL;
    }

    @Override public String descricao() { return "Clube Fidelidade 10%"; }
}
