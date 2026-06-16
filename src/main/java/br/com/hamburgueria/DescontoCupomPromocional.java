package br.com.hamburgueria;

/**
 * Strategy — desconto de valor fixo via cupom promocional.
 */
public class DescontoCupomPromocional implements PoliticaDesconto {
    private final String codigo;
    private final double valorFixo;

    public DescontoCupomPromocional(String codigo, double valorFixo) {
        this.codigo    = codigo;
        this.valorFixo = valorFixo;
    }

    @Override
    public double calcularDesconto(double totalBruto) {
        return Math.min(valorFixo, totalBruto);
    }

    @Override public String descricao() { return "Cupom " + codigo + " (-R$ " + valorFixo + ")"; }
}
