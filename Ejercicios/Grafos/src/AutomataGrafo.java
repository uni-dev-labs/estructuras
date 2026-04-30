import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutomataGrafo {

    // Grafo: estado -> (entrada -> siguiente estado)
    static Map<String, Map<Character, String>> grafo = new HashMap<>();

    static {
        // Transiciones de q0
        Map<Character, String> q0 = new HashMap<>();
        q0.put('0', "q1");
        q0.put('1', "q0");

        // Transiciones de q1
        Map<Character, String> q1 = new HashMap<>();
        q1.put('0', "q0");
        q1.put('1', "q1");

        grafo.put("q0", q0);
        grafo.put("q1", q1);
    }

    public static boolean evaluarCadena(String cadena) {
        String estadoActual = "q0"; // estado inicial

        for (char c : cadena.toCharArray()) {
            if (!grafo.get(estadoActual).containsKey(c)) {
                return false; // símbolo inválido
            }
            estadoActual = grafo.get(estadoActual).get(c);
        }

        return estadoActual.equals("q0"); // estado de aceptación
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena binaria: ");
        String cadena = scanner.nextLine();

        if (evaluarCadena(cadena)) {
            System.out.println("✅ Cadena válida (número par de 0s)");
        } else {
            System.out.println("❌ Cadena inválida (número impar de 0s o contiene caracteres no válidos)");
        }

        scanner.close();
    }
}