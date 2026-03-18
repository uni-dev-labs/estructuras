
package lista_enlazada_nestor.models;

public class Nodo {
    public Transaccion data;
    public Nodo siguiente;

    public Nodo(Transaccion data) {
        this.data = data;
        this.siguiente = null;
    }
}