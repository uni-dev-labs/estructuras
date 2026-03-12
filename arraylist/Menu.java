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
    
            
            System.out.println("***************MENU TRANSPORTES***************");
            System.out.println("==============================================");
            System.out.println("1. Gestionar Transporte Terrestre");
            System.out.println("2. Gestionar Transporte Maritimos");
            System.out.println("3. Gestionar Transporte Aereo");
            System.out.println("0. Salir");
    
            opt = Integer.valueOf(sc.nextLine());
            switch (opt) {
                case 1:
                    printTerrestres();
                    menuGestionar(sc, transportes_terrestres);
                    break;
                case 2: 
                    printMaritimos();
                    menuGestionar(sc, transportes_maritimos);
                    break;
                case 3: 
                    printAereos();
                    menuGestionar(sc, transportes_aereos);
                    break;
                case 0: 
                    System.out.println("Saliendo...");
                    break;
            
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }
        } while (opt != 0);
    }

    public static <T extends Transporte> void menuGestionar(Scanner sc, ArrayList<T> transportes_type ){
        int opt;
        T transporte;
        do {
            System.out.println("1. Agregar transporte");
            System.out.println("2. Mofificar transporte por posicion");
            System.out.println("3. Buscar transporte por nombre");
            System.out.println("4. Buscar transporte por posición");
            System.out.println("5. Cantidad de Transportes");
            System.out.println("6. Imprimir Transportes");
            System.out.println("7. Eliminar transporte");
            System.out.println("0. Volver al menu principal");
            int posicion;
            opt = Integer.valueOf(sc.nextLine());
            switch (opt) {
                case 1: 
                    transporte = pedirDatosTransporte(sc, transportes_type);
                    transportes_type.add(transporte);
                    break;
                case 2:
                    System.out.println("Posicion: ");
                    posicion = Integer.parseInt(sc.nextLine()) - 1;
                    transporte = pedirDatosTransporte(sc, transportes_type);
                    modificarObjetoPorPosicion(posicion, transportes_type, transporte);
                    break;
                case 3: 
                    System.out.println("Nombre del transporte a buscar  ");
                    String nombre = sc.nextLine();
                    obtenerObjetoPorNombre(nombre, transportes_type);
                    break;
                case 4: 
                    System.out.println("Posición del transporte a buscar");
                    posicion = Integer.valueOf(sc.nextLine()) - 1;
                    obtenerObjetoPorPosicion(posicion, transportes_type);
                    break;
                case 5: 
                    obtenerTamañoDelArrayList(transportes_type);
                    break;
                case 6: 
                    printTransportes(transportes_type);
                    break;
                case 7: 
                    System.out.println("Posición del transporte a eliminar");
                    posicion = Integer.valueOf(sc.nextLine());
                    eliminarObjetoPorPosicion(posicion, transportes_type);
                    break;
                case 0: 
                    System.out.println("Volviendo...");
                    break;
            
                default:
                    System.out.println("Opcion inexistente, vuelva a intentarlo");
                    break;
            }
        } while (opt != 0);

    }

    public static void printTerrestres() {
        System.out.println("*****************TERRESTRES********************");
        System.out.println("==============================================");
    }
        
    public static void printMaritimos() {
        System.out.println("*****************MARITIMOS********************");
        System.out.println("==============================================");
    }

    public static void printAereos() {
        System.out.println("*****************AEREOS********************");
        System.out.println("==============================================");
        //printTransportes(transportes_aereos); 
    }

    public static <T extends Transporte> void printTransportes(ArrayList<T> transportes_type){
        for(T transporte : transportes_type) {
            System.out.println("Transporte: " + transporte.getNombre() + " - " + transporte.getMedio());
        }
    }

    public static <T extends Transporte> T pedirDatosTransporte(Scanner sc,ArrayList<T> transportes_type){
        Transporte transporte;
        System.out.println("Nombre transporte: ");
        String nombre = sc.nextLine();
        System.out.println("Capacidad: ");
        int capacidad = Integer.parseInt(sc.nextLine());
        if (transportes_type.getFirst() instanceof Aereo) {
            String medio = "Aereo";
            System.out.println("Envergadura:");
            double envergadura = Double.parseDouble(sc.nextLine());
            System.out.println("Altura maxima:");
            int altura_max = Integer.parseInt(sc.nextLine());
            transporte = new Aereo(nombre, medio, capacidad, envergadura, altura_max);
            return (T) transporte;
            
        } else if (transportes_type.getFirst() instanceof Maritimo) {
            String medio = "Maritimo";
            System.out.println("Eslora:");
            double eslora = Double.parseDouble(sc.nextLine());
            System.out.println("Calado: ");
            int calado = Integer.parseInt(sc.nextLine());
            
            transporte = new Maritimo(nombre, medio, capacidad, eslora, calado);
            return (T) transporte;
        } else {
            String medio = "Terrestre";
            System.out.println("Numero de ruedas: ");
            int numero_ruedas = Integer.parseInt(sc.nextLine());
            System.out.println("Tipo: ");
            String tipo = sc.nextLine();

            transporte = new Terrestre(nombre, medio, tipo, capacidad, numero_ruedas);
            return (T) transporte;
        }

        //transportes_type.add((T) transporte);

    }

    public static <T extends Transporte> void añadirNuevoTransporte(int posicion, ArrayList<T> transportes_type, T transporte) {
        System.out.println("Añadiendo un nuevo transporte en la posición " + posicion);
        transportes_type.add(posicion, transporte);
    }

    public static <T> void obtenerTamañoDelArrayList(ArrayList<T> transportes_type) {
        System.out.println("Tamaño del ArrayList: " + transportes_type.size());
    }

    public static <T extends Transporte> void obtenerObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Objeto en la posición " + (posicion + 1) + " la instancia del objeto en memoria: " + transportes_type.get(posicion));
        System.out.println("Objeto en la posición " + (posicion + 1) + ": " + transportes_type.get(posicion).getCapacidad());
    }


    public static <T extends Transporte> T obtenerObjetoPorNombre(String nombre, ArrayList<T> transportes_type) {
        try {
            for(T transporte : transportes_type) {
                if(transporte.getNombre().equals(nombre)) {
                    System.out.println("Transporte:  " + transporte.getNombre()  + "- medio:" + transporte. getMedio() + "- capacidad:" + transporte.getCapacidad());
                    return transporte;
                }
            }
            throw new IndexOutOfBoundsException("Objeto no encontrado");    
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public static <T extends Transporte> void modificarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type, T transporte) {
        System.out.println("Modificando el objeto en la posición " + posicion);
        transportes_type.set(posicion, transporte);
    }

    public static <T extends Transporte> void eliminarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Eliminando el objeto en la posición " + posicion);
        transportes_type.remove(posicion);
    }
}
