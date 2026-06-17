package br.com.hamburgueria.ficha;

public class FichaEstadoEntregue extends FichaEstado {
    private static final FichaEstadoEntregue INSTANCE = new FichaEstadoEntregue();
    private FichaEstadoEntregue() {}
    public static FichaEstadoEntregue getInstance() { return INSTANCE; }

    @Override public String getSituacao() { return "Entregue"; }
}
