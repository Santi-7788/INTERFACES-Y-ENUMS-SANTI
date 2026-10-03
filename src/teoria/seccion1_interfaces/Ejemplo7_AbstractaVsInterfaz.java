package teoria.seccion1_interfaces;

import java.util.List;

/**
 * Sección 1.8: Interfaz vs Clase Abstracta.
 * Demuestra:
 * - Clase abstracta para jerarquías "es un" que comparten atributos y estado (Empleado).
 * - Interfaz para capacidades ortogonales "puede hacer" (Bonificable).
 */
public class Ejemplo7_AbstractaVsInterfaz {

    public static abstract class Empleado {
        protected final String nombre;
        protected final double salarioBase;

        protected Empleado(String nombre, double salarioBase) {
            this.nombre = nombre;
            this.salarioBase = salarioBase;
        }

        public abstract double salarioMensual();

        public String resumen() {
            return String.format("%-7s $%,.0f", nombre, salarioMensual());
        }
    }

    public interface Bonificable {
        double bono();
    }

    public static class Desarrollador extends Empleado implements Bonificable {
        public Desarrollador(String nombre, double base) {
            super(nombre, base);
        }

        @Override
        public double bono() {
            return salarioBase * 0.15;
        }

        @Override
        public double salarioMensual() {
            return salarioBase + bono();
        }
    }

    public static class Practicante extends Empleado {
        public Practicante(String nombre, double base) {
            super(nombre, base);
        }

        @Override
        public double salarioMensual() {
            return salarioBase;
        }
    }

    public static void ejecutar() {
        System.out.println("--- [1.8] Clase Abstracta vs Interfaz ---");
        List<Empleado> nomina = List.of(
                new Desarrollador("Laura", 6_000_000),
                new Practicante("Tomás", 1_750_000)
        );

        nomina.forEach(e -> System.out.println(e.resumen()));

        double total = nomina.stream().mapToDouble(Empleado::salarioMensual).sum();
        System.out.printf("Total $%,.0f%n", total);
        System.out.println();
    }
}
