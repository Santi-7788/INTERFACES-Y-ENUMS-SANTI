package retos.reto1_figuras;

public record Triangulo(double base, double altura) implements Figura {
    /**
     * Calcula el perímetro asumiendo un triángulo isósceles simétrico con la base y altura dadas.
     */
    public double perimetroIsosceles() {
        double cateto = base / 2.0;
        double ladoIgual = Math.hypot(cateto, altura);
        return base + 2 * ladoIgual;
    }
}
