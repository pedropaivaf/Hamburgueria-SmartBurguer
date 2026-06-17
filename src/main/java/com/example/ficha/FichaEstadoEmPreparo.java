package com.example.ficha;

public class FichaEstadoEmPreparo extends FichaEstado {
    private static final FichaEstadoEmPreparo INSTANCE = new FichaEstadoEmPreparo();
    private FichaEstadoEmPreparo() {}
    public static FichaEstadoEmPreparo getInstance() { return INSTANCE; }

    @Override public String getSituacao() { return "Em Preparo"; }

    @Override public boolean concluir(Ficha f) {
        f.setEstado(FichaEstadoPronta.getInstance());
        return true;
    }
}
