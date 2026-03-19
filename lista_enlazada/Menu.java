package lista_enlazada;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ListaTransacciones lista = new ListaTransacciones();

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar inicio");
            System.out.println("5. Eliminar final");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    lista.mostrar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    lista.eliminarInicio();
                    break;
                case 5:
                    lista.eliminarFinal();
                    break;
            }

        } while (opcion != 0);
    }

    public void agregar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        lista.agregar(new Transaccion(id, tipo, monto));
    }

    public void buscar() {
        System.out.print("Posición: ");
        int posicion = sc.nextInt();

        NodoTransaccion nodo = lista.buscar(posicion);

        if (nodo != null) {
            nodo.dato.mostrar();
        } else {
            System.out.println("No encontrado");
        }
    }
}