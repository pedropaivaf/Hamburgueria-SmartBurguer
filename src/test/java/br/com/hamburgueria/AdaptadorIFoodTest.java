package br.com.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Valida o padrao Adapter: AdaptadorIFood converte chamadas da
 * interface PlataformaDeliveryExterno para a API incompativel do iFood.
 */
class AdaptadorIFoodTest {

    @Test
    void enviarPedidoRetornaTrue() {
        PlataformaDeliveryExterno plataforma = new AdaptadorIFood(new ApiIFood());
        assertTrue(plataforma.enviarPedido("P100", "Rua das Flores, 10", 45.90));
    }

    @Test
    void consultarStatusRetornaEmTransito() {
        PlataformaDeliveryExterno plataforma = new AdaptadorIFood(new ApiIFood());
        String status = plataforma.consultarStatusEntrega("P100");
        assertEquals("Em transito", status);
    }

    @Test
    void adaptadorImplementaInterfaceAlvo() {
        PlataformaDeliveryExterno plataforma = new AdaptadorIFood(new ApiIFood());
        assertInstanceOf(PlataformaDeliveryExterno.class, plataforma);
    }

    @Test
    void valorConvertidoEmCentavosCorretamente() {
        ApiIFood api = new ApiIFood();
        // 19.99 => 1999 centavos — sem excecao
        AdaptadorIFood adaptador = new AdaptadorIFood(api);
        assertTrue(adaptador.enviarPedido("P101", "Av. Brasil, 50", 19.99));
    }
}
