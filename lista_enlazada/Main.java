package lista_enlazada;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Insertar al final");
            System.out.println("2. Insertar al inicio");
            System.out.println("3. Buscar transacción");
            System.out.println("4. Eliminar transacción");
            System.out.println("5. Ver historial");
            System.out.println("6. Limpiar historial");
            System.out.println("7. Actualizar transacción");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:
                    lista.insertarAlFinal(crearTransaccion(leer));
                    break;

                case 2:
                    lista.insertarAlInicio(crearTransaccion(leer));
                    break;

                case 3:
                    System.out.print("Descripción a buscar: ");
                    String buscar = leer.nextLine();
                    int pos = lista.buscar(buscar);

                    if (pos != -1) {
                        System.out.println("Encontrada en posición: " + pos);
                    } else {
                        System.out.println("No encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Descripción a eliminar: ");
                    lista.eliminarPorValor(leer.nextLine());
                    System.out.println("Proceso realizado.");
                    break;

                case 5:
                    lista.imprimir();
                    break;

                case 6:
                    lista.limpiar();
                    System.out.println("Historial eliminado.");
                    break;

                case 7:
                    System.out.print("Descripción a actualizar: ");
                    String desc = leer.nextLine();

                    boolean actualizado = lista.actualizar(desc, crearTransaccion(leer));

                    if (actualizado) {
                        System.out.println("Transacción actualizada.");
                    } else {
                        System.out.println("No se encontró la transacción.");
                    }
                    break;
            }

        } while (opcion != 8);

        System.out.println("Programa terminado.");
        leer.close();
    }

    public static Transaccion crearTransaccion(Scanner sc) {
        System.out.print("Monto: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        System.out.print("Fecha (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        return new Transaccion(monto, desc, fecha);
    }
}