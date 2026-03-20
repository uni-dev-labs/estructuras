package lista_enlazada;

import java.util.Scanner;
import lista_enlazada.models.Transaccion;

public class MenuSimple {

    ListaEnlazadaSimpleMenu lista = new ListaEnlazadaSimpleMenu();
    Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int opt;

        do {
            System.out.println("\n--- MENU BANCO ---");
            System.out.println("1. Registrar transacción");
            System.out.println("2. Consultar transacción por ID");
            System.out.println("3. Ver todas las transacciones");
            System.out.println("4. Eliminar transacción");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opt = Integer.parseInt(sc.nextLine());

            switch (opt) {
                case 1:
                    Transaccion t = pedirDatosTransaccion();
                    lista.insertarAlFinal(t);
                    System.out.println("Transacción registrada.");
                    break;

                case 2:
                    System.out.print("Ingrese ID: ");
                    Long id = Long.parseLong(sc.nextLine());

                    if (!lista.contiene(id)) {
                        System.out.println("No existe esa transacción.");
                    } else {
                        int pos = lista.buscar(id);
                        System.out.println(lista.obtenerEnPosicion(pos));
                    }
                    break;

                case 3:
                    if (lista.size() == 0) {
                        System.out.println("No hay transacciones.");
                    } else {
                        lista.imprimir();
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID a eliminar: ");
                    Long idEliminar = Long.parseLong(sc.nextLine());

                    if (!lista.contiene(idEliminar)) {
                        System.out.println("No existe esa transacción.");
                    } else {
                        lista.eliminarPorId(idEliminar);
                        System.out.println("Transacción eliminada.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opt != 0);
    }

    public Transaccion pedirDatosTransaccion() {
        System.out.print("ID: ");
        Long id = Long.parseLong(sc.nextLine());

        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        System.out.print("Cuenta origen: ");
        String origen = sc.nextLine();

        System.out.print("Cuenta destino: ");
        String destino = sc.nextLine();

        return new Transaccion(id, valor, origen, destino);
    }
}