// =======================
// File: Console.java
// =======================

package exposiciones.entities;

import java.util.Scanner;

public class Console {

    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public char[] readBinaryString() {

        System.out.print("Enter a binary string: ");

        return scanner.next().toCharArray();
    }

    public void closeScanner() {
        scanner.close();
    }
}