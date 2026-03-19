package lista_enlazada;

import java.util.Scanner;

public class Menu {
    public static void iniciarMenu() {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Menu lista enlazada simple ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Eliminar por valor");
            System.out.println("5. Eliminar por posición");
            System.out.println("6. Buscar valor");
            System.out.println("7. Obtener valor en posición");
            System.out.println("8. Ver tamaño");
            System.out.println("9. Imprimir lista");
            System.out.println("10. Limpiar lista");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un valor para insertar al inicio: ");
                    int valorInicio = sc.nextInt();
                    lista.insertarAlInicio(valorInicio);
                    System.out.println("Valor :" + valorInicio + " insertado al inicio.");
                    lista.imprimir();
                    break;

                case 2:
                    System.out.println("Ingrese un valor para insertar al final: ");
                    int ValorFinal = sc.nextInt();
                    lista.insertarAlFinal(ValorFinal);
                    System.out.println("Valor :" + ValorFinal + " insertado al final.");
                    lista.imprimir();
                    break;

                case 3:
                    System.out.println("Ingrese un valor para insertar: ");
                    int valorPos = sc.nextInt();
                    System.out.println("Ingrese la posición para insertar: ");
                    int pos = sc.nextInt();
                    try {
                        lista.insertarEnPosicion(valorPos, pos);
                        System.out.println("Valor :" + valorPos + " insertado en posición " + pos);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Ingrese un valor para eliminar: ");
                    int valorEliminar = sc.nextInt();
                    lista.eliminarPorValor(valorEliminar);
                    System.out.println("Valor :" + valorEliminar + " eliminado (si existía).");
                    lista.imprimir();
                    break;

                case 5:
                    System.out.println("Ingrese una posicion para eliminar: ");
                    int posiconEliminar = sc.nextInt();
                    lista.eliminarPorValor(posiconEliminar);
                    System.out.println("Valor en posición :" + posiconEliminar + " eliminado (si existía).");
                    lista.imprimir();
                    break;

                case 6:
                    System.out.println("Ingrese un valor para buscar: ");
                    int valorBuscar = sc.nextInt();
                    int posicion = lista.buscar(valorBuscar);
                    if (posicion != -1) {
                        System.out.println("Valor " + valorBuscar + " encontrado en posición: " + posicion);
                    } else {
                        System.out.println("Valor " + valorBuscar + " no encontrado en la lista.");
                    }
                    break;

                case 7:
                    System.out.println("Ingrese una posición para obtener el valor: ");
                    int posObtener = sc.nextInt();
                    try {
                        int valorEnPos = lista.obtenerEnPosicion(posObtener);
                        System.out.println("Valor en posición " + posObtener + ": " + valorEnPos);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;

                case 9:
                    System.out.println("Contenido de la lista:");
                    lista.imprimir();
                    break;

                case 10:
                    lista.limpiar();
                    System.out.println("Lista limpiada.");
                    lista.imprimir();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opcion != 0);
    }
}
