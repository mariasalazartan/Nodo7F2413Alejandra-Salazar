package com.miempresa.habitos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SeguimientoHabitos {
    private static HashMap<String, ArrayList<Boolean>> habitos = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar un nuevo hábito");
            System.out.println("2. Registrar progreso diario");
            System.out.println("3. Mostrar resumen diario");
            System.out.println("4. Mostrar resumen semanal");
            System.out.println("5. Salir");
            
            opcion = obtenerEntradaEntero(scanner);

            switch (opcion) {
                case 1:
                    ingresarNuevoHabito(scanner);
                    break;
                case 2:
                    registrarProgresoDiario(scanner);
                    break;
                case 3:
                    mostrarResumenDiario();
                    break;
                case 4:
                    mostrarResumenSemanal();
                    break;
                case 5:
                    System.out.println("Gracias por usar el seguimiento de hábitos.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static int obtenerEntradaEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    private static boolean obtenerEntradaBoolean(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese 'true' o 'false'.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    private static void ingresarNuevoHabito(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo hábito: ");
        String habito = scanner.nextLine();
        habitos.put(habito, new ArrayList<>());
        System.out.println("Hábito ingresado: " + habito);
    }

    private static void registrarProgresoDiario(Scanner scanner) {
        if (habitos.isEmpty()) {
            System.out.println("No hay hábitos registrados.");
            return;
        }

        System.out.println("Seleccione el hábito para registrar el progreso:");
        for (int i = 0; i < habitos.size(); i++) {
            System.out.println((i + 1) + ". " + (String) habitos.keySet().toArray()[i]);
        }
        
        int opcionHabito = obtenerEntradaEntero(scanner);
        if (opcionHabito < 1 || opcionHabito > habitos.size()) {
            System.out.println("Opción de hábito inválida.");
            return;
        }

        String habitoSeleccionado = (String) habitos.keySet().toArray()[opcionHabito - 1];
        System.out.print("¿Cumplió con el hábito '" + habitoSeleccionado + "' hoy? (true/false): ");
        boolean progreso = obtenerEntradaBoolean(scanner);
        habitos.get(habitoSeleccionado).add(progreso);
        System.out.println("Progreso registrado para el hábito: " + habitoSeleccionado);
    }

    private static void mostrarResumenDiario() {
        System.out.println("Resumen diario:");
        for (String habito : habitos.keySet()) {
            ArrayList<Boolean> progreso = habitos.get(habito);
            if (!progreso.isEmpty()) {
                System.out.println(habito + ": " + (progreso.get(progreso.size() - 1) ? "Cumplido" : "No cumplido"));
            } else {
                System.out.println(habito + ": No hay registros");
            }
        }
    }

    private static void mostrarResumenSemanal() {
        System.out.println("Resumen semanal:");
        for (String habito : habitos.keySet()) {
            ArrayList<Boolean> progreso = habitos.get(habito);
            int cumplidos = 0;
            int diasContados = Math.min(7, progreso.size());
            for (int i = progreso.size() - diasContados; i < progreso.size(); i++) {
                if (progreso.get(i)) {
                    cumplidos++;
                }
            }
            System.out.println(habito + ": " + cumplidos + " de " + diasContados + " días cumplidos");
        }
    }
}
