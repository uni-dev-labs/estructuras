package lista_enlazada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleLinkedList list = new SimpleLinkedList();
        int option;

        do {
            System.out.println("\n===== MENÚ CRUD LISTA ENLAZADA =====");
            System.out.println("1. Crear nodo");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Buscar nodo por posición");
            System.out.println("4. Actualizar nodo");
            System.out.println("5. Eliminar nodo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el valor del nuevo nodo: ");
                    int value = sc.nextInt();
                    list.addNode(value);
                    System.out.println("Nodo creado correctamente.");
                    break;

                case 2:
                    list.showList();
                    break;

                case 3:
                    System.out.print("Ingrese la posición a buscar: ");
                    int searchPosition = sc.nextInt();
                    list.searchNode(searchPosition);
                    break;

                case 4:
                    System.out.print("Ingrese la posición del nodo a actualizar: ");
                    int updatePosition = sc.nextInt();
                    System.out.print("Ingrese el nuevo valor: ");
                    int newValue = sc.nextInt();

                    if (list.updateNode(updatePosition, newValue)) {
                        System.out.println("Nodo actualizado correctamente.");
                    } else {
                        System.out.println("No se pudo actualizar. Posición inválida.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la posición del nodo a eliminar: ");
                    int deletePosition = sc.nextInt();

                    if (list.deleteNode(deletePosition)) {
                        System.out.println("Nodo eliminado correctamente.");
                    } else {
                        System.out.println("No se pudo eliminar. Posición inválida o lista vacía.");
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 0);

        sc.close();
    }
}