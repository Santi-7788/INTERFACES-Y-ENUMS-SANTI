package retos.reto1_figuras;

import java.util.List;

/**
 * Reto 1: Figuras con Perímetro.
 * Demuestra:
 * - Ampliación de jerarquía sellada (sealed interface con permits).
 * - Exhaustividad del compilador en expresiones switch con pattern matching.
 * - Desestructuración de records directamente en las cláusulas case (deconstruction patterns).
 */
public class MainFiguras {

    public static void main(String[] args) {
        ejecutar();
    }

    public static double area(Figura f) {
        return switch (f) {
            case Circulo c -> Math.PI * c.radio() * c.radio();
            case Rectangulo(double b, double h) -> b * h;
            case Triangulo t -> t.base() * t.altura() / 2.0;
            case Cuadrado(double lado) -> lado * lado;
        };
    }

    public static double perimetro(Figura f) {
        return switch (f) {
            case Circulo c -> 2 * Math.PI * c.radio();
            case Rectangulo(double b, double h) -> 2 * (b + h);
            case Triangulo t -> t.perimetroIsosceles();
            case Cuadrado(double lado) -> 4 * lado;
        };
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   RETO 1: FIGURAS CON PERÍMETRO (SEALED + SWITCH)");
        System.out.println("==================================================");

        List<Figura> figuras = List.of(
                new Circulo(5),
                new Rectangulo(4, 6),
                new Triangulo(10, 3),
                new Cuadrado(7)
        );

        for (Figura f : figuras) {
            System.out.printf("%-35s | Área: %8.2f | Perímetro: %8.2f%n",
                    f, area(f), perimetro(f));
        }

        System.out.println("\nNota teórica del compilador:");
        System.out.println("Al agregar 'Cuadrado' a la cláusula permits de 'Figura', el compilador");
        System.out.println("detecta automáticamente que los switch exhaustivos en area() y perimetro()");
        System.out.println("estaban incompletos, exigiendo añadir 'case Cuadrado' para compilar.");
        System.out.println("==================================================\n");
    }
}
