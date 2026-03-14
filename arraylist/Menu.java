package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);

        ArrayList<Terrestre> transportes_terrestres = new ArrayList<Terrestre>();
        ArrayList<Maritimo> transportes_maritimos   = new ArrayList<Maritimo>();
        ArrayList<Aereo>    transportes_aereos      = new ArrayList<Aereo>();

        
         int opt;
        do { 
            System.out.println("---------Menu Principal---------");
            System.out.println("--------------------------------");
            System.out.println("1. Gestionar los transportes");
            System.out.println("0. Salir");
            opt = Integer.valueOf(sc.nextLine());
            switch (opt) {
                case 1:
                    menuSelec(sc, transportes_terrestres);
                    
                    break;
                case 0:
                    System.out.println("exiting.... (exitando)");
                    break;
            
                default:
                    break;
            }
        } while (opt != 0);
    }




    public static <T> void añadirNuevoTransporte(int posicion, ArrayList<T> transportes_type, T transporte) {
        System.out.println("Añadiendo un nuevo transporte en la posición " + posicion);
        transportes_type.add(posicion, transporte);
    }

    public static <T> void obtenerTamañoDelArrayList(ArrayList<T> transportes_type) {
        System.out.println("Tamaño del ArrayList: " + transportes_type.size());
    }

    public static <T extends Transporte> void obtenerObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Obteniendo el objeto en la posición " + posicion+ ": ");
        System.out.println(transportes_type.get(posicion).getNombre());
        System.out.println(transportes_type.get(posicion).getMedio());
        System.out.println(transportes_type.get(posicion).getCapacidad());
        String medio = transportes_type.get(posicion).getMedio();
        if (medio.equalsIgnoreCase("Terrestre")) {
            Terrestre terrestre = (Terrestre) transportes_type.get(posicion);
            System.out.println(terrestre.getTipo());
            System.out.println(terrestre.getNumero_ruedas());
        } else if (medio.equalsIgnoreCase("Maritimo")) {
            Maritimo maritimo = (Maritimo) transportes_type.get(posicion);
            System.out.println(maritimo.getEslora());
            System.out.println(maritimo.getCalado());
        } else if (medio.equalsIgnoreCase("Aereo")) {
            Aereo aereo = (Aereo) transportes_type.get(posicion);
            System.out.println(aereo.getEnvergadura());
            System.out.println(aereo.getAltura_max());
        }
    }


    public static <T extends Transporte> T obtenerObjetoPorNombre(String nombre, ArrayList<T> transportes_type) {
        try {
            for(T transporte : transportes_type) {
                if(transporte.getNombre().equals(nombre)) {
                    return transporte;
                }
            }
            throw new IndexOutOfBoundsException("Objeto no encontrado");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public static <T extends Transporte> void ModificarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type, Scanner sc) {
        System.out.println("---------------Menu Para Modificar Transportes---------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese el nuevo nombre del transporte: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el nuevo medio del transporte (Terrestre/Maritimo/Aereo): ");
        String medio = sc.nextLine();
        System.out.println("Ingrese la nueva capacidad del transporte: ");
        int capacidad = Integer.valueOf(sc.nextLine());
        
        Transporte transporte2 = null;
        if (medio.equalsIgnoreCase("Terrestre")) {
            System.out.println("Ingrese el tipo de transporte terrestre: ");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el número de ruedas del transporte terrestre: ");
            int ruedas = Integer.valueOf(sc.nextLine());
            transporte2 = new Terrestre(nombre, medio, tipo, capacidad, ruedas);
        } else if (medio.equalsIgnoreCase("Maritimo")) {
            System.out.println("Ingrese la eslora: ");
            double eslora = Double.valueOf(sc.nextLine());
            System.out.println("Ingrese el calado: ");
            int calado = Integer.valueOf(sc.nextLine());
            transporte2 = new Maritimo(nombre, medio, capacidad, eslora, calado);
        } else if (medio.equalsIgnoreCase("Aereo")) {
            System.out.println("Ingrese la envergadura: ");
            double envergadura = Double.valueOf(sc.nextLine());
            System.out.println("Ingrese la altura maxima: ");
            int altura_max = Integer.valueOf(sc.nextLine());
            transporte2 = new Aereo(nombre, medio, capacidad, envergadura, altura_max);
        }
        transportes_type.set(posicion,(T) transporte2);
    }

    public static <T extends Transporte> void eliminarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Eliminando el objeto en la posición " + posicion);
        transportes_type.remove(posicion);
    }

    public static <T extends Transporte> void menuSelec(Scanner sc, ArrayList<T> transportes_type) {
        int opt;
        T transporte;
        do { 
            System.out.println("---------Menu de opciones---------");
            System.out.println("--------------------------------");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Editar transporte");
            System.out.println("3. Eliminar transporte");
            System.out.println("4. Buscar transporte por posición");
            System.out.println("0. Salir");
            int posicion;
            opt = Integer.valueOf(sc.nextLine());
            switch (opt) {
                case 1:
                    añadirTransportes(sc, transportes_type);
                    break;
                case 2:
                    System.out.println("Transporte que desea editar: ");
                    posicion = Integer.valueOf(sc.nextLine()) - 1;
                    ModificarObjetoPorPosicion(posicion, transportes_type, sc);
                    break;

                case 3:
                   System.out.println("Transporte que desea eliminar por posición: ");
                    posicion = Integer.valueOf(sc.nextLine()) - 1;
                    eliminarObjetoPorPosicion(posicion, transportes_type);
                    break;

                case 4:
                    System.out.println("Posición que desea buscar: ");
                    posicion = Integer.valueOf(sc.nextLine()) - 1;
                    obtenerObjetoPorPosicion(posicion, transportes_type);
                    break;
                case 0:
                    System.out.println("exiting.... (exitando)");
                    break;
            
                default:
                    break;
            }
        } while (opt != 0);


    } 

    public static <T extends Transporte> void añadirTransportes(Scanner sc, ArrayList<T> transportes_type) {
        System.out.println("---------------Menu Para Añadir Transportes---------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese el nombre del transporte: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el medio del transporte (Terrestre/Maritimo/Aereo): ");
        String medio = sc.nextLine();
        System.out.println("Ingrese la capacidad del transporte: ");
        int capacidad = Integer.valueOf(sc.nextLine());
        
        Transporte transporte = null;
        if (medio.equalsIgnoreCase("Terrestre")) {
            System.out.println("Ingrese el tipo de transporte terrestre: ");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el número de ruedas del transporte terrestre: ");
            int ruedas = Integer.valueOf(sc.nextLine());
            transporte = new Terrestre(nombre, medio, tipo, capacidad, ruedas);
        } else if (medio.equalsIgnoreCase("Maritimo")) {
            System.out.println("Ingrese la eslora: ");
            double eslora = Double.valueOf(sc.nextLine());
            System.out.println("Ingrese el calado: ");
            int calado = Integer.valueOf(sc.nextLine());
            transporte = new Maritimo(nombre, medio, capacidad, eslora, calado);
        } else if (medio.equalsIgnoreCase("Aereo")) {
            System.out.println("Ingrese la envergadura: ");
            double envergadura = Double.valueOf(sc.nextLine());
            System.out.println("Ingrese la altura maxima: ");
            int altura_max = Integer.valueOf(sc.nextLine());
            transporte = new Aereo(nombre, medio, capacidad, envergadura, altura_max);
        }
        transportes_type.add((T) transporte);
    }

}
    
