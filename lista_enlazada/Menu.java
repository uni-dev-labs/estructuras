package lista_enlazada;

import java.util.Scanner;

import lista_enlazada.models.Transaccion;

public class Menu {

    ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
    Scanner sc = new Scanner(System.in);
    
    public void imprimirMenu(){
        Transaccion transaccion;
        Long idTransaccion;
        int posicion;
        int opt;
        do {
            System.out.println("*******************MENU*******************");
            System.out.println("1. Añadir transaccion al inicio");
            System.out.println("2. Añadir transaccion al final");
            System.out.println("3. Añadir transaccion en una posición");
            System.out.println("4. Buscar por id");
            System.out.println("5. Buscar por posición");
            System.out.println("6. Imprimir transacciones");
            System.out.println("7. Eliminar transaccion por id");  
            System.out.println("8. Eliminar transaccion por posicion");
            System.out.println("9. Eliminar todas las transacciones");
            System.out.println("0. Salir");
            opt = Integer.parseInt(sc.nextLine());
            switch (opt) {
                case 1: 
                    transaccion = pedirDatosTransaccion();
                    lista.insertarAlInicio(transaccion);
                    System.out.println("Transaccion insertada");
                    
                    break;
                case 2: 
                    transaccion = pedirDatosTransaccion();
                    lista.insertarAlFinal(transaccion);
                    System.out.println("Transaccion insertada");
                    break;
                case 3: 
                    System.out.println("Posicion en la que quieres agregar la transaccion");
                    posicion = Integer.parseInt(sc.nextLine());
                    transaccion = pedirDatosTransaccion();
                    lista.insertarEnPosicion(transaccion, posicion);
                    System.out.println("Transaccion insertada");
                    break;
                case 4: 
                    System.out.println("Id transaccion:");
                    idTransaccion = Long.parseLong(sc.nextLine());
                    if (!lista.contiene(idTransaccion)) {                           
                        System.out.println("No existe transaccion con ese id");
                        break;
                    }
                    posicion = lista.buscar(idTransaccion);
                    transaccion = lista.obtenerEnPosicion(posicion);            
                    System.out.println(transaccion);                            
                    break;
                case 5: 
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Posición transaccion:");
                    posicion = Integer.parseInt(sc.nextLine());
                    if(posicion < 0 || posicion >= lista.size()){
                        System.out.println("Posición inválida: " + posicion);
                        break;
                    }
                    transaccion = lista.obtenerEnPosicion(posicion);
                    System.out.println(transaccion);
                    break;
                case 6: 
                    lista.imprimir();
                    break;
                case 7:
                    System.out.println("Id transaccion:");
                    idTransaccion = Long.parseLong(sc.nextLine());
                    if (!lista.contiene(idTransaccion)) {                           
                        System.out.println("No existe transaccion con ese id");
                        break;
                    }
                    lista.eliminarPorId(idTransaccion);
                    break;
                case 8:
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Posición transaccion:");
                    posicion = Integer.parseInt(sc.nextLine());
                    if(posicion < 0 || posicion >= lista.size()){
                        System.out.println("Posición inválida: " + posicion);
                        break;
                    }
                    lista.eliminarEnPosicion(posicion);
                    break;
                case 9:
                    lista.limpiar();
                    System.out.println("Se han eliminado todas las transacciones");
                    break;
                case 0: 
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, escoga una opcion valida");
                    break;
            }
        } while (opt != 0);

    }

    public Transaccion pedirDatosTransaccion(){
        System.out.println("Id de la transaccion:");
        Long idTransaccion = Long.parseLong(sc.nextLine());
        System.out.println("Valor a transferir:");
        double value = Double.parseDouble(sc.nextLine());
        System.out.println("Numero de cuenta de salida:");
        String numCuentaSalida = sc.nextLine();
        System.out.println("Numero de cuenta de llegada:");
        String numCuentaLlegada = sc.nextLine();

        Transaccion transaccion = new Transaccion(idTransaccion, value, numCuentaSalida, numCuentaLlegada);
        return transaccion;
    }
}
