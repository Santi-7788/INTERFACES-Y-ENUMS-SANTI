package laboratorios.lab3_semaforo;

/**
 * Laboratorio 3: Semáforo inteligente.
 * Demuestra:
 * - Enums con atributos, constructor y métodos de instancia y estáticos.
 * - Transiciones de estados mediante expresiones switch exhaustivas (Java 14+).
 * - Simulación de ciclo y cálculo acumulativo con values().
 */
public class MainSemaforo {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   LABORATORIO 3: SEMÁFORO INTELIGENTE");
        System.out.println("==================================================");

        Semaforo luz = Semaforo.VERDE;
        for (int paso = 1; paso <= 4; paso++) {
            System.out.printf("Paso %d: %-8s %2d s → %s%n",
                    paso, luz, luz.getSegundos(), luz.getAccion());
            luz = luz.siguiente();
        }
        System.out.println("Duración del ciclo completo: " + Semaforo.duracionCiclo() + " s");

        // Reto extra demostración
        System.out.println("\n[Demostración Reto Extra: AMARILLO_INTERMITENTE]");
        Semaforo intermitente = Semaforo.AMARILLO_INTERMITENTE;
        System.out.printf("Estado especial: %-22s -> %s (pasa a %s)%n",
                intermitente, intermitente.getAccion(), intermitente.siguiente());
        System.out.println("==================================================\n");
    }
}
