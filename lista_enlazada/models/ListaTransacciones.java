package lista_enlazada.models;

import lista_enlazada.Transaccion;

public class ListaTransacciones {

    private Nodo_Transaccion head;

    public ListaTransacciones() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int size() {
        int contador = 0;
        Nodo_Transaccion actual = head;

        while (actual != null) {
            contador++;
            actual = actual.getNext();
        }

        return contador;
    }

    public void insertarAlInicio(Transaccion t) {
        Nodo_Transaccion nuevo = new Nodo_Transaccion(t);
        nuevo.setNext(head);
        head = nuevo;
    }

    public void insertarAlFinal(Transaccion t) {
        Nodo_Transaccion nuevo = new Nodo_Transaccion(t);

        if (head == null) {
            head = nuevo;
            return;
        }

        Nodo_Transaccion actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }

        actual.setNext(nuevo);
    }

    public void eliminarPorId(int id) {

        if (head == null)
            return;

        if (head.getTransaccion().getId() == id) {
            head = head.getNext();
            return;
        }

        Nodo_Transaccion actual = head;

        while (actual.getNext() != null &&
                actual.getNext().getTransaccion().getId() != id) {
            actual = actual.getNext();
        }

        if (actual.getNext() != null) {
            actual.setNext(actual.getNext().getNext());
        }
    }

    public int buscarPorId(int id) {
        int posicion = 0;
        Nodo_Transaccion actual = head;

        while (actual != null) {
            if (actual.getTransaccion().getId() == id) {
                return posicion;
            }
            actual = actual.getNext();
            posicion++;
        }

        return -1;
    }

    public Transaccion obtenerEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size()) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        Nodo_Transaccion actual = head;
        int indice = 0;

        while (indice < posicion) {
            actual = actual.getNext();
            indice++;
        }

        return actual.getTransaccion();
    }

    public void imprimir() {
        Nodo_Transaccion actual = head;

        System.out.println("\n--- LISTA DE TRANSACCIONES ---");

        while (actual != null) {
            System.out.println(actual.getTransaccion());
            actual = actual.getNext();
        }
    }

    public void limpiar() {
        head = null;
    }
}