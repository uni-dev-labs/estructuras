package lista_enlazada;

public class Node {

    private Node next;
    private Transaccion value;
    
    public Node() {
    }
    
    public Node(Node next, Transaccion value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Transaccion getValue() {
        return value;
    }
    public void setValue(Transaccion value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [" + "value=" + value + ", next=" + next + "]";
    }
}
