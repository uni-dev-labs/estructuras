package arraylist.models;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void runMenu() {
        int typedOption = 0;

        do {
            typedOption = Integer.parseInt(scanner.nextLine());
            System.out.println("Agregar Transporte");
            System.out.println("Buscar Transporte");
            System.out.println("Eliminar Transporte");
            System.out.println("Actualizar Transporte");
        } while (typedOption != 0);
    }

    public static void runSecondMenu() {
        int option = 0;

        do {

        } while (option != 0);
    }

}
