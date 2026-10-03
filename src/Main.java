import java.util.Scanner;
import laboratorios.lab1_playlist.MainPlaylist;
import laboratorios.lab2_pagos.MainPasarela;
import laboratorios.lab3_semaforo.MainSemaforo;
import laboratorios.lab4_cafeteria.MainCafeteria;
import retos.reto1_figuras.MainFiguras;
import retos.reto2_baraja.MainBaraja;
import retos.reto3_calculadora.MainCalculadora;
import retos.reto4_promociones.MainPromocionesCombinables;
import retos.reto5_permisos.MainPermisos;
import teoria.PuntosDeControlYAutoevaluacion;
import teoria.seccion1_interfaces.*;
import teoria.seccion2_enums.*;

/**
 * Clase principal que conecta y centraliza todas las soluciones del documento
 * "Interfaces y Enums en Java":
 * - 4 Laboratorios guiados.
 * - 5 Retos para ir más allá.
 * - Todos los micro-ejemplos de las Secciones 1 y 2.
 * - Puntos de control y Autoevaluación 3.4.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("all")) {
            ejecutarTodo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================================");
            System.out.println("   INTERFACES Y ENUMS EN JAVA - SOLUCIÓN COMPLETA DEL DOCUMENTO       ");
            System.out.println("======================================================================");
            System.out.println(" 1. Ejecutar los 4 Laboratorios Guiados");
            System.out.println(" 2. Ejecutar los 5 Retos para ir más allá");
            System.out.println(" 3. Ejecutar Ejemplos Teóricos (Secciones 1 y 2)");
            System.out.println(" 4. Ver Puntos de Control y Autoevaluación 3.4");
            System.out.println(" 5. Ejecutar TODO el proyecto de principio a fin");
            System.out.println(" 6. Salir");
            System.out.print("Seleccione una opción [1-6]: ");

            if (!scanner.hasNextLine()) {
                // Modo no interactivo: ejecutar todo por defecto
                System.out.println("\n[Modo batch detectado: Ejecutando todo el contenido]");
                ejecutarTodo();
                break;
            }

            String opcion = scanner.nextLine().trim();
            System.out.println();

            switch (opcion) {
                case "1" -> ejecutarLaboratorios();
                case "2" -> ejecutarRetos();
                case "3" -> ejecutarTeoria();
                case "4" -> mostrarCuestionarios();
                case "5" -> ejecutarTodo();
                case "6" -> {
                    System.out.println("¡Hasta pronto!");
                    return;
                }
                default -> System.out.println("Opción no válida. Ingrese un número del 1 al 6.\n");
            }
        }
    }

    public static void ejecutarLaboratorios() {
        System.out.println("**********************************************************************");
        System.out.println("                      BLOQUE DE LABORATORIOS                          ");
        System.out.println("**********************************************************************\n");
        MainPlaylist.ejecutar();
        MainPasarela.ejecutar();
        MainSemaforo.ejecutar();
        MainCafeteria.ejecutar();
    }

    public static void ejecutarRetos() {
        System.out.println("**********************************************************************");
        System.out.println("                  BLOQUE DE RETOS PARA IR MÁS ALLÁ                    ");
        System.out.println("**********************************************************************\n");
        MainFiguras.ejecutar();
        MainBaraja.ejecutar();
        MainCalculadora.ejecutar();
        MainPromocionesCombinables.ejecutar();
        MainPermisos.ejecutar();
    }

    public static void ejecutarTeoria() {
        System.out.println("**********************************************************************");
        System.out.println("                 EJEMPLOS TEÓRICOS: SECCIONES 1 Y 2                   ");
        System.out.println("**********************************************************************\n");
        Ejemplo1_GranjaSonoro.ejecutar();
        Ejemplo2_ReglasJuegoConstantes.ejecutar();
        Ejemplo3_ImplementacionMultipleHerencia.ejecutar();
        Ejemplo4_MetodosDefaultStaticPrivate.ejecutar();
        Ejemplo5_FuncionalesLambdas.ejecutar();
        Ejemplo6_ComparableComparator.ejecutar();
        Ejemplo7_AbstractaVsInterfaz.ejecutar();
        Ejemplo8_InterfacesSelladasRecords.ejecutar();

        Ejemplo9_DiaSemanaIntro.ejecutar();
        Ejemplo10_EnumSwitchModerno.ejecutar();
        Ejemplo11_MonedaAtributosMetodos.ejecutar();
        Ejemplo12_OperadorAbstracto.ejecutar();
        Ejemplo13_EnumImplementaInterfaz.ejecutar();
        Ejemplo14_MaquinaEstadosPedido.ejecutar();
        Ejemplo15_EnumSetEnumMap.ejecutar();
        Ejemplo16_EnumSingleton.ejecutar();
    }

    public static void mostrarCuestionarios() {
        PuntosDeControlYAutoevaluacion.mostrarPuntosDeControl();
        PuntosDeControlYAutoevaluacion.mostrarAutoevaluacion();
    }

    public static void ejecutarTodo() {
        ejecutarLaboratorios();
        ejecutarRetos();
        ejecutarTeoria();
        mostrarCuestionarios();
    }
}
