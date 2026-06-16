package br.com.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Strategy: CaixaRegistradora aplica a politica de
 * desconto trocavel em tempo de execucao sobre o total do pedido.
 */
class CaixaRegistradoraTest {

    private static final double DELTA = 0.001;

    @Test
    void semDescontoRetornaTotalBruto() {
        CaixaRegistradora caixa = new CaixaRegistradora(new SemPoliticaDesconto());
        assertEquals(100.0, caixa.calcularTotalComDesconto(100.0), DELTA);
    }

    @Test
    void clubeFidelidadeAplicaDezPorCento() {
        CaixaRegistradora caixa = new CaixaRegistradora(new DescontoClubeFidelidade());
        assertEquals(90.0, caixa.calcularTotalComDesconto(100.0), DELTA);
    }

    @Test
    void cupomAplicaValorFixo() {
        CaixaRegistradora caixa = new CaixaRegistradora(
                new DescontoCupomPromocional("PROMO10", 10.0));
        assertEquals(90.0, caixa.calcularTotalComDesconto(100.0), DELTA);
    }

    @Test
    void cupomNaoUltrapassaTotalBruto() {
        CaixaRegistradora caixa = new CaixaRegistradora(
                new DescontoCupomPromocional("MEGA", 200.0));
        assertEquals(0.0, caixa.calcularTotalComDesconto(50.0), DELTA);
    }

    @Test
    void descontoProgressivoQuinzePorCentoAcimaDeCem() {
        CaixaRegistradora caixa = new CaixaRegistradora(new DescontoProgressivo());
        assertEquals(100.0 * 0.85, caixa.calcularTotalComDesconto(100.0), DELTA);
    }

    @Test
    void descontoProgressivoOitoPorCentoEntreCinquentaECem() {
        CaixaRegistradora caixa = new CaixaRegistradora(new DescontoProgressivo());
        assertEquals(60.0 * 0.92, caixa.calcularTotalComDesconto(60.0), DELTA);
    }

    @Test
    void politicaEhTrocavelEmTempoDeExecucao() {
        CaixaRegistradora caixa = new CaixaRegistradora(new SemPoliticaDesconto());
        assertEquals(100.0, caixa.calcularTotalComDesconto(100.0), DELTA);
        caixa.setPolitica(new DescontoClubeFidelidade());
        assertEquals(90.0, caixa.calcularTotalComDesconto(100.0), DELTA);
    }
}
