package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

/**
 * CRUD interactivo para gestionar tres tipos de transportes
 */
public class Menu {

    static ArrayList<Terrestre> transportes_terrestres = new ArrayList<>();
    static ArrayList<Maritimo> transportes_maritimos = new ArrayList<>();
    static ArrayList<Aereo> transportes_aereos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        llenarDatosIniciales();
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n== MENU PRINCIPAL ==");
            System.out.println("1. Gestionar Transportes Terrestres");
            System.out.println("2. Gestionar Transportes Marítimos");
            System.out.println("3. Gestionar Transportes Aéreos");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menuTerrestres();
                    break;
                case 2:
                    menuMaritimos();
                    break;
                case 3:
                    menuAereos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuTerrestres() {
        int opcion;
        do {
            System.out.println("\n----- MENU TERRESTRES -----");
            System.out.println("1. Crear");
            System.out.println("2. Leer todos");
            System.out.println("3. Leer por índice");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Actualizar");
            System.out.println("6. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearTerrestre();
                    break;
                case 2:
                    leerTodosTerrestres();
                    break;
                case 3:
                    leerTerrestrePorIndice();
                    break;
                case 4:
                    buscarTerrestrePorNombre();
                    break;
                case 5:
                    actualizarTerrestre();
                    break;
                case 6:
                    eliminarTerrestre();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuMaritimos() {
        int opcion;
        do {
            System.out.println("\n----- MENU MARÍTIMOS -----");
            System.out.println("1. Crear");
            System.out.println("2. Leer todos");
            System.out.println("3. Leer por índice");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Actualizar");
            System.out.println("6. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearMaritimo();
                    break;
                case 2:
                    leerTodosMaritimos();
                    break;
                case 3:
                    leerMaritimoPorIndice();
                    break;
                case 4:
                    buscarMaritimoporNombre();
                    break;
                case 5:
                    actualizarMaritimo();
                    break;
                case 6:
                    eliminarMaritimo();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuAereos() {
        int opcion;
        do {
            System.out.println("\n----- MENU AÉREOS -----");
            System.out.println("1. Crear");
            System.out.println("2. Leer todos");
            System.out.println("3. Leer por índice");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Actualizar");
            System.out.println("6. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearAereo();
                    break;
                case 2:
                    leerTodosAereos();
                    break;
                case 3:
                    leerAereoPorIndice();
                    break;
                case 4:
                    buscarAereoPorNombre();
                    break;
                case 5:
                    actualizarAereo();
                    break;
                case 6:
                    eliminarAereo();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    // = CRUD TERRESTRES =
    private static void crearTerrestre() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Medio: ");
        String medio = sc.nextLine();
        System.out.print("Tipo de terreno: ");
        String tipo = sc.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        System.out.print("Número de ruedas: ");
        int ruedas = sc.nextInt();
        sc.nextLine();

        Terrestre t = new Terrestre(nombre, medio, tipo, capacidad, ruedas);
        transportes_terrestres.add(t);
        System.out.println("✓ Terrestre creado exitosamente");
    }

    private static void leerTodosTerrestres() {
        if (transportes_terrestres.isEmpty()) {
            System.out.println("No hay terrestres registrados");
            return;
        }
        System.out.println("\n--- LISTA DE TERRESTRES ---");
        for (int i = 0; i < transportes_terrestres.size(); i++) {
            Terrestre t = transportes_terrestres.get(i);
            System.out.println(i + ". " + t.getNombre() + " - " + t.getTipo() + " - Ruedas: " + t.getNumero_ruedas());
        }
    }

    private static void leerTerrestrePorIndice() {
        System.out.print("Índice: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Terrestre t = transportes_terrestres.get(idx);
            System.out.println(
                    "Nombre: " + t.getNombre() + ", Tipo: " + t.getTipo() + ", Ruedas: " + t.getNumero_ruedas());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void buscarTerrestrePorNombre() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        for (Terrestre t : transportes_terrestres) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("✓ Encontrado: " + t.getNombre() + " - " + t.getTipo());
                return;
            }
        }
        System.out.println("✗ No encontrado");
    }

    private static void actualizarTerrestre() {
        System.out.print("Índice a actualizar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo medio: ");
            String medio = sc.nextLine();
            System.out.print("Nuevo tipo de terreno: ");
            String tipo = sc.nextLine();
            System.out.print("Nueva capacidad: ");
            int capacidad = sc.nextInt();
            System.out.print("Nuevo número de ruedas: ");
            int ruedas = sc.nextInt();
            sc.nextLine();

            Terrestre nuevo = new Terrestre(nombre, medio, tipo, capacidad, ruedas);
            transportes_terrestres.set(idx, nuevo);
            System.out.println("✓ Actualizado exitosamente");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void eliminarTerrestre() {
        System.out.print("Índice a eliminar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Terrestre eliminado = transportes_terrestres.remove(idx);
            System.out.println("✓ Eliminado: " + eliminado.getNombre());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    // =CRUD MARÍTIMOS =
    private static void crearMaritimo() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Medio: ");
        String medio = sc.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        System.out.print("Eslora: ");
        double eslora = sc.nextDouble();
        System.out.print("Calado: ");
        int calado = sc.nextInt();
        sc.nextLine();

        Maritimo m = new Maritimo(nombre, medio, capacidad, eslora, calado);
        transportes_maritimos.add(m);
        System.out.println("✓ Marítimo creado exitosamente");
    }

    private static void leerTodosMaritimos() {
        if (transportes_maritimos.isEmpty()) {
            System.out.println("No hay marítimos registrados");
            return;
        }
        System.out.println("\n--- LISTA DE MARÍTIMOS ---");
        for (int i = 0; i < transportes_maritimos.size(); i++) {
            Maritimo m = transportes_maritimos.get(i);
            System.out
                    .println(i + ". " + m.getNombre() + " - Eslora: " + m.getEslora() + " - Calado: " + m.getCalado());
        }
    }

    private static void leerMaritimoPorIndice() {
        System.out.print("Índice: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Maritimo m = transportes_maritimos.get(idx);
            System.out
                    .println("Nombre: " + m.getNombre() + ", Eslora: " + m.getEslora() + ", Calado: " + m.getCalado());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void buscarMaritimoporNombre() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        for (Maritimo m : transportes_maritimos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("✓ Encontrado: " + m.getNombre() + " - Eslora: " + m.getEslora());
                return;
            }
        }
        System.out.println("✗ No encontrado");
    }

    private static void actualizarMaritimo() {
        System.out.print("Índice a actualizar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo medio: ");
            String medio = sc.nextLine();
            System.out.print("Nueva capacidad: ");
            int capacidad = sc.nextInt();
            System.out.print("Nueva eslora: ");
            double eslora = sc.nextDouble();
            System.out.print("Nuevo calado: ");
            int calado = sc.nextInt();
            sc.nextLine();

            Maritimo nuevo = new Maritimo(nombre, medio, capacidad, eslora, calado);
            transportes_maritimos.set(idx, nuevo);
            System.out.println("✓ Actualizado exitosamente");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void eliminarMaritimo() {
        System.out.print("Índice a eliminar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Maritimo eliminado = transportes_maritimos.remove(idx);
            System.out.println("✓ Eliminado: " + eliminado.getNombre());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    // = CRUD AÉREOS =
    private static void crearAereo() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Medio: ");
        String medio = sc.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        System.out.print("Envergadura: ");
        double envergadura = sc.nextDouble();
        System.out.print("Altura máxima: ");
        int altura = sc.nextInt();
        sc.nextLine();

        Aereo a = new Aereo(nombre, medio, capacidad, envergadura, altura);
        transportes_aereos.add(a);
        System.out.println("✓ Aéreo creado exitosamente");
    }

    private static void leerTodosAereos() {
        if (transportes_aereos.isEmpty()) {
            System.out.println("No hay aéreos registrados");
            return;
        }
        System.out.println("\n--- LISTA DE AÉREOS ---");
        for (int i = 0; i < transportes_aereos.size(); i++) {
            Aereo a = transportes_aereos.get(i);
            System.out.println(i + ". " + a.getNombre() + " - Envergadura: " + a.getEnvergadura() + " - Altura: "
                    + a.getAltura_max());
        }
    }

    private static void leerAereoPorIndice() {
        System.out.print("Índice: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Aereo a = transportes_aereos.get(idx);
            System.out.println("Nombre: " + a.getNombre() + ", Envergadura: " + a.getEnvergadura() + ", Altura: "
                    + a.getAltura_max());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void buscarAereoPorNombre() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        for (Aereo a : transportes_aereos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("✓ Encontrado: " + a.getNombre() + " - Envergadura: " + a.getEnvergadura());
                return;
            }
        }
        System.out.println("✗ No encontrado");
    }

    private static void actualizarAereo() {
        System.out.print("Índice a actualizar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo medio: ");
            String medio = sc.nextLine();
            System.out.print("Nueva capacidad: ");
            int capacidad = sc.nextInt();
            System.out.print("Nueva envergadura: ");
            double envergadura = sc.nextDouble();
            System.out.print("Nueva altura máxima: ");
            int altura = sc.nextInt();
            sc.nextLine();

            Aereo nuevo = new Aereo(nombre, medio, capacidad, envergadura, altura);
            transportes_aereos.set(idx, nuevo);
            System.out.println("✓ Actualizado exitosamente");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void eliminarAereo() {
        System.out.print("Índice a eliminar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        try {
            Aereo eliminado = transportes_aereos.remove(idx);
            System.out.println("✓ Eliminado: " + eliminado.getNombre());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }

    private static void llenarDatosIniciales() {
        transportes_terrestres.add(new Terrestre("Tren", "Terrestre", "rieles", 30000, 0));
        transportes_terrestres.add(new Terrestre("camion", "Terrestre", "carretera", 7500, 8));
        transportes_maritimos.add(new Maritimo("Barco", "Maritimo", 10000, 100, 10));
        transportes_aereos.add(new Aereo("Avion", "Aereo", 10000, 100, 10));
    }
}
