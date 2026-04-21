package lista_enlazada;

public class Transaccion {
    private int id;
    private String tipo;
    private double monto;
    private String detalle; // campo adicional para diferenciar

    public Transaccion(int id, String tipo, double monto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.detalle = "Sin descripción"; // valor por defecto
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public String getDetalle() { return detalle; }

    public void setId(int id) { this.id = id; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setMonto(double monto) { this.monto = monto; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    @Override
    public String toString() {
        return "Transaccion [id=" + id + ", tipo=" + tipo + ", monto=" + monto + ", detalle=" + detalle + "]";
    }
}