package arraylist.models;

import java.util.Scanner;

public class Menu {

    public static void iniciarMenu(
            ListaEnlazada<Terrestre> terrestres,
            ListaEnlazada<Maritimo> maritimos,
            ListaEnlazada<Aereo> aereos) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU CRUD TRANSPORTES =====");
            System.out.println("1. Agregar transporte");
            System.out.println("2. Mostrar transportes");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\nTipo de transporte:");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    System.out.print("Seleccione tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Capacidad: ");
                    int capacidad = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Numero de ruedas: ");
                        int ruedas = sc.nextInt();
                        sc.nextLine();

                        terrestres.agregar(
                                new Terrestre(nombre, "Terrestre", "carretera", capacidad, ruedas));

                    } else if (tipo == 2) {
                        System.out.print("Tipo maritimo: ");
                        String tipoMar = sc.nextLine();

                        maritimos.agregar(
                                new Maritimo(nombre, "Maritimo", tipoMar, capacidad));

                    } else if (tipo == 3) {
                        System.out.print("Tipo aereo: ");
                        String tipoAer = sc.nextLine();

                        aereos.agregar(
                                new Aereo(nombre, "Aereo", tipoAer, capacidad));
                    } else {
                        System.out.println("Tipo invalido");
                    }

                    break;

                case 2:
                    System.out.println("\n--- TERRESTRES ---");
                    terrestres.mostrar();

                    System.out.println("\n--- MARITIMOS ---");
                    maritimos.mostrar();

                    System.out.println("\n--- AEREOS ---");
                    aereos.mostrar();
                    break;

                case 3:
                    System.out.println("\nQue lista desea actualizar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    System.out.print("Seleccione tipo: ");
                    int tipoAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Posicion a actualizar: ");
                    int posAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nueva capacidad: ");
                    int nuevaCapacidad = sc.nextInt();
                    sc.nextLine();

                    if (tipoAct == 1) {
                        System.out.print("Numero de ruedas: ");
                        int nuevasRuedas = sc.nextInt();
                        sc.nextLine();

                        terrestres.actualizar(
                                posAct,
                                new Terrestre(nuevoNombre, "Terrestre", "carretera", nuevaCapacidad, nuevasRuedas));

                    } else if (tipoAct == 2) {
                        System.out.print("Nuevo tipo maritimo: ");
                        String nuevoTipoMar = sc.nextLine();

                        maritimos.actualizar(
                                posAct,
                                new Maritimo(nuevoNombre, "Maritimo", nuevoTipoMar, nuevaCapacidad));

                    } else if (tipoAct == 3) {
                        System.out.print("Nuevo tipo aereo: ");
                        String nuevoTipoAer = sc.nextLine();

                        aereos.actualizar(
                                posAct,
                                new Aereo(nuevoNombre, "Aereo", nuevoTipoAer, nuevaCapacidad));
                    } else {
                        System.out.println("Tipo invalido");
                    }

                    break;

                case 4:
                    System.out.println("\nDe que lista desea eliminar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    System.out.print("Seleccione tipo: ");
                    int tipoElim = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Posicion a eliminar: ");
                    int posElim = sc.nextInt();
                    sc.nextLine();

                    if (tipoElim == 1) {
                        terrestres.eliminar(posElim);
                    } else if (tipoElim == 2) {
                        maritimos.eliminar(posElim);
                    } else if (tipoElim == 3) {
                        aereos.eliminar(posElim);
                    } else {
                        System.out.println("Tipo invalido");
                    }

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