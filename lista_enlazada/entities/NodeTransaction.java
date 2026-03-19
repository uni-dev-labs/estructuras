package lista_enlazada.entities;

public class NodeTransaction {

    private NodeTransaction next;
    private Transaction value;

    public NodeTransaction() {
    }

    public NodeTransaction(NodeTransaction next, Transaction value) {
        this.next = next;
        this.value = value;
    }

    public NodeTransaction getNext() {
        return next;
    }

    public void setNext(NodeTransaction next) {
        this.next = next;
    }

    public Transaction getValue() {
        return value;
    }

    public void setValue(Transaction value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NodeTransaccion [" + "value: " + value + ", next: " + next + "]";
    }

}
