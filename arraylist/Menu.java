package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // listas de ejemplo
        ArrayList<Terrestre> terrestres = new ArrayList<>();
        ArrayList<Maritimo> maritimos = new ArrayList<>();
        ArrayList<Aereo> aereos = new ArrayList<>();

        // poblar con algunos valores iniciales usando los métodos de Main
        Main.llenarTransportesTerrestres(terrestres);
        Main.llenarTransportesMaritimos(maritimos);
        Main.llenarTransportesAereos(aereos);

        do {
            System.out.println("Menú:");
            System.out.println("1. Crear");
            System.out.println("2. Buscar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Mostrar listas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir salto de línea

            switch (opcion) {
                case 1:
                    handleCreate(scanner, terrestres, maritimos, aereos);
                    break;
                case 2:
                    handleSearch(scanner, terrestres, maritimos, aereos);
                    break;
                case 3:
                    handleUpdate(scanner, terrestres, maritimos, aereos);
                    break;
                case 4:
                    handleDelete(scanner, terrestres, maritimos, aereos);
                    break;
                case 5:
                    Main.printTransportesTerrestres(terrestres);
                    Main.printTransportesMaritimos(maritimos);
                    Main.printTransportesAereos(aereos);
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void handleCreate(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("¿Qué tipo de transporte desea crear?");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch(tipo) {
            case 1:
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Medio: ");
                String medio = scanner.nextLine();
                System.out.print("Tipo (carretera/rieles...): ");
                String tipoVeh = scanner.nextLine();
                System.out.print("Capacidad: ");
                int cap = scanner.nextInt();
                System.out.print("Número de ruedas: ");
                int ruedas = scanner.nextInt();
                scanner.nextLine();
                Terrestre t = new Terrestre(nombre, medio, tipoVeh, cap, ruedas);
                Main.añadirNuevoTransporte(terrestres.size(), terrestres, t);
                break;
            case 2:
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Medio: ");
                medio = scanner.nextLine();
                System.out.print("Capacidad: ");
                cap = scanner.nextInt();
                System.out.print("Eslora: ");
                double eslora = scanner.nextDouble();
                System.out.print("Calado: ");
                int calado = scanner.nextInt();
                scanner.nextLine();
                Maritimo m = new Maritimo(nombre, medio, cap, eslora, calado);
                Main.añadirNuevoTransporte(maritimos.size(), maritimos, m);
                break;
            case 3:
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Medio: ");
                medio = scanner.nextLine();
                System.out.print("Capacidad: ");
                cap = scanner.nextInt();
                System.out.print("Envergadura: ");
                double env = scanner.nextDouble();
                System.out.print("Altura máxima: ");
                int alt = scanner.nextInt();
                scanner.nextLine();
                Aereo a = new Aereo(nombre, medio, cap, env, alt);
                Main.añadirNuevoTransporte(aereos.size(), aereos, a);
                break;
            default:
                System.out.println("Tipo no válido");
        }
    }

    private static void handleSearch(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        Transporte encontrado = Main.obtenerObjetoPorNombre(nombre, terrestres);
        if(encontrado == null) encontrado = Main.obtenerObjetoPorNombre(nombre, maritimos);
        if(encontrado == null) encontrado = Main.obtenerObjetoPorNombre(nombre, aereos);
        if(encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre() + " - " + encontrado.getMedio()
                + " capacidad " + encontrado.getCapacidad());
        } else {
            System.out.println("No se encontró ningún transporte con ese nombre.");
        }
    }

    private static void handleUpdate(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("¿Qué lista desea actualizar?");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");
        System.out.print("Opción: ");
        int lista = scanner.nextInt();
        System.out.print("Posición a modificar: ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        switch(lista) {
            case 1:
                System.out.println("Ingrese nuevos datos para el transporte terrestre");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Medio: ");
                String medio = scanner.nextLine();
                System.out.print("Tipo: ");
                String tipoVeh = scanner.nextLine();
                System.out.print("Capacidad: ");
                int cap = scanner.nextInt();
                System.out.print("Número de ruedas: ");
                int ruedas = scanner.nextInt();
                scanner.nextLine();
                Terrestre t = new Terrestre(nombre, medio, tipoVeh, cap, ruedas);
                Main.ModificarObjetoPorPosicion(pos, terrestres, t);
                break;
            case 2:
                System.out.println("Ingrese nuevos datos para el transporte marítimo");
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Medio: ");
                medio = scanner.nextLine();
                System.out.print("Capacidad: ");
                cap = scanner.nextInt();
                System.out.print("Eslora: ");
                double eslora = scanner.nextDouble();
                System.out.print("Calado: ");
                int calado = scanner.nextInt();
                scanner.nextLine();
                Maritimo m = new Maritimo(nombre, medio, cap, eslora, calado);
                Main.ModificarObjetoPorPosicion(pos, maritimos, m);
                break;
            case 3:
                System.out.println("Ingrese nuevos datos para el transporte aéreo");
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Medio: ");
                medio = scanner.nextLine();
                System.out.print("Capacidad: ");
                cap = scanner.nextInt();
                System.out.print("Envergadura: ");
                double env = scanner.nextDouble();
                System.out.print("Altura máxima: ");
                int alt = scanner.nextInt();
                scanner.nextLine();
                Aereo a = new Aereo(nombre, medio, cap, env, alt);
                Main.ModificarObjetoPorPosicion(pos, aereos, a);
                break;
            default:
                System.out.println("Lista no válida");
        }
    }

    private static void handleDelete(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("¿Qué lista desea eliminar? (Seleccione un índice)");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");
        System.out.print("Opción: ");
        int lista = scanner.nextInt();
        System.out.print("Posición a eliminar: ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        switch(lista) {
            case 1:
                Main.eliminarObjetoPorPosicion(pos, terrestres);
                break;
            case 2:
                Main.eliminarObjetoPorPosicion(pos, maritimos);
                break;
            case 3:
                Main.eliminarObjetoPorPosicion(pos, aereos);
                break;
            default:
                System.out.println("Lista no válida");
        }
    }
}