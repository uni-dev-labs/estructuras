package lista_enlazada;



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

    // =========================
    // CREATE
    // =========================

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

    // =========================
    // READ POR DESCRIPCIÓN (mantener)
    // =========================

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

    public Transaccion buscarTransaccion(String descripcion) {
        Node actual = head;

        while (actual != null) {
            if (actual.getValue().getDescripcion().equalsIgnoreCase(descripcion)) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    // =========================
    // 🔥 READ POR ID (NUEVO)
    // =========================

    public int buscarPorId(int id) {
        Node actual = head;
        int posicion = 0;

        while (actual != null) {
            if (actual.getValue().getId() == id) {
                return posicion;
            }
            actual = actual.getNext();
            posicion++;
        }
        return -1;
    }

    public Transaccion obtenerPorId(int id) {
        Node actual = head;

        while (actual != null) {
            if (actual.getValue().getId() == id) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    // =========================
    // DELETE
    // =========================

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

    // 🔥 DELETE POR ID (NUEVO)
    public void eliminarPorId(int id) {
        if (head == null) return;

        if (head.getValue().getId() == id) {
            head = head.getNext();
            return;
        }

        Node actual = head;

        while (actual.getNext() != null &&
               actual.getNext().getValue().getId() != id) {
            actual = actual.getNext();
        }

        if (actual.getNext() != null) {
            actual.setNext(actual.getNext().getNext());
        }
    }

    // =========================
    // UPDATE
    // =========================

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

    // 🔥 UPDATE POR ID (NUEVO)
    public boolean actualizarPorId(int id, Transaccion nueva) {
        Node actual = head;

        while (actual != null) {
            if (actual.getValue().getId() == id) {
                actual.setValue(nueva);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    // =========================
    // DELETE ALL
    // =========================

    public void limpiar() {
        head = null;
    }

    // =========================
    // IMPRIMIR
    // =========================

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