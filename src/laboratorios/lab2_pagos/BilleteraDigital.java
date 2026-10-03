package laboratorios.lab2_pagos;

/**
 * Pago mediante billetera digital (por ej. Nequi, Daviplata):
 * - No tiene comisión (hereda 0 de MetodoPago).
 * - Verifica si el saldo es suficiente.
 * - Descuenta el monto pagado del saldo.
 */
public class BilleteraDigital implements MetodoPago {
    private double saldo;

    public BilleteraDigital(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String nombre() {
        return "Billetera digital";
    }

    @Override
    public boolean pagar(double monto) {
        if (monto > saldo) {
            return false;
        }
        saldo -= monto;
        return true;
    }

    public double getSaldo() {
        return saldo;
    }
}
