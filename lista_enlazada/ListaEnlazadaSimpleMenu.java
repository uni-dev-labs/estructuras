package lista_enlazada;

import lista_enlazada.models.Transaccion;

public class ListaEnlazadaSimpleMenu {

    private Nodo cabeza;
    private int tamaño;

    // Clase interna Nodo
    private class Nodo {
        Transaccion data;
        Nodo siguiente;

        public Nodo(Transaccion data) {
            this.data = data;
            this.siguiente = null;
        }
    }

    // Insertar al final
    public void insertarAlFinal(Transaccion transaccion) {
        Nodo nuevo = new Nodo(transaccion);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    // Verificar si existe por ID
    public boolean contiene(Long id) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.data.getId().equals(id)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Buscar posición por ID
    public int buscar(Long id) {
        Nodo actual = cabeza;
        int posicion = 0;

        while (actual != null) {
            if (actual.data.getId().equals(id)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }

    // Obtener por posición
    public Transaccion obtenerEnPosicion(int pos) {
        if (pos < 0 || pos >= tamaño) {
            return null;
        }

        Nodo actual = cabeza;
        int contador = 0;

        while (contador < pos) {
            actual = actual.siguiente;
            contador++;
        }

        return actual.data;
    }

    // Eliminar por ID
    public void eliminarPorId(Long id) {
        if (cabeza == null) return;

        // Si es el primero
        if (cabeza.data.getId().equals(id)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.data.getId().equals(id)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Imprimir lista
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("No hay transacciones.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.siguiente;
        }
    }

    // Tamaño de la lista
    public int size() {
        return tamaño;
    }

    // Limpiar lista
    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }
}