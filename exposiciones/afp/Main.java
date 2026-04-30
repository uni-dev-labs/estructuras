package exposiciones.afp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una cadena binaria: ");
        String cadena = sc.nextLine();

        int ceros = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '0') {
                ceros++;
            } else if (c != '1') {
                System.out.println("Cadena inválida");
                return;
            }
        }

        if (ceros % 2 == 0) {
            System.out.println("Estado válido (ceros pares)");
        } else {
            System.out.println("Estado inválido (ceros impares)");
        }

        sc.close();
    }
}