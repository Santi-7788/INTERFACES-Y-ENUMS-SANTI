package teoria.seccion1_interfaces;

import java.util.List;

/**
 * Sección 1.9: Interfaces selladas (sealed), records y switch moderno.
 */
public class Ejemplo8_InterfacesSelladasRecords {

    public sealed interface FiguraTeoria permits CirculoTeoria, RectanguloTeoria, TrianguloTeoria {}

    public record CirculoTeoria(double radio) implements FiguraTeoria {}
    public record RectanguloTeoria(double base, double altura) implements FiguraTeoria {}
    public record TrianguloTeoria(double base, double altura) implements FiguraTeoria {}

    public static double calcularArea(FiguraTeoria f) {
        return switch (f) {
            case CirculoTeoria c -> Math.PI * c.radio() * c.radio();
            case RectanguloTeoria(double b, double h) -> b * h; // deconstruction pattern
            case TrianguloTeoria t -> t.base() * t.altura() / 2.0;
        };
    }

    public static void ejecutar() {
        System.out.println("--- [1.9] Interfaces selladas, records y switch con patrones ---");
        List<FiguraTeoria> figuras = List.of(
                new CirculoTeoria(5),
                new RectanguloTeoria(4, 6),
                new TrianguloTeoria(10, 3)
        );

        for (FiguraTeoria f : figuras) {
            System.out.printf("%-34s área = %.2f%n", f, calcularArea(f));
        }
        System.out.println();
    }
}
