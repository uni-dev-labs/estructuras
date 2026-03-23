package lista_enlazada.models;

import java.util.Scanner;

import lista_enlazada.ListaEnlazadaSimple;

public class Menu {
   private ListaEnlazadaSimple listaEnlazadaSimple;
   private Scanner sc;
   public Menu(){
    listaEnlazadaSimple= new ListaEnlazadaSimple();
    sc= new Scanner(System.in);
   }
   public void mostrarMenu(){
    int option;
    do{
       System.out.println("\n===== MENÚ LISTA ENLAZADA =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Eliminar por valor");
            System.out.println("5. Eliminar en posición");
            System.out.println("6. Buscar valor");
            System.out.println("7. Obtener valor en posición");
            System.out.println("8. Mostrar lista");
            System.out.println("9. Tamaño de la lista");
            System.out.println("10. Limpiar lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Ingrese valor: ");
                    int valInicio = sc.nextInt();
                    listaEnlazadaSimple.insertarAlInicio(valInicio);
                    break;

                case 2:
                    System.out.print("Ingrese valor: ");
                    int valFinal = sc.nextInt();
                    listaEnlazadaSimple.insertarAlFinal(valFinal);
                    break;

                case 3:
                    System.out.print("Ingrese valor: ");
                    int valPos = sc.nextInt();
                    System.out.print("Ingrese posición: ");
                    int posInsertar = sc.nextInt();
                    try {
                        listaEnlazadaSimple.insertarEnPosicion(valPos, posInsertar);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese valor a eliminar: ");
                    int valEliminar = sc.nextInt();
                    listaEnlazadaSimple.eliminarPorValor(valEliminar);
                    break;

                case 5:
                    System.out.print("Ingrese posición a eliminar: ");
                    int posEliminar = sc.nextInt();
                    try {
                        listaEnlazadaSimple.eliminarEnPosicion(posEliminar);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Ingrese valor a buscar: ");
                    int valBuscar = sc.nextInt();
                    int posicion = listaEnlazadaSimple.buscar(valBuscar);
                    if (posicion != -1) {
                        System.out.println("Valor encontrado en posición: " + posicion);
                    } else {
                        System.out.println("Valor no encontrado");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese posición: ");
                    int posObtener = sc.nextInt();
                    try {
                        int valor = listaEnlazadaSimple.obtenerEnPosicion(posObtener);
                        System.out.println("Valor en posición " + posObtener + ": " + valor);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    listaEnlazadaSimple.imprimir();
                    break;

                case 9:
                    System.out.println("Tamaño de la lista: " + listaEnlazadaSimple.size());
                    break;

                case 10:
                    listaEnlazadaSimple.limpiar();
                    System.out.println("Lista limpiada");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida"); 
    }
   }while (option != 0);

        sc.close();
}
}
