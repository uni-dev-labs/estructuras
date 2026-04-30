package arrays;

import java.util.Scanner;

public class Ciclos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Señor usuario ingrese un numero: ");
        
        int numero = scanner.nextInt();

        for (int inicio = 1; inicio <= numero; inicio++) {
            System.out.println("el numero es: " + inicio);
        }

        scanner.close();



    }
}
