package Exposiciones.EjerecicioArbol.EjerecicioArbol.src;

/**
 * Clase que implementa un árbol binario de búsqueda
 */
public class ArbolBinario {
    private Nodo raiz;

    /**
     * Constructor del árbol binario
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Inserta un valor en el árbol binario
     * 
     * @param valor el valor a insertar
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Método recursivo para insertar un valor
     */
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

    /**
     * Recorrido en Preorden (Raíz - Izquierda - Derecha)
     */
    public void preorden() {
        System.out.print("Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.valor + " ");
        preordenRecursivo(nodo.izquierdo);
        preordenRecursivo(nodo.derecho);
    }

    /**
     * Recorrido en Inorden (Izquierda - Raíz - Derecha)
     */
    public void inorden() {
        System.out.print("Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inordenRecursivo(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inordenRecursivo(nodo.derecho);
    }

    /**
     * Recorrido en Postorden (Izquierda - Derecha - Raíz)
     */
    public void postorden() {
        System.out.print("Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        postordenRecursivo(nodo.izquierdo);
        postordenRecursivo(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }

    /**
     * Muestra la estructura visual del árbol en la consola
     */
    public void mostrar() {
        System.out.println("\nEstructura del Árbol:");
        System.out.println("====================");
        if (raiz == null) {
            System.out.println("El árbol está vacío");
        } else {
            imprimirArbolRecursivo(raiz, "", true);
        }
    }

    /**
     * Imprime el árbol de forma recursiva con la estructura visual
     */
    private void imprimirArbolRecursivo(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) {
            return;
        }

        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.valor);

        if (nodo.izquierdo != null || nodo.derecho != null) {
            String nuevoPrefi = prefijo + (esUltimo ? "    " : "│   ");

            if (nodo.izquierdo != null && nodo.derecho != null) {
                System.out.println(nuevoPrefi + "/ \\");
                imprimirArbolRecursivo(nodo.izquierdo, nuevoPrefi, false);
                imprimirArbolRecursivo(nodo.derecho, nuevoPrefi, true);
            } else if (nodo.izquierdo != null) {
                System.out.println(nuevoPrefi + "/");
                imprimirArbolRecursivo(nodo.izquierdo, nuevoPrefi, true);
            } else if (nodo.derecho != null) {
                System.out.println(nuevoPrefi + "\\");
                imprimirArbolRecursivo(nodo.derecho, nuevoPrefi, true);
            }
        }
    }
}
