package teoria.seccion2_enums;

/**
 * Sección 2.11: El Enum como patrón Singleton.
 * Según Joshua Bloch (Effective Java), un enum de un solo elemento es la forma
 * más segura, limpia y concisa de implementar un Singleton en Java,
 * ya que garantiza serialización segura y protección contra reflexión.
 */
public class Ejemplo16_EnumSingleton {

    public enum Configuracion {
        INSTANCIA; // Único objeto garantizado por la JVM

        private String idioma = "es";
        private int volumen = 50;

        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

        public int getVolumen() {
            return volumen;
        }

        public void setVolumen(int volumen) {
            // Math.clamp disponible desde Java 21 LTS
            this.volumen = Math.clamp(volumen, 0, 100);
        }
    }

    public static void ejecutar() {
        System.out.println("--- [2.11] Enum como Singleton ---");
        Configuracion c1 = Configuracion.INSTANCIA;
        Configuracion c2 = Configuracion.INSTANCIA;

        c1.setIdioma("en");
        c1.setVolumen(140); // Se limita automáticamente a 100 con Math.clamp

        System.out.println("c2 ve: " + c2.getIdioma() + ", volumen " + c2.getVolumen());
        System.out.println("¿c1 y c2 apuntan al mismo objeto en memoria? " + (c1 == c2));
        System.out.println();
    }
}
