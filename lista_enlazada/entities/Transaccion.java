package lista_enlazada.entities;

public class Transaccion {
    private double monto;
    private String numCuenta;
    @Override
    public String toString() {
        return "Transaccion [ numCuenta=" + numCuenta +" monto=" + monto + "]";
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    public Transaccion() {}
    public Transaccion(double monto, String numCuenta) {
        this.monto = monto;
        this.numCuenta = numCuenta;
    }
}
