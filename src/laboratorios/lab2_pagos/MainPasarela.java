package laboratorios.lab2_pagos;

/**
 * Laboratorio 2: Pasarela de pagos.
 * Demuestra:
 * - Diseño de contratos con interfaces y métodos default.
 * - Polimorfismo e inversión de dependencias: Caja depende de MetodoPago, no de clases concretas.
 * - Extensibilidad del sistema (Paso 6: incorporación de Criptomoneda).
 */
public class MainPasarela {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   LABORATORIO 2: PASARELA DE PAGOS");
        System.out.println("==================================================");

        // Casos oficiales de prueba según la guía
        Caja.cobrar(new TarjetaCredito(500_000), 120_000);
        Caja.cobrar(new BilleteraDigital(50_000), 80_000);
        Caja.cobrar(new Efectivo(), 35_000);
        Caja.cobrar(new TarjetaCredito(100_000), 99_000); // 99.000 + 2.970 = 101.970 > 100.000 (RECHAZADO)

        // Paso 6: Agregar un quinto método sin tocar la clase Caja
        System.out.println("\n[Demostración Paso 6: Quinto método sin modificar Caja]");
        Criptomoneda btc = new Criptomoneda(200_000, 3_000);
        Caja.cobrar(btc, 150_000); // 150.000 + 3.000 <= 200.000 -> APROBADO
        Caja.cobrar(btc, 100_000); // Saldo restante 47.000 < 103.000 -> RECHAZADO

        System.out.println("==================================================\n");
    }
}
