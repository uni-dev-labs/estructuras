package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    static ArrayList<Transporte> transportes = new ArrayList<>();

    public static void abrirMenu() {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("-----MENU-----");
            System.out.println("1. Crear transporte");
            System.out.println("2. Mostrar transportes");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Eliminar transporte");
            System.out.println("0. Salir");
            System.out.println();

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    crearTransporte(sc);
                    break;

                case 2:
                    mostrarTransportes();
                    break;

                case 3:
                    actualizarTransporte(sc);
                    break;

                case 4:
                    eliminarTransporte(sc);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void crearTransporte(Scanner sc) {

        System.out.println("Elige el tipo de transporte a crear:");
        System.out.println("1. Terrestre");
        System.out.println("2. Marítimo");
        System.out.println("3. Aéreo");
        System.out.println();

        int tipoT = sc.nextInt();
        sc.nextLine();

        System.out.println("Nombre:");
        String nombre = sc.nextLine();

        System.out.println("Capacidad del:");
        int capacidad = sc.nextInt();
        sc.nextLine();

        switch (tipoT) {

            case 1:

                System.out.println("Tipo de via");
                String tipo = sc.nextLine();

                System.out.println("Número de ruedas:");
                int ruedas = sc.nextInt();

                Transporte transporte1 = new Terrestre(nombre, "Terrestre", tipo, capacidad, ruedas);
                transportes.add(transporte1);
                break;

            case 2:

                System.out.println("Eslora:");
                double eslora = sc.nextDouble();

                System.out.println("Calado:");
                int calado = sc.nextInt();

                Transporte transporte2 = new Maritimo(nombre, "Maritimo", capacidad, eslora, calado);
                transportes.add(transporte2);
                break;

            case 3:

                System.out.println("Envergadura:");
                double envergadura = sc.nextDouble();

                System.out.println("Altura máxima:");
                int altura = sc.nextInt();

                Transporte transporte3 = new Aereo(nombre, "Aereo", capacidad, envergadura, altura);
                transportes.add(transporte3);
                break;

            default:
                System.out.println("Opcion invalida");
                return;
        }

        System.out.println("Transporte agregado correctamente.");
        System.out.println();
    }

    public static void mostrarTransportes() {

        System.out.println("Lista de transportes: ");

        for (int i = 0; i < transportes.size(); i++) {

            Transporte transporte = transportes.get(i);

            System.out.println("Transporte " + (i + 1) + ": Nombre =" + transporte.getNombre() + ", Medio= "
                    + transporte.getMedio() + ", Capacidad= " + transporte.getCapacidad());
        }
        System.out.println();
    }

    public static void actualizarTransporte(Scanner sc) {

        mostrarTransportes();

        System.out.println("Ingrese la posición del transporte a modificar:");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos < 0 & pos >= transportes.size()) {
            System.out.println("NO existe un transporte en esa posicion");
            return;
        }

        Transporte transporteNuevo = transportes.get(pos);

        if (transporteNuevo instanceof Terrestre terrestre2) {
            System.out.println("Nuevo nombre:");
            String nombre = sc.nextLine();
            terrestre2.setNombre(nombre);

            System.out.println("Nueva cappacidad: ");
            int capacidad = sc.nextInt();
            terrestre2.setCapacidad(capacidad);

            System.out.println("Nuevo numero de ruedas");
            int numero = sc.nextInt();
            terrestre2.setNumero_ruedas(numero);

            System.out.println("Nuevo tipo de via");
            String via = sc.nextLine();
            terrestre2.setTipo(via);
            ;

        } else if (transporteNuevo instanceof Maritimo maritimo2) {
            System.out.println("Nuevo nombre:");
            String nombre = sc.nextLine();
            maritimo2.setNombre(nombre);

            System.out.println("Nueva cappacidad: ");
            int capacidad = sc.nextInt();
            maritimo2.setCapacidad(capacidad);

            System.out.println("Nueva eslora: ");
            double eslora = sc.nextDouble();
            maritimo2.setEslora(eslora);

            System.out.println("NUevo calado: ");
            int calado = sc.nextInt();
            maritimo2.setCalado(calado);
            
        } else if(transporteNuevo instanceof Aereo aereo2){
            System.out.println("Nuevo nombre:");
            String nombre = sc.nextLine();
            aereo2.setNombre(nombre);

            System.out.println("Nueva capacidad: ");
            int capacidad = sc.nextInt();
            aereo2.setCapacidad(capacidad);

            System.out.println("Nueva envergadura");
            double envergadura = sc.nextDouble();
            aereo2.setEnvergadura(envergadura);
        }

        System.out.println("Transporte actualizado.");
    }

    public static void eliminarTransporte(Scanner sc) {

        mostrarTransportes();

        System.out.println("Ingrese la posición del tranporte a eliminar:");
        int pos = sc.nextInt();

        if (pos < 0 & pos > transportes.size()) {
            System.out.println("Posición inválida");
            return;
        }

        transportes.remove(pos-1);

        System.out.println("Transporte eliminado.");
        System.out.println();
    }
}