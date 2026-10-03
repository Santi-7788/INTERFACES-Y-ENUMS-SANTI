package retos.reto3_calculadora;

/**
 * Reto 3: Calculadora con Lambdas en el Enum.
 * Demuestra:
 * - Uso de la interfaz funcional del JDK DoubleBinaryOperator como campo del enum.
 * - Operaciones concisas con lambdas y referencias a métodos (Math::pow).
 * - Comparativa de legibilidad entre método abstracto en enum vs atributos lambda.
 */
public class MainCalculadora {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   RETO 3: CALCULADORA CON LAMBDAS EN EL ENUM");
        System.out.println("==================================================");

        double a = 12.0;
        double b = 4.0;

        System.out.printf("Operaciones con a = %.1f y b = %.1f:%n", a, b);
        for (OperadorLambda op : OperadorLambda.values()) {
            System.out.printf("  %.1f %s %.1f = %8.2f%n", a, op.getSimbolo(), b, op.aplicar(a, b));
        }

        // Casos adicionales con Potencia y Módulo
        System.out.println("\nPruebas específicas de POTENCIA y MODULO:");
        System.out.printf("  2.0 ^ 10.0 = %.0f%n", OperadorLambda.POTENCIA.aplicar(2, 10));
        System.out.printf("  17.0 %% 5.0 = %.0f%n", OperadorLambda.MODULO.aplicar(17, 5));

        // Manejo de excepciones
        try {
            System.out.print("  Probando división por cero: ");
            OperadorLambda.DIVISION.aplicar(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado -> " + e.getMessage());
        }

        System.out.println("\n¿Cuál versión es más legible y por qué?");
        System.out.println("-> Para operaciones cortas (1-2 líneas), la versión con LAMBDAS es mucho");
        System.out.println("   más compacta, limpia y legible, pues evita la sobrecarga sintáctica de");
        System.out.println("   declarar cuerpos anónimos para cada constante.");
        System.out.println("-> Sin embargo, si una operación requiere lógica compleja, validaciones extensas");
        System.out.println("   o estado interno, la versión con MÉTODO ABSTRACTO (§2.7) es superior para");
        System.out.println("   evitar lambdas multilínea sobrecargadas dentro del constructor del enum.");
        System.out.println("==================================================\n");
    }
}
