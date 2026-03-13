package arraylist;

import java.util.ArrayList;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Main {

    public static void main(String[] args) {

        // Crear los arrays de transportes
        ArrayList<Terrestre> transportes_terrestres = new ArrayList<>();
        ArrayList<Maritimo> transportes_maritimos = new ArrayList<>();
        ArrayList<Aereo> transportes_aereos = new ArrayList<>();

        // Llenar los arrays
        llenarTransportesTerrestres(transportes_terrestres);
        llenarTransportesMaritimos(transportes_maritimos);
        llenarTransportesAereos(transportes_aereos);

        // LLAMAR EL MENU
       Menu.iniciarMenu();

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
    }

    public static void llenarTransportesAereos(ArrayList<Aereo> transportes_aereos) {
        transportes_aereos.add(new Aereo("Avion", "Aereo", 10000, 100, 10));
        transportes_aereos.add(new Aereo("Helicoptero", "Aereo", 5000, 50, 5));
        transportes_aereos.add(new Aereo("Drone", "Aereo", 3000, 30, 3));
    }
}