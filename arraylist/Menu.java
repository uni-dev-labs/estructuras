package arraylist;

import arraylist.Main;
import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {

    public static void mostrarMenu(ArrayList<Terrestre> terrestres, ArrayList<Maritimo> maritimos,
            ArrayList<Aereo> aereos) {

        Scanner options = new Scanner(System.in);
        int select;
        int subSelect;

        do {
            System.out.println("|--------------------------------------|");
            System.out.println("|             Menu Principal           |");
            System.out.println("|--------------------------------------|");
            System.out.println("|Presiona                              |");
            System.out.println("| 1. Transportes terrestres            |");
            System.out.println("| 2. Transportes maritimos             |");
            System.out.println("| 3. Transportes aereos                |");
            System.out.println("| 0. Salir                             |");
            System.out.println("|--------------------------------------|");
            select = Integer.parseInt(options.nextLine());

            switch (select) {
                case 1:
                    Main.printTransportesTerrestres(terrestres);
                    System.out.println("|--------------------------------------|");
                    System.out.println("|       Transportes terrestres         |");
                    System.out.println("|--------------------------------------|");
                    System.out.println("|Selecciona:                           |");
                    System.out.println("| 1. Ver lista                         |");
                    System.out.println("| 2. Agregar dato                      |");
                    System.out.println("| 3. Modificar dato                    |");
                    System.out.println("| 4. Eliminar dato                     |");
                    System.out.println("| 0. Salir                             |");
                    System.out.println("|--------------------------------------|");
                    subSelect = Integer.parseInt(options.nextLine());
                    if (subSelect != 0) {

                    }
                    break;
                case 2:
                    Main.printTransportesMaritimos(maritimos);
                    break;
                case 3:
                    Main.printTransportesAereos(aereos);
                    break;
                case 0:

                    break;
                default:
                    break;
            }
        } while ((select) != 0);

    }
}
