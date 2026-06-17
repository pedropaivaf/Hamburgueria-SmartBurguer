package br.com.hamburgueria.pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototype — pedido salvo que pode ser clonado para repetir um pedido anterior.
 * Util para clientes que pedem sempre o mesmo lanche (ex.: "o de sempre").
 */
public class PedidoRapido implements Clonavel {
    private String apelido;
    private final List<String> nomesLanches;
    private final List<String> combos;

    public PedidoRapido(String apelido) {
        this.apelido      = apelido;
        this.nomesLanches = new ArrayList<>();
        this.combos       = new ArrayList<>();
    }

    private PedidoRapido(PedidoRapido original) {
        this.apelido      = original.apelido + " (copia)";
        this.nomesLanches = new ArrayList<>(original.nomesLanches);
        this.combos       = new ArrayList<>(original.combos);
    }

    public void adicionarLanche(String nomeLanche) { nomesLanches.add(nomeLanche); }
    public void adicionarCombo(String nomeCombo)   { combos.add(nomeCombo); }
    public String getApelido()                     { return apelido; }
    public void setApelido(String apelido)         { this.apelido = apelido; }
    public List<String> getNomesLanches()          { return nomesLanches; }
    public List<String> getCombos()                { return combos; }

    @Override
    public Clonavel clonar() { return new PedidoRapido(this); }

    @Override
    public String toString() {
        return "PedidoRapido{apelido='" + apelido + "', lanches=" + nomesLanches + ", combos=" + combos + "}";
    }
}
