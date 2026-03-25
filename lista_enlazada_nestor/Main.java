package lista_enlazada_nestor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion = 0;

        do {
            System.out.println("\n1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Monto: ");
                    double monto = sc.nextDouble();
                    lista.insertar(id, monto);
                    break;

                case 2:
                    lista.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    lista.buscar(idBuscar);
                    break;

                case 4:
                    System.out.print("Ingrese ID a actualizar: ");
                    int idActualizar = sc.nextInt();
                
                    System.out.print("Nuevo monto: ");
                    double nuevoMonto = sc.nextDouble();
                
                    lista.actualizar(idActualizar, nuevoMonto);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        sc.close();
    }
}