package Exposiciones.CadenaBinario;

import java.util.Scanner;

public class AFParesCeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una cadena binaria: ");
        String cadena = scanner.nextLine();

        int estado = 0; // 0 = par, 1 = impar

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '0') {
                estado = (estado == 0) ? 1 : 0;
            } else if (c == '1') {
                // no cambia estado
            } else {
                System.out.println("Cadena inválida (solo se permiten 0 y 1)");
                return;
            }
        }

        if (estado == 0) {
            System.out.println("Cadena válida: tiene un número par de 0");
        } else {
            System.out.println("Estado inválido: número impar de 0");
        }
    }
}