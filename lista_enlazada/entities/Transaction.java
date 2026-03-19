package lista_enlazada.entities;

public class Transaction {

    private double amount;
    private String accountNumber;

    public Transaction() {
    }

    public Transaction(double amount, String accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNumCuenta() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Transaction [" + " Acount Number: " + accountNumber + ", amount: " + amount + "]";
    }

}
