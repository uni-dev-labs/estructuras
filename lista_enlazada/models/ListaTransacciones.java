package lista_enlazada.models;

import lista_enlazada.Transaccion;

public class ListaTransacciones {
    private Nodo_Transaccion cabeza;

    public ListaTransacciones() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarAlFinal(Transaccion t) {
        Nodo_Transaccion nuevo = new Nodo_Transaccion(t);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo_Transaccion actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    public void eliminarPorId(int id) {
        if (cabeza == null) return;
        if (cabeza.getTransaccion().getId() == id) {
            cabeza = cabeza.getSiguiente();
            return;
        }
        Nodo_Transaccion actual = cabeza;
        while (actual.getSiguiente() != null &&
               actual.getSiguiente().getTransaccion().getId() != id) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
    }

    public void imprimir() {
        Nodo_Transaccion actual = cabeza;
        System.out.println("\n--- LISTA DE TRANSACCIONES ---");
        while (actual != null) {
            System.out.println(actual.getTransaccion());
            actual = actual.getSiguiente();
        }
    }

    // método extra para diferenciar
    public int contar() {
        int total = 0;
        Nodo_Transaccion actual = cabeza;
        while (actual != null) {
            total++;
            actual = actual.getSiguiente();
        }
        return total;
    }
}