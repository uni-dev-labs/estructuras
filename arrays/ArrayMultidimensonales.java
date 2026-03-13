package arrays;

/**
 * DESCRIPCIÓN DEL PROBLEMA:
 * Necesito crear un programa que trabaje con una matriz (arreglo bidimensional) de 3x3:
 * mostrarla vacía, llenarla pidiendo cada valor por consola al usuario y volver a imprimirla.
 */

public class ArrayMultidimensonales {
    public static void main(String[] args) {
        int matriz[][] = new int[3][3];

        printMatrix(matriz);
        System.out.println("--------------------------------");
        fillMatrix(matriz);
        System.out.println("--------------------------------");
        printMatrix(matriz);
    }

    public static void fillMatrix(int matriz[][]) {
        for (int row = 0; row < matriz.length; row++) {
            for (int column = 0; column < matriz[row].length; column++) {
                System.out.println("Ingrese el valor para la posición [" + row + "][" + column + "]: ");
                matriz[row][column] = Integer.parseInt(System.console().readLine());
            }
        }
    }

    public static void printMatrix(int matriz[][]) {
        for (int rows = 0; rows < matriz.length; rows++) {
            for (int column = 0; column < matriz[rows].length; column++) {
                System.out.print(matriz[rows][column] + " ");
            }
            System.out.println();
        }
    }
}
