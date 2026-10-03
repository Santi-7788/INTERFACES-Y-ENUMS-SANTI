package laboratorios.lab4_cafeteria;

/**
 * Máquina de estados para el ciclo de vida de un pedido.
 * Define transiciones válidas y restricciones de cancelación.
 */
public enum EstadoPedido {
    RECIBIDO,
    EN_PREPARACION,
    LISTO,
    ENTREGADO,
    CANCELADO;

    /**
     * Indica si el estado es terminal (no permite más cambios).
     */
    public boolean esFinal() {
        return this == ENTREGADO || this == CANCELADO;
    }

    /**
     * Avanza al siguiente estado lógico en el flujo normal.
     */
    public EstadoPedido siguiente() {
        return switch (this) {
            case RECIBIDO -> EN_PREPARACION;
            case EN_PREPARACION -> LISTO;
            case LISTO -> ENTREGADO;
            case ENTREGADO, CANCELADO ->
                    throw new IllegalStateException("El pedido ya terminó: " + this);
        };
    }

    /**
     * Solo se puede cancelar antes de que esté listo o entregado.
     */
    public boolean puedeCancelarse() {
        return this == RECIBIDO || this == EN_PREPARACION;
    }

    /**
     * Transiciona el pedido al estado CANCELADO si es válido.
     */
    public EstadoPedido cancelar() {
        if (!puedeCancelarse()) {
            throw new IllegalStateException("No se puede cancelar en estado " + this);
        }
        return CANCELADO;
    }
}
