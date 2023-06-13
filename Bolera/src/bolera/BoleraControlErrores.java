package bolera;

import java.util.Scanner;

public class BoleraControlErrores {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int edad;
        double precio = 9;
        int ticketVendidos = 0;
        double caja = 0;

        while (!salir) {
            System.out.print("Bolera Los Maquinas\n-------------------\n");
            System.out.println("1. Vender Ticket\n2. Resumen de ventas\n3. Salir\n");

            if (scanner.hasNextInt()) { //Control de error
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Generando ticket...\nEdad: ");
                        if (scanner.hasNextInt()) { //Control de error
                            edad = scanner.nextInt();

                            if (edad <= 5 || edad > 70) {
                                precio = 1;
                            } else if ((edad > 5 && edad <= 14) || (edad >= 50 && edad <= 70)) {
                                precio *= 0.75;
                            }

                            System.out.println("-----------------------\nTICKET DE ENTRADA\nEdad: " + edad
                                    + "\nTotal a pagar: " + precio + "€");
                            ticketVendidos++;
                            caja += precio;
                        } else {
                            System.out.println("Edad inválida. Introduce un número entero válido.");
                            scanner.next(); // Limpiar el buffer del scanner
                        }
                        break;
                    case 2:
                        System.out.println("\nRESUMEN DE VENTAS\n-----------------------");
                        System.out.println(ticketVendidos + " Tickets vendidos.");
                        System.out.println(caja + "€ recaudados en caja\n\n");
                        break;
                    case 3:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Introduce un número válido.");
                        break;
                }
            } else {
                System.out.println("Opción inválida. Introduce un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        scanner.close(); // Cerrar el Scanner al finalizar
    }
}

