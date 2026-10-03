package retos.reto3_calculadora;

import java.util.function.DoubleBinaryOperator;

/**
 * Reto 3: Enum Operador reescrito usando DoubleBinaryOperator y lambdas.
 * Almacena el comportamiento como dato de primera clase dentro de cada constante.
 */
public enum OperadorLambda {
    SUMA("+", (a, b) -> a + b),
    RESTA("-", (a, b) -> a - b),
    MULTIPLICACION("×", (a, b) -> a * b),
    DIVISION("÷", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("división por cero");
        }
        return a / b;
    }),
    // Nuevas operaciones solicitadas en el Reto 3:
    POTENCIA("^", Math::pow),
    MODULO("%", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("módulo por cero");
        }
        return a % b;
    });

    private final String simbolo;
    private final DoubleBinaryOperator operacion;

    OperadorLambda(String simbolo, DoubleBinaryOperator operacion) {
        this.simbolo = simbolo;
        this.operacion = operacion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Ejecuta la operación matemática correspondiente a la constante.
     */
    public double aplicar(double a, double b) {
        return operacion.applyAsDouble(a, b);
    }
}
