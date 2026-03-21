package lista_enlazada;

public class SimpleLinkedList {
    private Node head;

    public SimpleLinkedList() {
        head = null;
    }

    // CREATE
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    // READ - Mostrar toda la lista
    public void showList() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node current = head;
        int position = 0;

        while (current != null) {
            System.out.println("Posición " + position + ": " + current.getValue());
            current = current.getNext();
            position++;
        }
    }

    // READ - Buscar por posición
    public void searchNode(int position) {
        if (position < 0) {
            System.out.println("Posición inválida.");
            return;
        }

        Node current = head;
        int index = 0;

        while (current != null) {
            if (index == position) {
                System.out.println("Nodo encontrado en posición " + position + ": " + current.getValue());
                return;
            }
            current = current.getNext();
            index++;
        }

        System.out.println("No existe un nodo en esa posición.");
    }

    // UPDATE
    public boolean updateNode(int position, int newValue) {
        if (position < 0) {
            return false;
        }

        Node current = head;
        int index = 0;

        while (current != null) {
            if (index == position) {
                current.setValue(newValue);
                return true;
            }
            current = current.getNext();
            index++;
        }

        return false;
    }

    // DELETE
    public boolean deleteNode(int position) {
        if (head == null || position < 0) {
            return false;
        }

        if (position == 0) {
            head = head.getNext();
            return true;
        }

        Node current = head;
        int index = 0;

        while (current != null && current.getNext() != null) {
            if (index + 1 == position) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
            index++;
        }

        return false;
    }
}