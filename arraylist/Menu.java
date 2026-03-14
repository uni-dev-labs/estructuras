package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Terrestre> transporteTerrestres = new ArrayList<>();
        ArrayList<Maritimo> transporteMarittMaritimos = new ArrayList<>();
        ArrayList<Aereo> transportAereos = new ArrayList<>();

        Main.llenarTransportesTerrestres(transporteTerrestres);
        Main.llenarTransportesMaritimos(transporteMarittMaritimos);
        Main.llenarTransportesAereos(transportAereos);

        int opcion;

        do {
            System.out.println("1. Agregar un nuevo transporte: ");
            System.out.println("2. Buscar un transporte: ");
            System.out.println("3. Actualizar un transporte: ");
            System.out.println("4. Eliminar un transporte: ");
            System.out.println("5. Mostrar todos los transportes: ");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("¿Que tipo de transporte desea agregar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    int tipoAgregar = sc.nextInt();
                    sc.nextLine();

                    if (tipoAgregar == 1) {

                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Tipo: ");
                        String tipo = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Numero de ruedas: ");
                        int numeroRuedas = sc.nextInt();

                        Terrestre nuevo = new Terrestre(nombre, medio, tipo, capacidad, numeroRuedas);
                        Main.añadirNuevoTransporte(transporteTerrestres.size(), transporteTerrestres, nuevo);

                        Main.printTransportesTerrestres(transporteTerrestres);

                    } else if (tipoAgregar == 2) {

                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Eslora: ");
                        int eslora = sc.nextInt();
                        System.out.println("calado: ");
                        int calado = sc.nextInt();

                        Maritimo nuevo = new Maritimo(nombre, medio, capacidad, eslora, calado);
                        Main.añadirNuevoTransporte(transporteMarittMaritimos.size(), transporteMarittMaritimos, nuevo);

                        Main.printTransportesMaritimos(transporteMarittMaritimos);

                    } else if (tipoAgregar == 3) {

                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Envergadura: ");
                        int envergadura = sc.nextInt();
                        System.out.println("Altura maxima: ");
                        int alturaMaxima = sc.nextInt();

                        Aereo nuevo = new Aereo(nombre, medio, capacidad, envergadura, alturaMaxima);
                        Main.añadirNuevoTransporte(transportAereos.size(), transportAereos, nuevo);

                        Main.printTransportesAereos(transportAereos);
                    }
                    break;

                case 2:
                    System.out.println("¿En que lista deseas buscar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    int tipoBuscar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el nombre");
                    String nombreBuscar = sc.nextLine();

                    if (tipoBuscar == 1) {
                        Terrestre t = Main.obtenerObjetoPorNombre(nombreBuscar, transporteTerrestres);
                        if (t != null)
                            System.out.println("Encontrado: " + t.getNombre());

                    } else if (tipoBuscar == 2) {
                        Maritimo m = Main.obtenerObjetoPorNombre(nombreBuscar, transporteMarittMaritimos);
                        if (m != null)
                            System.out.println("Encontrado: " + m.getNombre());
                    } else if (tipoBuscar == 3) {
                        Aereo a = Main.obtenerObjetoPorNombre(nombreBuscar, transportAereos);
                        if (a != null)
                            System.out.println("Encontrado: " + a.getNombre());
                    }
                    break;

                case 3:
                    System.out.println("Que lista desea actualizar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. MAritimo");
                    System.out.println("3. Aereo");
                    int tipoActualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Posicion a modificar: ");
                    int posicionActualizar = sc.nextInt();
                    sc.nextLine();

                    if (tipoActualizar == 1) {

                        System.out.println("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Tipo: ");
                        String tipo = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Numero de ruedas: ");
                        int numeroRuedas = sc.nextInt();

                        Terrestre nuevo = new Terrestre(nombre, medio, tipo, capacidad, numeroRuedas);
                        Main.ModificarObjetoPorPosicion(posicionActualizar, transporteTerrestres, nuevo);
                        Main.printTransportesTerrestres(transporteTerrestres);

                    } else if (tipoActualizar == 2) {

                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Eslora: ");
                        int eslora = sc.nextInt();
                        System.out.println("calado: ");
                        int calado = sc.nextInt();

                        Maritimo nuevo = new Maritimo(nombre, medio, capacidad, eslora, calado);
                        Main.ModificarObjetoPorPosicion(posicionActualizar, transporteMarittMaritimos, nuevo);
                        Main.printTransportesMaritimos(transporteMarittMaritimos);

                    } else if (tipoActualizar == 3) {

                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Medio: ");
                        String medio = sc.nextLine();
                        System.out.println("Capacidad: ");
                        int capacidad = sc.nextInt();
                        System.out.println("Envergadura: ");
                        int envergadura = sc.nextInt();
                        System.out.println("Altura maxima: ");
                        int alturaMaxima = sc.nextInt();

                        Aereo nuevo = new Aereo(nombre, medio, capacidad, envergadura, alturaMaxima);
                        Main.ModificarObjetoPorPosicion(posicionActualizar, transportAereos, nuevo);
                        Main.printTransportesAereos(transportAereos);
                    }

                    break;
                case 4:
                    System.out.println("¿De que lista desea eliminar?");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");
                    int tipoEliminar = sc.nextInt();

                    System.out.println("Posicion a eliminar: ");
                    int posicionEliminar = sc.nextInt();

                    if (tipoEliminar == 1) {
                        if (posicionEliminar >= 0 && posicionEliminar < transporteTerrestres.size()) {
                            Main.eliminarObjetoPorPosicion(posicionEliminar, transporteTerrestres);
                            Main.printTransportesTerrestres(transporteTerrestres);
                        } else {
                            System.out.println("Posicion invalida.");
                        }
                    } else if (tipoEliminar == 2) {
                        if (tipoEliminar >= 0 && posicionEliminar < transporteMarittMaritimos.size()) {
                            Main.eliminarObjetoPorPosicion(posicionEliminar, transporteMarittMaritimos);
                            Main.printTransportesMaritimos(transporteMarittMaritimos);
                        } else {
                            System.out.println("Posicion invalida");
                        }
                    } else if (tipoEliminar == 3) {
                        if (tipoEliminar >= 0 && posicionEliminar < transportAereos.size()) {
                            Main.eliminarObjetoPorPosicion(posicionEliminar, transportAereos);
                            Main.printTransportesAereos(transportAereos);
                        } else {
                            System.out.println("Posicion invalida");
                        }
                    }
                    break;

                case 5:
                    Main.printTransportesTerrestres(transporteTerrestres);
                    Main.printTransportesMaritimos(transporteMarittMaritimos);
                    Main.printTransportesAereos(transportAereos);
                    break;

                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                default:
                    System.out.println("Opcion valida");
                    break;
            }

        } while (opcion != 0);
        sc.close();
    }
}
