package ejercicios;

import java.util.Scanner;

public class ListasCircular {

    static class Nodo {
        String nombre;
        Nodo siguiente;

        Nodo(String nombre) {
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    static class ListaCircular {
        private Nodo cabeza;
        private int tamaño;

        ListaCircular() {
            cabeza = null;
            tamaño = 0;
        }

        void agregarAmigo(String nombre) {
            Nodo nuevo = new Nodo(nombre);
            if (cabeza == null) {
                cabeza = nuevo;
                cabeza.siguiente = cabeza;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
                nuevo.siguiente = cabeza;
            }
            tamaño++;
            System.out.println("Persona agregada: " + nombre);
        }

        void mostrarAmigos() {
            if (cabeza == null) {
                System.out.println("No hay personas en la lista.");
                return;
            }
            System.out.println("Personas en la lista (" + tamaño + "):");
            Nodo actual = cabeza;
            int i = 1;
            do {
                System.out.println("  " + i + ". " + actual.nombre);
                i++;
                actual = actual.siguiente;
            } while (actual != cabeza);
        }

        void jugar(int saltos) {
            if (cabeza == null) {
                System.out.println("No hay personas en la lista.");
                return;
            }

            System.out.println("Iniciando juego con " + saltos + " salto(s) por ronda...");
            Nodo actual = cabeza;

            while (tamaño > 1) {
                for (int i = 0; i < saltos - 1; i++) {
                    actual = actual.siguiente;
                }

                Nodo eliminado = actual.siguiente;
                actual.siguiente = eliminado.siguiente;

                if (eliminado == cabeza) {
                    cabeza = eliminado.siguiente;
                }

                tamaño--;
                System.out.println("Eliminado: " + eliminado.nombre);

                if (tamaño > 1) {
                    System.out.print("Quedan: ");
                    Nodo temp = cabeza;
                    do {
                        System.out.print(temp.nombre);
                        temp = temp.siguiente;
                        if (temp != cabeza)
                            System.out.print(", ");
                    } while (temp != cabeza);
                    System.out.println();
                }

                actual = actual.siguiente;
            }

            System.out.println("Ganador: " + cabeza.nombre);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();
        int opcion;

        do {
            System.out.println("\n--- MENU PAPA CALIENTE ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Jugar");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    lista.agregarAmigo(sc.nextLine());
                    break;

                case 2:
                    lista.mostrarAmigos();
                    break;

                case 3:
                    System.out.print("Cuantos saltos da la papa: ");
                    int saltos = Integer.parseInt(sc.nextLine());
                    lista.jugar(saltos);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}