package lista_enlazada.entities;

import java.util.Scanner;

public class MenuLinkedList {
    
    private static Scanner sc = new Scanner(System.in);

    // Este es el motor de arranque
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.out.println("Error fatal: " + e.getMessage());
        }
    }
    
    private static void menu() {
        int i = -1;
        ListaEnlazadaTransaccion lista = new ListaEnlazadaTransaccion();
        
        do {
            System.out.println("\n=== MENÚ PRINCIPAL DE TRANSACCIONES ===");
            System.out.println("1. Agregar Transacción");
            System.out.println("2. Eliminar Transacción");
            System.out.println("3. Buscar por Índice");
            System.out.println("4. Mostrar todas las Transacciones");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            try {
                i = Integer.parseInt(sc.nextLine()); // Leemos la opción
                
                switch (i) {
                    case 1:
                        agregar(lista);
                        break;
                    case 2:
                        eliminar(lista);
                        break;
                    case 3:
                        System.out.print("Dame el índice para buscar: ");
                        int index = Integer.parseInt(sc.nextLine());
                        NodeTransaccion node = lista.searchPerIndex(index);
                        System.out.println("\nTransacción encontrada: " + node.getValue());
                        break;
                    case 4:
                        NodeTransaccion actual = lista.getHead();
                        if (actual != null) {
                            System.out.println("\n--- LISTA DE TRANSACCIONES ---");
                            int posicion = 1;
                            while (actual != null) {
                                System.out.println(posicion + ". " + actual.getValue());
                                actual = actual.getNext();
                                posicion++;
                            }
                            System.out.println("Total de elementos: " + lista.getLenght());
                        } else {
                            System.out.println("\nLa lista está vacía. No hay Data.");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del programa... ¡Nos vemos panita!");
                        break;
                    default:
                        System.out.println("Opción no válida. Ingresa un número del 0 al 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Error! Por favor, ingresa un número válido, no letras.");
            } catch (Exception e) {
                System.out.println("Aviso: " + e.getMessage());
            }
            
        } while (i != 0);
    }
    
    private static void agregar(ListaEnlazadaTransaccion lista) {
        try {
            System.out.println("\n--- SUBMENÚ AGREGAR ---");
            System.out.println("1. Agregar al inicio");
            System.out.println("2. Agregar al final");
            System.out.println("3. Agregar por índice");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());
            
            System.out.print("Ingresa el monto de la transacción: ");
            double monto = Double.parseDouble(sc.nextLine());
            System.out.print("Ingresa el número de cuenta: ");
            String cuenta = sc.nextLine();
            
            Transaccion nueva = new Transaccion(monto, cuenta);
            
            switch (opcion) {
                case 1:
                    lista.addFirstTrans(nueva);
                    System.out.println("Agregado al inicio con éxito.");
                    break;
                case 2:
                    lista.addLastTrans(nueva);
                    System.out.println("Agregado al final con éxito.");
                    break;
                case 3:
                    System.out.print("Ingresa la posición exacta: ");
                    int pos = Integer.parseInt(sc.nextLine());
                    lista.addForIndexTrans(nueva, pos);
                    System.out.println("Agregado en la posición " + pos + " con éxito.");
                    break;
                default:
                    System.out.println("Opción de agregar no válida.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar números para las opciones y los montos.");
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }
    
    private static void eliminar(ListaEnlazadaTransaccion lista) {
        try {
            System.out.println("\n--- SUBMENÚ ELIMINAR ---");
            System.out.println("1. Eliminar al inicio");
            System.out.println("2. Eliminar al final");
            System.out.println("3. Eliminar por índice");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1:
                    lista.removeFirstTrans();
                    System.out.println("Primer elemento eliminado.");
                    break;
                case 2:
                    lista.removeLastTrans();
                    System.out.println("Último elemento eliminado.");
                    break;
                case 3:
                    System.out.print("Ingresa la posición a eliminar: ");
                    int pos = Integer.parseInt(sc.nextLine());
                    lista.removeForIndexTrans(pos);
                    System.out.println("Elemento en la posición " + pos + " eliminado.");
                    break;
                default:
                    System.out.println("Opción de eliminar no válida.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido.");
        } catch (Exception e) {
            System.out.println("Aviso: " + e.getMessage());
        }
    }
}