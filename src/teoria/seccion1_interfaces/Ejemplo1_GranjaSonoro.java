package teoria.seccion1_interfaces;

import java.util.List;

/**
 * Secciones 1.1 y 1.2: Tu primera interfaz y polimorfismo básico.
 * Demuestra:
 * - Definición de una interfaz como contrato (qué hacer, no cómo).
 * - Implementación con 'implements' y anotación @Override.
 * - Despacho dinámico y bajo acoplamiento.
 */
public class Ejemplo1_GranjaSonoro {

    public interface Sonoro {
        String hacerSonido();
    }

    public static class Perro implements Sonoro {
        @Override
        public String hacerSonido() {
            return "¡Guau!";
        }
    }

    public static class Gato implements Sonoro {
        @Override
        public String hacerSonido() {
            return "¡Miau!";
        }
    }

    public static class Vaca implements Sonoro {
        @Override
        public String hacerSonido() {
            return "¡Muuu!";
        }
    }

    public static void hacerSonar(Sonoro s) {
        System.out.println(s.hacerSonido());
    }

    public static void ejecutar() {
        System.out.println("--- [1.1 & 1.2] Tu primera interfaz: La Granja ---");
        Sonoro firulais = new Perro(); // Tipo declarado: Sonoro, tipo real: Perro
        Sonoro michi = new Gato();     // Tipo declarado: Sonoro, tipo real: Gato
        Sonoro lola = new Vaca();

        System.out.print("Perro: ");
        hacerSonar(firulais);
        System.out.print("Gato: ");
        hacerSonar(michi);

        System.out.println("\nRecorriendo lista polimórfica:");
        List<Sonoro> granja = List.of(firulais, michi, lola);
        for (Sonoro animal : granja) {
            String nombreClase = animal.getClass().getSimpleName();
            System.out.println("  " + nombreClase + " dice " + animal.hacerSonido());
        }
        System.out.println();
    }
}
