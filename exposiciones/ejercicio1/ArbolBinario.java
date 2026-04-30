package exposiciones.ejercicio1;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }
    //Insertar manualmente como ABB(árbol binario de busqueda)
    public void insertar(int valor){
        raiz = insertarRec(raiz,valor);
    }
    private Nodo insertarRec(Nodo actual, int valor){
        if (actual==null) {
            return new Nodo(valor);
        }
        if (valor<actual.valor) {
            actual.izquierda= insertarRec(actual.izquierda, valor);
        } else if (valor> actual.valor) {
            actual.derecha= insertarRec(actual.derecha, valor);
        }
        return actual;
            
        }
        //recorridos
        public void  preorden(Nodo nodo){
            if (nodo !=null) {
                System.out.println(nodo.valor+" ");
                preorden(nodo.izquierda);
                preorden(nodo.derecha);
            }
        }
        public void inorden(Nodo nodo){
            if (nodo!= null) {
                inorden(nodo.izquierda);
                System.out.println(nodo.valor + " ");
                inorden(nodo.derecha);
            }
        }
        public void postorden(Nodo nodo){
            if (nodo!=null) {
                postorden(nodo.izquierda);
                postorden(nodo.derecha);
                System.out.println(nodo.valor + " ");
            }
        }
    }


