package lista_enlazada.models;

/**
 * Clase Node: representa un nodo de la lista enlazada simple.
 * Cada nodo guarda:
 *  - un valor entero (value)
 *  - una referencia al siguiente nodo (next)
 */
public class Node {
    private int value; // Valor que almacena el nodo
    private Node next; // Referencia al siguiente nodo de la lista

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    //Devuelve la referencia al siguiente nodo. Si es null, este nodo es el último de la lista.
    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
