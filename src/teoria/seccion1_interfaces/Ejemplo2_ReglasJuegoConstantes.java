package teoria.seccion1_interfaces;

/**
 * Sección 1.3: Anatomía de una interfaz y sus reglas implícitas.
 * Demuestra:
 * - Constantes implícitamente public static final.
 * - Métodos abstractos implícitamente public abstract.
 */
public class Ejemplo2_ReglasJuegoConstantes {

    public interface ReglasJuego {
        // En una interfaz toda variable es public static final automáticamente
        int VIDAS_INICIALES = 3;
        int PUNTOS_POR_MONEDA = 10;

        // Todo método sin cuerpo es public abstract automáticamente
        int calcularPuntaje(int monedas);
    }

    public static class JuegoArcade implements ReglasJuego {
        @Override
        public int calcularPuntaje(int monedas) {
            return monedas * PUNTOS_POR_MONEDA; // La clase hereda la constante
        }
    }

    public static void ejecutar() {
        System.out.println("--- [1.3] Anatomía y constantes en interfaces ---");
        System.out.println("Vidas iniciales por defecto: " + ReglasJuego.VIDAS_INICIALES);

        ReglasJuego juego = new JuegoArcade();
        int puntaje = juego.calcularPuntaje(7);
        System.out.println("Puntaje con 7 monedas: " + puntaje);
        System.out.println();
    }
}
