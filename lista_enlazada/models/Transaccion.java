package lista_enlazada.models;


public class Transaccion {
    public int id;
    public String descripcion;
    public double monto;

    public Transaccion(int id, String descripcion, double monto) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Desc: " + descripcion + " | Monto: " + monto;
    }
}