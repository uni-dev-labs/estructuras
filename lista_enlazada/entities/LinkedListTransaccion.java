package lista_enlazada.entities;


public class LinkedListTransaccion {
    private NodeTransaccion head;
    private int length;

    public NodeTransaccion getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public LinkedListTransaccion(NodeTransaccion head) {
        this.head = head;
        this.length = 1;
    }

    public LinkedListTransaccion() {
        this.length = 0;
        this.head = null;
    }

    public void addLastTransaccion(Transaccion transaccion) {
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
        this.length++;

    }

    public void addFirstTransaccion(Transaccion transaccion) {
        NodeTransaccion node = new NodeTransaccion(head, transaccion);
        this.head = node;
        this.length++;
    }

    public void addForIndexTransaccion(Transaccion transaccion, int index) throws Exception {
        index = Math.abs(index);
        if (index == 1) {
            addFirstTransaccion(transaccion);
            return;
        } else if (index <= this.length) {
            int i = 1;
            NodeTransaccion temp = this.head;
            while (temp.getNext() != null && i != index - 1) {
                temp = temp.getNext();
                i++;
            }
            NodeTransaccion next = temp.getNext();
            NodeTransaccion node = new NodeTransaccion(next, transaccion);
            temp.setNext(node);
            this.length++;
            return;
        } else {
            throw new Exception("invalid index");
        }
    }

    public void removeFirstTransaccion() throws Exception {
        if (head != null) {
            NodeTransaccion node = this.head.getNext();
            this.head.setNext(null);
            head = node;
            this.length--;
            return;
        }
        throw new Exception("None Data");
    }

    public void removeLastTransaccion() throws Exception {
        if (this.length == 1) {
            this.head = null;
            this.length--;
            return;
        } else if (this.head != null) {
            NodeTransaccion temp = head;
            int i = 1;
            while (temp.getNext() != null && i != this.length - 1) {
                temp = temp.getNext();
                i++;
            }
            temp.setNext(null);
            this.length--;
            return;
        }
        throw new Exception("Node Data");
    }
    public void  removeForIndexTransaccion(int index) throws Exception{
        index = Math.abs(index);
        if(index<=this.length && index !=0){
            if(index == 1){
                NodeTransaccion temp =head;
                temp = head.getNext();
                head.setNext(null);
                this.head = temp;
                this.length--;
            }else{
                NodeTransaccion temp = head;
                int i = 1;
                while (temp.getNext() != null && i != index - 1) {
                    temp = temp.getNext();
                    i++;
                }
                NodeTransaccion remove = temp.getNext();
                NodeTransaccion next = remove.getNext();
                temp.setNext(next);
                remove.setNext(null);
                this.length--;
            }
            return;
        }
        throw new Exception("Invalid Index");

    }

    public NodeTransaccion searchForIndexTransaccion(int index)throws Exception{
        index = Math.abs(index);
        if(index<=this.length && index !=0){
            NodeTransaccion node = head;
            int i =1;
            while (i!=index && node.getNext()!=null) {
                node = node.getNext();
                i++;
            }
            return node;
        }
        throw new Exception("Invalid Index");
    }


}
