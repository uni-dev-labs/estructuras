package arrays;

/**
 * DESCRIPCIÓN DEL PROBLEMA:
 * Necesito crear un programa que me añada 10 elementos en un arreglo estático,
 * los modifique (por ejemplo multiplicando por 2) y los imprima; 
 * 
 * 
 * Necesito crear un programa que se cargan los elementos uno a uno (A–J) y se imprimen.
 * Así practico declaración con elementos cargados y declaración con tamaño sin cargar.
 */
public class ArrayStatics {
	public static void main(String[] args) {
		ArrayWithSizeElementsLoaded();
    System.out.println("--------------------------------");
    ArrayWithSizeElementsNotLoaded();
	}

	public static void ArrayWithSizeElementsLoaded() {
		// Arreglo estático de 10 elementos
		int numbers[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int element = 0; element < numbers.length; element++) {
			numbers[element] = element * 2;
			System.out.println("numbers[" + element + "]: " + numbers[element]);
		}
	}


  public static void ArrayWithSizeElementsNotLoaded() {
    char numbers[] = new char[10];
    
    numbers[0] = 'A';
    numbers[1] = 'B';
    numbers[2] = 'C';
    numbers[3] = 'D';
    numbers[4] = 'E';
    numbers[5] = 'F';
    numbers[6] = 'G';
    numbers[7] = 'H';
    numbers[8] = 'I';
    numbers[9] = 'J';
    // numbers[10] = 'K'; // Error: ArrayIndexOutOfBoundsException

    for (int element = 0; element < numbers.length; element++) {
      System.out.println("numbers[" + element + "]: " + numbers[element]);
    }
  }


}


