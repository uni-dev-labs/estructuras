package lista_enlazada.entities;


public class ListaEnlazadaTransaccion {

    private NodeTransaccion head;
    private int lenght;

    public ListaEnlazadaTransaccion() {
        this.head = null;
        this.lenght = 0;
    }

    public ListaEnlazadaTransaccion(NodeTransaccion head, int lenght) {
        this.head = head;
        this.lenght = lenght;
    }
    
    
    public void addLastTrans(Transaccion transaccion){
        NodeTransaccion node = new NodeTransaccion(null, transaccion);
        if (this.head == null) {
            this.head = node;
        }else{
            NodeTransaccion temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext(); 
            }
            temp.setNext(node);
        }
        this.lenght++;
    }

    public void addFirstTrans(Transaccion transaccion){
        NodeTransaccion node = new NodeTransaccion(head, transaccion);
        this.head = node;
        this.lenght++;
    }

    public void addForIndexTrans(Transaccion transaccion, int index)throws Exception{
        index = Math.abs(index);
        if (index == 1) {
            addFirstTrans(transaccion);
            this.lenght++;

        }
        else if (index> this.lenght) {
            int i = 1;
            NodeTransaccion temp = this.head;
            while (temp.getNext() != null && i != index) {
                temp = temp.getNext();
                i++;
            }
            NodeTransaccion next = temp.getNext();
            NodeTransaccion node = new NodeTransaccion(next, transaccion);
            temp.setNext(node);
            
        }else{
            throw new Exception("panita la cago en algo");
        }
    }
    public void removeFirstTrans()throws Exception{
        if (head != null) {
            NodeTransaccion node = this.head.getNext();
            this.head.setNext(null);
            this.head = node;
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos panita");
    }

    public void removeLastTrans()throws Exception{
        if (this.lenght == 1) {
            this.head = null;
            this.lenght--;
            return;
        }
        else if (head != null) {
            NodeTransaccion temp = head;
            int i = 0;
            while (temp.getNext() != null && i != this.lenght -1) {
                temp = temp.getNext();
                i++;
            }
            temp.setNext(null);
            this.lenght--;
            return;
        }
        throw new Exception("No hay datos panita");

    }
    public void removeForIndexTrans(int index)throws Exception{
        index = Math.abs(index);
        if (index < this.lenght) {
            if (index == 1) {
                NodeTransaccion temp = head;
                temp = head.getNext();
                head.setNext(null);
                this.head = temp;
                this.lenght--;
            }else{
                NodeTransaccion temp = head;
                int i = 1;
                while (temp.getNext()!= null  && i != this.lenght -1 ) {
                    temp = temp.getNext();
                    i++;
                }
                NodeTransaccion remove = temp.getNext();
                NodeTransaccion next = temp.getNext();
                temp.setNext(next);
                remove.setNext(null);
            }
            throw new Exception("Panita la cagaste en la posición");
        }
    }

    public NodeTransaccion searchPerIndex(int index) throws Exception{
        index = Math.abs(index);
        if (index<=this.lenght && index != 0) {
            NodeTransaccion node = head;
            int i = 1;
            while (i != index && node.getNext() != null) {
                node = node.getNext();
                i++;
            }
            return node;

        }
        throw new Exception("Panita la cagaste en la posición");
    }

    public NodeTransaccion getHead() {
        return head;
    }

    public void setHead(NodeTransaccion head) {
        this.head = head;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
