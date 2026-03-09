package arraylist;

import java.util.ArrayList;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Main {

    

    public static void main(String[] args) {
        // Crear los arrays de transportes
        ArrayList<Terrestre> transportes_terrestres = new ArrayList<Terrestre>();
        ArrayList<Maritimo> transportes_maritimos   = new ArrayList<Maritimo>();
        ArrayList<Aereo>    transportes_aereos      = new ArrayList<Aereo>();

        // // Llenar los arrays de transportes
        llenarTransportesTerrestres(transportes_terrestres);
        llenarTransportesMaritimos(transportes_maritimos);
        llenarTransportesAereos(transportes_aereos);

        // Imprimir los arrays de transportes
        printTransportesTerrestres(transportes_terrestres);
        printTransportesMaritimos(transportes_maritimos);
        printTransportesAereos(transportes_aereos);

        // Añadir un nuevo transporte terrestre en la posición 2
        añadirNuevoTransporte(2, transportes_terrestres, new Terrestre("Bicicleta", "Terrestre", "carretera", 2, 2));
        printTransportesTerrestres(transportes_terrestres);


        // Obtener el tamaño del ArrayList de transportes terrestres
        obtenerTamañoDelArrayList(transportes_terrestres);

        // Obtener el objeto por posición
        obtenerObjetoPorPosicion(2, transportes_terrestres);

        // Obtener el objeto por nombre
        final Aereo transporte_uno = obtenerObjetoPorNombre("Aereo", transportes_aereos);
        if(transporte_uno != null) 
            System.out.println("Transporte terrestre: " + transporte_uno.getNombre());


        // // Modificar el objeto por posición
        ModificarObjetoPorPosicion(2, transportes_aereos, new Aereo("Drone dos . 0", "Aereo", 3000, 30, 3));
        printTransportesAereos(transportes_aereos);

        // // Eliminar el objeto por posición
        eliminarObjetoPorPosicion(2, transportes_aereos);
        printTransportesAereos(transportes_aereos);



        // ArrayList<Transporte> transportes = new ArrayList<Transporte>();
        // transportes.addAll(transportes_terrestres);
        // transportes.addAll(transportes_maritimos);
        // transportes.addAll(transportes_aereos);
        

        // for(Transporte transporte : transportes) {
        //     System.out.println("Transporte: " + transporte.getNombre() + " - " + transporte.getMedio());
        // }

    }


    public static void llenarTransportesTerrestres(ArrayList<Terrestre> transportes_terrestres) {
        transportes_terrestres.add(new Terrestre("Tren", "Terrestre", "rieles", 30000, 0));
        transportes_terrestres.add(new Terrestre("camion", "Terrestre", "carretera", 7500, 8));
        transportes_terrestres.add(new Terrestre("automovil", "Terrestre", "carretera", 5, 4));
        transportes_terrestres.add(new Terrestre("motocicleta", "Terrestre", "carretera", 2, 2));
    }
    
    public static void llenarTransportesMaritimos(ArrayList<Maritimo> transportes_maritimos) {
        transportes_maritimos.add(new Maritimo("Barco", "Maritimo", 10000, 100, 10));
        transportes_maritimos.add(new Maritimo("Yate", "Maritimo", 5000, 50, 5));
        transportes_maritimos.add(new Maritimo("Lancha", "Maritimo", 3000, 30, 3));
        transportes_maritimos.add(new Maritimo("Lancha", "Maritimo", 3000, 30, 3));
    }

    public static void llenarTransportesAereos(ArrayList<Aereo> transportes_aereos) {
        transportes_aereos.add(new Aereo("Avion", "Aereo", 10000, 100, 10));
        transportes_aereos.add(new Aereo("Helicoptero", "Aereo", 5000, 50, 5));
        transportes_aereos.add(new Aereo("Drone", "Aereo", 3000, 30, 3));
    }

    public static void printTransportesTerrestres(ArrayList<Terrestre> transportes_terrestres) {
        System.out.println("*****************TERRESTRES********************");
        System.out.println("==============================================");

        for(Terrestre terrestre : transportes_terrestres) {
            System.out.println("Transportes Terrestres: " + terrestre.getNombre() + " - " + terrestre.getMedio());
        }
    }
        
    public static void printTransportesMaritimos(ArrayList<Maritimo> transportes_maritimos) {
        System.out.println("*****************MARITIMOS********************");
        System.out.println("==============================================");

        for(Maritimo maritimo : transportes_maritimos) {
            System.out.println("Transportes Maritimos: " + maritimo.getNombre() + " - " + maritimo.getMedio());
        }
    }

    public static void printTransportesAereos(ArrayList<Aereo> transportes_aereos) {
        System.out.println("*****************AEREOS********************");
        System.out.println("==============================================");

        for(Aereo aereo : transportes_aereos) {
            System.out.println("Transportes Aereos: " + aereo.getNombre() + " - " + aereo.getMedio());
        }
    }


    public static <T> void añadirNuevoTransporte(int posicion, ArrayList<T> transportes_type, T transporte) {
        System.out.println("Añadiendo un nuevo transporte en la posición " + posicion);
        transportes_type.add(posicion, transporte);
    }

    public static <T> void obtenerTamañoDelArrayList(ArrayList<T> transportes_type) {
        System.out.println("Tamaño del ArrayList: " + transportes_type.size());
    }

    public static <T extends Transporte> void obtenerObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Objeto en la posición " + posicion + " la instancia del objeto en memoria: " + transportes_type.get(posicion));
        System.out.println("Objeto en la posición " + posicion + ": " + transportes_type.get(posicion).getCapacidad());
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
    
    public static <T extends Transporte> void ModificarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type, T transporte) {
        System.out.println("Modificando el objeto en la posición " + posicion);
        transportes_type.set(posicion, transporte);
    }

    public static <T extends Transporte> void eliminarObjetoPorPosicion(int posicion, ArrayList<T> transportes_type) {
        System.out.println("Eliminando el objeto en la posición " + posicion);
        transportes_type.remove(posicion);
    }
}

