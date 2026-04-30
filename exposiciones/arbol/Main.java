package exposiciones.arbol;

public class Main {

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

        Nodo n = new Nodo(10);
        n.izquierdo = new Nodo(5);
        n.derecho = new Nodo(15);
        n.izquierdo.izquierdo = new Nodo(3);
        n.izquierdo.derecho = new Nodo(7);

        System.out.print("Preorden: ");
        preorden(n);

        System.out.print("\nInorden: ");
        inorden(n);

        System.out.print("\nPostorden: ");
        postorden(n);
    }
}