package teoria;

/**
 * Resuelve y documenta todos los Puntos de Control y la Autoevaluación 3.4
 * del documento "Interfaces y Enums en Java".
 */
public class PuntosDeControlYAutoevaluacion {

    public static void mostrarPuntosDeControl() {
        System.out.println("======================================================================");
        System.out.println("                 PUNTOS DE CONTROL DEL DOCUMENTO                      ");
        System.out.println("======================================================================");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 1.2]");
        System.out.println("1. ¿Qué palabra clave usa una clase para 'firmar' una interfaz?");
        System.out.println("   R/ implements.");
        System.out.println("2. ¿Por qué el método de una interfaz termina en ';' y no tiene llaves?");
        System.out.println("   R/ Porque solo declara el contrato (la firma); la implementación concreta");
        System.out.println("      la provee cada clase que lo implementa.");
        System.out.println("3. ¿Es válido escribir 'Sonoro s = new Sonoro();'? ¿Por qué?");
        System.out.println("   R/ No: una interfaz no se puede instanciar directamente porque es abstracta.");
        System.out.println("      Solo se puede usar como tipo de referencia para objetos que la implementen.");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 1.4]");
        System.out.println("1. ¿Cuántas clases puede extender una clase? ¿Cuántas interfaces puede implementar?");
        System.out.println("   R/ Una clase solo puede extender UNA sola clase (extends), pero puede");
        System.out.println("      implementar TODAS las interfaces que necesite (implements A, B, C...).");
        System.out.println("2. Si 'Volador v = new Pato();', ¿puedes escribir 'v.nadar() '?");
        System.out.println("   R/ No: el tipo declarado es Volador, y en su contrato solo existe volar().");
        System.out.println("      El compilador valida únicamente los métodos del tipo declarado.");
        System.out.println("3. ¿Qué modificadores tiene implícitamente 'int LIMITE = 5;' dentro de una interfaz?");
        System.out.println("   R/ public static final.");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 1.6]");
        System.out.println("1. ¿Cuántos métodos abstractos tiene una interfaz funcional?");
        System.out.println("   R/ Exactamente UNO (puede tener además métodos default y static).");
        System.out.println("2. Reescribe como lambda: una Function<Integer, Integer> que devuelva el cuadrado:");
        System.out.println("   R/ Function<Integer, Integer> cuadrado = n -> n * n;");
        System.out.println("3. ¿Qué interfaz de java.util.function usarías para '¿el número es positivo?'?");
        System.out.println("   R/ Predicate<Integer>, porque recibe un parámetro y retorna un boolean.");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 1.9]");
        System.out.println("1. ¿Qué devuelve compareTo si el objeto actual debe ir después del otro?");
        System.out.println("   R/ Un número entero positivo (> 0).");
        System.out.println("2. Tienes Ave, Avion y Superheroe. ¿Clase abstracta o interfaz para 'volar'? ¿Por qué?");
        System.out.println("   R/ Interfaz 'Volador': no pertenecen a una misma familia genealógica ('es un'),");
        System.out.println("      sino que comparten una habilidad o capacidad ('puede volar').");
        System.out.println("3. ¿Qué ventaja da 'sealed' al usar 'switch'?");
        System.out.println("   R/ Garantiza exhaustividad en tiempo de compilación. Si se cubren todas las clases");
        System.out.println("      permitidas, no hace falta 'default' y si se añade una subclase, el código avisa.");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 2.5]");
        System.out.println("1. ¿Por qué es seguro comparar enums con '==' en lugar de 'equals'?");
        System.out.println("   R/ Porque cada constante de un enum es una instancia única (singleton) en memoria.");
        System.out.println("2. ¿Qué imprime 'DiaSemana.DOMINGO.ordinal() '?");
        System.out.println("   R/ Imprime 6 (la numeración comienza en 0 con LUNES).");
        System.out.println("3. ¿Qué pasa si en una expresión switch sobre DiaSemana olvidas JUEVES y no hay default?");
        System.out.println("   R/ No compila: 'the switch expression does not cover all possible input values'.");

        System.out.println("\n[PUNTO DE CONTROL - SECCIÓN 2.12]");
        System.out.println("1. ¿En qué orden deben ir las constantes y los atributos dentro de un enum?");
        System.out.println("   R/ Primero las constantes (terminadas obligatoriamente en ';'), luego los");
        System.out.println("      atributos, los constructores y finalmente los métodos.");
        System.out.println("2. ¿Puede un enum usar 'extends'? ¿Y 'implements'?");
        System.out.println("   R/ 'extends' NO (ya hereda implícitamente de java.lang.Enum).");
        System.out.println("      'implements' SÍ (puede implementar tantas interfaces como requiera).");
        System.out.println("3. ¿Por qué EnumMap imprime las claves en orden de la semana?");
        System.out.println("   R/ Porque EnumMap almacena los valores internamente en un array indexado");
        System.out.println("      por el ordinal de cada constante, no por el orden en que fueron insertados.");
        System.out.println("======================================================================\n");
    }

    public static void mostrarAutoevaluacion() {
        System.out.println("======================================================================");
        System.out.println("           3.4 AUTOEVALUACIÓN DEL DOCUMENTO (10/10)                   ");
        System.out.println("======================================================================");

        String[][] preguntas = {
                {
                        "1. ¿Qué modificadores tiene implícitamente un método abstracto de una interfaz?",
                        "b) public abstract",
                        "Los métodos en una interfaz son públicos y abstractos por definición (§1.3)."
                },
                {
                        "2. ¿Cuál línea compila si Sonoro es una interfaz y Perro la implementa?",
                        "c) Sonoro s = new Perro();",
                        "Una interfaz no se puede instanciar directamente (new Sonoro() es inválido), pero sí se usa como tipo de referencia polimórfica (§1.2)."
                },
                {
                        "3. Una clase implementa dos interfaces con el mismo método default. ¿Qué ocurre?",
                        "c) Error: la clase debe sobrescribirlo",
                        "Conflicto del diamante: Java no adivina y exige desambiguar implementando el método y llamando si se desea a Interfaz.super.metodo() (§1.5)."
                },
                {
                        "4. ¿Cuál es una interfaz funcional válida para usar con lambda?",
                        "b) Una con un método abstracto y tres default",
                        "Una interfaz funcional requiere exactamente UN solo método abstracto; puede tener cualquier cantidad de métodos default o static (§1.6)."
                },
                {
                        "5. ¿Qué interfaz de java.util.function recibe un valor y no devuelve nada?",
                        "c) Consumer",
                        "Consumer<T> tiene el método accept(T valor) que realiza una acción y retorna void (§1.6)."
                },
                {
                        "6. ¿Qué imprime DiaSemana.MIERCOLES.ordinal() con el enum del capítulo?",
                        "b) 2",
                        "LUNES=0, MARTES=1, MIERCOLES=2 (§2.3)."
                },
                {
                        "7. ¿Qué lanza DiaSemana.valueOf(\"Lunes\")?",
                        "c) IllegalArgumentException",
                        "valueOf() distingue estrictamente mayúsculas/minúsculas. Al no coincidir con \"LUNES\", lanza IllegalArgumentException (§2.4)."
                },
                {
                        "8. ¿Cuál afirmación sobre el constructor de un enum es correcta?",
                        "b) Es siempre privado",
                        "El constructor de un enum es implícita y forzosamente privado. No se puede instanciar con 'new' (§2.6)."
                },
                {
                        "9. ¿Qué debes guardar en una base de datos para representar una constante de enum?",
                        "c) name() o un código propio",
                        "Nunca debe guardarse el ordinal(), ya que si se reordenan las constantes en el código se corrompen los datos históricos (§2.4)."
                },
                {
                        "10. Tienes Tarjeta, Nequi y Efectivo sin estado en común y quieres agregar más en el futuro. ¿Qué usas?",
                        "b) Una interfaz MetodoPago",
                        "Permite acoplamiento débil, polimorfismo abierto y extensión futura sin modificar las clases existentes (§1.8 y §3.1)."
                }
        };

        for (int i = 0; i < preguntas.length; i++) {
            System.out.printf("%s%n", preguntas[i][0]);
            System.out.printf("   -> Respuesta correcta: %s%n", preguntas[i][1]);
            System.out.printf("   -> Justificación:     %s%n%n", preguntas[i][2]);
        }
        System.out.println("======================================================================\n");
    }
}
