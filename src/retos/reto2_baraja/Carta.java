package retos.reto2_baraja;

/**
 * Record inmutable que representa una carta de la baraja española.
 */
public record Carta(Valor valor, Palo palo) {

    @Override
    public String toString() {
        return valor.getNombre() + " de " + palo;
    }
}
