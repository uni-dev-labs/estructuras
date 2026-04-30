package Arbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NodoEstado {
    String nombre;
    boolean esValido;
    Map<Character, NodoEstado> aristas;

    public NodoEstado(String nombre, boolean esValido) {
        this.nombre = nombre;
        this.esValido = esValido;
        this.aristas = new HashMap<>();
    }

    public void agregarArista(char simbolo, NodoEstado destino) {
        aristas.put(simbolo, destino);
    }

    public NodoEstado transicion(char simbolo) {
        return aristas.getOrDefault(simbolo, null);
    }
}

class GrafoAutomata {
    NodoEstado estadoInicial;

    public GrafoAutomata() {
        NodoEstado q0 = new NodoEstado("Q0_CerosPares", true);
        NodoEstado q1 = new NodoEstado("Q1_CerosImpares", false);

        q0.agregarArista('0', q1);
        q0.agregarArista('1', q0);

        q1.agregarArista('0', q0);
        q1.agregarArista('1', q1);

        this.estadoInicial = q0;
    }

    public String procesarCadena(String cadena) {
        NodoEstado actual = estadoInicial;

        for (char c : cadena.toCharArray()) {
            actual = actual.transicion(c);
            if (actual == null) {
                return "estado invalido";
            }
        }

        if (actual.esValido) {
            return "estado valido";
        } else {
            return "estado invalido";
        }
    }
}

public class Grafos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cadena binaria: ");
        String cadena = scanner.nextLine();

        GrafoAutomata automata = new GrafoAutomata();
        String resultado = automata.procesarCadena(cadena);

        System.out.println(resultado);

        scanner.close();
    }
}