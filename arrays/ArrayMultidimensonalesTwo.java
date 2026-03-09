package arrays;

import java.util.Scanner;

/**
 * Matriz de cualquier número de filas y columnas donde la diagonal son unos
 * y el resto son ceros.
 */
public class ArrayMultidimensonalesTwo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt();

        int[][] matriz = crearMatrizDiagonal(filas, columnas);
        System.out.println("\nMatriz resultante:");
        imprimirMatriz(matriz);

        sc.close();
    }

    /**
     * Crea una matriz donde la diagonal principal tiene unos y el resto ceros.
     */
    public static int[][] crearMatrizDiagonal(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        // La diagonal va hasta el mínimo entre filas y columnas
        int longitudDiagonal = Math.min(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j && i < longitudDiagonal) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
