package lista_enlazada.entities;

import java.util.Scanner;

public class MenuLinkedList {
    public static void main(String[] args) throws Exception {
        MenuLinkedList.menu();
    }
    private static Scanner sc = new Scanner(System.in);
    private static void menu() throws Exception{
        
        int i;
        ListaEnlazadaTransaccion listaEnlazada = new ListaEnlazadaTransaccion();
        do{
            System.out.println("1. Agregar ");
            System.out.println("2. Eliminar ");
            System.out.println("3. Buscar ");
            System.out.println("4. Mostrar");
            System.out.println("0. Salir");
            i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    agregar(listaEnlazada);
                    break;
                case 2:
                    Eliminar(listaEnlazada);
                    break;
                case 3:
                    System.out.println("dame indice para buscar");
                    int index = Integer.parseInt(sc.nextLine());
                    NodeTransaccion node = listaEnlazada.searchPerIndex(index);
                    Transaccion transaccion = node.getValue();
                    System.out.println(transaccion);
                    break;
                case 4:
                    NodeTransaccion head = listaEnlazada.getHead();
                    if(head!= null){
                        System.out.println(head);
                    }else{
                        System.out.println("no hay Data");
                    }
                    break;
            
                default:
                    break;
            }
        }
        while (i !=0);
            
        
    }
    private static void agregar(ListaEnlazadaTransaccion listaEnlazada) throws Exception{
        int i;

            System.out.println("1. Agregar al inicio ");
            System.out.println("2. Agregar al final ");
            System.out.println("3. Agregar por índice ");
            i = Integer.parseInt(sc.nextLine());
            System.out.println("Ingresa el monto de la transacción: ");
            double monto = Double.parseDouble(sc.nextLine());
            System.out.println("Ingresa el número de cuenta: ");
            String numeroCuenta = sc.nextLine();
            Transaccion transaccion = new Transaccion(monto, numeroCuenta);
            switch (i) {
                case 1:
                    listaEnlazada.addFirstTrans(transaccion);
                    break;
                case 2:
                    listaEnlazada.addLastTrans(transaccion);
                    break;
                case 3:
                    System.out.println("Ingresa el índice: ");
                    int index = Integer.parseInt(sc.nextLine());
                    listaEnlazada.addForIndexTrans(transaccion, index);
                    break;
            
                default:
                    break;
            }
    }
    public static void Eliminar(ListaEnlazadaTransaccion listaEnlazada) throws Exception{
        int i;

            System.out.println("1. Eliminar al inicio ");
            System.out.println("2. Eliminar al final ");
            System.out.println("3. Eliminar por índice ");
            i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    listaEnlazada.removeFirstTrans();
                    break;
                case 2:
                    listaEnlazada.removeLastTrans();
                    break;
                case 3:
                    System.out.println("Ingresa el índice: ");
                    int index = Integer.parseInt(sc.nextLine());
                    listaEnlazada.removeForIndexTrans(index);
                    break;
            
                default:
                    System.out.println("panita, panita la cagaste al escribir, capas el error esta entre la silla y el computador");
                    break;
            }
    }
}
