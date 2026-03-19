package lista_enlazada;

import lista_enlazada.models.Node;



public class ListaEnlazadaSimple {

    private Node head;

    public ListaEnlazadaSimple() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int size() {
        int contador = 0;
        Node actual = head;

        while (actual != null) {
            contador++;
            actual = actual.getNext();
        }
        return contador;
    }

    public void insertarAlInicio(Transaccion value) {
        Node nuevo = new Node(value);
        nuevo.setNext(head);
        head = nuevo;
    }

    public void insertarAlFinal(Transaccion value) {
        Node nuevo = new Node(value);

        if (head == null) {
            head = nuevo;
            return;
        }

        Node actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }

        actual.setNext(nuevo);
    }

    public int buscar(String descripcion) {
        Node actual = head;
        int posicion = 0;

        while (actual != null) {
            if (actual.getValue().getDescripcion().equalsIgnoreCase(descripcion)) {
                return posicion;
            }
            actual = actual.getNext();
            posicion++;
        }
        return -1;
    }

    public void eliminarPorValor(String descripcion) {
        if (head == null) return;

        if (head.getValue().getDescripcion().equalsIgnoreCase(descripcion)) {
            head = head.getNext();
            return;
        }

        Node actual = head;

        while (actual.getNext() != null &&
               !actual.getNext().getValue().getDescripcion().equalsIgnoreCase(descripcion)) {
            actual = actual.getNext();
        }

        if (actual.getNext() != null) {
            actual.setNext(actual.getNext().getNext());
        }
    }

    //  UPDATE (MODIFICAR)
    public boolean actualizar(String descripcion, Transaccion nueva) {
        Node actual = head;

        while (actual != null) {
            if (actual.getValue().getDescripcion().equalsIgnoreCase(descripcion)) {
                actual.setValue(nueva);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public void limpiar() {
        head = null;
    }

    public void imprimir() {
        System.out.println("\n--- Historial de Transacciones ---");

        if (head == null) {
            System.out.println("[Lista vacía]");
            return;
        }

        Node actual = head;
        int i = 0;

        while (actual != null) {
            System.out.print("[" + i + "] " + actual.getValue());
            if (actual.getNext() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getNext();
            i++;
        }

        System.out.println("\n----------------------------------");
    }
}