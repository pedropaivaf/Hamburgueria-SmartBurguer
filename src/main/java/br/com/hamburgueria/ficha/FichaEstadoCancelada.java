package br.com.hamburgueria.ficha;

public class FichaEstadoCancelada extends FichaEstado {
    private static final FichaEstadoCancelada INSTANCE = new FichaEstadoCancelada();
    private FichaEstadoCancelada() {}
    public static FichaEstadoCancelada getInstance() { return INSTANCE; }

    @Override public String getSituacao() { return "Cancelada"; }
}
