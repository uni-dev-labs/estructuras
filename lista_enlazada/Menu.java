package lista_enlazada;

import java.util.Scanner;
import lista_enlazada.models.*;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaTransacciones lista = new ListaTransacciones();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar transacción");
            System.out.println("2. Mostrar transacciones");
            System.out.println("3. Eliminar por ID");
            System.out.println("4. Contar transacciones"); // opción nueva
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Tipo (ingreso/gasto): ");
                    String tipo = sc.next();
                    System.out.print("Monto: ");
                    double monto = sc.nextDouble();
                    Transaccion t = new Transaccion(id, tipo, monto);
                    System.out.print("Detalle: ");
                    sc.nextLine(); // limpiar buffer
                    String detalle = sc.nextLine();
                    t.setDetalle(detalle);
                    lista.insertarAlFinal(t);
                    break;
                case 2:
                    lista.imprimir();
                    break;
                case 3:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = sc.nextInt();
                    lista.eliminarPorId(idEliminar);
                    break;
                case 4:
                    System.out.println("Total de transacciones: " + lista.contar());
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}