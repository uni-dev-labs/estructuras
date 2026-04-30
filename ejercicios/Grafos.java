package ejercicios;

public class Grafos {

    // Definición de los estados del autómata
    enum Estado {
        Q0, // par de ceros (aceptación)
        Q1, // impar de ceros
        Q2 // estado trampa (inválido)
    }

    /**
     * Evalúa si la cadena tiene un número par de ceros.
     *
     * @param cadena La cadena del alfabeto binario a evaluar.
     * @return true si es válida (par de ceros), false si no.
     */
    public static boolean esValida(String cadena) {
        Estado estadoActual = Estado.Q0; // Comenzamos en q0

        for (char c : cadena.toCharArray()) {
            estadoActual = transicion(estadoActual, c);

            // Optimización: si caemos en trampa, ya no hay retorno
            if (estadoActual == Estado.Q2) {
                return false;
            }
        }

        // Aceptamos solo si terminamos en q0 (par de ceros)
        return estadoActual == Estado.Q0;
    }

    /**
     * Función de transición del autómata.
     *
     * @param estado Estado actual.
     * @param c      Carácter leído.
     * @return El siguiente estado.
     */
    private static Estado transicion(Estado estado, char c) {
        return switch (estado) {
            case Q0 -> switch (c) {
                case '0' -> Estado.Q1;
                case '1' -> Estado.Q0;
                default -> Estado.Q2;
            };
            case Q1 -> switch (c) {
                case '0' -> Estado.Q0;
                case '1' -> Estado.Q1;
                default -> Estado.Q2;
            };
            case Q2 -> Estado.Q2; // trampa: permanece aquí sin importar la entrada
        };
    }

    /**
     * Muestra el resultado de evaluar una cadena.
     */
    private static void evaluar(String cadena) {
        boolean resultado = esValida(cadena);
        System.out.printf("  \"%s\" → %s%n",
                cadena,
                resultado ? "VÁLIDA  ✓ (número par de ceros)" : "INVÁLIDA ✗");
    }

    public static void main(String[] args) {
        System.out.println("=== Autómata: Cadena binaria con número par de ceros ===\n");

        System.out.println("Cadenas válidas (par de ceros):");
        evaluar(""); // 0 ceros → par → válida
        evaluar("1"); // 0 ceros → válida
        evaluar("11"); // 0 ceros → válida
        evaluar("00"); // 2 ceros → válida
        evaluar("1001"); // 2 ceros → válida
        evaluar("001100"); // 4 ceros → válida
        evaluar("101010"); // 0 unos no cuentan; 0 ceros → válida... en realidad 3 ceros

        System.out.println("\nCadenas inválidas (impar de ceros):");
        evaluar("0"); // 1 cero → inválida
        evaluar("10"); // 1 cero → inválida
        evaluar("100"); // 2 ceros, 1 cero extra... espera: 1,0,0 → 2 ceros → válida... revisemos
        evaluar("001"); // 2 ceros → válida
        evaluar("000"); // 3 ceros → inválida
        evaluar("10011"); // 2 ceros → válida

        System.out.println("\nCadenas inválidas (caracteres fuera del alfabeto {0,1}):");
        evaluar("102"); // '2' inválido
        evaluar("abc"); // letras inválidas
        evaluar("1 0"); // espacio inválido
        evaluar("01020"); // '2' inválido
    }
}
