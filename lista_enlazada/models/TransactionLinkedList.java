package lista_enlazada.models;

public class TransactionLinkedList {
    private NodeTransaction head;
    private IoManager ioManager;

    public TransactionLinkedList() {
        this.head = null;
        this.ioManager = new IoManager();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int counter = 0;
        NodeTransaction currentTransactionNode = head;

        while (currentTransactionNode != null) {
            counter++;
            currentTransactionNode = currentTransactionNode.getNext();
        }

        return counter;
    }

    public void insertarAtStart(Transaction transaction) {
        NodeTransaction newTransactionNode = new NodeTransaction(transaction);
        newTransactionNode.setNext(head);
        head = newTransactionNode;
    }

    public void insertarAlFinal(Transaction transaction) {
        NodeTransaction newTransactionNode = new NodeTransaction(transaction);

        if (head == null) {
            head = newTransactionNode;
            return;
        }

        NodeTransaction actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }

        actual.setNext(newTransactionNode);
    }

    public void insertarEnPosicion(Transaction transaction, int posicion) {
        if (posicion < 0 || posicion > size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }

        if (posicion == 0) {
            insertarAtStart(transaction);
            return;
        }

        NodeTransaction newTransactionNode = new NodeTransaction(transaction);
        NodeTransaction currentNode = head;
        int currentIndex = 0;

        while (currentIndex < posicion - 1) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        newTransactionNode.setNext(currentNode.getNext());
        currentNode.setNext(newTransactionNode);
    }

    public void deleteById(int id) {
        if (head == null) {
            return;
        }

        if (head.getValue().getId() == id) {
            head = head.getNext();
            return;
        }

        NodeTransaction currentNode = head;

        while (currentNode.getNext() != null && currentNode.getNext().getValue().getId() != id) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() != null) {
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + index);
        }

        if (index == 0) {
            head = head.getNext();
            return;
        }

        NodeTransaction currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index - 1) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        currentNode.setNext(currentNode.getNext().getNext());
    }

    public void clean() {
        head = null;
    }

    public boolean containsId(int id) {
        return searchById(id) != -1;
    }

    public int searchById(int id) {
        int currentIndex = 0;
        NodeTransaction currentNode = head;

        while (currentNode != null) {
            if (currentNode.getValue().getId() == id) {
                return currentIndex;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return -1;
    }

    public Transaction obtenerEnPosicion(int typedIndex) {
        if (typedIndex < 0 || typedIndex >= size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + typedIndex);
        }

        NodeTransaction currentNode = head;
        int currentIndex = 0;

        while (currentIndex < typedIndex) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode.getValue();
    }

    public void printLinkedList() {
        String message = "[";

        NodeTransaction currentNode = head;

        while (currentNode != null) {
            message += currentNode.getValue();

            if (currentNode.getNext() != null) {
                message += " -> ";
            }

            currentNode = currentNode.getNext();
        }

        message += "]";

        ioManager.printMessage(message);
    }

}
