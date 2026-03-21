package lista_enlazada;

import java.util.Scanner;

public class MenuListas {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        Menu();
    }

    private static void Menu() throws Exception {
        int opcion;

        ListaEnlazadaTransaccion lista = new ListaEnlazadaTransaccion();

        do {
            System.out.println("Menu Transaccion");
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar lista completa");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    menuAgregar(lista);
                    break;
                case 2:
                    menuEliminar(lista);
                    break;
                case 3:
                    System.out.print("Ingrese el índice a buscar: ");
                    int index = Integer.parseInt(sc.nextLine());
                    Node nodoEncontrado = lista.BuscarPorIndex(index);
                    System.out.println("Transacción encontrada: " + nodoEncontrado.getValue());
                    break;
                case 4:
                    mostrarLista(lista);
                    break;
                case 0:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuAgregar(ListaEnlazadaTransaccion lista) throws Exception {
        System.out.println("Opcion Agregar");
        System.out.println("1. Al inicio");
        System.out.println("2. Al final");
        System.out.println("3. En posición específica");
        int subOpcion = Integer.parseInt(sc.nextLine());

        System.out.print("Monto: ");
        double monto = Double.parseDouble(sc.nextLine());
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        
        Transaccion trans = new Transaccion(monto, cuenta);

        switch (subOpcion) {
            case 1: 
            lista.agregarPrimeraTransaccion(trans);
            break;
            case 2: 
            lista.agregarUltimaTransaccion(trans);
            break;
            case 3:
                System.out.print("¿En qué Indice?: ");
                int idx = Integer.parseInt(sc.nextLine());
                lista.agregarIndexTransaccion(trans, idx);
            break;
            default: 
            System.out.println("Subopción inválida.");
            break;
        }
    }

    private static void menuEliminar(ListaEnlazadaTransaccion lista) throws Exception {
        System.out.println("Opcion Eliminar");
        System.out.println("1. El primero");
        System.out.println("2. El último");
        System.out.println("3. Por índice");
        int subOpcion = Integer.parseInt(sc.nextLine());

        switch (subOpcion) {
            case 1: 
            lista.eliminarPrimeraTransaccion();
            break;
            case 2: 
            lista.eliminarUltimaTransaccion();
            break;
            case 3: 
                System.out.print("¿Indice a borrar?: ");
                int idx = Integer.parseInt(sc.nextLine());
                lista.eliminarIndexTransaccion(idx);
            break;
            default:
                System.out.println("Opción no existe.");
                break;
        }
    }

    private static void mostrarLista(ListaEnlazadaTransaccion lista) {
        Node temp = lista.getHead();
        if (temp == null) {
            System.out.println("La lista esta vacia");
            return;
        }
        System.out.println("Lista Transacciones");
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.getValue());
            temp = temp.getNext();
            i++;
        }
        System.out.println("Total: " + lista.getlength() + " transacciones.");
    }
}