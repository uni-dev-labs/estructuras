package lista_enlazada.models;

public class NodeTransaccion {
    private Transaccion transaccion; 
    private NodeTransaccion next; 

    public NodeTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
        this.next = null;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public NodeTransaccion getNext() {
        return next;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public void setNext(NodeTransaccion next) {
        this.next = next;
    }
}
