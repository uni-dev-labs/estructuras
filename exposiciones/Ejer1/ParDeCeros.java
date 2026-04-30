package exposiciones.Ejer1;

import java.util.Scanner;

public class ParDeCeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una cadena binaria: ");
        String cadena = sc.nextLine();

        // Estado inicial (q0 = par)
        boolean estadoPar = true;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '0') {
                // Cambia de estado
                estadoPar = !estadoPar;
            } else if (c == '1') {
                // No cambia
            } else {
                System.out.println("Cadena inválida (solo 0 y 1)");
                return;
            }
        }

        if (estadoPar) {
            System.out.println("Cadena válida (número PAR de ceros)");
        } else {
            System.out.println("Cadena inválida (número IMPAR de ceros)");
        }

        sc.close();
    }
}
