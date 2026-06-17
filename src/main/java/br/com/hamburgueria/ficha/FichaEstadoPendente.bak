package br.com.hamburgueria.ficha;

public class FichaEstadoPendente extends FichaEstado {
    private static final FichaEstadoPendente INSTANCE = new FichaEstadoPendente();
    private FichaEstadoPendente() {}
    public static FichaEstadoPendente getInstance() { return INSTANCE; }

    @Override public String getSituacao() { return "Pendente"; }

    @Override public boolean iniciarPreparo(Ficha f) {
        f.setEstado(FichaEstadoEmPreparo.getInstance());
        return true;
    }
    @Override public boolean cancelar(Ficha f) {
        f.setEstado(FichaEstadoCancelada.getInstance());
        return true;
    }
}
