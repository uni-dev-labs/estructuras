package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    public static void mostrarMenu(
            ArrayList<Terrestre> terrestres,
            ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        int tipo;

        do {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Crear transporte");
            System.out.println("2. Buscar transporte");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("5. Mostrar transportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 1 && opcion <= 4) {

                System.out.println("\nTipo de transporte:");
                System.out.println("1. Terrestre");
                System.out.println("2. Maritimo");
                System.out.println("3. Aereo");
                System.out.print("Seleccione tipo: ");

                tipo = sc.nextInt();
                sc.nextLine();

            } else {
                tipo = 0;
            }

            switch (opcion) {

                
                case 1:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    if (tipo == 1) {

                        terrestres.add(
                                new Terrestre(nombre, "Terrestre", "carretera", 4, 4));

                    } else if (tipo == 2) {

                        maritimos.add(
                                new Maritimo(nombre, "Maritimo", 100, 10, 2));

                    } else if (tipo == 3) {

                        aereos.add(
                                new Aereo(nombre, "Aereo", 500, 20, 2));

                    }

                    System.out.println("Transporte creado");
                    break;

                
                case 2:

                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();

                    if (tipo == 1) {

                        Terrestre t = Main.obtenerObjetoPorNombre(buscar, terrestres);
                        if (t != null)
                            System.out.println("Encontrado: " + t.getNombre());

                    } else if (tipo == 2) {

                        Maritimo m = Main.obtenerObjetoPorNombre(buscar, maritimos);
                        if (m != null)
                            System.out.println("Encontrado: " + m.getNombre());

                    } else if (tipo == 3) {

                        Aereo a = Main.obtenerObjetoPorNombre(buscar, aereos);
                        if (a != null)
                            System.out.println("Encontrado: " + a.getNombre());

                    }

                    break;

                
                case 3:

                    System.out.print("Posicion a actualizar: ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevo = sc.nextLine();

                    if (tipo == 1) {

                        Main.ModificarObjetoPorPosicion(
                                pos,
                                terrestres,
                                new Terrestre(nuevo, "Terrestre", "carretera", 4, 4));

                    } else if (tipo == 2) {

                        Main.ModificarObjetoPorPosicion(
                                pos,
                                maritimos,
                                new Maritimo(nuevo, "Maritimo", 100, 10, 2));

                    } else if (tipo == 3) {

                        Main.ModificarObjetoPorPosicion(
                                pos,
                                aereos,
                                new Aereo(nuevo, "Aereo", 500, 20, 2));

                    }

                    break;

                case 4:

                    System.out.print("Posicion a eliminar: ");
                    int eliminar = sc.nextInt();

                    if (tipo == 1)
                        Main.eliminarObjetoPorPosicion(eliminar, terrestres);

                    else if (tipo == 2)
                        Main.eliminarObjetoPorPosicion(eliminar, maritimos);

                    else if (tipo == 3)
                        Main.eliminarObjetoPorPosicion(eliminar, aereos);

                    break;

                
                case 5:

                    Main.printTransportesTerrestres(terrestres);
                    Main.printTransportesMaritimos(maritimos);
                    Main.printTransportesAereos(aereos);

                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }

        } while (opcion != 6);
        sc.close();
    }
}
