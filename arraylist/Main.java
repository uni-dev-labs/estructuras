package arraylist;

import java.util.ArrayList;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;
import arraylist.menu; 

public class Main {

    public static void main(String[] args) {

       
        ArrayList<Terrestre> transportes_terrestres = new ArrayList<Terrestre>();
        ArrayList<Maritimo> transportes_maritimos = new ArrayList<Maritimo>();
        ArrayList<Aereo> transportes_aereos = new ArrayList<Aereo>();

        
        llenarTransportesTerrestres(transportes_terrestres);
        llenarTransportesMaritimos(transportes_maritimos);
        llenarTransportesAereos(transportes_aereos);

        
        menu.iniciarMenu(transportes_terrestres, transportes_maritimos, transportes_aereos);

        
        printTransportesTerrestres(transportes_terrestres);
        printTransportesMaritimos(transportes_maritimos);
        printTransportesAereos(transportes_aereos);

        
        añadirNuevoTransporte(2, transportes_terrestres, new Terrestre("Bicicleta", "Terrestre", "carretera", 2, 2));
        printTransportesTerrestres(transportes_terrestres);

        
        obtenerTamañoDelArrayList(transportes_terrestres);

        
        obtenerObjetoPorPosicion(2, transportes_terrestres);

        
        final Aereo transporte_uno = obtenerObjetoPorNombre("Aereo", transportes_aereos);
        if (transporte_uno != null)
            System.out.println("Transporte aereo: " + transporte_uno.getNombre());

        
        ModificarObjetoPorPosicion(2, transportes_aereos, new Aereo("Drone dos . 0", "Aereo", 3000, 30, 3));
        printTransportesAereos(transportes_aereos);

        
        eliminarObjetoPorPosicion(2, transportes_aereos);
        printTransportesAereos(transportes_aereos);
    }

    private static void eliminarObjetoPorPosicion(int i, ArrayList<Aereo> transportes_aereos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarObjetoPorPosicion'");
    }

    private static void ModificarObjetoPorPosicion(int i, ArrayList<Aereo> transportes_aereos, Aereo aereo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ModificarObjetoPorPosicion'");
    }

    private static Aereo obtenerObjetoPorNombre(String string, ArrayList<Aereo> transportes_aereos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerObjetoPorNombre'");
    }

    private static void obtenerObjetoPorPosicion(int i, ArrayList<Terrestre> transportes_terrestres) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerObjetoPorPosicion'");
    }

    private static void obtenerTamañoDelArrayList(ArrayList<Terrestre> transportes_terrestres) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTamañoDelArrayList'");
    }

    private static void añadirNuevoTransporte(int i, ArrayList<Terrestre> transportes_terrestres, Terrestre terrestre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'añadirNuevoTransporte'");
    }

    private static void printTransportesAereos(ArrayList<Aereo> transportes_aereos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTransportesAereos'");
    }

    private static void printTransportesMaritimos(ArrayList<Maritimo> transportes_maritimos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTransportesMaritimos'");
    }

    private static void printTransportesTerrestres(ArrayList<Terrestre> transportes_terrestres) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTransportesTerrestres'");
    }

    private static void llenarTransportesAereos(ArrayList<Aereo> transportes_aereos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarTransportesAereos'");
    }

    private static void llenarTransportesMaritimos(ArrayList<Maritimo> transportes_maritimos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarTransportesMaritimos'");
    }

    private static void llenarTransportesTerrestres(ArrayList<Terrestre> transportes_terrestres) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarTransportesTerrestres'");
    }
}