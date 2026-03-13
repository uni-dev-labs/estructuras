package arraylist;

<<<<<<< HEAD
public class Menu {
    public static void main(String[] args) {
        System.out.println("1. Agregar un nombre");
        System.out.println("2. Eliminar un nombre");
        System.out.println("3. Buscar un nombre");
        System.out.println("4. Mostrar todos los nombres");
        System.out.println("5. Salir");
    }
=======
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
            System.out.println("2. Leer transportes");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

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
    }

    // AÑADIR

    public static void añadir() {

        System.out.println("\nTipo de transporte:");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();

        if (tipo == 1) {

            sc.nextLine();

            System.out.print("Tipo de vía: ");
            String via = sc.nextLine();

            System.out.print("Número de ruedas: ");
            int ruedas = sc.nextInt();

            transportes.add(new Terrestre(nombre, "Terrestre", via, capacidad, ruedas));
        }

        else if (tipo == 2) {

            System.out.print("Eslora: ");
            double eslora = sc.nextDouble();

            System.out.print("Calado: ");
            int calado = sc.nextInt();

            transportes.add(new Maritimo(nombre, "Maritimo", capacidad, eslora, calado));
        }

        else if (tipo == 3) {

            System.out.print("Envergadura: ");
            double envergadura = sc.nextDouble();

            System.out.print("Altura máxima: ");
            int altura = sc.nextInt();

            transportes.add(new Aereo(nombre, "Aereo", capacidad, envergadura, altura));
        }

        System.out.println("Transporte agregado correctamente");
    }

    // LEER

    public static void leer() {

        if (transportes.isEmpty()) {

            System.out.println("No hay transportes registrados");

        } else {

            System.out.println("\n--- LISTA DE TRANSPORTES ---");

            for (int i = 0; i < transportes.size(); i++) {

                Transporte t = transportes.get(i);

                System.out.println(i + " - Nombre: " + t.getNombre()
                        + " | Medio: " + t.getMedio()
                        + " | Capacidad: " + t.getCapacidad());
            }
        }
    }

    // ACTUALIZAR

    public static void actualizar() {

        leer();

        if (transportes.isEmpty()) {
            return;
        }

        System.out.print("Posición a modificar: ");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos >= 0 && pos < transportes.size()) {

            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();

            Transporte t = transportes.get(pos);
            t.setNombre(nombre); // solo cambia el nombre

            System.out.println("Transporte actualizado");

        } else {

            System.out.println("Posición no válida");
        }
    }

    // ELIMINAR

    public static void eliminar() {

        leer();

        if (transportes.isEmpty()) {
            return;
        }

        System.out.print("Posición a eliminar: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < transportes.size()) {

            transportes.remove(pos);

            System.out.println("Transporte eliminado");

        } else {

            System.out.println("Posición no válida");
        }
    }

    public static void iniciarMenu() {
        
    }

>>>>>>> d3eaf0c (CRUD menu transportes)
}
