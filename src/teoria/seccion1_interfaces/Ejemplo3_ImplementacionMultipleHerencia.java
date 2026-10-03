package teoria.seccion1_interfaces;

/**
 * Sección 1.4: Polimorfismo, implementación múltiple y herencia de interfaces.
 * Demuestra:
 * - Una clase puede implementar múltiples interfaces (Pato implements Volador, Nadador).
 * - Una interfaz puede heredar de múltiples interfaces (extends A, B).
 */
public class Ejemplo3_ImplementacionMultipleHerencia {

    public interface Volador {
        void volar();
    }

    public interface Nadador {
        void nadar();
    }

    public static class Pato implements Volador, Nadador {
        @Override
        public void volar() {
            System.out.println("Pato: aleteo sobre el lago");
        }

        @Override
        public void nadar() {
            System.out.println("Pato: remo con mis patas");
        }
    }

    public static class Avion implements Volador {
        @Override
        public void volar() {
            System.out.println("Avión: despego a 900 km/h");
        }
    }

    public static void despegar(Volador v) {
        v.volar();
    }

    // Herencia múltiple entre interfaces
    public interface Encendible {
        void encender();
        void apagar();
    }

    public interface Conectable {
        void conectarWifi(String red);
    }

    public interface DispositivoInteligente extends Encendible, Conectable {
        String asistente(); // Acumula los métodos de Encendible y Conectable
    }

    public static class Parlante implements DispositivoInteligente {
        @Override
        public void encender() {
            System.out.println("Parlante encendido");
        }

        @Override
        public void apagar() {
            System.out.println("Parlante apagado");
        }

        @Override
        public void conectarWifi(String red) {
            System.out.println("Conectado a " + red);
        }

        @Override
        public String asistente() {
            return "Asistente listo para escuchar";
        }
    }

    public static void ejecutar() {
        System.out.println("--- [1.4] Implementación múltiple y herencia entre interfaces ---");
        Pato lucas = new Pato();
        lucas.nadar();
        despegar(lucas);
        despegar(new Avion());

        System.out.println("\nDispositivo inteligente (herencia acumulada):");
        DispositivoInteligente d = new Parlante();
        d.encender();
        d.conectarWifi("Casa_5G");
        System.out.println(d.asistente());

        Encendible soloEnciende = d; // Tratar como subtipo menor
        soloEnciende.apagar();
        System.out.println();
    }
}
