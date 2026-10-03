package retos.reto1_figuras;

/**
 * Reto 1: Jerarquía sellada Figura ampliada con Cuadrado.
 * Una interfaz sellada restringe qué clases o records pueden implementarla
 * mediante la cláusula 'permits'.
 */
public sealed interface Figura permits Circulo, Rectangulo, Triangulo, Cuadrado {
}
