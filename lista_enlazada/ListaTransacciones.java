package lista_enlazada;

public class ListaTransacciones {
    NodoTransaccion cabeza;

    public ListaTransacciones() {
        cabeza = null;
    }

    public void agregar(Transaccion t) {
        NodoTransaccion nuevo = new NodoTransaccion(t);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoTransaccion temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    public void mostrar() {
        NodoTransaccion temp = cabeza;

        if (temp == null) {
            System.out.println("Lista vacia");
            return;
        }

        while (temp != null) {
            temp.dato.mostrar();
            temp = temp.siguiente;
        }
    }

    public NodoTransaccion buscar(int index) {
        NodoTransaccion temp = cabeza;
        int i = 0;

        while (temp != null) {
            if (i == index) {
                return temp;
            }
            temp = temp.siguiente;
            i++;
        }

        return null;
    }

    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    public void eliminarFinal() {
        if (cabeza == null) return;

        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }

        NodoTransaccion temp = cabeza;
        while (temp.siguiente.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = null;
    }
}