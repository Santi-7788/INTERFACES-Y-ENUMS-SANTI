package teoria.seccion2_enums;

import java.util.EnumMap;
import java.util.EnumSet;
import teoria.seccion2_enums.Ejemplo9_DiaSemanaIntro.DiaSemana;

/**
 * Sección 2.10: Colecciones especializadas de alto rendimiento: EnumSet y EnumMap.
 */
public class Ejemplo15_EnumSetEnumMap {

    public static void ejecutar() {
        System.out.println("--- [2.10] Colecciones especializadas: EnumSet y EnumMap ---");

        // EnumSet: implementado internamente con vectores de bits (bitmask de 64 bits por long)
        EnumSet<DiaSemana> finde = EnumSet.of(DiaSemana.SABADO, DiaSemana.DOMINGO);
        EnumSet<DiaSemana> laborales = EnumSet.complementOf(finde);
        EnumSet<DiaSemana> mitad = EnumSet.range(DiaSemana.MARTES, DiaSemana.JUEVES);

        System.out.println("Fin de semana: " + finde);
        System.out.println("Laborales:     " + laborales);
        System.out.println("Mitad:         " + mitad);
        System.out.println("¿VIERNES es laboral? " + laborales.contains(DiaSemana.VIERNES));

        // EnumMap: implementado como un array simple indexado por ordinal()
        System.out.println("\nEnumMap (recorrido garantizado por orden de ordinal):");
        EnumMap<DiaSemana, String> horario = new EnumMap<>(DiaSemana.class);
        horario.put(DiaSemana.VIERNES, "Laboratorio de Java");   // Insertado 1.°
        horario.put(DiaSemana.LUNES, "Teoría de interfaces");     // Insertado 2.°
        horario.put(DiaSemana.MIERCOLES, "Taller de enums");      // Insertado 3.°

        horario.forEach((dia, clase) -> System.out.printf("  %-10s %s%n", dia, clase));
        System.out.println();
    }
}
