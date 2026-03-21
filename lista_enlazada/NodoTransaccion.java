package lista_enlazada;

public class NodoTransaccion {
    Transaccion dato;
    NodoTransaccion siguiente;

    public NodoTransaccion(Transaccion dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}