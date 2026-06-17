package br.com.hamburgueria.ingrediente;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight — fabrica que cacheia e reutiliza TipoIngrediente compartilhado.
 */
public class FabricaIngredientes {
    private static final Map<String, TipoIngrediente> cache = new HashMap<>();

    public static TipoIngrediente obter(String nome, String grupo, boolean alergico) {
        if (!cache.containsKey(nome)) {
            cache.put(nome, new TipoIngrediente(nome, grupo, alergico));
        }
        return cache.get(nome);
    }

    public static int totalCached()   { return cache.size(); }
    public static void limparCache()  { cache.clear(); }
}
