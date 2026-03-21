package arraylist.models;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void mostrar() {
        Nodo<T> aux = cabeza;
        int i = 0;

        while (aux != null) {
            System.out.println(i + " -> " + aux.dato);
            aux = aux.siguiente;
            i++;
        }

        if (cabeza == null) {
            System.out.println("Lista vacia");
        }
    }

    public void eliminar(int posicion) {
        if (cabeza == null)
            return;

        if (posicion == 0) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<T> aux = cabeza;

        for (int i = 0; i < posicion - 1; i++) {
            if (aux.siguiente == null)
                return;
            aux = aux.siguiente;
        }

        if (aux.siguiente != null) {
            aux.siguiente = aux.siguiente.siguiente;
        }
    }

    public void actualizar(int posicion, T nuevoDato) {
        Nodo<T> aux = cabeza;
        int i = 0;

        while (aux != null) {
            if (i == posicion) {
                aux.dato = nuevoDato;
                return;
            }
            aux = aux.siguiente;
            i++;
        }
    }
}