package lista_enlazada;

public class Transaccion {   

    private static int contador = 1; // 🔥 genera IDs automáticos
    private int id;

    private double monto;
    private String descripcion;
    private String fecha;

    public Transaccion(double monto, String descripcion, String fecha) {
        this.id = contador++; // 🔥 asigna ID automático
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
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
        return "[ID:" + id + "] [$" + monto + " | " + descripcion + " (" + fecha + ")]";
    }
}