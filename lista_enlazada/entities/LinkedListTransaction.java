package lista_enlazada.entities;

public class LinkedListTransaction {

    private NodeTransaction head;
    private int lenght;

    public LinkedListTransaction() {
        this.head = null;
        this.lenght = 0;
    }

    public LinkedListTransaction(NodeTransaction head, int lenght) {
        this.head = head;
        this.lenght = lenght;
    }

    public void addLastTrans(Transaction transaction) {
        NodeTransaction node = new NodeTransaction(null, transaction);
        if (this.head == null) {
            this.head = node;
        } else {
            NodeTransaction temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        this.lenght++;
    }

    public void addFirstTransaction(Transaction transaction) {
        NodeTransaction node = new NodeTransaction(head, transaction);
        this.head = node;
        this.lenght++;
    }

    public void addForIndexTransaction(Transaction transaction, int index) throws Exception {
        index = Math.abs(index);
        if (index == 1) {
            addFirstTransaction(transaction);
            this.lenght++;

        } else if (index > this.lenght) {
            int i = 1;
            NodeTransaction temp = this.head;
            while (temp.getNext() != null && i != index) {
                temp = temp.getNext();
                i++;
            }
            NodeTransaction next = temp.getNext();
            NodeTransaction node = new NodeTransaction(next, transaction);
            temp.setNext(node);

        } else {
            throw new Exception("¡¡¡¡¡¡¡¡¡¡¡Error!!!!!!!!!!");
        }
    }

    public void removeFirstTransaction() throws Exception {
        if (head != null) {
            NodeTransaction node = this.head.getNext();
            this.head.setNext(null);
            this.head = node;
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos");
    }

    public void removeLastTransaction() throws Exception {
        if (this.lenght == 1) {
            this.head = null;
            this.lenght--;
            return;
        } else if (head != null) {
            NodeTransaction temp = head;
            int i = 0;
            while (temp.getNext() != null && i != this.lenght - 1) {
                temp = temp.getNext();
                i++;
            }
            temp.setNext(null);
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos");

    }

    public void removeForIndexTransaction(int index) throws Exception {
        index = Math.abs(index);
        if (index < this.lenght) {
            if (index == 1) {
                NodeTransaction temp = head;
                temp = head.getNext();
                head.setNext(null);
                this.head = temp;
                this.lenght--;
            } else {
                NodeTransaction temp = head;
                int i = 1;
                while (temp.getNext() != null && i != this.lenght - 1) {
                    temp = temp.getNext();
                    i++;
                }
                NodeTransaction remove = temp.getNext();
                NodeTransaction next = temp.getNext();
                temp.setNext(next);
                remove.setNext(null);
            }
            throw new Exception("Posición no valida");
        }
    }

    public NodeTransaction searchPerIndex(int index) throws Exception {
        index = Math.abs(index);
        if (index <= this.lenght && index != 0) {
            NodeTransaction node = head;
            int i = 1;
            while (i != index && node.getNext() != null) {
                node = node.getNext();
                i++;
            }
            return node;

        }
        throw new Exception("Posición invalida");
    }

    public NodeTransaction getHead() {
        return head;
    }

    public void setHead(NodeTransaction head) {
        this.head = head;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
