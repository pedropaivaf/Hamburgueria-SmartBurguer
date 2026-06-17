package com.example.analise;

/**
 * Visitor — interface do visitante com um metodo por tipo de elemento.
 */
public interface VisitanteCardapio {
    String visitarLancheCardapio(LancheCardapio lanche);
    String visitarBebidaCardapio(BebidaCardapio bebida);
    String visitarSobremesaCardapio(SobremesaCardapio sobremesa);
}
