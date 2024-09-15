package com.miempresa.agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reunion {
    private String titulo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private List<String> participantes;

    public Reunion(String titulo, LocalDateTime inicio, LocalDateTime fin) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.participantes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public void agregarParticipante(String participante) {
        participantes.add(participante);
    }

    public void eliminarParticipante(String participante) {
        participantes.remove(participante);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Reunión: " + titulo + "\nInicio: " + inicio.format(formatter) + "\nFin: " + fin.format(formatter) + "\nParticipantes: " + participantes + "\n";
    }
}

public class AgendaReuniones {
    private static List<Reunion> reuniones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    crearReunion();
                    break;
                case 2:
                    editarReunion();
                    break;
                case 3:
                    eliminarReunion();
                    break;
                case 4:
                    agregarParticipante();
                    break;
                case 5:
                    mostrarReuniones();
                    break;
                case 6:
                    System.out.println("Saliendo del simulador de reuniones...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Simulador de Agenda de Reuniones ---");
        System.out.println("1. Crear reunión");
        System.out.println("2. Editar reunión");
        System.out.println("3. Eliminar reunión");
        System.out.println("4. Agregar participante a una reunión");
        System.out.println("5. Mostrar todas las reuniones");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearReunion() {
        System.out.print("Ingrese el título de la reunión: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese la fecha y hora de inicio (yyyy-MM-dd HH:mm): ");
        String inicioStr = scanner.nextLine();
        LocalDateTime inicio = LocalDateTime.parse(inicioStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Ingrese la fecha y hora de fin (yyyy-MM-dd HH:mm): ");
        String finStr = scanner.nextLine();
        LocalDateTime fin = LocalDateTime.parse(finStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        if (haySolapamiento(inicio, fin)) {
            System.out.println("Error: La reunión se solapa con otra existente.");
        } else {
            Reunion nuevaReunion = new Reunion(titulo, inicio, fin);
            reuniones.add(nuevaReunion);
            System.out.println("Reunión creada con éxito.");
        }
    }

    private static void editarReunion() {
        System.out.print("Ingrese el título de la reunión a editar: ");
        String titulo = scanner.nextLine();
        Reunion reunion = buscarReunion(titulo);
        if (reunion != null) {
            System.out.print("Nuevo título: ");
            String nuevoTitulo = scanner.nextLine();
            reunion.setTitulo(nuevoTitulo);
            System.out.println("Reunión editada con éxito.");
        } else {
            System.out.println("Reunión no encontrada.");
        }
    }

    private static void eliminarReunion() {
        System.out.print("Ingrese el título de la reunión a eliminar: ");
        String titulo = scanner.nextLine();
        Reunion reunion = buscarReunion(titulo);
        if (reunion != null) {
            reuniones.remove(reunion);
            System.out.println("Reunión eliminada con éxito.");
        } else {
            System.out.println("Reunión no encontrada.");
        }
    }

    private static void agregarParticipante() {
        System.out.print("Ingrese el título de la reunión: ");
        String titulo = scanner.nextLine();
        Reunion reunion = buscarReunion(titulo);
        if (reunion != null) {
            System.out.print("Ingrese el nombre del participante: ");
            String participante = scanner.nextLine();
            reunion.agregarParticipante(participante);
            System.out.println("Participante agregado con éxito.");
        } else {
            System.out.println("Reunión no encontrada.");
        }
    }

    private static void mostrarReuniones() {
        if (reuniones.isEmpty()) {
            System.out.println("No hay reuniones programadas.");
        } else {
            for (Reunion reunion : reuniones) {
                System.out.println(reunion);
            }
        }
    }

    private static Reunion buscarReunion(String titulo) {
        for (Reunion reunion : reuniones) {
            if (reunion.getTitulo().equalsIgnoreCase(titulo)) {
                return reunion;
            }
        }
        return null;
    }

    private static boolean haySolapamiento(LocalDateTime inicio, LocalDateTime fin) {
        for (Reunion reunion : reuniones) {
            if (inicio.isBefore(reunion.getFin()) && fin.isAfter(reunion.getInicio())) {
                return true;
            }
        }
        return false;
    }
}
