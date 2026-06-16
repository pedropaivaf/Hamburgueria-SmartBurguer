package br.com.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Flyweight: FabricaIngredientes reutiliza instancias
 * de TipoIngrediente pelo nome, reduzindo criacao de objetos.
 */
class FabricaIngredientesTest {

    @BeforeEach
    void limparCache() {
        FabricaIngredientes.limparCache();
    }

    @Test
    void mesmoNomeRetornaMesmaInstancia() {
        TipoIngrediente a = FabricaIngredientes.obter("Queijo", "Laticinios", false);
        TipoIngrediente b = FabricaIngredientes.obter("Queijo", "Laticinios", false);
        assertSame(a, b);
    }

    @Test
    void nomesDistintosProduzemInstanciasDistintas() {
        TipoIngrediente queijo = FabricaIngredientes.obter("Queijo", "Laticinios", false);
        TipoIngrediente bacon  = FabricaIngredientes.obter("Bacon",  "Proteina",   false);
        assertNotSame(queijo, bacon);
    }

    @Test
    void cacheArmazenaExatamenteAQuantidadeCriada() {
        FabricaIngredientes.obter("Tomate",  "Vegetal",  false);
        FabricaIngredientes.obter("Alface",  "Vegetal",  false);
        FabricaIngredientes.obter("Tomate",  "Vegetal",  false); // repetido
        assertEquals(2, FabricaIngredientes.totalCached());
    }

    @Test
    void usoIngredienteCombinaTipoComDadosExtrinsecos() {
        TipoIngrediente tipo = FabricaIngredientes.obter("Carne", "Proteina", false);
        UsoIngrediente uso   = new UsoIngrediente(tipo, 2, "bem passada");
        assertEquals("Carne", uso.getTipo().getNome());
        assertEquals(2,       uso.getQuantidade());
        assertTrue(uso.toString().contains("bem passada"));
    }

    @Test
    void flyweightPreserveAtributosFisicos() {
        TipoIngrediente ing = FabricaIngredientes.obter("Gluten", "Farinaceo", true);
        assertTrue(ing.isAlergico());
        assertEquals("Farinaceo", ing.getGrupo());
    }
}
