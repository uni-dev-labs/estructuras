package lista_enlazada_nestor;

import lista_enlazada_nestor.models.Nodo;
import lista_enlazada_nestor.models.Transaccion;

public class ListaEnlazada {

    Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void insertar(int id, double monto) {

    if (id <= 0) {
        System.out.println("ID invalido");
        return;
    }

    if (monto <= 0) {
        System.out.println("Monto invalido");
        return;
    }

    Transaccion t = new Transaccion(id, monto);
    Nodo nuevo = new Nodo(t);

    if (cabeza == null) {
        cabeza = nuevo;
    } else {
        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevo;
    }

    System.out.println("Transaccion agregada correctamente");
}

    public void buscar(int id) {
    Nodo temp = cabeza;

    while (temp != null) {
        if (temp.data.id == id) {
            System.out.println("Transaccion encontrada:");
            temp.data.mostrar();
            return;
        }
        temp = temp.siguiente;
    }

    System.out.println("Transaccion no encontrada");
}

    public void mostrar() {
        Nodo temp = cabeza;

        while (temp != null) {
            temp.data.mostrar();
            temp = temp.siguiente;
        }
    }

    public void actualizar(int id, double nuevoMonto) {
    Nodo temp = cabeza;

    while (temp != null) {
        if (temp.data.id == id) {
            temp.data.monto = nuevoMonto;
            System.out.println("Transaccion actualizada correctamente");
            return;
        }
        temp = temp.siguiente;
    }

    System.out.println("Transaccion no encontrada");
}
}