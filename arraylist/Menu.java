package arraylist;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Terrestre> terrestres = new ArrayList<>();
        ArrayList<Maritimo> maritimos = new ArrayList<>();
        ArrayList<Aereo> aereos = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("*********** MENU CRUD ***********");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Buscar transporte");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            int tipo = menuTipo();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    if (tipo == 1) {

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Tipo via: ");
                        String via = sc.nextLine();

                        System.out.print("Capacidad: ");
                        int cap = sc.nextInt();

                        System.out.print("Ruedas: ");
                        int ruedas = sc.nextInt();
                        sc.nextLine();

                        Terrestre t = new Terrestre(nombre, "Terrestre", via, cap, ruedas);
                        terrestres.add(t);
                    }

                    if (tipo == 2) {

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Capacidad: ");
                        int cap = sc.nextInt();

                        System.out.print("Eslora: ");
                        double eslora = sc.nextDouble();

                        System.out.print("Calado: ");
                        int calado = sc.nextInt();
                        sc.nextLine();

                        Maritimo m = new Maritimo(nombre, "Maritimo", cap, eslora, calado);
                        maritimos.add(m);
                    }

                    if (tipo == 3) {

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Capacidad: ");
                        int cap = sc.nextInt();

                        System.out.print("Envergadura: ");
                        double env = sc.nextDouble();

                        System.out.print("Altura max: ");
                        int alt = sc.nextInt();
                        sc.nextLine();

                        Aereo a = new Aereo(nombre, "Aereo", cap, env, alt);
                        aereos.add(a);
                    }

                    break;

                case 2:

                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();

                    Transporte encontrado = null;

                    if (tipo == 1) {
                        for (Terrestre t : terrestres) {
                            if (t.getNombre().equalsIgnoreCase(buscar)) {
                                encontrado = t;
                            }
                        }
                    }

                    if (tipo == 2) {
                        for (Maritimo m : maritimos) {
                            if (m.getNombre().equalsIgnoreCase(buscar)) {
                                encontrado = m;
                            }
                        }
                    }

                    if (tipo == 3) {
                        for (Aereo a : aereos) {
                            if (a.getNombre().equalsIgnoreCase(buscar)) {
                                encontrado = a;
                            }
                        }
                    }

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Transporte no encontrado");
                    }

                    break;

                case 3:

                    System.out.print("Posicion a modificar: ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevo = sc.nextLine();

                    if (tipo == 1) {
                        terrestres.get(pos).setNombre(nuevo);
                    }

                    if (tipo == 2) {
                        maritimos.get(pos).setNombre(nuevo);
                    }

                    if (tipo == 3) {
                        aereos.get(pos).setNombre(nuevo);
                    }

                    break;

                case 4:

                    System.out.print("Posicion a eliminar: ");
                    int eliminar = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        terrestres.remove(eliminar);
                    }

                    if (tipo == 2) {
                        maritimos.remove(eliminar);
                    }

                    if (tipo == 3) {
                        aereos.remove(eliminar);
                    }

                    break;

                case 0:
                    System.out.println("Saliendo del programa");
                    break;
            }
        }
    }

    public static int menuTipo() {

        System.out.println("1. Terrestre");
        System.out.println("2. Maritimo");
        System.out.println("3. Aereo");
        System.out.print("Seleccione tipo: ");

        return sc.nextInt();
    }
}
