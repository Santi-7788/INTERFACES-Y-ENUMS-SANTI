package retos.reto4_promociones;

import laboratorios.lab4_cafeteria.Bebida;
import laboratorios.lab4_cafeteria.Pedido;
import laboratorios.lab4_cafeteria.Promocion;
import laboratorios.lab4_cafeteria.Tamano;

/**
 * Reto 4: Promociones Combinables.
 * Demuestra:
 * - Adición de métodos default de orden superior en interfaces funcionales (combinadores).
 * - Composición de funciones lambda: f(x) + g(x) con cota máxima (Math.min(..., subtotal)).
 * - Integración con el sistema de pedidos de la cafetería.
 */
public class MainPromocionesCombinables {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   RETO 4: PROMOCIONES COMBINABLES (MÉTODO DEFAULT)");
        System.out.println("==================================================");

        // Promoción combinada: 10% de descuento Y $1.000 fijos si supera $20.000
        Promocion promo10Porciento = Promocion.porcentaje(10);
        Promocion promoFijaMil = Promocion.fijaDesde(20_000, 1_000);
        Promocion combo = promo10Porciento.y(promoFijaMil);

        double subtotalPrueba1 = 25_000;
        double descP1 = combo.descuento(subtotalPrueba1);
        System.out.printf("Para subtotal $%,.0f:%n", subtotalPrueba1);
        System.out.printf("  10%% = $%,.0f | Fija = $%,.0f | Total Descuento = $%,.0f%n",
                promo10Porciento.descuento(subtotalPrueba1),
                promoFijaMil.descuento(subtotalPrueba1),
                descP1);

        double subtotalPrueba2 = 15_000;
        double descP2 = combo.descuento(subtotalPrueba2);
        System.out.printf("\nPara subtotal $%,.0f (no alcanza el mínimo de $20.000):%n", subtotalPrueba2);
        System.out.printf("  10%% = $%,.0f | Fija = $%,.0f | Total Descuento = $%,.0f%n",
                promo10Porciento.descuento(subtotalPrueba2),
                promoFijaMil.descuento(subtotalPrueba2),
                descP2);

        System.out.println("\nAplicando el combo a un pedido real:");
        Pedido pedido = new Pedido("Carlos")
                .agregar(Bebida.CAPUCHINO, Tamano.GRANDE, 3) // 3 x 8.000 = 24.000
                .agregar(Bebida.TINTO, Tamano.MEDIANO, 1);    // 1 x 3.500 = 3.500 -> Subtotal: 27.500

        pedido.aplicarPromocion(combo);
        pedido.imprimirTicket();
        System.out.println("==================================================\n");
    }
}
