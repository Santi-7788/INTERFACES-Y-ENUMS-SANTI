package teoria.seccion2_enums;

/**
 * Sección 2.7: Comportamiento polimórfico por constante (métodos abstractos en enums).
 */
public class Ejemplo12_OperadorAbstracto {

    public enum Operador {
        SUMA("+") {
            @Override
            public double aplicar(double a, double b) {
                return a + b;
            }
        },
        RESTA("-") {
            @Override
            public double aplicar(double a, double b) {
                return a - b;
            }
        },
        MULTIPLICACION("×") {
            @Override
            public double aplicar(double a, double b) {
                return a * b;
            }
        },
        DIVISION("÷") {
            @Override
            public double aplicar(double a, double b) {
                if (b == 0) {
                    throw new ArithmeticException("división por cero");
                }
                return a / b;
            }
        };

        private final String simbolo;

        Operador(String simbolo) {
            this.simbolo = simbolo;
        }

        public String simbolo() {
            return simbolo;
        }

        // Cada constante está OBLIGADA a implementar este método
        public abstract double aplicar(double a, double b);
    }

    public static void ejecutar() {
        System.out.println("--- [2.7] Comportamiento distinto por constante (método abstracto) ---");
        double a = 12, b = 4;
        for (Operador op : Operador.values()) {
            System.out.printf("%.0f %s %.0f = %.1f%n", a, op.simbolo(), b, op.aplicar(a, b));
        }

        try {
            Operador.DIVISION.aplicar(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
    }
}
