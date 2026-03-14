package arraylist;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<Terrestre> terrestres = new ArrayList<>();
    ArrayList<Maritimo> maritimos = new ArrayList<>();
    ArrayList<Aereo> aereos = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void menuTransportes(){

        int opcion;

        do{

            System.out.println("----- MENU -----");
            System.out.println("1. Imprimir transportes");
            System.out.println("2. Agregar transporte");
            System.out.println("3. Actualizar transporte");
            System.out.println("4. Buscar transporte");
            System.out.println("5. Eliminar transporte");
            System.out.println("6. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){

                case 1:

                    System.out.println("--- TERRESTRES ---");
                    for(int i = 0; i < terrestres.size(); i++){
                        System.out.println(i + " " + terrestres.get(i).getNombre());
                    }

                    System.out.println("--- MARITIMOS ---");
                    for(int i = 0; i < maritimos.size(); i++){
                        System.out.println(i + " " + maritimos.get(i).getNombre());
                    }

                    System.out.println("--- AEREOS ---");
                    for(int i = 0; i < aereos.size(); i++){
                        System.out.println(i + " " + aereos.get(i).getNombre());
                    }

                break;

                case 2:

                    System.out.println("Tipo de transporte:");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");

                    int tipo = sc.nextInt();

                    System.out.println("Posicion:");
                    int posicion = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    switch(tipo){

                        case 1:
                            Main.añadirNuevoTransporte(posicion, terrestres,
                            new Terrestre(nombre,"Terrestre","carretera",4,4));
                        break;

                        case 2:
                            Main.añadirNuevoTransporte(posicion, maritimos,
                            new Maritimo(nombre,"Maritimo",1000,20,3));
                        break;

                        case 3:
                            Main.añadirNuevoTransporte(posicion, aereos,
                            new Aereo(nombre,"Aereo",2000,10,2));
                        break;

                    }

                break;

                case 3:

                    System.out.println("Tipo:");
                    System.out.println("1. Terrestre");
                    System.out.println("2. Maritimo");
                    System.out.println("3. Aereo");

                    int tipoActualizar = sc.nextInt();

                    System.out.println("Posicion:");
                    int actualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nuevo nombre:");
                    String nuevoNombre = sc.nextLine();

                    switch(tipoActualizar){

                        case 1:
                            Main.actualizarObjetoPorPosicion(actualizar, terrestres,
                            new Terrestre(nuevoNombre,"Terrestre","carretera",4,4));
                        break;

                        case 2:
                            Main.actualizarObjetoPorPosicion(actualizar, maritimos,
                            new Maritimo(nuevoNombre,"Maritimo",1000,20,3));
                        break;

                        case 3:
                            Main.actualizarObjetoPorPosicion(actualizar, aereos,
                            new Aereo(nuevoNombre,"Aereo",2000,10,2));
                        break;

                    }

                break;

                case 4:

                    System.out.println("Nombre a buscar:");
                    String buscar = sc.nextLine();

                    for(Terrestre t : terrestres){
                        if(t.getNombre().equals(buscar)){
                            System.out.println("Encontrado en terrestres");
                        }
                    }

                    for(Maritimo m : maritimos){
                        if(m.getNombre().equals(buscar)){
                            System.out.println("Encontrado en maritimos");
                        }
                    }

                    for(Aereo a : aereos){
                        if(a.getNombre().equals(buscar)){
                            System.out.println("Encontrado en aereos");
                        }
                    }

                break;

                case 5:

                    System.out.println("Tipo:");
                    System.out.println("1 Terrestre");
                    System.out.println("2 Maritimo");
                    System.out.println("3 Aereo");

                    int tipoEliminar = sc.nextInt();

                    System.out.println("Posicion:");
                    int eliminar = sc.nextInt();

                    switch(tipoEliminar){

                        case 1:
                            Main.eliminarObjetoPorPosicion(eliminar, terrestres);
                        break;

                        case 2:
                            Main.eliminarObjetoPorPosicion(eliminar, maritimos);
                        break;

                        case 3:
                            Main.eliminarObjetoPorPosicion(eliminar, aereos);
                        break;

                    }

                break;

            }

        }while(opcion != 6);

    }

}