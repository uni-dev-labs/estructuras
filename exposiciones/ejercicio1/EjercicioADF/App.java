package exposiciones.ejercicio1.EjercicioADF;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("======AUTOMATA PAR DE CEROS======");
        System.out.println("Ingrese cadena binaria: ");
        String cadena= sc.nextLine();
        AutomataParCeros automata = new AutomataParCeros();

        try {
            automata.procesarCadena( cadena);

            if (automata.esValida()) {
                System.out.println("Cadena valida (par de ceros)");
            } else {
                System.out.println("Cadena invalida (Impar de ceros)");
                
            }
        } catch (IllegalArgumentException e ) {
            System.out.println("Error : " + e.getMessage());
        }
        sc.close();
    }
}
