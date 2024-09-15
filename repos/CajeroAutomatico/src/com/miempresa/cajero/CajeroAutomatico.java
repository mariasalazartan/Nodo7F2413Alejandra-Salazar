package com.miempresa.cajero;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroCuenta = 12345;
        int pin = 54321;
        double saldo = 1000.0;
        int cuentaIngresada, pinIngresado, opcion;
        double cantidad;

        System.out.println("Bienvenido al cajero automático");
        System.out.print("Ingrese su número de cuenta: ");
        cuentaIngresada = scanner.nextInt();
        System.out.print("Ingrese su PIN: ");
        pinIngresado = scanner.nextInt();

        if (cuentaIngresada == numeroCuenta && pinIngresado == pin) {
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Salir");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Su saldo es: " + saldo);
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad a retirar: ");
                        cantidad = scanner.nextDouble();
                        if (cantidad <= saldo) {
                            saldo -= cantidad;
                            System.out.println("Ha retirado: " + cantidad);
                        } else {
                            System.out.println("Fondos insuficientes");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad a depositar: ");
                        cantidad = scanner.nextDouble();
                        saldo += cantidad;
                        System.out.println("Ha depositado: " + cantidad);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero automático");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } while (opcion != 4);
        } else {
            System.out.println("Número de cuenta o PIN incorrecto");
        }

        scanner.close();
    }
}
