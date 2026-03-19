package lista_enlazada;

public class Transaccion {
    private double monto;
    private String descripcion;
    private String fecha;

    public Transaccion(double monto, String descripcion, String fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "[$" + monto + " | " + descripcion + " (" + fecha + ")]";
    }
}