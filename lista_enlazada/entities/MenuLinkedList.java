package lista_enlazada.entities;

import java.util.Scanner;

public class MenuLinkedList {

    public static void main(String[] args) throws Exception {
        MenuLinkedList.menu();
    }
    private static Scanner scanner = new Scanner(System.in);

    private static void menu() throws Exception {

        int i;
        LinkedListTransaction linkedList = new LinkedListTransaction();
        do {
            System.out.println("|-----------------------|");
            System.out.println("|          Menu         |");
            System.out.println("|-----------------------|");
            System.out.println("|1. Agregar dato        |");
            System.out.println("|2. Eliminar dato       |");
            System.out.println("|3. Buscar dato         |");
            System.out.println("|4. Mostrar datos       |");
            System.out.println("|0. Salir               |");
            System.out.println("|-----------------------|");

            i = Integer.parseInt(scanner.nextLine());
            switch (i) {
                case 1 ->
                    add(linkedList);
                case 2 ->
                    remove(linkedList);
                case 3 -> {
                    System.out.println("Ingresa el indice a buscar");
                    int index = Integer.parseInt(scanner.nextLine());
                    NodeTransaction node = linkedList.searchPerIndex(index);
                    Transaction transaction = node.getValue();
                    System.out.println(transaction);
                }

                case 4 -> {
                    NodeTransaction head = linkedList.getHead();
                    if (head != null) {
                        System.out.println(head);
                    } else {
                        System.out.println("No hay datos disponibles");
                    }
                }

                default -> {
                }
            }
        } while (i != 0);
    }

    private static void add(LinkedListTransaction linkedList) throws Exception {
        int i;

        System.out.println("|-----------------------|");
        System.out.println("|        Agregar        |");
        System.out.println("|-----------------------|");
        System.out.println("| 1. Agregar al inicio  |");
        System.out.println("| 2. Agregar al final   |");
        System.out.println("| 3. Agregar por índice |");
        System.out.println("|-----------------------|");
        i = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingresa el monto de la transacción: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingresa tu número de cuenta: ");
        String accountNumber = scanner.nextLine();
        Transaction transaction = new Transaction(amount, accountNumber);
        switch (i) {
            case 1 ->
                linkedList.addFirstTransaction(transaction);
            case 2 ->
                linkedList.addLastTrans(transaction);
            case 3 -> {
                System.out.println("Ingresa el índice: ");
                int index = Integer.parseInt(scanner.nextLine());
                linkedList.addForIndexTransaction(transaction, index);
            }

            default -> {
            }
        }
    }

    public static void remove(LinkedListTransaction linkedList) throws Exception {
        int i;

        System.out.println("|------------------------|");
        System.out.println("|        Eliminar        |");
        System.out.println("|------------------------|");
        System.out.println("| 1. Eliminar al inicio  |");
        System.out.println("| 2. Eliminar al final   |");
        System.out.println("| 3. Eliminar por índice |");
        System.out.println("|------------------------|");
        i = Integer.parseInt(scanner.nextLine());
        switch (i) {
            case 1 ->
                linkedList.removeFirstTransaction();
            case 2 ->
                linkedList.removeLastTransaction();
            case 3 -> {
                System.out.println("Ingresa el índice: ");
                int index = Integer.parseInt(scanner.nextLine());
                linkedList.removeForIndexTransaction(index);
            }

            default ->
                System.out.println("Error al ingresar el índice");
        }
    }
}
