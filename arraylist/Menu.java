package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Transporte> transportes = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENU CRUD TRANSPORTES =====");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Mostrar transportes");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    añadir();
                    break;
                case 2:
                    leer();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }

    // MÉTODO PARA AÑADIR TRANSPORTE
    public static void añadir() {
        System.out.println("\nTipo de transporte:");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");
        int tipo = leerEntero();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = leerEntero();

        if (tipo == 1) {
            System.out.print("Tipo de vía: ");
            String via = sc.nextLine();

            System.out.print("Número de ruedas: ");
            int ruedas = leerEntero();

            transportes.add(new Terrestre(nombre, "Terrestre", via, capacidad, ruedas));

        } else if (tipo == 2) {
            System.out.print("Eslora: ");
            double eslora = leerDouble();

            System.out.print("Calado: ");
            int calado = leerEntero();

            transportes.add(new Maritimo(nombre, "Marítimo", capacidad, eslora, calado));

        } else if (tipo == 3) {
            System.out.print("Envergadura: ");
            double envergadura = leerDouble();

            System.out.print("Altura máxima: ");
            int altura = leerEntero();

            transportes.add(new Aereo(nombre, "Aéreo", capacidad, envergadura, altura));

        } else {
            System.out.println("Tipo inválido");
            return;
        }

        System.out.println("Transporte agregado correctamente.");
    }

    // MÉTODO PARA LEER TRANSPORTES
    public static void leer() {
        if (transportes.isEmpty()) {
            System.out.println("No hay transportes registrados");
            return;
        }

        System.out.println("\n--- LISTA DE TRANSPORTES ---");
        for (int i = 0; i < transportes.size(); i++) {
            Transporte t = transportes.get(i);

            String info = i + " - Nombre: " + t.getNombre() + " | Medio: " + t.getMedio() +
                          " | Capacidad: " + t.getCapacidad();

            if (t instanceof Terrestre terrestre) {
                info += " | Tipo vía: " + terrestre.getTipo() + " | Ruedas: " + terrestre.getNumero_ruedas();
            } else if (t instanceof Maritimo maritimo) {
                info += " | Eslora: " + maritimo.getEslora() + " | Calado: " + maritimo.getCalado();
            } else if (t instanceof Aereo aereo) {
                info += " | Envergadura: " + aereo.getEnvergadura() + " | Altura: " + aereo.getAltura_max();
            }

            System.out.println(info);
        }
    }

    // MÉTODO PARA ACTUALIZAR TRANSPORTE
    public static void actualizar() {
        leer();
        if (transportes.isEmpty()) return;

        System.out.print("Posición a modificar: ");
        int pos = leerEntero();

        if (pos < 0 || pos >= transportes.size()) {
            System.out.println("Posición no válida");
            return;
        }

        Transporte t = transportes.get(pos);

        System.out.print("Nuevo nombre: ");
        t.setNombre(sc.nextLine());

        System.out.print("Nueva capacidad: ");
        t.setCapacidad(leerEntero());

        if (t instanceof Terrestre terrestre) {
            System.out.print("Nuevo tipo de vía: ");
            terrestre.setTipo(sc.nextLine());
            System.out.print("Nuevo número de ruedas: ");
            terrestre.setNumero_ruedas(leerEntero());
        } else if (t instanceof Maritimo maritimo) {
            System.out.print("Nueva eslora: ");
            maritimo.setEslora(leerDouble());
            System.out.print("Nuevo calado: ");
            maritimo.setCalado(leerEntero());
        } else if (t instanceof Aereo aereo) {
            System.out.print("Nueva envergadura: ");
            aereo.setEnvergadura(leerDouble());
            System.out.print("Nueva altura máxima: ");
            aereo.setAltura(leerEntero());
        }

        System.out.println("Transporte actualizado correctamente.");
    }

    // MÉTODO PARA ELIMINAR TRANSPORTE
    public static void eliminar() {
        leer();
        if (transportes.isEmpty()) return;

        System.out.print("Posición a eliminar: ");
        int pos = leerEntero();

        if (pos < 0 || pos >= transportes.size()) {
            System.out.println("Posición no válida");
            return;
        }

        transportes.remove(pos);
        System.out.println("Transporte eliminado correctamente.");
    }

    // MÉTODOS AUXILIARES PARA LEER NÚMEROS DE FORMA SEGURA
    public static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número entero: ");
            }
        }
    }

    public static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número decimal: ");
            }
        }
    }

    public static void iniciarMenu() {
        
    }
}
