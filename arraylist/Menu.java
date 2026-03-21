package arraylist;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void mostrarMenu(ArrayList<Terrestre> terrestres, ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        Scanner options = new Scanner(System.in);
        int select;
        int subSelect;

        do {
            System.out.println("|--------------------------------------|");
            System.out.println("|             Menu Principal           |");
            System.out.println("|--------------------------------------|");
            System.out.println("|Selecciona el Transporte:             |");
            System.out.println("| 1. Transportes terrestres            |");
            System.out.println("| 2. Transportes maritimos             |");
            System.out.println("| 3. Transportes aereos                |");
            System.out.println("| 0. Salir                             |");
            System.out.println("|--------------------------------------|");
            System.out.print("Ingresa tu opción: ");
            select = Integer.parseInt(options.nextLine());

            switch (select) {
                case 1:
                    gestionarSubmenu("Terrestres", terrestres, options);
                    break;
                case 2:
                    gestionarSubmenu("Maritimos", maritimos, options);
                    break;
                case 3:
                    gestionarSubmenu("Aereos", aereos, options);
                    break;
            }
        } while ((select) != 0);

    }

    private static <T extends Transporte> void gestionarSubmenu(String titulo, ArrayList<T> lista, Scanner subOptions) {
        int subSelect;
        do {
            System.out.println("");
            System.out.println("|--------------------------------------|");
            System.out.println("|      Transportes " + titulo + "          |");
            System.out.println("|--------------------------------------|");
            System.out.println("| 1. Ver lista                         |");
            System.out.println("| 2. Agregar dato                      |");
            System.out.println("| 3. Modificar dato                    |");
            System.out.println("| 4. Eliminar dato                     |");
            System.out.println("| 0. Volver al Menú Principal          |");
            System.out.println("|--------------------------------------|");
            System.out.print("Que acción deseas realizar: ");
            subSelect = Integer.parseInt(subOptions.nextLine());

            switch (subSelect) {
                case 1:
                    if (lista.isEmpty()) {
                        System.out.println("La lista " + titulo + " esta vacia.");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println((i + 1) + ". " + lista.get(i).getNombre());
                        }
                    }
                    System.out.println("Volviendo a la lista de acciones...");
                    break;
                case 2:
                    if (titulo.equals("Terrestres")) {
                        lista.add((T) crearTerrestre(subOptions));
                    } else if (titulo.equals("Maritimos")) {
                        lista.add((T) crearMaritimo(subOptions));
                    } else if (titulo.equals("Aereos")) {
                        lista.add((T) crearAereo(subOptions));
                    }
                    System.out.println(titulo + " agregado correctamente");
                    break;
                case 3:
                    System.out.println("Ingresa el número del elemento que desea modificar:");
                    int indiceModificar = Integer.parseInt(subOptions.nextLine());

                    if (indiceModificar >= 0 && indiceModificar < lista.size()) {
                        T nuevoObjeto = null;
                        if (titulo.equals("Terrestres")) {
                            nuevoObjeto = (T) crearTerrestre(subOptions);
                        } else if (titulo.equals("Maritimos")) {
                            nuevoObjeto = (T) crearMaritimo(subOptions);
                        } else if (titulo.equals("Aereos")) {
                            nuevoObjeto = (T) crearAereo(subOptions);
                        }
                        lista.set(indiceModificar, nuevoObjeto);
                        System.out.println("¡Elemento modificado con éxito!");
                    }
                    break;

                case 4:
                    System.out.println("Ingresa el número del elemento que desea eliminar:");
                    int indiceEliminar = (Integer.parseInt(subOptions.nextLine()) - 1);

                    if (indiceEliminar >= 0 && indiceEliminar < lista.size()) {
                        T eliminado = lista.remove(indiceEliminar);
                        System.out.println("Se eliminó: " + eliminado.getNombre());
                    } else {
                        System.out.println("Número no válido.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo al menú principal...");
                    break;
            }
        } while (subSelect != 0);
    }

    public static Terrestre crearTerrestre(Scanner newTerrestre) {
        System.out.println("--- Nuevo Transporte Terrestre ---");
        System.out.print("Nombre: ");
        String nombre = newTerrestre.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(newTerrestre.nextLine());

        System.out.print("Número de ruedas: ");
        int ruedas = Integer.parseInt(newTerrestre.nextLine());

        System.out.print("Tipo (carretera/vía): ");
        String tipo = newTerrestre.nextLine();

        return new Terrestre(nombre, "Terrestres", tipo, capacidad, ruedas);
    }

    public static Maritimo crearMaritimo(Scanner newMaritimo) {
        System.out.println("--- Nuevo Transporte Maritimo ---");
        System.out.print("Nombre: ");
        String nombre = newMaritimo.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(newMaritimo.nextLine());

        System.out.print("Eslora (metros): ");
        double estola = Double.parseDouble(newMaritimo.nextLine());

        System.out.print("Calado (metros): ");
        int calado = Integer.parseInt(newMaritimo.nextLine());

        return new Maritimo(nombre, "Maritimos", capacidad, estola, calado);
    }

    public static Aereo crearAereo(Scanner newAereo) {
        System.out.println("--- Nuevo Transporte Aereo ---");
        System.out.print("Nombre: ");
        String nombre = newAereo.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(newAereo.nextLine());

        System.out.print("Envergadura (metros): ");
        double envergadura = Double.parseDouble(newAereo.nextLine());

        System.out.print("Altura maxima (metros): ");
        int alturaMax = Integer.parseInt(newAereo.nextLine());

        return new Aereo(nombre, "Aereos", capacidad, envergadura, alturaMax);
    }
}
