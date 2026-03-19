package lista_enlazada.models;

import lista_enlazada.Transaccion;

public class Nodo_Transaccion {
    private Transaccion transaccion;
    private Nodo_Transaccion next;

    public Nodo_Transaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
        this.next = null;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public Nodo_Transaccion getNext() {
        return next;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public void setNext(Nodo_Transaccion next) {
        this.next = next;
    }
}