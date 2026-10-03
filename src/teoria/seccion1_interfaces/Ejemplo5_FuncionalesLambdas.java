package teoria.seccion1_interfaces;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Sección 1.6: Interfaces funcionales, expresiones lambda y paquete java.util.function.
 */
public class Ejemplo5_FuncionalesLambdas {

    @FunctionalInterface
    public interface Operacion {
        int aplicar(int a, int b);
    }

    public static int calcular(int a, int b, Operacion op) {
        return op.aplicar(a, b);
    }

    public static void ejecutar() {
        System.out.println("--- [1.6] Interfaces funcionales y expresiones lambda ---");

        // 1. Clase anónima tradicional vs lambda
        Operacion sumaAnonima = new Operacion() {
            @Override
            public int aplicar(int a, int b) {
                return a + b;
            }
        };

        Operacion resta = (a, b) -> a - b;

        Operacion potencia = (base, exponente) -> {
            int resultado = 1;
            for (int i = 0; i < exponente; i++) {
                resultado *= base;
            }
            return resultado;
        };

        System.out.println("8 + 2 = " + sumaAnonima.aplicar(8, 2));
        System.out.println("8 - 2 = " + resta.aplicar(8, 2));
        System.out.println("2 ^ 10 = " + potencia.aplicar(2, 10));
        System.out.println("6 x 7 = " + calcular(6, 7, (x, y) -> x * y));

        // 2. Interfaces estándar de java.util.function
        System.out.println("\nInterfaces de java.util.function:");
        Predicate<String> esLarga = s -> s.length() > 5;
        Function<String, Integer> longitud = String::length;
        Consumer<String> imprimir = System.out::println;
        Supplier<String> saludo = () -> "¡Bienvenido al laboratorio!";
        UnaryOperator<String> gritar = s -> s.toUpperCase() + "!";
        BiFunction<Integer, Integer, Integer> mayor = Math::max;

        imprimir.accept(saludo.get());
        System.out.println("¿'interfaz' es larga? " + esLarga.test("interfaz"));
        System.out.println("Longitud de 'enum': " + longitud.apply("enum"));
        System.out.println("Mayor entre 17 y 42: " + mayor.apply(17, 42));

        // Combinación de predicados y Stream API
        Predicate<String> empiezaConJ = s -> s.startsWith("J");
        Predicate<String> largaYConJ = esLarga.and(empiezaConJ);

        List<String> palabras = List.of("Java", "JavaScript", "Kotlin", "JetBrains", "Go");
        System.out.println("Palabras largas que empiezan con J:");
        palabras.stream().filter(largaYConJ).map(gritar).forEach(imprimir);
        System.out.println();
    }
}
