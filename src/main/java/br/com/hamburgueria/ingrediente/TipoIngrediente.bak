package br.com.hamburgueria.ingrediente;

/**
 * Flyweight — parte intrinseca compartilhada: dados fixos de um ingrediente.
 */
public class TipoIngrediente {
    private final String nome;
    private final String grupo;      // ex.: "Proteina", "Molho", "Vegetal"
    private final boolean alergico;

    public TipoIngrediente(String nome, String grupo, boolean alergico) {
        this.nome      = nome;
        this.grupo     = grupo;
        this.alergico  = alergico;
    }

    public String getNome()     { return nome; }
    public String getGrupo()    { return grupo; }
    public boolean isAlergico() { return alergico; }

    @Override
    public String toString() {
        return nome + " [" + grupo + (alergico ? ", ALERGICO" : "") + "]";
    }
}
