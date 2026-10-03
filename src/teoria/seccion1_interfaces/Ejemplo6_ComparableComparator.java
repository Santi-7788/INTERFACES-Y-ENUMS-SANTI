package teoria.seccion1_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sección 1.7: Interfaces del JDK: Comparable y Comparator.
 */
public class Ejemplo6_ComparableComparator {

    public static class Estudiante implements Comparable<Estudiante> {
        private final String nombre;
        private final double promedio;

        public Estudiante(String nombre, double promedio) {
            this.nombre = nombre;
            this.promedio = promedio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPromedio() {
            return promedio;
        }

        // Orden natural: alfabético por nombre
        @Override
        public int compareTo(Estudiante otro) {
            return this.nombre.compareTo(otro.nombre);
        }

        @Override
        public String toString() {
            return nombre + " (" + promedio + ")";
        }
    }

    public static void ejecutar() {
        System.out.println("--- [1.7] Comparable (orden natural) vs Comparator (orden externo) ---");
        List<Estudiante> curso = new ArrayList<>(List.of(
                new Estudiante("Valentina", 4.5),
                new Estudiante("Andrés", 3.8),
                new Estudiante("Sofía", 4.5),
                new Estudiante("Mateo", 4.1)
        ));

        // 1. Orden natural por compareTo
        Collections.sort(curso);
        System.out.println("Alfabético (Comparable): " + curso);

        // 2. Orden personalizado con Comparator encadenado
        curso.sort(Comparator.comparingDouble(Estudiante::getPromedio)
                .reversed()
                .thenComparing(Estudiante::getNombre));
        System.out.println("Por promedio descendente y nombre (Comparator): " + curso);
        System.out.println();
    }
}
