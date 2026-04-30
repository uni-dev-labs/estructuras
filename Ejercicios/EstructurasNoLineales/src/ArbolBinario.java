class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = null;
        derecha = null;
    }
}

public class ArbolBinario {

    Nodo raiz;

    // Insertar (tipo árbol binario de búsqueda)
    public Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertar(raiz.izquierda, valor);
        } else {
            raiz.derecha = insertar(raiz.derecha, valor);
        }

        return raiz;
    }

    // Preorden: raíz - izquierda - derecha
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    // Inorden: izquierda - raíz - derecha
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    // Postorden: izquierda - derecha - raíz
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();

        // Insertar valores
        int[] valores = {10, 5, 15, 3, 7};

        for (int v : valores) {
            arbol.raiz = arbol.insertar(arbol.raiz, v);
        }

        System.out.println("Preorden:");
        arbol.preorden(arbol.raiz);

        System.out.println("\nInorden:");
        arbol.inorden(arbol.raiz);

        System.out.println("\nPostorden:");
        arbol.postorden(arbol.raiz);
    }
}