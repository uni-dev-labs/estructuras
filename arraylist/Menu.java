import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        // scanner para leer lo que escribe el usuario
        Scanner sc = new Scanner(System.in);

        // arreglo donde se guardan los datos
        String datos[] = new String[10];

        int opcion = -1; // variable para el menu

        // ciclo para que el menu se repita
        do {

            System.out.println("---- MENU ----");
            System.out.println("1 Crear dato");
            System.out.println("2 Buscar dato");
            System.out.println("3 Actualizar dato");
            System.out.println("4 Eliminar dato");
            System.out.println("0 Salir");

            System.out.print("Digite una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion){

                case 1:
                    // crear dato en el arreglo
                    System.out.print("posicion (0-9): ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("dato a guardar: ");
                    String dato = sc.nextLine();

                    datos[pos] = dato; // guardamos en el array
                    System.out.println("dato guardado");
                break;

                case 2:
                    // buscar dato
                    System.out.print("posicion a buscar: ");
                    pos = sc.nextInt();

                    if(datos[pos] != null){
                        System.out.println("el dato es: " + datos[pos]);
                    }else{
                        System.out.println("no hay dato ahi");
                    }
                break;

                case 3:
                    // actualizar dato
                    System.out.print("posicion a cambiar: ");
                    pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("nuevo dato: ");
                    datos[pos] = sc.nextLine();

                    System.out.println("dato actualizado");
                break;

                case 4:
                    // eliminar dato
                    System.out.print("posicion a borrar: ");
                    pos = sc.nextInt();

                    datos[pos] = null;
                    System.out.println("dato eliminado");
                break;

                case 0:
                    System.out.println("fin del programa");
                break;

                default:
                    System.out.println("esa opcion no existe");

            }

        }while(opcion != 0);

        // cerramos el scanner
        sc.close();
    }
}