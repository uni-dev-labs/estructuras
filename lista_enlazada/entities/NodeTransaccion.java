package lista_enlazada.entities;

public class NodeTransaccion {
private NodeTransaccion next;
private Transaccion value;

@Override
public String toString() {
    return "NodeTransaccion [value=" + value + ", next=" + next + "]";
}
public NodeTransaccion getNext() {
    return next;
}
public void setNext(NodeTransaccion next) {
    this.next = next;
}
public Transaccion getValue() {
    return value;
}
public void setValue(Transaccion value) {
    this.value = value;
}
public NodeTransaccion(NodeTransaccion next, Transaccion value) {
    this.next = next;
    this.value = value;
}
public NodeTransaccion() {
}
}
