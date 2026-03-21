package lista_enlazada;
public class ListaEnlazadaTransaccion {

    private Node head;
    private int length; 

    public ListaEnlazadaTransaccion() {
        this.head = null;
        this.length = 0;
    }

    
    public ListaEnlazadaTransaccion(Node head, int length) {
        this.head = head;
        this.length = length;
    }

    public void agregarPrimeraTransaccion(Transaccion transaccion) {
        Node node = new Node(head, transaccion);
        this.head = node;
        this.length++;
        System.out.println("Transaccion agregada");
    }

        public void agregarUltimaTransaccion(Transaccion transaccion) {
        Node node = new Node(null, transaccion);
        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        this.length++;
        System.out.println("Transaccion agregada");
    }

    public void agregarIndexTransaccion(Transaccion transaccion, int index) throws Exception {
        index = Math.abs(index);
        if (index == 1) {
            agregarPrimeraTransaccion(transaccion);
        } else if (index <= length + 1) {
            Node temp = head;

            for (int i = 1; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node node = new Node(temp.getNext(), transaccion);
            temp.setNext(node);
            this.length++;
            System.out.println("Transaccion agregadaen la posicion " +  index);
        } else {
            throw new Exception("Posición inválida");
        }
    }

    public void eliminarPrimeraTransaccion() throws Exception {
        if (head == null) throw new Exception("sin datos");
        head = head.getNext();
        this.length--;
        System.out.println("Transaccion eliminada");
    }

    public void eliminarUltimaTransaccion() throws Exception {
        if (head == null) 
            throw new Exception("sin datos");
        
        if (this.length == 1) {
            head = null;
        } else {
            Node temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
        this.length--;
        System.out.println("Transaccion eliminada");
    }

    public void eliminarIndexTransaccion(int index) throws Exception {
        index = Math.abs(index);
        if (index < 1 || index > length) 
            throw new Exception("Posición fuera de rango");

        if (index == 1) {
            eliminarPrimeraTransaccion();
        } else {
            Node temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node Eliminar = temp.getNext();
            temp.setNext(Eliminar.getNext());
            this.length--;
            System.out.println("Transaccion eliminada");
        }
    }

    public Node BuscarPorIndex(int index) throws Exception {
        index = Math.abs(index);
        if (index > 0 && index <= this.length) {
            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.getNext();
            }
            System.out.println("Transaccion encontrada");
            return node;
        }
        throw new Exception("Esa posición no existe");
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getlength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    
}


