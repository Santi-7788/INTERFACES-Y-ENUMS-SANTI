package laboratorios.lab2_pagos;

/**
 * Contrato que define el comportamiento de cualquier método de pago.
 * Incluye métodos default para cálculo de comisiones y monto total.
 */
public interface MetodoPago {

    /**
     * Nombre descriptivo del método de pago.
     */
    String nombre();

    /**
     * Procesa el cobro por el monto indicado.
     * @return true si la transacción fue aprobada, false si fue rechazada.
     */
    boolean pagar(double monto);

    /**
     * Comisión por defecto (0 para métodos sin recargo).
     */
    default double comision(double monto) {
        return 0;
    }

    /**
     * Monto final a cobrar sumando el valor base y la comisión.
     */
    default double totalACobrar(double monto) {
        return monto + comision(monto);
    }
}
