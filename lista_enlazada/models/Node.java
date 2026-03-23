package lista_enlazada.models;

public class Node {
    private Transaccion value;
    private Node next;

    public Node(Transaccion value) {
        this.value = value;
        this.next = null;
    }

    public Transaccion getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(Transaccion value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}