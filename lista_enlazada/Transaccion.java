package lista_enlazada;

public class Transaccion {
    int id;
    String tipo;
    double monto;

    public Transaccion(int id, String tipo, double monto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
    }

    public void mostrar() {
        System.out.println("ID: " + id + " Tipo: " + tipo + " Monto: " + monto);
    }
}
