package arraylist.models;

public class Maritimo extends Transporte {

    private String tipo;

    public Maritimo(String nombre, String medio, String tipo, int capacidad) {
        super(nombre, medio, capacidad);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}