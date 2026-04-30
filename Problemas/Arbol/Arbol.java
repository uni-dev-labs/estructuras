package Problemas.Arbol;

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertar(nodo.izquierda, valor);
        } else {
            nodo.derecha = insertar(nodo.derecha, valor);
        }

        return nodo;
    }
        public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }
}