package com.example.analise;

/**
 * Visitor — visitante que calcula informacoes nutricionais dos itens.
 */
public class CalculoNutricional implements VisitanteCardapio {

    @Override
    public String visitarLancheCardapio(LancheCardapio lanche) {
        String aviso = lanche.getCalorias() > 600 ? " [ALTO VALOR CALORICO]" : "";
        return lanche.getNome() + ": " + lanche.getCalorias() + " kcal" + aviso;
    }

    @Override
    public String visitarBebidaCardapio(BebidaCardapio bebida) {
        String tipo = bebida.isAlcoolica() ? " [ALCOOLICA]" : "";
        return bebida.getNome() + ": " + bebida.getCalorias() + " kcal" + tipo;
    }

    @Override
    public String visitarSobremesaCardapio(SobremesaCardapio sobremesa) {
        return sobremesa.getNome() + ": " + sobremesa.getCalorias() + " kcal [SOBREMESA]";
    }
}
