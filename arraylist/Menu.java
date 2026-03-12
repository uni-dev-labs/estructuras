package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    public void printMenu() {

        Scanner sc = new Scanner(System.in);

        ArrayList<Terrestre> transportes_terrestres = new ArrayList<>();
        ArrayList<Maritimo> transportes_maritimos = new ArrayList<>();
        ArrayList<Aereo> transportes_aereos = new ArrayList<>();

        int option;

        do {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Mostrar transportes terrestres");
            System.out.println("2. Mostrar transportes maritimos");
            System.out.println("3. Mostrar transportes aereos");
            System.out.println("4. Añadir transporte");
            System.out.println("5. Obtener tamaño");
            System.out.println("6. Obtener transporte por posicion");
            System.out.println("7. Eliminar transporte por posicion");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    Main.printTransportesTerrestres(transportes_terrestres);
                    break;

                case 2:
                    Main.printTransportesMaritimos(transportes_maritimos);
                    break;

                case 3:
                    Main.printTransportesAereos(transportes_aereos);
                    break;

                case 4:
                    Main.crearTransporte(sc, transportes_terrestres, transportes_maritimos, transportes_aereos);
                    break;

                case 5:

                    System.out.println("Seleccione tipo:");
                    System.out.println("1 Terrestre");
                    System.out.println("2 Maritimo");
                    System.out.println("3 Aereo");

                    int tipo = sc.nextInt();

                    switch (tipo) {

                        case 1:
                            Main.obtenerTamañoDelArrayList(transportes_terrestres);
                            break;

                        case 2:
                            Main.obtenerTamañoDelArrayList(transportes_maritimos);
                            break;

                        case 3:
                            Main.obtenerTamañoDelArrayList(transportes_aereos);
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }

                    break;

                case 6:

                    System.out.println("Seleccione tipo:");
                    System.out.println("1 Terrestre");
                    System.out.println("2 Maritimo");
                    System.out.println("3 Aereo");

                    int tipo2 = sc.nextInt();

                    System.out.println("Ingrese posicion:");
                    int pos = sc.nextInt();

                    switch (tipo2) {

                        case 1:
                            Main.obtenerObjetoPorPosicion(pos, transportes_terrestres);
                            break;

                        case 2:
                            Main.obtenerObjetoPorPosicion(pos, transportes_maritimos);
                            break;

                        case 3:
                            Main.obtenerObjetoPorPosicion(pos, transportes_aereos);
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }

                    break;

                case 7:

                    System.out.println("Seleccione tipo:");
                    System.out.println("1 Terrestre");
                    System.out.println("2 Maritimo");
                    System.out.println("3 Aereo");

                    int tipo3 = sc.nextInt();

                    System.out.println("Ingrese posicion a eliminar:");
                    int eliminar = sc.nextInt();

                    switch (tipo3) {

                        case 1:
                            Main.eliminarObjetoPorPosicion(eliminar, transportes_terrestres);
                            break;

                        case 2:
                            Main.eliminarObjetoPorPosicion(eliminar, transportes_maritimos);
                            break;

                        case 3:
                            Main.eliminarObjetoPorPosicion(eliminar, transportes_aereos);
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }

                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }

        } while (option != 8);

        sc.close();

    }

}