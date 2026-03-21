package arraylist.models;

public class Aereo extends Transporte {

    private String tipo;

    public Aereo(String nombre, String medio, String tipo, int capacidad) {
        super(nombre, medio, capacidad);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}