package arraylist.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static List<Transporte> lista = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENU TRANSPORTES =====");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Buscar transporte");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Borrar transporte");
            System.out.println("5. Mostrar todos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> buscar();
                case 3 -> actualizar();
                case 4 -> borrar();
                case 5 -> mostrar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    static void agregar() {
        System.out.print("Nombre del transporte: ");
        String nombre = sc.nextLine();

        System.out.println("Medio:");
        System.out.println("1. Maritimo");
        System.out.println("2. Aereo");
        System.out.println("3. Terrestre");
        int med = sc.nextInt();
        sc.nextLine();

        String medio = switch (med) {
            case 1 -> "Maritimo";
            case 2 -> "Aereo";
            case 3 -> "Terrestre";
            default -> "Desconocido";
        };

        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        lista.add(new Transporte(nombre, medio, capacidad));
        System.out.println("Transporte agregado ✔");
    }

    static void buscar() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();

        for (Transporte t : lista) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + t);
                return;
            }
        }
        System.out.println("No encontrado ❌");
    }

    static void actualizar() {
        System.out.print("Nombre a actualizar: ");
        String nombre = sc.nextLine();

        for (Transporte t : lista) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {

                System.out.print("Nuevo nombre: ");
                t.setNombre(sc.nextLine());

                System.out.println("Nuevo medio (Maritimo/Aereo/Terrestre): ");
                t.setMedio(sc.nextLine());

                System.out.print("Nueva capacidad: ");
                t.setCapacidad(sc.nextInt());
                sc.nextLine();

                System.out.println("Actualizado ✔");
                return;
            }
        }
        System.out.println("No encontrado ❌");
    }

    static void borrar() {
        System.out.print("Nombre a borrar: ");
        String nombre = sc.nextLine();

        Iterator<Transporte> it = lista.iterator();

        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                System.out.println("Eliminado ✔");
                return;
            }
        }
        System.out.println("No encontrado ❌");
    }

    static void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay transportes");
            return;
        }

        for (Transporte t : lista) {
            System.out.println(t);
        }
    }
}
