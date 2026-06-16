package br.com.hamburgueria;

public class FichaEstadoPronta extends FichaEstado {
    private static final FichaEstadoPronta INSTANCE = new FichaEstadoPronta();
    private FichaEstadoPronta() {}
    public static FichaEstadoPronta getInstance() { return INSTANCE; }

    @Override public String getSituacao() { return "Pronta"; }

    @Override public boolean entregar(Ficha f) {
        f.setEstado(FichaEstadoEntregue.getInstance());
        return true;
    }
}
