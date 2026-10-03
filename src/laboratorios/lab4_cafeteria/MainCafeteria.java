package laboratorios.lab4_cafeteria;

/**
 * Laboratorio 4: Cafetería "El Algoritmo".
 * Proyecto integrador que combina:
 * - Enums (Bebida, Tamano, EstadoPedido).
 * - Interfaz funcional con lambdas (Promocion).
 * - Records inmutables (Item).
 * - Clases con estado encapsulado y despacho polimórfico (Pedido).
 */
public class MainCafeteria {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   LABORATORIO 4: CAFETERÍA EL ALGORITMO");
        System.out.println("==================================================");

        Pedido pedido = new Pedido("Camila")
                .agregar(Bebida.CAPUCHINO, Tamano.GRANDE, 2)
                .agregar(Bebida.TINTO, Tamano.PEQUENO, 1)
                .agregar(Bebida.CHOCOLATE, Tamano.MEDIANO, 1);

        pedido.aplicarPromocion(Promocion.porcentaje(10));
        pedido.avanzar(); // RECIBIDO -> EN_PREPARACION
        pedido.avanzar(); // EN_PREPARACION -> LISTO
        pedido.imprimirTicket();

        try {
            pedido.cancelar();
        } catch (IllegalStateException e) {
            System.out.println("Aviso: " + e.getMessage());
        }

        System.out.println("==================================================\n");
    }
}
