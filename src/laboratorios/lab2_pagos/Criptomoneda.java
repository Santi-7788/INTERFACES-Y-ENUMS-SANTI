package laboratorios.lab2_pagos;

/**
 * Quinto método de pago agregado para cumplir con el paso 6 del Laboratorio 2.
 * Demuestra la extensibilidad del sistema polimórfico: se agrega sin modificar Caja.
 */
public class Criptomoneda implements MetodoPago {
    private double saldoBilletera;
    private final double redFee; // tarifa de gas en la blockchain

    public Criptomoneda(double saldoBilletera, double redFee) {
        this.saldoBilletera = saldoBilletera;
        this.redFee = redFee;
    }

    @Override
    public String nombre() {
        return "Criptomoneda";
    }

    @Override
    public double comision(double monto) {
        return redFee;
    }

    @Override
    public boolean pagar(double monto) {
        double total = totalACobrar(monto);
        if (total > saldoBilletera) {
            return false;
        }
        saldoBilletera -= total;
        return true;
    }

    public double getSaldoBilletera() {
        return saldoBilletera;
    }
}
