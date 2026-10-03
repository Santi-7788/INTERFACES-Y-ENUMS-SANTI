package laboratorios.lab3_semaforo;

/**
 * Laboratorio 3: Semáforo inteligente.
 * Representa los estados de un semáforo de tránsito con su duración y acción.
 * Incluye el estado AMARILLO_INTERMITENTE solicitado en el Reto Extra (Paso 6).
 */
public enum Semaforo {
    VERDE(30, "Avance"),
    AMARILLO(5, "Precaución"),
    ROJO(35, "Pare"),
    // Reto extra (paso 6): Al agregarlo, el compilador exige actualizar el switch exhaustivo
    AMARILLO_INTERMITENTE(0, "Precaución intermitente");

    private final int segundos;
    private final String accion;

    Semaforo(int segundos, String accion) {
        this.segundos = segundos;
        this.accion = accion;
    }

    public int getSegundos() {
        return segundos;
    }

    public String getAccion() {
        return accion;
    }

    /**
     * Transición de estados utilizando switch de flecha exhaustivo.
     * Si se añade una nueva constante al enum, el compilador alertará
     * inmediatamente si falta algún case.
     */
    public Semaforo siguiente() {
        return switch (this) {
            case VERDE -> AMARILLO;
            case AMARILLO -> ROJO;
            case ROJO -> VERDE;
            case AMARILLO_INTERMITENTE -> VERDE;
        };
    }

    /**
     * Calcula la duración total del ciclo sumando los segundos de values().
     */
    public static int duracionCiclo() {
        int total = 0;
        for (Semaforo s : values()) {
            total += s.segundos;
        }
        return total;
    }
}
