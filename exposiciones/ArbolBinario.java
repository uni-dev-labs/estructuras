public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    public void preorden() {
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }

    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.derecho);
        }
    }

    public void postorden() {
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
}