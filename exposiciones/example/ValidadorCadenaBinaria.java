package exposiciones.example;

import java.util.Scanner;

public class ValidadorCadenaBinaria {

    public static boolean esValida(String cadena) {
        int contador = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            // Validar que solo tenga 0 o 1
            if (c != '0' && c != '1') {
                return false;
            }

            if (c == '1') {
                contador++;
            }
        }

        // Retorna true si el número de unos es par
        return contador % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena binaria: ");
        String cadena = scanner.nextLine();

        if (esValida(cadena)) {
            System.out.println("Estado válido (número par de unos)");
        } else {
            System.out.println("Estado inválido");
        }

        scanner.close();
    }
}