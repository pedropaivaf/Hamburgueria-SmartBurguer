package br.com.hamburgueria.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterator — coleção iteravel de itens do menu (Aggregate).
 */
public class ColecaoItensMenu {
    private final List<ItemMenu> itens = new ArrayList<>();

    public void adicionar(ItemMenu item) { itens.add(item); }
    public int tamanho()                 { return itens.size(); }

    public IteradorMenu criarIterador() {
        return new IteradorColecaoMenu(itens);
    }
}
