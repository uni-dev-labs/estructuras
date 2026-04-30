package Arboles.src;

public class TreeBinary {
    Node raiz;

    public void insertar(int value) {
        raiz = insertarRec(raiz, value);
    }

    private Node insertarRec(Node actual, int value) {
        if (actual == null) {
            return new Node(value);
        }

        if (value < actual.value) {
            actual.left = insertarRec(actual.left, value);
        } else if (value > actual.value) {
            actual.right = insertarRec(actual.right, value);
        }

        return actual;
    }

    public void preorden(Node nodo) {
        if (nodo != null) {
            System.out.print(nodo.value + " ");
            preorden(nodo.left);
            preorden(nodo.right);
        }
    }

    public void inorden(Node nodo) {
        if (nodo != null) {
            inorden(nodo.left);
            System.out.print(nodo.value + " ");
            inorden(nodo.right);
        }
    }

    public void postorden(Node nodo) {
        if (nodo != null) {
            postorden(nodo.left);
            postorden(nodo.right);
            System.out.print(nodo.value + " ");
        }
    }

}
