package com.cinema.booking;

import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    private String title;
    private String time;
    private boolean[][] seats;

    public Movie(String title, String time) {
        this.title = title;
        this.time = time;
        this.seats = new boolean[5][5]; 
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public void showSeats() {
        System.out.println("Distribución de asientos (O = disponible, X = reservado):");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int col) {
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length && !seats[row][col]) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }
}

public class CinemaBookingSystem {

    private static ArrayList<Movie> movies = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        movies.add(new Movie("Dettlejuice", "14:00"));
        movies.add(new Movie("Depredador", "16:00"));
        movies.add(new Movie("coco", "18:00"));

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    showAvailableMovies();
                    break;
                case 2:
                    selectSeats();
                    break;
                case 3:
                    simulatePayment();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema de reserva de cine.");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option != 4);
    }

    private static void showMenu() {
        System.out.println("\n--- Sistema de Reserva de Cine ---");
        System.out.println("1. Ver películas disponibles");
        System.out.println("2. Reservar asientos");
        System.out.println("3. Realizar pago (Simulación)");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void showAvailableMovies() {
        System.out.println("\nPelículas disponibles:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle() + " - Hora: " + movie.getTime());
        }
    }

    private static void selectSeats() {
        System.out.println("\nSeleccione una película para reservar asientos:");
        showAvailableMovies();
        int movieIndex = scanner.nextInt() - 1;

        if (movieIndex >= 0 && movieIndex < movies.size()) {
            Movie selectedMovie = movies.get(movieIndex);
            System.out.println("Película seleccionada: " + selectedMovie.getTitle() + " a las " + selectedMovie.getTime());
            selectedMovie.showSeats();

            System.out.print("Ingrese el número de fila (1-5): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Ingrese el número de columna (1-5): ");
            int col = scanner.nextInt() - 1;

            if (selectedMovie.reserveSeat(row, col)) {
                System.out.println("¡Asiento reservado con éxito!");
            } else {
                System.out.println("El asiento ya está reservado o es inválido.");
            }
        } else {
            System.out.println("Selección de película inválida.");
        }
    }

    private static void simulatePayment() {
        System.out.println("\nSimulando pago...");
        System.out.print("Ingrese el número de tarjeta (simulado): ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pago realizado con éxito usando la tarjeta: " + cardNumber);
        System.out.println("¡Gracias por su compra!");
    }
}
