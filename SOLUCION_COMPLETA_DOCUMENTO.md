# Solución Completa: Interfaces y Enums en Java
**Curso:** Programación Orientada a Objetos en Java  
**Compatibilidad:** Java 21 LTS / Java 25 / Java 26  
**Proyecto IntelliJ:** `INTERFACES Y ENUMS SANTI`

---

## Índice General

1. [Estructura del Proyecto y Organización de Paquetes](#1-estructura-del-proyecto-y-organización-de-paquetes)
2. [Solución de los 4 Laboratorios Guiados](#2-solución-de-los-4-laboratorios-guiados)
   - [Laboratorio 1: Mi playlist ordenada](#laboratorio-1-mi-playlist-ordenada)
   - [Laboratorio 2: Pasarela de pagos](#laboratorio-2-pasarela-de-pagos)
   - [Laboratorio 3: Semáforo inteligente](#laboratorio-3-semáforo-inteligente)
   - [Laboratorio 4: Cafetería "El Algoritmo" (Proyecto Integrador)](#laboratorio-4-cafetería-el-algoritmo)
3. [Solución de los 5 Retos para ir más allá](#3-solución-de-los-5-retos-para-ir-más-allá)
   - [Reto 1: Figuras con Perímetro (Sealed + Pattern Matching)](#reto-1-figuras-con-perímetro)
   - [Reto 2: Baraja Española (Enums + Records + Collections.shuffle)](#reto-2-baraja-española)
   - [Reto 3: Calculadora con Lambdas en el Enum (DoubleBinaryOperator)](#reto-3-calculadora-con-lambdas-en-el-enum)
   - [Reto 4: Promociones Combinables (Método default de Orden Superior)](#reto-4-promociones-combinables)
   - [Reto 5: Control de Permisos con EnumSet](#reto-5-control-de-permisos-con-enumset)
4. [Ejemplos Teóricos Compilados (Secciones 1 y 2)](#4-ejemplos-teóricos-compilados)
5. [Respuestas a los Puntos de Control Teóricos](#5-respuestas-a-los-puntos-de-control-teóricos)
6. [Respuestas Justificadas a la Autoevaluación 3.4](#6-respuestas-justificadas-a-la-autoevaluación-34)
7. [Cómo Ejecutar el Proyecto](#7-cómo-ejecutar-el-proyecto)

---

## 1. Estructura del Proyecto y Organización de Paquetes

El proyecto fue estructurado bajo las mejores prácticas de modularidad en Java y acoplamiento limpio:

```text
src/
├── Main.java                                   # Menú maestro y ejecutor integral
│
├── laboratorios/
│   ├── lab1_playlist/
│   │   ├── Cancion.java                        # Implementa Comparable<Cancion>
│   │   └── MainPlaylist.java                   # Collections.sort, Comparator y Predicate
│   ├── lab2_pagos/
│   │   ├── MetodoPago.java                     # Interfaz con métodos default comision y totalACobrar
│   │   ├── TarjetaCredito.java                 # Comisión del 3% y validación de cupo
│   │   ├── BilleteraDigital.java               # Manejo de saldo y sin comisión
│   │   ├── Efectivo.java                       # Aprobación directa
│   │   ├── Criptomoneda.java                   # Quinto método para demostrar el Paso 6
│   │   ├── Caja.java                           # Despacho polimórfico desacoplado
│   │   └── MainPasarela.java                   # Pruebas oficiales del documento
│   ├── lab3_semaforo/
│   │   ├── Semaforo.java                       # Enum con transiciones switch, duracionCiclo y paso 6
│   │   └── MainSemaforo.java                   # Simulación del ciclo completo (70 s)
│   └── lab4_cafeteria/
│       ├── Bebida.java                         # Enum con precios base
│       ├── Tamano.java                         # Enum con recargos
│       ├── EstadoPedido.java                   # Máquina de estados con transiciones y cancelaciones
│       ├── Promocion.java                      # Interfaz funcional con lambdas y combinador
│       ├── Item.java                           # Record inmutable de detalle
│       ├── Pedido.java                         # Lógica del pedido con API fluida y streams
│       └── MainCafeteria.java                  # Pedido de Camila y prueba de restricciones
│
├── retos/
│   ├── reto1_figuras/                          # sealed interface Figura + Cuadrado + pattern matching
│   ├── reto2_baraja/                           # Palo, Valor, record Carta y barajado de 48 cartas
│   ├── reto3_calculadora/                      # DoubleBinaryOperator con POTENCIA y MODULO
│   ├── reto4_promociones/                      # Composición con método default Promocion.y(...)
│   └── reto5_permisos/                         # Control de accesos con EnumSet y verificación de INVITADO
│
└── teoria/
    ├── PuntosDeControlYAutoevaluacion.java      # Respuestas completas a cuestionarios
    ├── seccion1_interfaces/                    # Ejemplos 1 al 8 (Granja, Diamante, Lambdas, Records, etc.)
    └── seccion2_enums/                         # Ejemplos 9 al 16 (Día, Switch, Moneda, Singleton, EnumSet)
```

---

## 2. Solución de los 4 Laboratorios Guiados

### Laboratorio 1: Mi playlist ordenada
- **Conceptos aplicados:** `Comparable<T>`, `Comparator<T>`, `Predicate<T>`, Streams y Lambdas.
- **Implementación:**
  - `Cancion.java` implementa `Comparable<Cancion>`, estableciendo el **orden natural** por título mediante `compareTo()`.
  - Provee el método `duracion()` calculando minutos y segundos con `String.format("%d:%02d", duracionSeg / 60, duracionSeg % 60)`.
  - Se ordena la lista por orden natural con `Collections.sort(playlist)`.
  - Se ordena por duración descendente con `Comparator.comparingInt(Cancion::getDuracionSeg).reversed()`.
  - Se filtran canciones de duración superior a 200 segundos mediante un `Predicate<Cancion>` y se extraen en mayúsculas con `stream().map(...).toList()`.
- **Salida en consola obtenida:**
  ```text
  Orden natural (título):
    Bailando       Enrique Iglesias  4:03
    Despacito      Luis Fonsi        3:48
    La Bicicleta   Carlos Vives      3:47
    Tusa           Karol G           3:20

  De la más larga a la más corta:
    Bailando (4:03)
    Despacito (3:48)
    La Bicicleta (3:47)
    Tusa (3:20)

  Canciones largas: [BAILANDO, DESPACITO, LA BICICLETA]
  ```

---

### Laboratorio 2: Pasarela de pagos
- **Conceptos aplicados:** Interfaces con métodos abstractos y métodos `default`, principio de bajo acoplamiento y polimorfismo.
- **Implementación:**
  - `MetodoPago` define los métodos abstractos `nombre()` y `pagar(double monto)`. Provee métodos default para `comision(double monto)` (retorna 0 por defecto) y `totalACobrar(double monto)` (suma `monto + comision(monto)`).
  - `TarjetaCredito` cobra 3% de comisión (`monto * 0.03`), descuenta de `cupoDisponible` si alcanza, o rechaza si supera el cupo.
  - `BilleteraDigital` valida y descuenta sobre un saldo sin comisiones.
  - `Efectivo` aprueba siempre sin comisión.
  - `Caja` contiene `static void cobrar(MetodoPago m, double monto)`. **No tiene ningún acoplamiento** a las clases concretas.
  - **Paso 6:** Se agregó la clase `Criptomoneda` implementando `MetodoPago` con tarifa de red fija, demostrando que el sistema es abierto a extensiones sin alterar una sola línea de `Caja`.
- **Salida en consola obtenida:**
  ```text
  Tarjeta de crédito   $   120.000 comisión $  3.600 APROBADO
  Billetera digital    $    80.000 comisión $      0 RECHAZADO
  Efectivo             $    35.000 comisión $      0 APROBADO
  Tarjeta de crédito   $    99.000 comisión $  2.970 RECHAZADO
  ```

---

### Laboratorio 3: Semáforo inteligente
- **Conceptos aplicados:** Enums con atributos `final`, constructores, métodos de instancia con `switch` moderno de flecha y métodos estáticos con `values()`.
- **Implementación:**
  - `Semaforo` con `VERDE(30, "Avance")`, `AMARILLO(5, "Precaución")`, `ROJO(35, "Pare")`.
  - Método `siguiente()` implementado con expresión switch exhaustiva.
  - Método estático `duracionCiclo()` que suma los segundos mediante `values()`.
  - **Paso 6 (Reto extra):** Se agregó `AMARILLO_INTERMITENTE(0, "Precaución intermitente")`. Al agregarlo, el compilador exige actualizar el switch para conservar la exhaustividad.
- **Salida en consola obtenida:**
  ```text
  Paso 1: VERDE     30 s → Avance
  Paso 2: AMARILLO   5 s → Precaución
  Paso 3: ROJO      35 s → Pare
  Paso 4: VERDE     30 s → Avance
  Duración del ciclo completo: 70 s
  ```

---

### Laboratorio 4: Cafetería "El Algoritmo" (Proyecto Integrador)
- **Conceptos aplicados:** Integración de Enums, Interfaces Funcionales, Records inmutables, Clases con estado, Fluent API y Streams.
- **Componentes:**
  1. `Bebida.java`: Enum con `precioBase` (`TINTO`: 2.500, `CAPUCHINO`: 6.000, `CHOCOLATE`: 5.000, `AROMATICA`: 3.000).
  2. `Tamano.java`: Enum con `recargo` (`PEQUENO`: 0, `MEDIANO`: 1.000, `GRANDE`: 2.000).
  3. `EstadoPedido.java`: Enum como máquina de estados (`RECIBIDO -> EN_PREPARACION -> LISTO -> ENTREGADO / CANCELADO`).
  4. `Promocion.java`: Interfaz funcional con fábricas estáticas lambdas (`ninguna()`, `porcentaje(double pct)`, `fijaDesde(double minimo, double valor)`).
  5. `Item.java`: Record inmutable que calcula el subtotal por renglón: `(precioBase + recargo) * cantidad`.
  6. `Pedido.java`: Permite encadenamiento en `agregar(...)`, cambio de estado con `avanzar()`, validación al `cancelar()`, y cálculo automático con Stream API.
- **Caso de prueba ejecutado:** Pedido de Camila con 2 capuchinos grandes, 1 tinto pequeño y 1 chocolate mediano, aplicando 10% de descuento y avanzando 2 estados.
- **Salida en consola obtenida:**
  ```text
    = Cafetería El Algoritmo =
  Cliente: Camila | Estado: LISTO
  2 x CAPUCHINO  GRANDE   $  16.000
  1 x TINTO      PEQUENO  $   2.500
  1 x CHOCOLATE  MEDIANO  $   6.000
  Subtotal                $  24.500
  Descuento               $   2.450
  TOTAL                   $  22.050
  Aviso: No se puede cancelar en estado LISTO
  ```

---

## 3. Solución de los 5 Retos para ir más allá

### Reto 1: Figuras con Perímetro
- **Objetivo:** Ampliar la jerarquía sellada `Figura` agregando el record `Cuadrado` y un método `perimetro(Figura f)` usando switch con patrones de deconstrucción de records.
- **Explicación técnica:** Al declarar `sealed interface Figura permits Circulo, Rectangulo, Triangulo, Cuadrado`, el compilador de Java 21+ fuerza a que cualquier expresión `switch` sobre `Figura` sin cláusula `default` contemple obligatoriamente las 4 variantes. Si se olvida `Cuadrado`, el código no compila.

### Reto 2: Baraja Española
- **Objetivo:** Modelar los 4 palos (`OROS, COPAS, ESPADAS, BASTOS`) y los 12 valores tradicionales (del 1 al 12), generar las 48 cartas con bucles anidados sobre `values()` y barajar con `Collections.shuffle`.
- **Implementación:**
  - `Palo.java` y `Valor.java` como enums.
  - `Carta.java` como record inmutable.
  - Generación de producto cartesiano (4 x 12 = 48 cartas) y barajado aleatorio eficiente.

### Reto 3: Calculadora con Lambdas en el Enum
- **Objetivo:** Reescribir `Operador` usando el tipo funcional `DoubleBinaryOperator` como atributo en cada constante, incorporando `POTENCIA` y `MODULO`.
- **Análisis de Legibilidad:**
  - **Versión con Lambdas:** Es óptima y mucho más legible para operaciones matemáticas sencillas de una línea (`(a, b) -> a + b`, `Math::pow`).
  - **Versión con Métodos Abstractos por Constante:** Es preferible cuando la operación requiere lógica extensa, algoritmos con bucles o manejo complejo de excepciones, evitando constructores densos.

### Reto 4: Promociones Combinables
- **Objetivo:** Agregar a `Promocion` el método default `Promocion y(Promocion otra)` que sume ambos descuentos sin superar el subtotal.
- **Implementación:**
  ```java
  default Promocion y(Promocion otra) {
      return subtotal -> Math.min(this.descuento(subtotal) + otra.descuento(subtotal), subtotal);
  }
  ```
  Permite componer promociones limpiamente:
  `Promocion combo = Promocion.porcentaje(10).y(Promocion.fijaDesde(20_000, 1_000));`

### Reto 5: Control de Permisos con EnumSet
- **Objetivo:** Enums `Permiso` y `Rol`, donde cada rol tiene un `EnumSet<Permiso>` y un método `puede(Permiso p)`, demostrando que `INVITADO` no puede borrar.
- **Ventaja técnica:** `EnumSet` no utiliza una tabla hash; se implementa como un bitfield (máscara de bits sobre un entero largo de 64 bits). Las comprobaciones de pertenencia son instrucciones binarias directas a nivel de hardware, otorgando el máximo rendimiento y menor consumo de memoria.

---

## 4. Ejemplos Teóricos Compilados

Todos los micro-ejemplos presentados a lo largo del documento fueron codificados y organizados en clases ejecutables:

| Sección | Clase | Contenido Clave |
|---|---|---|
| **1.1 - 1.2** | `Ejemplo1_GranjaSonoro` | Contrato, `implements`, polimorfismo de animales |
| **1.3** | `Ejemplo2_ReglasJuegoConstantes` | Constantes implícitas `public static final` |
| **1.4** | `Ejemplo3_ImplementacionMultipleHerencia` | Múltiples interfaces y herencia acumulada entre interfaces |
| **1.5** | `Ejemplo4_MetodosDefaultStaticPrivate` | Métodos default, resolución del diamante, métodos static y private |
| **1.6** | `Ejemplo5_FuncionalesLambdas` | `@FunctionalInterface`, lambdas, referencias y `java.util.function` |
| **1.7** | `Ejemplo6_ComparableComparator` | Orden natural vs `Comparator` encadenado (`thenComparing`) |
| **1.8** | `Ejemplo7_AbstractaVsInterfaz` | Jerarquía `Empleado` vs interfaz `Bonificable` |
| **1.9** | `Ejemplo8_InterfacesSelladasRecords` | `sealed interface`, records y pattern matching |
| **2.1 - 2.4**| `Ejemplo9_DiaSemanaIntro` | Eliminación de números mágicos, comparación con `==`, `values()`, `valueOf()` |
| **2.5** | `Ejemplo10_EnumSwitchModerno` | Expresiones switch con flechas y bloques con `yield` |
| **2.6** | `Ejemplo11_MonedaAtributosMetodos` | Enums con constructor privado, formateo y conversor de divisas |
| **2.7** | `Ejemplo12_OperadorAbstracto` | Métodos abstractos dentro de un enum con implementación en constantes |
| **2.8** | `Ejemplo13_EnumImplementaInterfaz` | Enums implementando interfaces y combinación con lambdas |
| **2.9** | `Ejemplo14_MaquinaEstadosPedido` | Máquinas de estados y transiciones en enums |
| **2.10** | `Ejemplo15_EnumSetEnumMap` | Operaciones con `EnumSet` y orden garantizado de `EnumMap` |
| **2.11** | `Ejemplo16_EnumSingleton` | Singleton thread-safe con enum y `Math.clamp` |

---

## 5. Respuestas a los Puntos de Control Teóricos

### Sección 1.2
1. **¿Qué palabra clave usa una clase para “firmar” una interfaz?**  
   **Respuesta:** `implements`.
2. **¿Por qué el método de una interfaz termina en `;` y no tiene llaves?**  
   **Respuesta:** Porque en una interfaz tradicional solo se define el contrato (la firma: nombre, tipo de retorno y parámetros); el cuerpo concreto lo escribe cada clase que la implemente.
3. **¿Es válido escribir `Sonoro s = new Sonoro();`? ¿Por qué?**  
   **Respuesta:** No. Las interfaces son abstractas por definición y no poseen constructores; no pueden instanciarse directamente. Se usan únicamente como tipos de referencia.

### Sección 1.4
1. **¿Cuántas clases puede extender una clase? ¿Cuántas interfaces puede implementar?**  
   **Respuesta:** Puede extender solo **una** clase (`extends`), pero puede implementar **múltiples** interfaces (`implements A, B, C...`).
2. **Si `Volador v = new Pato();`, ¿puedes escribir `v.nadar()`?**  
   **Respuesta:** No. El tipo declarado de la variable es `Volador`, y el contrato de `Volador` no incluye el método `nadar()`. El compilador solo revisa el tipo declarado.
3. **¿Qué modificadores tiene implícitamente `int LIMITE = 5;` dentro de una interfaz?**  
   **Respuesta:** `public static final`.

### Sección 1.6
1. **¿Cuántos métodos abstractos tiene una interfaz funcional?**  
   **Respuesta:** Exactamente **uno** (puede contener además cualquier cantidad de métodos `default` o `static`).
2. **Reescribe como lambda: una `Function<Integer, Integer>` que devuelva el cuadrado.**  
   **Respuesta:** `Function<Integer, Integer> cuadrado = n -> n * n;`
3. **¿Qué interfaz de `java.util.function` usarías para “¿el número es positivo?”?**  
   **Respuesta:** `Predicate<Integer>`, ya que recibe un valor y devuelve un `boolean`.

### Sección 1.9
1. **¿Qué devuelve `compareTo` si el objeto actual debe ir después del otro?**  
   **Respuesta:** Un entero **positivo** (`> 0`).
2. **Tienes `Ave`, `Avion` y `Superheroe`. ¿Clase abstracta o interfaz para “volar”? ¿Por qué?**  
   **Respuesta:** Interfaz `Volador`. No son de la misma familia ("es un"), sino que comparten una capacidad ("puede volar").
3. **¿Qué ventaja da `sealed` al usar `switch`?**  
   **Respuesta:** Otorga **exhaustividad garantizada por el compilador**. Al conocer todas las clases permitidas, no se requiere un bloque `default` y el compilador alertará si falta cubrir algún subtipo.

### Sección 2.5
1. **¿Por qué es seguro comparar enums con `==` en lugar de `equals`?**  
   **Respuesta:** Porque la JVM asegura que cada constante de un enum existe como una única instancia en memoria (singleton).
2. **¿Qué imprime `DiaSemana.DOMINGO.ordinal()`?**  
   **Respuesta:** Imprime `6` (la numeración empieza en 0 desde `LUNES`).
3. **¿Qué pasa si en una expresión `switch` sobre `DiaSemana` olvidas el caso `JUEVES` y no hay `default`?**  
   **Respuesta:** Error de compilación: `the switch expression does not cover all possible input values`.

### Sección 2.12
1. **¿En qué orden deben ir las constantes y los atributos dentro de un enum?**  
   **Respuesta:** Primero las constantes (terminadas obligatoriamente en `;`), seguidas de los atributos, los constructores y finalmente los métodos.
2. **¿Puede un enum usar `extends`? ¿Y `implements`?**  
   **Respuesta:** `extends` **no** (todo enum ya hereda internamente de `java.lang.Enum`); `implements` **sí** (puede implementar tantas interfaces como desee).
3. **¿Por qué `EnumMap` imprime las claves en orden de la semana?**  
   **Respuesta:** Porque `EnumMap` está respaldado internamente por un arreglo indexado por el `ordinal()` de las constantes, no por orden de inserción ni por código hash.

---

## 6. Respuestas Justificadas a la Autoevaluación 3.4

| # | Pregunta | Respuesta Correcta | Justificación Técnica |
|---|---|---|---|
| **1** | ¿Qué modificadores tiene implícitamente un método abstracto de una interfaz? | **b) public abstract** | En una interfaz, todos los métodos declarados sin cuerpo reciben implícitamente `public abstract` (§1.3). |
| **2** | ¿Cuál línea compila si `Sonoro` es una interfaz y `Perro` la implementa? | **c) Sonoro s = new Perro();** | Una interfaz no puede instanciarse (`new Sonoro()` falla), pero puede utilizarse como tipo de referencia para una clase que la implemente (§1.2). |
| **3** | Una clase implementa dos interfaces con el mismo método default. ¿Qué ocurre? | **c) Error: la clase debe sobrescribirlo** | Ocurre el problema del diamante; Java exige que la clase receptora desambigüe explícitamente sobrescribiendo el método (§1.5). |
| **4** | ¿Cuál es una interfaz funcional válida para usar con lambda? | **b) Una con un método abstracto y tres default** | El requisito fundamental es tener **un único método abstracto** (SAM: Single Abstract Method). Los métodos default no cuentan (§1.6). |
| **5** | ¿Qué interfaz de `java.util.function` recibe un valor y no devuelve nada? | **c) Consumer** | `Consumer<T>` expone el método `void accept(T t)`, consumiendo el valor sin retornar resultado (§1.6). |
| **6** | ¿Qué imprime `DiaSemana.MIERCOLES.ordinal()` con el enum del capítulo? | **b) 2** | Los ordinales son base 0: LUNES (0), MARTES (1), MIERCOLES (2) (§2.3). |
| **7** | ¿Qué lanza `DiaSemana.valueOf("Lunes")`? | **c) IllegalArgumentException** | `valueOf()` realiza una comparación estricta con coincidencia exacta de caracteres. Al estar en minúsculas/capitalizada, lanza dicha excepción (§2.4). |
| **8** | ¿Cuál afirmación sobre el constructor de un enum es correcta? | **b) Es siempre privado** | Los constructores de los enums son forzosamente privados para evitar que el usuario instancie constantes adicionales (§2.6). |
| **9** | ¿Qué debes guardar en una base de datos para representar una constante de enum? | **c) name() o un código propio** | Nunca debe guardarse el `ordinal()`, pues si se inserta una nueva constante en el código, los números se desplazan y los datos se corrompen (§2.4). |
| **10**| Tienes Tarjeta, Nequi y Efectivo sin estado en común y quieres agregar más en el futuro. ¿Qué usas? | **b) Una interfaz MetodoPago** | Las interfaces permiten acoplamiento débil para tipos heterogéneos y permiten que el sistema sea extensible sin modificar código existente (§1.8 y §3.1). |

---

## 7. Cómo Ejecutar el Proyecto

### Desde IntelliJ IDEA:
1. Abre el proyecto en IntelliJ.
2. Navega a `src/Main.java`.
3. Haz clic derecho en el archivo y selecciona **Run 'Main.main()'**.
4. En la consola interactiva podrás escoger ejecutar los laboratorios, los retos, los ejemplos teóricos o la demostración completa.
5. De manera individual, también puedes hacer clic derecho y ejecutar cualquiera de los archivos con método `main()`:
   - `laboratorios.lab1_playlist.MainPlaylist`
   - `laboratorios.lab2_pagos.MainPasarela`
   - `laboratorios.lab3_semaforo.MainSemaforo`
   - `laboratorios.lab4_cafeteria.MainCafeteria`
   - `retos.reto1_figuras.MainFiguras`
   - `retos.reto2_baraja.MainBaraja`
   - `retos.reto3_calculadora.MainCalculadora`
   - `retos.reto4_promociones.MainPromocionesCombinables`
   - `retos.reto5_permisos.MainPermisos`

### Desde la Consola de Comandos (PowerShell / Terminal):
Compilación:
```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Path src -Filter *.java -Recurse).FullName
```

Ejecutar todo el sistema automáticamente:
```powershell
java -cp out Main all
```
