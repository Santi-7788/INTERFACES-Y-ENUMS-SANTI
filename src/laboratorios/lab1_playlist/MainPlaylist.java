package laboratorios.lab1_playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Laboratorio 1: Mi playlist ordenada.
 * Demuestra:
 * - Implementación de Comparable<Cancion> (orden natural por título).
 * - Uso de Comparator encadenado con reversed() (de mayor a menor duración).
 * - Uso de Predicate<Cancion> con Stream API (canciones > 200 segundos).
 */
public class MainPlaylist {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   LABORATORIO 1: MI PLAYLIST ORDENADA");
        System.out.println("==================================================");

        List<Cancion> playlist = new ArrayList<>(List.of(
                new Cancion("Tusa", "Karol G", 200),
                new Cancion("La Bicicleta", "Carlos Vives", 227),
                new Cancion("Despacito", "Luis Fonsi", 228),
                new Cancion("Bailando", "Enrique Iglesias", 243)
        ));

        // 1. Orden natural por título usando Comparable
        Collections.sort(playlist);
        System.out.println("Orden natural (título):");
        for (Cancion c : playlist) {
            System.out.printf("  %-14s %-17s %s%n", c.getTitulo(), c.getArtista(), c.duracion());
        }

        // 2. Orden de mayor a menor duración usando Comparator
        playlist.sort(Comparator.comparingInt(Cancion::getDuracionSeg).reversed());
        System.out.println("\nDe la más larga a la más corta:");
        playlist.forEach(c -> System.out.println("  " + c.getTitulo() + " (" + c.duracion() + ")"));

        // 3. Filtrar canciones de más de 200 segundos usando Predicate y Stream
        Predicate<Cancion> esLarga = c -> c.getDuracionSeg() > 200;
        List<String> largas = playlist.stream()
                .filter(esLarga)
                .map(c -> c.getTitulo().toUpperCase())
                .toList();

        System.out.println("\nCanciones largas: " + largas);
        System.out.println("==================================================\n");
    }
}
