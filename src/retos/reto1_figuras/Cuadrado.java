package retos.reto1_figuras;

/**
 * Record Cuadrado añadido para cumplir con el Reto 1.
 * Al agregarse a permits en Figura, el compilador obliga a actualizar
 * todas las expresiones switch sobre Figura que carezcan de default.
 */
public record Cuadrado(double lado) implements Figura {
}
