public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void crearArbol() {
        raiz = new Nodo(10);

        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(3);
        raiz.izquierda.derecha = new Nodo(7);
    }

    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }

    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            inorden(nodo.derecha);
        }

    }

    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.println(nodo.valor + " ");
        }

    }

}
