package lista_enlazada;

import lista_enlazada.models.Transaccion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        int opcion;

        do {
            System.out.println("\n===== MENÚ CRUD =====");
            System.out.println("1. Agregar transacción");
            System.out.println("2. Mostrar transacciones");
            System.out.println("3. Actualizar transacción");
            System.out.println("4. Eliminar transacción");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese descripción: ");
                    String desc = sc.nextLine();

                    System.out.print("Ingrese monto: ");
                    double monto = sc.nextDouble();

                    lista.agregar(new Transaccion(id, desc, monto));
                    System.out.println("✅ Transacción agregada");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TRANSACCIONES ---");
                    lista.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese ID a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nueva descripción: ");
                    String nuevaDesc = sc.nextLine();

                    System.out.print("Nuevo monto: ");
                    double nuevoMonto = sc.nextDouble();

                    lista.actualizar(idAct, nuevaDesc, nuevoMonto);
                    break;

                case 4:
                    System.out.print("Ingrese ID a eliminar: ");
                    int idElim = sc.nextInt();

                    lista.eliminar(idElim);
                    System.out.println("🗑️ Transacción eliminada (si existía)");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
}