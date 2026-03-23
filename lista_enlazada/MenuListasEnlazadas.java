package lista_enlazada;

import java.util.Scanner;

public class MenuListasEnlazadas {

    private ListaEnlazadaSimple lista;
    private Scanner scanner;

    public MenuListasEnlazadas() {
        lista = new ListaEnlazadaSimple();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("           MENÚ            ");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Eliminar por valor");
            System.out.println("5. Eliminar en posición");
            System.out.println("6. Buscar valor");
            System.out.println("7. Obtener valor en posición");
            System.out.println("8. Mostrar lista");
            System.out.println("9. Tamaño de la lista");
            System.out.println("10. Limpiar lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    int valInicio = scanner.nextInt();
                    lista.insertarAlInicio(valInicio);
                    break;

                case 2:
                    System.out.print("Ingrese valor: ");
                    int valFinal = scanner.nextInt();
                    lista.insertarAlFinal(valFinal);
                    break;

                case 3:
                    System.out.print("Ingrese valor: ");
                    int valPos = scanner.nextInt();
                    System.out.print("Ingrese posición: ");
                    int posInsertar = scanner.nextInt();
                    try {
                        lista.insertarEnPosicion(valPos, posInsertar);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese valor a eliminar: ");
                    int valEliminar = scanner.nextInt();
                    lista.eliminarPorValor(valEliminar);
                    break;

                case 5:
                    System.out.print("Ingrese posición a eliminar: ");
                    int posEliminar = scanner.nextInt();
                    try {
                        lista.eliminarEnPosicion(posEliminar);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Ingrese valor a buscar: ");
                    int valBuscar = scanner.nextInt();
                    int pos = lista.buscar(valBuscar);
                    if (pos != -1) {
                        System.out.println("Valor encontrado en posición: " + pos);
                    } else {
                        System.out.println("Valor no encontrado");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese posición: ");
                    int posObtener = scanner.nextInt();
                    try {
                        int valor = lista.obtenerEnPosicion(posObtener);
                        System.out.println("Valor en posición " + posObtener + ": " + valor);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 8:
                    lista.imprimir();
                    break;

                case 9:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;

                case 10:
                    lista.limpiar();
                    System.out.println("Lista limpiada.");
                    break;

                case 0:
                    System.out.println("Saliendo del menú...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}