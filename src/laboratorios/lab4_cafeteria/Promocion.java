package laboratorios.lab4_cafeteria;

/**
 * Interfaz funcional para aplicar descuentos sobre un subtotal.
 * Proporciona métodos estáticos de fábrica (lambdas) y un método default combinador (Reto 4).
 */
@FunctionalInterface
public interface Promocion {

    /**
     * Calcula el monto del descuento sobre un subtotal dado.
     */
    double descuento(double subtotal);

    /**
     * Sin descuento (devuelve 0).
     */
    static Promocion ninguna() {
        return subtotal -> 0;
    }

    /**
     * Descuento porcentual sobre el subtotal.
     */
    static Promocion porcentaje(double pct) {
        return subtotal -> subtotal * pct / 100.0;
    }

    /**
     * Descuento de valor fijo si el subtotal supera o iguala un monto mínimo.
     */
    static Promocion fijaDesde(double minimo, double valor) {
        return subtotal -> subtotal >= minimo ? valor : 0;
    }

    /**
     * Reto 4: Promociones combinables.
     * Permite combinar dos promociones sumando ambos descuentos
     * sin que el descuento total supere el subtotal.
     */
    default Promocion y(Promocion otra) {
        return subtotal -> Math.min(this.descuento(subtotal) + otra.descuento(subtotal), subtotal);
    }
}
