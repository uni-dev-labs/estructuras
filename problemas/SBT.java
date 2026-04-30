package problemas;
public class SBT {
private Node root;
public void addData(int data) throws Exception{

        root=addElement(data,this.root);
}
private Node addElement(int data, Node node) throws Exception{
    if (node == null) {
        return new Node(data);
    }
    else{
        if(node.getData()>data)
            node.setLeft(addElement(data, node.getLeft()));
        else if (node.getData()<data) 
            node.setRight(addElement(data, node.getRight()));
        else
            throw new  Exception("yo no acepto duplicados papi va en contra de las reglas");
        return node;
    }
    
}
public void inOrderPrint(){
    inOrden(root);
}
public void postOrdenPrint(){
    postOrden(root);
}
public void preOrdenPrint(){
    preOrden(root);
}
private void inOrden(Node node){
    if(node !=null){
        inOrden(node.getLeft());
        System.out.println(node.getData());
        inOrden(node.getRight());
    }
}
private void postOrden(Node node){
    if(node != null){
        postOrden(node.getLeft());
        postOrden(node.getRight());
        System.out.println(node.getData());
    }
}
private void preOrden(Node node){
    if(node !=null){
        System.out.println(node.getData());
        preOrden(node.getLeft());
        preOrden(node.getRight());

    }
}
}
