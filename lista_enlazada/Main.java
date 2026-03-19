package lista_enlazada;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Agregar transacción al final");
            System.out.println("2. Agregar transacción al inicio");
            System.out.println("3. Buscar transacción por ID");
            System.out.println("4. Eliminar transacción por ID");
            System.out.println("5. Ver historial completo");
            System.out.println("6. Borrar todo el historial");
            System.out.println("7. Actualizar transacción por ID");
            System.out.println("0. Salir del programa");
            System.out.print("Opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.println("\n--- Agregar al final ---");
                    lista.insertarAlFinal(crearTransaccion(leer));
                    System.out.println("Transacción agregada al final.");
                    break;

                case 2:
                    System.out.println("\n--- Agregar al inicio ---");
                    lista.insertarAlInicio(crearTransaccion(leer));
                    System.out.println("Transacción agregada al inicio.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = leer.nextInt();
                    leer.nextLine();

                    int pos = lista.buscarPorId(idBuscar);
                    Transaccion t = lista.obtenerPorId(idBuscar);

                    if (pos != -1) {
                        System.out.println("Transacción encontrada en posición: " + pos);
                        System.out.println(t);
                    } else {
                        System.out.println("No se encontró la transacción.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID a eliminar: ");
                    int idEliminar = leer.nextInt();
                    leer.nextLine();

                    lista.eliminarPorId(idEliminar);
                    System.out.println("Proceso de eliminación realizado.");
                    break;

                case 5:
                    lista.imprimir();
                    break;

                case 6:
                    lista.limpiar();
                    System.out.println("Historial eliminado completamente.");
                    break;

                case 7:
                    System.out.print("Ingrese el ID de la transacción a actualizar: ");
                    int idActualizar = leer.nextInt();
                    leer.nextLine();

                    System.out.println("Ingrese los nuevos datos:");
                    boolean actualizado = lista.actualizarPorId(idActualizar, crearTransaccion(leer));

                    if (actualizado) {
                        System.out.println("Transacción actualizada correctamente.");
                    } else {
                        System.out.println("No se encontró la transacción.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        System.out.println("Programa terminado.");
        leer.close();
    }

    public static Transaccion crearTransaccion(Scanner sc) {
        System.out.print("Monto: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        System.out.print("Fecha (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        return new Transaccion(monto, desc, fecha);
    }
}