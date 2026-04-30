
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Estado q0 = new Estado("q0", true);   // par de ceros (FINAL)
        Estado q1 = new Estado("q1", false);  // impar de ceros

        // Definir transiciones (aristas del grafo)
        q0.agregarTransicion('0', q1);
        q0.agregarTransicion('1', q0);

        q1.agregarTransicion('0', q0);
        q1.agregarTransicion('1', q1);

        // Crear autómata
        Automatic afd = new Automatic(q0);

        // Entrada del usuario
        System.out.print("Ingrese una cadena binaria: ");
        String cadena = sc.nextLine();

        // Validación
        boolean esValida = afd.validarCadena(cadena);

        if (esValida) {
            System.out.println("Cadena válida (número par de ceros)");
        } else {
            System.out.println("Cadena inválida");
        }

        sc.close();
    }
}
