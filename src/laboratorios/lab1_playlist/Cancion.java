package laboratorios.lab1_playlist;

/**
 * Representa una canción en la playlist.
 * Implementa Comparable para proporcionar el orden natural por título.
 */
public class Cancion implements Comparable<Cancion> {
    private final String titulo;
    private final String artista;
    private final int duracionSeg;

    public Cancion(String titulo, String artista, int duracionSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }

    /**
     * Devuelve el tiempo formateado como "m:ss".
     */
    public String duracion() {
        return String.format("%d:%02d", duracionSeg / 60, duracionSeg % 60);
    }

    /**
     * Orden natural: orden alfabético por título.
     */
    @Override
    public int compareTo(Cancion otra) {
        return this.titulo.compareTo(otra.titulo);
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracion() + ")";
    }
}
