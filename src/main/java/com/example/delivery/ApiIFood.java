package com.example.delivery;



/**
 * Adapter — adaptee: API do iFood com interface incompativel.
 */
public class ApiIFood {
    public String postOrder(String orderId, String address, int centavos) {
        System.out.println("[iFood API] Pedido " + orderId + " enviado p/ " + address
            + " | Valor: R$ " + (centavos / 100.0));
        return "IFOOD_OK";
    }

    public String getDeliveryStatus(String orderId) {
        return "IFOOD_STATUS_TRANSIT_" + orderId;
    }
}
