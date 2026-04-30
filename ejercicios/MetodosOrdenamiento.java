package ejercicios;

import java.util.Scanner;

public class MetodosOrdenamiento {

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minimo]) {
                    minimo = j;
                }
            }
            // Intercambio
            int temp = array[i];
            array[i] = array[minimo];
            array[minimo] = temp;
        }
    }

    public static void imprimirArreglo(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el tamaño de la lista: ");
        int size = sc.nextInt();

        System.out.println("Ingresa los elementos de la lista: ");
        int[] lista = new int[size];
        for (int i = 0; i < size; i++) {
            lista[i] = sc.nextInt();
        }

        System.out.println("Lista original: ");
        imprimirArreglo(lista);

        System.out.println("\nLista ordenada");
        selectionSort(lista);
        imprimirArreglo(lista);

        sc.close();
    }
}
