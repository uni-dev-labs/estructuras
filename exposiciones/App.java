// =======================
// File: App.java
// =======================

package exposiciones;

import exposiciones.entities.BinaryTree;
import exposiciones.entities.Console;
import exposiciones.logic.Automaton;

public class App {

    public static void main(String[] args) {

        Console console = new Console();

        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        Automaton automaton = new Automaton();

        int option;

        do {

            console.showMessage("\n===== MAIN MENU =====");
            console.showMessage("1. Show PreOrder");
            console.showMessage("2. Show InOrder");
            console.showMessage("3. Show PostOrder");
            console.showMessage("4. Evaluate Binary String");
            console.showMessage("5. Exit");
            console.showMessage("Choose an option:");

            option = console.readInt();

            switch (option) {

                case 1:

                    console.showMessage("\nPREORDER:");
                    tree.preOrder();
                    System.out.println();

                    break;

                case 2:

                    console.showMessage("\nINORDER:");
                    tree.inOrder();
                    System.out.println();

                    break;

                case 3:

                    console.showMessage("\nPOSTORDER:");
                    tree.postOrder();
                    System.out.println();

                    break;

                case 4:

                    try {

                        char[] binary = console.readBinaryString();

                        boolean result = automaton.evaluateString(binary);

                        console.showMessage("Accepted: " + result);

                    } catch (Exception e) {

                        console.showMessage("Error: " + e.getMessage());
                    }

                    break;

                case 5:

                    console.showMessage("\nProgram finished.");

                    break;

                default:

                    console.showMessage("\nInvalid option.");
            }

        } while (option != 5);

        console.closeScanner();
    }
}