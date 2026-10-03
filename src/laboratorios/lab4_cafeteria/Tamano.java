package laboratorios.lab4_cafeteria;

/**
 * Tamaños de bebida con su respectivo valor de recargo.
 */
public enum Tamano {
    PEQUENO(0),
    MEDIANO(1_000),
    GRANDE(2_000);

    private final double recargo;

    Tamano(double recargo) {
        this.recargo = recargo;
    }

    public double getRecargo() {
        return recargo;
    }
}
