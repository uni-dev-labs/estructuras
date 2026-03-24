package lista_enlazada.models;

import java.util.Scanner;

public class Menu {
    private IoManager ioManager;
    private TransactionLinkedList transactionLinkedList;

    public Menu() {
        this.ioManager = new IoManager();
        this.transactionLinkedList = new TransactionLinkedList();
    }

    public void runMenu(String[] args) {
        int option = 0;

        do {
            showMenu();
            option = this.ioManager.readInt("Select an option: ");

            switch (option) {
                case 1:
                    insertAtStart();
                    break;
                case 2:
                    insertAtEnd();
                    break;
                case 3:
                    insertAtPosition();
                    break;
                case 4:
                    deleteById();
                    break;
                case 5:
                    deleteByIndex();
                    break;
                case 6:
                    clearList();
                    break;
                case 7:
                    searchById();
                    break;
                case 8:
                    checkIfContainsId();
                    break;
                case 9:
                    getByIndex();
                    break;
                case 10:
                    checkIfEmpty();
                    break;
                case 11:
                    showSize();
                    break;
                case 12:
                    printList();
                    break;
                case 0:
                    ioManager.printMessage("Exiting program...");
                    break;
                default:
                    ioManager.printMessage("Invalid option.");
                    break;
            }

        } while (option != 0);
    }

    private void insertAtStart() {
        transactionLinkedList.insertarAtStart(readTransaction());
        ioManager.printMessage("Transaction inserted at start.");
    }

    private void insertAtEnd() {
        transactionLinkedList.insertarAlFinal(readTransaction());
        ioManager.printMessage("Transaction inserted at end.");
    }

    private void insertAtPosition() {
        Transaction transaction = readTransaction();
        int position = ioManager.readInt("Enter position: ");

        try {
            transactionLinkedList.insertarEnPosicion(transaction, position);
            ioManager.printMessage("Transaction inserted at position " + position);
        } catch (IndexOutOfBoundsException e) {
            ioManager.printMessage(e.getMessage());
        }
    }

    private void deleteById() {
        int id = ioManager.readInt("Enter ID to delete: ");
        transactionLinkedList.deleteById(id);
        ioManager.printMessage("Delete by ID operation executed.");
    }

    private void deleteByIndex() {
        int index = ioManager.readInt("Enter position to delete: ");

        try {
            transactionLinkedList.deleteByIndex(index);
            ioManager.printMessage("Transaction deleted at position " + index);
        } catch (IndexOutOfBoundsException e) {
            ioManager.printMessage(e.getMessage());
        }
    }

    private void clearList() {
        transactionLinkedList.clean();
        ioManager.printMessage("List cleared successfully.");
    }

    private void searchById() {
        int id = ioManager.readInt("Enter ID to search: ");
        int position = transactionLinkedList.searchById(id);

        if (position != -1) {
            ioManager.printMessage("Transaction found at position: " + position);
        } else {
            ioManager.printMessage("No transaction found with that ID.");
        }
    }

    private void checkIfContainsId() {
        int id = ioManager.readInt("Enter ID to validate: ");
        boolean exists = transactionLinkedList.containsId(id);
        ioManager.printMessage("Does the list contain that ID? " + exists);
    }

    private void getByIndex() {
        int index = ioManager.readInt("Enter position to retrieve: ");

        try {
            Transaction t = transactionLinkedList.obtenerEnPosicion(index);
            ioManager.printMessage("Transaction found: " + t);
        } catch (IndexOutOfBoundsException e) {
            ioManager.printMessage(e.getMessage());
        }
    }

    private void checkIfEmpty() {
        ioManager.printMessage("Is the list empty? " + transactionLinkedList.isEmpty());
    }

    private void showSize() {
        ioManager.printMessage("List size: " + transactionLinkedList.size());
    }

    private void printList() {
        transactionLinkedList.printLinkedList();
    }

    public void showMenu() {
        ioManager.printMessage("\n===== TRANSACTION LINKED LIST MENU =====");
        ioManager.printMessage("1. Insert transaction at start");
        ioManager.printMessage("2. Insert transaction at end");
        ioManager.printMessage("3. Insert transaction at position");
        ioManager.printMessage("4. Delete transaction by ID");
        ioManager.printMessage("5. Delete transaction by position");
        ioManager.printMessage("6. Clear list");
        ioManager.printMessage("7. Search transaction by ID");
        ioManager.printMessage("8. Check if contains ID");
        ioManager.printMessage("9. Get transaction by position");
        ioManager.printMessage("10. Check if list is empty");
        ioManager.printMessage("11. Get list size");
        ioManager.printMessage("12. Print list");
        ioManager.printMessage("0. Exit");
    }

    public Transaction readTransaction() {
        int id = ioManager.readInt("Enter ID: ");
        String type = ioManager.readString("Enter account type: ");
        double amount = ioManager.readDouble("Enter amount: ");
        String description = ioManager.readString("Enter description: ");

        return new Transaction(id, type, amount, description);
    }

}
