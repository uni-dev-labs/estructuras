package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    static ArrayList<Transporte> listaTransportes = new ArrayList<>();

    public static void iniciarMenu() {

        Scanner sc = new Scanner(System.in);
        int opcionUsuario;

        do {

            System.out.println();
            System.out.println("===== SISTEMA DE TRANSPORTES =====");
            System.out.println("1. Registrar transporte");
            System.out.println("2. Ver lista de transportes");
            System.out.println("3. Editar transporte");
            System.out.println("4. Borrar transporte");
            System.out.println("0. Cerrar programa");
            System.out.println();

            opcionUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcionUsuario) {

                case 1:
                    registrarTransporte(sc);
                    break;

                case 2:
                    listarTransportes();
                    break;

                case 3:
                    modificarTransporte(sc);
                    break;

                case 4:
                    borrarTransporte(sc);
                    break;

                case 0:
                    System.out.println("Saliendo ...");
                    break;

                default:
                    System.out.println("La opcion ingresada no es valida.");
            }

        } while (opcionUsuario != 0);

        sc.close();
    }

    public static void registrarTransporte(Scanner sc) {

        System.out.println("Seleccione el tipo de transporte que desea crear:");
        System.out.println("1. Transporte terrestre");
        System.out.println("2. Transporte marítimo");
        System.out.println("3. Transporte aéreo");
        System.out.println();

        int tipoSeleccionado = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre:");
        String nombreTransporte = sc.nextLine();

        System.out.println("Ingrese la capacidad:");
        int capacidadTransporte = sc.nextInt();
        sc.nextLine();

        switch (tipoSeleccionado) {

            case 1:
                System.out.println("Tipo de vía:");
                String tipoVia = sc.nextLine();

                System.out.println("Cantidad de ruedas:");
                int ruedas = sc.nextInt();

                Transporte t1 = new Terrestre(nombreTransporte, "Terrestre", tipoVia, capacidadTransporte, ruedas);
                listaTransportes.add(t1);
                break;

            case 2:
                System.out.println("Ingrese la eslora:");
                double longitud = sc.nextDouble();

                System.out.println("Ingrese el calado:");
                int profundidad = sc.nextInt();

                Transporte t2 = new Maritimo(nombreTransporte, "Maritimo", capacidadTransporte, longitud, profundidad);
                listaTransportes.add(t2);
                break;

            case 3:
                System.out.println("Ingrese la envergadura:");
                double ala = sc.nextDouble();

                System.out.println("Ingrese la altura máxima:");
                int alturaMax = sc.nextInt();

                Transporte t3 = new Aereo(nombreTransporte, "Aereo", capacidadTransporte, ala, alturaMax);
                listaTransportes.add(t3);
                break;

            default:
                System.out.println("Tipo de transporte no válido.");
                return;
        }

        System.out.println("El transporte fue registrado correctamente.");
        System.out.println();
    }

    public static void listarTransportes() {

        System.out.println("--- Transportes registrados ---");

        for (int i = 0; i < listaTransportes.size(); i++) {

            Transporte t = listaTransportes.get(i);

            System.out.println("Registro " + (i + 1) + ": Nombre = " + t.getNombre() + ", Medio = " + t.getMedio()
                    + ", Capacidad = " + t.getCapacidad());
        }

        System.out.println();
    }

    public static void modificarTransporte(Scanner sc) {

        listarTransportes();

        System.out.println("Digite el número del transporte que desea modificar:");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice < 0 & indice >= listaTransportes.size()) {
            System.out.println("No existe transporte en esa posición.");
            return;
        }

        Transporte transporteEditar = listaTransportes.get(indice);

        if (transporteEditar instanceof Terrestre terrestreEdit) {

            System.out.println("Ingrese el nuevo nombre:");
            String nombre = sc.nextLine();
            terrestreEdit.setNombre(nombre);

            System.out.println("Ingrese la nueva capacidad:");
            int capacidad = sc.nextInt();
            terrestreEdit.setCapacidad(capacidad);

            System.out.println("Ingrese el nuevo número de ruedas:");
            int ruedas = sc.nextInt();
            terrestreEdit.setNumero_ruedas(ruedas);

            System.out.println("Ingrese el nuevo tipo de vía:");
            String via = sc.nextLine();
            terrestreEdit.setTipo(via);

        } else if (transporteEditar instanceof Maritimo maritimoEdit) {

            System.out.println("Ingrese el nuevo nombre:");
            String nombre = sc.nextLine();
            maritimoEdit.setNombre(nombre);

            System.out.println("Ingrese la nueva capacidad:");
            int capacidad = sc.nextInt();
            maritimoEdit.setCapacidad(capacidad);

            System.out.println("Ingrese la nueva eslora:");
            double eslora = sc.nextDouble();
            maritimoEdit.setEslora(eslora);

            System.out.println("Ingrese el nuevo calado:");
            int calado = sc.nextInt();
            maritimoEdit.setCalado(calado);

        } else if (transporteEditar instanceof Aereo aereoEdit) {

            System.out.println("Ingrese el nuevo nombre:");
            String nombre = sc.nextLine();
            aereoEdit.setNombre(nombre);

            System.out.println("Ingrese la nueva capacidad:");
            int capacidad = sc.nextInt();
            aereoEdit.setCapacidad(capacidad);

            System.out.println("Ingrese la nueva envergadura:");
            double envergadura = sc.nextDouble();
            aereoEdit.setEnvergadura(envergadura);
        }

        System.out.println("Los datos del transporte fueron actualizados.");
    }

    public static void borrarTransporte(Scanner sc) {

        listarTransportes();

        System.out.println("Digite el número del transporte que desea eliminar:");
        int indice = sc.nextInt();

        if (indice < 0 & indice > listaTransportes.size()) {
            System.out.println("Número fuera de rango.");
            return;
        }

        listaTransportes.remove(indice - 1);

        System.out.println("El transporte fue eliminado correctamente.");
        System.out.println();
    }
}
