package exercises.grafos;

public class Transicion {
    private char conecxion;
    private Estado Estado;

    public char getConecxion() {
        return conecxion;
    }
    public void setConecxion(char conecxion) {
        this.conecxion = conecxion;
    }
    
    public Estado getEstado() {
        return Estado;
    }
    
    public void setEstado(Estado estado) {
        Estado = estado;
    }
    
    public Transicion(char conecxion, Estado estado) {
        this.conecxion = conecxion;
        Estado = estado;
    }
}
