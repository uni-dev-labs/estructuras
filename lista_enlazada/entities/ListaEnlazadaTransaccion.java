package lista_enlazada.entities;

public class ListaEnlazadaTransaccion {
    private NodeTransaccion head;
    private int lenght;

    public ListaEnlazadaTransaccion() {
        this.head = null;
        this.lenght = 0;
    }
    
    public void addLastTrans(Transaccion transaccion) {
        NodeTransaccion node = new NodeTransaccion(null, transaccion);
        if (this.head == null) {
            this.head = node;
        } else {
            NodeTransaccion temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext(); 
            }
            temp.setNext(node);
        }
        this.lenght++;
    }

    public void addFirstTrans(Transaccion transaccion) {
        NodeTransaccion node = new NodeTransaccion(head, transaccion);
        this.head = node;
        this.lenght++;
    }

    public void addForIndexTrans(Transaccion transaccion, int index) throws Exception {
        index = Math.abs(index);
        if (index == 1 || this.head == null) {
            addFirstTrans(transaccion);
        } else if (index <= this.lenght + 1 && index != 0) {
            int i = 1;
            NodeTransaccion temp = this.head;
            while (temp.getNext() != null && i != index - 1) {
                temp = temp.getNext();
                i++;
            }
            NodeTransaccion next = temp.getNext();
            NodeTransaccion node = new NodeTransaccion(next, transaccion);
            temp.setNext(node);
            this.lenght++;
        } else {
            throw new Exception("Índice fuera de rango. La lista solo tiene " + this.lenght + " elementos.");
        }
    }

    public void removeFirstTrans() throws Exception {
        if (head != null) {
            NodeTransaccion node = this.head.getNext();
            this.head.setNext(null);
            this.head = node;
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos para eliminar panita.");
    }

    public void removeLastTrans() throws Exception {
        if (this.lenght == 1) {
            this.head = null;
            this.lenght--;
            return;
        } else if (head != null) {
            NodeTransaccion temp = head;
            // Avanzamos hasta el PENÚLTIMO nodo
            while (temp.getNext() != null && temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos para eliminar panita.");
    }

    public void removeForIndexTrans(int index) throws Exception {
        index = Math.abs(index);
        if (index <= this.lenght && index != 0) {
            if (index == 1) {
                removeFirstTrans();
            } else {
                NodeTransaccion temp = head;
                int i = 1;
                while (temp.getNext() != null && i != index - 1) {
                    temp = temp.getNext();
                    i++;
                }
                NodeTransaccion remove = temp.getNext();
                if (remove != null) {
                    NodeTransaccion next = remove.getNext();
                    temp.setNext(next);
                    remove.setNext(null);
                    this.lenght--;
                }
            }
        } else {
            throw new Exception("Panita la cagaste en la posición. Ese índice no existe.");
        }
    }

    public NodeTransaccion searchPerIndex(int index) throws Exception {
        index = Math.abs(index);
        if (index <= this.lenght && index != 0) {
            NodeTransaccion node = head;
            int i = 1;
            while (i != index && node.getNext() != null) {
                node = node.getNext();
                i++;
            }
            return node;
        }
        throw new Exception("Panita la cagaste en la posición. No se encontró el índice.");
    }

    public NodeTransaccion getHead() {
        return head;
    }

    public int getLenght() {
        return lenght;
    }
}