package lista_enlazada.models;

public class Transaction {
    private int id;
    private String type;
    private double amount;
    private String description;

    // Constructor
    public Transaction(int id, String type, double amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescripcion(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tipo: " + type +
                ", Monto: $" + amount +
                ", Descripción: " + description;
    }
}
