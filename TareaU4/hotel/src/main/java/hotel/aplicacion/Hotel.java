/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author David
 */
package hotel.aplicacion;

import hotel.modelo.Cliente;
import hotel.modelo.Reserva;
import hotel.modelo.TipoHabitacion;
import hotel.utilidades.Utilidades;
import java.time.LocalDate;
import java.util.Scanner;

 /** Claramente es la clase principal para crear clientes y reservas en el hotel */

public class Hotel {
	
 /** Crea menú interactivo para gestionar los clientes y reservas */
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = null, cliente2 = null, cliente3 = null;
        Reserva reserva1 = null, reserva2 = null, reserva3 = null;
        int opcion = 0;

        do {
            System.out.println("\n--- Gestión de Reservas en un Hotel ---");
            System.out.println("1. Crear clientes");
            System.out.println("2. Crear reserva");
            System.out.println("3. Mostrar datos de reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    try {
                        cliente1 = altaCliente(sc);
                        System.out.println("Cliente creado correctamente:\n" + cliente1.mostrarInformacion());

                        // Creación de dos clientes adicionales con datos literales.
                        cliente2 = new Cliente("Ana García", "12345678Z", "600111222");
                        cliente3 = new Cliente("Luis Martínez", "87654321X", "600333444");

                        System.out.println("Cliente creado correctamente:\n" + cliente2.mostrarInformacion());
                        System.out.println("Cliente creado correctamente:\n" + cliente3.mostrarInformacion());
                    } catch (Exception e) {
                        System.out.println("Error al crear cliente: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (cliente1 == null || cliente2 == null || cliente3 == null) {
                        System.out.println("Primero debe crear los clientes (opción 1).");
                        break;
                    }
                    // Lógica de creación de reservas (sin cambios)
                    break;

                case 3:
                    // Lógica para mostrar reservas (sin cambios)
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }
    
    /** solicita al cliente los datos para crear el nuevo cliente */

    private static Cliente altaCliente(Scanner sc) throws Exception {
        String nombre;
        do {
            System.out.println("\nIntroduzca los datos del cliente:");
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
        } while (nombre.isEmpty());

        String dni = null;
        boolean dniValido;
        do {
            try {
                System.out.print("Introduzca DNI: ");
                dni = sc.nextLine();
                Utilidades.validarDNI(dni);
                dniValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                dniValido = false;
            }
        } while (!dniValido);

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        return new Cliente(nombre, dni, telefono);
    }
}
