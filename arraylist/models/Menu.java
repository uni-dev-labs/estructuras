package arraylist.models;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.Main;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void runMenu(ArrayList<Terrestre> landTransportsList,
            ArrayList<Maritimo> maritimeTransportsList,
            ArrayList<Aereo> airTransportsList) {

        int typedOption = 0;

        do {
            System.out.println("\n============= MENU PRINCIPAL =============");
            System.out.println("0. Salir del programa");
            System.out.println("1. Agregar Transporte");
            System.out.println("2. Buscar Transporte");
            System.out.println("3. Eliminar Transporte");
            System.out.println("4. Actualizar Transporte");
            System.out.println("5. Mostrar Transportes");
            System.out.print("Digite una opcion: ");

            typedOption = Integer.parseInt(scanner.nextLine());

            switch (typedOption) {
                case 0:
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    runSecondMenu(typedOption, landTransportsList, maritimeTransportsList, airTransportsList);
                    break;
                default:
                    System.out.println("Por favor ingresa una opcion valida");
                    break;
            }

        } while (typedOption != 0);
    }

    public static void runSecondMenu(int crudOption,
            ArrayList<Terrestre> landTransportList,
            ArrayList<Maritimo> maritimeTransportsList,
            ArrayList<Aereo> airTransportsList) {

        int selectedTransport = 0;

        do {
            System.out.println("\n========= TIPO DE TRANSPORTE =========");
            System.out.println("0. Volver al menu principal");
            System.out.println("1. Terrestre");
            System.out.println("2. Maritimo");
            System.out.println("3. Aereo");
            System.out.print("Digite una opcion: ");

            selectedTransport = Integer.parseInt(scanner.nextLine());

            switch (selectedTransport) {
                case 0:
                    System.out.println("Regresando al menu principal...");
                    break;

                case 1:
                    operateLandTransport(crudOption, landTransportList);
                    break;

                case 2:
                    operateMaritimeTransport(crudOption, maritimeTransportsList);
                    break;

                case 3:
                    operateAirTransport(crudOption, airTransportsList);
                    break;

                default:
                    System.out.println("Por favor ingresa una opcion valida");
                    break;
            }

        } while (selectedTransport != 0);
    }

    public static void operateLandTransport(int crudOption, ArrayList<Terrestre> landTransportList) {
        switch (crudOption) {
            case 1:
                addLandTransport(landTransportList);
                break;
            case 2:
                searchTransportByName(landTransportList);
                break;
            case 3:
                deleteTransportByPosition(landTransportList);
                break;
            case 4:
                updateLandTransportByPosition(landTransportList);
                break;
            case 5:
                Main.printTransportesTerrestres(landTransportList);
                break;
            default:
                System.out.println("Operacion invalida");
                break;
        }
    }

    public static void operateMaritimeTransport(int crudOption, ArrayList<Maritimo> maritimeTransportsList) {
        switch (crudOption) {
            case 1:
                addMaritimeTransport(maritimeTransportsList);
                break;
            case 2:
                searchTransportByName(maritimeTransportsList);
                break;
            case 3:
                deleteTransportByPosition(maritimeTransportsList);
                break;
            case 4:
                updateMaritimeTransportByPosition(maritimeTransportsList);
                break;
            case 5:
                Main.printTransportesMaritimos(maritimeTransportsList);
                break;
            default:
                System.out.println("Operacion invalida");
                break;
        }
    }

    public static void operateAirTransport(int crudOption, ArrayList<Aereo> airTransportsList) {
        switch (crudOption) {
            case 1:
                addAirTransport(airTransportsList);
                break;
            case 2:
                searchTransportByName(airTransportsList);
                break;
            case 3:
                deleteTransportByPosition(airTransportsList);
                break;
            case 4:
                updateAirTransportByPosition(airTransportsList);
                break;
            case 5:
                Main.printTransportesAereos(airTransportsList);
                break;
            default:
                System.out.println("Operacion invalida");
                break;
        }
    }

    public static void addLandTransport(ArrayList<Terrestre> landTransportList) {
        System.out.print("Digite la posicion donde desea insertar: ");
        int position = Integer.parseInt(scanner.nextLine());

        Transporte createdTransport = createTransport(1);

        if (createdTransport != null) {
            Main.añadirNuevoTransporte(position, landTransportList, (Terrestre) createdTransport);
            System.out.println("Transporte terrestre agregado correctamente.");
        }
    }

    public static void addMaritimeTransport(ArrayList<Maritimo> maritimeTransportsList) {
        System.out.print("Digite la posicion donde desea insertar: ");
        int position = Integer.parseInt(scanner.nextLine());

        Transporte createdTransport = createTransport(2);

        if (createdTransport != null) {
            Main.añadirNuevoTransporte(position, maritimeTransportsList, (Maritimo) createdTransport);
            System.out.println("Transporte maritimo agregado correctamente.");
        }
    }

    public static void addAirTransport(ArrayList<Aereo> airTransportsList) {
        System.out.print("Digite la posicion donde desea insertar: ");
        int position = Integer.parseInt(scanner.nextLine());

        Transporte createdTransport = createTransport(3);

        if (createdTransport != null) {
            Main.añadirNuevoTransporte(position, airTransportsList, (Aereo) createdTransport);
            System.out.println("Transporte aereo agregado correctamente.");
        }
    }

    public static <T extends Transporte> void searchTransportByName(ArrayList<T> transportsList) {
        System.out.print("Digite el nombre del transporte a buscar: ");
        String name = scanner.nextLine();

        T foundTransport = Main.obtenerObjetoPorNombre(name, transportsList);

        if (foundTransport != null) {
            System.out
                    .println("Transporte encontrado: " + foundTransport.getNombre() + " - " + foundTransport.getMedio()
                            + " - capacidad: " + foundTransport.getCapacidad());
        } else {
            System.out.println("No se encontro el transporte.");
        }
    }

    public static <T extends Transporte> void deleteTransportByPosition(ArrayList<T> transportsList) {
        System.out.print("Digite la posicion del transporte a eliminar: ");
        int position = Integer.parseInt(scanner.nextLine());

        if (position >= 0 && position < transportsList.size()) {
            Main.eliminarObjetoPorPosicion(position, transportsList);
            System.out.println("Transporte eliminado correctamente.");
        } else {
            System.out.println("Posicion invalida.");
        }
    }

    public static void updateLandTransportByPosition(ArrayList<Terrestre> landTransportList) {
        System.out.print("Digite la posicion del transporte terrestre a modificar: ");
        int position = Integer.parseInt(scanner.nextLine());

        if (position >= 0 && position < landTransportList.size()) {
            Transporte updatedTransport = createTransport(1);

            if (updatedTransport != null) {
                Main.ModificarObjetoPorPosicion(position, landTransportList, (Terrestre) updatedTransport);
                System.out.println("Transporte terrestre actualizado correctamente.");
            }
        } else {
            System.out.println("Posicion invalida.");
        }
    }

    public static void updateMaritimeTransportByPosition(ArrayList<Maritimo> maritimeTransportsList) {
        System.out.print("Digite la posicion del transporte maritimo a modificar: ");
        int position = Integer.parseInt(scanner.nextLine());

        if (position >= 0 && position < maritimeTransportsList.size()) {
            Transporte updatedTransport = createTransport(2);

            if (updatedTransport != null) {
                Main.ModificarObjetoPorPosicion(position, maritimeTransportsList, (Maritimo) updatedTransport);
                System.out.println("Transporte maritimo actualizado correctamente.");
            }
        } else {
            System.out.println("Posicion invalida.");
        }
    }

    public static void updateAirTransportByPosition(ArrayList<Aereo> airTransportsList) {
        System.out.print("Digite la posicion del transporte aereo a modificar: ");
        int position = Integer.parseInt(scanner.nextLine());

        if (position >= 0 && position < airTransportsList.size()) {
            Transporte updatedTransport = createTransport(3);

            if (updatedTransport != null) {
                Main.ModificarObjetoPorPosicion(position, airTransportsList, (Aereo) updatedTransport);
                System.out.println("Transporte aereo actualizado correctamente.");
            }
        } else {
            System.out.println("Posicion invalida.");
        }
    }

    public static Transporte createTransport(int transportType) {
        System.out.print("Ingrese el nombre del transporte: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el medio del transporte: ");
        String medio = scanner.nextLine();

        System.out.print("Ingrese la capacidad del transporte: ");
        int capacidad = Integer.parseInt(scanner.nextLine());

        switch (transportType) {
            case 1:
                return inputLandInformation(nombre, medio, capacidad);
            case 2:
                return inputMaritimeInformation(nombre, medio, capacidad);
            case 3:
                return inputAirInformation(nombre, medio, capacidad);
            default:
                return null;
        }
    }

    public static Terrestre inputLandInformation(String transportName, String transportMedium, int capacity) {
        System.out.print("Ingrese el numero de ruedas: ");
        int wheelsNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el tipo de vehiculo: ");
        String vehicleType = scanner.nextLine();

        return new Terrestre(transportName, transportMedium, vehicleType, capacity, wheelsNumber);
    }

    public static Maritimo inputMaritimeInformation(String transportName, String transportMedium, int capacity) {
        System.out.print("Ingrese la eslora del vehiculo: ");
        double eslora = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite el calado del vehiculo: ");
        int calado = Integer.parseInt(scanner.nextLine());

        return new Maritimo(transportName, transportMedium, capacity, eslora, calado);
    }

    public static Aereo inputAirInformation(String transportName, String transportMedium, int capacity) {
        System.out.print("Ingrese la envergadura: ");
        double wingspan = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese la altura maxima: ");
        int highestHeight = Integer.parseInt(scanner.nextLine());

        return new Aereo(transportName, transportMedium, capacity, wingspan, highestHeight);
    }
}