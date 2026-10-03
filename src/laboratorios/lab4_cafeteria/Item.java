package laboratorios.lab4_cafeteria;

/**
 * Record inmutable que representa un renglón del pedido (línea de detalle).
 */
public record Item(Bebida bebida, Tamano tamano, int cantidad) {

    /**
     * Calcula el subtotal multiplicando (precio base + recargo por tamaño) por la cantidad.
     */
    public double subtotal() {
        return (bebida.getPrecioBase() + tamano.getRecargo()) * cantidad;
    }
}
