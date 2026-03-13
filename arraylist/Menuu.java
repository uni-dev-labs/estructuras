//Menu para gestionar transportes terrestres, marítimos y aéreos usando ArrayList. Permite añadir, listar, modificar y eliminar elementos de cada categoría. Utiliza métodos auxiliares para leer enteros y mostrar menús específicos para cada tipo de transporte.git add .
package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menuu {

    public static void main(String[] args) {
        ArrayList<Terrestre> terrestres = new ArrayList<>();
        ArrayList<Maritimo>  maritimos  = new ArrayList<>();
        ArrayList<Aereo>     aereos     = new ArrayList<>();

        
        Main.llenarTransportesTerrestres(terrestres);
        Main.llenarTransportesMaritimos(maritimos);
        Main.llenarTransportesAereos(aereos);

        Scanner sc = new Scanner(System.in);
        int opcionCat;
        do {
            System.out.println("\n=== GESTIÓN DE TRANSPORTES ===");
            System.out.println("1. Terrestres");
            System.out.println("2. Marítimos");
            System.out.println("3. Aéreos");
            System.out.println("0. Salir");
            opcionCat = leerInt(sc, "Elige categoría: ");

            switch (opcionCat) {
                case 1 -> menuTerrestres(sc, terrestres);
                case 2 -> menuMaritimos(sc, maritimos);
                case 3 -> menuAereos(sc, aereos);
                case 0 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcionCat != 0);

        sc.close();
    }

    private static void menuTerrestres(Scanner sc, ArrayList<Terrestre> list) {
        int op;
        do {
            System.out.println("\n-- Terrestres --");
            System.out.println("1. Añadir");
            System.out.println("2. Listar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            op = leerInt(sc, "Opción: ");

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Medio: ");
                    String m = sc.nextLine();
                    System.out.print("Terreno: ");
                    String t = sc.nextLine();
                    int vel = leerInt(sc, "Velocidad: ");
                    int cap = leerInt(sc, "Capacidad: ");
                    list.add(new Terrestre(n, m, t, vel, cap));
                    System.out.println("Añadido.");
                }
                case 2 -> Main.printTransportesTerrestres(list);
                case 3 -> {
                    if (list.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    int idx = leerInt(sc, "Índice a modificar: ");
                    if (idx >= 0 && idx < list.size()) {
                        System.out.print("Nuevo nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Nuevo medio: ");
                        String m = sc.nextLine();
                        System.out.print("Nuevo terreno: ");
                        String t = sc.nextLine();
                        int vel = leerInt(sc, "Nueva velocidad: ");
                        int cap = leerInt(sc, "Nueva capacidad: ");
                        list.set(idx, new Terrestre(n, m, t, vel, cap));
                        System.out.println("Actualizado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 4 -> {
                    int idx = leerInt(sc, "Índice a eliminar: ");
                    if (idx >= 0 && idx < list.size()) {
                        list.remove(idx);
                        System.out.println("Eliminado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    private static void menuMaritimos(Scanner sc, ArrayList<Maritimo> list) {
        int op;
        do {
            System.out.println("\n-- Marítimos --");
            System.out.println("1. Añadir");
            System.out.println("2. Listar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            op = leerInt(sc, "Opción: ");

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Medio: ");
                    String m = sc.nextLine();
                    int cap = leerInt(sc, "Capacidad: ");
                    int vel = leerInt(sc, "Velocidad: ");
                    int calado = leerInt(sc, "Calado: ");
                    list.add(new Maritimo(n, m, cap, vel, calado));
                    System.out.println("Añadido.");
                }
                case 2 -> Main.printTransportesMaritimos(list);
                case 3 -> {
                    if (list.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    int idx = leerInt(sc, "Índice a modificar: ");
                    if (idx >= 0 && idx < list.size()) {
                        System.out.print("Nuevo nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Nuevo medio: ");
                        String m = sc.nextLine();
                        int cap = leerInt(sc, "Nueva capacidad: ");
                        int vel = leerInt(sc, "Nueva velocidad: ");
                        int calado = leerInt(sc, "Nuevo calado: ");
                        list.set(idx, new Maritimo(n, m, cap, vel, calado));
                        System.out.println("Actualizado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 4 -> {
                    int idx = leerInt(sc, "Índice a eliminar: ");
                    if (idx >= 0 && idx < list.size()) {
                        list.remove(idx);
                        System.out.println("Eliminado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    private static void menuAereos(Scanner sc, ArrayList<Aereo> list) {
        int op;
        do {
            System.out.println("\n-- Aéreos --");
            System.out.println("1. Añadir");
            System.out.println("2. Listar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            op = leerInt(sc, "Opción: ");

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Medio: ");
                    String m = sc.nextLine();
                    int cap = leerInt(sc, "Capacidad: ");
                    int vel = leerInt(sc, "Velocidad: ");
                    int alt = leerInt(sc, "Altura máxima: ");
                    list.add(new Aereo(n, m, cap, vel, alt));
                    System.out.println("Añadido.");
                }
                case 2 -> Main.printTransportesAereos(list);
                case 3 -> {
                    if (list.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    int idx = leerInt(sc, "Índice a modificar: ");
                    if (idx >= 0 && idx < list.size()) {
                        System.out.print("Nuevo nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Nuevo medio: ");
                        String m = sc.nextLine();
                        int cap = leerInt(sc, "Nueva capacidad: ");
                        int vel = leerInt(sc, "Nueva velocidad: ");
                        int alt = leerInt(sc, "Nueva altura: ");
                        list.set(idx, new Aereo(n, m, cap, vel, alt));
                        System.out.println("Actualizado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 4 -> {
                    int idx = leerInt(sc, "Índice a eliminar: ");
                    if (idx >= 0 && idx < list.size()) {
                        list.remove(idx);
                        System.out.println("Eliminado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    private static int leerInt(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Debe ser un número. " + mensaje);
        }
        int v = sc.nextInt();
        sc.nextLine(); // consume salto de línea
        return v;
    }
}
