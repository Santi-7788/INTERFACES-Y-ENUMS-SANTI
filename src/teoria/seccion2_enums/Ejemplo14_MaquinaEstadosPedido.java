package teoria.seccion2_enums;

import laboratorios.lab4_cafeteria.EstadoPedido;

/**
 * Sección 2.9: Enums como máquinas de estado con transiciones válidas.
 */
public class Ejemplo14_MaquinaEstadosPedido {

    public static void ejecutar() {
        System.out.println("--- [2.9] Enums como máquinas de estado ---");

        EstadoPedido estado = EstadoPedido.RECIBIDO;
        while (!estado.esFinal()) {
            String cancelable = estado.puedeCancelarse() ? "sí" : "no";
            System.out.printf("%-15s ¿cancelable? %s%n", estado, cancelable);
            estado = estado.siguiente();
        }
        System.out.println(estado + " → fin del recorrido");

        try {
            EstadoPedido.LISTO.cancelar();
        } catch (IllegalStateException e) {
            System.out.println("Error esperado al intentar cancelar en LISTO: " + e.getMessage());
        }
        System.out.println();
    }
}
