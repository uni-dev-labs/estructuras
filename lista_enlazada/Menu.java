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
            try {
                opt = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Debe colocar un número entero"); 
                opt = -1;
            }
            switch (opt) {
                case 1: 
                    transaccion = pedirDatosTransaccion();
                    if (transaccion == null) {
                        System.out.println("No se puede crear una transaccion");
                        break;
                    }
                    lista.insertarAlInicio(transaccion);
                    System.out.println("Transaccion insertada");
                    
                    break;
                case 2: 
                    transaccion = pedirDatosTransaccion();
                    if (transaccion == null) {
                        System.out.println("No se puede crear una transaccion");
                        break;
                    }
                    lista.insertarAlFinal(transaccion);
                    System.out.println("Transaccion insertada");
                    break;
                case 3: 
                    System.out.println("Posicion en la que quieres agregar la transaccion");
                    try {
                        //El usuario coloca la posicion humana
                        //posicion 0 el usuario lo pone como 1
                        //se hace la correccion aqui para que el resto del sistema funcione 
                        posicion = Integer.parseInt(sc.nextLine()) - 1; 
                    } catch (Exception e) {
                        System.out.println("Debe colocar un número entero");   
                        break;
                    }
                    if(posicion < 0 || posicion > lista.size()){
                        //Se devuelve posicion humana, entonces se corrije
                        System.out.println("Posición inválida: " + (posicion + 1));
                        break;
                    }
                    transaccion = pedirDatosTransaccion();
                    if (transaccion == null) {
                        System.out.println("No se puede crear una transaccion");
                        break;
                    }
                    lista.insertarEnPosicion(transaccion, posicion);
                    System.out.println("Transaccion insertada");
                    break;
                case 4: 
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Id transaccion:");
                    try {
                        idTransaccion = Long.parseLong(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Debe colocar un número entero para el id");   
                        break;
                    }
                    if (!lista.contiene(idTransaccion)) {                           
                        System.out.println("No existe transaccion con el id " + idTransaccion);
                        break;
                    }
                    //aqui el programa no devuelve posicion humana, por lo que no se hae correccion
                    posicion = lista.buscar(idTransaccion);
                    transaccion = lista.obtenerEnPosicion(posicion);  
                    if (transaccion == null) {
                        System.out.println("No se puede crear una transaccion");
                        break;
                    }          
                    System.out.println(transaccion);                            
                    break;
                case 5: 
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Posición transaccion:");
                    try {
                        posicion = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        System.out.println("Debe colocar un número entero");   
                        break;
                    }
                    if(posicion < 0 || posicion >= lista.size()){
                        System.out.println("Posición inválida: " + (posicion + 1));
                        break;
                    }
                    transaccion = lista.obtenerEnPosicion(posicion);
                    System.out.println(transaccion);
                    break;
                case 6: 
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    lista.imprimir();
                    break;
                case 7:
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Id transaccion:");
                    try {
                        idTransaccion = Long.parseLong(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Id invalido, debe colocar un número entero para el id");   
                        break;
                    }
                    if (!lista.contiene(idTransaccion)) {                           
                        System.out.println("No existe transaccion con el id " + idTransaccion);
                        break;
                    }
                    lista.eliminarPorId(idTransaccion);
                    System.out.println("Transaccion con id " + idTransaccion + " eliminada");
                    break;
                case 8:
                    if(lista.size() == 0){
                        System.out.println("No existen transacciones");
                        break;
                    }
                    System.out.println("Posición transaccion:");
                    try {
                        posicion = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        System.out.println("Posicion invalida, debe colocar un número entero");   
                        break;
                    }
                    if(posicion < 0 || posicion >= lista.size()){
                        System.out.println("Posición inválida: " + (posicion + 1));
                        break;
                    }
                    lista.eliminarEnPosicion(posicion);
                    //se imprime indice humano, se coloca + 1 porque el programa maneja el indice normal
                    System.out.println("Transaccion en posicion " + (posicion + 1) + " eliminada");
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
        System.out.println("Id de la transaccion (El valor debe ser un número entero):");
        Long idTransaccion;
        try {
            idTransaccion = Long.parseLong(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Id invalido, debe ser un número entero");   
            return null;
        }
        if (lista.idExistente(idTransaccion)) {
            System.out.println("Id existente, por favor coloque un id diferente");
            return null;
        }
        System.out.println("Valor a transferir (Debe ser un número):");
        double value;
        try {
            value = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Valor invalido, debe ser un número");
            return null;   
        }
        System.out.println("Numero de cuenta de salida:");
        String numCuentaSalida = sc.nextLine();
        System.out.println("Numero de cuenta de llegada:");
        String numCuentaLlegada = sc.nextLine();

        Transaccion transaccion = new Transaccion(idTransaccion, value, numCuentaSalida, numCuentaLlegada);
        return transaccion;
    }
}
