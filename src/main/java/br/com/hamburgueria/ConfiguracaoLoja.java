package br.com.hamburgueria;

/**
 * Singleton.
 * Mantem em uma unica instancia as taxas e descontos globais da loja
 * (taxa de entrega, desconto Pix, taxa de cartao, desconto de combo).
 * O construtor e privado e o acesso e feito por getInstancia(), garantindo
 * que toda a aplicacao compartilhe a mesma configuracao.
 */
public class ConfiguracaoLoja {

    private static ConfiguracaoLoja instancia;

    private double taxaEntrega = 8.00;
    private double descontoPix = 0.05;
    private double taxaCartao = 0.03;
    private double descontoCombo = 0.10;

    private ConfiguracaoLoja() {
    }

    public static ConfiguracaoLoja getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoLoja();
        }
        return instancia;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public double getDescontoPix() {
        return descontoPix;
    }

    public void setDescontoPix(double descontoPix) {
        this.descontoPix = descontoPix;
    }

    public double getTaxaCartao() {
        return taxaCartao;
    }

    public void setTaxaCartao(double taxaCartao) {
        this.taxaCartao = taxaCartao;
    }

    public double getDescontoCombo() {
        return descontoCombo;
    }

    public void setDescontoCombo(double descontoCombo) {
        this.descontoCombo = descontoCombo;
    }
}
