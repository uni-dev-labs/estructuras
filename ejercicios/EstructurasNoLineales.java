package ejercicios;

public class EstructurasNoLineales {

    // Nodo del árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // Raíz del árbol
    Nodo raiz;

    // Insertar un valor en el árbol binario de búsqueda
    Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        }
        return nodo;
    }

    // Recorrido Preorden: Raíz → Izquierdo → Derecho
    void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    // Recorrido Inorden: Izquierdo → Raíz → Derecho
    void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    // Recorrido Postorden: Izquierdo → Derecho → Raíz
    void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {
        EstructurasNoLineales arbol = new EstructurasNoLineales();

        // Insertar valores: 10, 5, 15, 3, 7
        int[] valores = { 10, 5, 15, 3, 7 };
        for (int v : valores) {
            arbol.raiz = arbol.insertar(arbol.raiz, v);
        }

        System.out.println("=== Árbol Binario de Búsqueda ===");
        System.out.println("Valores insertados: 10, 5, 15, 3, 7");
        System.out.println();

        System.out.print("Preorden  (Raíz-Izq-Der): ");
        arbol.preorden(arbol.raiz);
        System.out.println();

        System.out.print("Inorden   (Izq-Raíz-Der): ");
        arbol.inorden(arbol.raiz);
        System.out.println();

        System.out.print("Postorden (Izq-Der-Raíz): ");
        arbol.postorden(arbol.raiz);
        System.out.println();
    }
}
