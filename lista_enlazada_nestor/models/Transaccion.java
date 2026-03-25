package lista_enlazada_nestor.models;

public class Transaccion {

    public int id;
    public double monto;

    public Transaccion(int id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public void mostrar() {
        System.out.println("ID: " + id + " Monto: " + monto);
    }
}