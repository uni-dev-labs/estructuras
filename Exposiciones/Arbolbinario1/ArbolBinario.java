package Exposiciones.Arbolbinario1;

public class ArbolBinario {

    static class Nodo {
        int valor;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public static void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    public static void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    public static void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {

        // Construcción manual del árbol
        Nodo raiz = new Nodo(10);

        raiz.izquierdo = new Nodo(5);
        raiz.derecho = new Nodo(15);

        raiz.izquierdo.izquierdo = new Nodo(3);
        raiz.izquierdo.derecho = new Nodo(7);

        // Recorridos
        System.out.print("\nPreorden (Raíz - Izq - Der): ");
        preorden(raiz);

        System.out.print("\nInorden (Izq - Raíz - Der): ");
        inorden(raiz);

        System.out.print("\nPostorden (Izq - Der - Raíz): ");
        postorden(raiz);
    }
}