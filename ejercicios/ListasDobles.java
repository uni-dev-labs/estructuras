package ejercicios;

import java.util.Scanner;

public class ListasDobles {

    static class Nodo {
        String titulo;
        String artista;
        Nodo anterior;
        Nodo siguiente;

        Nodo(String titulo, String artista) {
            this.titulo = titulo;
            this.artista = artista;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    static class ListaDobleEnlazada {
        private Nodo cabeza;
        private Nodo cola;
        private int tamaño;

        ListaDobleEnlazada() {
            cabeza = null;
            cola = null;
            tamaño = 0;
        }

        void agregarAlFinal(String titulo, String artista) {
            Nodo nuevo = new Nodo(titulo, artista);
            if (cabeza == null) {
                cabeza = nuevo;
                cola = nuevo;
            } else {
                nuevo.anterior = cola;
                cola.siguiente = nuevo;
                cola = nuevo;
            }
            tamaño++;
            System.out.println("Cancion agregada: " + titulo + " - " + artista);
        }

        boolean eliminarPorNombre(String titulo) {
            if (cabeza == null) {
                System.out.println("La playlist esta vacia.");
                return false;
            }
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.titulo.equalsIgnoreCase(titulo)) {
                    if (actual.anterior != null) {
                        actual.anterior.siguiente = actual.siguiente;
                    } else {
                        cabeza = actual.siguiente;
                    }
                    if (actual.siguiente != null) {
                        actual.siguiente.anterior = actual.anterior;
                    } else {
                        cola = actual.anterior;
                    }
                    tamaño--;
                    System.out.println("Cancion eliminada: " + actual.titulo + " - " + actual.artista);
                    return true;
                }
                actual = actual.siguiente;
            }
            System.out.println("No se encontro la cancion: " + titulo);
            return false;
        }

        void mostrarNormal() {
            if (cabeza == null) {
                System.out.println("La playlist esta vacia.");
                return;
            }
            System.out.println("Playlist (" + tamaño + " cancion(es)):");
            Nodo actual = cabeza;
            int i = 1;
            while (actual != null) {
                System.out.println("  " + i + ". " + actual.titulo + " - " + actual.artista);
                i++;
                actual = actual.siguiente;
            }
        }

        void mostrarAlReves() {
            if (cola == null) {
                System.out.println("La playlist esta vacia.");
                return;
            }
            System.out.println("Playlist al reves (" + tamaño + " cancion(es)):");
            Nodo actual = cola;
            int i = tamaño;
            while (actual != null) {
                System.out.println("  " + i + ". " + actual.titulo + " - " + actual.artista);
                i--;
                actual = actual.anterior;
            }
        }

        void buscarCancion(String titulo) {
            Nodo actual = cabeza;
            int pos = 1;
            while (actual != null) {
                if (actual.titulo.equalsIgnoreCase(titulo)) {
                    System.out.println(
                            "Cancion encontrada en posicion " + pos + ": " + actual.titulo + " - " + actual.artista);
                    return;
                }
                actual = actual.siguiente;
                pos++;
            }
            System.out.println("Cancion no encontrada: " + titulo);
        }
    }

    public static void main(String[] args) {
        Scanner pasarTxto = new Scanner(System.in);
        Scanner pasarNumeros = new Scanner(System.in);
        ListaDobleEnlazada playlist = new ListaDobleEnlazada();

        int opcion;
        do {
            System.out.println("\n--- MENU PLAYLIST ---");
            System.out.println("1. Agregar cancion");
            System.out.println("2. Eliminar cancion");
            System.out.println("3. Mostrar playlist");
            System.out.println("4. Mostrar playlist al reves");
            System.out.println("5. Buscar cancion");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = pasarNumeros.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = pasarTxto.nextLine();
                    System.out.print("Artista: ");
                    String artista = pasarTxto.nextLine();
                    playlist.agregarAlFinal(titulo, artista);
                    break;

                case 2:
                    System.out.print("Titulo a eliminar: ");
                    playlist.eliminarPorNombre(pasarTxto.nextLine());
                    break;

                case 3:
                    playlist.mostrarNormal();
                    break;

                case 4:
                    playlist.mostrarAlReves();
                    break;

                case 5:
                    System.out.print("Titulo a buscar: ");
                    playlist.buscarCancion(pasarTxto.nextLine());
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        pasarTxto.close();
        pasarNumeros.close();
    }
}