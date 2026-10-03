package teoria.seccion2_enums;

import teoria.seccion2_enums.Ejemplo9_DiaSemanaIntro.DiaSemana;

/**
 * Sección 2.5: Enums y switch moderno (expresiones con flecha y yield).
 */
public class Ejemplo10_EnumSwitchModerno {

    public static String tipoDia(DiaSemana dia) {
        return switch (dia) {
            case SABADO, DOMINGO -> "fin de semana";
            case LUNES, MARTES, MIERCOLES, JUEVES, VIERNES -> "día laboral";
        };
    }

    public static int horasDeClase(DiaSemana dia) {
        return switch (dia) {
            case LUNES, MIERCOLES -> 4;
            case MARTES, JUEVES -> 6;
            case VIERNES -> {
                int teoria = 1, laboratorio = 2;
                yield teoria + laboratorio; // yield devuelve el valor del bloque
            }
            case SABADO, DOMINGO -> 0;
        };
    }

    public static void ejecutar() {
        System.out.println("--- [2.5] Enums y expresiones switch modernas ---");
        for (DiaSemana d : DiaSemana.values()) {
            System.out.printf("%-10s %-14s %d h%n", d, tipoDia(d), horasDeClase(d));
        }
        System.out.println();
    }
}
