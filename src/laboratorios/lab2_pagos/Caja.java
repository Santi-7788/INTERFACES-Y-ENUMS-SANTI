package laboratorios.lab2_pagos;

/**
 * La clase Caja recibe el contrato MetodoPago.
 * No necesita conocer si es tarjeta, efectivo o criptomoneda (Bajo acoplamiento y polimorfismo).
 */
public class Caja {

    /**
     * Procesa y cobra utilizando cualquier implementación de MetodoPago.
     */
    public static void cobrar(MetodoPago m, double monto) {
        String resultado = m.pagar(monto) ? "APROBADO" : "RECHAZADO";
        System.out.printf("%-20s $%,10.0f comisión $%,7.0f %s%n",
                m.nombre(), monto, m.comision(monto), resultado);
    }
}
