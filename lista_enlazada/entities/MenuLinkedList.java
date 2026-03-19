package lista_enlazada.entities;

import java.util.Scanner;

public class MenuLinkedList {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        MenuLinkedList.menu();
    }

    public static void menu() throws Exception {
        int i;
        LinkedListTransaccion linkedList = new LinkedListTransaccion();
        do {
            System.out.println("agregar 1");
            System.out.println("eliminar 2");
            System.out.println("buscar 3");
            System.out.println("muestra 4");
            System.out.println("salir 0");
            i = Integer.parseInt(scanner.next());
            switch (i) {
                case 1:
                    menuAdd(linkedList);
                    break;
                case 2:
                    menuRemove(linkedList);
                    break;
                case 3:
                    System.out.println("dame indice para buscar");
                    int index = Integer.parseInt(scanner.next());    
                    NodeTransaccion node = linkedList.searchForIndexTransaccion(index);
                    Transaccion transaccion = node.getValue();
                    System.out.println(transaccion);
                    break;
                case 4:
                    NodeTransaccion head = linkedList.getHead();
                    if(head!= null){
                        System.out.println(head);
                    }else{
                        System.out.println("no hay Data");
                    }
                    break;
                default:
                    break;
            }
        } while (i != 0);
    }
    private static void menuAdd(LinkedListTransaccion linkedListTransaccion) throws Exception{
        
            System.out.println("agregar al inicio 1");
            System.out.println("agregar al final 2");
            System.out.println("agregar por indice 3");
            int i = Integer.parseInt(scanner.next());
            System.out.println("dame monto");
            double monto = Double.parseDouble(scanner.next());
            System.out.println("dame numero de cuenta");
            String numCuenta = scanner.next();
            Transaccion transaccion = new Transaccion(monto, numCuenta);
            switch (i) {
                case 1:
                    linkedListTransaccion.addFirstTransaccion(transaccion);
                    break;
                case 2:
                    linkedListTransaccion.addLastTransaccion(transaccion);
                    break;
                case 3:
                    System.out.println("dame el index");
                    int index = Integer.parseInt(scanner.next());
                    linkedListTransaccion.addForIndexTransaccion(transaccion, index);
                    break;
                default:
                    System.out.println("invalido no se completo");
                    break;
            }
    }
    public static void menuRemove(LinkedListTransaccion linkedListTransaccion) throws Exception{
        System.out.println("remover inicio 1");
        System.out.println("remover final 2");
        System.out.println("remover por indice 3");
        int i = Integer.parseInt(scanner.next());
        switch (i) {
            case 1:
                linkedListTransaccion.removeFirstTransaccion();
                break;
            case 2:
                linkedListTransaccion.removeLastTransaccion();
                break;
            case 3:
                System.out.println("dame indice");
                int index = Integer.parseInt(scanner.next());
                linkedListTransaccion.removeForIndexTransaccion(index);
                break;
            default:
                System.out.println("invalido no se hace nada");
                break;
        }

    }

}
