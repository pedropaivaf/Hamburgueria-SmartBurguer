package br.com.hamburgueria.pagamento;

/**
 * Factory Method.
 * Encapsula a decisao de qual FormaPagamento concreta instanciar
 * a partir de um codigo recebido (ex.: "pix", "cartao", "dinheiro").
 * O cliente nao precisa conhecer as classes concretas: pede ao
 * atendente e recebe o produto pronto. Diferente de Abstract Factory,
 * produz UM unico produto, nao uma familia coerente.
 */
public class Atendente {

    public FormaPagamento prepararPagamento(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Codigo de pagamento nao pode ser nulo");
        }
        switch (codigo.trim().toLowerCase()) {
            case "pix":
                return new PagamentoPix();
            case "cartao":
            case "cartão":
                return new PagamentoCartao();
            case "dinheiro":
                return new PagamentoDinheiro();
            default:
                throw new IllegalArgumentException("Forma de pagamento desconhecida: " + codigo);
        }
    }
}
