package lista_enlazada.models;

import lista_enlazada.Transaccion;

public class Nodo_Transaccion {
    private Transaccion transaccion;
    private Nodo_Transaccion siguiente;

    public Nodo_Transaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
        this.siguiente = null;
    }

    public Transaccion getTransaccion() { return transaccion; }
    public Nodo_Transaccion getSiguiente() { return siguiente; }

    public void setTransaccion(Transaccion transaccion) { this.transaccion = transaccion; }
    public void setSiguiente(Nodo_Transaccion siguiente) { this.siguiente = siguiente; }
}