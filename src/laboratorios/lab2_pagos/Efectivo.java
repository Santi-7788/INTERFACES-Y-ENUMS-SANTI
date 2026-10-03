package laboratorios.lab2_pagos;

/**
 * Pago en efectivo:
 * - Sin comisión adicional (comisión = 0).
 * - Siempre aprueba la transacción (se asume entrega de dinero físico).
 */
public class Efectivo implements MetodoPago {

    @Override
    public String nombre() {
        return "Efectivo";
    }

    @Override
    public boolean pagar(double monto) {
        return true;
    }
}
