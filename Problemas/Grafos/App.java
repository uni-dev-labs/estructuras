package Problemas.Grafos;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una cadena binaria: ");
        String cadena = sc.nextLine();

        if (Condicion.esValido(cadena)) {
            System.out.println("La cadena es válida.");
        } else {
            System.out.println("La cadena no es válida.");
        }

        sc.close();
    }
}