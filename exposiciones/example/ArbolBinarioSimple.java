package exposiciones.example;


class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class ArbolBinarioSimple {

    Nodo raiz;

    // Insertar manualmente (tipo árbol binario de ñbúsqueda)
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }

        return raiz;
    }

    // Recorrido Preorden
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    // Recorrido Inorden
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    // Recorrido Postorden
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {
        ArbolBinarioSimple arbol = new ArbolBinarioSimple();

        // Insertar valores
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);

        System.out.println("Preorden:");
        arbol.preorden(arbol.raiz);

        System.out.println("\nInorden:");
        arbol.inorden(arbol.raiz);

        System.out.println("\nPostorden:");
        arbol.postorden(arbol.raiz);
    }
}