package teoria.seccion1_interfaces;

/**
 * Sección 1.5: Métodos default, static, private y resolución del problema del diamante.
 */
public class Ejemplo4_MetodosDefaultStaticPrivate {

    // 1. Métodos default
    public interface Notificador {
        void enviar(String mensaje);

        default void enviarUrgente(String mensaje) {
            enviar("[URGENTE] " + mensaje.toUpperCase());
        }
    }

    public static class NotificadorEmail implements Notificador {
        @Override
        public void enviar(String mensaje) {
            System.out.println("Email → " + mensaje);
        }
    }

    public static class NotificadorSMS implements Notificador {
        @Override
        public void enviar(String mensaje) {
            System.out.println("SMS → " + mensaje);
        }

        @Override
        public void enviarUrgente(String mensaje) {
            enviar("!!! " + mensaje + " (responde SI)");
        }
    }

    // 2. Problema del diamante resuelto explícitamente
    public interface Cantante {
        default String presentarse() {
            return "canto";
        }
    }

    public interface Bailarin {
        default String presentarse() {
            return "bailo";
        }
    }

    public static class Artista implements Cantante, Bailarin {
        @Override
        public String presentarse() {
            return "Yo " + Cantante.super.presentarse() + " y " + Bailarin.super.presentarse();
        }
    }

    // 3. Métodos static y private (Java 9)
    public interface Formateador {
        String formatear(String texto);

        default String conMarco(String texto) {
            String contenido = "| " + formatear(texto) + " |";
            String borde = linea(contenido.length());
            return borde + "\n" + contenido + "\n" + borde;
        }

        static String limpiar(String texto) {
            return texto.trim().replaceAll("\\s+", " ");
        }

        private String linea(int largo) {
            return "+" + "-".repeat(largo - 2) + "+";
        }
    }

    public static class Mayusculas implements Formateador {
        @Override
        public String formatear(String texto) {
            return texto.toUpperCase();
        }
    }

    public static void ejecutar() {
        System.out.println("--- [1.5] Métodos default, static, private y diamante ---");
        Notificador[] canales = { new NotificadorEmail(), new NotificadorSMS() };
        for (Notificador n : canales) {
            n.enviar("Tu pedido fue enviado");
            n.enviarUrgente("Tu clave expira hoy");
        }

        System.out.println("\nResolución del diamante:");
        System.out.println(new Artista().presentarse());

        System.out.println("\nMétodos static y private en interfaces:");
        String limpia = Formateador.limpiar("   hola   mundo    java   ");
        Formateador f = new Mayusculas();
        System.out.println(f.conMarco(limpia));
        System.out.println();
    }
}
