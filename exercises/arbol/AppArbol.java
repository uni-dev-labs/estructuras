package exercises.arbol;

import java.util.Scanner;

public class AppArbol {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AppArbol arbol = new AppArbol();

        // Valores solicitados en el ejercicio
        int[] datos = {10, 5, 15, 3, 7};

        for (int valor : datos) {
            arbol.raiz = arbol.insertar(arbol.raiz, valor);
        }

        System.out.println("=== Recorridos del Árbol Binario ===");
        
        System.out.println("Preorden:  ");
        arbol.preorden(arbol.raiz);
        
        System.out.println("\nInOrden:   ");
        arbol.inOrden(arbol.raiz);
        
        System.out.println("\nPostOrden: ");
        arbol.postOrden(arbol.raiz);
        System.out.println();
    }

    Nodo raiz;

    public Nodo insertar(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertar(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertar(actual.derecho, valor);
        }

        return actual;
    }

    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }
    }

    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
}
