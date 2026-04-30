import java.util.*;

public class App {

    public static void main(String[] args) {
  
        Map<String, Map<Character, String>> grafo = new HashMap<>();

        // Configuración para el estado "Par"
        Map<Character, String> caminosDesdePar = new HashMap<>();
        caminosDesdePar.put('0', "Impar"); // Si llega un 0, va a Impar
        caminosDesdePar.put('1', "Par");   // Si llega un 1, se queda en Par
        grafo.put("Par", caminosDesdePar);

        // Configuración para el estado "Impar"
        Map<Character, String> caminosDesdeImpar = new HashMap<>();
        caminosDesdeImpar.put('0', "Par");   // Si llega un 0, vuelve a Par
        caminosDesdeImpar.put('1', "Impar"); // Si llega un 1, se queda en Impar
        grafo.put("Impar", caminosDesdeImpar);

        // 2. Cadena de entrada
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la cadena binaria: ");
        String cadena = sc.nextLine();

        // 3. Recorrido del grafo (Simulando el movimiento entre nodos)
        String estadoActual = "Par"; 
        
        for (int i = 0; i < cadena.length(); i++) {
            char bit = cadena.charAt(i);
            // Saltamos de una "ciudad" a otra usando el mapa
            estadoActual = grafo.get(estadoActual).get(bit);
        }

        // 4. Verificación final
        if (estadoActual.equals("Par")) {
            System.out.println("Estado: INVALIDO (Número par de ceros)");
        } else {
            System.out.println("Estado: VALIDO (Número impar de ceros)");
        }
        
        sc.close();
    }
}