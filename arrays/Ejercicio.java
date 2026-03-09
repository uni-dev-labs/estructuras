package arrays;

import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner scanner     = new Scanner(System.in);
        String [][] names   = new String[2][2];

        fillMatrix(names, scanner);
        printMatrix(names);
    }


    public static void fillMatrix(String [][]names, Scanner scanner) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                System.out.println("Ingrese el nombre para la posición [" + i + "][" + j + "]: ");
                names[i][j] = scanner.nextLine();
            }
        }
    }

    public static void printMatrix(String [][]names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                System.out.println("Nombre en la posición [" + i + "][" + j + "]: " + names[i][j]);
            }
        }
    }
}