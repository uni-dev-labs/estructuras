package lista_enlazada.models;

public class Transaccion {

    private Long id;
    private double valor;
    private String cuentaOrigen;
    private String cuentaDestino;

    
    public Transaccion(Long id, double valor, String cuentaOrigen, String cuentaDestino) {
        this.id = id;
        this.valor = valor;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }


    public String getCuentaOrigen() {
        return cuentaOrigen;
    }


    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }


    public String getCuentaDestino() {
        return cuentaDestino;
    }


    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    


    @Override
    public String toString() {
        return "Transaccion [id=" + id + ", valor=" + valor + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino="
                + cuentaDestino + "]";
    }

    
}