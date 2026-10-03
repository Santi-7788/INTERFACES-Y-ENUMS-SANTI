package teoria.seccion2_enums;

/**
 * Sección 2.6: Enums con atributos, constructor y métodos de negocio.
 */
public class Ejemplo11_MonedaAtributosMetodos {

    public enum Moneda {
        COP("Peso colombiano", "$", 1),
        USD("Dólar estadounidense", "US$", 4_000),
        EUR("Euro", "€", 4_400),
        MXN("Peso mexicano", "MX$", 220); // El punto y coma es obligatorio si hay miembros

        private final String nombre;
        private final String simbolo;
        private final double enPesos;

        Moneda(String nombre, String simbolo, double enPesos) { // Constructor siempre privado
            this.nombre = nombre;
            this.simbolo = simbolo;
            this.enPesos = enPesos;
        }

        public String getNombre() {
            return nombre;
        }

        public String formatear(double cantidad) {
            return simbolo + String.format("%,.2f", cantidad);
        }

        public double convertirA(Moneda destino, double cantidad) {
            return cantidad * this.enPesos / destino.enPesos;
        }

        public static Moneda desdeSimbolo(String simbolo) {
            for (Moneda m : values()) {
                if (m.simbolo.equals(simbolo)) return m;
            }
            throw new IllegalArgumentException("Símbolo desconocido: " + simbolo);
        }
    }

    public static void ejecutar() {
        System.out.println("--- [2.6] Enums con atributos, métodos y conversor ---");
        for (Moneda m : Moneda.values()) {
            System.out.printf("%s %-21s %s%n", m, m.getNombre(), m.formatear(1));
        }

        double pesos = Moneda.USD.convertirA(Moneda.COP, 25);
        System.out.println(Moneda.USD.formatear(25) + " = " + Moneda.COP.formatear(pesos));

        double mxn = Moneda.EUR.convertirA(Moneda.MXN, 100);
        System.out.println(Moneda.EUR.formatear(100) + " = " + Moneda.MXN.formatear(mxn));

        System.out.println("Símbolo € → " + Moneda.desdeSimbolo("€").getNombre());
        System.out.println();
    }
}
