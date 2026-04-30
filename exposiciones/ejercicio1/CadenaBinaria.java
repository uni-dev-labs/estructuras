package exposiciones.ejercicio1;

import java.util.Scanner;

public class CadenaBinaria {
   
    public static boolean tieneCerosPares(String cadena) {
        int contadorCeros = 0;
        
        for (char c : cadena.toCharArray()) {
            if (c == '0') {
                contadorCeros++;
            } else if (c != '1') {
                
                return false;
            }
            
        }
        return contadorCeros % 2 == 0;
    }

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una cadena binaria: ");
        String cadena = sc.nextLine();

        if (tieneCerosPares(cadena)) {
            System.out.println("La cadena es válida (tiene número par de ceros).");
        } else {
            System.out.println("Estado inválido (no tiene número par de ceros).");
        }

        sc.close();
    }
}
