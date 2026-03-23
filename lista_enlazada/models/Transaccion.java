package lista_enlazada.models;

public class Transaccion {

    private Long idTransaccion;
    private double value;
    private String numCuentaSalida;
    private String numCuentaLlegada;
    
    public Transaccion() {
    }
    
    public Transaccion(Long idTransaccion , double value, String numCuentaSalida, String numCuentaLlegada) {
        this.idTransaccion = idTransaccion;
        this.value = value;
        this.numCuentaSalida = numCuentaSalida;
        this.numCuentaLlegada = numCuentaLlegada;
    }
    

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNumCuentaSalida() {
        return numCuentaSalida;
    }

    public void setNumCuentaSalida(String numCuentaSalida) {
        this.numCuentaSalida = numCuentaSalida;
    }

    public String getNumCuentaLlegada() {
        return numCuentaLlegada;
    }

    public void setNumCuentaLlegada(String numCuentaLlegada) {
        this.numCuentaLlegada = numCuentaLlegada;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public String toString() {
        return "(idTransaccion: " + idTransaccion + ", value: " + value + ", numCuentaSalida: "
                + numCuentaSalida + ", numCuentaLlegada: " + numCuentaLlegada + ")";
    }


}
