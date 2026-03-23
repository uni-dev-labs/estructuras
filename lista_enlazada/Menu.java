package lista_enlazada;

import java.util.Scanner;

public class Menu {
    private ListaEnlazadaSimple lista;
    private Scanner sc;

    public Menu() {
        lista = new ListaEnlazadaSimple();
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n MENÚ LISTA ENLAZADA ");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Eliminar por valor");
            System.out.println("5. Eliminar en posición");
            System.out.println("6. Buscar valor");
            System.out.println("7. Mostrar lista");
            System.out.println("8. Mostrar tamaño");
            System.out.println("9. Limpiar lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    lista.insertarAlInicio(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Ingrese valor: ");
                    lista.insertarAlFinal(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Ingrese valor: ");
                    int valor = sc.nextInt();
                    System.out.print("Ingrese posición: ");
                    int pos = sc.nextInt();
                    try {
                        lista.insertarEnPosicion(valor, pos);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese valor a eliminar: ");
                    lista.eliminarPorValor(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Ingrese posición a eliminar: ");
                    try {
                        lista.eliminarEnPosicion(sc.nextInt());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Ingrese valor a buscar: ");
                    int buscado = sc.nextInt();
                    int indice = lista.buscar(buscado);
                    if (indice != -1) {
                        System.out.println("Valor encontrado en posición: " + indice);
                    } else {
                        System.out.println("Valor no encontrado.");
                    }
                    break;
                case 7:
                    lista.imprimir();
                    break;
                case 8:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                case 9:
                    lista.limpiar();
                    System.out.println("Lista vaciada.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}
