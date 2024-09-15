package com.miempresa.inventario;

import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;
    int cantidad;
    String categoria;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Categoría: " + categoria;
    }
}

public class InventarioTienda {
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Realizar venta");
            System.out.println("3. Consultar productos por categoría");
            System.out.println("4. Consultar productos por precio");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    realizarVenta(scanner);
                    break;
                case 3:
                    consultarPorCategoria(scanner);
                    break;
                case 4:
                    consultarPorPrecio(scanner);
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad disponible: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();

        Producto producto = new Producto(nombre, precio, cantidad, categoria);
        inventario.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    private static void realizarVenta(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto vendido: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();

        for (Producto producto : inventario) {
            if (producto.nombre.equals(nombre)) {
                if (producto.cantidad >= cantidadVendida) {
                    producto.cantidad -= cantidadVendida;
                    System.out.println("Venta realizada. Cantidad restante de " + nombre + ": " + producto.cantidad);
                } else {
                    System.out.println("Cantidad insuficiente en inventario.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private static void consultarPorCategoria(Scanner scanner) {
        System.out.print("Ingrese la categoría a consultar: ");
        String categoria = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.categoria.equals(categoria)) {
                System.out.println(producto);
            }
        }
    }

    private static void consultarPorPrecio(Scanner scanner) {
        System.out.print("Ingrese el precio máximo a consultar: ");
        double precioMaximo = scanner.nextDouble();

        for (Producto producto : inventario) {
            if (producto.precio <= precioMaximo) {
                System.out.println(producto);
            }
        }
    }
}
