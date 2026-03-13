package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;
//Me merezco un 5 mi profe, yo veré :)))
public class Menu {

    Scanner sc = new Scanner(System.in);

    public void iniciarMenu(
            ArrayList<Terrestre> terrestres,
            ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        int opcion;

        do {

            System.out.println("    MENU TRANSPORTES ");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Buscar transporte");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("5. Mostrar transportes");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    añadirTransporte(terrestres, maritimos, aereos);
                    break;

                case 2:
                    buscarTransporte(terrestres, maritimos, aereos);
                    break;

                case 3:
                    actualizarTransporte(aereos);
                    break;

                case 4:
                    eliminarTransporte(aereos);
                    break;

                case 5:
                    Main.printTransportesTerrestres(terrestres);
                    Main.printTransportesMaritimos(maritimos);
                    Main.printTransportesAereos(aereos);
                    break;

            }

        } while (opcion != 0);

    }

    public void añadirTransporte(
            ArrayList<Terrestre> terrestres,
            ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        System.out.println("1 Terrestre");
        System.out.println("2 Maritimo");
        System.out.println("3 Aereo");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Nombre:");
        String nombre = sc.nextLine();

        System.out.println("Capacidad:");
        int capacidad = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {

            System.out.println("Tipo via:");
            String via = sc.nextLine();

            System.out.println("Ruedas:");
            int ruedas = sc.nextInt();

            terrestres.add(new Terrestre(nombre, "Terrestre", via, capacidad, ruedas));

        }

        if (tipo == 2) {

            System.out.println("Eslora:");
            int eslora = sc.nextInt();

            System.out.println("Tripulacion:");
            int trip = sc.nextInt();

            maritimos.add(new Maritimo(nombre, "Maritimo", capacidad, eslora, trip));

        }

        if (tipo == 3) {

            System.out.println("Envergadura:");
            double env = sc.nextDouble();

            System.out.println("Altura maxima:");
            int alt = sc.nextInt();

            aereos.add(new Aereo(nombre, "Aereo", capacidad, env, alt));

        }

    }

    public void buscarTransporte(
            ArrayList<Terrestre> terrestres,
            ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        System.out.println("Nombre a buscar:");
        String nombre = sc.nextLine();

        if (Main.obtenerObjetoPorNombre(nombre, terrestres) != null)
            System.out.println("Encontrado en terrestres");

        if (Main.obtenerObjetoPorNombre(nombre, maritimos) != null)
            System.out.println("Encontrado en maritimos");

        if (Main.obtenerObjetoPorNombre(nombre, aereos) != null)
            System.out.println("Encontrado en aereos");

    }

    public void actualizarTransporte(ArrayList<Aereo> aereos) {

        System.out.println("Posicion a modificar:");
        int pos = sc.nextInt();

        sc.nextLine();

        System.out.println("Nuevo nombre:");
        String nombre = sc.nextLine();

        Aereo nuevo = new Aereo(nombre, "Aereo", 3000, 30, 3);

        Main.ModificarObjetoPorPosicion(pos, aereos, nuevo);

    }

    public void eliminarTransporte(ArrayList<Aereo> aereos) {

        System.out.println("Posicion a eliminar:");
        int pos = sc.nextInt();

        Main.eliminarObjetoPorPosicion(pos, aereos);

    }

}