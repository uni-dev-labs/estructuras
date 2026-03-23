package lista_enlazada;

import lista_enlazada.models.*;

public class ListaEnlazadaSimple {
    private Node head;

    public ListaEnlazadaSimple() {
        this.head = null;
    }

    // CREATE
    public void agregar(Transaccion t) {
        Node nuevo = new Node(t);

        if (head == null) {
            head = nuevo;
        } else {
            Node actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }

    // READ
    public void mostrar() {
        Node actual = head;
        while (actual != null) {
            System.out.println(actual.getValue());
            actual = actual.getNext();
        }
    }

    // UPDATE
    public void actualizar(int id, String nuevaDesc, double nuevoMonto) {
        Node actual = head;

        while (actual != null) {
            if (actual.getValue().id == id) {
                actual.getValue().descripcion = nuevaDesc;
                actual.getValue().monto = nuevoMonto;
                System.out.println("Actualizado correctamente");
                return;
            }
            actual = actual.getNext();
        }

        System.out.println("No encontrado");
    }

    // DELETE
    public void eliminar(int id) {
        if (head == null) return;

        if (head.getValue().id == id) {
            head = head.getNext();
            return;
        }

        Node actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getValue().id == id) {
                actual.setNext(actual.getNext().getNext());
                return;
            }
            actual = actual.getNext();
        }
    }
}