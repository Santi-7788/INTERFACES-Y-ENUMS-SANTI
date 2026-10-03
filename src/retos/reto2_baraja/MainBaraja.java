package retos.reto2_baraja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reto 2: Baraja Española.
 * Demuestra:
 * - Creación de enums combinados (Palo y Valor).
 * - Uso del método values() en bucles for-each para generar productos cartesianos.
 * - Uso de records para modelar estructuras de datos inmutables y concisas.
 * - Barajado aleatorio con Collections.shuffle.
 */
public class MainBaraja {

    public static void main(String[] args) {
        ejecutar();
    }

    public static List<Carta> crearBaraja() {
        List<Carta> baraja = new ArrayList<>();
        // Dos ciclos for sobre values() para generar las 48 cartas
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                baraja.add(new Carta(valor, palo));
            }
        }
        return baraja;
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   RETO 2: BARAJA ESPAÑOLA (48 CARTAS)");
        System.out.println("==================================================");

        List<Carta> baraja = crearBaraja();
        System.out.println("Cartas generadas en total: " + baraja.size());

        System.out.println("\nPrimeras 5 cartas ordenadas:");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + (i + 1) + ". " + baraja.get(i));
        }

        // Barajar con Collections.shuffle
        Collections.shuffle(baraja);
        System.out.println("\nCartas después de barajar (Collections.shuffle):");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + (i + 1) + ". " + baraja.get(i));
        }

        System.out.println("\nRepartiendo mano de muestra (4 cartas):");
        for (int i = 0; i < 4; i++) {
            Carta repartida = baraja.removeFirst();
            System.out.println("  Jugador recibe: " + repartida);
        }
        System.out.println("Cartas restantes en el mazo: " + baraja.size());
        System.out.println("==================================================\n");
    }
}
