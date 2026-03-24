package lista_enlazada.models;

public class NodeTransaction {

    private Transaction value;
    private NodeTransaction next;

    public NodeTransaction(Transaction value) {
        this.value = value;
        this.next = null;
    }

    public Transaction getValue() {
        return value;
    }

    public void setValue(Transaction value) {
        this.value = value;
    }

    public NodeTransaction getNext() {
        return next;
    }

    public void setNext(NodeTransaction next) {
        this.next = next;
    }

}

