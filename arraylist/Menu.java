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

        ArrayList<Terrestre> terrestres = new ArrayList<>();
        ArrayList<Maritimo> maritimos = new ArrayList<>();
        ArrayList<Aereo> aereos = new ArrayList<>();

        Main.llenarTransportesTerrestres(terrestres);
        Main.llenarTransportesMaritimos(maritimos);
        Main.llenarTransportesAereos(aereos);

        do {
            System.out.println("\n==============================================");
            System.out.println("        SISTEMA DE GESTIÓN DE TRANSPORTE      ");
            System.out.println("==============================================");
            System.out.println("1. Crear Transporte");
            System.out.println("2. Buscar (Nombre o ID/Posición)");
            System.out.println("3. Actualizar por Posición");
            System.out.println("4. Eliminar por Posición");
            System.out.println("5. Listar Todo");
            System.out.println("0. Salir");
            System.out.println("----------------------------------------------");
            System.out.print("Seleccione una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    handleCreate(scanner, terrestres, maritimos, aereos);
                    pause(scanner);
                    break;
                case 2:
                    handleSearch(scanner, terrestres, maritimos, aereos);
                    pause(scanner);
                    break;
                case 3:
                    handleUpdate(scanner, terrestres, maritimos, aereos);
                    pause(scanner);
                    break;
                case 4:
                    handleDelete(scanner, terrestres, maritimos, aereos);
                    pause(scanner);
                    break;
                case 5:
                    Main.printTransportesTerrestres(terrestres);
                    Main.printTransportesMaritimos(maritimos);
                    Main.printTransportesAereos(aereos);
                    pause(scanner);
                    break;
                case 0:
                    System.out.println("\nFinalizando programa...");
                    break;
                default:
                    System.out.println("\n[!] Opción no válida.");
                    pause(scanner);
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void pause(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void handleCreate(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("\n--- CREAR NUEVO ---");
        System.out.println("1. Terrestre | 2. Marítimo | 3. Aéreo");
        System.out.print("Selección: ");
        int tipoSeleccionado = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del vehículo: ");
        String nombre = scanner.nextLine();

        switch(tipoSeleccionado) {
            case 1:
                System.out.print("Tipo de terreno (carretera/rieles): ");
                String terreno = scanner.nextLine();
                System.out.print("Capacidad de carga: ");
                int capT = scanner.nextInt();
                System.out.print("Número de ruedas: ");
                int ruedas = scanner.nextInt();
                scanner.nextLine();
                terrestres.add(new Terrestre(nombre, "Terrestre", terreno, capT, ruedas));
                System.out.println("[+] Terrestre agregado.");
                break;
            case 2:
                System.out.print("Capacidad: ");
                int capM = scanner.nextInt();
                System.out.print("Eslora: ");
                double eslora = scanner.nextDouble();
                System.out.print("Calado: ");
                int calado = scanner.nextInt();
                scanner.nextLine();
                maritimos.add(new Maritimo(nombre, "Maritimo", capM, eslora, calado));
                System.out.println("[+] Marítimo agregado.");
                break;
            case 3:
                System.out.print("Capacidad: ");
                int capA = scanner.nextInt();
                System.out.print("Envergadura: ");
                double env = scanner.nextDouble();
                System.out.print("Altura máxima: ");
                int alt = scanner.nextInt();
                scanner.nextLine();
                aereos.add(new Aereo(nombre, "Aereo", capA, env, alt));
                System.out.println("[+] Aéreo agregado.");
                break;
            default:
                System.out.println("[!] Tipo no válido.");
        }
    }

    private static void handleSearch(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("\n--- BUSCAR TRANSPORTE ---");
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por ID (Posición)");
        System.out.print("Opción: ");
        int modo = scanner.nextInt();
        scanner.nextLine();

        if (modo == 1) {
            System.out.print("Ingrese nombre: ");
            String nombre = scanner.nextLine();
            Transporte encontrado = Main.obtenerObjetoPorNombre(nombre, terrestres);
            if(encontrado == null) encontrado = Main.obtenerObjetoPorNombre(nombre, maritimos);
            if(encontrado == null) encontrado = Main.obtenerObjetoPorNombre(nombre, aereos);
            mostrarResultado(encontrado);
        } else if (modo == 2) {
            System.out.println("¿En qué lista buscar ID? (1. Terrestre, 2. Marítimo, 3. Aéreo)");
            int lista = scanner.nextInt();
            System.out.print("Ingrese el ID (posición): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            try {
                Transporte encontrado = null;
                if (lista == 1) encontrado = terrestres.get(id);
                else if (lista == 2) encontrado = maritimos.get(id);
                else if (lista == 3) encontrado = aereos.get(id);
                mostrarResultado(encontrado);
            } catch (Exception e) {
                System.out.println("[!] ID no encontrado en esa lista.");
            }
        }
    }

    private static void mostrarResultado(Transporte t) {
        if (t != null) {
            System.out.println("\n[DATOS ENCONTRADOS]");
            System.out.println("Nombre: " + t.getNombre());
            System.out.println("Medio: " + t.getMedio());
            System.out.println("Capacidad: " + t.getCapacidad());
        } else {
            System.out.println("\n[!] No se encontró ningún registro.");
        }
    }

    private static void handleUpdate(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("\n--- ACTUALIZAR POR POSICIÓN ---");
        System.out.println("1. Terrestre | 2. Marítimo | 3. Aéreo");
        System.out.print("Lista: ");
        int lista = scanner.nextInt();
        System.out.print("Posición: ");
        int pos = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.print("Nuevo Nombre: ");
            String n = scanner.nextLine();

            if (lista == 1) {
                System.out.print("Nuevo Terreno: "); String t = scanner.nextLine();
                System.out.print("Nueva Cap: "); int c = scanner.nextInt();
                System.out.print("Nuevas Ruedas: "); int r = scanner.nextInt();
                scanner.nextLine();
                Main.ModificarObjetoPorPosicion(pos, terrestres, new Terrestre(n, "Terrestre", t, c, r));
            } else if (lista == 2) {
                System.out.print("Nueva Cap: "); int c = scanner.nextInt();
                System.out.print("Nueva Eslora: "); double e = scanner.nextDouble();
                System.out.print("Nuevo Calado: "); int cl = scanner.nextInt();
                scanner.nextLine();
                Main.ModificarObjetoPorPosicion(pos, maritimos, new Maritimo(n, "Maritimo", c, e, cl));
            } else if (lista == 3) {
                System.out.print("Nueva Cap: "); int c = scanner.nextInt();
                System.out.print("Nueva Env: "); double env = scanner.nextDouble();
                System.out.print("Nueva Alt: "); int al = scanner.nextInt();
                scanner.nextLine();
                Main.ModificarObjetoPorPosicion(pos, aereos, new Aereo(n, "Aereo", c, env, al));
            }
            System.out.println("[*] Registro actualizado.");
        } catch (Exception e) {
            System.out.println("[!] Error en actualización.");
        }
    }

    private static void handleDelete(Scanner scanner, ArrayList<Terrestre> terrestres,
                                     ArrayList<Maritimo> maritimos, ArrayList<Aereo> aereos) {
        System.out.println("\n--- ELIMINAR ---");
        System.out.println("1. Terrestre | 2. Marítimo | 3. Aéreo");
        System.out.print("Lista: ");
        int lista = scanner.nextInt();
        System.out.print("Índice: ");
        int pos = scanner.nextInt();
        scanner.nextLine();

        try {
            if (lista == 1) Main.eliminarObjetoPorPosicion(pos, terrestres);
            else if (lista == 2) Main.eliminarObjetoPorPosicion(pos, maritimos);
            else if (lista == 3) Main.eliminarObjetoPorPosicion(pos, aereos);
            System.out.println("[-] Eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("[!] Error al eliminar.");
        }
    }
}