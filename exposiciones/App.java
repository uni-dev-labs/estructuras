import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Automata automata = new Automata();

        System.out.println("AFD - Verificar cantidad par de ceros");
        System.out.print("Ingrese una cadena binaria: ");
        String cadena = entrada.nextLine();

        boolean resultado = automata.validarCadena(cadena);

        if (automata.getEstado().equals("INVALIDO")) {
            System.out.println("Estado: INVALIDO");
            System.out.println("La cadena contiene simbolos que no pertenecen al alfabeto binario.");
        } else if (resultado) {
            System.out.println("Estado: ACEPTADO");
            System.out.println("La cadena posee un numero PAR de ceros.");
        } else {
            System.out.println("Estado: INVALIDO");
            System.out.println("La cadena NO posee un numero par de ceros.");
        }

        entrada.close();
    }
}