package retos.reto5_permisos;

/**
 * Reto 5: Permisos con EnumSet.
 * Demuestra:
 * - Almacenamiento eficiente de conjuntos de enums con EnumSet.
 * - Validación de permisos mediante el método puede(Permiso p).
 * - Verificación explícita de que INVITADO no tiene permiso de BORRAR.
 */
public class MainPermisos {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        System.out.println("==================================================");
        System.out.println("   RETO 5: CONTROL DE ACCESO CON ENUMSET");
        System.out.println("==================================================");

        // Prueba explícita solicitada en el reto
        Rol invitado = Rol.INVITADO;
        boolean invitadoPuedeBorrar = invitado.puede(Permiso.BORRAR);
        System.out.println("¿Un INVITADO puede BORRAR? " + (invitadoPuedeBorrar ? "SÍ" : "NO (Correcto, no tiene ese permiso)"));

        System.out.println("\nMatriz completa de permisos por Rol:");
        System.out.printf("%-15s", "ROL / PERMISO");
        for (Permiso p : Permiso.values()) {
            System.out.printf("%-15s", p);
        }
        System.out.println();
        System.out.println("-".repeat(75));

        for (Rol rol : Rol.values()) {
            System.out.printf("%-15s", rol);
            for (Permiso p : Permiso.values()) {
                String check = rol.puede(p) ? "[✓] PERMITIDO" : "[✗] DENEGADO";
                System.out.printf("%-15s", check);
            }
            System.out.println();
        }

        System.out.println("\nVentaja técnica de EnumSet:");
        System.out.println("EnumSet se implementa internamente como un vector de bits (bit vector).");
        System.out.println("Comprobar 'puede(Permiso)' equivale a un simple AND a nivel de CPU,");
        System.out.println("sin colisiones de hash ni overhead de objetos de nodo.");
        System.out.println("==================================================\n");
    }
}
