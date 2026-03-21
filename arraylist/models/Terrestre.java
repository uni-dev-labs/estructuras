package arraylist.models;

public class Terrestre extends Transporte {

    private int ruedas;
    private String tipo;

    public Terrestre(String nombre, String medio, String tipo, int capacidad, int ruedas) {
        super(nombre, medio, capacidad);
        this.tipo = tipo;
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Ruedas: " + ruedas;
    }
}