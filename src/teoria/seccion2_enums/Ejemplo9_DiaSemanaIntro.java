package teoria.seccion2_enums;

/**
 * Secciones 2.1 a 2.4: Introducción a Enums y métodos estándar incluidos.
 * Demuestra:
 * - Evitar números y textos mágicos.
 * - Comparación segura por referencia con ==.
 * - Métodos automáticos: values(), valueOf(), name(), ordinal(), compareTo().
 */
public class Ejemplo9_DiaSemanaIntro {

    public enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    public static void ejecutar() {
        System.out.println("--- [2.1 a 2.4] Enums básicos y métodos integrados ---");
        DiaSemana hoy = DiaSemana.VIERNES;
        System.out.println("Hoy es " + hoy);

        if (hoy == DiaSemana.VIERNES) {
            System.out.println("¡Por fin viernes! (Comparación con == segura y rápida)");
        }

        // 1. values()
        System.out.print("\nRecorriendo con values(): ");
        for (DiaSemana d : DiaSemana.values()) {
            System.out.print(d.ordinal() + ":" + d.name() + " ");
        }
        System.out.println();

        // 2. valueOf()
        DiaSemana d = DiaSemana.valueOf("MARTES");
        System.out.println("valueOf(\"MARTES\") → " + d);

        // 3. compareTo()
        boolean antes = DiaSemana.LUNES.compareTo(DiaSemana.JUEVES) < 0;
        System.out.println("¿LUNES va antes que JUEVES? " + antes);
        System.out.println("Cantidad total de constantes: " + DiaSemana.values().length);

        // 4. Manejo de error con valueOf incorrecto
        try {
            DiaSemana.valueOf("lunes"); // Sensible a mayúsculas
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado con texto inválido: " + e.getMessage());
        }
        System.out.println();
    }
}
