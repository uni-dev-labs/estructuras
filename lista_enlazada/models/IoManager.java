package lista_enlazada.models;

import java.util.Scanner;

public class IoManager {
    private Scanner scanner;

    public IoManager() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String message) {
        printMessage(message);
        int inputValue = Integer.parseInt(scanner.nextLine());
        return inputValue;
    }

    public String readString(String message) {
        printMessage(message);
        String inputValue = scanner.nextLine();
        return inputValue;
    }

    public double readDouble(String message) {
        printMessage(message);
        double inputValue = Double.parseDouble(scanner.nextLine());
        return inputValue;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
