package br.com.hamburgueria.ficha;

/**
 * State — classe abstrata dos estados da Ficha (ticket de cozinha).
 * Cada transicao retorna boolean: true = ok, false = invalida.
 */
public abstract class FichaEstado {
    public abstract String getSituacao();
    public boolean iniciarPreparo(Ficha f) { return false; }
    public boolean concluir(Ficha f)       { return false; }
    public boolean entregar(Ficha f)       { return false; }
    public boolean cancelar(Ficha f)       { return false; }
}
