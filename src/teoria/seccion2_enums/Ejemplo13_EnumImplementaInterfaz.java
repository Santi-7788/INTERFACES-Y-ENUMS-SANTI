package teoria.seccion2_enums;

/**
 * Sección 2.8: Enums que implementan interfaces (patrón enum extensible).
 */
public class Ejemplo13_EnumImplementaInterfaz {

    @FunctionalInterface
    public interface Calculable {
        double calcular(double base);
    }

    public enum Impuesto implements Calculable {
        IVA_GENERAL(0.19),
        IVA_REDUCIDO(0.05),
        EXENTO(0.0);

        private final double tasa;

        Impuesto(double tasa) {
            this.tasa = tasa;
        }

        @Override
        public double calcular(double base) {
            return base * tasa;
        }
    }

    public static void cobrar(String concepto, double base, Calculable regla) {
        System.out.printf("%-12s base $%,9.0f recargo $%,7.0f%n",
                concepto, base, regla.calcular(base));
    }

    public static void ejecutar() {
        System.out.println("--- [2.8] Enums que implementan interfaces + interoperabilidad con lambdas ---");
        cobrar("Audífonos", 200_000, Impuesto.IVA_GENERAL);  // Un enum...
        cobrar("Producto B", 40_000, Impuesto.IVA_REDUCIDO);
        cobrar("Libro", 60_000, Impuesto.EXENTO);
        cobrar("Propina", 80_000, base -> base * 0.10);      // ...o una lambda!
        System.out.println();
    }
}
